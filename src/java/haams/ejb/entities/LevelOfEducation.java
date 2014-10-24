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
@Table(name = "level_of_education", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LevelOfEducation.findAll", query = "SELECT l FROM LevelOfEducation l"),
    @NamedQuery(name = "LevelOfEducation.findByLevelId", query = "SELECT l FROM LevelOfEducation l WHERE l.levelId = :levelId"),
    @NamedQuery(name = "LevelOfEducation.findByLevelDescription", query = "SELECT l FROM LevelOfEducation l WHERE l.levelDescription = :levelDescription")})
public class LevelOfEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "level_id", nullable = false, length = 2)
    private String levelId;
    @Size(max = 35)
    @Column(name = "level_description", length = 35)
    private String levelDescription;

    public LevelOfEducation() {
    }

    public LevelOfEducation(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (levelId != null ? levelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LevelOfEducation)) {
            return false;
        }
        LevelOfEducation other = (LevelOfEducation) object;
        if ((this.levelId == null && other.levelId != null) || (this.levelId != null && !this.levelId.equals(other.levelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.LevelOfEducation[ levelId=" + levelId + " ]";
    }
    
}
