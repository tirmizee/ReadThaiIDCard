import java.applet.Applet;

import com.carddata.PersonInfo;
import com.cardreader.ThaiCardReader;

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