package haams.ejb.entities;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "subject_group")
@NamedQueries({
    @NamedQuery(name = "SubjectGroup.findAll", query = "SELECT s FROM SubjectGroup s")})
public class SubjectGroup extends CommonEntity {

    @JoinColumn(name = "institution_program")
    @ManyToOne
    private InstitutionProgram institutionProgram;

    @Column(name = "subject_group_name")
    private String subjectGroupName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "subjects_ids")
    private String subjectsIds;

    @Column(name = "group_status")
    private String groupStatus;

    public SubjectGroup() {
    }

    public String getSubjectGroupName() {
        return subjectGroupName;
    }

    public void setSubjectGroupName(String subjectGroupName) {
        this.subjectGroupName = subjectGroupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public InstitutionProgram getInstitutionProgram() {
        return institutionProgram;
    }

    public void setInstitutionProgram(InstitutionProgram institutionProgram) {
        this.institutionProgram = institutionProgram;
    }

    public String getSubjectsIds() {
        return subjectsIds;
    }

    public void setSubjectsIds(String subjectsIds) {
        this.subjectsIds = subjectsIds;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }
//
//    @Transient
//    private List<InstitutionSubject> combinationSubjectList = new LinkedList<>();
//
//    public List<InstitutionSubject> getCombinationSubjectList() {
//
//        combinationSubjectList.clear();
//
//        if (subjectsIds == null) {
//            return combinationSubjectList;
//        }
//
//        String[] subjectCodes = subjectsIds.split("/");
//
//        for (String subjectCode : subjectCodes) {
//
//            try {
//                CrudService newInstance = CrudService.class.newInstance();
//                
//                System.out.println("Subject id..............."+subjectCode);
//
//                InstitutionSubject schoolSubject = newInstance.find(InstitutionSubject.class, subjectCode);
//
//                System.out.println("school subject from entity..........."+schoolSubject);
//                if (schoolSubject != null) {
//                    combinationSubjectList.add(schoolSubject);
//                }
//            } catch (InstantiationException ex) {
//                Logger.getLogger(SubjectGroup.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(SubjectGroup.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return combinationSubjectList;
//    }
//
//    public void setCombinationSubjectList(List<InstitutionSubject> combinationSubjectList) {
//        this.combinationSubjectList = combinationSubjectList;
//
//        subjectsIds = "";
//
//        for (InstitutionSubject schoolSubject : combinationSubjectList) {
//            subjectsIds = subjectsIds + "/" + schoolSubject.getCommonId();
//        }
//
//    }

    public String[] combinationSubjectCodes() {
        if (subjectsIds == null) {
            return new String[0];
        }

        return subjectsIds.split("/");
    }

    public String subjectIdsForQry() {
        String str = "";

        String[] ids = combinationSubjectCodes();

        for (int i = 0; i < ids.length; i++) {
            String string = ids[i];

            str = str + "'" + string + "'";

            if (i < (ids.length - 1)) {
                str = str + ",";
            }

        }

        return str;
    }

    private static final Set<String> combinationSubjectCodesSet = new LinkedHashSet<>();

    private void createSubjectCodesSet() {
        combinationSubjectCodesSet.clear();
        combinationSubjectCodesSet.addAll(Arrays.asList(combinationSubjectCodes()));
    }

    public Set<String> combinationSubjectCodesSet() {
        createSubjectCodesSet();
        return combinationSubjectCodesSet;
    }

}
