
package com.portFolioBackend.controller;

import com.portFolioBackend.entity.Estudio;
import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.service.IUsuarioService;
import com.portFolioBackend.service.IEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EstudioController {
    
    //Inyectar dependencias
    @Autowired
    private IEstudioService estudioServ; //Estudios
    
    @Autowired
    private IUsuarioService usuarioServ;
    
    //Peticiones Http para Estudio
    
    @PostMapping("/user/new/estudio/{userId}") 
    public ResponseEntity<?> agregarEstudio(@PathVariable Integer userId, @RequestBody Estudio est){
        Usuario user = usuarioServ.buscarUsuario(userId);
        est.setUser(user);
        estudioServ.crearEstudio(est);
        return new ResponseEntity<>("Estudio Creado",HttpStatus.CREATED);
    }
    
    @GetMapping("/ver/estudios") 
    @ResponseBody
    public ResponseEntity<List<Estudio>> verEstudios(){
        return new ResponseEntity<>(estudioServ.verEstudios(),HttpStatus.OK);
    }
    
    @DeleteMapping("/user/delete/estudio/{id}")
    public ResponseEntity<HttpStatus> borrarEstudio(@PathVariable() Integer id){
        estudioServ.borrarEstudio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/user/actualizar/estudio/{id}")
    public ResponseEntity<?> actualizarEstudio(@PathVariable Integer id,@RequestBody Estudio est){
        Usuario user = usuarioServ.buscarUsuario(id);
        est.setUser(user);
        estudioServ.actualizarEstudio(est);
        return new ResponseEntity<>("Estudio Actualizado",HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
}
