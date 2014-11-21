/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

//import com.sabonay.modules.imageutils.ImageResource;
import com.sabonay.modules.imageutils.ImageResource;
import haams.ejb.entities.AcademicLevel;
import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.ClassMembership;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.entities.InstitutionClass;
import haams.ejb.entities.InstitutionProgram;
import haams.ejb.entities.KinRelation;
import haams.ejb.entities.Nationality;
import haams.ejb.entities.Occupation;
import haams.ejb.entities.Region;
import haams.ejb.entities.ResidenceStatus;
import haams.ejb.entities.SchoolHouse;
import haams.ejb.entities.Student;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import haams.web.tableModel.StudentTableModel;
import haams.web.utils.StringConstants;
import haams.web.utils.UserSession;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author AbdulMumin
 */
@Named
@SessionScoped
public class StudentController implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Declaration and Initialisation">
    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    @Inject
    private Conversation conversation;

    @Inject
    private UserSession userSession;

    String academicLevel, assignedClass, studentPixId;

    String searchAttribute, searchText, residenceOfAffiliation;

    String saveEditButtonText = "Save", studentPix, surname;

    String othername, assignedProgramme, studentName, studentAcademicStatus;

    String nationality, region, guardianOccupation, relationToGuardian;

    String residenceStatus;

    Student student = new Student();

    boolean renderStudentListPanel = true;

    boolean renderNewStudentEntryPanel = false;

    boolean renderStudentDataViewPanel = false;

    boolean renderDisabilityDetailPanel;

    SelectItem[] classAdmitted;

    private SelectItem[] academicLevelOptions;

    Date dateOfbirth, dateOfAdmission;

    StudentTableModel studentTableModel = new StudentTableModel();

    List<StudentTableModel> studentTableModelList;
//    DataModel<StudentTableModel> studentDetailDataModel;

    private String clientFullImagePath = System.getProperty("com.sun.aas.instanceRoot")
            + File.separator + "docroot"
            + File.separator + "HAAMS_PIX" + File.separator;

    ;
//</editor-fold>
    
    //    //<editor-fold defaultstate="collapsed" desc="Methods">
    public StudentController() {

    }

    public void resetAssignedProgram() {
        academicLevel = null;
//        academicLevelOptions = null;
        List<AcademicLevel> academicLevelList = crudService.findAll(AcademicLevel.class, true);

        academicLevelOptions = new SelectItem[academicLevelList.size()];

        int count = 0;

        for (AcademicLevel al : academicLevelList) {
            academicLevelOptions[count] = new SelectItem(al.getAcademicLevelId(), al.getAcademicLevelId());

            count++;
        }
    }

    public void loadStudentDetail() {
        List<StudentTableModel> stmList = new ArrayList<>();

        List<Student> studentList = crudService.findAll(Student.class, false);

        if (studentList.size() > 0) {

            for (Student st : studentList) {
                String gender;
                StudentTableModel stm = new StudentTableModel();

                stm.setStudentId(st.getCommonId());

                if (st.getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }
                stm.setStudentName(st.getSurname().toUpperCase() + " " + st.getOthernames() + " " + gender);
                stm.setStudentCourse(st.getAssignedProgramme().getProgramName());
                stm.setStudentClass(st.getAssignedClass().getClassName());
                stm.setResidenceStatus(st.getResidenceStatus().getResidenceStatusDesc());
                stm.setGuardianName(st.getGuardianName());
                stm.setGuardianContact(st.getGuardianContactNumber());
                stm.setStudentId(st.getCommonId());
                stm.setHouse(st.getResidenceOfAffiliation().getHouseName());

                stmList.add(stm);
            }
        }

        studentTableModelList = (List<StudentTableModel>) new ListDataModel<>(stmList);
    }

    public void loadAcademicLevelClass() {

        assignedClass = "";
        List<InstitutionClass> institutionClassList = customCrudService.getInstitutionClass(academicLevel, assignedProgramme);
        classAdmitted = new SelectItem[institutionClassList.size()];

        int count = 0;

        for (InstitutionClass ic : institutionClassList) {

            classAdmitted[count] = new SelectItem(ic.getCommonId(), ic.getClassName());

            count++;
        }
    }

    public void studentPixUpload(FileUploadEvent event) {

        UploadedFile uploadedFile = event.getFile();

        Integer id = crudService.generatePk("student_pix_id");

        studentPixId = id.toString();

        String fileUploaded = ImageResource.saveJPGImage(uploadedFile.getContents(), clientFullImagePath, studentPixId);

        String serverName = null;
        String pictureFolder = null;

        List<EducationalInstitution> config = crudService.findAll(EducationalInstitution.class, true);

        if (config.size() < 1) {
            serverName = "localhost";
            pictureFolder = config.get(0).getPixFolderName();
        } else {
            serverName = config.get(0).getServerName();
            pictureFolder = config.get(0).getPixFolderName();
        }

        studentPix = "http://" + serverName + ":8080/" + pictureFolder + "/" + studentPixId + ".jpg";

    }

    public String generateStudentNumber(Date dateofBirth, Date dateOfAdmin) {

        Integer yearofBirth = dateofBirth.getYear() + 1900;
        Integer yearofAdmission = dateOfAdmin.getYear() + 1900;

        String lastTwoDigitOfBirth = yearofBirth.toString().substring(2);
        String lastTwoDigitOfAdmin = yearofAdmission.toString().substring(2);

        Integer id = crudService.generatePk("student_number");

        String studentCode = id.toString();

        String studentId = lastTwoDigitOfBirth + studentCode + lastTwoDigitOfAdmin;

        return studentId;

    }

    public void saveEditButtonAction() {

        AcademicTerm term = crudService.find(AcademicTerm.class, userSession.getAcademicTerm());

        if (saveEditButtonText.equals("Save")) {

            if (dateOfbirth == null) {
                StringConstants.showApprioprateMessage("Date of Birth is required");
            } else if (dateOfAdmission == null) {
                StringConstants.showApprioprateMessage("Date of Admission is required");
            } else if (assignedProgramme == null) {
                StringConstants.showApprioprateMessage("Student Course is required");
            } else if (academicLevel == null) {
                StringConstants.showApprioprateMessage("Academic Level is required");
            } else if (assignedClass == null) {
                StringConstants.showApprioprateMessage("Class Assigned is required");
            } else {
                String studentId = generateStudentNumber(dateOfbirth, dateOfAdmission);

                student.setCommonId(studentId);
                student.setDateOfbirth(dateOfbirth);
                student.setDateOfAdmission(dateOfAdmission);
                student.setAcademicLevel(crudService.find(AcademicLevel.class, academicLevel));
                student.setAssignedClass(crudService.find(InstitutionClass.class, assignedClass));
                student.setAssignedProgramme(crudService.find(InstitutionProgram.class, assignedProgramme));
                student.setStudentPixId(studentPixId);
                student.setSurname(surname.toUpperCase());
                student.setOthernames(othername.toUpperCase());

                student.setNationality(crudService.find(Nationality.class, nationality));
                student.setRegion(crudService.find(Region.class, region));
                student.setGuardianOccupation(crudService.find(Occupation.class, guardianOccupation));
                student.setRelationToGuardian(crudService.find(KinRelation.class, relationToGuardian));
                student.setResidenceOfAffiliation(crudService.find(SchoolHouse.class, residenceOfAffiliation));
                student.setResidenceStatus(crudService.find(ResidenceStatus.class, residenceStatus));

                Student saveSuccess = (Student) crudService.save(student);

                if (saveSuccess != null) {

//                    ClassMembership cm = new ClassMembership();
//
//                    cm.setClassMembershipId(StringConstants.generateID().substring(10));
//                    cm.setAcademicYear(term.getAcademicYear());
//                    cm.setInstitutionClass(dataSource.getCommonQry().institutionClassFind(saveSuccess.getAssignedClass()));
//                    cm.setStudent(saveSuccess);
//
//                    dataSource.getCommonQry().classMembershipCreate(cm);
//
//                    StringConstants.showApprioprateMessage(StringConstants.SAVE_MESSAGE);
//                    resetButtonAction();
                } else {
                    StringConstants.showApprioprateMessage(StringConstants.SAVE_ERRORMESSAGE);
                }
            }
        } else {

            if (dateOfbirth == null) {
                StringConstants.showApprioprateMessage("Date of Birth is required");
            } else if (dateOfAdmission == null) {
                StringConstants.showApprioprateMessage("Date of Admission is required");
            } else if (assignedProgramme == null) {
                StringConstants.showApprioprateMessage("Student Course is required");
            } else if (academicLevel == null) {
                StringConstants.showApprioprateMessage("Academic Level is required");
            } else if (assignedClass == null) {
                StringConstants.showApprioprateMessage("Class Assigned is required");
            } else {

                student.setDateOfbirth(dateOfbirth);
                student.setDateOfAdmission(dateOfAdmission);
                student.setAcademicLevel(crudService.find(AcademicLevel.class, academicLevel));
                student.setAssignedClass(crudService.find(InstitutionClass.class, assignedClass));
                student.setStudentPixId(studentPixId);
                student.setAssignedProgramme(crudService.find(InstitutionProgram.class, assignedProgramme));
                student.setSurname(surname.toUpperCase());
                student.setOthernames(othername.toUpperCase());

                student.setNationality(crudService.find(Nationality.class, nationality));
                student.setRegion(crudService.find(Region.class, region));
                student.setGuardianOccupation(crudService.find(Occupation.class, guardianOccupation));
                student.setRelationToGuardian(crudService.find(KinRelation.class, relationToGuardian));
                student.setResidenceOfAffiliation(crudService.find(SchoolHouse.class, residenceOfAffiliation));
                student.setResidenceStatus(crudService.find(ResidenceStatus.class, residenceStatus));

                boolean updateSuccess = crudService.update(student);

                if (updateSuccess) {

                    List<ClassMembership> cmList = customCrudService.classMembershipStudent(student.getCommonId(), term.getAcademicYear());

                    if (!cmList.isEmpty()) {

                        cmList.get(0).setInstitutionClass(crudService.find(InstitutionClass.class, assignedClass));

                        crudService.update(cmList.get(0));
                    }

                    StringConstants.showApprioprateMessage(StringConstants.EDIT_MESSAGE);
                    resetButtonAction();
                    searchButtonAction();
                    returnToStudentDataViewPanel();
                } else {
                    StringConstants.showApprioprateMessage(StringConstants.EDIT_ERRORMESSAGE);
                }
            }
        }
    }

    public void deleteButtonAction() {

        if (studentTableModel == null) {
            StringConstants.showApprioprateMessage("Please select student record");
        } else {

            student = crudService.find(Student.class, studentTableModel.getStudentId());

            boolean deleteSuccess = crudService.delete(student, false);

            if (deleteSuccess) {
                StringConstants.showApprioprateMessage(StringConstants.DELETE_MESSAGE);
                student = new Student();
                studentTableModel = new StudentTableModel();
                searchButtonAction();
            } else {
                StringConstants.showApprioprateMessage(StringConstants.DELETE_ERRORMESSAGE);
            }
        }

    }

    public void resetButtonAction() {
        student = new Student();
        saveEditButtonText = "Save";
        dateOfAdmission = null;
        dateOfbirth = null;
        studentPix = "";
        studentPixId = "";
        academicLevel = "";
        assignedClass = "";
        surname = "";
        othername = "";
    }

    public void searchButtonAction() {

        studentTableModelList = new ArrayList<>();

        List<Student> studentList;

        if (searchAttribute.equals("allStudents")) {

            studentList = crudService.findAll(Student.class, false);

        } else {

            studentList = customCrudService.findByParameter(Student.class, searchAttribute, searchText, 'N');

        }

        if (studentList.size() > 0) {

            for (Student st : studentList) {
                String gender;
                StudentTableModel stm = new StudentTableModel();

                stm.setStudentId(st.getCommonId());

                if (st.getGender().equals('F')) {
                    gender = "(Miss.)";
                } else {
                    gender = "(Mr.)";
                }
                stm.setStudentName(st.getSurname().toUpperCase() + " " + st.getOthernames() + " " + gender);
                stm.setStudentCourse(st.getAssignedProgramme().getProgramName());

                String studentClass = st.getAssignedClass().getClassName();

                if (studentClass == null) {
                    stm.setStudentClass("");
                } else {
                    stm.setStudentClass(studentClass);
                }
                stm.setResidenceStatus(st.getResidenceStatus().getResidenceStatusDesc());
                stm.setGuardianName(st.getGuardianName());
                stm.setGuardianContact(st.getGuardianContactNumber());
                stm.setStudentId(st.getCommonId());
                stm.setHouse(st.getResidenceOfAffiliation().getHouseName());

                studentTableModelList.add(stm);
            }
        }

    }

    public void rowSelectDataAction(StudentTableModel stm) {

        String serverName = null;
        String pictureFolder = null;

        this.studentTableModel = stm;

        student = crudService.find(Student.class, studentTableModel.getStudentId());

        studentName = student.getSurname().toUpperCase() + " " + student.getOthernames();

        nationality = student.getNationality().getNationalityId();
        region = student.getRegion().getRegionId();
        guardianOccupation = student.getGuardianOccupation().getOccupationId();
        relationToGuardian = student.getRelationToGuardian().getKinRelationId();
        residenceOfAffiliation = student.getResidenceOfAffiliation().getCommonId();
        residenceStatus = student.getResidenceStatus().getResidenceStatusId();
        
        studentPixId = student.getStudentPixId();

        if (userSession.getSchoolConfig().size() < 1) {

            serverName = "localhost";
            pictureFolder = userSession.getSchoolConfig().get(0).getPixFolderName();

        } else {

            serverName = userSession.getSchoolConfig().get(0).getServerName();
            pictureFolder = userSession.getSchoolConfig().get(0).getPixFolderName();

        }

        if (student.getStudentPixId() == null) {

            studentPix = "http://" + serverName + ":8080/" + pictureFolder + "/" + "defaultImage.jpg";

        } else {

            studentPix = "http://" + serverName + ":8080/" + pictureFolder + "/" + student.getStudentPixId() + ".jpg";

        }

        renderStudentDataViewPanel = true;
        renderNewStudentEntryPanel = false;
        renderStudentListPanel = false;

        saveEditButtonText = "Update";
    }

    public void renderStudentDataEditPanel() {

        renderNewStudentEntryPanel = true;
        renderStudentDataViewPanel = false;
        renderStudentListPanel = false;

        surname = student.getSurname();
        othername = student.getOthernames();
        dateOfbirth = student.getDateOfbirth();
        dateOfAdmission = student.getDateOfAdmission();
        assignedProgramme = student.getAssignedProgramme().getCommonId();
        academicLevel = student.getAcademicLevel().getAcademicLevelId();
        assignedClass = student.getAssignedClass().getCommonId();

        saveEditButtonText = "Update";
    }

    public void returnToStudentDataViewPanel() {

        renderStudentListPanel = true;
        renderStudentDataViewPanel = false;
        renderNewStudentEntryPanel = false;

//        student = new Student();
    }

    public void showNewStudentEntryPanel() {

        renderStudentListPanel = false;
        renderStudentDataViewPanel = false;
        renderNewStudentEntryPanel = true;

        student = new Student();
        
        studentPix = "";
        studentPixId = "";         
        
        surname = "";
        othername = "";
        dateOfbirth = null;
        dateOfAdmission = null;
        assignedProgramme = "";
        academicLevel = "";
        assignedClass = "";
        nationality = "";
        region = "";
        guardianOccupation = "";
        relationToGuardian = "";

        saveEditButtonText = "Save";

    }
    //</editor-fold>

    //    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public StudentTableModel getStudentTableModel() {
        return studentTableModel;
    }

    public void setStudentTableModel(StudentTableModel studentTableModel) {
        this.studentTableModel = studentTableModel;
    }

    public List<StudentTableModel> getStudentTableModelList() {
        return studentTableModelList;
    }

    public void setStudentTableModelList(List<StudentTableModel> studentTableModelList) {
        this.studentTableModelList = studentTableModelList;
    }

    public SelectItem[] getAcademicLevelOptions() {
        return academicLevelOptions;
    }

    public void setAcademicLevelOptions(SelectItem[] academicLevelOptions) {
        this.academicLevelOptions = academicLevelOptions;
    }

    public String getAssignedProgramme() {
        return assignedProgramme;
    }

    public void setAssignedProgramme(String assignedProgramme) {
        this.assignedProgramme = assignedProgramme;
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

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(Date dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(String assignedClass) {
        this.assignedClass = assignedClass;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public SelectItem[] getClassAdmitted() {
        return classAdmitted;
    }

    public void setClassAdmitted(SelectItem[] classAdmitted) {
        this.classAdmitted = classAdmitted;
    }

    public boolean isRenderDisabilityDetailPanel() {
        return renderDisabilityDetailPanel;
    }

    public void setRenderDisabilityDetailPanel(boolean renderDisabilityDetailPanel) {
        this.renderDisabilityDetailPanel = renderDisabilityDetailPanel;
    }

    public String getSaveEditButtonText() {
        return saveEditButtonText;
    }

    public void setSaveEditButtonText(String saveEditButtonText) {
        this.saveEditButtonText = saveEditButtonText;
    }

    public String getStudentPix() {
        return studentPix;
    }

    public void setStudentPix(String studentPix) {
        this.studentPix = studentPix;
    }

    public boolean isRenderStudentListPanel() {
        return renderStudentListPanel;
    }

    public void setRenderStudentListPanel(boolean renderStudentListPanel) {
        this.renderStudentListPanel = renderStudentListPanel;
    }

    public boolean isRenderNewStudentEntryPanel() {
        return renderNewStudentEntryPanel;
    }

    public void setRenderNewStudentEntryPanel(boolean renderNewStudentEntryPanel) {
        this.renderNewStudentEntryPanel = renderNewStudentEntryPanel;
    }

    public boolean isRenderStudentDataViewPanel() {
        return renderStudentDataViewPanel;
    }

    public void setRenderStudentDataViewPanel(boolean renderStudentDataViewPanel) {
        this.renderStudentDataViewPanel = renderStudentDataViewPanel;
    }

    public String getStudentPixId() {
        return studentPixId;
    }

    public void setStudentPixId(String studentPixId) {
        this.studentPixId = studentPixId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getResidenceOfAffiliation() {
        return residenceOfAffiliation;
    }

    public void setResidenceOfAffiliation(String residenceOfAffiliation) {
        this.residenceOfAffiliation = residenceOfAffiliation;
    }

    public String getStudentAcademicStatus() {
        return studentAcademicStatus;
    }

    public void setStudentAcademicStatus(String studentAcademicStatus) {
        this.studentAcademicStatus = studentAcademicStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public String getRelationToGuardian() {
        return relationToGuardian;
    }

    public void setRelationToGuardian(String relationToGuardian) {
        this.relationToGuardian = relationToGuardian;
    }

    public String getResidenceStatus() {
        return residenceStatus;
    }

    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    public String getClientFullImagePath() {
        return clientFullImagePath;
    }

    public void setClientFullImagePath(String clientFullImagePath) {
        this.clientFullImagePath = clientFullImagePath;
    }

//</editor-fold>
}
