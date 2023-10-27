package com.hostfully.bookingapi.adapters.in.block.controller.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BlockResponse {

    private Integer id;

    private LocalDate startPeriod;

    private LocalDate endPeriod;

    private Integer propertyId;
}
