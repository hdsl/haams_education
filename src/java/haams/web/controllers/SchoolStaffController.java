/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.ClassTeacher;
import haams.ejb.entities.CommonEntity;
import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.LevelOfEducation;
import haams.ejb.entities.MaritalStatus;
import haams.ejb.entities.Nationality;
import haams.ejb.entities.Region;
import haams.ejb.entities.StaffCategory;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.tableModel.ClassTeacherTableModel;
import haams.web.tableModel.StaffTableModel;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@SessionScoped
public class SchoolStaffController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    boolean renderStaffViewPanel = false;

    boolean renderStaffListPanel = true;

    boolean renderStaffCreatePanel = false;

    String saveEditButtonText = "Save", surname, othername,nextofKinRelation;

    String searchAttribute, searchText, courseClass, teacherId;

    String staffName,maritalStatus,staffNationality,hometownRegion;
    
    String staffCategory,levelOfEducation;
 
    InstitutionStaff institutionStaff = new InstitutionStaff();

    StaffTableModel staffTableModel = new StaffTableModel();

    ClassTeacher classTeacher = new ClassTeacher();

    ClassTeacherTableModel classTeacherDM = new ClassTeacherTableModel();

    List<StaffTableModel> staffDetailDataList;

    List<ClassTeacherTableModel> classTeacherDataModel;

    Date dateOfAdmission;

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public SchoolStaffController() {
    }

    public String generateStaffNumber(Date dateofAppointment, String surname, String othername) {

        Integer yearAppointed = dateofAppointment.getYear() + 1900;
        String lastTwoDigitOfAppoint = yearAppointed.toString().substring(2);

        Integer id = crudService.generatePk("staff_number");

        String nameCode = surname.substring(0, 1).toUpperCase() + othername.substring(0, 1).toUpperCase();

        String staffCode = id.toString();

        String staffId = nameCode + lastTwoDigitOfAppoint + staffCode;

        return staffId;
    }

    public void saveEditButtonAction() {

        if (saveEditButtonText.equals("Save")) {

            if (surname == null) {
                StringConstants.showApprioprateMessage("Surname is required");
            } else if (othername == null) {
                StringConstants.showApprioprateMessage("Othernames are required");
            } else if (dateOfAdmission == null) {
                StringConstants.showApprioprateMessage("Date of Appointment is required");
            } else {

                String staffId = generateStaffNumber(dateOfAdmission, surname, othername);
                institutionStaff.setCommonId(staffId);
                institutionStaff.setDateOfAppointment(dateOfAdmission);
                institutionStaff.setSurname(surname.toUpperCase());
                institutionStaff.setOtherName(othername.toUpperCase());
                
                CommonEntity saveSuccess = crudService.save(institutionStaff) ;

                if (saveSuccess!= null) {
                    StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                    searchAttribute = "surname";
                    searchText = crudService.find(InstitutionStaff.class, saveSuccess.getCommonId()).getSurname();
                    searchButtonAction();
                    resetButtonAction();
                    returnToStaffListPanel();
                } else {
                    StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                }
            }
        } else {

            institutionStaff.setDateOfAppointment(dateOfAdmission);
            institutionStaff.setSurname(surname.toUpperCase());
            institutionStaff.setOtherName(othername.toUpperCase());

            if (crudService.update(institutionStaff)) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
                searchButtonAction();
                renderStaffCreatePanel = false;
                renderStaffListPanel = true;
                renderStaffViewPanel = false;
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }

    }

    public void deleteButtonAction() {

        if (crudService.delete(institutionStaff, false)) {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
            resetButtonAction();
            searchButtonAction();
        } else {
            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
        }
    }

    public void resetButtonAction() {
        saveEditButtonText = "Save";
        institutionStaff = new InstitutionStaff();
        dateOfAdmission = null;
        surname = "";
        othername = "";
        teacherId = "";
        courseClass = "";
    }

    public void searchButtonAction() {

        staffDetailDataList = new ArrayList<>();

        List<InstitutionStaff> staffList = customCrudService.findByParameter(InstitutionStaff.class, searchAttribute, searchText, 'N');

        if (staffList.size() > 0) {

            for (InstitutionStaff st : staffList) {
                String gender;
                StaffTableModel stm = new StaffTableModel();

                stm.setStaffId(st.getCommonId());

                if (st.getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }
                stm.setStaffName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
                stm.setStaffPrimaryContact(st.getPrimaryContact());
                stm.setStaffEmailAddress(st.getEmailAddress());
                stm.setDateOfAppointment(st.getDateOfAppointment());
                stm.setStaffCategory(crudService.find(StaffCategory.class, st.getStaffCategory()).getStaffCategoryDesc());
                stm.setOccupationStatus(st.getOccupationStatus());

                staffDetailDataList.add(stm);
            }
        }

    }

    public void viewAllStaff() {

        staffDetailDataList = new ArrayList<>();

        List<InstitutionStaff> staffList = crudService.findAll(InstitutionStaff.class, false);

        if (staffList.size() > 0) {

            for (InstitutionStaff st : staffList) {
                String gender;
                StaffTableModel stm = new StaffTableModel();

                stm.setStaffId(st.getCommonId());

                if (st.getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }
                stm.setStaffName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
                stm.setStaffPrimaryContact(st.getPrimaryContact());
                stm.setStaffEmailAddress(st.getEmailAddress());
                stm.setDateOfAppointment(st.getDateOfAppointment());
                stm.setStaffCategory(crudService.find(StaffCategory.class, st.getStaffCategory()).getStaffCategoryDesc());
                stm.setOccupationStatus(st.getOccupationStatus());

                staffDetailDataList.add(stm);
            }
        }

    }

    public void rowSelectDataAction(StaffTableModel stm) {

        this.staffTableModel = stm;

        String gender;

        institutionStaff = crudService.find(InstitutionStaff.class, staffTableModel.getStaffId());

        dateOfAdmission = institutionStaff.getDateOfAppointment();

        if (institutionStaff.getGender().equals('F')) {
            gender = "(Miss.)";
        } else {
            gender = "(Mr.)";
        }

        staffName = institutionStaff.getSurname().toUpperCase() + " " + institutionStaff.getOtherName() + " " + gender;
        staffCategory = crudService.find(StaffCategory.class, institutionStaff.getStaffCategory()).getStaffCategoryDesc();
        staffNationality = crudService.find(Nationality.class, institutionStaff.getNationality()).getNationalityDesc();
        hometownRegion = crudService.find(Region.class, institutionStaff.getRegionId()).getRegionName();
        maritalStatus = crudService.find(MaritalStatus.class, institutionStaff.getMaritalStatus()).getStatusDesc();
        levelOfEducation = crudService.find(LevelOfEducation.class, institutionStaff.getLevelOfEducation()).getLevelDescription();
        
        renderStaffListPanel = false;
        renderStaffViewPanel = true;

        saveEditButtonText = "Update";

    }

    public void showNewStaffEntryPanel() {

        institutionStaff = new InstitutionStaff();
        
        renderStaffCreatePanel = true;
        renderStaffListPanel = false;
        renderStaffViewPanel = false;
        
        saveEditButtonText = "Save";

    }

    public void returnToStaffListPanel() {

        renderStaffCreatePanel = false;
        renderStaffListPanel = true;
        renderStaffViewPanel = false;
    }
    
    public void showStaffDetailEditPanel(){
        
        surname = institutionStaff.getSurname();
        othername = institutionStaff.getOtherName();
        
        renderStaffCreatePanel = true;
        renderStaffListPanel = false;
        renderStaffViewPanel = false;
        
        saveEditButtonText = "Update";
    }

    public void assignClassToTeacher() {

//        if (saveEditButtonText.equals("Save")) {
//
//            List<ClassTeacherTableModel> stmList = new ArrayList<>();
//
//            if (courseClass == null) {
//                StringConstants.showApprioprateMessage("Please select a class");
//            } else if (teacherId == null) {
//                StringConstants.showApprioprateMessage("Please select a teacher");
//            } else {
//                Setting setting = crudService.find(Setting.class, "CURRENT_TERM");
//
//                if (setting == null) {
//                    StringConstants.showApprioprateMessage("Current Academic Term has not been set");
//                } else {
//
//                    AcademicTerm term = crudService.find(AcademicTerm.class, setting.getSettingsValue());
//
//                    ClassTeacher ct = dataSource.getCustomQry().classTeacher(term.getAcademicYear(), teacherId, courseClass);
//
//                    if (ct != null) {
//                        StringConstants.showApprioprateMessage("A teacher is already assigned to " + courseClass);
//                        StringConstants.showApprioprateMessage("Kindly delete the existing class teacher");
//                    } else {
//
//                        classTeacher.setCommonId(StringConstants.generateID().substring(10));
//                        classTeacher.setAcademicYear(term.getAcademicYear());
//                        classTeacher.setStaffId(teacherId);
//                        classTeacher.setInstitutionClass(crudService.find(InstitutionClass.class, courseClass));
//
//                        CommonEntity saveSuccess = crudService.save(classTeacher);
//
//                        if (saveSuccess != null) {
//                            StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
//
//                            ClassTeacherTableModel dataModel = new ClassTeacherTableModel();
//
//                            dataModel.setClassTeacherId(saveSuccess.getCommonId());
//                            dataModel.setStaffId(teacherId);
//                            dataModel.setAcademicYear(term.getAcademicYear());
////                            dataModel.setAssignedClass(dataSource.getCommonQry().institutionClassFind(courseClass).getClassName());
//
//                            InstitutionStaff st = crudService.find(InstitutionStaff.class,teacherId);
//                            String gender;
//
//                            if (st.getGender().equals('F')) {
//                                gender = "(Miss.)";
//                            } else {
//                                gender = "(Mr.)";
//                            }
//
//                            dataModel.setTeacherName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
//
//                            stmList.add(dataModel);
//
//                            classTeacherDataModel = new ListDataModel<>(stmList);
//
//                            resetButtonAction();
//                        } else {
//                            StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
//                        }
//                    }
//                }
//            }
//        }
    }

    public void loadClassTeacherList() {

//        List<ClassTeacherTableModel> stmList = new ArrayList<>();
//
//        List<ClassTeacher> classTeacherList = dataSource.getCommonQry().classTeacherGetAll(false);
//
//        if (classTeacherList.size() > 0) {
//            for (ClassTeacher ct : classTeacherList) {
//                ClassTeacherTableModel dataModel = new ClassTeacherTableModel();
//
//                dataModel.setClassTeacherId(ct.getClassTeacherId());
//                dataModel.setStaffId(teacherId);
//                dataModel.setAcademicYear(ct.getAcademicYear());
//                dataModel.setAssignedClass(ct.getInstitutionClass().getClassId());
//
//                InstitutionStaff st = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//                String gender;
//
//                if (st.getGender().equals('F')) {
//                    gender = "(Miss.)";
//                } else {
//                    gender = "(Mr.)";
//                }
//
//                dataModel.setTeacherName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
//
//                stmList.add(dataModel);
//            }
//
//            classTeacherDataModel = new ListDataModel<>(stmList);
    }

    //<editor-fold defaultstate="collapsed" desc="take a look at ">
    public void searchClassMaster() {
//
//        List<ClassTeacherTableModel> stmList = new ArrayList<>();
//
//        System.out.println("search attrib............." + searchAttribute);
//        System.out.println("search attrib............." + searchText);
//
//        if (searchAttribute.equals("surname")) {
//
//            List<ClassTeacher> classTeacherList = dataSource.getCommonQry().classTeacherGetAll(false);
//
//            System.out.println("class teacher list.........." + classTeacherList);
//            if (classTeacherList.size() > 0) {
//
//                for (ClassTeacher ct : classTeacherList) {
//
//                    InstitutionStaff staff = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//                    System.out.println("staff.........." + staff);
//                    if (staff.getSurname().contains(searchText)) {
//                        System.out.println("got u ........." + staff.getSurname());
//                        ClassTeacherTableModel dataModel = new ClassTeacherTableModel();
//
//                        dataModel.setClassTeacherId(ct.getClassTeacherId());
//                        dataModel.setAcademicYear(ct.getAcademicYear());
//                        dataModel.setAssignedClass(ct.getInstitutionClass().getClassId());
//
//                        InstitutionStaff st = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//                        String gender;
//
//                        if (st.getGender().equals('F')) {
//                            gender = "(Miss.)";
//                        } else {
//                            gender = "(Mr.)";
//                        }
//
//                        dataModel.setTeacherName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
//
//                        stmList.add(dataModel);
//                    }
//
//                }
//
//                System.out.println("stmList........." + stmList);
//                classTeacherDataModel = new ListDataModel<>(stmList);
//            }
//        } else if (searchAttribute.equals("otherName")) {
//
//            List<ClassTeacher> classTeacherList = dataSource.getCommonQry().classTeacherGetAll(false);
//
//            if (classTeacherList.size() > 0) {
//
//                for (ClassTeacher ct : classTeacherList) {
//
//                    InstitutionStaff staff = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//
//                    if (staff.getOtherName().startsWith(searchText)) {
//                        ClassTeacherTableModel dataModel = new ClassTeacherTableModel();
//
//                        dataModel.setClassTeacherId(ct.getClassTeacherId());
//                        dataModel.setAcademicYear(ct.getAcademicYear());
//                        dataModel.setAssignedClass(ct.getInstitutionClass().getClassId());
//
//                        InstitutionStaff st = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//                        String gender;
//
//                        if (st.getGender().equals('F')) {
//                            gender = "(Miss.)";
//                        } else {
//                            gender = "(Mr.)";
//                        }
//
//                        dataModel.setTeacherName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
//
//                        stmList.add(dataModel);
//                    }
//
//                }
//
//                classTeacherDataModel = new ListDataModel<>(stmList);
//            }
//        } else if (searchAttribute.equals("AcademicYear")) {
//
//            List<ClassTeacher> classTeacherList = dataSource.getCommonQry().classTeacherGetAll(false);
//
//            if (classTeacherList.size() > 0) {
//
//                for (ClassTeacher ct : classTeacherList) {
//
//                    if (ct.getAcademicYear().equals(searchText)) {
//
//                        InstitutionStaff staff = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//
//                        ClassTeacherTableModel dataModel = new ClassTeacherTableModel();
//
//                        dataModel.setClassTeacherId(ct.getClassTeacherId());
//                        dataModel.setAcademicYear(ct.getAcademicYear());
//                        dataModel.setAssignedClass(ct.getInstitutionClass().getClassId());
//
//                        InstitutionStaff st = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//                        String gender;
//
//                        if (st.getGender().equals('F')) {
//                            gender = "(Miss.)";
//                        } else {
//                            gender = "(Mr.)";
//                        }
//
//                        dataModel.setTeacherName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
//
//                        stmList.add(dataModel);
//                    }
//
//                }
//
//                classTeacherDataModel = new ListDataModel<>(stmList);
//            }
//        } else if (searchAttribute.equals("class")) {
//
//            List<ClassTeacher> classTeacherList = dataSource.getCommonQry().classTeacherGetAll(false);
//
//            if (classTeacherList.size() > 0) {
//
//                for (ClassTeacher ct : classTeacherList) {
//
//                    if (ct.getInstitutionClass().equals(searchText)) {
//
//                        InstitutionStaff staff = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//
//                        ClassTeacherTableModel dataModel = new ClassTeacherTableModel();
//
//                        dataModel.setClassTeacherId(ct.getClassTeacherId());
//                        dataModel.setAcademicYear(ct.getAcademicYear());
//                        dataModel.setAssignedClass(ct.getInstitutionClass().getClassId());
//
//                        InstitutionStaff st = dataSource.getCommonQry().institutionStaffFind(ct.getStaffId());
//                        String gender;
//
//                        if (st.getGender().equals('F')) {
//                            gender = "(Miss.)";
//                        } else {
//                            gender = "(Mr.)";
//                        }
//
//                        dataModel.setTeacherName(st.getSurname().toUpperCase() + " " + st.getOtherName() + " " + gender);
//
//                        stmList.add(dataModel);
//                    }
//
//                }
//
//                classTeacherDataModel = new ListDataModel<>(stmList);
//            }
//        }

    }
//</editor-fold>

    public void rowSelectClassMaster() {
//        classTeacherDM = classTeacherDataModel.getRowData();
//
//        classTeacher = dataSource.getCommonQry().classTeacherFind(classTeacherDM.getClassTeacherId());
//
//        teacherId = classTeacher.getStaffId();
//        courseClass = classTeacher.getInstitutionClass().getClassId();
//
//        saveEditButtonText = "";
    }

    public void deleteAssignedClassMaster() {

//        boolean deleteSuccess = dataSource.getCommonQry().classTeacherDelete(classTeacher, false);
//
//        if (deleteSuccess) {
//            StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
//            resetButtonAction();
//            classTeacherDataModel = new ListDataModel<>();
//        } else {
//            StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
//        }
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getSaveEditButtonText() {
        return saveEditButtonText;
    }

    public void setSaveEditButtonText(String saveEditButtonText) {
        this.saveEditButtonText = saveEditButtonText;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getStaffNationality() {
        return staffNationality;
    }

    public void setStaffNationality(String staffNationality) {
        this.staffNationality = staffNationality;
    }

    public String getHometownRegion() {
        return hometownRegion;
    }

    public void setHometownRegion(String hometownRegion) {
        this.hometownRegion = hometownRegion;
    }

    public String getNextofKinRelation() {
        return nextofKinRelation;
    }

    public void setNextofKinRelation(String nextofKinRelation) {
        this.nextofKinRelation = nextofKinRelation;
    }

    public CrudService getCrudService() {
        return crudService;
    }

    public void setCrudService(CrudService crudService) {
        this.crudService = crudService;
    }

    public CustomCrudService getCustomCrudService() {
        return customCrudService;
    }

    public void setCustomCrudService(CustomCrudService customCrudService) {
        this.customCrudService = customCrudService;
    }

    public boolean isRenderStaffViewPanel() {
        return renderStaffViewPanel;
    }

    public void setRenderStaffViewPanel(boolean renderStaffViewPanel) {
        this.renderStaffViewPanel = renderStaffViewPanel;
    }

    public boolean isRenderStaffListPanel() {
        return renderStaffListPanel;
    }

    public void setRenderStaffListPanel(boolean renderStaffListPanel) {
        this.renderStaffListPanel = renderStaffListPanel;
    }

    public boolean isRenderStaffCreatePanel() {
        return renderStaffCreatePanel;
    }

    public void setRenderStaffCreatePanel(boolean renderStaffCreatePanel) {
        this.renderStaffCreatePanel = renderStaffCreatePanel;
    }

    public ClassTeacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(ClassTeacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSearchAttribute() {
        return searchAttribute;
    }

    public void setSearchAttribute(String searchAttribute) {
        this.searchAttribute = searchAttribute;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public InstitutionStaff getInstitutionStaff() {
        return institutionStaff;
    }

    public void setInstitutionStaff(InstitutionStaff institutionStaff) {
        this.institutionStaff = institutionStaff;
    }

    public StaffTableModel getStaffTableModel() {
        return staffTableModel;
    }

    public void setStaffTableModel(StaffTableModel staffTableModel) {
        this.staffTableModel = staffTableModel;
    }

    public ClassTeacherTableModel getClassTeacherDM() {
        return classTeacherDM;
    }

    public void setClassTeacherDM(ClassTeacherTableModel classTeacherDM) {
        this.classTeacherDM = classTeacherDM;
    }

    public List<StaffTableModel> getStaffDetailDataList() {
        return staffDetailDataList;
    }

    public void setStaffDetailDataList(List<StaffTableModel> staffDetailDataList) {
        this.staffDetailDataList = staffDetailDataList;
    }

    public List<ClassTeacherTableModel> getClassTeacherDataModel() {
        return classTeacherDataModel;
    }

    public void setClassTeacherDataModel(List<ClassTeacherTableModel> classTeacherDataModel) {
        this.classTeacherDataModel = classTeacherDataModel;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    //</editor-fold>
}
