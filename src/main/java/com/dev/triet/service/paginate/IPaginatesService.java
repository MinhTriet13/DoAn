package com.dev.triet.service.paginate;

import org.springframework.stereotype.Service;

import com.dev.triet.service.PagerData;

@Service
public interface IPaginatesService {
	public PagerData GetInfoPaginates(int totalItems, int limit, int currentPage);

}
