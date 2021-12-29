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
import java.util.Optional;

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
    @ApiOperation("Inserta una Especialidad")
    @ApiResponses({
            @ApiResponse(code = 201 , message = "CREATED"),
            @ApiResponse(code = 400 , message = "BAD REQUEST YA SE REGISTRO ESTE NOMBRE DE ESPECIALIDAD")
    })
    public ResponseEntity save( @RequestBody Specialty specialty) {
        if(specialtyService.getSpecialtyByName(specialty.getName()).isPresent()){
            return new ResponseEntity<String>("YA SE REGISTRO", HttpStatus.BAD_REQUEST);
        }
        specialty.setDateCreated(LocalDateTime.now());
        return new ResponseEntity<Specialty>(specialtyService.save(specialty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Specialty")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 400 , message = "BAD REQUEST YA SE REGISTRO ESTE NOMBRE DE ESPECIALIDAD")
    })
    public ResponseEntity update( @RequestBody Specialty specialty, @ApiParam(value = "id of the Specialty" , required = true, example = "12") @PathVariable("id") Integer id) {
        if( !specialtyService.getSpecialty(id).isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(specialty.getUserUpdated().isEmpty())
            return new ResponseEntity<String>("userCreated required", HttpStatus.BAD_REQUEST);
        if(specialty.getName().isEmpty())
            return new ResponseEntity<String>("name required", HttpStatus.BAD_REQUEST);

        Optional<Specialty> specialtyBD = specialtyService.getSpecialtyByName(specialty.getName());
        if(specialtyBD.isPresent()){
            if(specialtyBD.get().getId() == id) {
                Specialty specialtyObj = specialtyService.getSpecialty(id).get();
                specialtyObj.setName(specialty.getName());
                specialtyObj.setUserUpdated(specialty.getUserUpdated());
                specialtyObj.setDateUpdated(LocalDateTime.now());
                return new ResponseEntity<Specialty>(specialtyService.save(specialtyObj), HttpStatus.OK);
            }
            return new ResponseEntity<String>("YA SE REGISTRO", HttpStatus.BAD_REQUEST);
        }
        Specialty specialtyObj = specialtyService.getSpecialty(id).get();
        specialtyObj.setName(specialty.getName());
        specialtyObj.setUserUpdated(specialty.getUserUpdated());
        specialtyObj.setDateUpdated(LocalDateTime.now());
        return new ResponseEntity<Specialty>(specialtyService.save(specialtyObj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return specialtyService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
