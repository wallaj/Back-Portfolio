
package com.portFolioBackend.controller;

import com.portFolioBackend.model.Estudio;
import com.portFolioBackend.model.ExperienciaLab;
import com.portFolioBackend.model.Proyecto;
import com.portFolioBackend.model.Skill;
import com.portFolioBackend.model.Usuario;
import com.portFolioBackend.service.IEstudioService;
import com.portFolioBackend.service.IExperienciaLabService;
import com.portFolioBackend.service.IProyectoService;
import com.portFolioBackend.service.ISkillService;
import com.portFolioBackend.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    //Inyectar dependencias
    @Autowired
    private IEstudioService estudioServ; //Estudios
    @Autowired
    private IExperienciaLabService experienciaLabServ; //ExperienciasLab
    @Autowired
    private IProyectoService proyectoServ; //Proyectos
    @Autowired
    private ISkillService skillServ; //Skills
    @Autowired
    private  IUsuarioService usuarioServ; //Usuario
    
    //Peticiones Http para Estudios
    @PostMapping("/new/estudio") 
    public void agregarEstudio(@RequestBody Estudio est){
        estudioServ.crearEstudio(est);
    }
    
    @GetMapping("/ver/estudios") 
    @ResponseBody
    public List<Estudio> verEstudios(){
        return estudioServ.verEstudios();
    }
    
    @DeleteMapping("/delete/estudio/{id}")
    public void borrarEstudio(@PathVariable Integer id){
        estudioServ.borrarEstudio(id);
    }
    
    @PutMapping("/actualizar/estudio")
    public void actualizarEstudio(@RequestBody Estudio est){
        estudioServ.actualizarEstudio(est);
    }
    
    //Peticiones Http para ExperienciasLab
    @PostMapping("/new/experiencia") 
    public void agregarExperienciaLab(@RequestBody ExperienciaLab expLab){
        experienciaLabServ.crearExperienciaLab(expLab);
    }
    
    @GetMapping("/ver/experiencias") 
    @ResponseBody
    public List<ExperienciaLab> verExperienciasLab(){
        return experienciaLabServ.verExperienciasLab();
    }
    
    @DeleteMapping("/delete/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Integer id){
        experienciaLabServ.borrarExperienciaLab(id);
    }
    
    @PutMapping("/actualizar/experiencia")
    public void actualizarExperiencia(@RequestBody ExperienciaLab expLab){
        experienciaLabServ.actualizarExperienciaLab(expLab);
    }
    
    //Peticiones Http para Proyectos
    @PostMapping("/new/proyecto") 
    public void agregarProyecto(@RequestBody Proyecto pro){
        proyectoServ.crearProyecto(pro);
    }
    
    @GetMapping("/ver/proyectos") 
    @ResponseBody
    public List<Proyecto> verProyectos(){
        return proyectoServ.verProyectos();
    }
    
    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Integer id){
        proyectoServ.borrarProyecto(id);
    }
    
    @PutMapping("/actualizar/proyecto")
    public void actualizarProyecto(@RequestBody Proyecto pro){
        proyectoServ.actualizarProyecto(pro);
    }
    
    //Peticiones Http para Skills
    @PostMapping("/new/skill") 
    public void agregarSkill(@RequestBody Skill sk){
        skillServ.crearSkill(sk);
    }
    
    @GetMapping("/ver/skill") 
    @ResponseBody
    public List<Skill> verSkills(){
        return skillServ.verSkills();
    }
    
    @DeleteMapping("/delete/skill/{id}")
    public void borrarSkill(@PathVariable Integer id){
        skillServ.borrarSkill(id);
    }
    
    @PutMapping("/actualizar/skill")
    public void actualizarSkill(@RequestBody Skill sk){
        skillServ.actualizarSkill(sk);
    }
    
    //Peticiones Http para Usuarios
    @PostMapping("/new/user") 
    public void agregarUsuario(@RequestBody Usuario user){
        usuarioServ.crearUsuario(user);
    }
    
    @GetMapping("/ver/user") 
    @ResponseBody
    public List<Usuario> verUsuarios(){
        return usuarioServ.verUsuarios();
    }
    
    @DeleteMapping("/delete/user/{id}")
    public void borrarUsuario(@PathVariable Integer id){
       usuarioServ.borrarUsuario(id);
    }
    
    @PutMapping("/actualizar/user")
    public void actualizarUsuario(@RequestBody Usuario user){
        usuarioServ.actualizarUsuario(user);
    }
}
