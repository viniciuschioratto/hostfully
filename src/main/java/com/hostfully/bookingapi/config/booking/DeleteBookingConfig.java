package com.hostfully.bookingapi.config.booking;

import com.hostfully.bookingapi.adapters.out.block.FindBlockAdapter;
import com.hostfully.bookingapi.adapters.out.booking.DeleteBookingAdapter;
import com.hostfully.bookingapi.adapters.out.booking.FindBookingAdapter;
import com.hostfully.bookingapi.adapters.out.booking.InsertBookingAdapter;
import com.hostfully.bookingapi.application.core.usecase.booking.DeleteBookingUseCase;
import com.hostfully.bookingapi.application.core.usecase.booking.InsertBookingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteBookingConfig {

    @Bean
    public DeleteBookingUseCase deleteBookingUseCase(DeleteBookingAdapter deleteBookingAdapter, FindBookingAdapter findBookingAdapter) {
        return new DeleteBookingUseCase(deleteBookingAdapter, findBookingAdapter);
    }
}
