/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicYear;
import haams.ejb.entities.SchoolHouse;
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
@Named(value = "residenceView")
@ViewScoped
public class ResidenceView implements Serializable {

    @Inject
    private CrudService crudService;

    private List<SchoolHouse> studentResidenceList;

    @PostConstruct
    public void init() {

        studentResidenceList = crudService.findAll(SchoolHouse.class, false);

    }

    public List<SchoolHouse> getStudentResidenceList() {
        return studentResidenceList;
    }

}
