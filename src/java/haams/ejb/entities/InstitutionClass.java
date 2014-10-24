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
@Table(name = "institution_class", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitutionClass.findAll", query = "SELECT i FROM InstitutionClass i"),
    @NamedQuery(name = "InstitutionClass.findByClassId", query = "SELECT i FROM InstitutionClass i WHERE i.classId = :classId"),
    @NamedQuery(name = "InstitutionClass.findByClassName", query = "SELECT i FROM InstitutionClass i WHERE i.className = :className"),
    @NamedQuery(name = "InstitutionClass.findByAcademicLevel", query = "SELECT i FROM InstitutionClass i WHERE i.academicLevel = :academicLevel"),
    @NamedQuery(name = "InstitutionClass.findByInstitutionProgram", query = "SELECT i FROM InstitutionClass i WHERE i.institutionProgram = :institutionProgram"),
    @NamedQuery(name = "InstitutionClass.findByBillTermSet", query = "SELECT i FROM InstitutionClass i WHERE i.billTermSet = :billTermSet"),
    @NamedQuery(name = "InstitutionClass.findByDeleted", query = "SELECT i FROM InstitutionClass i WHERE i.deleted = :deleted"),
    @NamedQuery(name = "InstitutionClass.findByUpdated", query = "SELECT i FROM InstitutionClass i WHERE i.updated = :updated"),
    @NamedQuery(name = "InstitutionClass.findBySystemDate", query = "SELECT i FROM InstitutionClass i WHERE i.systemDate = :systemDate")})
public class InstitutionClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "class_id", nullable = false, length = 35)
    private String classId;
    @Size(max = 45)
    @Column(name = "class_name", length = 45)
    private String className;
    @Size(max = 35)
    @Column(name = "academic_level", length = 35)
    private String academicLevel;
    @Size(max = 35)
    @Column(name = "institution_program", length = 35)
    private String institutionProgram;
    @Size(max = 35)
    @Column(name = "bill_term_set", length = 35)
    private String billTermSet;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public InstitutionClass() {
    }

    public InstitutionClass(String classId) {
        this.classId = classId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getInstitutionProgram() {
        return institutionProgram;
    }

    public void setInstitutionProgram(String institutionProgram) {
        this.institutionProgram = institutionProgram;
    }

    public String getBillTermSet() {
        return billTermSet;
    }

    public void setBillTermSet(String billTermSet) {
        this.billTermSet = billTermSet;
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

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classId != null ? classId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitutionClass)) {
            return false;
        }
        InstitutionClass other = (InstitutionClass) object;
        if ((this.classId == null && other.classId != null) || (this.classId != null && !this.classId.equals(other.classId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.InstitutionClass[ classId=" + classId + " ]";
    }
    
}
