
package com.portFolioBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity 
public class ExperienciaLab {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String compania;
    private String ingreso;
    private String salida;
    private String descripcion;

    public ExperienciaLab() {
    }

    public ExperienciaLab(Integer id, String compania, String ingreso, String salida, String descripcion) {
        this.id = id;
        this.compania = compania;
        this.ingreso = ingreso;
        this.salida = salida;
        this.descripcion = descripcion;
    }
}
