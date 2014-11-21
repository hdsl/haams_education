/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.common;

import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.Student;

/**
 *
 * @author AbdulMumin
 */
public class CommonMethods {

    public static String studentName(Student student) {
        
        String gender;
        
        if (student.getGender().equals('F')) {
            gender = "(Miss.)";
        } else {
            gender = "(Mr.)";
        }

        String studentName = student.getSurname() + " " + student.getOthernames() + " " + gender;

        return studentName;
    }

    public static String staffName(InstitutionStaff institutionStaff) {
        
        String gender;
        
        if (institutionStaff.getGender().equals('F')) {
            gender = "(Miss.)";
        } else {
            gender = "(Mr.)";
        }

        String staffName = institutionStaff.getSurname() + " " + institutionStaff.getOtherName() + " " + gender;

        return staffName;
    }
}
