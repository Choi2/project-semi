package com.ktds.movie.user.vo;

import com.ktds.movie.common.web.pager.Pager;
import com.ktds.movie.common.web.pager.PagerFactory;

public class UserSearchVO {
	private Pager pager;

	private String userId;

	public Pager getPager() {
		if(pager == null){
			pager = PagerFactory.getPager(Pager.ORACLE, 50, 10);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
