
package com.portFolioBackend.service;

import com.portFolioBackend.model.Skill;
import java.util.List;

/**
 *
 * @author Marcos
 */
public interface ISkillService {
    public List<Skill> verSkills();
    public void crearSkill(Skill sk);
    public void borrarSkill(Integer id);
    public Skill buscarSkill(Integer id);
    public void actualizarSkill(Skill sk);
}
