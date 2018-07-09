package com.ggstudy.jpa.model;

import javax.persistence.*;

/**
 * Created by bjy on 16/7/12.
 */
@Entity
@Table(name="CPT_PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "seq_cpt_products",name="")
    private long id;

    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="PRODUCT_NO")
    private String productNo;
    @Column(name="PRODUCT_STATE")
    private String productState;
    @Column(name="REMARK")
    private String remark;
    @Column(name="PRODUCT_TYPE")
    private String productType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
