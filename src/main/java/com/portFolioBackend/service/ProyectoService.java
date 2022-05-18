
package com.portFolioBackend.service;

import com.portFolioBackend.model.Proyecto;
import com.portFolioBackend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public ProyectoRepository proyectoRepo;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto pro) {
        proyectoRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Integer id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Integer id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarProyecto(Proyecto pro) {
        proyectoRepo.save(pro);
    }
    
}
