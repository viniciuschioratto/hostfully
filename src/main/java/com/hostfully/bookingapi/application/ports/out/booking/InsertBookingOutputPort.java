package com.hostfully.bookingapi.application.ports.out.booking;

import com.hostfully.bookingapi.application.core.domain.Booking;

public interface InsertBookingOutputPort {

    Booking insert(Booking booking);
}
