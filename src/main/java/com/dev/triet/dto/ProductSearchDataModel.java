package com.dev.triet.dto;

import com.dev.triet.entities.BaseEntity;
import com.dev.triet.entities.Categories;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSearchDataModel extends BaseEntity {

    private String title;
    private BigDecimal price;

    private BigDecimal price_sale;

    private String shortDes;

    private String details;

    private String avatar;

    private String seo;

    private Categories categories;


    private Long userId;

    private String userOwnTheProduct;

    private String bank;

    private String paymentAccountNumber;
}
