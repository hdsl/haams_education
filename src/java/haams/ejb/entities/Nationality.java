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
@Table(name = "nationality", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationality.findAll", query = "SELECT n FROM Nationality n"),
    @NamedQuery(name = "Nationality.findByNationalityId", query = "SELECT n FROM Nationality n WHERE n.nationalityId = :nationalityId"),
    @NamedQuery(name = "Nationality.findByNationalityDesc", query = "SELECT n FROM Nationality n WHERE n.nationalityDesc = :nationalityDesc")})
public class Nationality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "nationality_id", nullable = false, length = 2)
    private String nationalityId;
    @Size(max = 36)
    @Column(name = "nationality_desc", length = 36)
    private String nationalityDesc;

    public Nationality() {
    }

    public Nationality(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getNationalityDesc() {
        return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nationalityId != null ? nationalityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nationality)) {
            return false;
        }
        Nationality other = (Nationality) object;
        if ((this.nationalityId == null && other.nationalityId != null) || (this.nationalityId != null && !this.nationalityId.equals(other.nationalityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.Nationality[ nationalityId=" + nationalityId + " ]";
    }
    
}
