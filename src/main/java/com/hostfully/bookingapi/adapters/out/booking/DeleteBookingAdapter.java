package com.hostfully.bookingapi.adapters.out.booking;

import com.hostfully.bookingapi.adapters.out.booking.repository.BookingRepository;
import com.hostfully.bookingapi.application.ports.out.booking.DeleteBookingOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookingAdapter implements DeleteBookingOutputPort {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void deleteById(String id) {
        bookingRepository.deleteById(Integer.valueOf(id));
    }
}
