
package com.portFolioBackend.service;

import com.portFolioBackend.model.Usuario;
import com.portFolioBackend.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
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
    
}
