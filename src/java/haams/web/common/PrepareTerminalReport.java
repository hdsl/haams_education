/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.common;

import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.GradingSystem;
import haams.ejb.entities.StudentMark;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AbdulMumin
 */
public class PrepareTerminalReport implements Serializable {

//    private static List<StudentMarksTableModel> preparedList = new ArrayList<>();
//
//    public static List<StudentMarksTableModel> prepareStudentTerminalReport(String academicTerm, String selectedClass, String studentId) {
//
//        List<EducationalInstitution> configuration = dataSource.getCommonQry().educationalInstitutionGetAll(true);
//
//        double classScorePercentage = configuration.get(0).getAverageClassScore();
//        double examsScorePercentage = configuration.get(0).getAverageExamScore();
//
//        List<StudentMark> studentSubjectMarks
//                = dataSource.getCustomQry().getStudentSubjectsMark(academicTerm, selectedClass, studentId);
//
//        if (!studentSubjectMarks.isEmpty()) {
//
//            for (StudentMark sm : studentSubjectMarks) {
//
//                StudentMarksTableModel smtm = new StudentMarksTableModel();
//
//                smtm.setStudentSubjects(dataSource.getCommonQry().institutionSubjectFind(sm.getInstitutionSubject()).getSubjectName());
//
//                double averageClassMark = classScorePercentage * sm.getStudentClassMark();
//
//                double averageExamsMark = examsScorePercentage * sm.getStudentExamMark();
//
//                double averageTotalMark = averageClassMark + averageExamsMark;
//
//                smtm.setClassMark(averageClassMark);
//                smtm.setExamsMark(averageExamsMark);
//                smtm.setTotalMark(averageTotalMark);
//
//                List<GradingSystem> gradingSystemList = dataSource.getCustomQry().loadAllExamGrading();
//
//                for (GradingSystem gs : gradingSystemList) {
//
//                    if (averageTotalMark >= gs.getGradeLowerBound() && averageTotalMark <= gs.getGradeUpperBound()) {
//                        smtm.setAcademicGrade(gs.getExamGradeId());
//                        smtm.setGradeRemark(gs.getGradeDesc());
//                    }
//                }
//
//                preparedList.add(smtm);
//
//            }
//
//        }
//
//        return preparedList;
//    }
}
