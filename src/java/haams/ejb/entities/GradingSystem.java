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
@Table(name = "grading_system", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradingSystem.findAll", query = "SELECT g FROM GradingSystem g"),
    @NamedQuery(name = "GradingSystem.findByExamGradeId", query = "SELECT g FROM GradingSystem g WHERE g.examGradeId = :examGradeId"),
    @NamedQuery(name = "GradingSystem.findByGradeLowerBound", query = "SELECT g FROM GradingSystem g WHERE g.gradeLowerBound = :gradeLowerBound"),
    @NamedQuery(name = "GradingSystem.findByGradeUpperBound", query = "SELECT g FROM GradingSystem g WHERE g.gradeUpperBound = :gradeUpperBound"),
    @NamedQuery(name = "GradingSystem.findByGradeDesc", query = "SELECT g FROM GradingSystem g WHERE g.gradeDesc = :gradeDesc"),
    @NamedQuery(name = "GradingSystem.findByDeleted", query = "SELECT g FROM GradingSystem g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GradingSystem.findByUpdated", query = "SELECT g FROM GradingSystem g WHERE g.updated = :updated")})
public class GradingSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "exam_grade_id", nullable = false, length = 255)
    private String examGradeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grade_lower_bound", precision = 22)
    private Double gradeLowerBound;
    @Column(name = "grade_upper_bound", precision = 22)
    private Double gradeUpperBound;
    @Size(max = 45)
    @Column(name = "grade_desc", length = 45)
    private String gradeDesc;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public GradingSystem() {
    }

    public GradingSystem(String examGradeId) {
        this.examGradeId = examGradeId;
    }

    public String getExamGradeId() {
        return examGradeId;
    }

    public void setExamGradeId(String examGradeId) {
        this.examGradeId = examGradeId;
    }

    public Double getGradeLowerBound() {
        return gradeLowerBound;
    }

    public void setGradeLowerBound(Double gradeLowerBound) {
        this.gradeLowerBound = gradeLowerBound;
    }

    public Double getGradeUpperBound() {
        return gradeUpperBound;
    }

    public void setGradeUpperBound(Double gradeUpperBound) {
        this.gradeUpperBound = gradeUpperBound;
    }

    public String getGradeDesc() {
        return gradeDesc;
    }

    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
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
        hash += (examGradeId != null ? examGradeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradingSystem)) {
            return false;
        }
        GradingSystem other = (GradingSystem) object;
        if ((this.examGradeId == null && other.examGradeId != null) || (this.examGradeId != null && !this.examGradeId.equals(other.examGradeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.GradingSystem[ examGradeId=" + examGradeId + " ]";
    }
    
}
