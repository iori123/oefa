package com.oefa.backend.persistence;

import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.Vocal;
import com.oefa.backend.domain.repository.SpecialtyRepository;
import com.oefa.backend.persistence.crud.EspecialidadCrudRepository;
import com.oefa.backend.persistence.entity.Especialidad;
import com.oefa.backend.persistence.entity.VocalPonente;
import com.oefa.backend.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class EspecialidadRepository implements SpecialtyRepository  {
    @Autowired
    private EspecialidadCrudRepository especialidadCrudRepository;
    @Autowired
    private SpecialtyMapper mapper;
    @Override
    public List<Specialty> getAll() {
        List<Especialidad> especialidades = (List<Especialidad>)especialidadCrudRepository.findAll();
        return mapper.toSpecialtys(especialidades);
    }

    @Override
    public Optional<Specialty> getSpecialty(Integer id) {
        //return Optional.of( mapper.toSpecialty(especialidadCrudRepository.findOne(id)));
        return especialidadCrudRepository.findById(id).map(especialidad -> mapper.toSpecialty(especialidad));
    }

    @Override
    public Optional<Specialty> getSpecialtyByName(String name) {
        return especialidadCrudRepository.findBynombreEspecialidad(name).map(especialidad -> mapper.toSpecialty(especialidad));
    }

    @Override
    public Specialty save(Specialty specialty) {
        Especialidad especialidad = mapper.toEspecialidad(specialty);
       // especialidad.getVocales().forEach(vocalPonente -> vocalPonente.setEspecialidad(especialidad));
        return mapper.toSpecialty(especialidadCrudRepository.save(especialidad));
    }

    @Override
    public void delete( Integer idEspecialidad) {
        especialidadCrudRepository.deleteById(idEspecialidad);
    }

}
