
package com.portFolioBackend.service;

import com.portFolioBackend.model.ExperienciaLab;
import java.util.List;


public interface IExperienciaLabService {
    public List<ExperienciaLab> verExperienciasLab();
    public void crearExperienciaLab(ExperienciaLab expLab);
    public void borrarExperienciaLab(Integer id);
    public void mostrarExperienciaLab(Integer id);
}
