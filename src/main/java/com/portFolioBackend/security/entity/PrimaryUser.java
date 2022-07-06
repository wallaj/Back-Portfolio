
package com.portFolioBackend.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Marcos
 * 
 * Usuario accede a la base de datos
 * PrimaryUser implementa los privilegios de cada usuario
 */
public class PrimaryUser  implements UserDetails{
   
    private String email;
    private String password;
    //Clase especifica del security core
    private Collection<? extends GrantedAuthority> authorities;

    public PrimaryUser(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    ///Método que asigna privilegios a cada usuario
    public static PrimaryUser build(Usuario user){
        List<GrantedAuthority> authorities = 
            user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(
                rol.getRol().name())).collect(Collectors.toList());
        //Se convierte la clase rol en GrantedAuthority
        
        return new PrimaryUser(user.getEmail(), user.getPassword(), authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}
