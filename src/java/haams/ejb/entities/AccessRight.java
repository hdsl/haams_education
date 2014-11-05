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
@Table(name = "access_right")
@NamedQueries({
    @NamedQuery(name = "AccessRight.findAll", query = "SELECT a FROM AccessRight a")})
public class AccessRight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "access_right_id")
    private String accessRightId;
    @Size(max = 36)
    @Column(name = "access_right")
    private String accessRight;

    public AccessRight() {
    }

    public AccessRight(String accessRightId) {
        this.accessRightId = accessRightId;
    }

    public String getAccessRightId() {
        return accessRightId;
    }

    public void setAccessRightId(String accessRightId) {
        this.accessRightId = accessRightId;
    }

    public String getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessRightId != null ? accessRightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessRight)) {
            return false;
        }
        AccessRight other = (AccessRight) object;
        if ((this.accessRightId == null && other.accessRightId != null) || (this.accessRightId != null && !this.accessRightId.equals(other.accessRightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haamsEdu.ejb.entities.AccessRight[ accessRightId=" + accessRightId + " ]";
    }
    
}
