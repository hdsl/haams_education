
package haams.ejb.entities;

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
@Table(name = "class_membership")
@NamedQueries({
    @NamedQuery(name = "ClassMembership.findAll", query = "SELECT c FROM ClassMembership c")})
public class ClassMembership extends CommonEntity {
   
    @JoinColumn(name = "academic_year")
    @ManyToOne
    private AcademicYear academicYear;
    
    @JoinColumn(name = "student_id")
    private Student student;
    
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
    
    @JoinColumn(name = "institution_class")
    private InstitutionClass institutionClass;
  
    public ClassMembership() {
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }
    
    public InstitutionClass getInstitutionClass() {
        return institutionClass;
    }

    public void setInstitutionClass(InstitutionClass institutionClass) {
        this.institutionClass = institutionClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectGroup getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(SubjectGroup subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

}
