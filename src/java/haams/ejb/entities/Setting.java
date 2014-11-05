/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "setting")
@NamedQueries({
    @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s")})
public class Setting extends CommonEntity {
   
    @Column(name = "settings_value")
    private String settingsValue;
    
    public Setting() {
    }

    public String getSettingsValue() {
        return settingsValue;
    }

    public void setSettingsValue(String settingsValue) {
        this.settingsValue = settingsValue;
    }

}
