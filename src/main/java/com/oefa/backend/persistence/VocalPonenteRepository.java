package com.oefa.backend.persistence;

import com.oefa.backend.domain.Vocal;
import com.oefa.backend.domain.repository.VocalRepository;
import com.oefa.backend.persistence.crud.VocalPonenteCrudRepository;
import com.oefa.backend.persistence.entity.VocalPonente;
import com.oefa.backend.persistence.mapper.VocalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class VocalPonenteRepository implements VocalRepository {
    @Autowired
    private VocalPonenteCrudRepository vocalPonenteCrudRepository;

    @Autowired
    private VocalMapper mapper;
    @Override
    public List<Vocal> getAll() {
        List<VocalPonente> vocales = (List<VocalPonente>)vocalPonenteCrudRepository.findAll();
        return mapper.toVocals(vocales);
    }

    @Override
    public List<Vocal> getAllVocals(String fullName) {
        List<VocalPonente> vocales = (List<VocalPonente>)vocalPonenteCrudRepository.findByNombreCompletoContainingIgnoreCase(fullName);
        return mapper.toVocals(vocales);
    }

    @Override
    public Optional<Vocal> getVocal(Integer id) {
        //return Optional.of( mapper.toVocal(vocalPonenteCrudRepository.findOne(id)));

        return vocalPonenteCrudRepository.findById(id).map(vocalPonente -> mapper.toVocal(vocalPonente));
    }
    @Override
    public Vocal save(Vocal vocal) {
        VocalPonente vocalPonente = mapper.toVocalPonente(vocal);
        vocalPonente.getEspecialidades().forEach(especialidad -> especialidad.setVocalPonente(vocalPonente));
        vocalPonente.setNombreCompleto(vocal.getNames() + " "+ vocal.getLastName());
        return mapper.toVocal(vocalPonenteCrudRepository.save(vocalPonente));
    }
    @Override
    public void delete( Integer idVocal) {
        vocalPonenteCrudRepository.deleteById(idVocal);
    }

}
