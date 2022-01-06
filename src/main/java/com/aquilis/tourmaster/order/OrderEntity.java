package com.aquilis.tourmaster.order;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long tourId;
    private ZonedDateTime orderTime;
    private ZonedDateTime updatedAt;
    private int countAdults;
    private int countChildren;
    private ZonedDateTime pickupTime;
    private String pickupAddress;
    private String pickupCoordinates;
    private String hotelName;
    private String contactPersonName;
    private String contactPersonPhone;
    private String paymentMethod;
    private String voucherId;

    @PrePersist
    void prePersist() {
        this.orderTime = ZonedDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }
}
