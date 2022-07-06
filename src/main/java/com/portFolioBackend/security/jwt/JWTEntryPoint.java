/*
 * Comprueba si hay un token válido. Si la respuesta es false envía un error 401
 * no autorizado   
 */
package com.portFolioBackend.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcos
 */
@Component
public class JWTEntryPoint implements AuthenticationEntryPoint {
    
    //Sirve para ver cuales métodos dan error en caso de que no funcione la app (registro de registros)
    //Registra errores. Será utilizada sólo en fase de desarrollo
    private final static Logger logger = LoggerFactory.getLogger(JWTEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, 
            AuthenticationException authException) throws IOException, ServletException {
        logger.error("Falla en el método commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
    
} 
