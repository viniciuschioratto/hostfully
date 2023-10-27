package com.hostfully.bookingapi.adapters.in.booking.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    @NotNull
    private LocalDate startPeriod;

    @NotNull
    private LocalDate endPeriod;

    @NotBlank
    private String guestFirstName;

    @NotBlank
    private String guestLastName;

    @NotNull
    private Integer guestDocumentId;

    @NotNull
    private Integer propertyId;
}
