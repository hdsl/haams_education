/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.utils;

import com.sabonay.common.utils.DateTimeUtils;
import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.GradingSystem;
import haams.ejb.services.CrudService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author abdulmumin
 */
public class StringConstants {

    @Inject
    private CrudService crudService;

    public static final String SAVE_MESSAGE = "Saved Successfully";
    public static final String DELETE_MESSAGE = "Deleted Successfully";
    public static final String EDIT_MESSAGE = "Updated Successfully";
    public static final String SAVE_ERRORMESSAGE = "Unable to save";
    public static final String DELETE_ERRORMESSAGE = "Unable to delete";
    public static final String EDIT_ERRORMESSAGE = "Unable to update";

    public static void showApprioprateMessage(String message) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(message);
        facesContext.addMessage(null, facesMessage);

    }

    public static String generateID() {

        return UUID.randomUUID().toString();

    }

    public static String hashGeneratedPassword(String pwd) {

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(pwd.getBytes());

    }

    public static String unHashGeneratedPassword(String pwd) {

        BASE64Decoder decoder = new BASE64Decoder();

        try {
            return new String(decoder.decodeBuffer(pwd));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static String boldTextWithHTML(String textToBolden) {
        String formattedText = "";

        formattedText = "" + textToBolden + "";

        return formattedText;
    }

    List<GradingSystem> examGradesList = crudService.findAll(GradingSystem.class, true);

    public GradingSystem getGradeOfMark(double mark) {

        GradingSystem requestedExamGradeDetail = null;

        for (GradingSystem examGradeDetail : examGradesList) {
            double lowerBound = examGradeDetail.getGradeLowerBound();
            double upperBound = examGradeDetail.getGradeUpperBound();

            if ((mark <= upperBound) && (mark >= lowerBound)) {
                requestedExamGradeDetail = examGradeDetail;
                break;
            }
        }

        return requestedExamGradeDetail;
    }

    public static String getNextTermBeginDate() {
        String nextTermBeginsDate = "";
//
//        AcademicTerm nextAcademicTerm =
//                ds.getCustomDA().findNextAcademicTerm(userData.getCurrentTermID());
//
//       if(nextAcademicTerm != null)
//       {
//           Date nextTermBegins = nextAcademicTerm.getBeginDate();
//
//           nextTermBeginsDate = DateTimeUtils.formatDateShort(nextTermBegins);
//       }

        return nextTermBeginsDate;
    }

    public static String getNextAcademicTermCode() {
        String nextTerm = "";

//        AcademicTerm nextAcademicTerm
//                = ds.getCustomDA().findNextAcademicTerm(userData.getCurrentTermID());
//
//        if (nextAcademicTerm != null) {
//            return nextAcademicTerm.getAcademicTermId();
//        }
        return nextTerm;
    }

}
