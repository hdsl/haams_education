/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "student_fee_ledger")
@NamedQueries({
    @NamedQuery(name = "StudentFeeLedger.findAll", query = "SELECT s FROM StudentFeeLedger s")})
public class StudentFeeLedger extends CommonEntity{
    
    @Column(name = "student_id")
    private String studentId;
  
    @Column(name = "academic_term_applied")
    private String academicTermApplied;
    
    @Column(name = "date_applied")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApplied;
    
    @Column(name = "date_of_payment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPayment;
    
    @Column(name = "type_of_entry")
    private String typeOfEntry;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "receipt_number")
    private String receiptNumber;    
    
    @JoinColumn(name = "student_bill")
    private StudentBill studentBill;
    
    @Column(name = "transaction_by")
    private String transactionBy;
    
    @Column(name = "mode_of_payment")
    private String modeOfPayment;
    
    @Column(name = "mode_of_payment_id")
    private String modeOfPaymentId;
    
    @Column(name = "transaction_entry_by")
    private String transactionEntryBy;
    
    public StudentFeeLedger() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAcademicTermApplied() {
        return academicTermApplied;
    }

    public void setAcademicTermApplied(String academicTermApplied) {
        this.academicTermApplied = academicTermApplied;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getTypeOfEntry() {
        return typeOfEntry;
    }

    public void setTypeOfEntry(String typeOfEntry) {
        this.typeOfEntry = typeOfEntry;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public StudentBill getStudentBill() {
        return studentBill;
    }

    public void setStudentBill(StudentBill studentBill) {
        this.studentBill = studentBill;
    }

    public String getTransactionBy() {
        return transactionBy;
    }

    public void setTransactionBy(String transactionBy) {
        this.transactionBy = transactionBy;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getModeOfPaymentId() {
        return modeOfPaymentId;
    }

    public void setModeOfPaymentId(String modeOfPaymentId) {
        this.modeOfPaymentId = modeOfPaymentId;
    }

    public String getTransactionEntryBy() {
        return transactionEntryBy;
    }

    public void setTransactionEntryBy(String transactionEntryBy) {
        this.transactionEntryBy = transactionEntryBy;
    }
    
}
