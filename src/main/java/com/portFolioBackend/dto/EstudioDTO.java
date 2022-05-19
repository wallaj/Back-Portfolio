
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
public class EstudioDTO implements Serializable{
    private Integer id;
    private String lugar;
    private String curso;
    private String tipo;
    
    private Usuario userId;
}
