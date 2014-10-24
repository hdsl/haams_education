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
import javax.persistence.Lob;
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
@Table(name = "teacher_subject", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherSubject.findAll", query = "SELECT t FROM TeacherSubject t"),
    @NamedQuery(name = "TeacherSubject.findByTeacherSubjectId", query = "SELECT t FROM TeacherSubject t WHERE t.teacherSubjectId = :teacherSubjectId"),
    @NamedQuery(name = "TeacherSubject.findByTeacherId", query = "SELECT t FROM TeacherSubject t WHERE t.teacherId = :teacherId"),
    @NamedQuery(name = "TeacherSubject.findBySubjectId", query = "SELECT t FROM TeacherSubject t WHERE t.subjectId = :subjectId"),
    @NamedQuery(name = "TeacherSubject.findByAcademicTerm", query = "SELECT t FROM TeacherSubject t WHERE t.academicTerm = :academicTerm"),
    @NamedQuery(name = "TeacherSubject.findByDeleted", query = "SELECT t FROM TeacherSubject t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TeacherSubject.findByUpdated", query = "SELECT t FROM TeacherSubject t WHERE t.updated = :updated")})
public class TeacherSubject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "teacher_subject_id", nullable = false, length = 55)
    private String teacherSubjectId;
    @Size(max = 20)
    @Column(name = "teacher_id", length = 20)
    private String teacherId;
    @Size(max = 50)
    @Column(name = "subject_id", length = 50)
    private String subjectId;
    @Lob
    @Size(max = 65535)
    @Column(name = "teaching_classes", length = 65535)
    private String teachingClasses;
    @Size(max = 20)
    @Column(name = "academic_term", length = 20)
    private String academicTerm;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public TeacherSubject() {
    }

    public TeacherSubject(String teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    public String getTeacherSubjectId() {
        return teacherSubjectId;
    }

    public void setTeacherSubjectId(String teacherSubjectId) {
        this.teacherSubjectId = teacherSubjectId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeachingClasses() {
        return teachingClasses;
    }

    public void setTeachingClasses(String teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
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
        hash += (teacherSubjectId != null ? teacherSubjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherSubject)) {
            return false;
        }
        TeacherSubject other = (TeacherSubject) object;
        if ((this.teacherSubjectId == null && other.teacherSubjectId != null) || (this.teacherSubjectId != null && !this.teacherSubjectId.equals(other.teacherSubjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.TeacherSubject[ teacherSubjectId=" + teacherSubjectId + " ]";
    }
    
}
