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
public class StudentBillDetail {

    private String debitItemName = "";
    private Double debitItemAmt = 0.0;
    private String creditItemName = "";
    private Double creditItemAmt = 0.0;
    private Double outstandingAmount = 0.0;
    private Double billAmount = 0.0;

    private String termOfReport = "";
    private String dateOfReport = "";
    private String studentId;
    private String studentName;
    private String residentialStatus;
    private String programmeOfStudy;
    private String currentClass;
    private String studentPicture;
    private String billItemName;

    private String nextTermBegins = "";

    private String studentBillType = "";

    private String reportTitle;

    public Double getCreditItemAmt() {
        return creditItemAmt;
    }

    public void setCreditItemAmt(Double creditItemAmt) {
        this.creditItemAmt = creditItemAmt;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillItemName() {
        return billItemName;
    }

    public void setBillItemName(String billItemName) {
        this.billItemName = billItemName;
    }

    public Double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(Double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getCreditItemName() {
        return creditItemName;
    }

    public void setCreditItemName(String creditItemName) {
        this.creditItemName = creditItemName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getProgrammeOfStudy() {
        return programmeOfStudy;
    }

    public void setProgrammeOfStudy(String programmeOfStudy) {
        this.programmeOfStudy = programmeOfStudy;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public String getStudentPicture() {
        return studentPicture;
    }

    public void setStudentPicture(String studentPicture) {
        this.studentPicture = studentPicture;
    }

    public String getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(String dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public Double getDebitItemAmt() {
        return debitItemAmt;
    }

    public void setDebitItemAmt(Double debitItemAmt) {
        this.debitItemAmt = debitItemAmt;
    }

    public String getDebitItemName() {
        return debitItemName;
    }

    public void setDebitItemName(String debitItemName) {
        this.debitItemName = debitItemName;
    }

    public String getNextTermBegins() {
        return nextTermBegins;
    }

    public void setNextTermBegins(String nextTermBegins) {
        this.nextTermBegins = nextTermBegins;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getTermOfReport() {
        return termOfReport;
    }

    public void setTermOfReport(String termOfReport) {
        this.termOfReport = termOfReport;
    }

    public String getStudentBillType() {
        return studentBillType;
    }

    public void setStudentBillType(String studentBillType) {
        this.studentBillType = studentBillType;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
