package cn.ximcloud.chatonline.chatonline.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 16:51
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/
@Entity
public class Administrator {

    @Id
    @GeneratedValue
    private Integer ID;
    private String adminName;
    private String adminEmail;
    private String password;
    private Long adminLastLoginTime;
    private String adminLastLoginIP;
    private Integer adminAccountLevel;
    private Integer adminAccountAvailableStatus;


    @Override
    public String toString() {
        return "Administrator{" +
                "ID=" + ID +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", password='" + password + '\'' +
                ", adminLastLoginTime=" + adminLastLoginTime +
                ", adminLastLoginIP='" + adminLastLoginIP + '\'' +
                ", adminAccountLevel=" + adminAccountLevel +
                ", adminAccountAvailableStatus=" + adminAccountAvailableStatus +
                '}';
    }

    public Administrator() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAdminLastLoginTime() {
        return adminLastLoginTime;
    }

    public void setAdminLastLoginTime(Long adminLastLoginTime) {
        this.adminLastLoginTime = adminLastLoginTime;
    }

    public String getAdminLastLoginIP() {
        return adminLastLoginIP;
    }

    public void setAdminLastLoginIP(String adminLastLoginIP) {
        this.adminLastLoginIP = adminLastLoginIP;
    }

    public Integer getAdminAccountLevel() {
        return adminAccountLevel;
    }

    public void setAdminAccountLevel(Integer adminAccountLevel) {
        this.adminAccountLevel = adminAccountLevel;
    }

    public Integer getAdminAccountAvailableStatus() {
        return adminAccountAvailableStatus;
    }

    public void setAdminAccountAvailableStatus(Integer adminAccountAvailableStatus) {
        this.adminAccountAvailableStatus = adminAccountAvailableStatus;
    }
}
