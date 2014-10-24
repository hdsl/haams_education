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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HDSL_MUMIN
 */
@Entity
@Table(name = "institution_staff", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitutionStaff.findAll", query = "SELECT i FROM InstitutionStaff i"),
    @NamedQuery(name = "InstitutionStaff.findByStaffId", query = "SELECT i FROM InstitutionStaff i WHERE i.staffId = :staffId"),
    @NamedQuery(name = "InstitutionStaff.findBySurname", query = "SELECT i FROM InstitutionStaff i WHERE i.surname = :surname"),
    @NamedQuery(name = "InstitutionStaff.findByOtherName", query = "SELECT i FROM InstitutionStaff i WHERE i.otherName = :otherName"),
    @NamedQuery(name = "InstitutionStaff.findByGender", query = "SELECT i FROM InstitutionStaff i WHERE i.gender = :gender"),
    @NamedQuery(name = "InstitutionStaff.findByDateOfBirth", query = "SELECT i FROM InstitutionStaff i WHERE i.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "InstitutionStaff.findByNationality", query = "SELECT i FROM InstitutionStaff i WHERE i.nationality = :nationality"),
    @NamedQuery(name = "InstitutionStaff.findByHometown", query = "SELECT i FROM InstitutionStaff i WHERE i.hometown = :hometown"),
    @NamedQuery(name = "InstitutionStaff.findByRegionId", query = "SELECT i FROM InstitutionStaff i WHERE i.regionId = :regionId"),
    @NamedQuery(name = "InstitutionStaff.findByDisabilityStatus", query = "SELECT i FROM InstitutionStaff i WHERE i.disabilityStatus = :disabilityStatus"),
    @NamedQuery(name = "InstitutionStaff.findByEmailAddress", query = "SELECT i FROM InstitutionStaff i WHERE i.emailAddress = :emailAddress"),
    @NamedQuery(name = "InstitutionStaff.findByPrimaryContact", query = "SELECT i FROM InstitutionStaff i WHERE i.primaryContact = :primaryContact"),
    @NamedQuery(name = "InstitutionStaff.findByOtherContact", query = "SELECT i FROM InstitutionStaff i WHERE i.otherContact = :otherContact"),
    @NamedQuery(name = "InstitutionStaff.findByMaritalStatus", query = "SELECT i FROM InstitutionStaff i WHERE i.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "InstitutionStaff.findByHouseNumber", query = "SELECT i FROM InstitutionStaff i WHERE i.houseNumber = :houseNumber"),
    @NamedQuery(name = "InstitutionStaff.findByPostalLocation", query = "SELECT i FROM InstitutionStaff i WHERE i.postalLocation = :postalLocation"),
    @NamedQuery(name = "InstitutionStaff.findByNextOfKin", query = "SELECT i FROM InstitutionStaff i WHERE i.nextOfKin = :nextOfKin"),
    @NamedQuery(name = "InstitutionStaff.findByKinContact", query = "SELECT i FROM InstitutionStaff i WHERE i.kinContact = :kinContact"),
    @NamedQuery(name = "InstitutionStaff.findByRelationToKin", query = "SELECT i FROM InstitutionStaff i WHERE i.relationToKin = :relationToKin"),
    @NamedQuery(name = "InstitutionStaff.findByLevelOfEducation", query = "SELECT i FROM InstitutionStaff i WHERE i.levelOfEducation = :levelOfEducation"),
    @NamedQuery(name = "InstitutionStaff.findByStaffCategory", query = "SELECT i FROM InstitutionStaff i WHERE i.staffCategory = :staffCategory"),
    @NamedQuery(name = "InstitutionStaff.findByDateOfAppointment", query = "SELECT i FROM InstitutionStaff i WHERE i.dateOfAppointment = :dateOfAppointment"),
    @NamedQuery(name = "InstitutionStaff.findByOccupationStatus", query = "SELECT i FROM InstitutionStaff i WHERE i.occupationStatus = :occupationStatus"),
    @NamedQuery(name = "InstitutionStaff.findByUpdated", query = "SELECT i FROM InstitutionStaff i WHERE i.updated = :updated"),
    @NamedQuery(name = "InstitutionStaff.findByDeleted", query = "SELECT i FROM InstitutionStaff i WHERE i.deleted = :deleted"),
    @NamedQuery(name = "InstitutionStaff.findBySystemDate", query = "SELECT i FROM InstitutionStaff i WHERE i.systemDate = :systemDate")})
public class InstitutionStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "staff_id", nullable = false, length = 35)
    private String staffId;
    @Size(max = 45)
    @Column(name = "surname", length = 45)
    private String surname;
    @Size(max = 45)
    @Column(name = "other_name", length = 45)
    private String otherName;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 2)
    @Column(name = "nationality", length = 2)
    private String nationality;
    @Size(max = 45)
    @Column(name = "hometown", length = 45)
    private String hometown;
    @Size(max = 15)
    @Column(name = "region_id", length = 15)
    private String regionId;
    @Column(name = "disability_status")
    private Character disabilityStatus;
    @Lob
    @Size(max = 65535)
    @Column(name = "disability_detail", length = 65535)
    private String disabilityDetail;
    @Size(max = 45)
    @Column(name = "email_address", length = 45)
    private String emailAddress;
    @Size(max = 15)
    @Column(name = "primary_contact", length = 15)
    private String primaryContact;
    @Size(max = 15)
    @Column(name = "other_contact", length = 15)
    private String otherContact;
    @Size(max = 2)
    @Column(name = "marital_status", length = 2)
    private String maritalStatus;
    @Size(max = 79)
    @Column(name = "house_number", length = 79)
    private String houseNumber;
    @Lob
    @Size(max = 65535)
    @Column(name = "physical_location", length = 65535)
    private String physicalLocation;
    @Size(max = 79)
    @Column(name = "postal_location", length = 79)
    private String postalLocation;
    @Size(max = 79)
    @Column(name = "next_of_kin", length = 79)
    private String nextOfKin;
    @Size(max = 15)
    @Column(name = "kin_contact", length = 15)
    private String kinContact;
    @Size(max = 2)
    @Column(name = "relation_to_kin", length = 2)
    private String relationToKin;
    @Size(max = 2)
    @Column(name = "level_of_education", length = 2)
    private String levelOfEducation;
    @Lob
    @Size(max = 65535)
    @Column(name = "last_school_attended", length = 65535)
    private String lastSchoolAttended;
    @Size(max = 2)
    @Column(name = "staff_category", length = 2)
    private String staffCategory;
    @Column(name = "date_of_appointment")
    @Temporal(TemporalType.DATE)
    private Date dateOfAppointment;
    @Size(max = 15)
    @Column(name = "occupation_status", length = 15)
    private String occupationStatus;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public InstitutionStaff() {
    }

    public InstitutionStaff(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

    public Character getUpdated() {
        return updated;
    }

    public void setUpdated(Character updated) {
        this.updated = updated;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitutionStaff)) {
            return false;
        }
        InstitutionStaff other = (InstitutionStaff) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.InstitutionStaff[ staffId=" + staffId + " ]";
    }
    
}
