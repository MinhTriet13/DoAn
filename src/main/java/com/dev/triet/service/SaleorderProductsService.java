package com.dev.triet.service;

import com.dev.triet.entities.SaleorderProducts;
import com.dev.triet.dto.OrderSearchModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SaleorderProductsService extends BaseService<SaleorderProducts>{

	@Override
	protected Class<SaleorderProducts> clazz() {
		// TODO Auto-generated method stub
		return SaleorderProducts.class;
	}

	public PagerData<SaleorderProducts> search(OrderSearchModel searchModel) {
		String sql = "SELECT * FROM tbl_saleorder_products p WHERE 1=1";
		if (searchModel != null) {
			if (!StringUtils.isEmpty(searchModel.keyword)) {
				sql += " and (p.saleorder_id like '%" + searchModel.keyword + "%')";
			}
		}
		return executeByNativeSQL(sql, searchModel == null ? 0 : searchModel.getPage());
	}
}
