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
@Table(name = "generate_pk", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneratePk.findAll", query = "SELECT g FROM GeneratePk g"),
    @NamedQuery(name = "GeneratePk.findByPkName", query = "SELECT g FROM GeneratePk g WHERE g.pkName = :pkName"),
    @NamedQuery(name = "GeneratePk.findByPkValue", query = "SELECT g FROM GeneratePk g WHERE g.pkValue = :pkValue"),
    @NamedQuery(name = "GeneratePk.findByPkDescription", query = "SELECT g FROM GeneratePk g WHERE g.pkDescription = :pkDescription")})
public class GeneratePk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "pk_name", nullable = false, length = 35)
    private String pkName;
    @Column(name = "pk_value")
    private Integer pkValue;
    @Size(max = 35)
    @Column(name = "pk_description", length = 35)
    private String pkDescription;

    public GeneratePk() {
    }

    public GeneratePk(String pkName) {
        this.pkName = pkName;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public Integer getPkValue() {
        return pkValue;
    }

    public void setPkValue(Integer pkValue) {
        this.pkValue = pkValue;
    }

    public String getPkDescription() {
        return pkDescription;
    }

    public void setPkDescription(String pkDescription) {
        this.pkDescription = pkDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkName != null ? pkName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneratePk)) {
            return false;
        }
        GeneratePk other = (GeneratePk) object;
        if ((this.pkName == null && other.pkName != null) || (this.pkName != null && !this.pkName.equals(other.pkName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.GeneratePk[ pkName=" + pkName + " ]";
    }
    
}
