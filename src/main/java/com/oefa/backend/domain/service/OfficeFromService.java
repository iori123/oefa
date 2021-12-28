package com.oefa.backend.domain.service;

import com.oefa.backend.domain.OfficeFrom;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.repository.OfficeFromRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfficeFromService {
    @Autowired
    private OfficeFromRepository officeFromRepository;

    public List<OfficeFrom> getAll() {
        return officeFromRepository.getAll();
    }
    public Optional<OfficeFrom> getOfficeFrom(Integer id) {
        return officeFromRepository.getOfficeFrom(id);
    }
    public Optional<OfficeFrom> getOfficeFromByName(String name) {return officeFromRepository.getOfficeFromByName(name);}

    public OfficeFrom save( OfficeFrom officeFrom) {
        return officeFromRepository.save(officeFrom);
    }
    public boolean delete( Integer id) {
        return getOfficeFrom(id).map( officeFrom -> {
            officeFromRepository.delete(id);
            return true ;
        }).orElse(false);
    }
}
