package com.oefa.backend.web.controller;

import com.oefa.backend.domain.EconomicSector;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.service.EconomicSectorService;
import com.oefa.backend.domain.service.SpecialtyService;
import com.oefa.backend.persistence.entity.SectorEconomico;
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
@RequestMapping("/economic-sector")

public class EconomicSectorController {
    @Autowired
    private EconomicSectorService economicSectorService;

    @GetMapping
    @ApiOperation("Retorna la lista de sectores economicos")
    @ApiResponse(code = 200 , message = "OK")
    public ResponseEntity<List<EconomicSector>> getAll() {
        return new ResponseEntity<>(economicSectorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("retorna el sector economico con el Id indicado")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 404 , message = "Sector economico not found")
    })
    public ResponseEntity<EconomicSector> getEconomicSector(@ApiParam(value = "id of the economic sector" , required = true, example = "21") @PathVariable("id") Integer id) {
        return economicSectorService.getEconomicSector(id)
                .map(economicSector -> new ResponseEntity<>(economicSector, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<EconomicSector> save( @RequestBody EconomicSector economicSector) {
        economicSector.setDateCreation(LocalDateTime.now());
        return new ResponseEntity<>(economicSectorService.save(economicSector), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return economicSectorService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
