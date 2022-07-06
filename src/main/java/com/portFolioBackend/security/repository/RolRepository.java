
package com.portFolioBackend.security.repository;

import com.portFolioBackend.security.entity.Rol;
import com.portFolioBackend.security.enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRol(RoleName rol);
}
