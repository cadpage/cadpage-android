import java.util.TimeZone;


public class TimeZoneTest {
  
  public static void main(String[] args) {
    String[] ids = TimeZone.getAvailableIDs(-5*60*60*1000);
    for (String id : ids) {
      System.out.println(id);
    }
  }

}
