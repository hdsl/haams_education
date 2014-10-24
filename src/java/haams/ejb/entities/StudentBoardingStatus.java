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
@Table(name = "student_boarding_status", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentBoardingStatus.findAll", query = "SELECT s FROM StudentBoardingStatus s"),
    @NamedQuery(name = "StudentBoardingStatus.findByBoardingStatusId", query = "SELECT s FROM StudentBoardingStatus s WHERE s.boardingStatusId = :boardingStatusId"),
    @NamedQuery(name = "StudentBoardingStatus.findByStudentId", query = "SELECT s FROM StudentBoardingStatus s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentBoardingStatus.findByAcademicTerm", query = "SELECT s FROM StudentBoardingStatus s WHERE s.academicTerm = :academicTerm"),
    @NamedQuery(name = "StudentBoardingStatus.findByResidenceStatus", query = "SELECT s FROM StudentBoardingStatus s WHERE s.residenceStatus = :residenceStatus"),
    @NamedQuery(name = "StudentBoardingStatus.findBySystemDate", query = "SELECT s FROM StudentBoardingStatus s WHERE s.systemDate = :systemDate"),
    @NamedQuery(name = "StudentBoardingStatus.findByDeleted", query = "SELECT s FROM StudentBoardingStatus s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentBoardingStatus.findByUpdated", query = "SELECT s FROM StudentBoardingStatus s WHERE s.updated = :updated")})
public class StudentBoardingStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "boarding_status_id", nullable = false, length = 35)
    private String boardingStatusId;
    @Size(max = 35)
    @Column(name = "student_id", length = 35)
    private String studentId;
    @Size(max = 35)
    @Column(name = "academic_term", length = 35)
    private String academicTerm;
    @Size(max = 15)
    @Column(name = "residence_status", length = 15)
    private String residenceStatus;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public StudentBoardingStatus() {
    }

    public StudentBoardingStatus(String boardingStatusId) {
        this.boardingStatusId = boardingStatusId;
    }

    public String getBoardingStatusId() {
        return boardingStatusId;
    }

    public void setBoardingStatusId(String boardingStatusId) {
        this.boardingStatusId = boardingStatusId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getResidenceStatus() {
        return residenceStatus;
    }

    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
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
        hash += (boardingStatusId != null ? boardingStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentBoardingStatus)) {
            return false;
        }
        StudentBoardingStatus other = (StudentBoardingStatus) object;
        if ((this.boardingStatusId == null && other.boardingStatusId != null) || (this.boardingStatusId != null && !this.boardingStatusId.equals(other.boardingStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentBoardingStatus[ boardingStatusId=" + boardingStatusId + " ]";
    }
    
}
