
package com.portFolioBackend.repository;

import com.portFolioBackend.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    
}
