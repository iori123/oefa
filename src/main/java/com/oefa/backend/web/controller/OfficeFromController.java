package com.oefa.backend.web.controller;

import com.oefa.backend.domain.OfficeFrom;

import com.oefa.backend.domain.service.OfficeFromService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/office-from")
public class OfficeFromController {
    @Autowired
    private OfficeFromService officeFromService;

    @GetMapping
    @ApiOperation("Get all list of OfficeFrom")
    @ApiResponse(code = 200 , message = "OK")
    public ResponseEntity<List<OfficeFrom>> getAll() {
        return new ResponseEntity<>(officeFromService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search Office from with an ID")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 404 , message = "office not found")
    })
    public ResponseEntity<OfficeFrom> getOfficeFrom( @ApiParam(value = "id of the Office" , required = true, example = "18") @PathVariable("id") Integer id) {
        return officeFromService.getOfficeFrom(id)
                .map(officeFrom -> new ResponseEntity<>(officeFrom, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<OfficeFrom> save( @RequestBody OfficeFrom officeFrom) {
        officeFrom.setDateCreated(LocalDateTime.now());
        return new ResponseEntity<>(officeFromService.save(officeFrom), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return officeFromService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
