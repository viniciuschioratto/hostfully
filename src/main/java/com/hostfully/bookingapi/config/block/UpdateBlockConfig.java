package com.hostfully.bookingapi.config.block;

import com.hostfully.bookingapi.adapters.out.block.FindBlockAdapter;
import com.hostfully.bookingapi.adapters.out.block.UpdateBlockAdapter;
import com.hostfully.bookingapi.application.core.usecase.block.UpdateBlockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateBlockConfig {

    @Bean
    public UpdateBlockUseCase updateBlockUseCase(FindBlockAdapter findBlockAdapter, UpdateBlockAdapter updateBlockAdapter) {
        return new UpdateBlockUseCase(findBlockAdapter, updateBlockAdapter);
    }
}
