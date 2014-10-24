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
@Table(name = "student_report_comment", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentReportComment.findAll", query = "SELECT s FROM StudentReportComment s"),
    @NamedQuery(name = "StudentReportComment.findByStudentReportCommentId", query = "SELECT s FROM StudentReportComment s WHERE s.studentReportCommentId = :studentReportCommentId"),
    @NamedQuery(name = "StudentReportComment.findByStudent", query = "SELECT s FROM StudentReportComment s WHERE s.student = :student"),
    @NamedQuery(name = "StudentReportComment.findByComment", query = "SELECT s FROM StudentReportComment s WHERE s.comment = :comment"),
    @NamedQuery(name = "StudentReportComment.findByConductType", query = "SELECT s FROM StudentReportComment s WHERE s.conductType = :conductType"),
    @NamedQuery(name = "StudentReportComment.findByAcademicTerm", query = "SELECT s FROM StudentReportComment s WHERE s.academicTerm = :academicTerm"),
    @NamedQuery(name = "StudentReportComment.findByDeleted", query = "SELECT s FROM StudentReportComment s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentReportComment.findByUpdated", query = "SELECT s FROM StudentReportComment s WHERE s.updated = :updated"),
    @NamedQuery(name = "StudentReportComment.findByLastModifiedBy", query = "SELECT s FROM StudentReportComment s WHERE s.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "StudentReportComment.findByLastModifiedDate", query = "SELECT s FROM StudentReportComment s WHERE s.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "StudentReportComment.findByStudentAttendance", query = "SELECT s FROM StudentReportComment s WHERE s.studentAttendance = :studentAttendance"),
    @NamedQuery(name = "StudentReportComment.findByExpectedAttendance", query = "SELECT s FROM StudentReportComment s WHERE s.expectedAttendance = :expectedAttendance")})
public class StudentReportComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_report_comment_id", nullable = false, length = 255)
    private String studentReportCommentId;
    @Size(max = 255)
    @Column(name = "student", length = 255)
    private String student;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Size(max = 50)
    @Column(name = "conduct_type", length = 50)
    private String conductType;
    @Size(max = 50)
    @Column(name = "academic_term", length = 50)
    private String academicTerm;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;
    @Size(max = 50)
    @Column(name = "last_modified_by", length = 50)
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 50)
    @Column(name = "student_attendance", length = 50)
    private String studentAttendance;
    @Size(max = 50)
    @Column(name = "expected_attendance", length = 50)
    private String expectedAttendance;

    public StudentReportComment() {
    }

    public StudentReportComment(String studentReportCommentId) {
        this.studentReportCommentId = studentReportCommentId;
    }

    public String getStudentReportCommentId() {
        return studentReportCommentId;
    }

    public void setStudentReportCommentId(String studentReportCommentId) {
        this.studentReportCommentId = studentReportCommentId;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConductType() {
        return conductType;
    }

    public void setConductType(String conductType) {
        this.conductType = conductType;
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

    public String getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(String studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public String getExpectedAttendance() {
        return expectedAttendance;
    }

    public void setExpectedAttendance(String expectedAttendance) {
        this.expectedAttendance = expectedAttendance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentReportCommentId != null ? studentReportCommentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentReportComment)) {
            return false;
        }
        StudentReportComment other = (StudentReportComment) object;
        if ((this.studentReportCommentId == null && other.studentReportCommentId != null) || (this.studentReportCommentId != null && !this.studentReportCommentId.equals(other.studentReportCommentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentReportComment[ studentReportCommentId=" + studentReportCommentId + " ]";
    }
    
}
