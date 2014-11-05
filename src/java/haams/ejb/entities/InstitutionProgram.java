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
@Table(name = "institution_program")
@NamedQueries({
    @NamedQuery(name = "InstitutionProgram.findAll", query = "SELECT i FROM InstitutionProgram i")})
public class InstitutionProgram extends CommonEntity{
   
    @Column(name = "program_name")
    private String programName;
    
    public InstitutionProgram() {
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

}
