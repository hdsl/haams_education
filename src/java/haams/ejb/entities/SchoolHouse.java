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
@Table(name = "school_house")
@NamedQueries({
    @NamedQuery(name = "SchoolHouse.findAll", query = "SELECT s FROM SchoolHouse s")})
public class SchoolHouse extends CommonEntity {
    
    @Column(name = "house_name")
    private String houseName;
    
    @Column(name = "gender")
    private Character gender;
    
    @Column(name = "house_master")
    private String houseMaster;

    public SchoolHouse() {
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

}
