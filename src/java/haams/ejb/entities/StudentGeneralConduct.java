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
@Table(name = "student_general_conduct", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGeneralConduct.findAll", query = "SELECT s FROM StudentGeneralConduct s"),
    @NamedQuery(name = "StudentGeneralConduct.findByStudentConductId", query = "SELECT s FROM StudentGeneralConduct s WHERE s.studentConductId = :studentConductId"),
    @NamedQuery(name = "StudentGeneralConduct.findByConductStatus", query = "SELECT s FROM StudentGeneralConduct s WHERE s.conductStatus = :conductStatus"),
    @NamedQuery(name = "StudentGeneralConduct.findByUpdated", query = "SELECT s FROM StudentGeneralConduct s WHERE s.updated = :updated"),
    @NamedQuery(name = "StudentGeneralConduct.findByDeleted", query = "SELECT s FROM StudentGeneralConduct s WHERE s.deleted = :deleted")})
public class StudentGeneralConduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "student_conduct_id", nullable = false, length = 35)
    private String studentConductId;
    @Lob
    @Size(max = 65535)
    @Column(name = "conduct_desc", length = 65535)
    private String conductDesc;
    @Size(max = 35)
    @Column(name = "conduct_status", length = 35)
    private String conductStatus;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "deleted")
    private Character deleted;

    public StudentGeneralConduct() {
    }

    public StudentGeneralConduct(String studentConductId) {
        this.studentConductId = studentConductId;
    }

    public String getStudentConductId() {
        return studentConductId;
    }

    public void setStudentConductId(String studentConductId) {
        this.studentConductId = studentConductId;
    }

    public String getConductDesc() {
        return conductDesc;
    }

    public void setConductDesc(String conductDesc) {
        this.conductDesc = conductDesc;
    }

    public String getConductStatus() {
        return conductStatus;
    }

    public void setConductStatus(String conductStatus) {
        this.conductStatus = conductStatus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentConductId != null ? studentConductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentGeneralConduct)) {
            return false;
        }
        StudentGeneralConduct other = (StudentGeneralConduct) object;
        if ((this.studentConductId == null && other.studentConductId != null) || (this.studentConductId != null && !this.studentConductId.equals(other.studentConductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentGeneralConduct[ studentConductId=" + studentConductId + " ]";
    }
    
}
