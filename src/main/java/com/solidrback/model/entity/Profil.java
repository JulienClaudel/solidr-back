package com.solidrback.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Profil {
    private int profilId;
    private String profilLabel;
    private String profilDescription;
    private Collection<ProfilFonction> profilFonctionsByProfilId;
    private Collection<UserProfil> userProfilsByProfilId;

    @Id
    @Column(name = "PROFIL_ID", nullable = false, precision = 0)
    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    @Basic
    @Column(name = "PROFIL_LABEL", nullable = false, length = 50)
    public String getProfilLabel() {
        return profilLabel;
    }

    public void setProfilLabel(String profilLabel) {
        this.profilLabel = profilLabel;
    }

    @Basic
    @Column(name = "PROFIL_DESCRIPTION", nullable = false, length = 100)
    public String getProfilDescription() {
        return profilDescription;
    }

    public void setProfilDescription(String profilDescription) {
        this.profilDescription = profilDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profil profil = (Profil) o;
        return Objects.equals(profilId, profil.profilId) &&
                Objects.equals(profilLabel, profil.profilLabel) &&
                Objects.equals(profilDescription, profil.profilDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profilId, profilLabel, profilDescription);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "profilByProfilId")
    public Collection<ProfilFonction> getProfilFonctionsByProfilId() {
        return profilFonctionsByProfilId;
    }

    public void setProfilFonctionsByProfilId(Collection<ProfilFonction> profilFonctionsByProfilId) {
        this.profilFonctionsByProfilId = profilFonctionsByProfilId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "profilByProfilId")
    public Collection<UserProfil> getUserProfilsByProfilId() {
        return userProfilsByProfilId;
    }

    public void setUserProfilsByProfilId(Collection<UserProfil> userProfilsByProfilId) {
        this.userProfilsByProfilId = userProfilsByProfilId;
    }
}
