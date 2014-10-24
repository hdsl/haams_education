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
@Table(name = "comment_type", catalog = "haams_edu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentType.findAll", query = "SELECT c FROM CommentType c"),
    @NamedQuery(name = "CommentType.findByCommentTypeId", query = "SELECT c FROM CommentType c WHERE c.commentTypeId = :commentTypeId"),
    @NamedQuery(name = "CommentType.findByCommentName", query = "SELECT c FROM CommentType c WHERE c.commentName = :commentName")})
public class CommentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comment_type_id", nullable = false, length = 255)
    private String commentTypeId;
    @Size(max = 255)
    @Column(name = "comment_name", length = 255)
    private String commentName;

    public CommentType() {
    }

    public CommentType(String commentTypeId) {
        this.commentTypeId = commentTypeId;
    }

    public String getCommentTypeId() {
        return commentTypeId;
    }

    public void setCommentTypeId(String commentTypeId) {
        this.commentTypeId = commentTypeId;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentTypeId != null ? commentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentType)) {
            return false;
        }
        CommentType other = (CommentType) object;
        if ((this.commentTypeId == null && other.commentTypeId != null) || (this.commentTypeId != null && !this.commentTypeId.equals(other.commentTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "haams.ejb.entities.CommentType[ commentTypeId=" + commentTypeId + " ]";
    }
    
}
