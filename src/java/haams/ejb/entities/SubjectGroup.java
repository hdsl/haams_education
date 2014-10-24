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
@Table(name = "subject_group", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectGroup.findAll", query = "SELECT s FROM SubjectGroup s"),
    @NamedQuery(name = "SubjectGroup.findBySubjectGroupId", query = "SELECT s FROM SubjectGroup s WHERE s.subjectGroupId = :subjectGroupId"),
    @NamedQuery(name = "SubjectGroup.findByInstitutionProgram", query = "SELECT s FROM SubjectGroup s WHERE s.institutionProgram = :institutionProgram"),
    @NamedQuery(name = "SubjectGroup.findBySubjectGroupName", query = "SELECT s FROM SubjectGroup s WHERE s.subjectGroupName = :subjectGroupName"),
    @NamedQuery(name = "SubjectGroup.findByGroupName", query = "SELECT s FROM SubjectGroup s WHERE s.groupName = :groupName"),
    @NamedQuery(name = "SubjectGroup.findBySubjectsIds", query = "SELECT s FROM SubjectGroup s WHERE s.subjectsIds = :subjectsIds"),
    @NamedQuery(name = "SubjectGroup.findByGroupStatus", query = "SELECT s FROM SubjectGroup s WHERE s.groupStatus = :groupStatus"),
    @NamedQuery(name = "SubjectGroup.findBySystemDate", query = "SELECT s FROM SubjectGroup s WHERE s.systemDate = :systemDate"),
    @NamedQuery(name = "SubjectGroup.findByDeleted", query = "SELECT s FROM SubjectGroup s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "SubjectGroup.findByUpdated", query = "SELECT s FROM SubjectGroup s WHERE s.updated = :updated")})
public class SubjectGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "subject_group_id", nullable = false, length = 35)
    private String subjectGroupId;
    @Size(max = 35)
    @Column(name = "institution_program", length = 35)
    private String institutionProgram;
    @Size(max = 255)
    @Column(name = "subject_group_name", length = 255)
    private String subjectGroupName;
    @Size(max = 50)
    @Column(name = "group_name", length = 50)
    private String groupName;
    @Size(max = 255)
    @Column(name = "subjects_ids", length = 255)
    private String subjectsIds;
    @Size(max = 15)
    @Column(name = "group_status", length = 15)
    private String groupStatus;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public SubjectGroup() {
    }

    public SubjectGroup(String subjectGroupId) {
        this.subjectGroupId = subjectGroupId;
    }

    public String getSubjectGroupId() {
        return subjectGroupId;
    }

    public void setSubjectGroupId(String subjectGroupId) {
        this.subjectGroupId = subjectGroupId;
    }

    public String getInstitutionProgram() {
        return institutionProgram;
    }

    public void setInstitutionProgram(String institutionProgram) {
        this.institutionProgram = institutionProgram;
    }

    public String getSubjectGroupName() {
        return subjectGroupName;
    }

    public void setSubjectGroupName(String subjectGroupName) {
        this.subjectGroupName = subjectGroupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubjectsIds() {
        return subjectsIds;
    }

    public void setSubjectsIds(String subjectsIds) {
        this.subjectsIds = subjectsIds;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
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
        hash += (subjectGroupId != null ? subjectGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectGroup)) {
            return false;
        }
        SubjectGroup other = (SubjectGroup) object;
        if ((this.subjectGroupId == null && other.subjectGroupId != null) || (this.subjectGroupId != null && !this.subjectGroupId.equals(other.subjectGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.SubjectGroup[ subjectGroupId=" + subjectGroupId + " ]";
    }
    
}
