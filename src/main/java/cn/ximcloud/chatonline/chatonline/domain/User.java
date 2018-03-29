package cn.ximcloud.chatonline.chatonline.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 14:24
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/

@Entity
public class User {

    @Id
    @GeneratedValue
    //用户的ID，自增
    private Integer ID;
    //用户的UUID
    private String UUID;
    //用户名
    private String userName;
    //用户密码
    private String userPassword;

    private String userEmail;

    private Long userRegistedTime;


    private String userRegistedIP;

    private Long userLastLoginTime;

    private String userLoginIPList;

    private boolean userAccountAvailableStatus;

    private String userQuestion;

    private String userAnswer;

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", UUID=" + UUID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRegistedTime=" + userRegistedTime +
                ", userRegistedIP='" + userRegistedIP + '\'' +
                ", userLastLoginTime=" + userLastLoginTime +
                ", userLoginIPList='" + userLoginIPList + '\'' +
                ", userAccountAvailableStatus=" + userAccountAvailableStatus +
                '}';
    }

    public User() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserRegistedTime() {
        return userRegistedTime;
    }

    public void setUserRegistedTime(Long userRegistedTime) {
        this.userRegistedTime = userRegistedTime;
    }

    public String getUserRegistedIP() {
        return userRegistedIP;
    }

    public void setUserRegistedIP(String userRegistedIP) {
        this.userRegistedIP = userRegistedIP;
    }

    public Long getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Long userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public String getUserLoginIPList() {
        return userLoginIPList;
    }

    public void setUserLoginIPList(String userLoginIPList) {
        this.userLoginIPList = userLoginIPList;
    }

    public boolean isUserAccountAvailableStatus() {
        return userAccountAvailableStatus;
    }

    public void setUserAccountAvailableStatus(boolean userAccountAvailableStatus) {
        this.userAccountAvailableStatus = userAccountAvailableStatus;
    }
}