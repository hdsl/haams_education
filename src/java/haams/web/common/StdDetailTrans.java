/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.common;

import haams.ejb.entities.Student;
import haams.ejb.services.CrudService;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author AbdulMumin
 */
public class StdDetailTrans {

    @Inject private CrudService crudService;
    
    public static StudentDetail studentDetail(Student stu) {
        StudentDetail detail = new StudentDetail();

        return studentDetail(stu, detail);
    }

    public static StudentDetail studentDetail(Student stu, StudentDetail detail) {
        detail.setStudentBasicId(stu.getCommonId());
        detail.setSurname(stu.getSurname());
        detail.setOthernames(stu.getOthernames());
        detail.setDateOfbirth(stu.getDateOfbirth());
        if (stu.getGender() == null) {

        } else {
            detail.setGender(stu.getGender().toString());
//            detail.setGenderInitals(stu.getGender().getInitial());
        }

        detail.setCurrentClass(stu.getAssignedClass().getClassName());
//        detail.setStudentPicture(stu.getStudentPicture());
        detail.setCurrentStatus(stu.getStudentAcademicStatus().getStudentAcademicStatusDesc());

        detail.setHometown(stu.getHometown());
        detail.setDateOfAdmission(stu.getDateOfAdmission());

        if (stu.getAssignedProgramme()!= null) {
            detail.setProgrammeOfStudy(stu.getAssignedProgramme().getProgramName());
        }

//        detail.setBoardingStatusInitials(stu.getBoardingStatusInitialString());
        detail.setBoardingStatus(stu.getResidenceStatus().getResidenceStatusDesc());
        System.out.println("THE BOARDING IS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + detail.getBoardingStatus());

        if (stu.getAssignedClass()!= null) {
            detail.setClassAdmittedTo(stu.getAssignedClass().getClassName());
        }

        detail.setGuardianPhysicalAddress(stu.getGuardianPhysicalAddress());

        detail.setGuardianName(stu.getGuardianName());
        detail.setGuardianContactNumber(stu.getGuardianContactNumber());
        detail.setGuardianOccupation(stu.getGuardianOccupation().getOccupationDesc());
        detail.setGuardianAddress(stu.getGuardianPostalAddress());
        detail.setRelationToGuardian(stu.getRelationToGuardian().getRelationDesc());

        if (stu.getResidenceOfAffiliation()!= null) {
            detail.setHouseOfResidence(stu.getResidenceOfAffiliation().getHouseName());
            //   System.out.println("House is :"+ stu.getHouseOfResidence().getHouseName());
        }
        if (stu.getRegion() != null) {
            detail.setRegion(stu.getRegion().getRegionName());
        }

//        if (stu.getCurrentSubjectCombination() != null) {
//            detail.setSubjectCombination(stu.getCurrentSubjectCombination().getSubjectCombinationName());
//            detail.setSubjectCombinationShortName(stu.getCurrentSubjectCombination().getCombinationShortName());
//        }

        return detail;
    }

    public static List<StudentDetail> studentDetails(List<Student> studentList) {
        List<StudentDetail> detailsList = new LinkedList<>();

        if (studentList == null) {
            return detailsList;
        }

        for (Student student : studentList) {
            try {
                StudentDetail studentDetail = studentDetail(student);
                System.out.println("THE STS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + studentDetail.getBoardingStatus());
                detailsList.add(studentDetail);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        return detailsList;
    }
}
