/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.ejb.entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "teacher_subject")
@NamedQueries({
    @NamedQuery(name = "TeacherSubject.findAll", query = "SELECT t FROM TeacherSubject t")})
public class TeacherSubject extends CommonEntity {

    @Column(name = "teacher_id")
    private String teacherId;
   
    @Column(name = "subject_id")
    private String subjectId;
  
    @Column(name = "teaching_classes")
    private String teachingClasses;
    
    @Column(name = "academic_term")
    private String academicTerm;
   
    public TeacherSubject() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeachingClasses() {
        return teachingClasses;
    }

    public void setTeachingClasses(String teachingClasses) {
        this.teachingClasses = teachingClasses;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    @Transient
    private List<InstitutionClass> institutionClassList = new LinkedList<>();

    public List<InstitutionClass> getInstitutionClassList() {
        institutionClassList.clear();

        if (teachingClasses == null) {
            return institutionClassList;
        }

        String[] classCodes = teachingClasses.split("/");

//        for (String classId : classCodes) {
//            InstitutionClass subjectClass = dataSource.getCommonQry().institutionClassFind(classId);
//
//            if (subjectClass != null) {
//                institutionClassList.add(subjectClass);
//            }
//        }
        return institutionClassList;
    }

    public void setInstitutionClassList(List<InstitutionClass> institutionClassList) {
        this.institutionClassList = institutionClassList;

        teachingClasses = "";

        for (InstitutionClass classId : institutionClassList) {
            teachingClasses = teachingClasses + "/" + classId.getCommonId();
        }

    }

}
