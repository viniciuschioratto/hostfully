package com.hostfully.bookingapi.adapters.out.booking;

import com.hostfully.bookingapi.adapters.out.booking.entity.BookingEntity;
import com.hostfully.bookingapi.adapters.out.booking.mapper.BookingMapperOut;
import com.hostfully.bookingapi.adapters.out.booking.repository.BookingRepository;
import com.hostfully.bookingapi.application.core.domain.Booking;
import com.hostfully.bookingapi.application.ports.out.booking.UpdateBookingOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateBookingAdapter implements UpdateBookingOutputPort {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapperOut bookingMapperOut;

    @Override
    public Booking update(Booking booking) {
        BookingEntity bookingEntity = bookingMapperOut.toBookingEntityWithId(booking);

        return bookingMapperOut.toBooking(bookingRepository.saveAndFlush(bookingEntity));
    }
}
