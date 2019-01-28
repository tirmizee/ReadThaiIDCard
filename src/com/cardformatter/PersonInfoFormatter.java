package com.cardformatter;

import com.carddata.PersonInfo;
import com.carddata.RawData;

public class PersonInfoFormatter extends ThaiCardFormatter<PersonInfo>{

	@Override
	public PersonInfo process(RawData rawdata) {
		if (rawdata == null) return null;
		PersonInfo personInfo = new PersonInfo();
		personInfo.setCid(rawdata.getCid());
		personInfo.setCardIssue(rawdata.getCardIssue());
		personInfo.setIssueDate(rawdata.getIssueDate());
		personInfo.setExpireDate(rawdata.getExpireDate());
		personInfo.setDateOfBirth(rawdata.getDateOfBirth());
		personInfo.setAge(formatAge(rawdata.getDateOfBirth()));
		personInfo.setGenderId(rawdata.getGender());
		personInfo.setGenderCode(formatGenderCode(rawdata.getGender()));
		personInfo.setGenderNameTH(formatGenderNameTH(rawdata.getGender()));
		personInfo.setGenderNameEN(formatGenderNameEN(rawdata.getGender()));
		personInfo.setTitlenameTH(formatTitlename(rawdata.getFullnameTH()));
		personInfo.setTitlenameEN(formatTitlename(rawdata.getFullnameEN()));
		personInfo.setFirstnameTH(formatFirstname(rawdata.getFullnameTH()));
		personInfo.setFirstnameEN(formatFirstname(rawdata.getFullnameEN()));
		personInfo.setLastnameTH(formatLastname(rawdata.getFullnameTH()));
		personInfo.setLastnameEN(formatLastname(rawdata.getFullnameEN()));
		personInfo.setMidnameTH(formatMidname(rawdata.getFullnameTH()));
		personInfo.setMidnameEN(formatMidname(rawdata.getFullnameEN()));
		personInfo.setFullnameTH(formatFullname(rawdata.getFullnameTH()));
		personInfo.setFullnameEN(formatFullname(rawdata.getFullnameEN()));
		personInfo.setAddress(formatAddress(rawdata.getAddress()));
		personInfo.setHouseNo(formatHouseNo(rawdata.getAddress()));
		personInfo.setVillageNo(formatVillageNo(rawdata.getAddress()));
		personInfo.setAlley(formatAlley(rawdata.getAddress()));
		personInfo.setRoad(formatRoad(rawdata.getAddress()));
		personInfo.setSubDistrict(formatSubDistrict(rawdata.getAddress()));
		personInfo.setDistrict(formatDistrict(rawdata.getAddress()));
		personInfo.setProvince(formatProvince(rawdata.getAddress()));
		return personInfo;
	}
	
}
