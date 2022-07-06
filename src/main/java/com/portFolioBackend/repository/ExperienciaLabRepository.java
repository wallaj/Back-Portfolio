
package com.portFolioBackend.repository;

import com.portFolioBackend.entity.ExperienciaLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLabRepository extends JpaRepository<ExperienciaLab, Integer>{
    
}
