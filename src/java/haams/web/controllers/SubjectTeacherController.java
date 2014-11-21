/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.InstitutionClass;
import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.InstitutionSubject;
import haams.ejb.entities.Setting;
import haams.ejb.entities.TeacherSubject;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.tableModel.SubjectTeacherTableModel;
import haams.web.utils.StringConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

/**
 *
 * @author AbdulMumin
 */
@Named
@ConversationScoped
public class SubjectTeacherController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    private Conversation conversation;

    String saveEditButtonText = "Save", selectedTeacher;

    String selectedSubject, searchText, searchAttribute, selectedTerm;

    private boolean renderSubjectTeacherListForm = true;

    private boolean renderSubjectTeacherEntryForm = false;

    TeacherSubject teacherSubject = new TeacherSubject();

    private DualListModel<String> courseClasses;

    List<String> courseClassTarget;

    List<String> courseClassSource;

    SelectItem[] searchTextOptions;

    SubjectTeacherTableModel subTeacherTableModel = new SubjectTeacherTableModel();

    List<SubjectTeacherTableModel> subjectTeacherList;

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public SubjectTeacherController() {

    }

    @PostConstruct
    public void init() {

        courseClassSource = new ArrayList<>();
        courseClassTarget = new ArrayList<>();

        List<InstitutionClass> institutionClassList = crudService.findAll(InstitutionClass.class, false);

        for (InstitutionClass es : institutionClassList) {
            courseClassSource.add(es.getCommonId());
        }

        courseClasses = new DualListModel<>(courseClassSource, courseClassTarget);

    }

    public void startConversation() {

        if (conversation.isTransient()) {
            conversation.begin();
        }

    }

    public void endConversation() {

        if (!conversation.isTransient()) {
            conversation.end();
        }

    }

    public void saveEditButtonAction() {

        startConversation();

        if (saveEditButtonText.equals("Save")) {

            String classesId = "";

            List<String> target = courseClasses.getTarget();

            if (target.size() > 0) {

                for (String s : target) {

                    InstitutionClass es = crudService.find(InstitutionClass.class, s);

                    classesId = es.getCommonId() + "/" + classesId;
                }
            }

            Setting setting = crudService.find(Setting.class, "CURRENT_TERM");

            teacherSubject.setCommonId(StringConstants.generateID().substring(20) + "#" + selectedTeacher + selectedSubject + "#" + setting.getSettingsValue());

            teacherSubject.setTeacherId(selectedTeacher);
            teacherSubject.setSubjectId(selectedSubject);
            teacherSubject.setTeachingClasses(classesId);
            teacherSubject.setAcademicTerm(setting.getSettingsValue());

            if (crudService.save(teacherSubject) != null) {
                StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
                resetButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
            }

        } else {

            Setting setting = crudService.find(Setting.class, "CURRENT_TERM");

            if (subTeacherTableModel == null) {
                StringConstants.showApprioprateMessage("Please select a data row first");
            } else {

                String classesId = "";

                List<String> target = courseClasses.getTarget();

                if (target.size() > 0) {

                    for (String s : target) {

                        InstitutionClass es = crudService.find(InstitutionClass.class, s);

                        classesId = es.getCommonId() + "/" + classesId;
                    }
                }

                teacherSubject.setTeacherId(selectedTeacher);
                teacherSubject.setSubjectId(selectedSubject);
                teacherSubject.setTeachingClasses(classesId);
                teacherSubject.setAcademicTerm(setting.getSettingsValue());

                if (crudService.update(teacherSubject)) {
                    StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                    resetButtonAction();
                    searchButtonAction();
                } else {
                    StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
                }
            }
        }

    }

    public void deleteButtonAction() {

        if (subTeacherTableModel == null) {
            StringConstants.showApprioprateMessage("Please select a data row first");
        } else {

            if (crudService.delete(teacherSubject, false)) {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                resetButtonAction();
                searchButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
            }
        }
    }

    public void resetButtonAction() {

        endConversation();

        saveEditButtonText = "Save";
        teacherSubject = new TeacherSubject();
        selectedSubject = "";
        selectedTeacher = "";

    }

    public void searchParameters() {

        startConversation();

        if (searchAttribute.equals("academicTerm")) {

            List<AcademicTerm> academicTermList = crudService.findAll(AcademicTerm.class, false);

            if (!academicTermList.isEmpty()) {

                searchTextOptions = new SelectItem[academicTermList.size()];

                int count = 0;

                for (AcademicTerm at : academicTermList) {
                    searchTextOptions[count] = new SelectItem(at.getCommonId(), at.getCommonId());

                    count++;
                }

            }

        } else if (searchAttribute.equals("academicYear")) {

        } else if (searchAttribute.equals("teacher")) {

            List<InstitutionStaff> teachingStaff = customCrudService.institutionTeachingStaffGetAll();

            if (!teachingStaff.isEmpty()) {

                searchTextOptions = new SelectItem[teachingStaff.size()];

                int count = 0;
                String gender;

                for (InstitutionStaff is : teachingStaff) {

                    if (is.getGender().equals('F')) {
                        gender = "(Miss.)";
                    } else {
                        gender = "(Mr.)";
                    }

                    searchTextOptions[count] = new SelectItem(is.getCommonId(),
                            is.getSurname().toUpperCase() + " " + is.getOtherName() + " " + gender);

                    count++;
                }
            }

        } else if (searchAttribute.equals("subject")) {

            List<InstitutionSubject> subjectList = crudService.findAll(InstitutionSubject.class, false);

            if (!subjectList.isEmpty()) {

                searchTextOptions = new SelectItem[subjectList.size()];

                int count = 0;

                for (InstitutionSubject is : subjectList) {

                    searchTextOptions[count] = new SelectItem(is.getCommonId(), is.getSubjectName());

                    count++;
                }

            }

        } else if (searchAttribute.equals("allTeachers")) {

        } else if (searchAttribute.equals("")) {

            searchTextOptions = null;

        }

        endConversation();

    }

    public void searchButtonAction() {

        startConversation();

        List<TeacherSubject> subjTeachList = null;

        if (searchAttribute.equals("academicTerm")) {

            subjTeachList = customCrudService.
                    findByParameter(TeacherSubject.class, "academicTerm", searchText, 'N');

        } else if (searchAttribute.equals("academicYear")) {

        } else if (searchAttribute.equals("subject")) {

            subjTeachList = customCrudService.
                    findByParameter(TeacherSubject.class, "subjectId", searchText, 'N');

        } else if (searchAttribute.equals("teacher")) {

            subjTeachList = customCrudService.
                    findByParameter(TeacherSubject.class, "teacherId", searchText, 'N');

        }

        System.out.println("List..................."+subjTeachList);
        if (!subjTeachList.isEmpty()) {

            for (TeacherSubject ts : subjTeachList) {

                SubjectTeacherTableModel model = new SubjectTeacherTableModel();

                InstitutionStaff institutionStaff = crudService.find(InstitutionStaff.class, ts.getTeacherId());

                String gender;

                if (institutionStaff.getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }

                String staffName = institutionStaff.getSurname().toUpperCase() + " " + institutionStaff.getOtherName() + " " + gender;

                model.setSubjectTeacherId(ts.getTeacherId());
                model.setAcademicTerm(ts.getAcademicTerm());
                model.setSubjectClass(ts.getTeachingClasses());
                model.setSubjectName(crudService.find(InstitutionSubject.class, ts.getSubjectId()).getSubjectName());
                model.setSubjectTeacherName(staffName);

                subjectTeacherList.add(model);
            }

        }

//        (searchAttribute.equals("allTeachers")) {
//
//            List<TeacherSubject> teacherSubjList = dataSource.getCommonQry().teacherSubjectGetAll(false);
//
//            if (teacherSubjList.size() > 0) {
//
//                for (TeacherSubject ts : teacherSubjList) {
//
//                    SubjectTeacherTableModel model = new SubjectTeacherTableModel();
//
//                    InstitutionStaff institutionStaff = dataSource.getCommonQry().institutionStaffFind(ts.getTeacherId());
//
//                    String gender;
//
//                    if (institutionStaff.getGender().equals('F')) {
//                        gender = "(Miss.)";
//                    } else {
//                        gender = "(Mr.)";
//                    }
//
//                    String staffName = institutionStaff.getSurname().toUpperCase() + " " + institutionStaff.getOtherName() + " " + gender;
//
//                    model.setSubjectTeacherId(ts.getTeacherSubjectId());
//                    model.setAcademicTerm(ts.getAcademicTerm());
//                    model.setSubjectClass(ts.getTeachingClasses());
//                    model.setSubjectName(dataSource.getCommonQry().institutionSubjectFind(ts.getSubjectId()).getSubjectName());
//                    model.setSubjectTeacherName(staffName);
//
//                    sttmsList.add(model);
//                }
//                subTeacherTableDataModel = new ListDataModel<>(sttmsList);
//            }
//        }
        
        endConversation();
    }

    public void rowSelectDataAction() {

//        courseClassSource = new ArrayList<>();
//        courseClassTarget = new ArrayList<>();
//
//        subTeacherTableModel = subTeacherTableDataModel.getRowData();
//
//        saveEditButtonText = "Update";
//
//        teacherSubject = dataSource.getCommonQry().teacherSubjectFind(subTeacherTableModel.getSubjectTeacherId());
//
//        selectedTeacher = teacherSubject.getTeacherId();
//        selectedSubject = teacherSubject.getSubjectId();
//
//        List<InstitutionClass> selectedInstitutionClassesList = teacherSubject.getInstitutionClassList();
//
//        List<InstitutionClass> institutionClassList = dataSource.getCommonQry().institutionClassGetAll(false);
//
//        if (selectedInstitutionClassesList == null) {
//            return;
//        }
//
//        for (InstitutionClass subjectCheck : selectedInstitutionClassesList) {
//            institutionClassList.remove(subjectCheck);
//        }
//
//        for (InstitutionClass subject1 : institutionClassList) {
//            courseClassSource.add(subject1.getClassId());
//        }
//
//        for (InstitutionClass subject : selectedInstitutionClassesList) {
//            courseClassTarget.add(subject.getClassId());
//        }
//
//        courseClasses = new DualListModel<>(courseClassSource, courseClassTarget);
    }

    public void moveTeachersToSelectedTerm() {

        if (selectedTerm == null) {
            StringConstants.showApprioprateMessage("Please select academic term");
        } else {

        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getSaveEditButtonText() {
        return saveEditButtonText;
    }

    public void setSaveEditButtonText(String saveEditButtonText) {
        this.saveEditButtonText = saveEditButtonText;
    }

    public boolean isRenderSubjectTeacherListForm() {
        return renderSubjectTeacherListForm;
    }

    public void setRenderSubjectTeacherListForm(boolean renderSubjectTeacherListForm) {
        this.renderSubjectTeacherListForm = renderSubjectTeacherListForm;
    }

    public boolean isRenderSubjectTeacherEntryForm() {
        return renderSubjectTeacherEntryForm;
    }

    public void setRenderSubjectTeacherEntryForm(boolean renderSubjectTeacherEntryForm) {
        this.renderSubjectTeacherEntryForm = renderSubjectTeacherEntryForm;
    }

    public SelectItem[] getSearchTextOptions() {
        return searchTextOptions;
    }

    public void setSearchTextOptions(SelectItem[] searchTextOptions) {
        this.searchTextOptions = searchTextOptions;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchAttribute() {
        return searchAttribute;
    }

    public void setSearchAttribute(String searchAttribute) {
        this.searchAttribute = searchAttribute;
    }

    public String getSelectedTeacher() {
        return selectedTeacher;
    }

    public void setSelectedTeacher(String selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    public String getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(String selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public DualListModel<String> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(DualListModel<String> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public List<String> getCourseClassTarget() {
        return courseClassTarget;
    }

    public void setCourseClassTarget(List<String> courseClassTarget) {
        this.courseClassTarget = courseClassTarget;
    }

    public List<SubjectTeacherTableModel> getSubjectTeacherList() {
        return subjectTeacherList;
    }

    public void setSubjectTeacherList(List<SubjectTeacherTableModel> subjectTeacherList) {
        this.subjectTeacherList = subjectTeacherList;
    }

    public List<String> getCourseClassSource() {
        return courseClassSource;
    }

    public void setCourseClassSource(List<String> courseClassSource) {
        this.courseClassSource = courseClassSource;
    }

//</editor-fold> 
}
