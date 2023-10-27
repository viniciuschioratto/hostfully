package com.hostfully.bookingapi.adapters.out.booking;

import com.hostfully.bookingapi.adapters.out.booking.entity.BookingEntity;
import com.hostfully.bookingapi.adapters.out.booking.mapper.BookingMapperOut;
import com.hostfully.bookingapi.adapters.out.booking.repository.BookingRepository;
import com.hostfully.bookingapi.application.core.domain.Booking;
import com.hostfully.bookingapi.application.ports.out.booking.FindBookingOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class FindBookingAdapter implements FindBookingOutputPort {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapperOut bookingMapperOut;

    @Override
    public List<Booking> findBookingByPropertyBetweenDate(Integer propertyId, LocalDate startBookingPeriod, LocalDate endBookingPeriod) {
        List<BookingEntity> bookingEntities = bookingRepository.findAllByPropertyIdAndBetweenDate(propertyId,startBookingPeriod,endBookingPeriod);

        return bookingMapperOut.toBookingList(bookingEntities);
    }

    @Override
    public Optional<Booking> findById(String id) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(Integer.valueOf(id));

        return bookingMapperOut.toBooking(bookingEntity);
    }
}
