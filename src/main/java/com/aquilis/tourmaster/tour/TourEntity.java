package com.aquilis.tourmaster.tour;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tours")
@Data
class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String destination;
    private String description;
    private int durationHrs;
    private String transportType;
    private int tollTaxes;
    private double priceAdult;
    private double priceChild;
    private String currency;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedTimeBackAtOrigin;
    private String documentsNeeded;
    private String contacts;
}
