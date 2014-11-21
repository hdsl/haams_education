/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.InstitutionProgram;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@ConversationScoped
public class AcademicCoursesController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    Conversation conversation;

    String saveEditButtonText = "Save", courseCode;

    InstitutionProgram institutionProgram = new InstitutionProgram();

    List<InstitutionProgram> institutionProgramList;

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public AcademicCoursesController() {
//        institutionProgramList = new ArrayList<>();

    }

    public void startConversation() {

        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void endConversation() {

        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public void saveEditButtonAction() {

        startConversation();

        if (saveEditButtonText.equals("Save")) {

            if (courseCode == null) {
                StringConstants.showApprioprateMessage("Course Code is required");
            } else {

                institutionProgram.setCommonId(courseCode.toUpperCase());

                InstitutionProgram block = crudService.find(InstitutionProgram.class, courseCode.toUpperCase());

                if (block == null) {

                    if (crudService.save(institutionProgram) != null) {
                        StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                        resetButtonAction();
                    } else {
                        StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                        resetButtonAction();
                    }
                } else {
                    StringConstants.showApprioprateMessage("Course Code already exist");
                }

            }

        } else if (saveEditButtonText.equals("Update")) {

            if (crudService.update(institutionProgram)) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }
    }

    public void deleteButtonAction(InstitutionProgram program) {

        startConversation();

        this.institutionProgram = program;

        if (crudService.delete(institutionProgram, false)) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
    }

    public void resetButtonAction() {
        
        endConversation();
        
        institutionProgram = new InstitutionProgram();
        saveEditButtonText = "Save";
        courseCode = "";
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(InstitutionProgram program) {
        
        startConversation();
        
        this.institutionProgram = program;
        
        saveEditButtonText = "Update";
        
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getSaveEditButtonText() {
        return saveEditButtonText;
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

    public InstitutionProgram getInstitutionProgram() {
        return institutionProgram;
    }

    public void setInstitutionProgram(InstitutionProgram institutionProgram) {
        this.institutionProgram = institutionProgram;
    }

//</editor-fold>

}
