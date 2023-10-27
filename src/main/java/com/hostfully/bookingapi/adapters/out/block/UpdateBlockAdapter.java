package com.hostfully.bookingapi.adapters.out.block;

import com.hostfully.bookingapi.adapters.out.block.mapper.BlockMapperOut;
import com.hostfully.bookingapi.adapters.out.block.repository.BlockRepository;
import com.hostfully.bookingapi.adapters.out.block.repository.entity.BlockEntity;
import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.out.block.UpdateBlockOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateBlockAdapter implements UpdateBlockOutputPort {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private BlockMapperOut blockMapperOut;

    @Override
    public Block update(Block block) {
        BlockEntity blockEntity = blockMapperOut.toBlockEntityWithId(block);

        return blockMapperOut.toBlock(blockRepository.saveAndFlush(blockEntity));
    }
}
