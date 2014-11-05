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

/**
 *
 * @author AbdulMumin
 */
@Entity
@Table(name = "school_term")
@NamedQueries({
    @NamedQuery(name = "SchoolTerm.findAll", query = "SELECT s FROM SchoolTerm s")})
public class SchoolTerm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "commonId")
    private String commonId;
    @Size(max = 35)
    @Column(name = "term_desc")
    private String termDesc;

    public SchoolTerm() {
    }

    public SchoolTerm(String commonId) {
        this.commonId = commonId;
    }

    public String getcommonId() {
        return commonId;
    }

    public void setcommonId(String commonId) {
        this.commonId = commonId;
    }

    public String getTermDesc() {
        return termDesc;
    }

    public void setTermDesc(String termDesc) {
        this.termDesc = termDesc;
    }

}
