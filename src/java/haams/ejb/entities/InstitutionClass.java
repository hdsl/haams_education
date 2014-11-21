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
@Table(name = "institution_class")
@NamedQueries({
    @NamedQuery(name = "InstitutionClass.findAll", query = "SELECT i FROM InstitutionClass i")})
public class InstitutionClass extends CommonEntity {

    @Column(name = "class_name")
    private String className;

    @JoinColumn(name = "academic_level")
    @ManyToOne
    private AcademicLevel academicLevel;

    @JoinColumn(name = "institution_program")
    @ManyToOne
    private InstitutionProgram institutionProgram;

    @Column(name = "bill_term_set")
    private String billTermSet;

    public InstitutionClass() {
    }

    public InstitutionProgram getInstitutionProgram() {
        return institutionProgram;
    }

    public void setInstitutionProgram(InstitutionProgram institutionProgram) {
        this.institutionProgram = institutionProgram;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getBillTermSet() {
        return billTermSet;
    }

    public void setBillTermSet(String billTermSet) {
        this.billTermSet = billTermSet;
    }

}
