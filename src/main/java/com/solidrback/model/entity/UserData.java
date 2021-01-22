package com.solidrback.model.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_DATA", schema = "dbo", catalog = "solidr")
public class UserData {
    private String userEmail;
    private int statusId;
    private String userPassword;
    private String userUsername;
    private String userFirstname;
    private String userLastname;
    private Date userBirthdate;
    private Date userSignin;
    private String userDescription;
    private String userLinkContact;
    private Double userGaz;
    private boolean isEnabled;
    private boolean using2FA;
    private String userSecret;
    private String confirmationToken;
    private Collection<Comment> commentsByUserEmail;
    private Collection<Strategy> strategiesByUserEmail;
    private Collection<Trade> tradesByUserEmail;
    private Status statusByStatusId;
    private Collection<UserProfil> userProfilsByUserEmail;
    private Collection<UserSubscribeStrat> userSubscribeStratsByUserEmail;
    private Collection<Wallet> walletsByUserEmail;
    private Set<Profil> roles = new HashSet<>();

    public UserData() {
    }

    public UserData(String userEmail, Integer statusId, String userUsername, String userPassword, Date userSignin) {
        this.setUserEmail(userEmail);
        this.setStatusId(statusId);
        this.setUserUsername(userUsername);
        this.setUserPassword(userPassword);
        this.setUserSignin(userSignin);
    }

    public UserData(String userEmail, int statusId, String userUsername, String userPassword, String userFirstname, String userLastname, Date userBirthdate, Date userSignin, String userDescription, String userLinkContact, Double userGaz, Set<Profil> roles) {
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
        this.roles = roles;
    }

    @Id
    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "USER_PASSWORD", nullable = false, length = 150)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "USER_USERNAME", nullable = false, length = 30)
    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @Basic
    @Column(name = "USER_FIRSTNAME", nullable = true, length = 30)
    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    @Basic
    @Column(name = "USER_LASTNAME", nullable = true, length = 30)
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Basic
    @Column(name = "USER_BIRTHDATE")
    public Date getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(Date userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    @Basic
    @Column(name = "USER_SIGNIN", nullable = false)
    public Date getUserSignin() {
        return userSignin;
    }

    public void setUserSignin(Date userSignin) {
        this.userSignin = userSignin;
    }

    @Basic
    @Column(name = "USER_DESCRIPTION", nullable = true, length = 200)
    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    @Basic
    @Column(name = "USER_LINK_CONTACT", nullable = true, length = 100)
    public String getUserLinkContact() {
        return userLinkContact;
    }

    public void setUserLinkContact(String userLinkContact) {
        this.userLinkContact = userLinkContact;
    }

    @Basic
    @Column(name = "USER_GAZ", nullable = true, precision = 0)
    public Double getUserGaz() {
        return userGaz;
    }

    public void setUserGaz(Double userGaz) {
        this.userGaz = userGaz;
    }

    @Basic
    @Column(name = "USER_ENABLED")
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Basic
    @Column(name = "USER_USING2FA")
    public boolean isUsing2FA() {
        return using2FA;
    }

    public void setUsing2FA(boolean using2FA) {
        this.using2FA = using2FA;
    }

    @Basic
    @Column(name = "USER_SECRET", length = 30)
    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    @Basic
    @Column(name = "USER_TOKEN", length = 60)
    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (statusId != userData.statusId) return false;
        if (userEmail != null ? !userEmail.equals(userData.userEmail) : userData.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(userData.userPassword) : userData.userPassword != null)
            return false;
        if (userUsername != null ? !userUsername.equals(userData.userUsername) : userData.userUsername != null)
            return false;
        if (userFirstname != null ? !userFirstname.equals(userData.userFirstname) : userData.userFirstname != null)
            return false;
        if (userLastname != null ? !userLastname.equals(userData.userLastname) : userData.userLastname != null)
            return false;
        if (userBirthdate != null ? !userBirthdate.equals(userData.userBirthdate) : userData.userBirthdate != null) return false;
        if (userSignin != null ? !userSignin.equals(userData.userSignin) : userData.userSignin != null) return false;
        if (userDescription != null ? !userDescription.equals(userData.userDescription) : userData.userDescription != null)
            return false;
        if (userLinkContact != null ? !userLinkContact.equals(userData.userLinkContact) : userData.userLinkContact != null)
            return false;
        if (userGaz != null ? !userGaz.equals(userData.userGaz) : userData.userGaz != null) return false;
        if (confirmationToken != null ? !confirmationToken.equals(userData.confirmationToken) : userData.confirmationToken != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userEmail != null ? userEmail.hashCode() : 0;
        result = 31 * result + statusId;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userUsername != null ? userUsername.hashCode() : 0);
        result = 31 * result + (userFirstname != null ? userFirstname.hashCode() : 0);
        result = 31 * result + (userLastname != null ? userLastname.hashCode() : 0);
        result = 31 * result + (userBirthdate != null ? userBirthdate.hashCode() : 0);
        result = 31 * result + (userSignin != null ? userSignin.hashCode() : 0);
        result = 31 * result + (userDescription != null ? userDescription.hashCode() : 0);
        result = 31 * result + (userLinkContact != null ? userLinkContact.hashCode() : 0);
        result = 31 * result + (userGaz != null ? userGaz.hashCode() : 0);
        result = 31 * result + (confirmationToken != null ? confirmationToken.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userDataByUserEmail")
    public Collection<Comment> getCommentsByUserEmail() {
        return commentsByUserEmail;
    }

    public void setCommentsByUserEmail(Collection<Comment> commentsByUserEmail) {
        this.commentsByUserEmail = commentsByUserEmail;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userDataByUserEmail")
    public Collection<Strategy> getStrategiesByUserEmail() {
        return strategiesByUserEmail;
    }

    public void setStrategiesByUserEmail(Collection<Strategy> strategiesByUserEmail) {
        this.strategiesByUserEmail = strategiesByUserEmail;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userDataByUserEmail")
    public Collection<Trade> getTradesByUserEmail() {
        return tradesByUserEmail;
    }

    public void setTradesByUserEmail(Collection<Trade> tradesByUserEmail) {
        this.tradesByUserEmail = tradesByUserEmail;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false, insertable = false, updatable = false)
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userDataByUserEmail")
    public Collection<UserProfil> getUserProfilsByUserEmail() {
        return userProfilsByUserEmail;
    }

    public void setUserProfilsByUserEmail(Collection<UserProfil> userProfilsByUserEmail) {
        this.userProfilsByUserEmail = userProfilsByUserEmail;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userDataByUserEmail")
    public Collection<UserSubscribeStrat> getUserSubscribeStratsByUserEmail() {
        return userSubscribeStratsByUserEmail;
    }

    public void setUserSubscribeStratsByUserEmail(Collection<UserSubscribeStrat> userSubscribeStratsByUserEmail) {
        this.userSubscribeStratsByUserEmail = userSubscribeStratsByUserEmail;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userDataByUserEmail")
    public Collection<Wallet> getWalletsByUserEmail() {
        return walletsByUserEmail;
    }

    public void setWalletsByUserEmail(Collection<Wallet> walletsByUserEmail) {
        this.walletsByUserEmail = walletsByUserEmail;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "USER_PROFIL",
            joinColumns = @JoinColumn(name = "USER_EMAIL"),
            inverseJoinColumns = @JoinColumn(name = "PROFIL_ID"))
    public Set<Profil> getRoles() {
        return roles;
    }

    public void setRoles(Set<Profil> roles) {
        this.roles = roles;
    }
}

