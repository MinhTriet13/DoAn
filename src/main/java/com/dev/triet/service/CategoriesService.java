package com.dev.triet.service;

import com.dev.triet.entities.Categories;
import org.springframework.stereotype.Service;


@Service
public class CategoriesService extends BaseService<Categories>{

	@Override
	protected Class<Categories> clazz() {
		// TODO Auto-generated method stub
		return Categories.class;
	}
	


}
