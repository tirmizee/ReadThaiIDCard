package com.cardreader;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

import com.cardcommand.AbstractThaiCommandAPDU;

public abstract class AbstractThaiCardReader<T> extends AbstractThaiCommandAPDU implements CardReader<T>{

	public static final TerminalFactory FACTORY = TerminalFactory.getDefault();
	
	public static final DateTimeFormatter THAI_DATE_FORMAT= DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public Card connect(String protocol) throws CardException {
		List<CardTerminal> terminals = FACTORY.terminals().list();
		CardTerminal terminal = terminals.get(0);
		return terminal.connect(protocol);
	}
	
	protected CommandAPDU command(byte[] apdu) {
		return new CommandAPDU(apdu);
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
	
	protected String formatAddress(String rawAddress) {
		return rawAddress.replaceAll("[#]+", " ");
	}
	
	protected String formatHouseNo(String rawAddress) {
		return  rawAddress.split("#")[0];
	}
	
	protected String formatVillageNo(String rawAddress) {
		return  rawAddress.split("#")[1];
	}
	
	protected String formatAlley(String rawAddress) {
		return  rawAddress.split("#")[3];
	}
	
	protected String formatRoad(String rawAddress) {
		return  rawAddress.split("#")[4];
	}
	
	protected String formatSubDistrict(String rawAddress) {
		return  rawAddress.split("#")[5];
	}
	
	protected String formatDistrict(String rawAddress) {
		return  rawAddress.split("#")[6];
	}
	
	protected String formatProvince(String rawAddress) {
		return  rawAddress.split("#")[7];
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

	protected String formatTitlename(String rawFullname) {
		return rawFullname.split("#")[0];
	}
	
	protected String formatFirstname(String rawFullname) {
		return rawFullname.split("#")[1];
	}
	
	protected String formatMidname(String rawFullname) {
		return rawFullname.split("#")[2];
	}
	
	protected String formatLastname(String rawFullname) {
		return rawFullname.split("#")[3];
	}
	
	protected String formatFullname(String rawFullname) {
		String[] names = rawFullname.split("#"); 
		return names[0] + names[1] + " " + names[3];
	}
	
}
