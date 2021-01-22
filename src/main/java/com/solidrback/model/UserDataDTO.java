package com.solidrback.solidrback.model;

import java.util.Date;
import java.util.Objects;

public class UserDataDTO {

    private String userEmail;
    private int statusId;
    private String userUsername;
    private String userPassword;
    private String userFirstname;
    private String userLastname;
    private Date userBirthdate;
    private Date userSignin;
    private String userDescription;
    private String userLinkContact;
    private Double userGaz;
    private boolean isEnabled;

    public UserDataDTO(String userFirstname, String userLastname, String userDescription, String userLinkContact) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userDescription = userDescription;
        this.userLinkContact = userLinkContact;
    }

    public UserDataDTO(String userEmail, int statusId, String userUsername, String userPassword, String userFirstname, String userLastname, Date userBirthdate, Date userSignin, String userDescription, String userLinkContact, Double userGaz, boolean isEnabled) {
        this.userEmail = userEmail;
        this.statusId = statusId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userBirthdate = userBirthdate;
        this.userSignin = userSignin;
        this.userDescription = userDescription;
        this.userLinkContact = userLinkContact;
        this.userGaz = userGaz;
        this.isEnabled = isEnabled;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public Date getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(Date userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserLinkContact() {
        return userLinkContact;
    }

    public void setUserLinkContact(String userLinkContact) {
        this.userLinkContact = userLinkContact;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserSignin() {
        return userSignin;
    }

    public void setUserSignin(Date userSignin) {
        this.userSignin = userSignin;
    }

    public Double getUserGaz() {
        return userGaz;
    }

    public void setUserGaz(Double userGaz) {
        this.userGaz = userGaz;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataDTO that = (UserDataDTO) o;
        return statusId == that.statusId &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userUsername, that.userUsername) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userFirstname, that.userFirstname) &&
                Objects.equals(userLastname, that.userLastname) &&
                Objects.equals(userSignin, that.userSignin) &&
                Objects.equals(userDescription, that.userDescription) &&
                Objects.equals(userLinkContact, that.userLinkContact) &&
                Objects.equals(userGaz, that.userGaz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, statusId, userUsername, userPassword, userFirstname, userLastname, userSignin, userDescription, userLinkContact, userGaz);
    }

    @Override
    public String toString() {
        return "UserDataDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", statusId='" + statusId + '\'' +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userSignIn='" + userSignin + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", userLinkContact='" + userLinkContact + '\'' +
                ", userGaz='" + userGaz + '\'' +
                '}';
    }
}
