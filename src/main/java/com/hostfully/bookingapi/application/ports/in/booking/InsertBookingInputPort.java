package com.hostfully.bookingapi.application.ports.in.booking;

import com.hostfully.bookingapi.application.core.domain.Booking;

public interface InsertBookingInputPort {

    Booking insert(Booking booking) throws Exception;
}
