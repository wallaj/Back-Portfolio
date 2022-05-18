
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String descripcion;
    private String año;
    
    @ManyToOne
    private Usuario userId;

    public Proyecto() {
    }

    public Proyecto(Integer id, String descripcion, String año) {
        this.id = id;
        this.descripcion = descripcion;
        this.año = año;
    }
    
    
}
