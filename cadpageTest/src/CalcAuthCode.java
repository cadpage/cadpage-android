
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import net.anei.cadpage.donation.DonationManager;

/** Class calculates and displays the daily authorization codes */ 

public class CalcAuthCode {
  public static void main(String[] args) {
    
    Calendar cal = new GregorianCalendar();
    if (args.length > 0 && args[0].length() > 0) {
      int adjust;
      try {
        adjust = Integer.parseInt(args[0]);
      } catch (NumberFormatException ex) {
        System.out.println("*** Invalid integer adjustmer");
        return;
      }
      cal.add(Calendar.HOUR_OF_DAY, adjust);
    }
    Date date = cal.getTime();
    
    String code1 = DonationManager.getAuthCode(1, date);
    String code2 = DonationManager.getAuthCode(2, date);
    System.out.println("Today is " + new SimpleDateFormat("MM/dd/yyyy").format(date));
    System.out.println("Exempt release code is " + code1 + " or " + code1.toLowerCase());
    System.out.println("Extend 1 Month code is " + code2 + " or " + code2.toLowerCase());
  }

}
