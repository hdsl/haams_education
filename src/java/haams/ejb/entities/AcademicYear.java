/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "academic_year")
@NamedQueries({
    @NamedQuery(name = "AcademicYear.findAll", query = "SELECT a FROM AcademicYear a")})
public class AcademicYear extends CommonEntity {
   
    @Column(name = "academic_year_begin")
    @Temporal(TemporalType.DATE)    
    private Date academicYearBegin;
    
    @Column(name = "academic_year_end")
    @Temporal(TemporalType.DATE)    
    private Date academicYearEnd;
    
    public AcademicYear() {
    }

    public Date getAcademicYearBegin() {
        return academicYearBegin;
    }

    public void setAcademicYearBegin(Date academicYearBegin) {
        this.academicYearBegin = academicYearBegin;
    }

    public Date getAcademicYearEnd() {
        return academicYearEnd;
    }

    public void setAcademicYearEnd(Date academicYearEnd) {
        this.academicYearEnd = academicYearEnd;
    }

}
