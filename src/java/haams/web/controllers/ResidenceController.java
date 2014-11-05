/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.SchoolHouse;
import haams.ejb.services.CrudService;
import haams.web.utils.ActionButtonText;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@ConversationScoped
public class ResidenceController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    
    @Inject 
    private CrudService crudService;
    
    @Inject
    private Conversation conversation;
    
    String saveEditButtonText = "Save";

    SchoolHouse schoolHouse = new SchoolHouse();

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public ResidenceController() {
    }
    
   
    public void beginConversation() {

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
        
        beginConversation();
        
        if (saveEditButtonText.equals("Save")) {

            schoolHouse.setCommonId(StringConstants.generateID());

            if (crudService.save(schoolHouse) != null) {
                StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                resetButtonAction();
            }
        } else  if (saveEditButtonText.equals("Update")) {

            if (crudService.update(schoolHouse)) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }

        }
    }

    public void deleteButtonAction(SchoolHouse sh) {
        
        this.schoolHouse = sh;
        
        if (crudService.delete(schoolHouse, false)) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
        
    }

    public void resetButtonAction() {
        saveEditButtonText = "Save";
        schoolHouse = new SchoolHouse();
        endConversation();
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(SchoolHouse sh) {
        
        beginConversation();
        
        this.schoolHouse = sh;
        
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

    public SchoolHouse getSchoolHouse() {
        return schoolHouse;
    }

    public void setSchoolHouse(SchoolHouse schoolHouse) {
        this.schoolHouse = schoolHouse;
    }

//</editor-fold>
}
