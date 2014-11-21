/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.AccessRight;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.Setting;
import haams.ejb.entities.UserAccount;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.utils.NavHandler;
import haams.web.utils.StringConstants;
import haams.web.utils.UserSession;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@RequestScoped
public class LoginController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private UserSession userSession;
    
    @Inject
    private NavHandler navHandler;
    
    @Inject
    private CrudService crudService;
    
    @Inject
    private CustomCrudService customCrudService;

    String username, password, accessRight, staffName, currentTerm;
    
    Date sessionDate;
    
    UserAccount userAccount = new UserAccount();
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public LoginController() {
    }

    public String login() {

        if (username == null || "".equals(username)) {
            StringConstants.showApprioprateMessage("Username field is empty");
            return "pretty:login";
        } else if (password == null || "".equals(password)) {
            StringConstants.showApprioprateMessage("Password field is empty");
            return "pretty:login";
        } else {

            String hashedPassword = StringConstants.hashGeneratedPassword(password);

            userAccount = customCrudService.getUserAccount(username, hashedPassword);

            if (userAccount == null) {
                StringConstants.showApprioprateMessage("Username or Password is invalid");
                return "pretty:login";
            } else {

                userSession.setUserAccount(userAccount);
                
                Setting setting = crudService.find(Setting.class, "CURRENT_TERM");

                currentTerm = setting.getSettingsValue();
                sessionDate = Calendar.getInstance().getTime();

                AccessRight ar = crudService.find(AccessRight.class, userAccount.getAccessRight());

                InstitutionStaff staff = crudService.find(InstitutionStaff.class, userAccount.getStaffId());
                staffName = staff.getSurname() + " " + staff.getOtherName();

                userSession.setUsername(staffName);
                userSession.setSessionDate(sessionDate);
                userSession.setAcademicTerm(currentTerm);
                userSession.setAcademicYear(crudService.find(AcademicTerm.class, currentTerm).getAcademicYear());

                List<EducationalInstitution> configuration = crudService.findAll(EducationalInstitution.class, true);

                userSession.setSchoolName(configuration.get(0).getInstitutionName());
                userSession.setSchoolAddress(configuration.get(0).getInstitutionAddress());
                userSession.setSchoolConfig(configuration);
                userSession.setSetting(setting);

                if (ar.getAccessRightId().equals("10")) {
                    
                    accessRight = "System Administrator";
                    userSession.setAccessRight(accessRight);
                    
                    navHandler.setModule("sysadmin");
                    navHandler.setPage("welcome");
                    
                    return "pretty:home";
                    
                } else if (ar.getAccessRightId().equals("20")) {
//                    menuConfiguration.enableSchoolAdminMenus();
                    accessRight = "School Administrator";
                    return "welcome.xhtml?faces-redirect=true";

                } else if (ar.getAccessRightId().equals("30")) {
//                    menuConfiguration.enableSchoolAdminMenus();
                    accessRight = "Subject Teacher";
                    navHandler.setModule("teachingStaff");
                    userSession.setAccessRight(accessRight);
                    return "/pages/welcome.xhtml?faces-redirect=true";
                
                } else if (ar.getAccessRightId().equals("40")) {
//                    menuConfiguration.enableSchoolAdminMenus();
                    accessRight = "Subject/Class Teacher";
                    navHandler.setModule("classTeacher");
                    userSession.setAccessRight(accessRight);
                    return "/pages/welcome.xhtml?faces-redirect=true";
                }
                return null;
            }
        }
    }

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }


    //<editor-fold defaultstate="collapsed" desc="Change Password">
//    public String renderChangePasswordPage() {
//        userAccount = new UserAccount();
//        httpSession.invalidate();
//        return "../../change_password.xhtml?faces-redirect=true";
//    }
    //</editor-fold>

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(String currentTerm) {
        this.currentTerm = currentTerm;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>

}
