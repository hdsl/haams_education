/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicYear;
import haams.ejb.entities.CommonEntity;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import java.util.Date;
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
public class AcademicYearController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    private Conversation conversation;

    String saveEditButtonText = "Save";

    AcademicYear academicYear = new AcademicYear();

    Date beginDate, endDate;

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public AcademicYearController() {
    }

    private void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public void saveEditButtonAction() {

        if (saveEditButtonText.equals("Save")) {

            Integer yearBegin = beginDate.getYear() + 1900;
            Integer yearEnd = endDate.getYear() + 1900;

            academicYear.setCommonId(yearBegin.toString() + "/" + yearEnd.toString());
            academicYear.setAcademicYearBegin(beginDate);
            academicYear.setAcademicYearEnd(endDate);

            CommonEntity saveSuccess = crudService.save(academicYear);

            if (saveSuccess != null) {
                StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
            }
        } else if (saveEditButtonText.equals("Update")) {

            academicYear.setAcademicYearBegin(beginDate);
            academicYear.setAcademicYearEnd(endDate);

            boolean updateSuccess = crudService.update(academicYear);

            if (updateSuccess) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }

    }

    public void deleteButtonAction(AcademicYear academicYear) {

        beginConversation();
        boolean deleteSuccess = crudService.delete(academicYear, false);

        if (deleteSuccess) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
        
    }

    public void resetButtonAction() {
        endConversation();
        beginDate = null;
        endDate = null;
        saveEditButtonText = "Save";
        academicYear = new AcademicYear();
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(AcademicYear academicYear) {

        beginConversation();

        this.academicYear = academicYear;

        beginDate = academicYear.getAcademicYearBegin();

        endDate = academicYear.getAcademicYearEnd();

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

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //</editor-fold>
    
}
