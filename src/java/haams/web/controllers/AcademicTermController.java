/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.SchoolTerm;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
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
public class AcademicTermController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    private Conversation conversation;

    String saveEditButtonText = "Save", schoolTerm = "";

    String academicYear = "", academicTermSelected;

    AcademicTerm academicTerm = new AcademicTerm();

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public AcademicTermController() {
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

            if (academicYear.equals("")) {
                StringConstants.showApprioprateMessage("Please select academic year");
            } else if (schoolTerm.equals("00")) {
                StringConstants.showApprioprateMessage("Please select academic term");
            } else {

                SchoolTerm schTerm = customCrudService.find(SchoolTerm.class, "termDesc", schoolTerm);

                academicTerm.setCommonId(academicYear + "/" + schTerm.getcommonId());
                academicTerm.setAcademicYear(academicYear);
                academicTerm.setTermDesc(schoolTerm);
                academicTerm.setActiveTerm('N');

                if (crudService.save(academicTerm) != null) {

                    StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                    resetButtonAction();
                } else {
                    StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                }
            }
        } else {

            academicTerm.setAcademicYear(academicYear);
            academicTerm.setTermDesc(schoolTerm);

            if (crudService.save(academicTerm) != null) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }
    }

    public void deleteButtonAction(AcademicTerm at) {

        if (crudService.delete(at, true)) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
    }

    public void resetButtonAction() {
        endConversation();
        schoolTerm = "";
        academicYear = "";
        saveEditButtonText = "Save";
        academicTerm = new AcademicTerm();
        academicTermSelected = "";
    }

    public void searchButtonAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rowSelectDataAction(AcademicTerm at) {

        beginConversation();
        
        this.academicTerm = at;

        academicYear = academicTerm.getAcademicYear();
        schoolTerm = academicTerm.getTermDesc();

        saveEditButtonText = "Update";

//        academicTermSelected = "Set Selected term  [" + academicTerm.getAcademicTermId() + "]  as the current term";
    }

//    public void setCurrentAcademicTerm() {
//
//        List<AcademicTerm> academicTermList = dataSource.getCustomQry().getCurrentAcademicTerm();
//
//        if (academicTermList.size() > 0) {
//
//            for (AcademicTerm at : academicTermList) {
//                at.setActiveTerm('N');
//                dataSource.getCommonQry().academicTermUpdate(at);
//            }
//        }
//
//        academicTerm.setActiveTerm('Y');
//
//        boolean updateSuccess = dataSource.getCommonQry().academicTermUpdate(academicTerm);
//
//        if (updateSuccess) {
//            StringConstants.showApprioprateMessage("Current Academic Term has been set to " + academicTerm.getAcademicTermId());
//            resetButtonAction();
//        } else {
//            StringConstants.showApprioprateMessage("Unable to set current academic term to " + academicTerm.getAcademicTermId());
//        }
//
//    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getSaveEditButtonText() {
        return saveEditButtonText;
    }

    public void setSaveEditButtonText(String saveEditButtonText) {
        this.saveEditButtonText = saveEditButtonText;
    }

    public String getAcademicTermSelected() {
        return academicTermSelected;
    }

    public void setAcademicTermSelected(String academicTermSelected) {
        this.academicTermSelected = academicTermSelected;
    }

    public String getSchoolTerm() {
        return schoolTerm;
    }

    public void setSchoolTerm(String schoolTerm) {
        this.schoolTerm = schoolTerm;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public AcademicTerm getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(AcademicTerm academicTerm) {
        this.academicTerm = academicTerm;
    }

//</editor-fold>
}
