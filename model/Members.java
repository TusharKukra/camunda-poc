package com.tk.adhaFileUpload.model;

public class Members {
	
	private int memberId;
	private String memberName;
	//private String wantLoan;
	
	/* Default Constructor */
	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* Parameterized Constructor */
	public Members(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		//this.wantLoan = wantLoan;
	}

	
	/* Getters & Setters */
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

//	public String isWantLoan() {
//		return wantLoan;
//	}
//
//	public void setWantLoan(String wantLoan) {
//		this.wantLoan = wantLoan;
//	}

	
	

}
