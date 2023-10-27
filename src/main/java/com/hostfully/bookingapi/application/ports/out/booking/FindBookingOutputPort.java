package com.hostfully.bookingapi.application.ports.out.booking;

import com.hostfully.bookingapi.application.core.domain.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FindBookingOutputPort {

    List<Booking> findBookingByPropertyBetweenDate(Integer propertyId, LocalDate startBookingPeriod, LocalDate endBookingPeriod);

    Optional<Booking> findById(String id);
}
