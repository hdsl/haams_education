/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.controllers;

import haams.ejb.entities.InstitutionClass;
import haams.ejb.services.CrudService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author HDSL_MUMIN
 */
@Named(value = "classRoomView")
@ViewScoped
public class ClassRoomView {
    
    @Inject
    private CrudService crudService;
    
    private List<InstitutionClass> institutionClassList;
    
    @PostConstruct
    public void init(){
        
        institutionClassList = crudService.findAll(InstitutionClass.class, false);
        
    }

    public List<InstitutionClass> getInstitutionClassList() {
        return institutionClassList;
    }
    
    
    
}
