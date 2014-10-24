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
@Table(name = "student_term_report_note", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentTermReportNote.findAll", query = "SELECT s FROM StudentTermReportNote s"),
    @NamedQuery(name = "StudentTermReportNote.findByStudentTermReportNoteId", query = "SELECT s FROM StudentTermReportNote s WHERE s.studentTermReportNoteId = :studentTermReportNoteId"),
    @NamedQuery(name = "StudentTermReportNote.findByPromotionStatus", query = "SELECT s FROM StudentTermReportNote s WHERE s.promotionStatus = :promotionStatus"),
    @NamedQuery(name = "StudentTermReportNote.findByUpdated", query = "SELECT s FROM StudentTermReportNote s WHERE s.updated = :updated"),
    @NamedQuery(name = "StudentTermReportNote.findByLastModifiedBy", query = "SELECT s FROM StudentTermReportNote s WHERE s.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "StudentTermReportNote.findByLastModifiedDate", query = "SELECT s FROM StudentTermReportNote s WHERE s.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "StudentTermReportNote.findByDeleted", query = "SELECT s FROM StudentTermReportNote s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentTermReportNote.findByAcademicTerm", query = "SELECT s FROM StudentTermReportNote s WHERE s.academicTerm = :academicTerm"),
    @NamedQuery(name = "StudentTermReportNote.findByClassPromotedTo", query = "SELECT s FROM StudentTermReportNote s WHERE s.classPromotedTo = :classPromotedTo"),
    @NamedQuery(name = "StudentTermReportNote.findByStudent", query = "SELECT s FROM StudentTermReportNote s WHERE s.student = :student"),
    @NamedQuery(name = "StudentTermReportNote.findBySchoolNumber", query = "SELECT s FROM StudentTermReportNote s WHERE s.schoolNumber = :schoolNumber")})
public class StudentTermReportNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_term_report_note_id", nullable = false, length = 255)
    private String studentTermReportNoteId;
    @Size(max = 255)
    @Column(name = "promotion_status", length = 255)
    private String promotionStatus;
    @Size(max = 255)
    @Column(name = "updated", length = 255)
    private String updated;
    @Size(max = 255)
    @Column(name = "last_modified_by", length = 255)
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 255)
    @Column(name = "deleted", length = 255)
    private String deleted;
    @Size(max = 255)
    @Column(name = "academic_term", length = 255)
    private String academicTerm;
    @Size(max = 255)
    @Column(name = "class_promoted_to", length = 255)
    private String classPromotedTo;
    @Size(max = 255)
    @Column(name = "student", length = 255)
    private String student;
    @Size(max = 50)
    @Column(name = "school_number", length = 50)
    private String schoolNumber;

    public StudentTermReportNote() {
    }

    public StudentTermReportNote(String studentTermReportNoteId) {
        this.studentTermReportNoteId = studentTermReportNoteId;
    }

    public String getStudentTermReportNoteId() {
        return studentTermReportNoteId;
    }

    public void setStudentTermReportNoteId(String studentTermReportNoteId) {
        this.studentTermReportNoteId = studentTermReportNoteId;
    }

    public String getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(String promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getClassPromotedTo() {
        return classPromotedTo;
    }

    public void setClassPromotedTo(String classPromotedTo) {
        this.classPromotedTo = classPromotedTo;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentTermReportNoteId != null ? studentTermReportNoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentTermReportNote)) {
            return false;
        }
        StudentTermReportNote other = (StudentTermReportNote) object;
        if ((this.studentTermReportNoteId == null && other.studentTermReportNoteId != null) || (this.studentTermReportNoteId != null && !this.studentTermReportNoteId.equals(other.studentTermReportNoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentTermReportNote[ studentTermReportNoteId=" + studentTermReportNoteId + " ]";
    }
    
}
