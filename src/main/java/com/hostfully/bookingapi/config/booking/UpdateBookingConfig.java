package com.hostfully.bookingapi.config.booking;

import com.hostfully.bookingapi.adapters.out.block.FindBlockAdapter;
import com.hostfully.bookingapi.adapters.out.booking.FindBookingAdapter;
import com.hostfully.bookingapi.adapters.out.booking.InsertBookingAdapter;
import com.hostfully.bookingapi.adapters.out.booking.UpdateBookingAdapter;
import com.hostfully.bookingapi.application.core.usecase.booking.InsertBookingUseCase;
import com.hostfully.bookingapi.application.core.usecase.booking.UpdateBookingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateBookingConfig {

    @Bean
    public UpdateBookingUseCase updateBookingUseCase(FindBookingAdapter findBookingAdapter, UpdateBookingAdapter updateBookingAdapter, FindBlockAdapter findBlockAdapter) {
        return new UpdateBookingUseCase(findBookingAdapter, updateBookingAdapter, findBlockAdapter);
    }
}
