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
@Table(name = "institution_subject")
@NamedQueries({
    @NamedQuery(name = "InstitutionSubject.findAll", query = "SELECT i FROM InstitutionSubject i")})
public class InstitutionSubject extends CommonEntity {
   
    @Column(name = "subject_name")
    private String subjectName;
   
    @Column(name = "subject_type")
    private String subjectType;
    
    public InstitutionSubject() {
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

}
