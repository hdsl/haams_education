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
@Table(name = "student_conduct", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentConduct.findAll", query = "SELECT s FROM StudentConduct s"),
    @NamedQuery(name = "StudentConduct.findByStudentConductId", query = "SELECT s FROM StudentConduct s WHERE s.studentConductId = :studentConductId"),
    @NamedQuery(name = "StudentConduct.findByStudentId", query = "SELECT s FROM StudentConduct s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentConduct.findByGeneralStudentConduct", query = "SELECT s FROM StudentConduct s WHERE s.generalStudentConduct = :generalStudentConduct"),
    @NamedQuery(name = "StudentConduct.findByAcademicTerm", query = "SELECT s FROM StudentConduct s WHERE s.academicTerm = :academicTerm"),
    @NamedQuery(name = "StudentConduct.findByExpectedAttendance", query = "SELECT s FROM StudentConduct s WHERE s.expectedAttendance = :expectedAttendance"),
    @NamedQuery(name = "StudentConduct.findByStudentAttendance", query = "SELECT s FROM StudentConduct s WHERE s.studentAttendance = :studentAttendance"),
    @NamedQuery(name = "StudentConduct.findByUpdated", query = "SELECT s FROM StudentConduct s WHERE s.updated = :updated"),
    @NamedQuery(name = "StudentConduct.findByDeleted", query = "SELECT s FROM StudentConduct s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentConduct.findBySystemDate", query = "SELECT s FROM StudentConduct s WHERE s.systemDate = :systemDate")})
public class StudentConduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "student_conduct_id", nullable = false, length = 35)
    private String studentConductId;
    @Size(max = 35)
    @Column(name = "student_id", length = 35)
    private String studentId;
    @Size(max = 35)
    @Column(name = "general_student_conduct", length = 35)
    private String generalStudentConduct;
    @Size(max = 50)
    @Column(name = "academic_term", length = 50)
    private String academicTerm;
    @Size(max = 15)
    @Column(name = "expected_attendance", length = 15)
    private String expectedAttendance;
    @Size(max = 15)
    @Column(name = "student_attendance", length = 15)
    private String studentAttendance;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public StudentConduct() {
    }

    public StudentConduct(String studentConductId) {
        this.studentConductId = studentConductId;
    }

    public String getStudentConductId() {
        return studentConductId;
    }

    public void setStudentConductId(String studentConductId) {
        this.studentConductId = studentConductId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGeneralStudentConduct() {
        return generalStudentConduct;
    }

    public void setGeneralStudentConduct(String generalStudentConduct) {
        this.generalStudentConduct = generalStudentConduct;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getExpectedAttendance() {
        return expectedAttendance;
    }

    public void setExpectedAttendance(String expectedAttendance) {
        this.expectedAttendance = expectedAttendance;
    }

    public String getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(String studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public Character getUpdated() {
        return updated;
    }

    public void setUpdated(Character updated) {
        this.updated = updated;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
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
        hash += (studentConductId != null ? studentConductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentConduct)) {
            return false;
        }
        StudentConduct other = (StudentConduct) object;
        if ((this.studentConductId == null && other.studentConductId != null) || (this.studentConductId != null && !this.studentConductId.equals(other.studentConductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentConduct[ studentConductId=" + studentConductId + " ]";
    }
    
}
