
import net.anei.cadpage.donation.DonationManager;

/** Class calcualtes the daily release exemption authorization code */ 

public class CalcAuthCode {
  public static void main(String[] args) {
    String code = DonationManager.getAuthCode();
    System.out.println("Todays authorization code is " + code + " or " + code.toLowerCase());
  }

}
