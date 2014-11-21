/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.controllers;

import haams.ejb.entities.InstitutionProgram;
import haams.ejb.entities.InstitutionSubject;
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
@Named(value = "academicCoursesView")
@ViewScoped
public class AcademicCoursesView {

    @Inject private CrudService crudService;
    
    List<InstitutionProgram> institutionProgramList;    
      
    @PostConstruct
    public void init() {

        institutionProgramList = crudService.findAll(InstitutionProgram.class, false);

    }

    public List<InstitutionProgram> getInstitutionProgramList() {
        return institutionProgramList;
    }

    
}
