package com.solidrback.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProfilFonctionPK implements Serializable {
    private int profilId;
    private int fonctionId;

    @Column(name = "PROFIL_ID", nullable = false, precision = 0)
    @Id
    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    @Column(name = "FONCTION_ID", nullable = false, precision = 0)
    @Id
    public int getFonctionId() {
        return fonctionId;
    }

    public void setFonctionId(int fonctionId) {
        this.fonctionId = fonctionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfilFonctionPK that = (ProfilFonctionPK) o;
        return Objects.equals(profilId, that.profilId) &&
                Objects.equals(fonctionId, that.fonctionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profilId, fonctionId);
    }
}
