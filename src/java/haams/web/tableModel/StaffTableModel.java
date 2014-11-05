/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.tableModel;

import java.util.Date;

/**
 *
 * @author AbdulMumin
 */
public class StaffTableModel {

    public String staffId;
    public String staffName;
    public String username;
    public String userAccountId;
    public String userAccessRight;
    public String staffPrimaryContact;
    public String staffEmailAddress;
    public String staffCategory;
    public String levelOfEducation;
    public String occupationStatus;
    public String gender;

    Date dateOfAppointment;
    
    Integer femaleTeachingStaff;
    Integer maleTeachingStaff;
    Integer femaleNonTeachingStaff;
    Integer maleNonTeachingStaff;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getUserAccessRight() {
        return userAccessRight;
    }

    public void setUserAccessRight(String userAccessRight) {
        this.userAccessRight = userAccessRight;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public Integer getFemaleTeachingStaff() {
        return femaleTeachingStaff;
    }

    public void setFemaleTeachingStaff(Integer femaleTeachingStaff) {
        this.femaleTeachingStaff = femaleTeachingStaff;
    }

    public Integer getMaleTeachingStaff() {
        return maleTeachingStaff;
    }

    public void setMaleTeachingStaff(Integer maleTeachingStaff) {
        this.maleTeachingStaff = maleTeachingStaff;
    }

    public Integer getFemaleNonTeachingStaff() {
        return femaleNonTeachingStaff;
    }

    public void setFemaleNonTeachingStaff(Integer femaleNonTeachingStaff) {
        this.femaleNonTeachingStaff = femaleNonTeachingStaff;
    }

    public Integer getMaleNonTeachingStaff() {
        return maleNonTeachingStaff;
    }

    public void setMaleNonTeachingStaff(Integer maleNonTeachingStaff) {
        this.maleNonTeachingStaff = maleNonTeachingStaff;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPrimaryContact() {
        return staffPrimaryContact;
    }

    public void setStaffPrimaryContact(String staffPrimaryContact) {
        this.staffPrimaryContact = staffPrimaryContact;
    }

    public String getStaffEmailAddress() {
        return staffEmailAddress;
    }

    public void setStaffEmailAddress(String staffEmailAddress) {
        this.staffEmailAddress = staffEmailAddress;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public String getOccupationStatus() {
        return occupationStatus;
    }

    public void setOccupationStatus(String occupationStatus) {
        this.occupationStatus = occupationStatus;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

}
