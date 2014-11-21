/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "student_bill")
@NamedQueries({
    @NamedQuery(name = "StudentBill.findAll", query = "SELECT s FROM StudentBill s")})
public class StudentBill extends CommonEntity {
 
    @Column(name = "bill_item_type")
    private String billItemType;
    
    @JoinColumn(name = "bill_item")
    private StudentBillItem studentBillItem;
  
    @Column(name = "day_student_amt")
    private Double dayStudentAmt;
    
    @Column(name = "boarding_student_amt")
    private Double boardingStudentAmt;
   
    @Column(name = "academic_term")
    private String academicTerm;
    
    @Column(name = "institution_program")
    private String institutionProgram;
    
    @Column(name = "institution_level")
    private String institutionLevel;
   
    @Column(name = "institution_class")
    private String institutionClass;

    @Column(name = "student_type")
    private String studentType;

    public StudentBill() {
    }

    public String getBillItemType() {
        return billItemType;
    }

    public void setBillItemType(String billItemType) {
        this.billItemType = billItemType;
    }

    public StudentBillItem getStudentBillItem() {
        return studentBillItem;
    }

    public void setStudentBillItem(StudentBillItem studentBillItem) {
        this.studentBillItem = studentBillItem;
    }

    public Double getDayStudentAmt() {
        return dayStudentAmt;
    }

    public void setDayStudentAmt(Double dayStudentAmt) {
        this.dayStudentAmt = dayStudentAmt;
    }

    public Double getBoardingStudentAmt() {
        return boardingStudentAmt;
    }

    public void setBoardingStudentAmt(Double boardingStudentAmt) {
        this.boardingStudentAmt = boardingStudentAmt;
    }

    public String getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(String academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getInstitutionProgram() {
        return institutionProgram;
    }

    public void setInstitutionProgram(String institutionProgram) {
        this.institutionProgram = institutionProgram;
    }

    public String getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(String institutionLevel) {
        this.institutionLevel = institutionLevel;
    }

    public String getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(String institutionClass) {
        this.institutionClass = institutionClass;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

}
