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
import javax.persistence.Lob;
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
@Table(name = "audit_trail", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditTrail.findAll", query = "SELECT a FROM AuditTrail a"),
    @NamedQuery(name = "AuditTrail.findByAuditTrailId", query = "SELECT a FROM AuditTrail a WHERE a.auditTrailId = :auditTrailId"),
    @NamedQuery(name = "AuditTrail.findBySystemUser", query = "SELECT a FROM AuditTrail a WHERE a.systemUser = :systemUser"),
    @NamedQuery(name = "AuditTrail.findBySchoolReferenceId", query = "SELECT a FROM AuditTrail a WHERE a.schoolReferenceId = :schoolReferenceId"),
    @NamedQuery(name = "AuditTrail.findByAcademicTerm", query = "SELECT a FROM AuditTrail a WHERE a.academicTerm = :academicTerm"),
    @NamedQuery(name = "AuditTrail.findBySystemTime", query = "SELECT a FROM AuditTrail a WHERE a.systemTime = :systemTime"),
    @NamedQuery(name = "AuditTrail.findByDeleted", query = "SELECT a FROM AuditTrail a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AuditTrail.findByUpdated", query = "SELECT a FROM AuditTrail a WHERE a.updated = :updated")})
public class AuditTrail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "audit_trail_id", nullable = false, length = 35)
    private String auditTrailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "system_user", nullable = false, length = 35)
    private String systemUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "school_reference_id", nullable = false, length = 35)
    private String schoolReferenceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "academic_term", nullable = false, length = 35)
    private String academicTerm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "system_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemTime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "trail_activity", nullable = false, length = 16777215)
    private String trailActivity;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public AuditTrail() {
    }

    public AuditTrail(String auditTrailId) {
        this.auditTrailId = auditTrailId;
    }

    public AuditTrail(String auditTrailId, String systemUser, String schoolReferenceId, String academicTerm, Date systemTime, String trailActivity) {
        this.auditTrailId = auditTrailId;
        this.systemUser = systemUser;
        this.schoolReferenceId = schoolReferenceId;
        this.academicTerm = academicTerm;
        this.systemTime = systemTime;
        this.trailActivity = trailActivity;
    }

    public String getAuditTrailId() {
        return auditTrailId;
    }

    public void setAuditTrailId(String auditTrailId) {
        this.auditTrailId = auditTrailId;
    }

    public String getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(String systemUser) {
        this.systemUser = systemUser;
    }

    public String getSchoolReferenceId() {
        return schoolReferenceId;
    }

    public void setSchoolReferenceId(String schoolReferenceId) {
        this.schoolReferenceId = schoolReferenceId;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public Date getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    public String getTrailActivity() {
        return trailActivity;
    }

    public void setTrailActivity(String trailActivity) {
        this.trailActivity = trailActivity;
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
        hash += (auditTrailId != null ? auditTrailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditTrail)) {
            return false;
        }
        AuditTrail other = (AuditTrail) object;
        if ((this.auditTrailId == null && other.auditTrailId != null) || (this.auditTrailId != null && !this.auditTrailId.equals(other.auditTrailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.AuditTrail[ auditTrailId=" + auditTrailId + " ]";
    }
    
}
