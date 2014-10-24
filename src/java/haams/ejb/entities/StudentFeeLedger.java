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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HDSL_MUMIN
 */
@Entity
@Table(name = "student_fee_ledger", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentFeeLedger.findAll", query = "SELECT s FROM StudentFeeLedger s"),
    @NamedQuery(name = "StudentFeeLedger.findByStudentLedgerId", query = "SELECT s FROM StudentFeeLedger s WHERE s.studentLedgerId = :studentLedgerId"),
    @NamedQuery(name = "StudentFeeLedger.findByStudentId", query = "SELECT s FROM StudentFeeLedger s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "StudentFeeLedger.findByAcademicTermApplied", query = "SELECT s FROM StudentFeeLedger s WHERE s.academicTermApplied = :academicTermApplied"),
    @NamedQuery(name = "StudentFeeLedger.findByDateApplied", query = "SELECT s FROM StudentFeeLedger s WHERE s.dateApplied = :dateApplied"),
    @NamedQuery(name = "StudentFeeLedger.findByDateOfPayment", query = "SELECT s FROM StudentFeeLedger s WHERE s.dateOfPayment = :dateOfPayment"),
    @NamedQuery(name = "StudentFeeLedger.findByTypeOfEntry", query = "SELECT s FROM StudentFeeLedger s WHERE s.typeOfEntry = :typeOfEntry"),
    @NamedQuery(name = "StudentFeeLedger.findByAmount", query = "SELECT s FROM StudentFeeLedger s WHERE s.amount = :amount"),
    @NamedQuery(name = "StudentFeeLedger.findByReceiptNumber", query = "SELECT s FROM StudentFeeLedger s WHERE s.receiptNumber = :receiptNumber"),
    @NamedQuery(name = "StudentFeeLedger.findByStudentBill", query = "SELECT s FROM StudentFeeLedger s WHERE s.studentBill = :studentBill"),
    @NamedQuery(name = "StudentFeeLedger.findByTransactionBy", query = "SELECT s FROM StudentFeeLedger s WHERE s.transactionBy = :transactionBy"),
    @NamedQuery(name = "StudentFeeLedger.findByModeOfPayment", query = "SELECT s FROM StudentFeeLedger s WHERE s.modeOfPayment = :modeOfPayment"),
    @NamedQuery(name = "StudentFeeLedger.findByModeOfPaymentId", query = "SELECT s FROM StudentFeeLedger s WHERE s.modeOfPaymentId = :modeOfPaymentId"),
    @NamedQuery(name = "StudentFeeLedger.findByTransactionEntryBy", query = "SELECT s FROM StudentFeeLedger s WHERE s.transactionEntryBy = :transactionEntryBy"),
    @NamedQuery(name = "StudentFeeLedger.findByDeleted", query = "SELECT s FROM StudentFeeLedger s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentFeeLedger.findByUpdated", query = "SELECT s FROM StudentFeeLedger s WHERE s.updated = :updated")})
public class StudentFeeLedger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "student_ledger_id", nullable = false, length = 45)
    private String studentLedgerId;
    @Size(max = 35)
    @Column(name = "student_id", length = 35)
    private String studentId;
    @Size(max = 35)
    @Column(name = "academic_term_applied", length = 35)
    private String academicTermApplied;
    @Column(name = "date_applied")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApplied;
    @Column(name = "date_of_payment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPayment;
    @Size(max = 255)
    @Column(name = "type_of_entry", length = 255)
    private String typeOfEntry;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount", precision = 22)
    private Double amount;
    @Size(max = 255)
    @Column(name = "receipt_number", length = 255)
    private String receiptNumber;
    @Size(max = 255)
    @Column(name = "student_bill", length = 255)
    private String studentBill;
    @Size(max = 50)
    @Column(name = "transaction_by", length = 50)
    private String transactionBy;
    @Size(max = 35)
    @Column(name = "mode_of_payment", length = 35)
    private String modeOfPayment;
    @Size(max = 55)
    @Column(name = "mode_of_payment_id", length = 55)
    private String modeOfPaymentId;
    @Size(max = 35)
    @Column(name = "transaction_entry_by", length = 35)
    private String transactionEntryBy;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public StudentFeeLedger() {
    }

    public StudentFeeLedger(String studentLedgerId) {
        this.studentLedgerId = studentLedgerId;
    }

    public String getStudentLedgerId() {
        return studentLedgerId;
    }

    public void setStudentLedgerId(String studentLedgerId) {
        this.studentLedgerId = studentLedgerId;
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

    public String getStudentBill() {
        return studentBill;
    }

    public void setStudentBill(String studentBill) {
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
        hash += (studentLedgerId != null ? studentLedgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentFeeLedger)) {
            return false;
        }
        StudentFeeLedger other = (StudentFeeLedger) object;
        if ((this.studentLedgerId == null && other.studentLedgerId != null) || (this.studentLedgerId != null && !this.studentLedgerId.equals(other.studentLedgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentFeeLedger[ studentLedgerId=" + studentLedgerId + " ]";
    }
    
}
