package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROFIL_FONCTION", schema = "dbo", catalog = "solidr")
@IdClass(ProfilFonctionPK.class)
public class ProfilFonction {
    private int profilId;
    private int fonctionId;
    private Profil profilByProfilId;
    private Fonction fonctionByFonctionId;

    @Id
    @Column(name = "PROFIL_ID", nullable = false, precision = 0)
    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    @Id
    @Column(name = "FONCTION_ID", nullable = false, precision = 0)
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
        ProfilFonction that = (ProfilFonction) o;
        return Objects.equals(profilId, that.profilId) &&
                Objects.equals(fonctionId, that.fonctionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profilId, fonctionId);
    }

    @ManyToOne
    @JoinColumn(name = "PROFIL_ID", referencedColumnName = "PROFIL_ID", nullable = false, insertable = false, updatable = false)
    public Profil getProfilByProfilId() {
        return profilByProfilId;
    }

    public void setProfilByProfilId(Profil profilByProfilId) {
        this.profilByProfilId = profilByProfilId;
    }

    @ManyToOne
    @JoinColumn(name = "FONCTION_ID", referencedColumnName = "FONCTION_ID", nullable = false, insertable = false, updatable = false)
    public Fonction getFonctionByFonctionId() {
        return fonctionByFonctionId;
    }

    public void setFonctionByFonctionId(Fonction fonctionByFonctionId) {
        this.fonctionByFonctionId = fonctionByFonctionId;
    }
}
