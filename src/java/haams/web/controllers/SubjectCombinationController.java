/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.InstitutionProgram;
import haams.ejb.entities.InstitutionSubject;
import haams.ejb.entities.SubjectGroup;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

/**
 *
 * @author AbdulMumin
 */
@Named
@SessionScoped
public class SubjectCombinationController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    Conversation conversation;

    String saveEditButtonText = "Save", courseCode, subjectsIds;

    SubjectGroup subjectGroup = new SubjectGroup();

    private DualListModel<String> academicSubjects;

    List<String> academicSubjectsSource;

    List<String> academicSubjectsTarget;

    private List<InstitutionSubject> combinationSubjectList = new LinkedList<>();

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public SubjectCombinationController() {

    }

    @PostConstruct
    public void init() {

        academicSubjectsSource = new ArrayList<>();
        academicSubjectsTarget = new ArrayList<>();

        List<InstitutionSubject> institutionSubjectList = crudService.findAll(InstitutionSubject.class, true);

        for (InstitutionSubject es : institutionSubjectList) {
            academicSubjectsSource.add(es.getSubjectName());
        }

        academicSubjects = new DualListModel<>(academicSubjectsSource, academicSubjectsTarget);

    }

    public void saveEditButtonAction() {

        if (saveEditButtonText.equals("Save")) {

            if (courseCode == null) {
                StringConstants.showApprioprateMessage("Please select the academic course");
            } else {

                String subjectsId = "";

                List<String> target = academicSubjects.getTarget();

                if (target.size() > 0) {

                    for (String s : target) {

                        InstitutionSubject es = customCrudService.find(InstitutionSubject.class, "subjectName", s);

                        subjectsId = es.getCommonId() + "/" + subjectsId;
                    }
                }

                subjectGroup.setCommonId(StringConstants.generateID());
                subjectGroup.setInstitutionProgram(crudService.find(InstitutionProgram.class, courseCode));
                subjectGroup.setSubjectsIds(subjectsId);

                if (crudService.save(subjectGroup) != null) {
                    StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                    resetButtonAction();
                } else {
                    StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                }
            }
        } else {

            String subjectsId = "";

            List<String> target = academicSubjects.getTarget();

            if (target.size() > 0) {

                for (String s : target) {
                    InstitutionSubject es = customCrudService.find(InstitutionSubject.class, "subjectName", s);
                    subjectsId = es.getCommonId() + "/" + subjectsId;
                }
            }

            subjectGroup.setInstitutionProgram(crudService.find(InstitutionProgram.class, courseCode));
            subjectGroup.setSubjectsIds(subjectsId);

            if (crudService.update(subjectGroup)) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }

    }

    public void deleteButtonAction(SubjectGroup sg) {

        this.subjectGroup = sg;

        if (crudService.delete(subjectGroup, false)) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
    }

    public void resetButtonAction() {
        saveEditButtonText = "Save";
        subjectGroup = new SubjectGroup();
        courseCode = "";
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(SubjectGroup sg) {

        this.subjectGroup = sg;

        academicSubjectsSource = new ArrayList<>();
        academicSubjectsTarget = new ArrayList<>();

        saveEditButtonText = "Update";

        courseCode = subjectGroup.getInstitutionProgram().getCommonId();

        subjectsIds = subjectGroup.getSubjectsIds();

        List<InstitutionSubject> combinationSubject = getCombinationSubjectList();

        List<InstitutionSubject> schoolSubjectList = crudService.findAll(InstitutionSubject.class, false);

        if (combinationSubject == null) {
            return;
        }

        for (InstitutionSubject subjectCheck : combinationSubject) {
            schoolSubjectList.remove(subjectCheck);
        }

        for (InstitutionSubject subject1 : schoolSubjectList) {
            academicSubjectsSource.add(subject1.getSubjectName());
        }

        for (InstitutionSubject subject : combinationSubject) {
            academicSubjectsTarget.add(subject.getSubjectName());
        }

        academicSubjects = new DualListModel<>(academicSubjectsSource, academicSubjectsTarget);

    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public List<InstitutionSubject> getCombinationSubjectList() {

        combinationSubjectList.clear();

        if (subjectsIds == null) {
            return combinationSubjectList;
        }

        String[] subjectCodes = subjectsIds.split("/");

        for (String subjectCode : subjectCodes) {

            InstitutionSubject schoolSubject = crudService.find(InstitutionSubject.class, subjectCode);

            if (schoolSubject != null) {
                combinationSubjectList.add(schoolSubject);
            }
        }
        return combinationSubjectList;
    }

    public void setCombinationSubjectList(List<InstitutionSubject> combinationSubjectList) {
        this.combinationSubjectList = combinationSubjectList;

        subjectsIds = "";

        for (InstitutionSubject schoolSubject : combinationSubjectList) {
            subjectsIds = subjectsIds + "/" + schoolSubject.getCommonId();
        }

    }

    public DualListModel<String> getAcademicSubjects() {
        return academicSubjects;
    }

    public String getSaveEditButtonText() {
        return saveEditButtonText;
    }

    public CrudService getCrudService() {
        return crudService;
    }

    public void setCrudService(CrudService crudService) {
        this.crudService = crudService;
    }

    public CustomCrudService getCustomCrudService() {
        return customCrudService;
    }

    public void setCustomCrudService(CustomCrudService customCrudService) {
        this.customCrudService = customCrudService;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public String getSubjectsIds() {
        return subjectsIds;
    }

    public void setSubjectsIds(String subjectsIds) {
        this.subjectsIds = subjectsIds;
    }

    public List<String> getAcademicSubjectsSource() {
        return academicSubjectsSource;
    }

    public void setAcademicSubjectsSource(List<String> academicSubjectsSource) {
        this.academicSubjectsSource = academicSubjectsSource;
    }

    public List<String> getAcademicSubjectsTarget() {
        return academicSubjectsTarget;
    }

    public void setAcademicSubjectsTarget(List<String> academicSubjectsTarget) {
        this.academicSubjectsTarget = academicSubjectsTarget;
    }

    public void setSaveEditButtonText(String saveEditButtonText) {
        this.saveEditButtonText = saveEditButtonText;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public SubjectGroup getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(SubjectGroup subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

    public void setAcademicSubjects(DualListModel<String> academicSubjects) {
        this.academicSubjects = academicSubjects;
    }
//</editor-fold>

}
