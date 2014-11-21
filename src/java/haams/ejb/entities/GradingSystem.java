/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "grading_system")
@NamedQueries({
    @NamedQuery(name = "GradingSystem.findAll", query = "SELECT g FROM GradingSystem g")})
public class GradingSystem extends CommonEntity {
    
    @Column(name = "grade_lower_bound")
    private Double gradeLowerBound;
    
    @Column(name = "grade_upper_bound")
    private Double gradeUpperBound;
    
    @Column(name = "grade_desc")
    private String gradeDesc;

    public GradingSystem() {
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
    
}
