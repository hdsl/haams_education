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
@Table(name = "class_membership", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassMembership.findAll", query = "SELECT c FROM ClassMembership c"),
    @NamedQuery(name = "ClassMembership.findByClassMembershipId", query = "SELECT c FROM ClassMembership c WHERE c.classMembershipId = :classMembershipId"),
    @NamedQuery(name = "ClassMembership.findByAcademicYear", query = "SELECT c FROM ClassMembership c WHERE c.academicYear = :academicYear"),
    @NamedQuery(name = "ClassMembership.findByInstitutionClass", query = "SELECT c FROM ClassMembership c WHERE c.institutionClass = :institutionClass"),
    @NamedQuery(name = "ClassMembership.findByStudentId", query = "SELECT c FROM ClassMembership c WHERE c.studentId = :studentId"),
    @NamedQuery(name = "ClassMembership.findBySubjectGroupId", query = "SELECT c FROM ClassMembership c WHERE c.subjectGroupId = :subjectGroupId"),
    @NamedQuery(name = "ClassMembership.findByDeleted", query = "SELECT c FROM ClassMembership c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "ClassMembership.findByUpdated", query = "SELECT c FROM ClassMembership c WHERE c.updated = :updated")})
public class ClassMembership implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "class_membership_id", nullable = false, length = 35)
    private String classMembershipId;
    @Size(max = 35)
    @Column(name = "academic_year", length = 35)
    private String academicYear;
    @Size(max = 35)
    @Column(name = "institution_class", length = 35)
    private String institutionClass;
    @Size(max = 35)
    @Column(name = "student_id", length = 35)
    private String studentId;
    @Size(max = 35)
    @Column(name = "subject_group_id", length = 35)
    private String subjectGroupId;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public ClassMembership() {
    }

    public ClassMembership(String classMembershipId) {
        this.classMembershipId = classMembershipId;
    }

    public String getClassMembershipId() {
        return classMembershipId;
    }

    public void setClassMembershipId(String classMembershipId) {
        this.classMembershipId = classMembershipId;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectGroupId() {
        return subjectGroupId;
    }

    public void setSubjectGroupId(String subjectGroupId) {
        this.subjectGroupId = subjectGroupId;
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
        hash += (classMembershipId != null ? classMembershipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassMembership)) {
            return false;
        }
        ClassMembership other = (ClassMembership) object;
        if ((this.classMembershipId == null && other.classMembershipId != null) || (this.classMembershipId != null && !this.classMembershipId.equals(other.classMembershipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.ClassMembership[ classMembershipId=" + classMembershipId + " ]";
    }
    
}
