
package com.portFolioBackend.security.service;

import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcos
 */
@Service
@Transactional
public class UsuarioService  implements IUsuarioService{

    @Autowired 
    private UsuarioRepository usuarioRepo;
    
    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void crearUsuario(Usuario user) {
        usuarioRepo.save(user);
    }

    @Override
    public void borrarUsuario(Integer id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Integer id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarUsuario(Usuario user) {
        usuarioRepo.save(user);
    }

    @Override
    public Optional<Usuario> getByMail(String email) {
       return usuarioRepo.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepo.existsByEmail(email);
    }
    
}
