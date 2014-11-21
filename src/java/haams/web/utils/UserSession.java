/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.utils;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.Setting;
import haams.ejb.entities.UserAccount;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@SessionScoped
public class UserSession implements Serializable
{
    private String username;
    private String accessRight;
    private Date sessionDate;
    private String academicTerm;
    private String academicYear;
    private String schoolName;
    private String schoolAddress;
    private List<EducationalInstitution> schoolConfig;
    
    private Setting setting;
    
    private UserAccount userAccount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public List<EducationalInstitution> getSchoolConfig() {
        return schoolConfig;
    }

    public void setSchoolConfig(List<EducationalInstitution> schoolConfig) {
        this.schoolConfig = schoolConfig;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
}
