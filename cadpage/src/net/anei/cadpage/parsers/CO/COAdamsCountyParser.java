package net.anei.cadpage.parsers.CO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Adams County, CO
Contact: "Matt Kehoe" <mjkehoe@gmail.com>
Sender: ipspage@adcom911.org

Subject:IPS I/Page Notification E 64TH AVE/MONACO ST ADAM CCPD 09:51:48 TYPE CODE: ACCI CALLER NAME: TIME: 09:51:48 Comments: -104.90947
Subject:IPS I/Page Notification 6950 NIAGARA ST ADAM CCPD 11:04:10 TYPE CODE: EMS CALLER NAME: FELIX - 13YO TIME: 11:04:10 Comments: 15YO
Subject:IPS I/Page Notification 10220 BRIGHTON RD ADAM CCPD:DIVERSIFIES TRUCK AND RV 17:22:11 TYPE CODE: NONSTR CALLER NAME: BOB TIME: 17:
Subject:IPS I/Page Notification US HIGHWAY 85 NB/E 77TH AVE ADAM ADAM 03:34:04 TYPE CODE: NONSTR CALLER NAME: ASHLEY TIME: 03:34:04 Commen
Subject:IPS I/Page Notification 9900 E 102ND AVE ADAM CCPD:USF 06:06:49 TYPE CODE: FRALRM CALLER NAME: ADT TIME: 06:06:49 Comments: WATER
Subject:IPS I/Page Notification\n26900 E COLFAX AVE ARAP ARAP,454: @FOX RIDGE FARMS 17:19:15 TYPE CODE: EMS CALLER NAME:  TIME: 17:19:15 Co

Contact: Derrick Keeton <derrickkeeton@gmail.com>
IPS I/Page Notification / 10433 SALIDA ST ADAM CCPD 06:51:58 TYPE CODE: FRALRM CALLER NAME:  TIME: 06:51:58\n\n\n

Contact: JC Langley <ashaman01@gmail.com>
(IPS I/Page Notification) E 470 EB ADAM ADAM: @E 470 EB/E 56TH AVE 22:58:36 TYPE CODE: NONSTR CALLER NAME:  TIME: 22:58:36 Comments:  -104.701552 +39.798521 WH

Contact: "Schuppe, Michael" <mschuppe@brightonfire.org>
Sender: ipspage@adcom911.org
Subject:IPS I/Page Notification\n510.5 S 2nd Ave major incident-- hazmat  no additional equip needed at this time\r\n\r\n\r

Contact: support@active911.com
(IPS I/Page Notification) 8055 WASHINGTON ST ADAM ADAM: @STATION 31 13:45:48 TYPE CODE: EMS CALLER NAME: FIL MARTINEZ TIME: 13:45:48 Comments:  TEST CARD

 */


public class COAdamsCountyParser extends FieldProgramParser {
  
  private static final Pattern CAD_MARKER = 
        Pattern.compile("^(?:Subject:)?IPS I/Page Notification (?:/ )?");
  
  public COAdamsCountyParser() {
    super(CITY_TABLE, "ADAMS COUNTY", "CO",
           "ADDR! TYPE_CODE:CALL! CALLER_NAME:NAME! TIME:TIME! Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "ipspage@adcom911.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() > 0) body = "Subject:" + subject + ' ' + body;

    Matcher match = CAD_MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    if (super.parseMsg(body, data)) return true;
    
    // Fallback parsing address followed by call description
    data.initialize();
    parseAddress(StartType.START_ADDR, body, data);
    data.strCall = getLeft();
    return (getStatus() > 0);
  }
  
  
  private static final Pattern TIME_MARK = Pattern.compile(" +(\\d\\d:\\d\\d:\\d\\d)$");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("E 470", "E-470");
    
      Matcher match = TIME_MARK.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
        field = field.substring(0, match.start());
      }
      int pt = field.lastIndexOf(':');
      String sPlace = null;
      if (pt >= 0) {
        sPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (sPlace.startsWith("@")) sPlace = sPlace.substring(1).trim();
      }
      parseAddress(StartType.START_ADDR, field.replace(',', ' '), data);
      if (sPlace != null) {
        String sCross = null;
        pt = sPlace.indexOf('/');
        if (pt >= 0) {
          String sPart1 = sPlace.substring(0,pt).trim();
          String sPart2 = sPlace.substring(pt+1).trim();
          if (sPart1.equals(data.strAddress)) sCross = sPart2;
          else if (sPart2.equals(data.strAddress)) sCross = sPart1; 
        }
        if (sCross != null) data.strAddress = append(data.strAddress, " & ", sCross);
        else data.strPlace = sPlace;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE CITY";
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      if (data.strTime.length() > 0) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "ADAM ADAM", "",
      "ADAM CCPD", "",
      "ARAP ARAP", "ARAPAHOE COUNTY"
  });
}
