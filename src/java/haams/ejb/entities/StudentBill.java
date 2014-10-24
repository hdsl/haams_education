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
@Table(name = "student_bill", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentBill.findAll", query = "SELECT s FROM StudentBill s"),
    @NamedQuery(name = "StudentBill.findByStudentBillId", query = "SELECT s FROM StudentBill s WHERE s.studentBillId = :studentBillId"),
    @NamedQuery(name = "StudentBill.findByBillItemType", query = "SELECT s FROM StudentBill s WHERE s.billItemType = :billItemType"),
    @NamedQuery(name = "StudentBill.findByBillItem", query = "SELECT s FROM StudentBill s WHERE s.billItem = :billItem"),
    @NamedQuery(name = "StudentBill.findByDayStudentAmt", query = "SELECT s FROM StudentBill s WHERE s.dayStudentAmt = :dayStudentAmt"),
    @NamedQuery(name = "StudentBill.findByBoardingStudentAmt", query = "SELECT s FROM StudentBill s WHERE s.boardingStudentAmt = :boardingStudentAmt"),
    @NamedQuery(name = "StudentBill.findByAcademicTerm", query = "SELECT s FROM StudentBill s WHERE s.academicTerm = :academicTerm"),
    @NamedQuery(name = "StudentBill.findByInstitutionProgram", query = "SELECT s FROM StudentBill s WHERE s.institutionProgram = :institutionProgram"),
    @NamedQuery(name = "StudentBill.findByInstitutionLevel", query = "SELECT s FROM StudentBill s WHERE s.institutionLevel = :institutionLevel"),
    @NamedQuery(name = "StudentBill.findByInstitutionClass", query = "SELECT s FROM StudentBill s WHERE s.institutionClass = :institutionClass"),
    @NamedQuery(name = "StudentBill.findByStudentType", query = "SELECT s FROM StudentBill s WHERE s.studentType = :studentType"),
    @NamedQuery(name = "StudentBill.findByUpdated", query = "SELECT s FROM StudentBill s WHERE s.updated = :updated"),
    @NamedQuery(name = "StudentBill.findByDeleted", query = "SELECT s FROM StudentBill s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentBill.findBySystemDate", query = "SELECT s FROM StudentBill s WHERE s.systemDate = :systemDate")})
public class StudentBill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "student_bill_id", nullable = false, length = 35)
    private String studentBillId;
    @Size(max = 35)
    @Column(name = "bill_item_type", length = 35)
    private String billItemType;
    @Size(max = 255)
    @Column(name = "bill_item", length = 255)
    private String billItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "day_student_amt", precision = 22)
    private Double dayStudentAmt;
    @Column(name = "boarding_student_amt", precision = 22)
    private Double boardingStudentAmt;
    @Size(max = 35)
    @Column(name = "academic_term", length = 35)
    private String academicTerm;
    @Size(max = 35)
    @Column(name = "institution_program", length = 35)
    private String institutionProgram;
    @Size(max = 35)
    @Column(name = "institution_level", length = 35)
    private String institutionLevel;
    @Size(max = 35)
    @Column(name = "institution_class", length = 35)
    private String institutionClass;
    @Size(max = 50)
    @Column(name = "student_type", length = 50)
    private String studentType;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "system_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public StudentBill() {
    }

    public StudentBill(String studentBillId) {
        this.studentBillId = studentBillId;
    }

    public String getStudentBillId() {
        return studentBillId;
    }

    public void setStudentBillId(String studentBillId) {
        this.studentBillId = studentBillId;
    }

    public String getBillItemType() {
        return billItemType;
    }

    public void setBillItemType(String billItemType) {
        this.billItemType = billItemType;
    }

    public String getBillItem() {
        return billItem;
    }

    public void setBillItem(String billItem) {
        this.billItem = billItem;
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

    public Character getUpdated() {
        return updated;
    }

    public void setUpdated(Character updated) {
        this.updated = updated;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentBillId != null ? studentBillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentBill)) {
            return false;
        }
        StudentBill other = (StudentBill) object;
        if ((this.studentBillId == null && other.studentBillId != null) || (this.studentBillId != null && !this.studentBillId.equals(other.studentBillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentBill[ studentBillId=" + studentBillId + " ]";
    }
    
}
