
package com.portFolioBackend.security.service;

import com.portFolioBackend.security.entity.PrimaryUser;
import com.portFolioBackend.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioService.getByMail(email).get();
        return PrimaryUser.build(user);
    }
    
}
