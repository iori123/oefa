package com.oefa.backend.web.controller;

import com.oefa.backend.domain.OfficeFrom;

import com.oefa.backend.domain.Specialty;
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
import java.util.Optional;

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
    @ApiOperation("Inserta una Oficina proveniente")
    @ApiResponses({
            @ApiResponse(code = 201 , message = "CREATED"),
            @ApiResponse(code = 400 , message = "BAD REQUEST YA SE REGISTRO ESTE NOMBRE OFICINA")
    })
    public ResponseEntity save( @RequestBody OfficeFrom officeFrom) {
        if(officeFromService.getOfficeFromByName(officeFrom.getName()).isPresent()){
            return new ResponseEntity<String>("YA SE REGISTRO", HttpStatus.BAD_REQUEST);
        }
        officeFrom.setDateCreated(LocalDateTime.now());
        return new ResponseEntity<OfficeFrom>(officeFromService.save(officeFrom), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Office")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 400 , message = "BAD REQUEST YA SE REGISTRO ESTE NOMBRE DE OFICINA")
    })
    public ResponseEntity update(@RequestBody OfficeFrom officeFrom, @ApiParam(value = "id of the office" , required = true, example = "12") @PathVariable("id") Integer id) {
        if( !officeFromService.getOfficeFrom(id).isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(officeFrom.getUserUpdated().isEmpty())
            return new ResponseEntity<String>("userCreated required", HttpStatus.BAD_REQUEST);
        if(officeFrom.getName().isEmpty())
            return new ResponseEntity<String>("name required", HttpStatus.BAD_REQUEST);

        Optional<OfficeFrom> officeFromBD = officeFromService.getOfficeFromByName(officeFrom.getName());
        if(officeFromBD.isPresent()){
            if(officeFromBD.get().getId() == id) {
                OfficeFrom officeFromObj = officeFromService.getOfficeFrom(id).get();
                officeFromObj.setName(officeFrom.getName());
                officeFromObj.setUserUpdated(officeFrom.getUserUpdated());
                officeFromObj.setDirection(officeFrom.getDirection());
                officeFromObj.setAbreviature(officeFrom.getAbreviature());
                officeFromObj.setDateUpdated(LocalDateTime.now());
                return new ResponseEntity<OfficeFrom>(officeFromService.save(officeFromObj), HttpStatus.OK);
            }
            return new ResponseEntity<String>("YA SE REGISTRO", HttpStatus.BAD_REQUEST);
        }
        OfficeFrom officeFromObj = officeFromService.getOfficeFrom(id).get();
        officeFromObj.setName(officeFrom.getName());
        officeFromObj.setDirection(officeFrom.getDirection());
        officeFromObj.setAbreviature(officeFrom.getAbreviature());
        officeFromObj.setUserUpdated(officeFrom.getUserUpdated());
        officeFromObj.setDateUpdated(LocalDateTime.now());
        return new ResponseEntity<OfficeFrom>(officeFromService.save(officeFromObj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return officeFromService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
