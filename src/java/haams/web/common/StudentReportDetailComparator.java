/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.common;

import java.util.Comparator;

/**
 *
 * @author AbdulMumin
 */
public class StudentReportDetailComparator implements Comparator<StudentReportDetail> {

    @Override
    public int compare(StudentReportDetail o1, StudentReportDetail o2) {
        if (o2.getCumulativeMarks() == o1.getCumulativeMarks()) {
            return 0;
        } else if (o2.getCumulativeMarks() >= o1.getCumulativeMarks()) {
            return 1;
        } else {
            return -1;
        }
    }
}
