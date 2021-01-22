package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Information {
    private int informationId;
    private String informationCode;
    private String informationType;
    private String informationDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INFORMATION_ID", nullable = false, precision = 0)
    public int getInformationId() {
        return informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    @Basic
    @Column(name = "INFORMATION_CODE", nullable = false, length = 50)
    public String getInformationCode() {
        return informationCode;
    }

    public void setInformationCode(String informationCode) {
        this.informationCode = informationCode;
    }

    @Basic
    @Column(name = "INFORMATION_TYPE", nullable = false, length = 50)
    public String getInformationType() {
        return informationType;
    }

    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    @Basic
    @Column(name = "INFORMATION_DESCRIPTION", nullable = false, length = 200)
    public String getInformationDescription() {
        return informationDescription;
    }

    public void setInformationDescription(String informationDescription) {
        this.informationDescription = informationDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return Objects.equals(informationId, that.informationId) &&
                Objects.equals(informationCode, that.informationCode) &&
                Objects.equals(informationType, that.informationType) &&
                Objects.equals(informationDescription, that.informationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationId, informationCode, informationType, informationDescription);
    }
}
