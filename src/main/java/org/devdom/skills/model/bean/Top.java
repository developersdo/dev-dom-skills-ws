package org.devdom.skills.model.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.devdom.skills.model.dao.SkillsDao;
import org.devdom.skills.model.dto.Skills;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@ManagedBean
@SessionScoped
public class Top implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private final SkillsDao dao = new SkillsDao();

    public List<Skills> getSkills(){
        return dao.findAllSkillsByTopFilters(0,0,10);
    }
    
    public List<Skills> getLanguages(){
        return dao.findAllSkillsByTopFilters(5,0,10);
    }
    
}