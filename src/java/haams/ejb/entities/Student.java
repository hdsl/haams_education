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
@Table(name = "student", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findBySurname", query = "SELECT s FROM Student s WHERE s.surname = :surname"),
    @NamedQuery(name = "Student.findByOthernames", query = "SELECT s FROM Student s WHERE s.othernames = :othernames"),
    @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender"),
    @NamedQuery(name = "Student.findByDateOfbirth", query = "SELECT s FROM Student s WHERE s.dateOfbirth = :dateOfbirth"),
    @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality"),
    @NamedQuery(name = "Student.findByDisabilitiesStatus", query = "SELECT s FROM Student s WHERE s.disabilitiesStatus = :disabilitiesStatus"),
    @NamedQuery(name = "Student.findByHometown", query = "SELECT s FROM Student s WHERE s.hometown = :hometown"),
    @NamedQuery(name = "Student.findByRelationToGuardian", query = "SELECT s FROM Student s WHERE s.relationToGuardian = :relationToGuardian"),
    @NamedQuery(name = "Student.findByResidenceOfAffiliation", query = "SELECT s FROM Student s WHERE s.residenceOfAffiliation = :residenceOfAffiliation"),
    @NamedQuery(name = "Student.findByGuardianName", query = "SELECT s FROM Student s WHERE s.guardianName = :guardianName"),
    @NamedQuery(name = "Student.findByGuardianOccupation", query = "SELECT s FROM Student s WHERE s.guardianOccupation = :guardianOccupation"),
    @NamedQuery(name = "Student.findByGuardianContactNumber", query = "SELECT s FROM Student s WHERE s.guardianContactNumber = :guardianContactNumber"),
    @NamedQuery(name = "Student.findByOtherContact", query = "SELECT s FROM Student s WHERE s.otherContact = :otherContact"),
    @NamedQuery(name = "Student.findByRegion", query = "SELECT s FROM Student s WHERE s.region = :region"),
    @NamedQuery(name = "Student.findByHouseNumber", query = "SELECT s FROM Student s WHERE s.houseNumber = :houseNumber"),
    @NamedQuery(name = "Student.findByStudentAcademicStatus", query = "SELECT s FROM Student s WHERE s.studentAcademicStatus = :studentAcademicStatus"),
    @NamedQuery(name = "Student.findByResidenceStatus", query = "SELECT s FROM Student s WHERE s.residenceStatus = :residenceStatus"),
    @NamedQuery(name = "Student.findByAssignedProgramme", query = "SELECT s FROM Student s WHERE s.assignedProgramme = :assignedProgramme"),
    @NamedQuery(name = "Student.findByAssignedClass", query = "SELECT s FROM Student s WHERE s.assignedClass = :assignedClass"),
    @NamedQuery(name = "Student.findByDateOfAdmission", query = "SELECT s FROM Student s WHERE s.dateOfAdmission = :dateOfAdmission"),
    @NamedQuery(name = "Student.findByAcademicLevel", query = "SELECT s FROM Student s WHERE s.academicLevel = :academicLevel"),
    @NamedQuery(name = "Student.findByStudentPassword", query = "SELECT s FROM Student s WHERE s.studentPassword = :studentPassword"),
    @NamedQuery(name = "Student.findByAdmissionPersonnel", query = "SELECT s FROM Student s WHERE s.admissionPersonnel = :admissionPersonnel"),
    @NamedQuery(name = "Student.findByStudentPixId", query = "SELECT s FROM Student s WHERE s.studentPixId = :studentPixId"),
    @NamedQuery(name = "Student.findByLastModifiedDate", query = "SELECT s FROM Student s WHERE s.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "Student.findByLastModifiedBy", query = "SELECT s FROM Student s WHERE s.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "Student.findByDeleted", query = "SELECT s FROM Student s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "Student.findByUpdated", query = "SELECT s FROM Student s WHERE s.updated = :updated")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "student_id", nullable = false, length = 35)
    private String studentId;
    @Size(max = 79)
    @Column(name = "surname", length = 79)
    private String surname;
    @Size(max = 79)
    @Column(name = "othernames", length = 79)
    private String othernames;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "date_Of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfbirth;
    @Size(max = 2)
    @Column(name = "nationality", length = 2)
    private String nationality;
    @Column(name = "disabilities_status")
    private Character disabilitiesStatus;
    @Lob
    @Size(max = 16777215)
    @Column(name = "disabilities_detail", length = 16777215)
    private String disabilitiesDetail;
    @Size(max = 79)
    @Column(name = "hometown", length = 79)
    private String hometown;
    @Size(max = 2)
    @Column(name = "relation_to_guardian", length = 2)
    private String relationToGuardian;
    @Size(max = 35)
    @Column(name = "residence_of_affiliation", length = 35)
    private String residenceOfAffiliation;
    @Size(max = 79)
    @Column(name = "guardian_name", length = 79)
    private String guardianName;
    @Size(max = 15)
    @Column(name = "guardian_occupation", length = 15)
    private String guardianOccupation;
    @Size(max = 15)
    @Column(name = "guardian_contact_number", length = 15)
    private String guardianContactNumber;
    @Size(max = 15)
    @Column(name = "other_contact", length = 15)
    private String otherContact;
    @Lob
    @Size(max = 65535)
    @Column(name = "guardian_postal_address", length = 65535)
    private String guardianPostalAddress;
    @Lob
    @Size(max = 65535)
    @Column(name = "guardian_physical_address", length = 65535)
    private String guardianPhysicalAddress;
    @Size(max = 15)
    @Column(name = "region", length = 15)
    private String region;
    @Size(max = 55)
    @Column(name = "house_number", length = 55)
    private String houseNumber;
    @Size(max = 2)
    @Column(name = "student_academic_status", length = 2)
    private String studentAcademicStatus;
    @Size(max = 15)
    @Column(name = "residence_status", length = 15)
    private String residenceStatus;
    @Size(max = 35)
    @Column(name = "assigned_programme", length = 35)
    private String assignedProgramme;
    @Size(max = 35)
    @Column(name = "assigned_class", length = 35)
    private String assignedClass;
    @Column(name = "date_of_admission")
    @Temporal(TemporalType.DATE)
    private Date dateOfAdmission;
    @Size(max = 35)
    @Column(name = "academic_level", length = 35)
    private String academicLevel;
    @Size(max = 79)
    @Column(name = "student_password", length = 79)
    private String studentPassword;
    @Size(max = 79)
    @Column(name = "admission_personnel", length = 79)
    private String admissionPersonnel;
    @Size(max = 35)
    @Column(name = "student_pix_id", length = 35)
    private String studentPixId;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 79)
    @Column(name = "last_modified_by", length = 79)
    private String lastModifiedBy;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public Student() {
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(Date dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Character getDisabilitiesStatus() {
        return disabilitiesStatus;
    }

    public void setDisabilitiesStatus(Character disabilitiesStatus) {
        this.disabilitiesStatus = disabilitiesStatus;
    }

    public String getDisabilitiesDetail() {
        return disabilitiesDetail;
    }

    public void setDisabilitiesDetail(String disabilitiesDetail) {
        this.disabilitiesDetail = disabilitiesDetail;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getRelationToGuardian() {
        return relationToGuardian;
    }

    public void setRelationToGuardian(String relationToGuardian) {
        this.relationToGuardian = relationToGuardian;
    }

    public String getResidenceOfAffiliation() {
        return residenceOfAffiliation;
    }

    public void setResidenceOfAffiliation(String residenceOfAffiliation) {
        this.residenceOfAffiliation = residenceOfAffiliation;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact;
    }

    public String getGuardianPostalAddress() {
        return guardianPostalAddress;
    }

    public void setGuardianPostalAddress(String guardianPostalAddress) {
        this.guardianPostalAddress = guardianPostalAddress;
    }

    public String getGuardianPhysicalAddress() {
        return guardianPhysicalAddress;
    }

    public void setGuardianPhysicalAddress(String guardianPhysicalAddress) {
        this.guardianPhysicalAddress = guardianPhysicalAddress;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStudentAcademicStatus() {
        return studentAcademicStatus;
    }

    public void setStudentAcademicStatus(String studentAcademicStatus) {
        this.studentAcademicStatus = studentAcademicStatus;
    }

    public String getResidenceStatus() {
        return residenceStatus;
    }

    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    public String getAssignedProgramme() {
        return assignedProgramme;
    }

    public void setAssignedProgramme(String assignedProgramme) {
        this.assignedProgramme = assignedProgramme;
    }

    public String getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(String assignedClass) {
        this.assignedClass = assignedClass;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getAdmissionPersonnel() {
        return admissionPersonnel;
    }

    public void setAdmissionPersonnel(String admissionPersonnel) {
        this.admissionPersonnel = admissionPersonnel;
    }

    public String getStudentPixId() {
        return studentPixId;
    }

    public void setStudentPixId(String studentPixId) {
        this.studentPixId = studentPixId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getUpdated() {
        return updated;
    }

    public void setUpdated(Character updated) {
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.Student[ studentId=" + studentId + " ]";
    }
    
}
