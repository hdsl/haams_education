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
@Table(name = "academic_year", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademicYear.findAll", query = "SELECT a FROM AcademicYear a"),
    @NamedQuery(name = "AcademicYear.findByAcademicYearId", query = "SELECT a FROM AcademicYear a WHERE a.academicYearId = :academicYearId"),
    @NamedQuery(name = "AcademicYear.findByAcademicYearBegin", query = "SELECT a FROM AcademicYear a WHERE a.academicYearBegin = :academicYearBegin"),
    @NamedQuery(name = "AcademicYear.findByAcademicYearEnd", query = "SELECT a FROM AcademicYear a WHERE a.academicYearEnd = :academicYearEnd"),
    @NamedQuery(name = "AcademicYear.findByDeleted", query = "SELECT a FROM AcademicYear a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AcademicYear.findByUpdated", query = "SELECT a FROM AcademicYear a WHERE a.updated = :updated")})
public class AcademicYear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "academic_year_id", nullable = false, length = 35)
    private String academicYearId;
    @Column(name = "academic_year_begin")
    @Temporal(TemporalType.DATE)
    private Date academicYearBegin;
    @Column(name = "academic_year_end")
    @Temporal(TemporalType.DATE)
    private Date academicYearEnd;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public AcademicYear() {
    }

    public AcademicYear(String academicYearId) {
        this.academicYearId = academicYearId;
    }

    public String getAcademicYearId() {
        return academicYearId;
    }

    public void setAcademicYearId(String academicYearId) {
        this.academicYearId = academicYearId;
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
        hash += (academicYearId != null ? academicYearId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademicYear)) {
            return false;
        }
        AcademicYear other = (AcademicYear) object;
        if ((this.academicYearId == null && other.academicYearId != null) || (this.academicYearId != null && !this.academicYearId.equals(other.academicYearId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.AcademicYear[ academicYearId=" + academicYearId + " ]";
    }
    
}
