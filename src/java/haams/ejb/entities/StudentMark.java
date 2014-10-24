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
@Table(name = "student_mark", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentMark.findAll", query = "SELECT s FROM StudentMark s"),
    @NamedQuery(name = "StudentMark.findByStudentMarkId", query = "SELECT s FROM StudentMark s WHERE s.studentMarkId = :studentMarkId"),
    @NamedQuery(name = "StudentMark.findByAcademicTerm", query = "SELECT s FROM StudentMark s WHERE s.academicTerm = :academicTerm"),
    @NamedQuery(name = "StudentMark.findByStudentId", query = "SELECT s FROM StudentMark s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentMark.findByInstitutionSubject", query = "SELECT s FROM StudentMark s WHERE s.institutionSubject = :institutionSubject"),
    @NamedQuery(name = "StudentMark.findByInstitutionClass", query = "SELECT s FROM StudentMark s WHERE s.institutionClass = :institutionClass"),
    @NamedQuery(name = "StudentMark.findBySubjectTeacher", query = "SELECT s FROM StudentMark s WHERE s.subjectTeacher = :subjectTeacher"),
    @NamedQuery(name = "StudentMark.findByStudentClassMark", query = "SELECT s FROM StudentMark s WHERE s.studentClassMark = :studentClassMark"),
    @NamedQuery(name = "StudentMark.findByStudentExamMark", query = "SELECT s FROM StudentMark s WHERE s.studentExamMark = :studentExamMark"),
    @NamedQuery(name = "StudentMark.findByDeleted", query = "SELECT s FROM StudentMark s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentMark.findByUpdated", query = "SELECT s FROM StudentMark s WHERE s.updated = :updated")})
public class StudentMark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_mark_id", nullable = false, length = 255)
    private String studentMarkId;
    @Size(max = 35)
    @Column(name = "academic_term", length = 35)
    private String academicTerm;
    @Size(max = 35)
    @Column(name = "student_id", length = 35)
    private String studentId;
    @Size(max = 35)
    @Column(name = "institution_subject", length = 35)
    private String institutionSubject;
    @Size(max = 35)
    @Column(name = "institution_class", length = 35)
    private String institutionClass;
    @Size(max = 255)
    @Column(name = "subject_teacher", length = 255)
    private String subjectTeacher;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "student_class_mark", precision = 10, scale = 2)
    private Double studentClassMark;
    @Column(name = "student_exam_mark", precision = 10, scale = 2)
    private Double studentExamMark;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public StudentMark() {
    }

    public StudentMark(String studentMarkId) {
        this.studentMarkId = studentMarkId;
    }

    public String getStudentMarkId() {
        return studentMarkId;
    }

    public void setStudentMarkId(String studentMarkId) {
        this.studentMarkId = studentMarkId;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getInstitutionSubject() {
        return institutionSubject;
    }

    public void setInstitutionSubject(String institutionSubject) {
        this.institutionSubject = institutionSubject;
    }

    public String getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(String institutionClass) {
        this.institutionClass = institutionClass;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public Double getStudentClassMark() {
        return studentClassMark;
    }

    public void setStudentClassMark(Double studentClassMark) {
        this.studentClassMark = studentClassMark;
    }

    public Double getStudentExamMark() {
        return studentExamMark;
    }

    public void setStudentExamMark(Double studentExamMark) {
        this.studentExamMark = studentExamMark;
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
        hash += (studentMarkId != null ? studentMarkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentMark)) {
            return false;
        }
        StudentMark other = (StudentMark) object;
        if ((this.studentMarkId == null && other.studentMarkId != null) || (this.studentMarkId != null && !this.studentMarkId.equals(other.studentMarkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentMark[ studentMarkId=" + studentMarkId + " ]";
    }
    
}
