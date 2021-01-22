package com.solidrback.solidrback.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "API_CORP", schema = "dbo", catalog = "solidr")
public class ApiCorp {
    private int apiId;
    private String apiLabel;
    private String apiLink;
    // private Object apiIcon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API_ID", nullable = false, precision = 0)
    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    @Basic
    @Column(name = "API_LABEL", nullable = false, length = 50)
    public String getApiLabel() {
        return apiLabel;
    }

    public void setApiLabel(String apiLabel) {
        this.apiLabel = apiLabel;
    }

    @Basic
    @Column(name = "API_LINK", nullable = false, length = 100)
    public String getApiLink() {
        return apiLink;
    }

    public void setApiLink(String apiLink) {
        this.apiLink = apiLink;
    }

/*    @Basic
    @Column(name = "API_ICON", nullable = true)
    public Object getApiIcon() {
        return apiIcon;
    }

    public void setApiIcon(Object apiIcon) {
        this.apiIcon = apiIcon;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiCorp apiCorp = (ApiCorp) o;
        return Objects.equals(apiId, apiCorp.apiId) &&
                Objects.equals(apiLabel, apiCorp.apiLabel) &&
                Objects.equals(apiLink, apiCorp.apiLink)
              // && Objects.equals(apiIcon, apiCorp.apiIcon)
        ; }

    @Override
    public int hashCode() {
       // return Objects.hash(apiId, apiLabel, apiLink, apiIcon);
        return Objects.hash(apiId, apiLabel, apiLink);
    }
}
