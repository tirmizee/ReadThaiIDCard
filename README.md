### ReadThaiIDCard

#### Smart Card I/O API : https://docs.oracle.com/javase/7/docs/jre/api/security/smartcardio/spec/
	
### APDU (Application Protocol Data Unit) 

มาตรฐานการสื่อสารของ Smart card ถูกกำหนดใน ISO/IEC 7816–4

### APDU Commands 

### APDU Java byte array 
| Variable name | Type | Value |
| ------------- | ------------- |-------------|
| APDU_SELECT  | byte[] |{0, -92, 4, 0, 8, -96, 0, 0, 0, 84, 72, 0, 1}  |
| APDU_CID  | byte[] |{-128, -80, 0, 4, 2, 0, 13}  |
| APDU_FULLNAME_TH  | byte[] |{-128, -80, 0, 17, 2, 0, 100}  |
|APDU_FULLNAME_EN|byte[]|{-128, -80, 0, 117, 2, 0, 100}|
|APDU_DATE_OF_BIRTH|byte[]|{-128, -80, 0, -39, 2, 0, 8}|
|APDU_GENDER|byte[]|{-128, -80, 0, -31, 2, 0, 1}|
|APDU_CARD_ISSUER|byte[]|{-128, -80, 0, -10, 2, 0, 100}|
|APDU_ISSUE_DATE|byte[]|{-128, -80, 1, 103, 2, 0, 8}|
|APDU_EXPIRE_DATE|byte[]|{-128, -80, 1, 111, 2, 0, 8}|
|APDU_ADDRESS|byte[]|{-128, -80, 21, 121, 2, 0, 100}|
|APDU_PHOTO_PART01|byte[]|{-128, -80, 1, 123, 2, 0, -1}|
|APDU_PHOTO_PART02|byte[]|{-128, -80, 2, 122, 2, 0, -1}|
|APDU_PHOTO_PART03|byte[]|{-128, -80, 3, 121, 2, 0, -1}|
|APDU_PHOTO_PART04|byte[]|{-128, -80, 4, 120, 2, 0, -1}|
|APDU_PHOTO_PART05|byte[]|{-128, -80, 5, 119, 2, 0, -1}|
|APDU_PHOTO_PART06|byte[]|{-128, -80, 6, 118, 2, 0, -1}|
|APDU_PHOTO_PART07|byte[]|{-128, -80, 7, 117, 2, 0, -1}|
|APDU_PHOTO_PART08|byte[]|{-128, -80, 8, 116, 2, 0, -1}|
|APDU_PHOTO_PART09|byte[]|{-128, -80, 9, 115, 2, 0, -1}|
|APDU_PHOTO_PART10|byte[]|{-128, -80, 10, 114, 2, 0, -1}|
|APDU_PHOTO_PART11|byte[]|{-128, -80, 11, 113, 2, 0, -1}|
|APDU_PHOTO_PART12|byte[]|{-128, -80, 12, 112, 2, 0, -1}|
|APDU_PHOTO_PART13|byte[]|{-128, -80, 13, 111, 2, 0, -1}|
|APDU_PHOTO_PART14|byte[]|{-128, -80, 14, 110, 2, 0, -1}|
|APDU_PHOTO_PART15|byte[]|{-128, -80, 15, 109, 2, 0, -1}|
|APDU_PHOTO_PART16|byte[]|{-128, -80, 16, 108, 2, 0, -1}|
|APDU_PHOTO_PART17|byte[]|{-128, -80, 17, 107, 2, 0, -1}|
|APDU_PHOTO_PART18|byte[]|{-128, -80, 18, 106, 2, 0, -1}|
|APDU_PHOTO_PART19|byte[]|{-128, -80, 19, 105, 2, 0, -1}|
|APDU_PHOTO_PART20|byte[]|{-128, -80, 20, 104, 2, 0, -1}|

	

#### Credit APDU : https://github.com/chakphanu/ThaiNationalIDCard/blob/master/APDU.md

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


### Result


![Capture](https://user-images.githubusercontent.com/15135199/75363360-97c4ba80-58ec-11ea-8bef-d229c1d1de7a.PNG)


![demo](https://user-images.githubusercontent.com/15135199/51822112-db29af80-230d-11e9-9e75-013bb8947d13.png)



