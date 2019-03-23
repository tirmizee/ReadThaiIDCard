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
	public class ThaiCardReader extends AbstractThaiCommandAPDU implements CardReader<RawData> {

		@Override
		public RawData readCard() throws Exception {

			TerminalFactory factory = TerminalFactory.getDefault();
			List<CardTerminal> terminals = factory.terminals().list();

			CardTerminal terminal = terminals.get(0);
			Card card = terminal.connect("*");
			CardChannel channel = card.getBasicChannel();
			channel.transmit(commandSelect());

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



#
Credit APDU : https://github.com/chakphanu/ThaiNationalIDCard/blob/master/APDU.md

	public abstract class AbstractThaiCommandAPDU {

		public static final byte[] APDU_SELECT = {
			(byte)0x00, // CLA
			(byte)0xA4, // INS
			(byte)0X04, // P1
			(byte)0x00, // P2
			(byte)0x08, // Lc
			(byte)0xA0, (byte)0X00, (byte)0x00, (byte)0x00, (byte)0x54, (byte)0x48, (byte)0x00, (byte)0x01 // Data field
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

		protected CommandAPDU commandCid() throws IOException {
			return new CommandAPDU(APDU_CID);
		}

		protected CommandAPDU commandFullnameTH() {
			return new CommandAPDU(APDU_FULLNAME_TH);
		}

		protected CommandAPDU commandFullnameEN() {
			return new CommandAPDU(APDU_FULLNAME_EN);
		}

		protected CommandAPDU commandDateOfBirth() {
			return new CommandAPDU(APDU_DATE_OF_BIRTH);
		}

		protected CommandAPDU commandGender() {
			return new CommandAPDU(APDU_GENDER);
		}

		protected CommandAPDU commandCardIssuer() {
			return new CommandAPDU(APDU_CARD_ISSUER);
		}

		protected CommandAPDU commandIsseDate() {
			return new CommandAPDU(APDU_ISSUE_DATE);
		}

		protected CommandAPDU commandExpireDate() {
			return new CommandAPDU(APDU_EXPIRE_DATE);
		}

		protected CommandAPDU commandAddress() {
			return new CommandAPDU(APDU_ADDRESS);
		}

		protected CommandAPDU commandSelect() {
			return new CommandAPDU(APDU_SELECT);
		}

	}



#

Demo run as Java Applet


	public class Demo extends Applet {

		private static final long serialVersionUID = 1L;

		@Override
		public void start() {
			try {
				ThaiCardReader thaiCardReader = new ThaiCardReader();
				PersonInfo personInfo = thaiCardReader.readCard();
				if (personInfo != null) {
					System.out.println(personInfo.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	}


Result

![demo](https://user-images.githubusercontent.com/15135199/51822112-db29af80-230d-11e9-9e75-013bb8947d13.png)



