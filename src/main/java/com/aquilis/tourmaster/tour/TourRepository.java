package com.aquilis.tourmaster.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface TourRepository extends JpaRepository<TourEntity, Long> {
    List<TourEntity> findByNameContaining(@Param("name") String name);
    List<TourEntity> findByDescriptionContaining(@Param("description") String description);
}
