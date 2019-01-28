package com.carddata;

public class PersonInfo {

	private String cid;
	private String titlenameTH;
	private String titlenameEN;
	private String firstnameTH;
	private String firstnameEN;
	private String lastnameTH;
	private String lastnameEN;
	private String fullnameTH;
	private String fullnameEN;
	private String midnameTH;
	private String midnameEN;
	private Integer age;
	private String genderId;
	private String genderCode;
	private String genderNameTH;
	private String genderNameEN;
	private String dateOfBirth;
	private String cardIssue;
	private String IssueDate;
	private String expireDate;
	private String address;
	private String houseNo;
	private String villageNo;
	private String alley;
	private String road;
	private String subDistrict;
	private String district;
	private String province;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTitlenameTH() {
		return titlenameTH;
	}
	public void setTitlenameTH(String titlenameTH) {
		this.titlenameTH = titlenameTH;
	}
	public String getTitlenameEN() {
		return titlenameEN;
	}
	public void setTitlenameEN(String titlenameEN) {
		this.titlenameEN = titlenameEN;
	}
	public String getFirstnameTH() {
		return firstnameTH;
	}
	public void setFirstnameTH(String firstnameTH) {
		this.firstnameTH = firstnameTH;
	}
	public String getFirstnameEN() {
		return firstnameEN;
	}
	public void setFirstnameEN(String firstnameEN) {
		this.firstnameEN = firstnameEN;
	}
	public String getLastnameTH() {
		return lastnameTH;
	}
	public void setLastnameTH(String lastnameTH) {
		this.lastnameTH = lastnameTH;
	}
	public String getLastnameEN() {
		return lastnameEN;
	}
	public void setLastnameEN(String lastnameEN) {
		this.lastnameEN = lastnameEN;
	}
	public String getMidnameTH() {
		return midnameTH;
	}
	public void setMidnameTH(String midnameTH) {
		this.midnameTH = midnameTH;
	}
	public String getMidnameEN() {
		return midnameEN;
	}
	public void setMidnameEN(String midnameEN) {
		this.midnameEN = midnameEN;
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
	public String getGenderId() {
		return genderId;
	}
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	public String getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}
	public String getGenderNameTH() {
		return genderNameTH;
	}
	public void setGenderNameTH(String genderNameTH) {
		this.genderNameTH = genderNameTH;
	}
	public String getGenderNameEN() {
		return genderNameEN;
	}
	public void setGenderNameEN(String genderNameEN) {
		this.genderNameEN = genderNameEN;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
		return IssueDate;
	}
	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getVillageNo() {
		return villageNo;
	}
	public void setVillageNo(String villageNo) {
		this.villageNo = villageNo;
	}
	public String getAlley() {
		return alley;
	}
	public void setAlley(String alley) {
		this.alley = alley;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getSubDistrict() {
		return subDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "PersonInfo [\n\tcid=" + cid + ",\n\ttitlenameTH=" + titlenameTH + ",\n\ttitlenameEN=" + titlenameEN
				+ ",\n\tfirstnameTH=" + firstnameTH + ",\n\tfirstnameEN=" + firstnameEN + ",\n\tlastnameTH=" + lastnameTH
				+ ",\n\tlastnameEN=" + lastnameEN + ",\n\tfullnameTH=" + fullnameTH + ",\n\tfullnameEN=" + fullnameEN
				+ ",\n\tmidnameTH=" + midnameTH + ",\n\tmidnameEN=" + midnameEN + ",\n\tage=" + age + ",\n\tgenderId=" + genderId
				+ ",\n\tgenderCode=" + genderCode + ",\n\tgenderNameTH=" + genderNameTH + ",\n\tgenderNameEN=" + genderNameEN
				+ ",\n\tdateOfBirth=" + dateOfBirth + ",\n\tcardIssue=" + cardIssue + ",\n\tIssueDate=" + IssueDate
				+ ",\n\texpireDate=" + expireDate + ",\n\taddress=" + address + ",\n\thouseNo=" + houseNo + ",\n\tvillageNo="
				+ villageNo + ",\n\talley=" + alley + ",\n\troad=" + road + ",\n\tsubDistrict=" + subDistrict + ",\n\tdistrict="
				+ district + ",\n\tprovince=" + province + "\n]";
	}
	
}
