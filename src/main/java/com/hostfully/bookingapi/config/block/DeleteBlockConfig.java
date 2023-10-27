package com.hostfully.bookingapi.config.block;

import com.hostfully.bookingapi.adapters.out.block.DeleteBlockAdapter;
import com.hostfully.bookingapi.adapters.out.block.FindBlockAdapter;
import com.hostfully.bookingapi.application.core.usecase.block.DeleteBlockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteBlockConfig {

    @Bean
    public DeleteBlockUseCase deleteBlockUseCase(FindBlockAdapter findBlockAdapter, DeleteBlockAdapter deleteBlockAdapter) {
        return new DeleteBlockUseCase(findBlockAdapter, deleteBlockAdapter);
    }
}
