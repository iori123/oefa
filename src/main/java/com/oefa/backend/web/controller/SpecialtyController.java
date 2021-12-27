package com.oefa.backend.web.controller;

import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.service.SpecialtyService;
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
@RequestMapping("/specialties")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping
    @ApiOperation("Get all list of Specialties")
    @ApiResponse(code = 200 , message = "OK")
    public ResponseEntity<List<Specialty>>  getAll() {
        return new ResponseEntity<>(specialtyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search Specialty with an ID")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 404 , message = "Specialty not found")
    })
    public ResponseEntity<Specialty> getSpecialty( @ApiParam(value = "id of the Specialty" , required = true, example = "12") @PathVariable("id") Integer id) {
        return specialtyService.getSpecialty(id)
                .map(specialty -> new ResponseEntity<>(specialty, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Specialty> save( @RequestBody Specialty specialty) {
        specialty.setDateCreated(LocalDateTime.now());
        return new ResponseEntity<>(specialtyService.save(specialty), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return specialtyService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
