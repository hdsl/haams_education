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
@Table(name = "occupation")
@NamedQueries({
    @NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o")})
public class Occupation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "occupation_id")
    private String occupationId;
    @Size(max = 30)
    @Column(name = "occupation_desc")
    private String occupationDesc;

    public Occupation() {
    }

    public Occupation(String occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(String occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupationDesc() {
        return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc) {
        this.occupationDesc = occupationDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (occupationId != null ? occupationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occupation)) {
            return false;
        }
        Occupation other = (Occupation) object;
        if ((this.occupationId == null && other.occupationId != null) || (this.occupationId != null && !this.occupationId.equals(other.occupationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haamsEdu.ejb.entities.Occupation[ occupationId=" + occupationId + " ]";
    }
    
}
