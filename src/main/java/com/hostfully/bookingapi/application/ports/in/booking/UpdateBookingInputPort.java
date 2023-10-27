package com.hostfully.bookingapi.application.ports.in.booking;

import com.hostfully.bookingapi.application.core.domain.Booking;

public interface UpdateBookingInputPort {

    Booking update(String id, Booking booking) throws Exception;
}
