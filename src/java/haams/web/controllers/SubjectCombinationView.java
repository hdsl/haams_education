/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.SubjectGroup;
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
@Named
@ViewScoped
public class SubjectCombinationView {

    @Inject
    private CrudService crudService;

    private List<SubjectGroup> subjectGroupList;

    @PostConstruct
    public void init() {

        subjectGroupList = crudService.findAll(SubjectGroup.class, false);

    }

    public List<SubjectGroup> getSubjectGroupList() {
        return subjectGroupList;
    }

}
