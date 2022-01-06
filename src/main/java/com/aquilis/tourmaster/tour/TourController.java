package com.aquilis.tourmaster.tour;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private TourRepository tourRepository;

    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @RolesAllowed({"admin", "tour_creator"})
    @PostMapping
    public ResponseEntity createTour(@RequestBody Tour tour) {
        TourEntity tourEntity = new TourEntity();
        BeanUtils.copyProperties(tour, tourEntity);
        TourEntity saved = tourRepository.save(tourEntity);
        return ResponseEntity.ok(saved.getId());
    }

    @RolesAllowed({"admin", "tour_creator", "regular_user"})
    @GetMapping
    public List<Tour> getAllTours() {
        return tourRepository.findAll().stream().map(tourEntity -> {
            Tour tour = new Tour();
            BeanUtils.copyProperties(tourEntity, tour);
            return tour;
        }).collect(Collectors.toList());
    }

    @RolesAllowed({"admin", "tour_creator", "regular_user"})
    @GetMapping("/{tourId}")
    public ResponseEntity getTour(@PathVariable Long tourId) {
        Tour tour = new Tour();
        TourEntity tourEntity = tourRepository.findById(tourId).orElse(null);
        if (tourEntity == null) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(tourEntity, tour);
        return ResponseEntity.of(Optional.ofNullable(tour));
    }
}
