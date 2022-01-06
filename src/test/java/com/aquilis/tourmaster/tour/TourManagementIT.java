package com.aquilis.tourmaster.tour;

import com.aquilis.tourmaster.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Testcontainers
class TourManagementIT extends AbstractIntegrationTest {

	@Test
	@WithMockUser(username = "usr_admin", roles = {"admin"})
	public void should_Create_Tour() throws Exception {
		Tour tour = Tour.builder().name("Test tour name").description("Test tour").destination("Barcelona")
				.currency("EUR").priceAdult(600).build();
		MvcResult result = doPost("/api/tours", tour);
		Long createdId = Long.valueOf(result.getResponse().getContentAsString());

		MvcResult retrievedResult = doGet("/api/tours/" + createdId);
		Tour retrievedTour = new ObjectMapper().readValue(retrievedResult.getResponse().getContentAsString(), Tour.class);
		assertNotNull(retrievedTour);
		retrievedTour.setId(null);
		assertEquals(tour, retrievedTour);
	}
}
