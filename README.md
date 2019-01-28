# ReadThaiIDCard
	/**
	 * @author Pratya Yeekhaday
	 *
	 * @param <T> responseDataType
	 */
	public interface CardReader<T> {

		T readCard() throws Exception;

	}
	
	
#
	/**
	 * @author Pratya Yeekhaday
	 *
	 */
	public class ThaiCardReader extends AbstractThaiCommandAPDU implements CardReader<PersonData> {

		@Override
		public PersonData readCard() throws Exception {

			TerminalFactory factory = TerminalFactory.getDefault();
			List<CardTerminal> terminals = factory.terminals().list();

			CardTerminal terminal = terminals.get(0);
			Card card = terminal.connect("*");
			CardChannel channel = card.getBasicChannel();
			channel.transmit(getThaiCardCommand());

			String cid = getDataAsString(channel.transmit(getCidCommand()));
			String fullnameTH = getDataAsString(channel.transmit(getFullnameTHCommand()));
			String fullnameEN = getDataAsString(channel.transmit(getFullnameENCommand()));
			String gender = getDataAsString(channel.transmit(getGenderCommand()));
			String address = getDataAsString(channel.transmit(getAddressCommand()));
			String dateOfBirth = getDataAsString(channel.transmit(getDateOfBirthCommand()));
			String cardIssue = getDataAsString(channel.transmit(getCardIssuerCommand()));
			String issueDate = getDataAsString(channel.transmit(getIsseDateCommand()));
			String expireDate = getDataAsString(channel.transmit(getExpireDateCommand()));

			PersonData personDetail = new PersonData();
			personDetail.setCid(cid);
			personDetail.setFullnameTH(toFormatFullname(fullnameTH));
			personDetail.setFullnameEN(toFormatFullname(fullnameEN));
			personDetail.setTitlenameTH(toFormatTitlename(fullnameTH));
			personDetail.setTitlenameEN(toFormatTitlename(fullnameEN));
			personDetail.setFirstnameTH(toFormatFirstname(fullnameTH));
			personDetail.setFirstnameEN(toFormatFirstname(fullnameEN));
			personDetail.setLastnameTH(toFormatLastname(fullnameTH));
			personDetail.setLastnameEN(toFormatLastname(fullnameEN));
			personDetail.setMidnameTH(toFormatMidname(fullnameTH));
			personDetail.setMidnameEN(toFormatMidname(fullnameEN));
			personDetail.setGenderId(gender);
			personDetail.setGenderCode(toFormatGenderCode(gender));
			personDetail.setGenderNameTH(toFormatGenderNameTH(gender));
			personDetail.setGenderNameEN(toFormatGenderNameEN(gender));
			personDetail.setAddress(toFormatAddress(address));
			personDetail.setDateOfBirth(dateOfBirth);
			personDetail.setCardIssue(cardIssue);
			personDetail.setIssueDate(issueDate);
			personDetail.setExpireDate(expireDate);

			card.disconnect(false);

			return personDetail;
		}

		private String toFormatAddress(String address) {
			return address.replaceAll("[#]+", " ");
		}

		private String toFormatGenderNameTH(String genderId) {
			return "1".equals(genderId) ? "ชาย" : "หญิง";
		}

		private String toFormatGenderNameEN(String genderId) {
			return "1".equals(genderId) ? "Male" : "Famale";
		}

		private String toFormatGenderCode(String genderId) {
			return "1".equals(genderId) ? "M" : "F";
		}

		private String toFormatTitlename(String fullname) {
			return fullname.split("#")[0];
		}

		private String toFormatFirstname(String fullname) {
			return fullname.split("#")[1];
		}

		private String toFormatMidname(String fullname) {
			return fullname.split("#")[2];
		}

		private String toFormatLastname(String fullname) {
			return fullname.split("#")[3];
		}

		private String toFormatFullname(String fullname) {
			String[] names = fullname.split("#"); 
			return names[0] + names[1] + " " + names[3];
		}

		public String getDataAsString(ResponseAPDU responseAPDU) {
			return new String(responseAPDU.getData());
		}

		public String getDataAsString(ResponseAPDU responseAPDU, String carset) throws UnsupportedEncodingException {
			return new String(responseAPDU.getData(), carset);
		}

	}

#
Credit APDU : https://github.com/chakphanu/ThaiNationalIDCard/blob/master/APDU.md

	public abstract class AbstractThaiCommandAPDU {

		public static final byte[] APDU_BA = {
			(byte)0x00, (byte)0xA4, (byte)0X04, (byte)0x00, (byte)0x08, (byte)0xA0, (byte)0X00, 
			(byte)0x00, (byte)0x00, (byte)0x54, (byte)0x48, (byte)0x00, (byte)0x01
		};

		public static final byte[] APDU_CID = {
			(byte) 0x80, (byte)0xb0, (byte)0x00, (byte)0x04, (byte)0x02, (byte)0x00, (byte)0x0d
		};

		public static final byte[] APDU_FULLNAME_TH = {
			(byte)0x80, (byte)0xB0, (byte)0x00, (byte)0x11, (byte)0x02, (byte)0x00, (byte)0x64
		};

		public static final byte[] APDU_FULLNAME_EN = {
			(byte)0x80, (byte)0xB0, (byte)0x00, (byte)0x75, (byte)0x02, (byte)0x00, (byte)0x64
		};

		public static final byte[] APDU_DATE_OF_BIRTH = {
			(byte)0x80, (byte)0xB0, (byte)0x00, (byte)0xD9, (byte)0x02, (byte)0x00, (byte)0x08	
		};

		public static final byte[] APDU_GENDER = {
			(byte)0x80, (byte)0xB0, (byte)0x00, (byte)0xE1, (byte)0x02, (byte)0x00, (byte)0x01
		};

		public static final byte[] APDU_CARD_ISSUER = {
			(byte)0x80, (byte)0xB0, (byte)0x00, (byte)0xF6, (byte)0x02, (byte)0x00, (byte)0x64
		};

		public static final byte[] APDU_ISSUE_DATE = {
			(byte)0x80, (byte)0xB0, (byte)0x01, (byte)0x67, (byte)0x02, (byte)0x00, (byte)0x08
		};

		public static final byte[] APDU_EXPIRE_DATE = {
			(byte)0x80, (byte)0xB0, (byte)0x01, (byte)0x6F, (byte)0x02, (byte)0x00, (byte)0x08
		};

		public static final byte[] APDU_ADDRESS = {
			(byte)0x80, (byte)0xB0, (byte)0x15, (byte)0x79, (byte)0x02, (byte)0x00, (byte)0x64	
		};

		public static final byte[] APDU_PHOTO_PART01 = {
			(byte)0x80, (byte)0xB0, (byte)0x01, (byte)0x7B, (byte)0x02, (byte)0x00, (byte)0xFF	
		};

		public static final byte[] APDU_PHOTO_PART02 = {
			(byte)0x80, (byte)0xB0, (byte)0x02, (byte)0x7A, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART03 = {
			(byte)0x80, (byte)0xB0, (byte)0x03, (byte)0x79, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART04 = {
			(byte)0x80, (byte)0xB0, (byte)0x04, (byte)0x78, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART05 = {
			(byte)0x80, (byte)0xB0, (byte)0x05, (byte)0x77, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART06 = {
			(byte)0x80, (byte)0xB0, (byte)0x06, (byte)0x76, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART07 = {
			(byte)0x80, (byte)0xB0, (byte)0x07, (byte)0x75, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART08 = {
			(byte)0x80, (byte)0xB0, (byte)0x08, (byte)0x74, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART09 = {
			(byte)0x80, (byte)0xB0, (byte)0x09, (byte)0x73, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART10 = {
			(byte)0x80, (byte)0xB0, (byte)0x0A, (byte)0x72, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART11 = {
			(byte)0x80, (byte)0xB0, (byte)0x0B, (byte)0x71, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART12 = {
			(byte)0x80, (byte)0xB0, (byte)0x0C, (byte)0x70, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART13 = {
			(byte)0x80, (byte)0xB0, (byte)0x0D, (byte)0x6F, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART14 = {
			(byte)0x80, (byte)0xB0, (byte)0x0E, (byte)0x6E, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART15 = {
			(byte)0x80, (byte)0xB0, (byte)0x0F, (byte)0x6D, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART16 = {
			(byte)0x80, (byte)0xB0, (byte)0x10, (byte)0x6C, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART17 = {
			(byte)0x80, (byte)0xB0, (byte)0x11, (byte)0x6B, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART18 = {
			(byte)0x80, (byte)0xB0, (byte)0x12, (byte)0x6A, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART19 = {
			(byte)0x80, (byte)0xB0, (byte)0x13, (byte)0x69, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public static final byte[] APDU_PHOTO_PART20 = {
			(byte)0x80, (byte)0xB0, (byte)0x14, (byte)0x68, (byte)0x02, (byte)0x00, (byte)0xFF
		};

		public CommandAPDU getCidCommand() throws IOException {
			return new CommandAPDU(APDU_CID);
		}

		public CommandAPDU getFullnameTHCommand() {
			return new CommandAPDU(APDU_FULLNAME_TH);
		}

		public CommandAPDU getFullnameENCommand() {
			return new CommandAPDU(APDU_FULLNAME_EN);
		}

		public CommandAPDU getDateOfBirthCommand() {
			return new CommandAPDU(APDU_DATE_OF_BIRTH);
		}

		public CommandAPDU getGenderCommand() {
			return new CommandAPDU(APDU_GENDER);
		}

		public CommandAPDU getCardIssuerCommand() {
			return new CommandAPDU(APDU_CARD_ISSUER);
		}

		public CommandAPDU getIsseDateCommand() {
			return new CommandAPDU(APDU_ISSUE_DATE);
		}

		public CommandAPDU getExpireDateCommand() {
			return new CommandAPDU(APDU_EXPIRE_DATE);
		}

		public CommandAPDU getAddressCommand() {
			return new CommandAPDU(APDU_ADDRESS);
		}

		public CommandAPDU getThaiCardCommand() {
			return new CommandAPDU(APDU_BA);
		}
	
	}

#


	public class PersonData {

		private String cid;
		private String titlenameTH;
		private String titlenameEN;
		private String firstnameTH;
		private String firstnameEN;
		private String lastnameTH;
		private String lastnameEN;
		private String fullnameTH;
		private String fullnameEN;
		private String genderId;
		private String genderCode;
		private String genderNameTH;
		private String genderNameEN;
		private String dateOfBirth;
		private String cardIssue;
		private String IssueDate;
		private String expireDate;
		private String address;

		// getter setter

	}
