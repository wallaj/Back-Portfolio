
package com.portFolioBackend.security.service;

import com.portFolioBackend.security.entity.Rol;
import com.portFolioBackend.security.enums.RoleName;
import com.portFolioBackend.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcos
 */
@Service
@Transactional
public class RoleService  implements IRoleService{
    
   
    @Autowired
    RolRepository rolRepo;
    
    @Override
    public Optional<Rol>getRolPorNombre(RoleName rolNombre){
        return this.rolRepo.findByRol(rolNombre);
    }

    @Override
    public void guardarRol(Rol rol) {
        this.rolRepo.save(rol);
    }
            
}
