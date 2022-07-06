
package com.portFolioBackend.security.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Marcos
 */
@Getter @Setter
public class JWTdto {
    private String token;
    private String bearer = "Bearer";
    private String email;
    private Collection <?  extends GrantedAuthority> authorities;

    public JWTdto(String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }
    
    
    
}
