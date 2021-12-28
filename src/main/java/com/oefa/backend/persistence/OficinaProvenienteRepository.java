package com.oefa.backend.persistence;

import com.oefa.backend.domain.OfficeFrom;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.repository.OfficeFromRepository;
import com.oefa.backend.domain.repository.SpecialtyRepository;
import com.oefa.backend.persistence.crud.EspecialidadCrudRepository;
import com.oefa.backend.persistence.crud.OficinaProvenienteCrudRepository;
import com.oefa.backend.persistence.entity.Especialidad;
import com.oefa.backend.persistence.entity.OficinaProveniente;
import com.oefa.backend.persistence.mapper.OfficeFromMapper;
import com.oefa.backend.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class OficinaProvenienteRepository implements OfficeFromRepository {
    @Autowired
    private OficinaProvenienteCrudRepository oficinaProvenienteCrudRepository;
    @Autowired
    private OfficeFromMapper mapper;
    @Override
    public List<OfficeFrom> getAll() {
        List<OficinaProveniente> oficinasProvenientes = (List<OficinaProveniente>)oficinaProvenienteCrudRepository.findAll();
        return mapper.toOfficesFrom(oficinasProvenientes);
    }

    @Override
    public Optional<OfficeFrom> getOfficeFrom(Integer id) {
        return oficinaProvenienteCrudRepository.findById(id).map(oficina -> mapper.toOfficeFrom(oficina));
    }
    @Override
    public Optional<OfficeFrom> getOfficeFromByName(String name) {
        return oficinaProvenienteCrudRepository.findBynombreOficina(name).map(oficina -> mapper.toOfficeFrom(oficina));
    }
    @Override
    public OfficeFrom save(OfficeFrom officeFrom) {
        OficinaProveniente oficinaProveniente = mapper.toOficinaProveniente(officeFrom);
        return mapper.toOfficeFrom(oficinaProvenienteCrudRepository.save(oficinaProveniente));
    }
    @Override
    public void delete( Integer idEspecialidad) {
        oficinaProvenienteCrudRepository.deleteById(idEspecialidad);
    }
}
