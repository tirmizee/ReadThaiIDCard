package com.cardformatter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.carddata.RawData;


/**
 * @author Pratya Yeekhaday
 *
 * @param <T> data info
 */
public abstract class ThaiCardFormatter<T> {

	public final DateTimeFormatter THAI_DATE_FORMAT= DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public abstract T process(RawData rawdata);
	
	protected int formatAge(String yyyyMMdd) {
        LocalDate dateOfBirth = LocalDate.parse(yyyyMMdd, THAI_DATE_FORMAT);
        LocalDate currentDate = LocalDate.now().plusYears(543);
		return Period.between(dateOfBirth, currentDate).getYears();
	}
	
	protected String formatAddress(String address) {
		return address.replaceAll("[#]+", " ");
	}
	
	protected String formatHouseNo(String address) {
		return  address.split("#")[0];
	}
	
	protected String formatVillageNo(String address) {
		return  address.split("#")[1];
	}
	
	protected String formatAlley(String address) {
		return  address.split("#")[3];
	}
	
	protected String formatRoad(String address) {
		return  address.split("#")[4];
	}
	
	protected String formatSubDistrict(String address) {
		return  address.split("#")[5];
	}
	
	protected String formatDistrict(String address) {
		return  address.split("#")[6];
	}
	
	protected String formatProvince(String address) {
		return  address.split("#")[7];
	}
	
	protected String formatGenderNameTH(String genderId) {
		return "1".equals(genderId) ? "ªÒÂ" : "Ë­Ô§";
	}
	
	protected String formatGenderNameEN(String genderId) {
		return "1".equals(genderId) ? "Male" : "Famale";
	}

	protected String formatGenderCode(String genderId) {
		return "1".equals(genderId) ? "M" : "F";
	}

	protected String formatTitlename(String fullname) {
		return fullname.split("#")[0];
	}
	
	protected String formatFirstname(String fullname) {
		return fullname.split("#")[1];
	}
	
	protected String formatMidname(String fullname) {
		return fullname.split("#")[2];
	}
	
	protected String formatLastname(String fullname) {
		return fullname.split("#")[3];
	}
	
	protected String formatFullname(String fullname) {
		String[] names = fullname.split("#"); 
		return names[0] + names[1] + " " + names[3];
	}
	
}
