package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_PROFIL", schema = "dbo", catalog = "solidr")
@IdClass(UserProfilPK.class)
public class UserProfil {
    private String userEmail;
    private int profilId;
    private UserData userDataByUserEmail;
    private Profil profilByProfilId;

    @Id
    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Id
    @Column(name = "PROFIL_ID", nullable = false, precision = 0)
    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfil that = (UserProfil) o;
        return Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(profilId, that.profilId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, profilId);
    }

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "USER_EMAIL", nullable = false, insertable = false, updatable = false)
    public UserData getUserDataByUserEmail() {
        return userDataByUserEmail;
    }

    public void setUserDataByUserEmail(UserData userDataByUserEmail) {
        this.userDataByUserEmail = userDataByUserEmail;
    }

    @ManyToOne
    @JoinColumn(name = "PROFIL_ID", referencedColumnName = "PROFIL_ID", nullable = false, insertable = false, updatable = false)
    public Profil getProfilByProfilId() {
        return profilByProfilId;
    }

    public void setProfilByProfilId(Profil profilByProfilId) {
        this.profilByProfilId = profilByProfilId;
    }
}
