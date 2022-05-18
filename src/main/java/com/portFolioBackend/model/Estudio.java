
package com.portFolioBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity 
public class Estudio {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String lugar;
    private String curso;
    private String tipo;
    
    @ManyToOne
    private Usuario userId;

    public Estudio() {
    }
    public Estudio(Integer id, String lugar, String curso, String tipo) {
        this.id = id;
        this.lugar = lugar;
        this.curso = curso;
        this.tipo = tipo;
    }
    
}
