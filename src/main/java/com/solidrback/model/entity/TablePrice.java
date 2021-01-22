package com.solidrback.solidrback.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "TABLEPRICE", schema = "dbo", catalog = "solidr")
public class TablePrice {
    private Long tablePriceId;
    private String tablePricePeriod;
    private String tablePriceAmount;
    private String tablePriceText1;
    private String tablePriceText2;
    private String tablePriceText3;
    private String tablePriceText4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TABLEPRICE_ID", nullable = false)
    public Long getTablePriceId() {
        return tablePriceId;
    }

    public void setTablePriceId(Long tablePriceId) {
        this.tablePriceId = tablePriceId;
    }
    @Basic
    @Column(name = "TABLEPRICE_PERIOD", nullable = false)
    public String getTablePricePeriod() {
        return tablePricePeriod;
    }

    public void setTablePricePeriod(String tablePeriod) {
        this.tablePricePeriod = tablePeriod;
    }

    @Basic
    @Column(name="TABLEPRICE_AMOUNT", nullable = false)
    public String getTablePriceAmount() {
        return tablePriceAmount;
    }

    public void setTablePriceAmount(String tablePriceAmount) {
        this.tablePriceAmount = tablePriceAmount;
    }
    @Basic
    @Column(name = "TABLEPRICE_TEXT1")
    public String getTablePriceText1() {
        return tablePriceText1;
    }

    public void setTablePriceText1(String tablePriceText1) {
        this.tablePriceText1 = tablePriceText1;
    }
    @Basic
    @Column(name = "TABLEPRICE_TEXT2")
    public String getTablePriceText2() {
        return tablePriceText2;
    }

    public void setTablePriceText2(String tablePriceText2) {
        this.tablePriceText2 = tablePriceText2;
    }

    @Basic
    @Column(name = "TABLEPRICE_TEXT3")
    public String getTablePriceText3() {
        return tablePriceText3;
    }

    public void setTablePriceText3(String tablePriceText3) {
        this.tablePriceText3 = tablePriceText3;
    }
    @Basic
    @Column(name = "TABLEPRICE_TEXT4")
    public String getTablePriceText4() {
        return tablePriceText4;
    }

    public void setTablePriceText4(String tablePriceText4) {
        this.tablePriceText4 = tablePriceText4;
    }

    @Override
    public String toString() {
        return "TablePrice{" +
                "tablePriceId=" + tablePriceId +
                ", tablePricePeriod='" + tablePricePeriod + '\'' +
                ", tablePriceAmount='" + tablePriceAmount + '\'' +
                ", tablePriceText1='" + tablePriceText1 + '\'' +
                ", tablePriceText2='" + tablePriceText2 + '\'' +
                ", tablePriceText4='" + tablePriceText4 + '\'' +
                ", tablePriceText3='" + tablePriceText3 + '\'' +
                '}';
    }
}
