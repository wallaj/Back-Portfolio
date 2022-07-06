
package com.portFolioBackend.entity;

import com.portFolioBackend.security.entity.Usuario;
import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity 
public class Estudio {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lugar;
    private String curso;
    private String tipo;
    private String estado;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(nullable = false, name = "userId")
    private Usuario user;

    public Estudio() {
    }
    public Estudio(Integer id, String lugar, String curso, String tipo, String estado) {
        this.id = id;
        this.lugar = lugar;
        this.curso = curso;
        this.tipo = tipo;
        this.estado = estado;
    }
    
}
