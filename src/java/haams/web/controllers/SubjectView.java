/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.InstitutionSubject;
import haams.ejb.entities.SchoolHouse;
import haams.ejb.services.CrudService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author HDSL_MUMIN
 */
@Named(value = "subjectView")
@ViewScoped
public class SubjectView implements Serializable {

    @Inject
    private CrudService crudService;
    
    private List<InstitutionSubject> institutionSubjectList;
    
    @PostConstruct
    public void init() {

        institutionSubjectList = crudService.findAll(InstitutionSubject.class, false);

    }

    public List<InstitutionSubject> getInstitutionSubjectList() {
        return institutionSubjectList;
    }
    
    
}
