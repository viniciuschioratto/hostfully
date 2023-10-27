package com.hostfully.bookingapi.adapters.in.booking.controller.mapper;

import com.hostfully.bookingapi.adapters.in.booking.controller.request.BookingRequest;
import com.hostfully.bookingapi.adapters.in.booking.controller.response.BookingResponse;
import com.hostfully.bookingapi.application.core.domain.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapperIn {

    @Mapping(target = "id", ignore = true)
    Booking toBooking(BookingRequest bookingRequest);

    BookingResponse toBookingResponse(Booking booking);
}
