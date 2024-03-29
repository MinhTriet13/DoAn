package com.dev.triet.service;

import com.dev.triet.entities.Subcribe;
import com.dev.triet.dto.SubcribeSearchModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Service
public class SubcribeService extends BaseService<Subcribe> {

	@Override
	protected Class<Subcribe> clazz() {
		// TODO Auto-generated method stub
		return Subcribe.class;
	}

	public PagerData<Subcribe> search(SubcribeSearchModel searchModel) {
		String sql = "SELECT * FROM tbl_subcribe p WHERE 1=1";

		if (searchModel != null) {
			if (!StringUtils.isEmpty(searchModel.keyword)) {
				sql += " and (p.email like '%" + searchModel.keyword + "%')";
			}
		}
		return executeByNativeSQL(sql, searchModel == null ? 0 : searchModel.getPage());
	}

	@Transactional
	public void delete(Subcribe subscribe) {
		delete(subscribe);
	}

}
