/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.tableModel;

/**
 *
 * @author AbdulMumin
 */
public class SubjectTeacherTableModel {
    
    private String academicTerm;
    private String subjectName;
    private String subjectTeacherName;
    private String subjectTeacherId;
    private String subjectClass;
    
    private Integer studentPopulation;

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public Integer getStudentPopulation() {
        return studentPopulation;
    }

    public void setStudentPopulation(Integer studentPopulation) {
        this.studentPopulation = studentPopulation;
    }

    public String getSubjectTeacherId() {
        return subjectTeacherId;
    }

    public void setSubjectTeacherId(String subjectTeacherId) {
        this.subjectTeacherId = subjectTeacherId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectTeacherName() {
        return subjectTeacherName;
    }

    public void setSubjectTeacherName(String subjectTeacherName) {
        this.subjectTeacherName = subjectTeacherName;
    }

    public String getSubjectClass() {
        return subjectClass;
    }

    public void setSubjectClass(String subjectClass) {
        this.subjectClass = subjectClass;
    }
    
    
}
