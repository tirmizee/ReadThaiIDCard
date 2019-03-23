package com.cardreader;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

import com.cardcommand.AbstractThaiCommandAPDU;

public abstract class AbstractThaiCardReader<T> extends AbstractThaiCommandAPDU implements CardReader<T>{

	public static final TerminalFactory factory = TerminalFactory.getDefault();
	
	public static final DateTimeFormatter THAI_DATE_FORMAT= DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public Card connect(String protocol) throws CardException {
		List<CardTerminal> terminals = factory.terminals().list();
		CardTerminal terminal = terminals.get(0);
		return terminal.connect(protocol);
	}
	
	public byte[] readBytes(ResponseAPDU responseAPDU) {
		return responseAPDU.getBytes();
	}
	
	public String readDataAsString(ResponseAPDU responseAPDU) {
		return new String(responseAPDU.getData());
	}
	
	public String readDataAsString(ResponseAPDU responseAPDU, String carset) throws UnsupportedEncodingException {
		return new String(responseAPDU.getData(), carset);
	}
	
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
