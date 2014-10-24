/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HDSL_MUMIN
 */
@Entity
@Table(name = "class_teacher", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassTeacher.findAll", query = "SELECT c FROM ClassTeacher c"),
    @NamedQuery(name = "ClassTeacher.findByClassTeacherId", query = "SELECT c FROM ClassTeacher c WHERE c.classTeacherId = :classTeacherId"),
    @NamedQuery(name = "ClassTeacher.findByAcademicYear", query = "SELECT c FROM ClassTeacher c WHERE c.academicYear = :academicYear"),
    @NamedQuery(name = "ClassTeacher.findByInstitutionClass", query = "SELECT c FROM ClassTeacher c WHERE c.institutionClass = :institutionClass"),
    @NamedQuery(name = "ClassTeacher.findByStaffId", query = "SELECT c FROM ClassTeacher c WHERE c.staffId = :staffId"),
    @NamedQuery(name = "ClassTeacher.findByDeleted", query = "SELECT c FROM ClassTeacher c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "ClassTeacher.findByUpdated", query = "SELECT c FROM ClassTeacher c WHERE c.updated = :updated")})
public class ClassTeacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "class_teacher_id", nullable = false, length = 35)
    private String classTeacherId;
    @Size(max = 35)
    @Column(name = "academic_year", length = 35)
    private String academicYear;
    @Size(max = 255)
    @Column(name = "institution_class", length = 255)
    private String institutionClass;
    @Size(max = 35)
    @Column(name = "staff_id", length = 35)
    private String staffId;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public ClassTeacher() {
    }

    public ClassTeacher(String classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public String getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(String classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(String institutionClass) {
        this.institutionClass = institutionClass;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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
        hash += (classTeacherId != null ? classTeacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassTeacher)) {
            return false;
        }
        ClassTeacher other = (ClassTeacher) object;
        if ((this.classTeacherId == null && other.classTeacherId != null) || (this.classTeacherId != null && !this.classTeacherId.equals(other.classTeacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.ClassTeacher[ classTeacherId=" + classTeacherId + " ]";
    }
    
}
