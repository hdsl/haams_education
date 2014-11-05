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

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "educational_institution")
@NamedQueries({
    @NamedQuery(name = "EducationalInstitution.findAll", query = "SELECT e FROM EducationalInstitution e")})
public class EducationalInstitution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "institution_id")
    private String institutionId;
    @Size(max = 79)
    @Column(name = "institution_name")
    private String institutionName;
    @Size(max = 79)
    @Column(name = "institution_motor")
    private String institutionMotor;
    @Size(max = 35)
    @Column(name = "institution_cycle")
    private String institutionCycle;
    @Size(max = 15)
    @Column(name = "institution_primary_contact")
    private String institutionPrimaryContact;
    @Size(max = 15)
    @Column(name = "institution_other_contact")
    private String institutionOtherContact;
    @Lob
    @Size(max = 65535)
    @Column(name = "institution_address")
    private String institutionAddress;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "average_exam_score")
    private Double averageExamScore;
    @Size(max = 35)
    @Column(name = "current_academic_term")
    private String currentAcademicTerm;
    @Column(name = "average_class_score")
    private Double averageClassScore;
    @Size(max = 35)
    @Column(name = "server_name")
    private String serverName;
    @Size(max = 35)
    @Column(name = "pix_folder_name")
    private String pixFolderName;
    @Size(max = 45)
    @Column(name = "super_username")
    private String superUsername;
    @Size(max = 45)
    @Column(name = "super_password")
    private String superPassword;
    @Column(name = "date_of_registration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRegistration;

    public EducationalInstitution() {
    }

    public EducationalInstitution(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionMotor() {
        return institutionMotor;
    }

    public void setInstitutionMotor(String institutionMotor) {
        this.institutionMotor = institutionMotor;
    }

    public String getInstitutionCycle() {
        return institutionCycle;
    }

    public void setInstitutionCycle(String institutionCycle) {
        this.institutionCycle = institutionCycle;
    }

    public String getInstitutionPrimaryContact() {
        return institutionPrimaryContact;
    }

    public void setInstitutionPrimaryContact(String institutionPrimaryContact) {
        this.institutionPrimaryContact = institutionPrimaryContact;
    }

    public String getInstitutionOtherContact() {
        return institutionOtherContact;
    }

    public void setInstitutionOtherContact(String institutionOtherContact) {
        this.institutionOtherContact = institutionOtherContact;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public Double getAverageExamScore() {
        return averageExamScore;
    }

    public void setAverageExamScore(Double averageExamScore) {
        this.averageExamScore = averageExamScore;
    }

    public String getCurrentAcademicTerm() {
        return currentAcademicTerm;
    }

    public void setCurrentAcademicTerm(String currentAcademicTerm) {
        this.currentAcademicTerm = currentAcademicTerm;
    }

    public Double getAverageClassScore() {
        return averageClassScore;
    }

    public void setAverageClassScore(Double averageClassScore) {
        this.averageClassScore = averageClassScore;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPixFolderName() {
        return pixFolderName;
    }

    public void setPixFolderName(String pixFolderName) {
        this.pixFolderName = pixFolderName;
    }

    public String getSuperUsername() {
        return superUsername;
    }

    public void setSuperUsername(String superUsername) {
        this.superUsername = superUsername;
    }

    public String getSuperPassword() {
        return superPassword;
    }

    public void setSuperPassword(String superPassword) {
        this.superPassword = superPassword;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutionId != null ? institutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationalInstitution)) {
            return false;
        }
        EducationalInstitution other = (EducationalInstitution) object;
        if ((this.institutionId == null && other.institutionId != null) || (this.institutionId != null && !this.institutionId.equals(other.institutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haamsEdu.ejb.entities.EducationalInstitution[ institutionId=" + institutionId + " ]";
    }
    
}
