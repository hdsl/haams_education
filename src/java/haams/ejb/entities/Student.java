/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.ejb.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")})
public class Student extends CommonEntity {

    @Column(name = "surname")
    private String surname;

    @Column(name = "othernames")
    private String othernames;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "date_Of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfbirth;

    @JoinColumn(name = "nationality")
    @ManyToOne
    private Nationality nationality;

    @Column(name = "disabilities_status")
    private Character disabilitiesStatus;

    @Column(name = "disabilities_detail")
    private String disabilitiesDetail;

    @Column(name = "hometown")
    private String hometown;

    @JoinColumn(name = "relation_to_guardian")
    @ManyToOne
    private KinRelation relationToGuardian;

    @JoinColumn(name = "residence_of_affiliation")
    @ManyToOne
    private SchoolHouse residenceOfAffiliation;

    @Column(name = "guardian_name")
    private String guardianName;

    @JoinColumn(name = "guardian_occupation")
    @ManyToOne
    private Occupation guardianOccupation;

    @Column(name = "guardian_contact_number")
    private String guardianContactNumber;

    @Column(name = "other_contact")
    private String otherContact;

    @Column(name = "guardian_postal_address")
    private String guardianPostalAddress;

    @Column(name = "guardian_physical_address")
    private String guardianPhysicalAddress;

    @JoinColumn(name = "region")
    @ManyToOne
    private Region region;

    @Column(name = "house_number")
    private String houseNumber;

    @JoinColumn(name = "student_academic_status")
    @ManyToOne
    private StudentAcademicStatus studentAcademicStatus;

    @JoinColumn(name = "residence_status")
    @ManyToOne
    private ResidenceStatus residenceStatus;

    @JoinColumn(name = "assigned_programme")
    @ManyToOne
    private InstitutionProgram assignedProgramme;

    @JoinColumn(name = "assigned_class")
    @ManyToOne
    private InstitutionClass assignedClass;

    @Column(name = "date_of_admission")
    @Temporal(TemporalType.DATE)
    private Date dateOfAdmission;

    @JoinColumn(name = "academic_level")
    @ManyToOne
    private AcademicLevel academicLevel;

    @Column(name = "student_password")
    private String studentPassword;

    @Column(name = "admission_personnel")
    private String admissionPersonnel;

    @Column(name = "student_pix_id")
    private String studentPixId;

    public Student() {
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

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
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

    public KinRelation getRelationToGuardian() {
        return relationToGuardian;
    }

    public void setRelationToGuardian(KinRelation relationToGuardian) {
        this.relationToGuardian = relationToGuardian;
    }

    public SchoolHouse getResidenceOfAffiliation() {
        return residenceOfAffiliation;
    }

    public void setResidenceOfAffiliation(SchoolHouse residenceOfAffiliation) {
        this.residenceOfAffiliation = residenceOfAffiliation;
    }

    public ResidenceStatus getResidenceStatus() {
        return residenceStatus;
    }

    public void setResidenceStatus(ResidenceStatus residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    public InstitutionClass getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(InstitutionClass assignedClass) {
        this.assignedClass = assignedClass;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public Occupation getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(Occupation guardianOccupation) {
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public StudentAcademicStatus getStudentAcademicStatus() {
        return studentAcademicStatus;
    }

    public void setStudentAcademicStatus(StudentAcademicStatus studentAcademicStatus) {
        this.studentAcademicStatus = studentAcademicStatus;
    }

    public InstitutionProgram getAssignedProgramme() {
        return assignedProgramme;
    }

    public void setAssignedProgramme(InstitutionProgram assignedProgramme) {
        this.assignedProgramme = assignedProgramme;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
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

}
