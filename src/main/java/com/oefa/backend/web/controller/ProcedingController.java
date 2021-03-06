package com.oefa.backend.web.controller;

import com.oefa.backend.domain.*;
import com.oefa.backend.domain.dto.proceding.DocumentDto;
import com.oefa.backend.domain.dto.proceding.ProcedingAssign;
import com.oefa.backend.domain.dto.proceding.ProcedingsAssignResponseDTO;
import com.oefa.backend.domain.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/procedings")
public class ProcedingController {
    @Autowired
    private ProcedingService procedingService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private EconomicSectorService economicSectorService;
    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private VocalService vocalService;

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

        if( proceding.getVocals() != null) {
            EconomicSector economicSector = economicSectorService.getEconomicSector(proceding.getEconomicSectorId()).get();
            String nameSpecialty = economicSector.getName();
            if(!specialtyService.getSpecialtyByName(nameSpecialty).isPresent()) {
                return new ResponseEntity<String>("no hay existe la especilidad para los vocales", HttpStatus.CONFLICT);
            }
            Specialty specialty = specialtyService.getSpecialtyByName(nameSpecialty).get();
            if( specialty.getVocals().size() == 0) {
                return new ResponseEntity<String>("no hay vocales disponibles en esta especialidad", HttpStatus.CONFLICT);
            }
            if( proceding.getVocals().size() != 0) {
                proceding.getVocals().forEach( vocal -> {
                    vocal.setDateCreated(LocalDateTime.now());
                    vocal.setUserCreated(proceding.getUserCreated());
                });
                proceding.setConditionId(2);
            }
        }
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
        Proceding procedingObj = procedingService.getProceding(id).get();
        try {
            if(proceding.getUserUpdated() == null) return new ResponseEntity<String>("userUpdated required", HttpStatus.BAD_REQUEST);
            procedingObj.setUserUpdated(proceding.getUserUpdated());
            procedingObj.setDateUpdated(LocalDateTime.now());

            if(proceding.getRuc() != null) procedingObj.setRuc(proceding.getRuc());
            if(proceding.getComplexity() != null) procedingObj.setComplexity(proceding.getComplexity());
            if(proceding.getSocialReason() != null) procedingObj.setSocialReason(proceding.getSocialReason());
            if(proceding.getDirection() != null) procedingObj.setDirection(proceding.getDirection());
            if(proceding.getMemorandum() != null) procedingObj.setMemorandum(proceding.getMemorandum());
            if(proceding.getAdministrate() != null) procedingObj.setAdministrate(proceding.getAdministrate());
            if(proceding.getDocElevation() != null) procedingObj.setDocElevation(proceding.getDocElevation());
            if(proceding.getRoadMap() != null) procedingObj.setRoadMap(proceding.getRoadMap());
            if(proceding.getActive() != null) procedingObj.setActive(proceding.getActive());
            if(proceding.getDateReception() != null) procedingObj.setDateReception(proceding.getDateReception());
            if(proceding.getDateAttention() != null) procedingObj.setDateAttention(proceding.getDateAttention());
            if(proceding.getConditionId() != null) procedingObj.setConditionId(proceding.getConditionId());
            if(proceding.getOfficeFromId() != null) procedingObj.setOfficeFromId(proceding.getOfficeFromId());
            if(proceding.getEconomicSectorId() != null) procedingObj.setEconomicSectorId(proceding.getEconomicSectorId());

            if(procedingService.delete(id)) {
                if( proceding.getVocals() != null) {
                    if(proceding.getVocals().size() != 0 ) {
                        if( procedingObj.getVocals().size() == 0 ) {
                            procedingObj.getVocals().forEach( vocal -> {
                                vocal.setVocalId(proceding.getVocals().get(0).getVocalId());
                                vocal.setDateCreated(LocalDateTime.now());
                                vocal.setUserCreated(proceding.getUserCreated());
                            });
                        }else {
                            procedingObj.getVocals().forEach( vocal -> {
                                vocal.setVocalId(proceding.getVocals().get(0).getVocalId());
                                vocal.setUserUpdated(proceding.getUserUpdated());
                                vocal.setDateUpdated(LocalDateTime.now());
                            });
                        }
                        procedingObj.setConditionId(2);
                    }
                }
            }
            return new ResponseEntity<Proceding>(procedingService.save(procedingObj), HttpStatus.OK);
        } catch (NullPointerException e) {
            System.out.println(e);
            return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/assign/{id}")
    @ApiOperation("ASIGNAR VOCAL A NUEVO EXPEDIENTE")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 400 , message = "BAD REQUEST")
    })
    public ResponseEntity assign(@RequestBody ProcedingAssign proceding,
                                 @ApiParam(value = "id of the proceding" , required = true, example = "12") @PathVariable("id") Integer id) {

        if( !procedingService.getProceding(id).isPresent()) return new ResponseEntity<String>("no existe el expediente",HttpStatus.NOT_FOUND);
        Proceding procedingObj = procedingService.getProceding(id).get();

        EconomicSector economicSector = economicSectorService.getEconomicSector(procedingObj.getEconomicSectorId()).get();
        String nameSpecialty = economicSector.getName();

        if(!specialtyService.getSpecialtyByName(nameSpecialty).isPresent()) {
            return new ResponseEntity<String>("no hay existe la especialidad para los vocales", HttpStatus.CONFLICT);
        }
        Specialty specialty = specialtyService.getSpecialtyByName(nameSpecialty).get();

        if( specialty.getVocals().size() == 0) {
            return new ResponseEntity<String>("no hay vocales disponibles en esta especialidad", HttpStatus.CONFLICT);
        }

        try {
            if(proceding.getUserAssign() == null) return new ResponseEntity<String>("Es necesario el campo userAssign ", HttpStatus.BAD_REQUEST);
            procedingObj.setUserUpdated(proceding.getUserAssign());
            procedingObj.setDateUpdated(LocalDateTime.now());

            if( procedingObj.getVocals().size() == 0) {
                List<ProcedingVocalSort> procedingVocals = new ArrayList<>();
                specialty.getVocals().forEach( vocal -> {

                    List<ProcedingVocal> procedingsForVocal = vocalService.getVocal(vocal.getVocalId()).get().getProcedings();
                    List<ProcedingVocal> procedingsForVocalNoResolve = new ArrayList<>();
                    if(procedingsForVocal.size() > 0) {
                        procedingsForVocal.forEach( p -> {
                            Proceding procedingData = procedingService.getProceding(p.getProcedingId()).get();
                            if(procedingData.getConditionId() == 2 ){
                                procedingsForVocalNoResolve.add(p);
                            }
                        });
                    }
                    ProcedingVocalSort objProcedingsForVocal = new ProcedingVocalSort(vocal.getVocalId(), procedingsForVocalNoResolve.size());
                    procedingVocals.add(objProcedingsForVocal);
                });

                Collections.sort(procedingVocals);

                VocalProceding vocalProceding = new VocalProceding();
                vocalProceding.setVocalId(procedingVocals.get(0).getVocalId());
                vocalProceding.setDateCreated(LocalDateTime.now());
                vocalProceding.setUserCreated(proceding.getUserAssign());
                List<VocalProceding> vocals = new ArrayList<VocalProceding>();
                vocals.add(vocalProceding);
                procedingObj.setConditionId(2);
                procedingObj.setVocals(vocals);

                return new ResponseEntity<Proceding>(procedingService.save(procedingObj), HttpStatus.OK);

            }else {
                return new ResponseEntity<String>( "Ya existe asignado un vocal para este expediente", HttpStatus.CONFLICT);

            }

        } catch (NullPointerException e) {
            System.out.println(e);
            return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/assign")
    @ApiOperation("ASIGNAR VOCALS A LOS EXPEDIENTES")
    @ApiResponses({
            @ApiResponse(code = 200 , message = "OK"),
            @ApiResponse(code = 400 , message = "BAD REQUEST")
    })
    public ResponseEntity assignAll(@RequestBody ProcedingAssign proceding ){
        if(proceding.getUserAssign() == null)
            return new ResponseEntity<String>("Es necesario el campo userAssign ", HttpStatus.BAD_REQUEST);

        List<Proceding> dataBD = procedingService.getAll();
        List<Proceding> notAccepted = new ArrayList<>();
        List<Proceding> temAcceptedProceding = new ArrayList<>();
        List<Proceding> acceptedProcedings = new ArrayList<>();
        List<Proceding> data = new ArrayList<>();

        dataBD.forEach( p-> {
            if(p.getVocals().size() == 0 ){
                System.out.println(p.getVocals().size());
                data.add(p);
            }
        });

        data.forEach( p -> {

            EconomicSector economicSector = economicSectorService.getEconomicSector(p.getEconomicSectorId()).get();
            String nameSpecialty = economicSector.getName();
            if(specialtyService.getSpecialtyByName(nameSpecialty).isPresent()) {
                Specialty specialty = specialtyService.getSpecialtyByName(nameSpecialty).get();
                if( specialty.getVocals().size() > 0) {
                    temAcceptedProceding.add(p);
                    acceptedProcedings.add(p);
                }else {
                    notAccepted.add(p);
                }
            }else {
                notAccepted.add(p);
            }

        });

        List<Vocal> vocalesDB = vocalService.getAll();

        acceptedProcedings.forEach( procedingObj -> {
            try {
                procedingObj.setUserUpdated(proceding.getUserAssign());
                procedingObj.setDateUpdated(LocalDateTime.now());

                List<ProcedingVocalSort> procedingVocals = new ArrayList<>();
                String nameSpecialty = economicSectorService.getEconomicSector(procedingObj.getEconomicSectorId()).get().getName();
                Specialty specialties = specialtyService.getSpecialtyByName(nameSpecialty).get();

                specialties.getVocals().forEach( vocal -> {
                    List<ProcedingVocal> procedingsForVocal = vocalService.getVocal(vocal.getVocalId()).get().getProcedings();
                    List<ProcedingVocal> procedingsForVocalNoResolve = new ArrayList<>();
                    if(procedingsForVocal.size() > 0) {
                        procedingsForVocal.forEach( p -> {
                            Proceding procedingData = procedingService.getProceding(p.getProcedingId()).get();
                            if(procedingData.getConditionId() == 2 ){
                                procedingsForVocalNoResolve.add(p);
                            }
                        });
                    }

                    ProcedingVocalSort objProcedingsForVocal = new ProcedingVocalSort(vocal.getVocalId(), procedingsForVocalNoResolve.size());
                    procedingVocals.add(objProcedingsForVocal);
                });

                Collections.sort(procedingVocals);

                VocalProceding vocalProceding = new VocalProceding();
                vocalProceding.setVocalId(procedingVocals.get(0).getVocalId());
                vocalProceding.setDateCreated(LocalDateTime.now());
                vocalProceding.setUserCreated(proceding.getUserAssign());
                List<VocalProceding> vocals = new ArrayList<VocalProceding>();
                vocals.add(vocalProceding);
                procedingObj.setConditionId(2);
                procedingObj.setVocals(vocals);
                procedingService.save(procedingObj);
            } catch (NullPointerException e) {
                System.out.println(e);
            }

        });
        if(notAccepted.size() == 0 && temAcceptedProceding.size() > 0){
            ProcedingsAssignResponseDTO response = new ProcedingsAssignResponseDTO(notAccepted.size(),"Se asignaron todos los expedientes correctamente",notAccepted, temAcceptedProceding);
            return new ResponseEntity<ProcedingsAssignResponseDTO>( response, HttpStatus.OK);        }
        if(temAcceptedProceding.size() > 0 && notAccepted.size() > 0 ){
            ProcedingsAssignResponseDTO response = new ProcedingsAssignResponseDTO(notAccepted.size(),"No se lograron insertar los siguientes expedientes por motivos de especialidad no encontrada o que la especialidad no ha sido  asignada a vocales",notAccepted, temAcceptedProceding);
            return new ResponseEntity<ProcedingsAssignResponseDTO>( response, HttpStatus.CONFLICT);
        }
        if( temAcceptedProceding.size() ==  0 && notAccepted.size() > 0) {
            ProcedingsAssignResponseDTO response = new ProcedingsAssignResponseDTO(notAccepted.size(),"no se pudieron asignar los expedientes , las especialidades no fueron registradas o estas no estaban designadas a un vocal.",notAccepted, temAcceptedProceding);
            return new ResponseEntity<ProcedingsAssignResponseDTO>( response, HttpStatus.CONFLICT);

        }
        if( temAcceptedProceding.size() ==  0 && notAccepted.size() == 0) {
            ProcedingsAssignResponseDTO response = new ProcedingsAssignResponseDTO(notAccepted.size(),"Todos los expedientes ya fueron asignados",notAccepted, temAcceptedProceding);
            return new ResponseEntity<ProcedingsAssignResponseDTO>( response, HttpStatus.OK);
        }
        return new ResponseEntity<String>(".", HttpStatus.BAD_REQUEST);

    }

    @GetMapping ("/document")
    @ApiOperation("retorna el documento")
    public ResponseEntity documentProceding(@RequestParam(required = true) String ticket_auth ,@RequestParam(required = true) String ticket_session) {
        return documentService.getDocumentByTickets(ticket_auth,ticket_session)
                .map(document1 -> new ResponseEntity<>(document1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return procedingService.delete(id)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
