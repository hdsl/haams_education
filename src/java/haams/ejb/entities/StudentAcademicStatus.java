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

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "student_academic_status")
@NamedQueries({
    @NamedQuery(name = "StudentAcademicStatus.findAll", query = "SELECT s FROM StudentAcademicStatus s")})
public class StudentAcademicStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "student_academic_status_id")
    private String studentAcademicStatusId;
    @Size(max = 15)
    @Column(name = "student_academic_status_desc")
    private String studentAcademicStatusDesc;

    public StudentAcademicStatus() {
    }

    public StudentAcademicStatus(String studentAcademicStatusId) {
        this.studentAcademicStatusId = studentAcademicStatusId;
    }

    public String getStudentAcademicStatusId() {
        return studentAcademicStatusId;
    }

    public void setStudentAcademicStatusId(String studentAcademicStatusId) {
        this.studentAcademicStatusId = studentAcademicStatusId;
    }

    public String getStudentAcademicStatusDesc() {
        return studentAcademicStatusDesc;
    }

    public void setStudentAcademicStatusDesc(String studentAcademicStatusDesc) {
        this.studentAcademicStatusDesc = studentAcademicStatusDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentAcademicStatusId != null ? studentAcademicStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentAcademicStatus)) {
            return false;
        }
        StudentAcademicStatus other = (StudentAcademicStatus) object;
        if ((this.studentAcademicStatusId == null && other.studentAcademicStatusId != null) || (this.studentAcademicStatusId != null && !this.studentAcademicStatusId.equals(other.studentAcademicStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haamsEdu.ejb.entities.StudentAcademicStatus[ studentAcademicStatusId=" + studentAcademicStatusId + " ]";
    }
    
}
