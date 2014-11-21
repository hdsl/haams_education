/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.controllers;

import com.sabonay.common.utils.DateTimeUtils;
import haams.ejb.entities.AcademicTerm;
import haams.ejb.entities.GradingSystem;
import haams.ejb.services.CrudService;
import haams.ejb.services.CustomCrudService;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author HDSL_MUMIN
 */
@Named(value = "commonController")
@RequestScoped
public class CommonController {

    @Inject
    private CrudService crudService;

    @Inject
    private CustomCrudService customCrudService;

    public CommonController() {
    }

//    private static final List<GradingSystem> examGradesList = crudService.findAll(GradingSystem.class, true);
//
//    public static GradingSystem getGradeOfMark(double mark) {
//        GradingSystem requestedExamGradeDetail = null;
//
//        for (GradingSystem examGradeDetail : examGradesList) {
//            double lowerBound = examGradeDetail.getGradeLowerBound();
//            double upperBound = examGradeDetail.getGradeUpperBound();
//
//            if ((mark <= upperBound) && (mark >= lowerBound)) {
//                requestedExamGradeDetail = examGradeDetail;
//                break;
//            }
//        }
//
//        return requestedExamGradeDetail;
//    }

//    public static String getNextTermBeginDate() {
//        String nextTermBeginsDate = "";
//
//        AcademicTerm nextAcademicTerm
//                = ds.getCustomDA().findNextAcademicTerm(userData.getCurrentTermID());
//
//        if (nextAcademicTerm != null) {
//            Date nextTermBegins = nextAcademicTerm.getBeginDate();
//
//            nextTermBeginsDate = DateTimeUtils.formatDateShort(nextTermBegins);
//        }
//
//        return nextTermBeginsDate;
//    }
//
//    public static String getNextAcademicTermCode() {
//        String nextTerm = "";
//
//        AcademicTerm nextAcademicTerm
//                = ds.getCustomDA().findNextAcademicTerm(userData.getCurrentTermID());
//
//        if (nextAcademicTerm != null) {
//            return nextAcademicTerm.getAcademicTermId();
//        }
//        return nextTerm;
//    }

}
