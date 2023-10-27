package com.hostfully.bookingapi.adapters.out.block;

import com.hostfully.bookingapi.adapters.out.block.repository.BlockRepository;
import com.hostfully.bookingapi.application.ports.out.block.DeleteBlockOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteBlockAdapter implements DeleteBlockOutputPort {

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public void deleteById(String id) {
        blockRepository.deleteById(Integer.valueOf(id));
    }
}
