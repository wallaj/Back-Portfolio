
package com.portFolioBackend.security.repository;

import com.portFolioBackend.security.entity.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Marcos
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
    //Se crea un método adicional para la interface UsuarioRepository
    //el método devuelve un Usuario que es buscado por el método finBy
    //Para esto se nombra al método como 'findBy'seguido por el campo que debe buscar
    //Con letra mayúscula, en este caso el campo es 'Email' que es una atributo de la entidad Usuario
    boolean existsByEmail(String email);
}
