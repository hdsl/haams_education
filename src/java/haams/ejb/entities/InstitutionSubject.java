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
@Table(name = "institution_subject", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitutionSubject.findAll", query = "SELECT i FROM InstitutionSubject i"),
    @NamedQuery(name = "InstitutionSubject.findBySubjectId", query = "SELECT i FROM InstitutionSubject i WHERE i.subjectId = :subjectId"),
    @NamedQuery(name = "InstitutionSubject.findBySubjectName", query = "SELECT i FROM InstitutionSubject i WHERE i.subjectName = :subjectName"),
    @NamedQuery(name = "InstitutionSubject.findBySubjectType", query = "SELECT i FROM InstitutionSubject i WHERE i.subjectType = :subjectType"),
    @NamedQuery(name = "InstitutionSubject.findByDeleted", query = "SELECT i FROM InstitutionSubject i WHERE i.deleted = :deleted"),
    @NamedQuery(name = "InstitutionSubject.findByUpdated", query = "SELECT i FROM InstitutionSubject i WHERE i.updated = :updated")})
public class InstitutionSubject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "subject_id", nullable = false, length = 35)
    private String subjectId;
    @Size(max = 255)
    @Column(name = "subject_name", length = 255)
    private String subjectName;
    @Size(max = 35)
    @Column(name = "subject_type", length = 35)
    private String subjectType;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public InstitutionSubject() {
    }

    public InstitutionSubject(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
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
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitutionSubject)) {
            return false;
        }
        InstitutionSubject other = (InstitutionSubject) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.InstitutionSubject[ subjectId=" + subjectId + " ]";
    }
    
}
