/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.common;

import com.sabonay.common.formating.NumberFormattingUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AbdulMumin
 */
public class StudentReportDetail extends StudentDetail
{

    private List<ExamMarkDetail> listOfStudentMarkDetail = new ArrayList<>();
    
    private String positionInClass = "";
    private String studentExamAverage = "";
    private String promotionStatus = "";
    private String classPromotedTo = "";
    private String studentConduct = "";
    private String studentId = "";
    private String programmeOption = "";
    
    

    private String reportID = "";

    private double cumulativeMarks = 0.0;

    public double getCumulativeMarks()
    {
        return cumulativeMarks;
    }

    public double getCumulativeMarksRoundedUp()
    {
        return NumberFormattingUtils.formatDecimalNumberTo_2(cumulativeMarks);
    }

   
    public void setCumulativeMarks(double cumulativeMarks)
    {
        this.cumulativeMarks = cumulativeMarks;
    }

    public List<ExamMarkDetail> getListOfStudentMarkDetail4Rpts()
    {
        return listOfStudentMarkDetail;
    }

    public void setListOfStudentMarkDetail4Rpts(List<ExamMarkDetail> listOfStudentMarkDetail4Rpts)
    {
        this.listOfStudentMarkDetail = listOfStudentMarkDetail4Rpts;
    }

    public void addStudentMarksDetail(ExamMarkDetail studentMarkDetail)
    {
        getListOfStudentMarkDetail4Rpts().add(studentMarkDetail);

        try
        {
            cumulativeMarks += Double.parseDouble(studentMarkDetail.getTotalScore());
        } catch (Exception e)
        {
        }       
        
    }
    

    public String getPositionInClass()
    {
        if(positionInClass == null)
            positionInClass = "";
        
        return positionInClass;
    }

    public void setPositionInClass(String positionInClass)
    {
        this.positionInClass = positionInClass;
    }
    

    

    public String getStudentExamAverage()
    {


        return studentExamAverage;
    }

    public void setStudentExamAverage(String studentExamAverage)
    {
        this.studentExamAverage = studentExamAverage;
    }

    public String getClassPromotedTo()
    {
        return classPromotedTo;
    }

    public void setClassPromotedTo(String classPromotedTo)
    {
        this.classPromotedTo = classPromotedTo;
    }

    public String getPromotionStatus()
    {
        return promotionStatus;
    }

    public void setPromotionStatus(String promotionStatus)
    {
        this.promotionStatus = promotionStatus;
    }

    public String getReportID()
    {
        return reportID;
    }

    public void setReportID(String reportID)
    {
        this.reportID = reportID;
    }

    public List<ExamMarkDetail> getListOfStudentMarkDetail() {
        return listOfStudentMarkDetail;
    }

    public void setListOfStudentMarkDetail(List<ExamMarkDetail> listOfStudentMarkDetail) {
        this.listOfStudentMarkDetail = listOfStudentMarkDetail;
    }

    public String getStudentConduct() {
        return studentConduct;
    }

    public void setStudentConduct(String studentConduct) {
        this.studentConduct = studentConduct;
    }


//
//    @Override
    public String toString() {
        return cumulativeMarks+"";
    }

    public List<ExamMarkDetail> getMarksWithSomeMising()
    {
        List<ExamMarkDetail> markDetailsList = new LinkedList<ExamMarkDetail>();

        for (ExamMarkDetail studentMarkDetail : listOfStudentMarkDetail)
        {
            if (studentMarkDetail.wasSomeNotAvailable())
            {
//                studentMarkDetail.setStudentName(getStudentName());
//                studentMarkDetail.setStudentId(getStudentBasicId());
                markDetailsList.add(studentMarkDetail);
            }
        }

        return markDetailsList;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgrammeOption() {
        return programmeOption;
    }

    public void setProgrammeOption(String programmeOption) {
        this.programmeOption = programmeOption;
    }

    
}
