/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.Setting;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@ConversationScoped
public class SettingController implements Serializable {

    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    String academicTerm;

    public SettingController() {
    }

    public void setCurrentTerm() {

        Setting setting = crudService.find(Setting.class, "CURRENT_TERM");

        setting.setSettingsValue(academicTerm);

        boolean updateSuccess = crudService.update(setting);

        if (updateSuccess) {
            StringConstants.showApprioprateMessage("Current Academic Term has been set to " + academicTerm);
            StringConstants.showApprioprateMessage("Please restart application to effect changes ");
            academicTerm = "";
        } else {
            StringConstants.showApprioprateMessage("Unable to set current academic term to " + academicTerm);
        }
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

}
