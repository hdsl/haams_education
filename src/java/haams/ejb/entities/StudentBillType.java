/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "student_bill_type")
@NamedQueries({
    @NamedQuery(name = "StudentBillType.findAll", query = "SELECT s FROM StudentBillType s")})
public class StudentBillType extends CommonEntity {

    @Column(name = "bill_type_name")
    private String billTypeName;

    public StudentBillType() {
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

}
