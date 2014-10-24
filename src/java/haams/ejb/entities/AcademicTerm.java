/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HDSL_MUMIN
 */
@Entity
@Table(name = "academic_term", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademicTerm.findAll", query = "SELECT a FROM AcademicTerm a"),
    @NamedQuery(name = "AcademicTerm.findByAcademicTermId", query = "SELECT a FROM AcademicTerm a WHERE a.academicTermId = :academicTermId"),
    @NamedQuery(name = "AcademicTerm.findByAcademicYear", query = "SELECT a FROM AcademicTerm a WHERE a.academicYear = :academicYear"),
    @NamedQuery(name = "AcademicTerm.findByTermDesc", query = "SELECT a FROM AcademicTerm a WHERE a.termDesc = :termDesc"),
    @NamedQuery(name = "AcademicTerm.findByTermBegin", query = "SELECT a FROM AcademicTerm a WHERE a.termBegin = :termBegin"),
    @NamedQuery(name = "AcademicTerm.findByTermEnd", query = "SELECT a FROM AcademicTerm a WHERE a.termEnd = :termEnd"),
    @NamedQuery(name = "AcademicTerm.findByExamBeginDate", query = "SELECT a FROM AcademicTerm a WHERE a.examBeginDate = :examBeginDate"),
    @NamedQuery(name = "AcademicTerm.findByExamEndDate", query = "SELECT a FROM AcademicTerm a WHERE a.examEndDate = :examEndDate"),
    @NamedQuery(name = "AcademicTerm.findByActiveTerm", query = "SELECT a FROM AcademicTerm a WHERE a.activeTerm = :activeTerm"),
    @NamedQuery(name = "AcademicTerm.findByDeleted", query = "SELECT a FROM AcademicTerm a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AcademicTerm.findByUpdated", query = "SELECT a FROM AcademicTerm a WHERE a.updated = :updated")})
public class AcademicTerm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "academic_term_id", nullable = false, length = 35)
    private String academicTermId;
    @Size(max = 35)
    @Column(name = "academic_year", length = 35)
    private String academicYear;
    @Size(max = 35)
    @Column(name = "term_desc", length = 35)
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
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public AcademicTerm() {
    }

    public AcademicTerm(String academicTermId) {
        this.academicTermId = academicTermId;
    }

    public String getAcademicTermId() {
        return academicTermId;
    }

    public void setAcademicTermId(String academicTermId) {
        this.academicTermId = academicTermId;
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
        hash += (academicTermId != null ? academicTermId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademicTerm)) {
            return false;
        }
        AcademicTerm other = (AcademicTerm) object;
        if ((this.academicTermId == null && other.academicTermId != null) || (this.academicTermId != null && !this.academicTermId.equals(other.academicTermId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.AcademicTerm[ academicTermId=" + academicTermId + " ]";
    }
    
}
