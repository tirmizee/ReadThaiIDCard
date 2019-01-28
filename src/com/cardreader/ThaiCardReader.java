package com.cardreader;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

import com.cardcommand.AbstractThaiCommandAPDU;
import com.carddata.RawData;

/**
 * @author Pratya Yeekhaday
 *
 */
public class ThaiCardReader extends AbstractThaiCommandAPDU implements CardReader<RawData> {

	@Override
	public RawData readCard() throws Exception {
		
		TerminalFactory factory = TerminalFactory.getDefault();
		List<CardTerminal> terminals = factory.terminals().list();
		
		CardTerminal terminal = terminals.get(0);
		Card card = terminal.connect("*");
		CardChannel channel = card.getBasicChannel();
		channel.transmit(commandBa());
		
		String cid = readDataAsString(channel.transmit(commandCid()));
		String fullnameTH = readDataAsString(channel.transmit(commandFullnameTH()));
		String fullnameEN = readDataAsString(channel.transmit(commandFullnameEN()));
		String gender = readDataAsString(channel.transmit(commandGender()));
		String address = readDataAsString(channel.transmit(commandAddress()));
		String dateOfBirth = readDataAsString(channel.transmit(commandDateOfBirth()));
		String cardIssue = readDataAsString(channel.transmit(commandCardIssuer()));
		String issueDate = readDataAsString(channel.transmit(commandIsseDate()));
		String expireDate = readDataAsString(channel.transmit(commandExpireDate()));
		
		RawData  rawdata = new RawData();
		rawdata.setCid(cid);
		rawdata.setGender(gender);
		rawdata.setAddress(address);
		rawdata.setIssueDate(issueDate);
		rawdata.setCardIssue(cardIssue);
		rawdata.setFullnameTH(fullnameTH);
		rawdata.setFullnameEN(fullnameEN);
		rawdata.setExpireDate(expireDate);
		rawdata.setDateOfBirth(dateOfBirth);
		card.disconnect(false);
		
		return rawdata;
	}
	
	public String readDataAsString(ResponseAPDU responseAPDU) {
		return new String(responseAPDU.getData());
	}
	
	public String readDataAsString(ResponseAPDU responseAPDU, String carset) throws UnsupportedEncodingException {
		return new String(responseAPDU.getData(), carset);
	}

}
