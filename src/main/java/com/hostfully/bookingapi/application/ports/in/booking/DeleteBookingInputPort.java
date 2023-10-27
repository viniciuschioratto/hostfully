package com.hostfully.bookingapi.application.ports.in.booking;

public interface DeleteBookingInputPort {

    void deleteById(String id) throws Exception;
}
