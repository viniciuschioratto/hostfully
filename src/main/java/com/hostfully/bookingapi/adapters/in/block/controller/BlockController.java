package com.hostfully.bookingapi.adapters.in.block.controller;

import com.hostfully.bookingapi.adapters.in.block.controller.mapper.BlockMapperIn;
import com.hostfully.bookingapi.adapters.in.block.controller.request.BlockRequest;
import com.hostfully.bookingapi.adapters.in.block.controller.response.BlockResponse;
import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.in.block.DeleteBlockInputPort;
import com.hostfully.bookingapi.application.ports.in.block.InsertBlockInputPort;
import com.hostfully.bookingapi.application.ports.in.block.UpdateBlockInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private DeleteBlockInputPort deleteBlockInputPort;

    @Autowired
    private InsertBlockInputPort insertBlockInputPort;

    @Autowired
    private UpdateBlockInputPort updateBlockInputPort;

    @Autowired
    private BlockMapperIn blockMapperIn;


    @Operation(summary = "Create a new Block")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Block created with success.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BlockRequest.class
                            )
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Error to create a new Block.", content = @Content),
    })
    @PostMapping
    public ResponseEntity<BlockResponse> insert(@Valid @RequestBody BlockRequest blockRequest) {

        Block block = insertBlockInputPort.insert(blockMapperIn.toBlock(blockRequest));

        return ResponseEntity.ok().body(blockMapperIn.toBlockResponse(block));

    }

    @Operation(summary = "Update a Block")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Block updated with success.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BlockRequest.class
                            )
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Error to update a Block.", content = @Content),
    })
    @PutMapping("/{id}")
    public ResponseEntity<BlockResponse> update(@PathVariable final String id, @Valid @RequestBody BlockRequest blockRequest) throws Exception {

        Block block = updateBlockInputPort.update(id, blockMapperIn.toBlock(blockRequest));

        return ResponseEntity.ok().body(blockMapperIn.toBlockResponse(block));
    }

    @Operation(summary = "Delete a Block")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Block deleted with success."),
            @ApiResponse(responseCode = "400", description = "Error to delete a Block."),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) throws Exception {

        deleteBlockInputPort.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
