package com.carddata;

public class RawData {

	private String cid;
	private String fullnameTH;
	private String fullnameEN;
	private String gender;
	private String address;
	private String dateOfBirth;
	private String cardIssue;
	private String issueDate;
	private String expireDate;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFullnameTH() {
		return fullnameTH;
	}
	public void setFullnameTH(String fullnameTH) {
		this.fullnameTH = fullnameTH;
	}
	public String getFullnameEN() {
		return fullnameEN;
	}
	public void setFullnameEN(String fullnameEN) {
		this.fullnameEN = fullnameEN;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCardIssue() {
		return cardIssue;
	}
	public void setCardIssue(String cardIssue) {
		this.cardIssue = cardIssue;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String toString() {
		return "RawData [\n"
				+ "\tcid=" + cid + ",\n\tfullnameTH=" + fullnameTH + ",\n\tfullnameEN=" + fullnameEN + ",\n\tgender="
				+ gender + ",\n\taddress=" + address + ",\n\tdateOfBirth=" + dateOfBirth + ",\n\tcardIssue=" + cardIssue
				+ ",\n\tissueDate=" + issueDate + ",\n\texpireDate=" + expireDate + "\n]";
	}
	
}
