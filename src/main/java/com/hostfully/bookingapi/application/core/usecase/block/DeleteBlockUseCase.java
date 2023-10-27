package com.hostfully.bookingapi.application.core.usecase.block;

import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.in.block.DeleteBlockInputPort;
import com.hostfully.bookingapi.application.ports.out.block.DeleteBlockOutputPort;
import com.hostfully.bookingapi.application.ports.out.block.FindBlockOutputPort;

import java.util.Optional;

public class DeleteBlockUseCase implements DeleteBlockInputPort {

    private final FindBlockOutputPort findBlockOutputPort;

    private final DeleteBlockOutputPort deleteBlockOutputPort;

    public DeleteBlockUseCase(FindBlockOutputPort findBlockOutputPort, DeleteBlockOutputPort deleteBlockOutputPort) {
        this.findBlockOutputPort = findBlockOutputPort;
        this.deleteBlockOutputPort = deleteBlockOutputPort;
    }

    @Override
    public void deleteById(String id) throws Exception {
        Optional<Block> block = findBlockOutputPort.findById(id);

        if (block.isEmpty()) {
            throw new Exception("Block does not exist");
        }

        deleteBlockOutputPort.deleteById(id);

    }
}
