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
@Table(name = "academic_year_active_class", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademicYearActiveClass.findAll", query = "SELECT a FROM AcademicYearActiveClass a"),
    @NamedQuery(name = "AcademicYearActiveClass.findByAcademicYearClassId", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.academicYearClassId = :academicYearClassId"),
    @NamedQuery(name = "AcademicYearActiveClass.findByAcademicYear", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.academicYear = :academicYear"),
    @NamedQuery(name = "AcademicYearActiveClass.findByInstitutionClass", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.institutionClass = :institutionClass"),
    @NamedQuery(name = "AcademicYearActiveClass.findBySchoolReferenceId", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.schoolReferenceId = :schoolReferenceId"),
    @NamedQuery(name = "AcademicYearActiveClass.findByDeleted", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AcademicYearActiveClass.findByUpdated", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.updated = :updated"),
    @NamedQuery(name = "AcademicYearActiveClass.findBySystemDate", query = "SELECT a FROM AcademicYearActiveClass a WHERE a.systemDate = :systemDate")})
public class AcademicYearActiveClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "academic_year_class_id", nullable = false, length = 35)
    private String academicYearClassId;
    @Size(max = 35)
    @Column(name = "academic_year", length = 35)
    private String academicYear;
    @Size(max = 35)
    @Column(name = "institution_class", length = 35)
    private String institutionClass;
    @Size(max = 35)
    @Column(name = "school_reference_id", length = 35)
    private String schoolReferenceId;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public AcademicYearActiveClass() {
    }

    public AcademicYearActiveClass(String academicYearClassId) {
        this.academicYearClassId = academicYearClassId;
    }

    public String getAcademicYearClassId() {
        return academicYearClassId;
    }

    public void setAcademicYearClassId(String academicYearClassId) {
        this.academicYearClassId = academicYearClassId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(String institutionClass) {
        this.institutionClass = institutionClass;
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

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (academicYearClassId != null ? academicYearClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcademicYearActiveClass)) {
            return false;
        }
        AcademicYearActiveClass other = (AcademicYearActiveClass) object;
        if ((this.academicYearClassId == null && other.academicYearClassId != null) || (this.academicYearClassId != null && !this.academicYearClassId.equals(other.academicYearClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.AcademicYearActiveClass[ academicYearClassId=" + academicYearClassId + " ]";
    }
    
}
