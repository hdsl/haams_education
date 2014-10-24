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
import javax.persistence.Lob;
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
@Table(name = "setting", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s"),
    @NamedQuery(name = "Setting.findBySettingsId", query = "SELECT s FROM Setting s WHERE s.settingsId = :settingsId"),
    @NamedQuery(name = "Setting.findByDeleted", query = "SELECT s FROM Setting s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "Setting.findByUpdated", query = "SELECT s FROM Setting s WHERE s.updated = :updated")})
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "settings_id", nullable = false, length = 200)
    private String settingsId;
    @Lob
    @Size(max = 65535)
    @Column(name = "settings_value", length = 65535)
    private String settingsValue;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public Setting() {
    }

    public Setting(String settingsId) {
        this.settingsId = settingsId;
    }

    public String getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(String settingsId) {
        this.settingsId = settingsId;
    }

    public String getSettingsValue() {
        return settingsValue;
    }

    public void setSettingsValue(String settingsValue) {
        this.settingsValue = settingsValue;
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
        hash += (settingsId != null ? settingsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        if ((this.settingsId == null && other.settingsId != null) || (this.settingsId != null && !this.settingsId.equals(other.settingsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.Setting[ settingsId=" + settingsId + " ]";
    }
    
}
