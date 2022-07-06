
package com.portFolioBackend.service;

import com.portFolioBackend.entity.Proyecto;
import java.util.List;

/**
 *
 * @author Marcos
 */
public interface IProyectoService {
    public List<Proyecto> verProyectos();
    public void crearProyecto(Proyecto pro);
    public void borrarProyecto(Integer id);
    public Proyecto buscarProyecto(Integer id);
    public void actualizarProyecto(Proyecto pro);
}
