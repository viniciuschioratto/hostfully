package com.hostfully.bookingapi.adapters.out.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_seq")
    @SequenceGenerator(name = "generator_seq", sequenceName = "block_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "start_period")
    private LocalDate startPeriod;

    @Column(name = "end_period")
    private LocalDate endPeriod;

    @Column(name = "guest_first_name")
    private String guestFirstName;

    @Column(name = "guest_last_name")
    private String guestLastName;

    @Column(name = "guest_document_id")
    private Integer guestDocumentId;

    @Column(name = "property_id")
    private Integer propertyId;
}
