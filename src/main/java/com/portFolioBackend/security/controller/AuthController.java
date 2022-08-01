
package com.portFolioBackend.security.controller;

import com.portFolioBackend.security.dto.JWTdto;
import com.portFolioBackend.security.dto.Login;
import com.portFolioBackend.security.dto.Mensaje;
import com.portFolioBackend.security.dto.NewUser;
import com.portFolioBackend.security.entity.Rol;
import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.enums.RoleName;
import com.portFolioBackend.security.jwt.JWTProvider;
import com.portFolioBackend.security.service.RoleService;
import com.portFolioBackend.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {
    
    @Autowired
    PasswordEncoder passEncoder; //cifra contraseña
    
    @Autowired
    AuthenticationManager authManager;
    
    @Autowired
    UsuarioService userService;
    
    @Autowired
    RoleService rolService;
    
    @Autowired
    JWTProvider jwtProvider;
    
    @PostMapping("/new/user")
    public ResponseEntity<?> nuevoUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()) //Valida errores en los campos ingresados
            return new ResponseEntity(new Mensaje("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))//Valida si el mail ingresado ya existe
            return new ResponseEntity(new Mensaje("El email ingresado ya existe"), HttpStatus.BAD_REQUEST);
        //Crea usuario a partir del newUser
        Usuario usuario = new Usuario(newUser.getEmail(), passEncoder.encode(newUser.getPassword())); 
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getRolPorNombre(RoleName.ROLE_USER).get()); //Por defecto asigna rol 'USER'
        if(newUser.getRoles().contains("admin")) //Si el newUser está ingresado con rol 'ADMIN'
            roles.add(rolService.getRolPorNombre(RoleName.ROLE_ADMIN).get());
            usuario.setRoles(roles);//Asigna rol
            userService.crearUsuario(usuario);
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JWTdto> login(@Valid @RequestBody Login loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal ingresados "+ bindingResult.toString()), HttpStatus.BAD_REQUEST);
        Authentication authentication =  
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUser.getEmail(),loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);//A partir de la autenticación se genera el token
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JWTdto jwtDTO = new JWTdto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
