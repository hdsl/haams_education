/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.utils;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.AcademicYear;
import haams.ejb.entities.AccessRight;
import haams.ejb.entities.InstitutionProgram;
import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.KinRelation;
import haams.ejb.entities.LevelOfEducation;
import haams.ejb.entities.MaritalStatus;
import haams.ejb.entities.Nationality;
import haams.ejb.entities.Occupation;
import haams.ejb.entities.Region;
import haams.ejb.entities.ResidenceStatus;
import haams.ejb.entities.SchoolHouse;
import haams.ejb.entities.SchoolTerm;
import haams.ejb.entities.StaffCategory;
import haams.ejb.entities.StudentAcademicStatus;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 *
 */
@ManagedBean
@RequestScoped
public class CommonOptions implements Serializable {

    @Inject private CrudService crudService;
    
    @Inject private CustomCrudService customCrudService;
    
    private SelectItem[] calendarYears;
    private SelectItem[] calenderMonthNamesOptions;
    private SelectItem[] nationality;
    private SelectItem[] maritalStatus;
    private SelectItem[] identificationTypes;
    private SelectItem[] accessRightTypes;
    private SelectItem[] kinRelationOptions;
    private SelectItem[] occupationTypeOptions;
    private SelectItem[] levelOfEducationOptions;

    private SelectItem[] academicYearOptions;
    private SelectItem[] academicTermOptions;
    private SelectItem[] schoolHouseOptions;
    private SelectItem[] academicStatusOptions;
    private SelectItem[] regionOptions;
    private SelectItem[] academicCoursesOptions;
    private SelectItem[] academicLevelOptions;
    private SelectItem[] schoolTermOptions;
    private SelectItem[] boardingStatusOptions;
    private SelectItem[] subjectCombinationOptions;
    private SelectItem[] staffCategoryOptions;
    private SelectItem[] teachingStaffOptions;
    private SelectItem[] schoolStaffOptions;
    private SelectItem[] studentClassOptions;
    private SelectItem[] studentBillTypeOptions;
    private SelectItem[] studentBillItemOptions;
    private SelectItem[] subjectOptions;
    private SelectItem[] commentTypeOptions;

    public CommonOptions() {
    }

//    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public SelectItem[] getCalendarYears() {
        return calendarYears;
    }

    public void setCalendarYears(SelectItem[] calendarYears) {
        this.calendarYears = calendarYears;
    }

//    public SelectItem[] getCommentTypeOptions() {
//
//        List<CommentType> commentTypeList = dataSource.getCustomQry().getCommentTypes();
//
//        if (!commentTypeList.isEmpty()) {
//
//            commentTypeOptions = new SelectItem[commentTypeList.size()];
//
//            int count = 0;
//
//            for (CommentType estProp : commentTypeList) {
//
//                commentTypeOptions[count] = new SelectItem(estProp.getCommentTypeId(), estProp.getCommentName());
//
//                count++;
//            }
//        }
//        return commentTypeOptions;
//    }

    public void setCommentTypeOptions(SelectItem[] commentTypeOptions) {
        this.commentTypeOptions = commentTypeOptions;
    }

    public SelectItem[] getSchoolStaffOptions() {

        List<InstitutionStaff> institutionStaffList = crudService.findAll(InstitutionStaff.class, false);

        if (institutionStaffList.size() > 0) {

            schoolStaffOptions = new SelectItem[institutionStaffList.size()];

            int count = 0;

            for (InstitutionStaff estProp : institutionStaffList) {

                String gender;

                if (estProp.getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }

                String staffName = estProp.getSurname().toUpperCase() + " " + estProp.getOtherName() + " " + gender;

                schoolStaffOptions[count] = new SelectItem(estProp.getCommonId(), staffName);

                count++;
            }
        }
        return schoolStaffOptions;
    }

    public void setSchoolStaffOptions(SelectItem[] schoolStaffOptions) {
        this.schoolStaffOptions = schoolStaffOptions;
    }

//    public SelectItem[] getSubjectOptions() {
//
//        List<InstitutionSubject> institutionSubjectList = dataSource.getCommonQry().institutionSubjectGetAll(false);
//
//        if (institutionSubjectList.size() > 0) {
//
//            subjectOptions = new SelectItem[institutionSubjectList.size()];
//
//            int count = 0;
//
//            for (InstitutionSubject estProp : institutionSubjectList) {
//                subjectOptions[count] = new SelectItem(estProp.getSubjectId(), estProp.getSubjectName());
//
//                count++;
//            }
//        }
//        return subjectOptions;
//    }

    public void setSubjectOptions(SelectItem[] subjectOptions) {
        this.subjectOptions = subjectOptions;
    }

//    public SelectItem[] getStudentBillItemOptions() {
//
//        List<StudentBillItem> studentBillItemList = dataSource.getCommonQry().studentBillItemGetAll(false);
//
//        if (studentBillItemList.size() > 0) {
//
//            studentBillItemOptions = new SelectItem[studentBillItemList.size()];
//
//            int count = 0;
//
//            for (StudentBillItem estProp : studentBillItemList) {
//                studentBillItemOptions[count] = new SelectItem(estProp.getBillItemId(), estProp.getItemName());
//
//                count++;
//            }
//        }
//        return studentBillItemOptions;
//    }

    public void setStudentBillItemOptions(SelectItem[] studentBillItemOptions) {
        this.studentBillItemOptions = studentBillItemOptions;
    }

//    public SelectItem[] getStudentBillTypeOptions() {
//
//        List<StudentBillType> studentBillTypeList = dataSource.getCommonQry().studentBillTypeGetAll(true);
//
//        if (studentBillTypeList.size() > 0) {
//
//            studentBillTypeOptions = new SelectItem[studentBillTypeList.size()];
//
//            int count = 0;
//
//            for (StudentBillType estProp : studentBillTypeList) {
//                studentBillTypeOptions[count] = new SelectItem(estProp.getStudentBillTypeId(), estProp.getBillTypeName());
//
//                count++;
//            }
//        }
//        return studentBillTypeOptions;
//    }

    public void setStudentBillTypeOptions(SelectItem[] studentBillTypeOptions) {
        this.studentBillTypeOptions = studentBillTypeOptions;
    }

//    public SelectItem[] getStudentClassOptions() {
//
//        List<InstitutionClass> institutionClassList = dataSource.getCommonQry().institutionClassGetAll(false);
//
//        if (institutionClassList.size() > 0) {
//
//            studentClassOptions = new SelectItem[institutionClassList.size()];
//
//            int count = 0;
//
//            for (InstitutionClass estProp : institutionClassList) {
//                studentClassOptions[count] = new SelectItem(estProp.getClassId(), estProp.getClassName());
//
//                count++;
//            }
//        }
//        return studentClassOptions;
//    }

    public void setStudentClassOptions(SelectItem[] studentClassOptions) {
        this.studentClassOptions = studentClassOptions;
    }

//    public SelectItem[] getTeachingStaffOptions() {
//        List<InstitutionStaff> institutionStaffList = dataSource.getCustomQry().institutionTeachingStaffGetAll(false);
//
//        if (institutionStaffList.size() > 0) {
//
//            teachingStaffOptions = new SelectItem[institutionStaffList.size()];
//
//            int count = 0;
//
//            for (InstitutionStaff estProp : institutionStaffList) {
//
//                String gender;
//
//                if (estProp.getGender().equals('F')) {
//                    gender = "(Miss.)";
//                } else {
//                    gender = "(Mr.)";
//                }
//
//                String staffName = estProp.getSurname().toUpperCase() + " " + estProp.getOtherName() + " " + gender;
//
//                teachingStaffOptions[count] = new SelectItem(estProp.getStaffId(), staffName);
//
//                count++;
//            }
//        }
//        return teachingStaffOptions;
//    }

    public void setTeachingStaffOptions(SelectItem[] teachingStaffOptions) {
        this.teachingStaffOptions = teachingStaffOptions;
    }

    public SelectItem[] getStaffCategoryOptions() {
        List<StaffCategory> staffCategoryList = crudService.findAll(StaffCategory.class, true);

        if (staffCategoryList.size() > 0) {

            staffCategoryOptions = new SelectItem[staffCategoryList.size()];

            int count = 0;

            for (StaffCategory estProp : staffCategoryList) {
                staffCategoryOptions[count] = new SelectItem(estProp.getStaffCategoryId(), estProp.getStaffCategoryDesc());

                count++;
            }
        }
        return staffCategoryOptions;
    }

    public void setStaffCategoryOptions(SelectItem[] staffCategoryOptions) {
        this.staffCategoryOptions = staffCategoryOptions;
    }

    public SelectItem[] getLevelOfEducationOptions() {
        
        List<LevelOfEducation> levelOfEducationList = crudService.findAll(LevelOfEducation.class, true);

        if (levelOfEducationList.size() > 0) {

            levelOfEducationOptions = new SelectItem[levelOfEducationList.size()];

            int count = 0;

            for (LevelOfEducation estProp : levelOfEducationList) {
                levelOfEducationOptions[count] = new SelectItem(estProp.getLevelId(), estProp.getLevelDescription());

                count++;
            }
        }
        return levelOfEducationOptions;
    }

    public void setLevelOfEducationOptions(SelectItem[] levelOfEducationOptions) {
        this.levelOfEducationOptions = levelOfEducationOptions;
    }

//    public SelectItem[] getSubjectCombinationOptions() {
//
//        List<SubjectGroup> subjectGroupList = dataSource.getCommonQry().subjectGroupGetAll(false);
//
//        subjectCombinationOptions = new SelectItem[subjectGroupList.size()];
//
//        int count = 0;
//
//        for (SubjectGroup sas : subjectGroupList) {
//            subjectCombinationOptions[count] = new SelectItem(sas.getSubjectGroupId(), sas.getSubjectGroupName());
//
//            count++;
//        }
//
//        return subjectCombinationOptions;
//    }

    public void setSubjectCombinationOptions(SelectItem[] subjectCombinationOptions) {
        this.subjectCombinationOptions = subjectCombinationOptions;
    }

    public SelectItem[] getAcademicTermOptions() {

        List<AcademicTerm> academicTermList = crudService.findAll(AcademicTerm.class, false);

        academicTermOptions = new SelectItem[academicTermList.size()];

        int count = 0;

        for (AcademicTerm sas : academicTermList) {
            academicTermOptions[count] = new SelectItem(sas.getCommonId(), sas.getCommonId());

            count++;
        }
        return academicTermOptions;
    }

    public void setAcademicTermOptions(SelectItem[] academicTermOptions) {
        this.academicTermOptions = academicTermOptions;
    }

    public SelectItem[] getSchoolHouseOptions() {

        List<SchoolHouse> schoolHouseList = crudService.findAll(SchoolHouse.class, false);

        schoolHouseOptions = new SelectItem[schoolHouseList.size()];

        int count = 0;

        for (SchoolHouse sas : schoolHouseList) {
            schoolHouseOptions[count] = new SelectItem(sas.getCommonId(), sas.getHouseName());

            count++;
        }
        return schoolHouseOptions;
    }

    public void setSchoolHouseOptions(SelectItem[] schoolHouseOptions) {
        this.schoolHouseOptions = schoolHouseOptions;
    }

    public SelectItem[] getBoardingStatusOptions() {

        List<ResidenceStatus> residenceStatusList = crudService.findAll(ResidenceStatus.class, true);

        boardingStatusOptions = new SelectItem[residenceStatusList.size()];

        int count = 0;

        for (ResidenceStatus sas : residenceStatusList) {
            boardingStatusOptions[count] = new SelectItem(sas.getResidenceStatusId(), sas.getResidenceStatusDesc());

            count++;
        }

        return boardingStatusOptions;
    }

    public void setBoardingStatusOptions(SelectItem[] boardingStatusOptions) {
        this.boardingStatusOptions = boardingStatusOptions;
    }

    public SelectItem[] getAcademicStatusOptions() {

        List<StudentAcademicStatus> studentAcademicStatusList = crudService.findAll(StudentAcademicStatus.class, true);

        academicStatusOptions = new SelectItem[studentAcademicStatusList.size()];

        int count = 0;

        for (StudentAcademicStatus sas : studentAcademicStatusList) {
            academicStatusOptions[count] = new SelectItem(sas.getStudentAcademicStatusId(), sas.getStudentAcademicStatusDesc());

            count++;
        }

        return academicStatusOptions;
    }

    public void setAcademicStatusOptions(SelectItem[] academicStatusOptions) {
        this.academicStatusOptions = academicStatusOptions;
    }

    public SelectItem[] getKinRelationOptions() {

        List<KinRelation> kinRelationList = crudService.findAll(KinRelation.class, true);

        kinRelationOptions = new SelectItem[kinRelationList.size()];

        int count = 0;

        for (KinRelation kinRelation : kinRelationList) {
            kinRelationOptions[count] = new SelectItem(kinRelation.getKinRelationId(), kinRelation.getRelationDesc());

            count++;
        }

        return kinRelationOptions;
    }

    public void setKinRelationOptions(SelectItem[] kinRelationOptions) {
        this.kinRelationOptions = kinRelationOptions;
    }

    public SelectItem[] getRegionOptions() {

        List<Region> regionList = crudService.findAll(Region.class, true);

        regionOptions = new SelectItem[regionList.size()];

        int count = 0;

        for (Region region : regionList) {
            regionOptions[count] = new SelectItem(region.getRegionId(), region.getRegionName());

            count++;
        }

        return regionOptions;
    }

    public void setRegionOptions(SelectItem[] regionOptions) {
        this.regionOptions = regionOptions;
    }

//    public SelectItem[] getAcademicLevelOptions() {
//
//        List<AcademicLevel> academicLevelList = dataSource.getCommonQry().academicLevelGetAll();
//
//        academicLevelOptions = new SelectItem[academicLevelList.size()];
//
//        int count = 0;
//
//        for (AcademicLevel academicLevel : academicLevelList) {
//            academicLevelOptions[count] = new SelectItem(academicLevel.getAcademicLevelId(), academicLevel.getAcademicLevelId());
//
//            count++;
//        }
//
//        return academicLevelOptions;
//    }

    public void setAcademicLevelOptions(SelectItem[] academicLevelOptions) {
        this.academicLevelOptions = academicLevelOptions;
    }

    public SelectItem[] getAcademicCoursesOptions() {

        List<InstitutionProgram> institutionProgramList = crudService.findAll(InstitutionProgram.class, false);

        academicCoursesOptions = new SelectItem[institutionProgramList.size()];

        int count = 0;

        for (InstitutionProgram institutionProgram : institutionProgramList) {
            academicCoursesOptions[count] = new SelectItem(institutionProgram.getCommonId(), institutionProgram.getProgramName());

            count++;
        }

        return academicCoursesOptions;
    }

    public void setAcademicCoursesOptions(SelectItem[] academicCoursesOptions) {
        this.academicCoursesOptions = academicCoursesOptions;
    }

    public SelectItem[] getSchoolTermOptions() {

        List<SchoolTerm> schoolTermList = crudService.findAll(SchoolTerm.class, true);

        schoolTermOptions = new SelectItem[schoolTermList.size()];

        int count = 0;

        for (SchoolTerm schoolTerm : schoolTermList) {
            schoolTermOptions[count] = new SelectItem(schoolTerm.getTermDesc(), schoolTerm.getTermDesc());

            count++;
        }
        return schoolTermOptions;
    }

    public void setSchoolTermOptions(SelectItem[] schoolTermOptions) {
        this.schoolTermOptions = schoolTermOptions;
    }

    public SelectItem[] getAcademicYearOptions() {

        List<AcademicYear> academicYearList = crudService.findAll(AcademicYear.class,false);

        academicYearOptions = new SelectItem[academicYearList.size()];

        int count = 0;

        for (AcademicYear academicYear : academicYearList) {
            academicYearOptions[count] = new SelectItem(academicYear.getCommonId(), academicYear.getCommonId());

            count++;
        }

        return academicYearOptions;
    }

    public void setAcademicYearOptions(SelectItem[] academicYearOptions) {
        this.academicYearOptions = academicYearOptions;
    }

    public SelectItem[] getOccupationTypeOptions() {

        List<Occupation> occupationList = crudService.findAll(Occupation.class, true);

        occupationTypeOptions = new SelectItem[occupationList.size()];

        int count = 0;

        for (Occupation occupation : occupationList) {
            occupationTypeOptions[count] = new SelectItem(occupation.getOccupationId(), occupation.getOccupationDesc());

            count++;
        }

        return occupationTypeOptions;
    }

    public void setOccupationTypeOptions(SelectItem[] occupationTypeOptions) {
        this.occupationTypeOptions = occupationTypeOptions;
    }

//    public SelectItem[] getKinRelationOptions() {
//
//        List<NextOfKin> nextOfKinList = dataSource.getCommonQry().nextOfKinGetAll(true);
//
//        kinRelationOptions = new SelectItem[nextOfKinList.size()];
//
//        int count = 0;
//
//        for (NextOfKin at : nextOfKinList) {
//            kinRelationOptions[count] = new SelectItem(at.getNextOfKinId(), at.getRelationDesc());
//
//            count++;
//        }
//
//        return kinRelationOptions;
//    }
//
//    public void setKinRelationOptions(SelectItem[] kinRelationOptions) {
//        this.kinRelationOptions = kinRelationOptions;
//    }
    
    public SelectItem[] getAccessRightTypes() {

        List<AccessRight> accessRightList = crudService.findAll(AccessRight.class, true);

        accessRightTypes = new SelectItem[accessRightList.size()];

        int count = 0;

        for (AccessRight at : accessRightList) {
            accessRightTypes[count] = new SelectItem(at.getAccessRightId(), at.getAccessRight());

            count++;
        }
        return accessRightTypes;
    }

    public void setAccessRightTypes(SelectItem[] accessRightTypes) {
        this.accessRightTypes = accessRightTypes;
    }

    public SelectItem[] getNationality() {

        List<Nationality> nationalityList = crudService.findAll(Nationality.class, true);

        nationality = new SelectItem[nationalityList.size()];

        int count = 0;

        for (Nationality n : nationalityList) {

            nationality[count] = new SelectItem(n.getNationalityId(), n.getNationalityDesc());
            count++;

        }
        return nationality;
    }

    public void setNationality(SelectItem[] nationality) {
        this.nationality = nationality;
    }

//    public SelectItem[] getIdentificationTypes() {
//
//        List<IdentificationType> idTypesList = dataSource.getCommonQry().identificationTypeGetAll(true);
//
//        identificationTypes = new SelectItem[idTypesList.size()];
//        int count = 0;
//        for (IdentificationType g : idTypesList) {
//            identificationTypes[count] = new SelectItem(g.getCardCode(), g.getCardDesc());
//            count++;
//        }
//
//        return identificationTypes;
//    }

    public void setIdentificationTypes(SelectItem[] identificationTypes) {
        this.identificationTypes = identificationTypes;
    }

    public SelectItem[] getMaritalStatus() {

        List<MaritalStatus> maritalStatusList = crudService.findAll(MaritalStatus.class, true);
        
        maritalStatus = new SelectItem[maritalStatusList.size()];
        int count = 0;
        for (MaritalStatus ms : maritalStatusList) {
            maritalStatus[count] = new SelectItem(ms.getMaritalStatusId(), ms.getStatusDesc());
            count++;
        }
        return maritalStatus;
    }

    public void setMaritalStatus(SelectItem[] maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public SelectItem[] getCalenderMonthNamesOptions() {
        return calenderMonthNamesOptions;
    }

    public void setCalenderMonthNamesOptions(SelectItem[] calenderMonthNamesOptions) {
        this.calenderMonthNamesOptions = calenderMonthNamesOptions;
    }

//    //</editor-fold>
}
