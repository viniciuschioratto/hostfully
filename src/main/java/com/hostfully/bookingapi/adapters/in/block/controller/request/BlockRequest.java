package com.hostfully.bookingapi.adapters.in.block.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BlockRequest {

    @NotNull
    private LocalDate startPeriod;

    @NotNull
    private LocalDate endPeriod;

    @NotNull
    private Integer propertyId;
}
