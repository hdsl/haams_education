package haams.ejb.services;

import haams.ejb.entities.ClassMembership;
import haams.ejb.entities.GeneratePk;
import haams.ejb.entities.InstitutionClass;
import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.StudentFeeLedger;
import haams.ejb.entities.SubjectGroup;
import haams.ejb.entities.UserAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HYSEN SOFTWARE DEPT
 */
@Stateless
public class CustomCrudService {

    @PersistenceContext
    private EntityManager em;

    public List findByParameter(Class t, String parameterQuery, String searchText, Character includeLogicallyDelete) {

        String qry = "SELECT t FROM " + t.getSimpleName() + " t "
                + "WHERE t." + parameterQuery + " LIKE '%" + searchText + "%' "
                + "AND t.deleted='" + includeLogicallyDelete + "' ";

        try {

            return em.createQuery(qry).getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return Collections.EMPTY_LIST;

        }
    }

    public <T> T find(Class t, String parameterQuery, String searchText) {

        String qry = "SELECT t FROM " + t.getSimpleName() + " t "
                + "WHERE t." + parameterQuery + " LIKE '%" + searchText + "%' ";

        try {

            return (T) em.createQuery(qry).getSingleResult();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }

    public List findByParameter(Class t, String searchAttribute1, String searcText1, String searchAttribute2, String searcText2, Character includeLogicallyDelete) {

        String qry = "SELECT t FROM " + t.getSimpleName() + " t "
                + "WHERE t." + searchAttribute1 + " LIKE '%" + searcText1 + "%' "
                + "AND t." + searchAttribute2 + " LIKE '%" + searcText2 + "%' "
                + "AND t.deleted='" + includeLogicallyDelete + "' ";

        try {

            return em.createQuery(qry).getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return Collections.EMPTY_LIST;

        }
    }

    public List<StudentFeeLedger> getStudentPreviousFeeLedger(String studentId, String academicTermApplied) {

        List<StudentFeeLedger> studentFeeLedgerList = null;

        String qryString = "";

        try {

            qryString = "SELECT e FROM StudentFeeLedger e WHERE e.studentId = '" + studentId + "' "
                    + "AND e.academicTermApplied < :academicTermApplied  AND e.deleted = 'N'";

            studentFeeLedgerList = em.createQuery(qryString).setParameter("academicTermApplied", academicTermApplied).getResultList();

            return studentFeeLedgerList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentFeeLedger> selectedStudentCurrentFeeLedgerList(String studentId, String academicTermApplied, String billType) {

        List<StudentFeeLedger> studentFeeLedgerList = null;

        String qryString = "";

        try {

            qryString = "SELECT e FROM StudentFeeLedger e WHERE e.studentId = '" + studentId + "' "
                    + "AND e.academicTermApplied = :academicTermApplied  "
                    + "AND e.studentBill.billItemType='" + billType + "' AND e.deleted = 'N'";

            studentFeeLedgerList = em.createQuery(qryString).setParameter("academicTermApplied", academicTermApplied).getResultList();

            return studentFeeLedgerList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentFeeLedger> selectedStudentCurrentFeeLedgerList(String studentId, String academicTermApplied) {

        List<StudentFeeLedger> studentFeeLedgerList = null;

        String qryString = "";

        try {

            qryString = "SELECT e FROM StudentFeeLedger e WHERE e.studentId = '" + studentId + "' "
                    + "AND e.academicTermApplied = :academicTermApplied AND e.deleted = 'N' ORDER BY e.dateOfPayment";

            studentFeeLedgerList = em.createQuery(qryString).setParameter("academicTermApplied", academicTermApplied).getResultList();

            return studentFeeLedgerList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SubjectGroup> subjectGroupFindByAttribute(String academicProgrammeId) {
        List<SubjectGroup> listOfSubjectGroup = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM SubjectGroup e WHERE  e.institutionProgram.commonId = '" + academicProgrammeId + "' "
                    + "AND e.deleted='N'";

            listOfSubjectGroup = em.createQuery(qryString).getResultList();

            return listOfSubjectGroup;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<InstitutionClass> getInstitutionClass(String academicLevel, String schoolProgramme) {
        List<InstitutionClass> listOfInstitutionClass = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM InstitutionClass e WHERE e.academicLevel.academicLevelId = '" + academicLevel + "'"
                    + "AND e.institutionProgram.commonId='" + schoolProgramme + "'  AND e.deleted = 'N'";

            listOfInstitutionClass = (List<InstitutionClass>) em.createQuery(qryString).getResultList();

            return listOfInstitutionClass;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public UserAccount getUserAccount(String username, String password) {

        String qry = "SELECT t FROM UserAccount t WHERE t.username = '" + username + "' AND t.userPassword = '" + password + "' "
                + "AND t.deleted = 'N'";

        try {

            return (UserAccount) em.createQuery(qry).getSingleResult();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }

    public List<ClassMembership> classMembershipStudent(String studentId, String academicYear) {

        String qryString = "";

        try {

            qryString = "SELECT e FROM ClassMembership e WHERE e.student.commonId = '" + studentId + "' "
                    + " AND e.academicYear='" + academicYear + "' AND e.deleted = 'N' ";

            return em.createQuery(qryString).getResultList();

        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public ClassMembership classMembershipFindByAttribute(String academicYear, String institutionClass, String studentId) {

        String qryString = "";

        try {
            qryString = "SELECT e FROM ClassMembership e WHERE e.student.commonId = '" + studentId + "' AND e.academicYear.commonId='" + academicYear + "' "
                    + "AND e.institutionClass.commonId = '" + institutionClass + "' AND e.deleted='N' ";

            return (ClassMembership) em.createQuery(qryString).getSingleResult();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public List<ClassMembership> classMembershipFindByAttribute(String institutionClass, String academicYear) {
        List<ClassMembership> listOfClassMembership = null;
        String qryString = "";

        try {
            qryString = "SELECT e FROM ClassMembership e WHERE e.academicYear.commonId='" + academicYear + "' "
                    + "AND e.institutionClass.commonId = '" + institutionClass + "' AND e.deleted='N' ";

            listOfClassMembership = em.createQuery(qryString).getResultList();

            return listOfClassMembership;

        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public List<InstitutionStaff> institutionTeachingStaffGetAll() {

        List<InstitutionStaff> teachingStaff = null;

        String qryString = "SELECT e FROM InstitutionStaff e WHERE e.staffCategory='02' "
                + "AND e.deleted = 'N' ORDER BY e.surname ASC";
        
        try {

            return teachingStaff = (List<InstitutionStaff>) em.createQuery(qryString).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }

    }

//    public List searchByParameter(Class t, String parameterQuery, String productTypeId, Character includeLogicallyDelete) {
//
//        String qry = "SELECT t FROM " + t.getSimpleName() + " t "
//                + "WHERE t." + parameterQuery +"="+ productTypeId+ " "
//                + "AND t.deleted='" + includeLogicallyDelete + "' ";
//
//        try {
//
//            return em.createQuery(qry).getResultList();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return Collections.EMPTY_LIST;
//
//        }
//    }
//    public List<ClientProduct> clientProductsList(String clientId, String productType) {
//
//        List<ClientProduct> productList;
//
//        String qry = "SELECT s FROM ClientProduct s WHERE s.clientDetail.commonId = '" + clientId + "' "
//                + "AND s.productTypeModel.productTypes.commonId = '" + productType + "' AND s.deleted = 'N'";
//
//        try {
//
//            productList = em.createQuery(qry).getResultList();
//
//            return productList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.EMPTY_LIST;
//        }
//    }
//    public ClientContact clientContactSave(ClientContact cc) {
//
//        try {
//
//            cc.setDeleted('N');
//            cc.setUpdated('N');
//            em.merge(cc);
//            em.flush();
//
//            return cc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public List<ServiceRequest> clientPMServiceList(String clientId, String searchAttribute) {
//
//        List<ServiceRequest> serviceRequestList;
//
//        String qry = null;
//
//        if (searchAttribute.equals("customer_name")) {
//
//            qry = "SELECT t FROM ServiceRequest t WHERE t.clientDetail.commonId = '" + clientId + "' "
//                    + "AND t.serviceRequestId LIKE PM AND t.deleted='N' "
//                    + "ORDER BY t.serviceStartDate ";
//
//        } else if (searchAttribute.equals("engineer_name")) {
//
//            qry = "SELECT t FROM ServiceRequest t WHERE t.staffDetail.commonId = '" + clientId + "' "
//                    + "AND t.deleted='N' "
//                    + "ORDER BY t.serviceStartDate ";
//
//        }
//
//        try {
//
//            serviceRequestList = em.createQuery(qry).getResultList();
//
//            return serviceRequestList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.EMPTY_LIST;
//        }
//
//    }
//    public List<ServiceRequest> clientServiceRequestList(Date startDate, Date endDate, String clientId) {
//
//        List<ServiceRequest> serviceRequestList;
//
//        String qry = "SELECT t FROM ServiceRequest t WHERE t.clientDetail.commonId = '" + clientId + "' "
//                + "AND t.requestDate BETWEEN :startDate AND :endDate AND t.deleted='N' "
//                + "ORDER BY t.clientProduct.serialNumber ";
//
//        try {
//
//            serviceRequestList = em.createQuery(qry).setParameter("startDate", startDate, TemporalType.TIMESTAMP).setParameter("endDate", endDate, TemporalType.TIMESTAMP).getResultList();
//
//            return serviceRequestList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.EMPTY_LIST;
//        }
//
//    }
//    public List<ServiceRequest> clientServiceModelRequestList(Date startDate, Date endDate, String serialNumber) {
//
//        List<ServiceRequest> serviceRequestList;
//
//        String qry = "SELECT t FROM ServiceRequest t WHERE t.clientProduct.commonId = '" + serialNumber + "' "
//                + "AND t.requestDate BETWEEN :startDate AND :endDate AND t.deleted='N' "
//                + "ORDER BY t.requestDate ";
//
//        try {
//
//            serviceRequestList = em.createQuery(qry).setParameter("startDate", startDate, TemporalType.TIMESTAMP).setParameter("endDate", endDate, TemporalType.TIMESTAMP).getResultList();
//
//            return serviceRequestList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.EMPTY_LIST;
//        }
//
//    }
//
//    public List<ServiceRequest> serviceRequestList(String clientProductId) {
//
//        List<ServiceRequest> serviceRequestList;
//
//        String qry = "SELECT t FROM ServiceRequest t WHERE t.clientProduct.commonId = '" + clientProductId + "' "
//                + "AND t.deleted='N' ORDER BY t.requestDate ";
//
//        try {
//
//            serviceRequestList = em.createQuery(qry).getResultList();
//
//            return serviceRequestList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Collections.EMPTY_LIST;
//        }
//
//    }
//    public ServiceRequest clientPMScheduleList(String pmPeriod, int pmYear, String serialNumber) {
//
//        String qry = "SELECT t FROM ServiceRequest t WHERE t.clientProduct.commonId = '" + serialNumber + "' "
//                + "AND t.pmPeriod = '" + pmPeriod + "' AND t.pmYear='" + pmYear + "' AND t.deleted='N' "
//                + "ORDER BY t.serviceStartDate ";
//
//        try {
//
//            return (ServiceRequest) em.createQuery(qry).getSingleResult();
//
//        } catch (Exception e) {
////            e.printStackTrace();
//            return null;
//        }
//
//    }
    // <editor-fold defaultstate="collapsed" desc=" GeneratePk Persistence Functionalities">
    public boolean generatePkUpdate(GeneratePk generatePk) {
        try {

            em.merge(generatePk);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Integer generatePk(String pkName) {
        try {

            GeneratePk generatePk = em.find(GeneratePk.class, pkName);

            int in = generatePk.getPkValue();
            int a = 1 + in;

            return a;
        } catch (Exception e) {
            return null;
        }
    }

    public GeneratePk getGenPk(String pkName) {
        try {

            GeneratePk generatePk = em.find(GeneratePk.class, pkName);

            return generatePk;

        } catch (Exception e) {
            return null;
        }
    }

    // </editor-fold>
}
