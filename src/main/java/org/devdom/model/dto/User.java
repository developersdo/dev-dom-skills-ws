package org.devdom.model.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos V�squez Polanco
 */
@Entity
@Table(name = "dev_dom_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex"),
    @NamedQuery(name = "Users.count", query = "SELECT count(u) FROM User u")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "pic_small")
    private String picSmall;
    @Column(name = "pic_big")
    private String picBig;
    @Column(name = "pic")
    private String pic;
    @Column(name = "is_page_liked")
    private Short isPageLiked;
    @Column(name = "sex")
    private String sex;
    @Column(name = "username")
    private String username;
    @Column(name = "pic_cover")
    private String picCover;
    @Column(name = "offset_y")
    private String offsetY;
    @Column(name = "uid")
    private Long uid;
    
    public User(){
    }
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param picSmall
     * @param picBig
     * @param pic
     * @param sex
     * @param username
     * @param picCover
     * @param offsetY
     * @param uid
     */

    public User(String firstName, String lastName, String picSmall, String picBig, String pic,
            String sex, String username, String picCover, String offsetY, Long uid) {
        
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPicSmall(picSmall);
        this.setPicBig(picBig);
        this.setPic(pic);
        this.setSex(sex);
        this.setUsername(username);
        this.setPicCover(picCover);
        this.setOffsetY(offsetY);
        this.setUid(uid);

    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicBig() {
        return picBig;
    }

    public void setPicBig(String picBig) {
        this.picBig = picBig;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Short getIsPageLiked() {
        return isPageLiked;
    }

    public void setIsPageLiked(Short isPageLiked) {
        this.isPageLiked = isPageLiked;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicCover() {
        return picCover;
    }

    public void setPicCover(String picCover) {
        this.picCover = picCover;
    }

    public String getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(String offsetY) {
        this.offsetY = offsetY;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devdom.model.User[ userId=" + userId + " ]";
    }
}
