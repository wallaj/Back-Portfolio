/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portFolioBackend.security.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marcos
 */
@Getter @Setter
public class Mensaje {
    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
