package com.aquilis.tourmaster.tour;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Tour {
    private Long id;
    private String name;
    private String destination;
    private String description;
    private int durationHrs;
    private String transportType;
    private int tollTaxes;
    private double priceAdult;
    private double priceChild;
    private String currency;
    private Date expectedTimeBackAtOrigin;
    private String documentsNeeded;
    private String contacts;
}
