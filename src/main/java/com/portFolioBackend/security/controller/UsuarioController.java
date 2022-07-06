package com.portFolioBackend.security.controller;




import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private  IUsuarioService usuarioServ; //Usuario
    
    @GetMapping("/ver/user") 
    @ResponseBody
    public ResponseEntity <List<Usuario>> verUsuarios(){
        return new ResponseEntity<>(usuarioServ.verUsuarios(),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<HttpStatus> borrarUsuario(@PathVariable Integer id){
       usuarioServ.borrarUsuario(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/user/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario user){
        usuarioServ.actualizarUsuario(user);
        return new ResponseEntity<>("User Actualizado!", HttpStatus.OK);
    }
    @GetMapping("/ver/user/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> verUsuarioID(@PathVariable Integer id){
        return new ResponseEntity<> (usuarioServ.buscarUsuario(id), HttpStatus.OK);
    }
}
