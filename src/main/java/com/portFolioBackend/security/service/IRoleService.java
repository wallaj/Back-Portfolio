/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portFolioBackend.security.service;

import com.portFolioBackend.security.entity.Rol;
import com.portFolioBackend.security.enums.RoleName;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcos
 */

public interface IRoleService {
    public Optional<Rol>getRolPorNombre(RoleName rolNombre);
    public void guardarRol(Rol rol);
}
