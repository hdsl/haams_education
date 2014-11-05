/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.controllers;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.services.CrudService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author HDSL_MUMIN
 */
@Named(value = "academicTermView")
@ViewScoped
public class AcademicTermView implements Serializable{

    @Inject
    private CrudService crudService;
    
    private List<AcademicTerm> academicTermList;
    
    @PostConstruct
    public void init(){
        
        academicTermList = crudService.findAll(AcademicTerm.class, false);
        
    }

    public List<AcademicTerm> getAcademicTermList() {
        return academicTermList;
    }
    
}
