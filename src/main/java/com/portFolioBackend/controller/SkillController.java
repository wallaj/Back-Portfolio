
package com.portFolioBackend.controller;

import com.portFolioBackend.entity.Skill;
import com.portFolioBackend.security.entity.Usuario;
import com.portFolioBackend.security.service.IUsuarioService;
import com.portFolioBackend.service.ISkillService;
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
public class SkillController {
    @Autowired
    private ISkillService skillServ; //Skills
    
    @Autowired
    private IUsuarioService usuarioServ;
    
    //Peticiones Http para Skills
   
    @PostMapping("/user/new/skill/{userId}") 
    public ResponseEntity<?> agregarSkill(@PathVariable Integer userId,@RequestBody Skill sk){
        Usuario user = usuarioServ.buscarUsuario(userId);
        sk.setUser(user);
        skillServ.crearSkill(sk);
        return new ResponseEntity<>("Skill Creada",HttpStatus.CREATED);
    }
    
    @GetMapping("/ver/skill") 
    @ResponseBody
    public ResponseEntity<List<Skill>> verSkills(){
        return new ResponseEntity<>(skillServ.verSkills(),HttpStatus.OK);
    }
    
    @DeleteMapping("/user/delete/skill/{id}")
    public ResponseEntity<HttpStatus> borrarSkill(@PathVariable Integer id){
        skillServ.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/user/actualizar/skill/{id}")
    public ResponseEntity<?> actualizarSkill(@PathVariable Integer id,@RequestBody Skill sk){
        Usuario user = usuarioServ.buscarUsuario(id);
        sk.setUser(user);
        skillServ.actualizarSkill(sk);
        return new ResponseEntity<>("Skill Actualizada",HttpStatus.OK);
    }
    
}
