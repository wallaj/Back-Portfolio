
package com.portFolioBackend.security.service;

import com.portFolioBackend.security.entity.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Marcos
 */
public interface IUsuarioService {
    public List<Usuario> verUsuarios();
    public void crearUsuario(Usuario user);
    public void borrarUsuario(Integer id);
    public Usuario buscarUsuario(Integer id);
    public void actualizarUsuario(Usuario user);
    public Optional<Usuario> getByMail(String email);
    public boolean existsByEmail(String email);
}
