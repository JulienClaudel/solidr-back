package com.solidrback.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserProfilPK implements Serializable {
    private String userEmail;
    private int profilId;

    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    @Id
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "PROFIL_ID", nullable = false, precision = 0)
    @Id
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
        UserProfilPK that = (UserProfilPK) o;
        return Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(profilId, that.profilId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, profilId);
    }
}
