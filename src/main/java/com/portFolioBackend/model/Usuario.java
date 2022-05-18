
package com.portFolioBackend.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Marcos
 */
@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String mail;
    private String password;
    
    //Relaciones
    @OneToMany(mappedBy ="userId")
    private List<Estudio> estudios;
    @OneToMany(mappedBy ="userId")
    private List<Proyecto> proyectos;
    @OneToMany(mappedBy ="userId")
    private List<ExperienciaLab> experienciasLab;
    @OneToMany(mappedBy ="userId")
    private List<Skill>skills;
    
    

    public Usuario(Integer id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }
    
    
}
