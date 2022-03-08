package com.oefa.backend.web.controller;

import com.oefa.backend.domain.Proceding;
import com.oefa.backend.domain.Vocal;
import com.oefa.backend.domain.dto.search.SearchDTO;
import com.oefa.backend.domain.dto.vocal.VocalReportDto;
import com.oefa.backend.domain.service.ProcedingService;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vocales")
public class VocalController {
    @Autowired
    private VocalService vocalService;
    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private ProcedingService procedingService;

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

    @GetMapping("/report")
    @ApiOperation("get vocals report")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
    })
    public ResponseEntity<List<VocalReportDto>> getVocalReports() {
        List<VocalReportDto> reportVocals = new ArrayList<VocalReportDto>();
        
        vocalService.getAll().forEach( vocal -> {
            Vocal vocalData = vocalService.getVocal(vocal.getId()).get();
            VocalReportDto report = new VocalReportDto();
            report.setIdVocal(vocal.getId());
            report.setVocal(vocal.getNames());
            report.setAssignProcedigns(0);
            report.setResolveProcedings(0);
            report.setInactiveProcedings(0);
            if(vocalData.getProcedings().size() != 0) {
                vocalData.getProcedings().forEach( p -> {
                    Proceding proceding = procedingService.getProceding(p.getProcedingId()).get();
                    if(proceding.getConditionId() == 2 ) {
                        report.setAssignProcedigns( report.getAssignProcedigns() + 1 ); ;
                    }
                    if(proceding.getConditionId() == 3 ) {
                        report.setResolveProcedings( report.getResolveProcedings() + 1 ); ;
                    }
                    if(proceding.getActive() == 0 ) {
                        report.setInactiveProcedings( report.getInactiveProcedings() + 1 ); ;

                    }
                });
            }
            reportVocals.add(report);
        });
        return new ResponseEntity<>(reportVocals,HttpStatus.OK);

    }

    @GetMapping("/search")
    @ApiOperation("Search Vocal with an fullName")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 404 , message = "Vocal not found")
    })
    public ResponseEntity save( @RequestBody SearchDTO search ) {
        return  new ResponseEntity<>(vocalService.getAllByName(search.getKeyword()), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Inserta un Vocal")
    @ApiResponses({
            @ApiResponse(code = 201 , message = "CREATED"),
            @ApiResponse(code = 400 , message = "BAD REQUEST")

    })
    public ResponseEntity save( @RequestBody Vocal vocal ) {
        vocal.setDateCreated(LocalDateTime.now());
        vocal.getSpecialties().forEach( specialty -> {
            specialty.setDateCreated(LocalDateTime.now());
            specialty.setUserCreated(vocal.getUserCreated());
        });
        return new ResponseEntity<Vocal>(vocalService.save(vocal), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Vocal")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
    })
    public ResponseEntity update(@RequestBody Vocal vocal, @ApiParam(value = "id of the Vocal" , required = true, example = "12") @PathVariable("id") Integer id) {
        if( !vocalService.getVocal(id).isPresent())  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Vocal vocalObj = vocalService.getVocal(id).get();

        if(vocalService.delete(id)) {
            vocal.setId(id);
            vocal.setDateCreated(vocalObj.getDateCreated());
            vocal.setDateUpdated(LocalDateTime.now());
            vocal.setUserCreated(vocalObj.getUserCreated());
            vocal.setUserUpdated(vocal.getUserUpdated());
            vocal.getSpecialties().forEach( specialty -> {
                specialty.setDateCreated(LocalDateTime.now());
                specialty.setUserCreated(vocal.getUserCreated());
            });

            vocal.setProcedings(new ArrayList<>());
        }
        return new ResponseEntity<Vocal>(vocalService.save(vocal), HttpStatus.OK);
        //vocalObj.setSpecialties(vocal.getSpecialties());
        //vocal.setId(id);
        //vocal.setDateUpdated(LocalDateTime.now());

        //return new ResponseEntity<Vocal>(vocalService.save(vocal), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return vocalService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
