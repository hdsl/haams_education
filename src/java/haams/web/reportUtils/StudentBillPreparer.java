/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.reportUtils;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.ClassMembership;
import haams.ejb.entities.SchoolHouse;
import haams.ejb.entities.StudentBillType;
import haams.ejb.entities.StudentFeeLedger;
import haams.ejb.entities.TransType;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.tableModel.StudentBillDetail;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author AbdulMumin
 */
public class StudentBillPreparer {

    @Inject
    private CrudService crudService;
    
    @Inject
    private CustomCrudService customCrudService;

    private double totalDebit;
    private double totalCredit;

    private double previousTermCredit;
    private double previousTermDebit;
    private double specialAmount;

    public List<StudentBillDetail> getStudentBill(List<ClassMembership> membershipList, String currentAcademicTerm) {

        List<StudentBillDetail> classBillDetails = new LinkedList<>();

        AcademicTerm term = crudService.find(AcademicTerm.class, currentAcademicTerm);

        if (!membershipList.isEmpty()) {

            StudentBillDetail bill = new StudentBillDetail();

            for (ClassMembership cm : membershipList) {

                List<StudentFeeLedger> previousFeeLedger = customCrudService.getStudentPreviousFeeLedger(cm.getStudent().getCommonId(), currentAcademicTerm);

                if (!previousFeeLedger.isEmpty()) {

                    for (StudentFeeLedger sfl : previousFeeLedger) {

                        String entryType = crudService.find(TransType.class, sfl.getTypeOfEntry()).getTypeDesc();

                        if (entryType.equals("CREDIT") || entryType.equals("CREDIT_BALANCE")) {

                            previousTermCredit += sfl.getAmount();

                        } else if (entryType.equals("DEBIT") || entryType.equals("DEBIT_BALANCE")) {

                            previousTermDebit += sfl.getAmount();

                        }

                    }

                }

                StudentBillDetail CRandDRFromPreviousTerm = new StudentBillDetail();
                CRandDRFromPreviousTerm.setDebitItemName("Arrears From Previous Term");
                CRandDRFromPreviousTerm.setCreditItemName("Credit From Previous Term");

                if (previousTermCredit > previousTermDebit) {
                    CRandDRFromPreviousTerm.setCreditItemAmt(previousTermCredit - previousTermDebit);
                    CRandDRFromPreviousTerm.setDebitItemAmt(0.0);
                } else {
                    CRandDRFromPreviousTerm.setDebitItemAmt(previousTermDebit - previousTermCredit);
                    CRandDRFromPreviousTerm.setCreditItemAmt(0.0);
                }

                classBillDetails.add(CRandDRFromPreviousTerm);

                String gender;

                if (cm.getStudent().getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }

                String studentName = cm.getStudent().getSurname() + " " + cm.getStudent().getOthernames() + " " + gender;

                CRandDRFromPreviousTerm.setStudentId(cm.getStudent().getCommonId());
                CRandDRFromPreviousTerm.setStudentName(studentName);
//                CRandDRFromPreviousTerm.setProgrammeOfStudy(dataSource.getCommonQry().institutionProgramFind(cm.getStudent().getAssignedProgramme()).getProgramName());
//                CRandDRFromPreviousTerm.setResidentialStatus(dataSource.getCommonQry().residenceStatusFind(cm.getStudent().getResidenceStatus()).getResidenceStatusDesc());
//                CRandDRFromPreviousTerm.setCurrentClass(cm.getStudent().getAssignedClass());
//
                List<StudentBillType> billTypes = crudService.findAll(StudentBillType.class, false);

                for (StudentBillType sbt : billTypes) {

                    List<StudentFeeLedger> sflList = customCrudService.selectedStudentCurrentFeeLedgerList(cm.getStudent().getCommonId(), currentAcademicTerm, sbt.getCommonId());

                    if (!sflList.isEmpty()) {

                        for (StudentFeeLedger ledger : sflList) {

                            bill.setStudentId(cm.getStudent().getCommonId());
                            bill.setStudentName(studentName);
//                            bill.setProgrammeOfStudy(dataSource.getCommonQry().institutionProgramFind(cm.getStudent().getAssignedProgramme()).getProgramName());
//                            bill.setResidentialStatus(dataSource.getCommonQry().residenceStatusFind(cm.getStudent().getResidenceStatus()).getResidenceStatusDesc());
//                            bill.setCurrentClass(cm.getStudent().getAssignedClass());
                            bill.setStudentBillType(sbt.getBillTypeName());

//                            StudentBill studentBill = ledger.getStudentBill(); ignore
                            if (cm.getStudent().getResidenceStatus().equals("BOSTD")) {

                                bill.setDebitItemName(ledger.getStudentBill().getStudentBillItem().getItemName());
                                bill.setDebitItemAmt(ledger.getStudentBill().getBoardingStudentAmt());
                                classBillDetails.add(bill);
                                bill = new StudentBillDetail();

                            } else if (cm.getStudent().getResidenceStatus().equals("DASTD")) {
                                bill.setDebitItemName(ledger.getStudentBill().getStudentBillItem().getItemName());
                                bill.setDebitItemAmt(ledger.getStudentBill().getDayStudentAmt());
                                classBillDetails.add(bill);
                                bill = new StudentBillDetail();
                            }
                        }
                    }
                }

            }

        }

        return classBillDetails;
    }

    public List<StudentBillDetail> getStudentFeesLedger(List<ClassMembership> membershipList, String currentAcademicTerm) {

        List<StudentBillDetail> classBillDetails = new LinkedList<>();

        AcademicTerm term = crudService.find(AcademicTerm.class, currentAcademicTerm);

        if (!membershipList.isEmpty()) {

            StudentBillDetail bill = new StudentBillDetail();

            for (ClassMembership cm : membershipList) {

                totalCredit = 0.0;
                totalDebit = 0.0;

                List<StudentFeeLedger> sflList = customCrudService.selectedStudentCurrentFeeLedgerList(cm.getStudent().getCommonId(), currentAcademicTerm);

                if (!sflList.isEmpty()) {

                    for (StudentFeeLedger ledger : sflList) {

                        String entryType = crudService.find(TransType.class,ledger.getTypeOfEntry()).getTypeDesc();

                        if (entryType.equals("CREDIT") || entryType.equals("CREDIT_BALANCE")) {

                            totalCredit += ledger.getAmount();

                        } else if (entryType.equals("DEBIT") || entryType.equals("DEBIT_BALANCE")) {

                            totalDebit += ledger.getAmount();

                        }
                    }

                }
                String gender;

                if (cm.getStudent().getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }

                String studentName = cm.getStudent().getSurname() + " " + cm.getStudent().getOthernames() + " " + gender;

                bill.setStudentId(cm.getStudent().getCommonId());
                bill.setStudentName(studentName);
//                bill.setResidentialStatus(crudService.find(SchoolHouse.class, cm.getStudent().getResidenceStatus()).getResidenceStatusDesc());
                bill.setDebitItemAmt(totalDebit);
                bill.setCreditItemAmt(totalCredit);
                bill.setOutstandingAmount(totalDebit - totalCredit);

                classBillDetails.add(bill);
                bill = new StudentBillDetail();
            }
        }

        return classBillDetails;
    }
}
