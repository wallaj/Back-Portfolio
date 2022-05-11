
package com.portFolioBackend.service;

import com.portFolioBackend.model.Estudio;
import java.util.List;


public interface IEstudioService {
    public List<Estudio> verEstudios();
    public void crearEstudio(Estudio est);
    public void borrarEstudio(Integer id);
    public Estudio buscarEstudio(Integer id);
}
