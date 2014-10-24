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
@Table(name = "academic_level", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademicLevel.findAll", query = "SELECT a FROM AcademicLevel a"),
    @NamedQuery(name = "AcademicLevel.findByAcademicLevelId", query = "SELECT a FROM AcademicLevel a WHERE a.academicLevelId = :academicLevelId"),
    @NamedQuery(name = "AcademicLevel.findByAcademicLevelName", query = "SELECT a FROM AcademicLevel a WHERE a.academicLevelName = :academicLevelName")})
public class AcademicLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "academic_level_id", nullable = false, length = 20)
    private String academicLevelId;
    @Size(max = 45)
    @Column(name = "academic_level_name", length = 45)
    private String academicLevelName;

    public AcademicLevel() {
    }

    public AcademicLevel(String academicLevelId) {
        this.academicLevelId = academicLevelId;
    }

    public String getAcademicLevelId() {
        return academicLevelId;
    }

    public void setAcademicLevelId(String academicLevelId) {
        this.academicLevelId = academicLevelId;
    }

    public String getAcademicLevelName() {
        return academicLevelName;
    }

    public void setAcademicLevelName(String academicLevelName) {
        this.academicLevelName = academicLevelName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (academicLevelId != null ? academicLevelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademicLevel)) {
            return false;
        }
        AcademicLevel other = (AcademicLevel) object;
        if ((this.academicLevelId == null && other.academicLevelId != null) || (this.academicLevelId != null && !this.academicLevelId.equals(other.academicLevelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.AcademicLevel[ academicLevelId=" + academicLevelId + " ]";
    }
    
}
