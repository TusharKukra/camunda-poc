package com.tk.adhaFileUpload.model;

import java.util.Iterator;
import java.util.List;

public class MemberList implements Iterable<Members>{
	
	public List<Members> memberList;

	
	public List<Members> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Members> members) {
		this.memberList = members;
	}

	
	@Override
	public String toString() {
		return "MemberList [memberList=" + memberList + "]";
	}

	@Override
	public Iterator<Members> iterator() {
		// TODO Auto-generated method stub
		return memberList.iterator();
	}
	
	
	
}
