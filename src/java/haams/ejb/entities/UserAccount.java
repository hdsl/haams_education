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
@Table(name = "user_account", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u"),
    @NamedQuery(name = "UserAccount.findByUserAccountId", query = "SELECT u FROM UserAccount u WHERE u.userAccountId = :userAccountId"),
    @NamedQuery(name = "UserAccount.findByStaffId", query = "SELECT u FROM UserAccount u WHERE u.staffId = :staffId"),
    @NamedQuery(name = "UserAccount.findByUsername", query = "SELECT u FROM UserAccount u WHERE u.username = :username"),
    @NamedQuery(name = "UserAccount.findByUserPassword", query = "SELECT u FROM UserAccount u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "UserAccount.findByAccessRight", query = "SELECT u FROM UserAccount u WHERE u.accessRight = :accessRight"),
    @NamedQuery(name = "UserAccount.findByAccountStatus", query = "SELECT u FROM UserAccount u WHERE u.accountStatus = :accountStatus"),
    @NamedQuery(name = "UserAccount.findByUpdated", query = "SELECT u FROM UserAccount u WHERE u.updated = :updated"),
    @NamedQuery(name = "UserAccount.findByDeleted", query = "SELECT u FROM UserAccount u WHERE u.deleted = :deleted")})
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "user_account_id", nullable = false, length = 35)
    private String userAccountId;
    @Size(max = 35)
    @Column(name = "staff_id", length = 35)
    private String staffId;
    @Size(max = 35)
    @Column(name = "username", length = 35)
    private String username;
    @Size(max = 45)
    @Column(name = "user_password", length = 45)
    private String userPassword;
    @Size(max = 2)
    @Column(name = "access_right", length = 2)
    private String accessRight;
    @Column(name = "account_status")
    private Character accountStatus;
    @Column(name = "updated")
    private Character updated;
    @Column(name = "deleted")
    private Character deleted;

    public UserAccount() {
    }

    public UserAccount(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    public Character getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Character accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Character getUpdated() {
        return updated;
    }

    public void setUpdated(Character updated) {
        this.updated = updated;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAccountId != null ? userAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.userAccountId == null && other.userAccountId != null) || (this.userAccountId != null && !this.userAccountId.equals(other.userAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.UserAccount[ userAccountId=" + userAccountId + " ]";
    }
    
}
