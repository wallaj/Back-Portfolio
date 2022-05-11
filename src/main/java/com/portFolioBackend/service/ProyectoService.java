
package com.portFolioBackend.service;

import com.portFolioBackend.model.Proyecto;
import com.portFolioBackend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Marcos
 */
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
    
}
