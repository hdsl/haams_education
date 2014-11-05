/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "institution_staff")
@NamedQueries({
    @NamedQuery(name = "InstitutionStaff.findAll", query = "SELECT i FROM InstitutionStaff i")})
public class InstitutionStaff extends CommonEntity {
   
    @Column(name = "surname")
    private String surname;
  
    @Column(name = "other_name")
    private String otherName;
    
    @Column(name = "gender")
    private Character gender;
    
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
  
    @Column(name = "nationality")
    private String nationality;
    
    @Column(name = "hometown")
    private String hometown;
    
    @Column(name = "region_id")
    private String regionId;
    
    @Column(name = "disability_status")
    private Character disabilityStatus;
 
    @Column(name = "disability_detail")
    private String disabilityDetail;
  
    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "primary_contact")
    private String primaryContact;

    @Column(name = "other_contact")
    private String otherContact;
  
    @Column(name = "marital_status")
    private String maritalStatus;
   
    @Column(name = "house_number")
    private String houseNumber;
   
    @Column(name = "physical_location")
    private String physicalLocation;
   
    @Column(name = "postal_location")
    private String postalLocation;
    
    @Column(name = "next_of_kin")
    private String nextOfKin;
    
    @Column(name = "kin_contact")
    private String kinContact;
  
    @Column(name = "relation_to_kin")
    private String relationToKin;
   
    @Column(name = "level_of_education")
    private String levelOfEducation;
 
    @Column(name = "last_school_attended")
    private String lastSchoolAttended;

    @Column(name = "staff_category")
    private String staffCategory;
    @Column(name = "date_of_appointment")
    @Temporal(TemporalType.DATE)
    private Date dateOfAppointment;
   
    @Column(name = "occupation_status")
    private String occupationStatus;

    public InstitutionStaff() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Character getDisabilityStatus() {
        return disabilityStatus;
    }

    public void setDisabilityStatus(Character disabilityStatus) {
        this.disabilityStatus = disabilityStatus;
    }

    public String getDisabilityDetail() {
        return disabilityDetail;
    }

    public void setDisabilityDetail(String disabilityDetail) {
        this.disabilityDetail = disabilityDetail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    public String getPostalLocation() {
        return postalLocation;
    }

    public void setPostalLocation(String postalLocation) {
        this.postalLocation = postalLocation;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getKinContact() {
        return kinContact;
    }

    public void setKinContact(String kinContact) {
        this.kinContact = kinContact;
    }

    public String getRelationToKin() {
        return relationToKin;
    }

    public void setRelationToKin(String relationToKin) {
        this.relationToKin = relationToKin;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getLastSchoolAttended() {
        return lastSchoolAttended;
    }

    public void setLastSchoolAttended(String lastSchoolAttended) {
        this.lastSchoolAttended = lastSchoolAttended;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getOccupationStatus() {
        return occupationStatus;
    }

    public void setOccupationStatus(String occupationStatus) {
        this.occupationStatus = occupationStatus;
    }

}
