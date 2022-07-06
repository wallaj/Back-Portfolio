
package com.portFolioBackend.controller;

import com.portFolioBackend.entity.ExperienciaLab;
import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.service.IUsuarioService;
import com.portFolioBackend.service.IExperienciaLabService;
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
public class ExperienciaController {
    @Autowired
    private IExperienciaLabService experienciaLabServ; //ExperienciasLab
    
    @Autowired 
    private IUsuarioService usuarioServ;
    
    //Peticiones Http para ExperienciasLab
    
    
    @PostMapping("/user/new/experiencia/{userId}") 
    public ResponseEntity<?> agregarExperienciaLab(@PathVariable Integer userId,@RequestBody ExperienciaLab expLab){
        Usuario user = usuarioServ.buscarUsuario(userId);
        expLab.setUser(user);
        experienciaLabServ.crearExperienciaLab(expLab);
        return new ResponseEntity<>("Experiencia de Trabajo Creada",HttpStatus.CREATED);
    }
    
    @GetMapping("/ver/experiencias") 
    @ResponseBody
    public ResponseEntity<List<ExperienciaLab>> verExperienciasLab(){
        return new ResponseEntity<>(experienciaLabServ.verExperienciasLab(),HttpStatus.OK);
    }
    
    @DeleteMapping("/user/delete/experiencia/{id}")
    public ResponseEntity<HttpStatus> borrarExperiencia(@PathVariable Integer id){
        experienciaLabServ.borrarExperienciaLab(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/user/actualizar/experiencia/{id}")
    public ResponseEntity<?> actualizarExperiencia(@PathVariable Integer id,@RequestBody ExperienciaLab expLab){
        Usuario user = usuarioServ.buscarUsuario(id);
        expLab.setUser(user);
        experienciaLabServ.actualizarExperienciaLab(expLab);
        return new ResponseEntity<>("Experiencia de Trabajo Actualizada",HttpStatus.OK);
    }
}
