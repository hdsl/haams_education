/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.InstitutionSubject;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@ConversationScoped
public class SubjectsController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    Conversation conversation;

    String saveEditButtonText = "Save", subjectCode="";

    InstitutionSubject institutionSubject = new InstitutionSubject();

    DataModel<InstitutionSubject> institutionSubjectDataModel;

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public SubjectsController() {
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

            if (subjectCode.equals("")) {
                StringConstants.showApprioprateMessage("Subject Code is required");
            } else {

                institutionSubject.setCommonId(subjectCode);

                InstitutionSubject block = crudService.find(InstitutionSubject.class, subjectCode);

                if (block == null) {

                    if (crudService.save(institutionSubject) != null) {
                        StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                        resetButtonAction();
                    } else {
                        StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                        resetButtonAction();
                    }
                } else {
                    StringConstants.showApprioprateMessage("Subject Code already exist");
                }

            }
        } else {

            if (crudService.update(institutionSubject)) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }

        }
    }

    public void deleteButtonAction(InstitutionSubject subject) {

        startConversation();

        this.institutionSubject = subject;

        if (crudService.delete(institutionSubject, false)) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
    }

    public void resetButtonAction() {

        startConversation();

        saveEditButtonText = "Save";
        institutionSubject = new InstitutionSubject();
        subjectCode = "";
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(InstitutionSubject subject) {

        startConversation();

        this.institutionSubject = subject;

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

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public InstitutionSubject getInstitutionSubject() {
        return institutionSubject;
    }

    public void setInstitutionSubject(InstitutionSubject institutionSubject) {
        this.institutionSubject = institutionSubject;
    }

//</editor-fold>
}
