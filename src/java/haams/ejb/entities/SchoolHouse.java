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
@Table(name = "school_house", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolHouse.findAll", query = "SELECT s FROM SchoolHouse s"),
    @NamedQuery(name = "SchoolHouse.findBySchoolHouseId", query = "SELECT s FROM SchoolHouse s WHERE s.schoolHouseId = :schoolHouseId"),
    @NamedQuery(name = "SchoolHouse.findByHouseName", query = "SELECT s FROM SchoolHouse s WHERE s.houseName = :houseName"),
    @NamedQuery(name = "SchoolHouse.findByGender", query = "SELECT s FROM SchoolHouse s WHERE s.gender = :gender"),
    @NamedQuery(name = "SchoolHouse.findByHouseMaster", query = "SELECT s FROM SchoolHouse s WHERE s.houseMaster = :houseMaster"),
    @NamedQuery(name = "SchoolHouse.findByDeleted", query = "SELECT s FROM SchoolHouse s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "SchoolHouse.findByUpdated", query = "SELECT s FROM SchoolHouse s WHERE s.updated = :updated")})
public class SchoolHouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "school_house_id", nullable = false, length = 35)
    private String schoolHouseId;
    @Size(max = 79)
    @Column(name = "house_name", length = 79)
    private String houseName;
    @Column(name = "gender")
    private Character gender;
    @Size(max = 79)
    @Column(name = "house_master", length = 79)
    private String houseMaster;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public SchoolHouse() {
    }

    public SchoolHouse(String schoolHouseId) {
        this.schoolHouseId = schoolHouseId;
    }

    public String getSchoolHouseId() {
        return schoolHouseId;
    }

    public void setSchoolHouseId(String schoolHouseId) {
        this.schoolHouseId = schoolHouseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getHouseMaster() {
        return houseMaster;
    }

    public void setHouseMaster(String houseMaster) {
        this.houseMaster = houseMaster;
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
        hash += (schoolHouseId != null ? schoolHouseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchoolHouse)) {
            return false;
        }
        SchoolHouse other = (SchoolHouse) object;
        if ((this.schoolHouseId == null && other.schoolHouseId != null) || (this.schoolHouseId != null && !this.schoolHouseId.equals(other.schoolHouseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.SchoolHouse[ schoolHouseId=" + schoolHouseId + " ]";
    }
    
}
