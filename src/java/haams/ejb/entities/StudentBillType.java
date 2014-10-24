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
@Table(name = "student_bill_type", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentBillType.findAll", query = "SELECT s FROM StudentBillType s"),
    @NamedQuery(name = "StudentBillType.findByStudentBillTypeId", query = "SELECT s FROM StudentBillType s WHERE s.studentBillTypeId = :studentBillTypeId"),
    @NamedQuery(name = "StudentBillType.findByBillTypeName", query = "SELECT s FROM StudentBillType s WHERE s.billTypeName = :billTypeName"),
    @NamedQuery(name = "StudentBillType.findByDeleted", query = "SELECT s FROM StudentBillType s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentBillType.findByUpdated", query = "SELECT s FROM StudentBillType s WHERE s.updated = :updated")})
public class StudentBillType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "student_bill_type_id", nullable = false, length = 35)
    private String studentBillTypeId;
    @Size(max = 35)
    @Column(name = "bill_type_name", length = 35)
    private String billTypeName;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public StudentBillType() {
    }

    public StudentBillType(String studentBillTypeId) {
        this.studentBillTypeId = studentBillTypeId;
    }

    public String getStudentBillTypeId() {
        return studentBillTypeId;
    }

    public void setStudentBillTypeId(String studentBillTypeId) {
        this.studentBillTypeId = studentBillTypeId;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
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
        hash += (studentBillTypeId != null ? studentBillTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentBillType)) {
            return false;
        }
        StudentBillType other = (StudentBillType) object;
        if ((this.studentBillTypeId == null && other.studentBillTypeId != null) || (this.studentBillTypeId != null && !this.studentBillTypeId.equals(other.studentBillTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentBillType[ studentBillTypeId=" + studentBillTypeId + " ]";
    }
    
}
