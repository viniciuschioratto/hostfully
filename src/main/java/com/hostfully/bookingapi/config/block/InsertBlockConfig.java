package com.hostfully.bookingapi.config.block;

import com.hostfully.bookingapi.adapters.out.block.InsertBlockAdapter;
import com.hostfully.bookingapi.application.core.usecase.block.InsertBlockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertBlockConfig {

    @Bean
    public InsertBlockUseCase insertBlockUseCase(InsertBlockAdapter insertBlockAdapter) {
        return new InsertBlockUseCase(insertBlockAdapter);
    }
}
