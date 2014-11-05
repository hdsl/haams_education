/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.web.controllers;

import haams.ejb.entities.AccessRight;
import haams.ejb.entities.InstitutionStaff;
import haams.ejb.entities.UserAccount;
import haams.ejb.services.CrudService;
import haams.web.tableModel.StaffTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author HDSL_MUMIN
 */
@Named
@ViewScoped
public class UserAccountView implements Serializable{

    @Inject
    private CrudService crudService;
    
    private List<StaffTableModel> staffAccountList;
    
    @PostConstruct
    public void init(){
        
        staffAccountList = new ArrayList<>();
        
       List<UserAccount> userAccountList = crudService.findAll(UserAccount.class, false);
        
        for (UserAccount ua : userAccountList) {
            
            StaffTableModel staffView = new StaffTableModel();

            InstitutionStaff st = crudService.find(InstitutionStaff.class, ua.getStaffId());
            
            staffView.setUserAccountId(ua.getUserAccountId());
//
//            String gender = "";
//            System.out.println("gender................"+st.getGender());
//            if (st.getGender().equals('F')) {
//                gender = "(Miss.)";
//            } else {
//                gender = "(Mr.)";
//            }

            staffView.setStaffName(st.getSurname().toUpperCase() + " " + st.getOtherName());

            staffView.setUsername(ua.getUsername());

            staffView.setUserAccessRight(crudService.find(AccessRight.class, ua.getAccessRight()).getAccessRight());

            staffAccountList.add(staffView);
        }
    }

    public List<StaffTableModel> getStaffAccountList() {
        return staffAccountList;
    }

}
