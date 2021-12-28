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
import java.util.Optional;

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
    @ApiOperation("Inserta un sector economico")
    @ApiResponses({
            @ApiResponse(code = 201 , message = "CREATED"),
            @ApiResponse(code = 400 , message = "BAD REQUEST YA SE REGSITRO ESTE NOMBRE DE SECTOR")
    })
    public ResponseEntity save( @RequestBody EconomicSector economicSector) {
        if(economicSectorService.getEconomicSectorByName(economicSector.getName()).isPresent()){
            return new ResponseEntity<String>("YA SE REGISTRO", HttpStatus.BAD_REQUEST);
        }
        economicSector.setDateCreation(LocalDateTime.now());
        return new ResponseEntity<EconomicSector>(economicSectorService.save(economicSector), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Economic Sector")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 400 , message = "BAD REQUEST YA SE REGISTRO ESTE NOMBRE DEL SECTOR")
    })
    public ResponseEntity update( @RequestBody EconomicSector economicSector, @ApiParam(value = "id of the Economic Sector" , required = true, example = "12") @PathVariable("id") Integer id) {
        if( !economicSectorService.getEconomicSector(id).isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(economicSector.getUserUpdated().isEmpty())
            return new ResponseEntity<String>("userCreated required", HttpStatus.BAD_REQUEST);
        if(economicSector.getName().isEmpty())
            return new ResponseEntity<String>("name required", HttpStatus.BAD_REQUEST);

        Optional<EconomicSector> economicSectorBD = economicSectorService.getEconomicSectorByName(economicSector.getName());
        if(economicSectorBD.isPresent()){
            if(economicSectorBD.get().getId() == id) {
                EconomicSector economicSectorObj = economicSectorService.getEconomicSector(id).get();
                economicSectorObj.setName(economicSector.getName());
                economicSectorObj.setUserUpdated(economicSector.getUserUpdated());
                economicSectorObj.setDateUpdated(LocalDateTime.now());
                return new ResponseEntity<EconomicSector>(economicSectorService.save(economicSectorObj), HttpStatus.OK);
            }
            return new ResponseEntity<String>("YA SE REGISTRO", HttpStatus.BAD_REQUEST);
        }
        EconomicSector economicSectorObj = economicSectorService.getEconomicSector(id).get();
        economicSectorObj.setName(economicSector.getName());
        economicSectorObj.setUserUpdated(economicSector.getUserUpdated());
        economicSectorObj.setDateUpdated(LocalDateTime.now());
        return new ResponseEntity<EconomicSector>(economicSectorService.save(economicSectorObj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return economicSectorService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
