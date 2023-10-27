package com.hostfully.bookingapi.adapters.out.block.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "block")
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_seq")
    @SequenceGenerator(name = "generator_seq", sequenceName = "block_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "start_period")
    private LocalDate startPeriod;

    @Column(name = "end_period")
    private LocalDate endPeriod;

    @Column(name = "property_id")
    private Integer propertyId;
}
