/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "class_teacher")
@NamedQueries({
    @NamedQuery(name = "ClassTeacher.findAll", query = "SELECT c FROM ClassTeacher c")})
public class ClassTeacher extends CommonEntity {

    @Column(name = "academic_year")
    private String academicYear;

    @JoinColumn(name = "institution_class")
    @ManyToOne
    private InstitutionClass institutionClass;

    @JoinColumn(name = "staff_id")
    @ManyToOne
    private InstitutionStaff staffId;

    public ClassTeacher() {
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public InstitutionStaff getStaffId() {
        return staffId;
    }

    public void setStaffId(InstitutionStaff staffId) {
        this.staffId = staffId;
    }

    public InstitutionClass getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(InstitutionClass institutionClass) {
        this.institutionClass = institutionClass;
    }

}
