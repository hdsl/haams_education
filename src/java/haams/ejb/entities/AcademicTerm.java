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
@Table(name = "academic_term")
@NamedQueries({
    @NamedQuery(name = "AcademicTerm.findAll", query = "SELECT a FROM AcademicTerm a")})
public class AcademicTerm extends CommonEntity {
   
    @Column(name = "academic_year")
    private String academicYear;
   
    @Column(name = "term_desc")
    private String termDesc;
    
    @Column(name = "term_begin")
    @Temporal(TemporalType.DATE)
    private Date termBegin;
    
    @Column(name = "term_end")
    @Temporal(TemporalType.DATE)
    private Date termEnd;
    
    @Column(name = "exam_begin_date")
    @Temporal(TemporalType.DATE)
    private Date examBeginDate;
    
    @Column(name = "exam_end_date")
    @Temporal(TemporalType.DATE)
    private Date examEndDate;
    
    @Column(name = "active_term")
    private Character activeTerm;
    
    public AcademicTerm() {
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getTermDesc() {
        return termDesc;
    }

    public void setTermDesc(String termDesc) {
        this.termDesc = termDesc;
    }

    public Date getTermBegin() {
        return termBegin;
    }

    public void setTermBegin(Date termBegin) {
        this.termBegin = termBegin;
    }

    public Date getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(Date termEnd) {
        this.termEnd = termEnd;
    }

    public Date getExamBeginDate() {
        return examBeginDate;
    }

    public void setExamBeginDate(Date examBeginDate) {
        this.examBeginDate = examBeginDate;
    }

    public Date getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(Date examEndDate) {
        this.examEndDate = examEndDate;
    }

    public Character getActiveTerm() {
        return activeTerm;
    }

    public void setActiveTerm(Character activeTerm) {
        this.activeTerm = activeTerm;
    }

}
