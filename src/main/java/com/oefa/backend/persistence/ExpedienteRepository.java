package com.oefa.backend.persistence;

import com.oefa.backend.domain.OfficeFrom;
import com.oefa.backend.domain.Proceding;
import com.oefa.backend.domain.Vocal;
import com.oefa.backend.domain.repository.ProcedingRepository;
import com.oefa.backend.persistence.crud.ExpedienteCrudRepository;
import com.oefa.backend.persistence.crud.OficinaProvenienteCrudRepository;
import com.oefa.backend.persistence.entity.Expediente;
import com.oefa.backend.persistence.entity.OficinaProveniente;
import com.oefa.backend.persistence.entity.VocalPonente;
import com.oefa.backend.persistence.mapper.OfficeFromMapper;
import com.oefa.backend.persistence.mapper.ProcedingMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ExpedienteRepository  implements ProcedingRepository {
    @Autowired
    private ExpedienteCrudRepository expedienteCrudRepository;
    @Autowired
    private ProcedingMapper mapper;
    @Override
    public List<Proceding> getAll() {
        List<Expediente> expedientes = (List<Expediente>)expedienteCrudRepository.findAll();
        return mapper.toProcedings(expedientes);
    }
    @Override
    public List<Proceding> getAllByVocalId(Integer id) {
        List<Expediente> expedientes = (List<Expediente>)expedienteCrudRepository.findByCodigoVocal(id);
        return mapper.toProcedings(expedientes);

    }
    @Override
    public Optional<Proceding> getProcedingByNumberProceding(String numberProceding) {
        return expedienteCrudRepository.findByNumeroExpedienteContainingIgnoreCase(numberProceding).map(oficina -> mapper.toProceding(oficina));
    }
    @Override
    public Optional<Proceding> getProceding(Integer id) {
        return expedienteCrudRepository.findById(id).map(expediente -> mapper.toProceding(expediente));
    }

    @Override
    public Proceding save(Proceding proceding) {
        Expediente expediente = mapper.toExpediente(proceding);
        return mapper.toProceding(expedienteCrudRepository.save(expediente));
    }

    @Override
    public void delete(Integer id) {
        expedienteCrudRepository.deleteById(id);
    }

}
