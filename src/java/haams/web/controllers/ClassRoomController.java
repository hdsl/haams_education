/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicLevel;
import haams.ejb.entities.CommonEntity;
import haams.ejb.entities.InstitutionClass;
import haams.ejb.entities.InstitutionProgram;
import haams.ejb.services.CrudService;
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
public class ClassRoomController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    
    @Inject private CrudService crudService;
    
    @Inject Conversation conversation;
    
    String saveEditButtonText = "Save", courseCode, classId;
    
    AcademicLevel academicLevel = new AcademicLevel();
    
    InstitutionClass institutionClass = new InstitutionClass();
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public ClassRoomController() {
    }

    public void startConversation(){
        
        if(conversation.isTransient()){
            conversation.begin();
        }
    }
    
    public void endConversation(){
        
        if(!conversation.isTransient()){
            conversation.end();
        }
    }
    
    public void saveEditButtonAction() {

        startConversation();
        
        if (saveEditButtonText.equals("Save")) {

            if (courseCode == null) {
                StringConstants.showApprioprateMessage("Course Code is required");
            } else {

                institutionClass.setCommonId(classId);
                institutionClass.setClassName(classId);
                institutionClass.setInstitutionProgram(crudService.find(InstitutionProgram.class, courseCode));

                InstitutionClass block = crudService.find(InstitutionClass.class, classId);

                if (block == null) {

                    CommonEntity saveSuccess = crudService.save(institutionClass);

                    if (saveSuccess != null) {
                        StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                        resetButtonAction();
                    } else {
                        StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                        resetButtonAction();
                    }
                } else {
                    StringConstants.showApprioprateMessage("Class Name already exist");
                }

            }

        } else if (saveEditButtonText.equals("Update")) {

            boolean updateSuccess = crudService.update(institutionClass);

            if (updateSuccess) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }
    }

    public void deleteButtonAction(InstitutionClass ic) {

        startConversation();
        
          this.institutionClass = ic;
        
        boolean deleteSuccess = crudService.delete(institutionClass, false);

        if (deleteSuccess) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
    }

    public void resetButtonAction() {
        
        endConversation();
        
        institutionClass = new InstitutionClass();
        saveEditButtonText = "Save";
        courseCode = "";
        classId = "";
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(InstitutionClass ic) {

        startConversation();
        
        this.institutionClass = ic;
        
        classId = institutionClass.getClassName();
        
        courseCode = institutionClass.getInstitutionProgram().getCommonId();

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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public InstitutionClass getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(InstitutionClass institutionClass) {
        this.institutionClass = institutionClass;
    }

//</editor-fold>

}
