
package com.portFolioBackend.controller;

import com.portFolioBackend.entity.Proyecto;
import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.service.IUsuarioService;
import com.portFolioBackend.service.IProyectoService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoServ; //Proyectos
    
    @Autowired
    private IUsuarioService usuarioServ;
    
    //Peticiones Http para Proyectos
   
    @PostMapping("/user/new/proyecto/{userId}") 
    public ResponseEntity<?> agregarProyecto(@PathVariable Integer userId, @RequestBody Proyecto pro){
        Usuario user = usuarioServ.buscarUsuario(userId);
        pro.setUser(user);
        proyectoServ.crearProyecto(pro);
        return new ResponseEntity<>("Proyecto Creado",HttpStatus.CREATED);
    }
    
    @GetMapping("/ver/proyectos") 
    @ResponseBody
    public ResponseEntity<List<Proyecto>> verProyectos(){
        return new ResponseEntity<>(proyectoServ.verProyectos(), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/user/delete/proyecto/{id}")
    public ResponseEntity<HttpStatus> borrarProyecto(@PathVariable Integer id){
        proyectoServ.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/user/actualizar/proyecto/{id}")
    public ResponseEntity<?> actualizarProyecto(@PathVariable Integer id,@RequestBody Proyecto pro){
        Usuario user = usuarioServ.buscarUsuario(id);
        pro.setUser(user);
        proyectoServ.actualizarProyecto(pro);
        return new ResponseEntity<>("Poyecto Actualizado",HttpStatus.OK);
    }
}
