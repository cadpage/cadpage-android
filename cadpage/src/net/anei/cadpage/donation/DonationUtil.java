package net.anei.cadpage.donation;
import java.util.Date;
import java.util.Random;


public class DonationUtil {
  
  /**
   * @return Today's authorization code
   */
  public static String getAuthCode(int type) {
    return getAuthCode(type, new Date());
  }
  
  public static String getAuthCode(int type, Date date) {
    return calcAuthCode(type, new JulianDate(date));
  }
  
  /**
   * Return a hash authorization code from a date
   * @param date date to be hashed
   * @return return hashed authorization string
   */
  public static String calcAuthCode(int type, JulianDate jdate) {
    Random rnd = new Random(jdate.hashCode());
    for (int ndx = 1; ndx < type; ndx++) rnd.nextInt();
    int val = Math.abs(rnd.nextInt());
    StringBuffer sb = new StringBuffer();
    for (int j = 0; j < 8; j++) {
       sb.append((char)('A'+ (val % 26)));
       val = val / 26;
    }
    return sb.toString();
  }

}
