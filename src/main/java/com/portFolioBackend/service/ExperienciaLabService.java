
package com.portFolioBackend.service;

import com.portFolioBackend.model.ExperienciaLab;
import com.portFolioBackend.repository.ExperienciaLabRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLabService implements IExperienciaLabService {
    
    @Autowired
    public ExperienciaLabRepository expLabRepo;
    
    @Override
    public List<ExperienciaLab> verExperienciasLab() {
        return expLabRepo.findAll();
    }

    @Override
    public void crearExperienciaLab(ExperienciaLab expLab) {
        expLabRepo.save(expLab);
    }

    @Override
    public void borrarExperienciaLab(Integer id) {
        expLabRepo.deleteById(id);
    }

    @Override
    public void mostrarExperienciaLab(Integer id) {
        expLabRepo.findById(id);
    }

    @Override
    public void actualizarExperienciaLab(ExperienciaLab expLab) {
        expLabRepo.save(expLab);
    }
    
}
