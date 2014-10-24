/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package haams.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HDSL_MUMIN
 */
@Entity
@Table(name = "student_bill_item", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentBillItem.findAll", query = "SELECT s FROM StudentBillItem s"),
    @NamedQuery(name = "StudentBillItem.findByBillItemId", query = "SELECT s FROM StudentBillItem s WHERE s.billItemId = :billItemId"),
    @NamedQuery(name = "StudentBillItem.findByItemName", query = "SELECT s FROM StudentBillItem s WHERE s.itemName = :itemName"),
    @NamedQuery(name = "StudentBillItem.findByDeleted", query = "SELECT s FROM StudentBillItem s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "StudentBillItem.findByUpdated", query = "SELECT s FROM StudentBillItem s WHERE s.updated = :updated")})
public class StudentBillItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "bill_item_id", nullable = false, length = 35)
    private String billItemId;
    @Size(max = 255)
    @Column(name = "item_name", length = 255)
    private String itemName;
    @Lob
    @Size(max = 65535)
    @Column(name = "item_description", length = 65535)
    private String itemDescription;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "updated")
    private Character updated;

    public StudentBillItem() {
    }

    public StudentBillItem(String billItemId) {
        this.billItemId = billItemId;
    }

    public String getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(String billItemId) {
        this.billItemId = billItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getUpdated() {
        return updated;
    }

    public void setUpdated(Character updated) {
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billItemId != null ? billItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentBillItem)) {
            return false;
        }
        StudentBillItem other = (StudentBillItem) object;
        if ((this.billItemId == null && other.billItemId != null) || (this.billItemId != null && !this.billItemId.equals(other.billItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.StudentBillItem[ billItemId=" + billItemId + " ]";
    }
    
}
