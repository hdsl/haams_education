/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.common;

import com.sabonay.common.formating.NumberFormattingUtils;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.GradingSystem;
import haams.ejb.entities.InstitutionSubject;
import haams.ejb.entities.Setting;
import haams.ejb.entities.StudentMark;
import haams.ejb.services.CrudService;
import haams.web.utils.StringConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author AbdulMumin
 */
public class ReportPreparationUtils {

    @Inject
    private CrudService crudService;

    private static List<SubjectAndMarks> listOfSubjectAndMarkses = new ArrayList<SubjectAndMarks>();
    private static GradingSystem selectedExamGradeDetail;

    public static String getMarkPostion(String className, String subjectCode, double totalSubjectMark) {

        if (totalSubjectMark == 0) {
            return "";
        }

        SubjectAndMarks requestedSubjectAndMarks = null;

        for (SubjectAndMarks subjectAndMarks : listOfSubjectAndMarkses) {
            if (subjectAndMarks.getSubjectCode().equalsIgnoreCase(subjectCode)) {
                requestedSubjectAndMarks = subjectAndMarks;
                break;
            }
        }

        if (requestedSubjectAndMarks == null) {
            requestedSubjectAndMarks = new SubjectAndMarks();

//            requestedSubjectAndMarks.setSubjectCode(subjectCode);
//
//            Setting setting = dataSource.getCommonQry().settingFind("CURRENT_TERM");
//
//            String currentTerm = setting.getSettingsValue();
//
//            List<StudentMark> studentMarksList
//                    = dataSource.getCustomQry().findAllClassSubjectMarksForTerm(
//                            className, subjectCode, currentTerm);
//
//            for (StudentMark studentMarkDetail : studentMarksList) {
//                requestedSubjectAndMarks.addStudentMarks(studentMarkDetail);
//            }
            requestedSubjectAndMarks.sortMarksForPositions();
        }

        String positionStr = "";
        int position = 0;

        position = requestedSubjectAndMarks.findPostionForMarks(totalSubjectMark);

        positionStr = NumberFormattingUtils.formatNumberAsPosition(position);

//        System.out.println(totalSubjectMark +" postion is " + position + " and string value is " + positionStr);
        return positionStr;
    }

    public static ExamMarkDetail prepareStudentMarkDetail(StudentMark studentMark) {
        double classMark = 0;
        double examMark = 0;
        double totalMarks = 0;

        boolean classMarkWasAvailable = false;
        boolean examMarkWasAvailable = false;

        String subjectCode = studentMark.getInstitutionSubject();
        String className = studentMark.getInstitutionClass();
//        String subjectName = dataSource.getCommonQry().institutionSubjectFind(studentMark.getInstitutionSubject()).getSubjectName();

        String totalMarksStr;

        ExamMarkDetail studentMarkDetail = new ExamMarkDetail();

        List<EducationalInstitution> configuration;
//                = dataSource.getCommonQry().educationalInstitutionGetAll(true);

        double classScorePercentage = 0;
//                configuration.get(0).getAverageClassScore();
        double examsScorePercentage = 0;
//                configuration.get(0).getAverageExamScore();

        if (studentMark.getStudentClassMark() != null) {
            classMark = studentMark.getStudentClassMark().doubleValue() * classScorePercentage;

            if (classMark != 0) {
                studentMarkDetail.setClassScore(NumberFormattingUtils.formatDouble(classMark, 2));
            } else {
                studentMarkDetail.setClassScore("-");
            }

            classMarkWasAvailable = true;
        } else {
            studentMarkDetail.setClassScore("-");
        }

        if (studentMark.getStudentExamMark() != null) {
            examMark = studentMark.getStudentExamMark().doubleValue() * examsScorePercentage;

            if (examMark != 0) {
                studentMarkDetail.setExamScore(NumberFormattingUtils.formatDouble(examMark, 2));
            } else {
                studentMarkDetail.setExamScore("-");
            }

            examMarkWasAvailable = true;
        } else {
            studentMarkDetail.setExamScore("-");
        }

        totalMarks = classMark + examMark;

        totalMarksStr = NumberFormattingUtils.formatDouble(totalMarks, 2);
        String totalMarksStrTotal = NumberFormattingUtils.formatDouble(totalMarks, 0);
        double totalMarkStrTotal = 0.0;
        try {
            totalMarks = Double.parseDouble(totalMarksStr);
            totalMarkStrTotal = Double.parseDouble(totalMarksStrTotal);
        } catch (Exception e) {
        }

//        selectedExamGradeDetail = StringConstants.getGradeOfMark(totalMarkStrTotal);
        //selectedExamGradeDetail = SabEduUtils.getGradeOfMark(totalMarks);
        String positionInSubject = getMarkPostion(className, subjectCode, totalMarks);

        studentMarkDetail.setSubjectCode(subjectCode);
//        studentMarkDetail.setSubjectName(subjectName);

        try {
            String subjectCategory = null;

//            InstitutionSubject is = dataSource.getCommonQry().institutionSubjectFind(studentMark.getInstitutionSubject());
//
//            if (is.getSubjectType().equals("CORE_SUBJECT")) {
//                subjectCategory = "Core Subject";
//            } else if (is.getSubjectType().equals("ELECTIVE_SUBJECT")) {
//                subjectCategory = "Elective Subject";
//            }
            studentMarkDetail.setSubjectCategory(subjectCategory);
        } catch (Exception e) {
        }

        if (totalMarks == 0.0) {
            studentMarkDetail.setTotalScore("-");
            studentMarkDetail.setPositionInClass("-");
        } else {
            studentMarkDetail.setTotalScore(totalMarksStr);
            studentMarkDetail.setPositionInClass(positionInSubject);
        }

        //setting of grades and remarks
        if ((selectedExamGradeDetail != null) && (totalMarks != 0.0)) {
            studentMarkDetail.setGrades(selectedExamGradeDetail.getCommonId());
            studentMarkDetail.setRemarks(selectedExamGradeDetail.getGradeDesc());
        } else {
            studentMarkDetail.setGrades("-");
            studentMarkDetail.setRemarks("-");
        }

        return studentMarkDetail;
    }
}
