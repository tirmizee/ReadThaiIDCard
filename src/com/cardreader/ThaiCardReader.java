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
		channel.transmit(commandSelect());
		
		// raw data from card
		String rawCid = readDataAsString(channel.transmit(commandCid()));
		String rawFullnameTH = readDataAsString(channel.transmit(commandFullnameTH()));
		String rawFullnameEN = readDataAsString(channel.transmit(commandFullnameEN()));
		String rawGender = readDataAsString(channel.transmit(commandGender()));
		String rawAddress = readDataAsString(channel.transmit(commandAddress()));
		String rawDateOfBirth = readDataAsString(channel.transmit(commandDateOfBirth()));
		String rawCardIssue = readDataAsString(channel.transmit(commandCardIssuer()));
		String rawIssueDate = readDataAsString(channel.transmit(commandIsseDate()));
		String rawExpireDate = readDataAsString(channel.transmit(commandExpireDate()));
		
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
