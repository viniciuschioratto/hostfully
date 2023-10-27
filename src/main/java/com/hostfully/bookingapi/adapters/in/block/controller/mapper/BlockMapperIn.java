package com.hostfully.bookingapi.adapters.in.block.controller.mapper;

import com.hostfully.bookingapi.adapters.in.block.controller.request.BlockRequest;
import com.hostfully.bookingapi.adapters.in.block.controller.response.BlockResponse;
import com.hostfully.bookingapi.application.core.domain.Block;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlockMapperIn {

    @Mapping(target = "id", ignore = true)
    Block toBlock(BlockRequest blockRequest);

    BlockResponse toBlockResponse(Block block);
}
