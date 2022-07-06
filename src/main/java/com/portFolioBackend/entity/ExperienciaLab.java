
package com.portFolioBackend.entity;

import com.portFolioBackend.security.entity.Usuario;
import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity 
public class ExperienciaLab {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String compania;
    private String ingreso;
    private String salida;
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "userId")
    private Usuario user;

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
