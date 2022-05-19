
package com.portFolioBackend.dto;

import com.portFolioBackend.model.Usuario;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marcos
 */
@Getter
@Setter
public class ExperienciaDTO implements Serializable{
    private Integer id;
    private String compania;
    private String ingreso;
    private String salida;
    private String descripcion;
    
    private Usuario userId;
}
