package com.solidrback.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Fonction {
    private int fonctionId;
    private String fonctionLabel;
    private String fonctionDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FONCTION_ID", nullable = false, precision = 0)
    public int getFonctionId() {
        return fonctionId;
    }

    public void setFonctionId(int fonctionId) {
        this.fonctionId = fonctionId;
    }

    @Basic
    @Column(name = "FONCTION_LABEL", nullable = false, length = 50)
    public String getFonctionLabel() {
        return fonctionLabel;
    }

    public void setFonctionLabel(String fonctionLabel) {
        this.fonctionLabel = fonctionLabel;
    }

    @Basic
    @Column(name = "FONCTION_DESCRIPTION", nullable = false, length = 100)
    public String getFonctionDescription() {
        return fonctionDescription;
    }

    public void setFonctionDescription(String fonctionDescription) {
        this.fonctionDescription = fonctionDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fonction fonction = (Fonction) o;
        return Objects.equals(fonctionId, fonction.fonctionId) &&
                Objects.equals(fonctionLabel, fonction.fonctionLabel) &&
                Objects.equals(fonctionDescription, fonction.fonctionDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fonctionId, fonctionLabel, fonctionDescription);
    }

}
