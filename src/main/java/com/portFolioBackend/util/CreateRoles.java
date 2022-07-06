

package com.portFolioBackend.util;

import com.portFolioBackend.security.entity.Rol;
import com.portFolioBackend.security.enums.RoleName;
import com.portFolioBackend.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Sólo se ejecuta una vez para crear roles en la base de datos
 * @author Marcos
 */
@Component
public class CreateRoles  implements CommandLineRunner{

    @Autowired
    RoleService roleService;
    
    @Override
    public void run(String... args) throws Exception {
        
        /*Rol rolAdmin = new Rol(RoleName.ROLE_ADMIN);
        Rol rolUser = new Rol(RoleName.ROLE_USER);
        roleService.guardarRol(rolAdmin);
        roleService.guardarRol(rolUser);*/
    }
    
}
