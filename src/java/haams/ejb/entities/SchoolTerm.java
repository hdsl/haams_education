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
@Table(name = "school_term", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolTerm.findAll", query = "SELECT s FROM SchoolTerm s"),
    @NamedQuery(name = "SchoolTerm.findBySchoolTermId", query = "SELECT s FROM SchoolTerm s WHERE s.schoolTermId = :schoolTermId"),
    @NamedQuery(name = "SchoolTerm.findByTermDesc", query = "SELECT s FROM SchoolTerm s WHERE s.termDesc = :termDesc")})
public class SchoolTerm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "school_term_id", nullable = false, length = 2)
    private String schoolTermId;
    @Size(max = 35)
    @Column(name = "term_desc", length = 35)
    private String termDesc;

    public SchoolTerm() {
    }

    public SchoolTerm(String schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public String getSchoolTermId() {
        return schoolTermId;
    }

    public void setSchoolTermId(String schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public String getTermDesc() {
        return termDesc;
    }

    public void setTermDesc(String termDesc) {
        this.termDesc = termDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolTermId != null ? schoolTermId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchoolTerm)) {
            return false;
        }
        SchoolTerm other = (SchoolTerm) object;
        if ((this.schoolTermId == null && other.schoolTermId != null) || (this.schoolTermId != null && !this.schoolTermId.equals(other.schoolTermId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.SchoolTerm[ schoolTermId=" + schoolTermId + " ]";
    }
    
}
