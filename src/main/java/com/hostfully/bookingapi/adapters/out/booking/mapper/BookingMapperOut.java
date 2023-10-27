package com.hostfully.bookingapi.adapters.out.booking.mapper;

import com.hostfully.bookingapi.adapters.out.booking.entity.BookingEntity;
import com.hostfully.bookingapi.application.core.domain.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookingMapperOut {

    @Mapping(target = "id", ignore = true)
    BookingEntity toBookingEntity(Booking booking);

    BookingEntity toBookingEntityWithId(Booking booking);

    Booking toBooking(BookingEntity bookingEntity);

    default Optional<Booking> toBooking(Optional<BookingEntity> optionalBookingEntity) {
        return optionalBookingEntity.map(this::toBooking);
    }

    List<Booking> toBookingList(List<BookingEntity> bookingEntityList);
}
