
package com.portFolioBackend.security.entity;

import com.portFolioBackend.entity.Estudio;
import com.portFolioBackend.entity.ExperienciaLab;
import com.portFolioBackend.entity.Proyecto;
import com.portFolioBackend.entity.Skill;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Marcos
 */
@Getter @Setter
@Entity
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(unique = true)
    private String email;
    
    @NotNull
    private String password;
    
    /*//Relaciones
        @OneToMany(mappedBy ="userId")
        private List<Estudio> estudios;
        @OneToMany(mappedBy ="userId")
        private List<Proyecto> proyectos;
        @OneToMany(mappedBy ="userId")
        private List<ExperienciaLab> experienciasLab;
        @OneToMany(mappedBy ="userId")
        private List<Skill>skills;
    */
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)//EAGER: La relación es cargada al momento de cargar la entidad
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();//Set evita repetidos

    public Usuario() {
    }

    public Usuario( @NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }
    
    
}
