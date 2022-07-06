/*
 * Se ejecuta por cada petición. Comprobará la validez del token a través
 * de la clase JWTProvider. Si el token es válido, se podrá acceder al recurso
 */
package com.portFolioBackend.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import com.portFolioBackend.security.jwt.JWTProvider;
import com.portFolioBackend.security.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marcos
 */
@Component
public class JWTFilter extends OncePerRequestFilter{
    
    @Autowired
    JWTProvider jwtProvider; //Provider
    @Autowired 
    UserDetailsServiceImp userDetailsService;
    
    private final static Logger logger = LoggerFactory.getLogger(JWTFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request,     
        HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Se ejecuta una vez por cada petición. Comprueba que el token sea válido.
        //Si es válido, permite el acceso el al recurso
        
        try{
            String token = getToken(request);

            //Si el token no es nulo y es validado por JWTProvider
            if(token != null && jwtProvider.validateToken(token)){
                //A partir del token obtenemos el usuario 
                String userName = jwtProvider.getUserNameFromToken(token);
                //Se crea el userDetails
                UserDetails  userDetails= userDetailsService.loadUserByUsername(userName);
                //Se autentica el userDetails
                UsernamePasswordAuthenticationToken upat =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //La autenticación se pasa al contexto de autenticación
                SecurityContextHolder.getContext().setAuthentication(upat);
            } 
        }catch(Exception e){
            logger.error("Fallo en el método doFilter"+ e.getMessage());
        }
        filterChain.doFilter(request, response);
        
    }
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }
    
}
