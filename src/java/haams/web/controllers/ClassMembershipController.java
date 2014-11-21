/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicLevel;
import haams.ejb.entities.ClassMembership;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.InstitutionClass;
import haams.ejb.entities.Setting;
import haams.ejb.entities.Student;
import haams.ejb.entities.SubjectGroup;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.tableModel.StudentTableModel;
import haams.web.utils.StringConstants;
import haams.web.utils.UserSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author AbdulMumin
 */
@Named
@SessionScoped
public class ClassMembershipController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    private UserSession userSession;

    String actionSelected, schoolProgramme, academicLevel, currentClass;

    String studentPix, studentId, studentName;

    String selectedSubjectCombination;

    StudentTableModel studentTableModel = new StudentTableModel();

    Student student = new Student();

    List<Student> studentList;

    List<StudentTableModel> stmList;

    SelectItem[] classAdmitted;

    SelectItem[] subjectCombinationOptions;

    SelectItem[] academicLevelOptions;

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public ClassMembershipController() {
    }

    public void programmeSubjectCombination() {

        if (schoolProgramme == null) {
            StringConstants.showApprioprateMessage("Please select a course");
        } else {

            List<SubjectGroup> subjectGroupList = customCrudService.subjectGroupFindByAttribute(schoolProgramme);

            if (subjectGroupList.size() > 0) {

                subjectCombinationOptions = new SelectItem[subjectGroupList.size()];

                int count = 0;

                for (SubjectGroup ic : subjectGroupList) {

                    subjectCombinationOptions[count] = new SelectItem(ic.getCommonId(), ic.getSubjectGroupName());

                    count++;
                }
            }
        }

        academicLevel = null;

        List<AcademicLevel> academicLevelList = crudService.findAll(AcademicLevel.class, true);

        academicLevelOptions = new SelectItem[academicLevelList.size()];

        int count = 0;

        for (AcademicLevel al : academicLevelList) {
            academicLevelOptions[count] = new SelectItem(al.getAcademicLevelId(), al.getAcademicLevelId());

            count++;
        }
    }

    public void loadAcademicLevelClass() {

        currentClass = "";

        List<InstitutionClass> institutionClassList = customCrudService.getInstitutionClass(academicLevel, schoolProgramme);
        classAdmitted = new SelectItem[institutionClassList.size()];

        int count = 0;

        for (InstitutionClass ic : institutionClassList) {

            classAdmitted[count] = new SelectItem(ic.getCommonId(), ic.getClassName());

            count++;
        }
    }

    public void searchButtonAction() {

        stmList = new ArrayList<>();

        List<ClassMembership> classMembership = customCrudService.classMembershipFindByAttribute(currentClass, userSession.getAcademicYear());

        if (!classMembership.isEmpty()) {

            for (ClassMembership st : classMembership) {

                String gender;
                StudentTableModel stm = new StudentTableModel();

                stm.setStudentId(st.getStudent().getCommonId());

                if (st.getStudent().getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }
                stm.setStudentName(st.getStudent().getSurname().toUpperCase() + " " + st.getStudent().getOthernames() + " " + gender);
                stm.setResidenceStatus(st.getStudent().getResidenceStatus().getResidenceStatusDesc());
                stm.setStudentCourse(st.getStudent().getAssignedProgramme().getProgramName());
                stm.setStudentClass(st.getStudent().getAssignedClass().getClassName());

                stm.setStudentAcademicStatus(st.getStudent().getStudentAcademicStatus().getStudentAcademicStatusDesc());

                if (st.getSubjectGroup() == null) {
                    stm.setSubjectCombination("");
                } else {
                    SubjectGroup subjectGroup = st.getSubjectGroup();
//                    SubjectGroup subjectGroup = dataSource.getCommonQry().subjectGroupFind(classMembership.getStudentSubjectGroup());

                    if (subjectGroup == null) {
                        stm.setSubjectCombination("");
                    } else {
                        stm.setSubjectCombination(subjectGroup.getSubjectGroupName());
                    }
                }

                stmList.add(stm);
            }
        }

    }

    public void rowSelectDataAction(StudentTableModel stm) {
        
        String gender;

        this.studentTableModel = stm;
        
        student = crudService.find(Student.class,studentTableModel.getStudentId());

        studentId = student.getCommonId();

        if (student.getGender().equals('F')) {
            gender = "(Miss.)";
        } else {
            gender = "(Mr.)";
        }
        studentName = student.getSurname().toUpperCase() + " " + student.getOthernames() + " " + gender;

        String serverName = null;
        String pictureFolder = null;

        if (userSession.getSchoolConfig().size() < 1) {
            serverName = "localhost";
            pictureFolder = userSession.getSchoolConfig().get(0).getPixFolderName();
        } else {
            serverName = userSession.getSchoolConfig().get(0).getServerName();
            pictureFolder = userSession.getSchoolConfig().get(0).getPixFolderName();
        }
        
        if (student.getStudentPixId() == null || student.getStudentPixId().equals("")) {
           
            studentPix = "http://" + serverName + ":8080/" + pictureFolder + "/" + "defaultImage.jpg";
        } else {
            studentPix = "http://" + serverName + ":8080/" + pictureFolder + "/" + student.getStudentPixId() + ".jpg";

        }
    }

    public void executeSelectedAction() {

        Setting setting = crudService.find(Setting.class,"CURRENT_TERM");

        if (setting == null) {
            StringConstants.showApprioprateMessage("Current Academic Term has not been set");
        } else {

            if (actionSelected == null) {
                StringConstants.showApprioprateMessage("Please select an action to be performed first");
            } else if (actionSelected.equals("REMOVE_STUD_FR_CLASS")) {

                ClassMembership cm = customCrudService.classMembershipFindByAttribute(userSession.getAcademicYear(), currentClass, studentId);

                Student st = cm.getStudent();

                if (cm == null) {
                    StringConstants.showApprioprateMessage("Student record does not exist");
                } else {

                    if (crudService.delete(cm, false)) {

                        st.setAssignedClass(null);
                        crudService.update(st);

                        StringConstants.showApprioprateMessage("Student records has been sucessfully removed from " + currentClass);
                        searchButtonAction();
                        resetButtonAction();
                    } else {
                        StringConstants.showApprioprateMessage("Unable to remove student records from " + currentClass);
                    }
                }

            } else if (actionSelected.equals("ASSIGN_SUB_COMB")) {

                if (selectedSubjectCombination == null) {
                    StringConstants.showApprioprateMessage("Please select subject combination");
                } else {

                    ClassMembership cm = customCrudService.classMembershipFindByAttribute(userSession.getAcademicYear(), currentClass, studentId);

                    if (cm == null) {
                        StringConstants.showApprioprateMessage("Student record does not exist ");
                        StringConstants.showApprioprateMessage("Please add student to the class first");
                    } else {

                        cm.setSubjectGroup(crudService.find(SubjectGroup.class, selectedSubjectCombination));

                        if (crudService.update(cm)) {
                            StringConstants.showApprioprateMessage("Subject Combination has been entered successfully for student");
                            searchButtonAction();
                            resetButtonAction();
                        } else {
                            StringConstants.showApprioprateMessage("Unable to enter Subject Combination for student");
                        }
                    }
                }
            } else if (actionSelected.equals("BATCH_ASSIGN_SUB_COMB")) {

                if (stmList.size() > 0) {

                    if (selectedSubjectCombination == null) {
                        StringConstants.showApprioprateMessage("Please select subject combination");
                    } else {

                        for (StudentTableModel stm : stmList) {

                            Student s = crudService.find(Student.class, stm.getStudentId());
                                    
                            ClassMembership cm = customCrudService.classMembershipFindByAttribute(userSession.getAcademicYear(), currentClass, s.getCommonId());

                            if (cm == null) {
                                String gender;
                                if (s.getGender().equals('F')) {
                                    gender = "(Miss.)";
                                } else {
                                    gender = "(Mr.)";
                                }
                                String studName = s.getSurname().toUpperCase() + " " + s.getOthernames() + " " + gender;

                                StringConstants.showApprioprateMessage(studName + "does not exist in the selected class");
                                StringConstants.showApprioprateMessage("Please add student to the class first");
                            } else {

                                cm.setSubjectGroup(crudService.find(SubjectGroup.class, selectedSubjectCombination));

                                crudService.update(cm);

                            }
                        }

                        StringConstants.showApprioprateMessage("Subject Combination has been entered successfully for all student");
                        searchButtonAction();
                        resetButtonAction();
                    }
                } else {
                    StringConstants.showApprioprateMessage("There are no student list");
                }

            }
        }
    }

    public void saveEditButtonAction() {

    }

    public void deleteButtonAction() {

    }

    public void resetButtonAction() {
        studentId = "";
        studentName = "";
        selectedSubjectCombination = "";
        actionSelected = "";
        studentPix = "";
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getActionSelected() {
        return actionSelected;
    }

    public void setActionSelected(String actionSelected) {
        this.actionSelected = actionSelected;
    }

    public SelectItem[] getAcademicLevelOptions() {
        return academicLevelOptions;
    }

    public void setAcademicLevelOptions(SelectItem[] academicLevelOptions) {
        this.academicLevelOptions = academicLevelOptions;
    }

    public String getSelectedSubjectCombination() {
        return selectedSubjectCombination;
    }

    public void setSelectedSubjectCombination(String selectedSubjectCombination) {
        this.selectedSubjectCombination = selectedSubjectCombination;
    }

    public String getStudentPix() {
        return studentPix;
    }

    public void setStudentPix(String studentPix) {
        this.studentPix = studentPix;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SelectItem[] getClassAdmitted() {
        return classAdmitted;
    }

    public void setClassAdmitted(SelectItem[] classAdmitted) {
        this.classAdmitted = classAdmitted;
    }

    public String getSchoolProgramme() {
        return schoolProgramme;
    }

    public void setSchoolProgramme(String schoolProgramme) {
        this.schoolProgramme = schoolProgramme;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public StudentTableModel getStudentTableModel() {
        return studentTableModel;
    }

    public void setStudentTableModel(StudentTableModel studentTableModel) {
        this.studentTableModel = studentTableModel;
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

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<StudentTableModel> getStmList() {
        return stmList;
    }

    public void setStmList(List<StudentTableModel> stmList) {
        this.stmList = stmList;
    }

    public SelectItem[] getSubjectCombinationOptions() {
        return subjectCombinationOptions;
    }

    public void setSubjectCombinationOptions(SelectItem[] subjectCombinationOptions) {
        this.subjectCombinationOptions = subjectCombinationOptions;
    }

    //</editor-fold>
}
