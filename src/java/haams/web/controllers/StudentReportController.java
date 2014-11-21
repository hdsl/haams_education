/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import com.sabonay.common.utils.DateTimeUtils;
import com.sabonay.modules.web.jsf.utilities.JsfUtil;
import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.GradingSystem;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.reports.HaamsEduReportMgr;
import haams.web.utils.StringConstants;
import haams.web.utils.UserSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named(value = "studentReportController")
@ConversationScoped
public class StudentReportController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    UserSession userSession;
    
    String selectedClass;
    
//    private List<StudentReportDetail> studentReportDetailList;
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public StudentReportController() {
    }

    public void generateStudentReport() {

        if (selectedClass == null) {
            StringConstants.showApprioprateMessage("Please select class");
        } else {
//
//            ExamReportPreparer reportPreparer = new ExamReportPreparer();
//            reportPreparer.prepareReportForClass(selectedClass, userSession.getAcademicTerm());

//            studentReportDetailList = reportPreparer.getStudentReportDetailList();

            viewSelectedReportDetail();
        }
    }

    public void viewSelectedReportDetail() {
        System.out.println("preparing final print out ...");
        try {

            String academicTermDesc = "";

            AcademicTerm academicTerm = crudService.find(AcademicTerm.class, userSession.getAcademicTerm());

            if (academicTerm.getTermDesc().equals("FIRST_TERM")) {
                academicTermDesc = "First Term";
            } else if (academicTerm.getTermDesc().equals("SECOND_TERM")) {
                academicTermDesc = "Second Term";
            } else if (academicTerm.getTermDesc().equals("THIRD_TERM")) {
                academicTermDesc = "Third Term";
            }

            String reportTitle = "Terminal Examination Report - " + academicTermDesc;

            String reportDate = DateTimeUtils.formatDateShort(new Date());

            String academicYear = academicTerm.getAcademicYear();

            String nextTermBeginsDate = StringConstants.getNextTermBeginDate();
//            String numberOnRoll = String.valueOf(studentReportDetailList.size()) + "";

            List<EducationalInstitution> config = crudService.findAll(EducationalInstitution.class, true);

            HaamsEduReportMgr.instance().initDefaultParamenters();

            HaamsEduReportMgr.instance().addParam("companyName", config.get(0).getInstitutionName());
            HaamsEduReportMgr.instance().addParam("companyAddress", config.get(0).getInstitutionAddress().replaceAll("\n", " "));
            HaamsEduReportMgr.instance().addParam("companyTelephone", config.get(0).getInstitutionPrimaryContact());
            HaamsEduReportMgr.instance().addParam("reportTitle", reportTitle);
            HaamsEduReportMgr.instance().addParam("academicYear", academicYear);
            HaamsEduReportMgr.instance().addParam("nextTermBegins", nextTermBeginsDate);
            HaamsEduReportMgr.instance().addParam("dateOfReport", DateTimeUtils.formatDateShort(academicTerm.getTermEnd()));
            //EducationRptMgr.instance().addParam("dateOfReport", reportDate);
//            HaamsEduReportMgr.instance().addParam("numberOnRoll", numberOnRoll);
//            ExamReportPreparer reportPreparer = new ExamReportPreparer();
//            HaamsEduReportMgr.instance().addParam("classAverage", ExamReportPreparer.allClassAverage);
//            System.out.println("THE CLASS AVERGAE IS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + reportPreparer.getClassAverage().getClassAverage());
            List<GradingSystem> allGrade = new ArrayList<GradingSystem>();
            allGrade = crudService.findAll(GradingSystem.class, true);
            String gradeInterpretation = "GRADE INTERPRETATION \n";
            gradeInterpretation += "-------------------------------------------------------------\n";
            for (GradingSystem grade : allGrade) {
                gradeInterpretation += grade.getGradeUpperBound().toString() + "\t\t\t\t\t\t -\t\t\t\t\t" + grade.getGradeLowerBound().toString() + "\t\t\t\t\t";
                gradeInterpretation += grade.getCommonId()+ "\t\t\t\t\t" + grade.getGradeDesc() + "\n ";
            }
            HaamsEduReportMgr.instance().addParam("grading", gradeInterpretation);
            HaamsEduReportMgr.instance().addParam("detailMarksSubReport", getClass().getResourceAsStream(HaamsEduReportMgr.STUDENT_TERMINAL_SUB));

            String reportOutputFile = selectedClass + "_exam_report_" + userSession.getAcademicTerm() + ".pdf";
//
//            if (reportViewingMode.equalsIgnoreCase(CommonOptions.VIEW_MODE_IN_WRITE)) {
//                HaamsEduReportMgr.instance().writePDFReportToFile(studentReportDetailList,
//                        EducationRptMgr.STUDENT_TERMINAL_EXAM, reportDirectory, reportOutputFile);
//                for (StudentReportDetail srd : studentReportDetailList) {
//                    //System.out.println("THE STUDENT >>>>>>>>>>>>>>>>"+srd.);
//                }
//            } else if (reportViewingMode.equalsIgnoreCase(CommonOptions.VIEW_MODE_IN_BROWSER)) {
//                HaamsEduReportMgr.instance().showPDFReport(studentReportDetailList,
//                        HaamsEduReportMgr.STUDENT_TERMINAL_EXAM);
//            } else {
//                HaamsEduReportMgr.instance().showPDFReport(studentReportDetailList,
//                        HaamsEduReportMgr.STUDENT_TERMINAL_EXAM);
//            }

//            HaamsEduReportMgr.instance().showPDFReport(studentReportDetailList, HaamsEduReportMgr.STUDENT_TERMINAL_EXAM);

        } catch (Exception e) {
            JsfUtil.addErrorMessageAndRespond("Error Occured in Generating Report : " + e.toString());
            e.printStackTrace();
        }
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public String getSelectedClass() {
        return selectedClass;
    }

    public void setSelectedClass(String selectedClass) {
        this.selectedClass = selectedClass;
    }

//    public List<StudentReportDetail> getStudentReportDetailList() {
//        return studentReportDetailList;
//    }
//
//    public void setStudentReportDetailList(List<StudentReportDetail> studentReportDetailList) {
//        this.studentReportDetailList = studentReportDetailList;
//    }
//</editor-fold>
}
