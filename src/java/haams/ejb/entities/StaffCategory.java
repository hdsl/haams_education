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
@Table(name = "staff_category", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffCategory.findAll", query = "SELECT s FROM StaffCategory s"),
    @NamedQuery(name = "StaffCategory.findByStaffCategoryId", query = "SELECT s FROM StaffCategory s WHERE s.staffCategoryId = :staffCategoryId"),
    @NamedQuery(name = "StaffCategory.findByStaffCategoryDesc", query = "SELECT s FROM StaffCategory s WHERE s.staffCategoryDesc = :staffCategoryDesc")})
public class StaffCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "staff_category_id", nullable = false, length = 2)
    private String staffCategoryId;
    @Size(max = 45)
    @Column(name = "staff_category_desc", length = 45)
    private String staffCategoryDesc;

    public StaffCategory() {
    }

    public StaffCategory(String staffCategoryId) {
        this.staffCategoryId = staffCategoryId;
    }

    public String getStaffCategoryId() {
        return staffCategoryId;
    }

    public void setStaffCategoryId(String staffCategoryId) {
        this.staffCategoryId = staffCategoryId;
    }

    public String getStaffCategoryDesc() {
        return staffCategoryDesc;
    }

    public void setStaffCategoryDesc(String staffCategoryDesc) {
        this.staffCategoryDesc = staffCategoryDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffCategoryId != null ? staffCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffCategory)) {
            return false;
        }
        StaffCategory other = (StaffCategory) object;
        if ((this.staffCategoryId == null && other.staffCategoryId != null) || (this.staffCategoryId != null && !this.staffCategoryId.equals(other.staffCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StaffCategory[ staffCategoryId=" + staffCategoryId + " ]";
    }
    
}
