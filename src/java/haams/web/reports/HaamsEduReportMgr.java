package haams.web.reports;

import com.sabonay.modules.jasperreporting.JasperReportManager;
import com.sabonay.modules.jasperreporting.ReportDesignFileType;
import com.sabonay.modules.jasperreporting.ReportOutputEnvironment;
import com.sabonay.modules.jasperreporting.ReportOutputFileType;
import haams.ejb.entities.EducationalInstitution;
import haams.ejb.services.CrudService;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

public class HaamsEduReportMgr extends JasperReportManager implements Serializable {

    @Inject
    private CrudService crudService;

    public static final String REPORT_BASE_DIR = "/haams/web/reports/";

    public static final String CLASS_MEMBERSHIP_REPORT = REPORT_BASE_DIR + "class_membership.jasper";

    public static final String CLASS_SIGN_SHEET_REPORT = REPORT_BASE_DIR + "class_sign_sheet.jasper";

    public static final String EXAMS_SIGN_SHEET_REPORT = REPORT_BASE_DIR + "examination_sign_sheet.jasper";

    public static final String STUDENT_CONTACT_REPORT = REPORT_BASE_DIR + "student_contact.jasper";

    public static final String FEES_PAYMENT_RECEIPT = REPORT_BASE_DIR + "fees_receipt.jasper";

    public static final String STUDENT_LEDGER = REPORT_BASE_DIR + "student_ledger.jasper";

    public static final String HOUSE_MEMBERSHIP_REPORT = REPORT_BASE_DIR + "house_membership.jasper";

    public static final String HOUSE_MEMBERSHIP_DISTRIBUTION = REPORT_BASE_DIR + "residence_distribution.jasper";

    public static final String CLASS_TEACHERS_LIST = REPORT_BASE_DIR + "class_teacher.jasper";

    public static final String SUBJECT_TEACHERS_LIST = REPORT_BASE_DIR + "subject_teacher.jasper";

    public static final String STAFF_DETAILED_REPORT = REPORT_BASE_DIR + "staff_detail.jasper";

    public static final String STUDENT_BILL_REPORT = REPORT_BASE_DIR + "student_bill.jasper";

    public static final String SCHOOL_FEES_SUMMARY_REPORT = REPORT_BASE_DIR + "school_fees_ledger.jasper";

    public static final String ACADEMIC_TERM_FEES_REPORT = REPORT_BASE_DIR + "class_bills_summary.jasper";

    public static final String SPECIAL_BILLS_REPORT = REPORT_BASE_DIR + "special_bills.jasper";

    public static final String CLASS_BILL_PAYMENT_REPORT = REPORT_BASE_DIR + "class_bill_payment_summary.jasper";

    public static final String DAILY_FEES_PAYMENT_REPORT = REPORT_BASE_DIR + "daily_fees_payment.jasper";

    public static final String STUDENT_TERMINAL_EXAM = REPORT_BASE_DIR + "student_report.jasper";
    public static final String STUDENT_TERMINAL_SUB = REPORT_BASE_DIR + "student_subject_4_report.jasper";

    public String companyLogoFullImagePath = System.getProperty("com.sun.aas.instanceRoot")
            + File.separator + "docroot"
            + File.separator + "DOXA_PIX" + File.separator;

    private static HaamsEduReportMgr reportManager = new HaamsEduReportMgr();

    private HaamsEduReportMgr() {
        setReportEnvironment(ReportOutputEnvironment.WEB_APPLICATION);
        setReportFileType(ReportDesignFileType.INPUTSTREAM);
        setReportOutput(ReportOutputFileType.PDF);
    }

    public static HaamsEduReportMgr instance() {
        return reportManager;
    }

    public void showPDFReport(Collection reportData, String jasperFile) {
        InputStream is = HaamsEduReportMgr.class.getResourceAsStream(jasperFile);
        showReport(reportData, is);
    }

    public void showPDFReport(Object reportData, String jasperFile) {
        showReport(reportData, jasperFile);

    }

    public void writePDFReportToFile(Collection reportData, String jasperFile, String reportDirector, String reportFile) {

        InputStream is = HaamsEduReportMgr.class.getResourceAsStream(jasperFile);
        writeToFile(reportData, is, reportDirector, reportFile);

    }

    public void setReportTilte(String reportTitle) {
        addParam("reportTitle", reportTitle);
    }

//    public static void addParam(String paramKey, Object paramValue)
//    {
//        reportManager.addParam(paramKey, paramValue);
//    }
    public void initDefaultParamenters() {
        String serverName = null;
        String pictureFolder = null;

        List<EducationalInstitution> configuration = crudService.findAll(EducationalInstitution.class, true);

        if (configuration.size() < 1) {
            serverName = "localhost";
            pictureFolder = configuration.get(0).getPixFolderName();
        } else {
            serverName = configuration.get(0).getServerName();
            pictureFolder = configuration.get(0).getPixFolderName();
        }

        String companyLogo = "http://" + serverName + ":8080/" + pictureFolder + "/" + "companyLogo.jpg";

        addToDefaultParameters("companyName", configuration.get(0).getInstitutionName());
        addToDefaultParameters("footerText", "Haams. (0540926315)");
        addToDefaultParameters("companyLogo", companyLogo);
        addToDefaultParameters("companyAddress", configuration.get(0).getInstitutionAddress());
        addToDefaultParameters("companyTelephone", configuration.get(0).getInstitutionPrimaryContact() + "/" + configuration.get(0).getInstitutionOtherContact());

    }

    public void resetParameterToEmpty() {
        resetReportParametersToDefault();
    }
}
