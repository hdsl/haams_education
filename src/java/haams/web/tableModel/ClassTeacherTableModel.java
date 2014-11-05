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
public class ClassTeacherTableModel {
    
    public String teacherName;
    public String teacherContact;
    public String staffId;
    public String classTeacherId;
    public String assignedClass;
    public String classProgramme;
    public String academicYear;
    public String academicLevel;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getClassProgramme() {
        return classProgramme;
    }

    public void setClassProgramme(String classProgramme) {
        this.classProgramme = classProgramme;
    }

    public String getTeacherContact() {
        return teacherContact;
    }

    public void setTeacherContact(String teacherContact) {
        this.teacherContact = teacherContact;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getAssignedClass() {
        return assignedClass;
    }

    public String getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(String classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public void setAssignedClass(String assignedClass) {
        this.assignedClass = assignedClass;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
    
    
}
