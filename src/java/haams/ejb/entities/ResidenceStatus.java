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
@Table(name = "residence_status")
@NamedQueries({
    @NamedQuery(name = "ResidenceStatus.findAll", query = "SELECT r FROM ResidenceStatus r")})
public class ResidenceStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "residence_status_id")
    private String residenceStatusId;
    @Size(max = 35)
    @Column(name = "residence_status_desc")
    private String residenceStatusDesc;

    public ResidenceStatus() {
    }

    public ResidenceStatus(String residenceStatusId) {
        this.residenceStatusId = residenceStatusId;
    }

    public String getResidenceStatusId() {
        return residenceStatusId;
    }

    public void setResidenceStatusId(String residenceStatusId) {
        this.residenceStatusId = residenceStatusId;
    }

    public String getResidenceStatusDesc() {
        return residenceStatusDesc;
    }

    public void setResidenceStatusDesc(String residenceStatusDesc) {
        this.residenceStatusDesc = residenceStatusDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (residenceStatusId != null ? residenceStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenceStatus)) {
            return false;
        }
        ResidenceStatus other = (ResidenceStatus) object;
        if ((this.residenceStatusId == null && other.residenceStatusId != null) || (this.residenceStatusId != null && !this.residenceStatusId.equals(other.residenceStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haamsEdu.ejb.entities.ResidenceStatus[ residenceStatusId=" + residenceStatusId + " ]";
    }
    
}
