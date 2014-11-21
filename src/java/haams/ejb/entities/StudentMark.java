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
@Table(name = "student_mark")
@NamedQueries({
    @NamedQuery(name = "StudentMark.findAll", query = "SELECT s FROM StudentMark s")})
public class StudentMark extends CommonEntity {
   
    @Column(name = "academic_term")
    private String academicTerm;
   
    @Column(name = "student_id")
    private String studentId;
 
    @Column(name = "institution_subject")
    private String institutionSubject;
    
    @Column(name = "subject_teacher")
    private String subjectTeacher;
   
    @Column(name = "institution_class")
    private String institutionClass;
   
    @Column(name = "student_class_mark")
    private Double studentClassMark;
    
    @Column(name = "student_exam_mark")
    private Double studentExamMark;
    
    public StudentMark() {
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getInstitutionSubject() {
        return institutionSubject;
    }

    public void setInstitutionSubject(String institutionSubject) {
        this.institutionSubject = institutionSubject;
    }

    public String getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(String institutionClass) {
        this.institutionClass = institutionClass;
    }

    public Double getStudentClassMark() {
        return studentClassMark;
    }

    public void setStudentClassMark(Double studentClassMark) {
        this.studentClassMark = studentClassMark;
    }

    public Double getStudentExamMark() {
        return studentExamMark;
    }

    public void setStudentExamMark(Double studentExamMark) {
        this.studentExamMark = studentExamMark;
    }

}
