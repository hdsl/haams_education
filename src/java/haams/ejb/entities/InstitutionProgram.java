/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HDSL_MUMIN
 */
@Entity
@Table(name = "institution_program", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitutionProgram.findAll", query = "SELECT i FROM InstitutionProgram i"),
    @NamedQuery(name = "InstitutionProgram.findByProgramId", query = "SELECT i FROM InstitutionProgram i WHERE i.programId = :programId"),
    @NamedQuery(name = "InstitutionProgram.findByProgramName", query = "SELECT i FROM InstitutionProgram i WHERE i.programName = :programName"),
    @NamedQuery(name = "InstitutionProgram.findByDeleted", query = "SELECT i FROM InstitutionProgram i WHERE i.deleted = :deleted"),
    @NamedQuery(name = "InstitutionProgram.findByUpdated", query = "SELECT i FROM InstitutionProgram i WHERE i.updated = :updated")})
public class InstitutionProgram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "program_id", nullable = false, length = 35)
    private String programId;
    @Size(max = 45)
    @Column(name = "program_name", length = 45)
    private String programName;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public InstitutionProgram() {
    }

    public InstitutionProgram(String programId) {
        this.programId = programId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitutionProgram)) {
            return false;
        }
        InstitutionProgram other = (InstitutionProgram) object;
        if ((this.programId == null && other.programId != null) || (this.programId != null && !this.programId.equals(other.programId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.InstitutionProgram[ programId=" + programId + " ]";
    }
    
}
