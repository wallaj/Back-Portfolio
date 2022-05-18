
package com.portFolioBackend.service;

import com.portFolioBackend.model.Usuario;
import java.util.List;

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
}
