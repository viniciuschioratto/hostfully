package com.hostfully.bookingapi.adapters.out.block;

import com.hostfully.bookingapi.adapters.out.block.mapper.BlockMapperOut;
import com.hostfully.bookingapi.adapters.out.block.repository.BlockRepository;
import com.hostfully.bookingapi.adapters.out.block.repository.entity.BlockEntity;
import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.out.block.InsertBlockOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertBlockAdapter implements InsertBlockOutputPort {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private BlockMapperOut blockMapperOut;

    @Override
    public Block insert(Block block) {
        BlockEntity blockEntity = blockMapperOut.toBlockEntity(block);

        return blockMapperOut.toBlock(blockRepository.saveAndFlush(blockEntity));
    }
}
