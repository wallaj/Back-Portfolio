
package com.portFolioBackend.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marcos
 */
@Getter @Setter
public class Login {
    @Email  
    private String email;
    @NotBlank
    private String password;
    
    
}
