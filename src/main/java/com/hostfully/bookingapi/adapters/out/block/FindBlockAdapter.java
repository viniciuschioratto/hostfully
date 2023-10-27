package com.hostfully.bookingapi.adapters.out.block;

import com.hostfully.bookingapi.adapters.out.block.mapper.BlockMapperOut;
import com.hostfully.bookingapi.adapters.out.block.repository.BlockRepository;
import com.hostfully.bookingapi.adapters.out.block.repository.entity.BlockEntity;
import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.out.block.FindBlockOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class FindBlockAdapter implements FindBlockOutputPort {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private BlockMapperOut blockMapperOut;

    @Override
    public Optional<Block> findById(String id) throws Exception {
        Optional<BlockEntity> block = blockRepository.findById(Integer.valueOf(id));

        return blockMapperOut.toBlock(block);

    }

    @Override
    public List<Block> findBlockByPropertyBetweenDate(Integer propertyId, LocalDate startBookingPeriod, LocalDate endBookingPeriod) {
        List<BlockEntity> blockEntityList = blockRepository.findAllByPropertyIdAndBetweenDate(propertyId, startBookingPeriod, endBookingPeriod);

        return blockMapperOut.toBlockList(blockEntityList);
    }
}
