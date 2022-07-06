/*
 * Clase que genera el token. Efectua métodos de validación del token para comprobar 
 * que esté bien formado y/o no haya expirado
 */
package com.portFolioBackend.security.jwt;

import com.portFolioBackend.security.entity.PrimaryUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcos
 */
@Component
public class JWTProvider {
    //Sirve para ver cuales métodos dan error en caso de que no funcione la app (registro de registros)
    //Registra errores. Será utilizada sólo en fase de desarrollo
    private final static Logger logger = LoggerFactory.getLogger(JWTProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication auth){
        PrimaryUser usuarioPrincipal = (PrimaryUser) auth.getPrincipal();
        
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + expiration * 1000))
            .signWith(SignatureAlgorithm.HS512, secret).compact();
        //armado del token
    }
    
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(MalformedJwtException jwtEx){
            logger.error("Token mal formado");
        }catch(UnsupportedJwtException jwtEx){
            logger.error("Token no soportado");
        }catch(ExpiredJwtException jwtEx){
            logger.error("Token expirado");
        }catch(IllegalArgumentException jwtEx){
            logger.error("Token vacío");
        }catch(SignatureException jwtEx){
            logger.error("Fallo en la firma del token");
        }
        return false;
   }
}
