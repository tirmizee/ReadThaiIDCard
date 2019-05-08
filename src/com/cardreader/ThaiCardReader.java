package com.cardreader;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;

import com.carddata.PersonInfo;

/**
 * @author Pratya Yeekhaday
 *
 */
public class ThaiCardReader extends AbstractThaiCardReader<PersonInfo>{

	@Override
	public PersonInfo readCard() throws Exception {
		
		Card card = connect("*");
		CardChannel channel = card.getBasicChannel();
		channel.transmit(command(APDU_SELECT));
		
		// raw data from card
		String rawCid = readDataAsString(channel.transmit(command(APDU_CID)));
		String rawFullnameTH = readDataAsString(channel.transmit(command(APDU_FULLNAME_TH)));
		String rawFullnameEN = readDataAsString(channel.transmit(command(APDU_FULLNAME_EN)));
		String rawGender = readDataAsString(channel.transmit(command(APDU_GENDER)));
		String rawAddress = readDataAsString(channel.transmit(command(APDU_ADDRESS)));
		String rawDateOfBirth = readDataAsString(channel.transmit(command(APDU_DATE_OF_BIRTH)));
		String rawCardIssue = readDataAsString(channel.transmit(command(APDU_CARD_ISSUER)));
		String rawIssueDate = readDataAsString(channel.transmit(command(APDU_ISSUE_DATE)));
		String rawExpireDate = readDataAsString(channel.transmit(command(APDU_EXPIRE_DATE)));
		
		// person info
		PersonInfo personInfo = new PersonInfo();
		personInfo.setCid(rawCid);
		personInfo.setCardIssue(rawCardIssue);
		personInfo.setIssueDate(rawIssueDate);
		personInfo.setExpireDate(rawExpireDate);
		personInfo.setDateOfBirth(rawDateOfBirth);
		personInfo.setAge(formatAge(rawDateOfBirth));
		personInfo.setGenderId(rawGender);
		personInfo.setGenderCode(formatGenderCode(rawGender));
		personInfo.setGenderNameTH(formatGenderNameTH(rawGender));
		personInfo.setGenderNameEN(formatGenderNameEN(rawGender));
		personInfo.setTitlenameTH(formatTitlename(rawFullnameTH));
		personInfo.setTitlenameEN(formatTitlename(rawFullnameEN));
		personInfo.setFirstnameTH(formatFirstname(rawFullnameTH));
		personInfo.setFirstnameEN(formatFirstname(rawFullnameEN));
		personInfo.setLastnameTH(formatLastname(rawFullnameTH));
		personInfo.setLastnameEN(formatLastname(rawFullnameEN));
		personInfo.setMidnameTH(formatMidname(rawFullnameTH));
		personInfo.setMidnameEN(formatMidname(rawFullnameEN));
		personInfo.setFullnameTH(formatFullname(rawFullnameTH));
		personInfo.setFullnameEN(formatFullname(rawFullnameEN));
		personInfo.setAddress(formatAddress(rawAddress));
		personInfo.setHouseNo(formatHouseNo(rawAddress));
		personInfo.setVillageNo(formatVillageNo(rawAddress));
		personInfo.setAlley(formatAlley(rawAddress));
		personInfo.setRoad(formatRoad(rawAddress));
		personInfo.setSubDistrict(formatSubDistrict(rawAddress));
		personInfo.setDistrict(formatDistrict(rawAddress));
		personInfo.setProvince(formatProvince(rawAddress));
		card.disconnect(false);
		
		return personInfo;
	}

}
