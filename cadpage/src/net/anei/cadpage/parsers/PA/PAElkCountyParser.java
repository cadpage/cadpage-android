package net.anei.cadpage.parsers.PA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Elk County, PA (also dispatches Cameron County and apparently Clearfield County)
Contact: "McAllister, Mike" <mamcallister@elkoes.com>
Sender: alerts@elkcounty911.ealertgov.com
System: Logisys CAD

Inc: DIABETIC PROBLEMS Add: 890 BURNING WELL RD\nCity: JONES\nXSt: OLD KANE RD * ROCKY RUN RD\nAgency: ST MARYS AMB 
Inc: FALLS Add: 185 CENTER ST\nCity: ST_MARYS\nXSt: N SAINT MARYS ST * MCGILL ST\nAgency: ST MARYS AMB 
Inc: SICK PERSON Add: 352 STATE ST\nCity: ST_MARYS\nXSt: ANTHONY RD * RIDGWAY ST MARYS RD\nAgency: ST MARYS AMB 
Inc: TRANSFER/INTERFACILITY Add: 755 JOHNSONBURG RD\nCity: ST_MARYS\nXSt: MAURUS ST * SHERRY RD\nAgency: ST MARYS AMB 
Inc: TRAFFIC ACCIDENT/INJURIES Add: IRISHTOWN RD and MAIN ST\nCity: FOX\nXSt: SKYLINE DR * TAYLOR ST\nAgency: ST MARYS AMB 
Inc: ALARMS-COMMERCIAL Add: 109 JEEP RD\nCity: ST_MARYS\nXSt: S SAINT MARYS ST\nAgency: ST MARYS AMB 
Inc: SICK PERSON Add: 303 CHESTNUT ST\nCity: ST_MARYS\nXSt: E MILL ST * OAK ST\nAgency: ST MARYS AMB

Contact: "Mike Healy" <mike.healy@thefirehall.net>
Sender: alerts@elkcounty911.ealertgov.com
Inc: ELEC HAZ-ELECTRICAL HAZ-WATER Add: 1449 SHAWMUT RD \nCity: HORTON \nXSt: ROUTE 219 * ROCKY LN \nAgency: ELK COMPANY 1 FD \n\n5/29/2012 4:03:58 PM

 */


public class PAElkCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "ST_MARYS", "ST MARYS"
  }); 
  
  public  PAElkCountyParser() {
    super(CITY_TABLE, "ELK COUNTY", "PA",
          "Inc:CALL! Add:ADDR! City:CITY! XSt:X! Agency:SRC! INFO DATETIME");
  }
  
  @Override
  public String getFilter() {
    return "alerts@elkcounty911.ealertgov.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = body.replace(" Add:", "\nAdd:");
    return parseFields(body.split("\n"), 5, data);
  }
  
  private final static DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) return;
      data.strDate = field.substring(0,pt).trim();
      setTime(TIME_FMT, field.substring(pt+1).trim(), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
}
