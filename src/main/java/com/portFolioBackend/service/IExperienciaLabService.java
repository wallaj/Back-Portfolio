
package com.portFolioBackend.service;

import com.portFolioBackend.entity.ExperienciaLab;
import java.util.List;


public interface IExperienciaLabService {
    public List<ExperienciaLab> verExperienciasLab();
    public void crearExperienciaLab(ExperienciaLab expLab);
    public void borrarExperienciaLab(Integer id);
    public void mostrarExperienciaLab(Integer id);
    public void actualizarExperienciaLab(ExperienciaLab expLab);
}
