
package com.portFolioBackend.repository;

import com.portFolioBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Marcos
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
