
package com.portFolioBackend.entity;

import com.portFolioBackend.security.entity.Usuario;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(length = 255)
    private String descripcion;
    private String anio;
    private String urlFoto;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "userId")
    private Usuario user;

    public Proyecto() {
    }

    public Proyecto(Integer id,String nombre, String descripcion, String anio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
    }
    
    
}
