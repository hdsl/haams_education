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
@Table(name = "configuration", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c"),
    @NamedQuery(name = "Configuration.findByConfigurationId", query = "SELECT c FROM Configuration c WHERE c.configurationId = :configurationId"),
    @NamedQuery(name = "Configuration.findByConfigDesc", query = "SELECT c FROM Configuration c WHERE c.configDesc = :configDesc"),
    @NamedQuery(name = "Configuration.findByConfigStatus", query = "SELECT c FROM Configuration c WHERE c.configStatus = :configStatus"),
    @NamedQuery(name = "Configuration.findBySchoolReferenceId", query = "SELECT c FROM Configuration c WHERE c.schoolReferenceId = :schoolReferenceId"),
    @NamedQuery(name = "Configuration.findByDeleted", query = "SELECT c FROM Configuration c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "Configuration.findByUpdated", query = "SELECT c FROM Configuration c WHERE c.updated = :updated")})
public class Configuration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "configuration_id", nullable = false, length = 35)
    private String configurationId;
    @Size(max = 45)
    @Column(name = "config_desc", length = 45)
    private String configDesc;
    @Size(max = 15)
    @Column(name = "config_status", length = 15)
    private String configStatus;
    @Size(max = 35)
    @Column(name = "school_reference_id", length = 35)
    private String schoolReferenceId;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public Configuration() {
    }

    public Configuration(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }

    public String getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(String configStatus) {
        this.configStatus = configStatus;
    }

    public String getSchoolReferenceId() {
        return schoolReferenceId;
    }

    public void setSchoolReferenceId(String schoolReferenceId) {
        this.schoolReferenceId = schoolReferenceId;
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
        hash += (configurationId != null ? configurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.configurationId == null && other.configurationId != null) || (this.configurationId != null && !this.configurationId.equals(other.configurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.Configuration[ configurationId=" + configurationId + " ]";
    }
    
}
