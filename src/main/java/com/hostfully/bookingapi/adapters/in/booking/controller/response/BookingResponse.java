package com.hostfully.bookingapi.adapters.in.booking.controller.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingResponse {

    private Integer id;

    private LocalDate startPeriod;

    private LocalDate endPeriod;

    private String guestFirstName;

    private String guestLastName;

    private Integer guestDocumentId;

    private Integer propertyId;
}
