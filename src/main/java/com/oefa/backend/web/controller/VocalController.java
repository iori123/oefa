package com.oefa.backend.web.controller;

import com.oefa.backend.domain.Vocal;
import com.oefa.backend.domain.service.SpecialtyService;
import com.oefa.backend.domain.service.VocalService;
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
@RequestMapping("/vocales")
public class VocalController {
    @Autowired
    private VocalService vocalService;
    @Autowired
    private SpecialtyService specialtyService;


    @GetMapping
    @ApiOperation("Get all list of Vocals")
    @ApiResponse(code = 200 , message = "OK")
    public ResponseEntity<List<Vocal>> getAll() {
        return new ResponseEntity<>(vocalService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search Vocal with an ID")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 404 , message = "Vocal not found")
    })
    public ResponseEntity<Vocal> getVocal(@ApiParam(value = "id of the Vocal" , required = true, example = "2") @PathVariable("id") Integer id) {
        return vocalService.getVocal(id)
                .map(vocal -> new ResponseEntity<>(vocal, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Inserta un Vocal")
    @ApiResponses({
            @ApiResponse(code = 201 , message = "CREATED"),
    })
    public ResponseEntity save( @RequestBody Vocal vocal ) {
        vocal.setDateCreated(LocalDateTime.now());
        return new ResponseEntity<Vocal>(vocalService.save(vocal), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return vocalService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
