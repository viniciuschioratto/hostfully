package com.hostfully.bookingapi.adapters.out.block.mapper;

import com.hostfully.bookingapi.adapters.out.block.repository.entity.BlockEntity;
import com.hostfully.bookingapi.adapters.out.booking.entity.BookingEntity;
import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.core.domain.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BlockMapperOut {

    Block toBlock(BlockEntity blockEntity);

    default Optional<Block> toBlock(Optional<BlockEntity> optionalBlock) {
        return optionalBlock.map(this::toBlock);
    }

    @Mapping(target = "id", ignore = true)
    BlockEntity toBlockEntity(Block block);

    BlockEntity toBlockEntityWithId(Block block);

    List<Block> toBlockList(List<BlockEntity> blockEntity);
}
