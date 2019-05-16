package com.welfare.service;

import java.util.List;

import com.welfare.model.MemberCard;

public interface MemberService {
	
	public List<MemberCard> getMemberCardListById(int idMember);

}
