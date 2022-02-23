package com.oefa.backend.web.controller;

import com.oefa.backend.domain.EconomicSector;
import com.oefa.backend.domain.Proceding;
import com.oefa.backend.domain.ProcedingVocal;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.service.EconomicSectorService;
import com.oefa.backend.domain.service.ProcedingService;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/procedings")
public class ProcedingController {
    @Autowired
    private ProcedingService procedingService;
    @Autowired
    private EconomicSectorService economicSectorService;
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping
    @ApiOperation("Retorna la lista de expedientes")
    @ApiResponse(code = 200 , message = "OK")
    public ResponseEntity<List<Proceding>> getAll() {
        return new ResponseEntity<>(procedingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("retorna el expediente con el Id indicado")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 404 , message = "Proceding not found")
    })
    public ResponseEntity<Proceding> getProceding(@ApiParam(value = "id of the proceding" , required = true, example = "22") @PathVariable("id") Integer id) {
        return procedingService.getProceding(id)
                .map(proceding -> new ResponseEntity<>(proceding, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    @ApiOperation("Inserta un expediente")
    @ApiResponses({
            @ApiResponse(code = 201 , message = "CREATED"),
            @ApiResponse(code = 400 , message = "BAD REQUEST")
    })
    public ResponseEntity save( @RequestBody Proceding proceding) {
        if(proceding.getUserCreated().isEmpty())
            return new ResponseEntity<String>("userCreated required", HttpStatus.BAD_REQUEST);
        if(proceding.getNumberProceding().isEmpty())
            return new ResponseEntity<String>("number proceding is required", HttpStatus.BAD_REQUEST);

        if(procedingService.getProcedingByNumberProceding(proceding.getNumberProceding()).isPresent()) {
            return new ResponseEntity<String>("Ya se registro este numero de expediente", HttpStatus.BAD_REQUEST);
        }
        EconomicSector economicSector = economicSectorService.getEconomicSector(proceding.getEconomicSectorId()).get();
        String nameSpecialty = economicSector.getName();
        if(!specialtyService.getSpecialtyByName(nameSpecialty).isPresent()) {
            return new ResponseEntity<String>("no hay existe la especilidad para los vocales", HttpStatus.CONFLICT);
        }
        Specialty specialty = specialtyService.getSpecialtyByName(nameSpecialty).get();
        if( specialty.getVocals().size() == 0) {
            return new ResponseEntity<String>("no hay vocales disponibles en esta especialidad", HttpStatus.CONFLICT);
        }
        List<ProcedingVocal> procedingVocals = new ArrayList<>();
        specialty.getVocals().forEach( vocal -> {
            List<Proceding> procedingsForVocal = procedingService.getAllByVocalId(vocal.getVocalId());
            ProcedingVocal objProcedingsForVocal = new ProcedingVocal(vocal.getVocalId(), procedingsForVocal.size());
            procedingVocals.add(objProcedingsForVocal);
        });
        Collections.sort(procedingVocals);
        proceding.setVocalId(procedingVocals.get(0).getVocalId());
        proceding.setDateCreation(LocalDateTime.now());
        return new ResponseEntity<Proceding>(procedingService.save(proceding), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Proceding")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 400 , message = "BAD REQUEST")
    })
    public ResponseEntity update(@RequestBody Proceding proceding,
                                 @ApiParam(value = "id of the proceding" , required = true, example = "12") @PathVariable("id") Integer id) {
        if( !procedingService.getProceding(id).isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(proceding.getUserUpdated().isEmpty())
            return new ResponseEntity<String>("userUpdated required", HttpStatus.BAD_REQUEST);
        if(proceding.getNumberProceding().isEmpty())
            return new ResponseEntity<String>("numero de expediente es requerido", HttpStatus.BAD_REQUEST);

        Proceding procedingObj = procedingService.getProceding(id).get();

        proceding.setId(id);
        proceding.setUserCreated(procedingObj.getUserCreated());
        proceding.setDateCreation(procedingObj.getDateCreation());
        proceding.setDateUpdated(LocalDateTime.now());
        return new ResponseEntity<Proceding>(procedingService.save(proceding), HttpStatus.OK);
    }





    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return procedingService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
