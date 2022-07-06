
package com.portFolioBackend.service;

import com.portFolioBackend.entity.Estudio;
import com.portFolioBackend.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService{

    @Autowired
    public EstudioRepository estudioRepo;
    
    @Override
    public List<Estudio> verEstudios() {
        return estudioRepo.findAll();
    }

    @Override
    public void crearEstudio(Estudio est) {
        estudioRepo.save(est);
    }

    @Override
    public void borrarEstudio(Integer id) {
        estudioRepo.deleteById(id);
    }

    @Override
    public Estudio buscarEstudio(Integer id) {
        return estudioRepo.findById(id).orElse(null); //or else devuelve un null
        //evitando problemas por registros inexistentes
    }

    @Override
    public void actualizarEstudio(Estudio est) {
        estudioRepo.save(est);
    }
    
    
}
