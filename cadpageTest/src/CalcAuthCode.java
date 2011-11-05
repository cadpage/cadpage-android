
import java.text.SimpleDateFormat;
import java.util.Date;

import net.anei.cadpage.donation.DonationManager;

/** Class calculates and displays the daily authorization codes */ 

public class CalcAuthCode {
  public static void main(String[] args) {
    String code1 = DonationManager.getAuthCode(1);
    String code2 = DonationManager.getAuthCode(2);
    System.out.println("Today is " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
    System.out.println("Exempt release code is " + code1 + " or " + code1.toLowerCase());
    System.out.println("Extend 1 Month code is " + code2 + " or " + code2.toLowerCase());
  }

}
