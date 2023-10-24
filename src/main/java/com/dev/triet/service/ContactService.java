package com.dev.triet.service;

import com.dev.triet.entities.Contact;
import com.dev.triet.dto.ContactSearchModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ContactService extends BaseService<Contact> {

	@Override
	protected Class<Contact> clazz() {
		// TODO Auto-generated method stub
		return Contact.class;
	}

	public PagerData<Contact> search(ContactSearchModel searchModel){
		
		// khởi tạo câu lệnh
				String sql = "SELECT * FROM tbl_contact p WHERE 1=1";
				
				if (searchModel != null) {

					// tim kiem san pham theo seachText
					if (!StringUtils.isEmpty(searchModel.keyword)) {
						sql += " and (p.name like '%" + searchModel.keyword + "%'" + " or p.email like '%"
								+ searchModel.keyword + "%'" + " or p.massage like '%" + searchModel.keyword + "%')";
					}
				}
		return executeByNativeSQL(sql, searchModel == null ? 0 : searchModel.getPage());
	}

}
