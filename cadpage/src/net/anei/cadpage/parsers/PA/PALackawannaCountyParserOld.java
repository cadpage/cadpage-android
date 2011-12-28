package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lackawanna County, PA
Contact: greg rhodes <grhodes908@gmail.com>
Sender: aegispage@lackawannacounty.org

14 - Covington TWP
53 - Spring Brook TWP

(Dispatch) Unit:14-9 Status:Dispatched Location:524 DEACON ST, 14 Call Type:BLS Call Time:12/7/2010 6:22:58 AM Call Number:245 Quadrant:F14 District:
(Dispatch) Unit:14-9 Status:Dispatched Location:132 UNION MILL RD WINSHIP RD / LANGAN RD, VAN BRUNT ST, 14 Call Type:ALS Call Time:12/11/2010 11:27:5
(Dispatch) Unit:CH53 Status:Dispatched Location:0 ASTON MOUNTAIN RD, 53 Call Type:ACCI Call Time:12/11/2010 1:12:10 PM Call Number:446 Quadrant:F53 D
(Dispatch) Unit:ch14 Status:Dispatched Location:0 LEHIGH RD, 14 Call Type:BRSH Call Time:12/12/2010 9:01:17 AM Call Number:872 Quadrant:F14 District:
(Dispatch) Unit:14-9 Status:Dispatched Location:298 1ST AVE DEAD END / DRINKER TPKE, 14 Common Name:DIAPERS COM Call Type:BLS Call Time:12/12/2010 5:
(Dispatch) Unit:CH53 Status:Dispatched Location:RT 690 / BOWENS RD, 53 Call Type:ACCI Call Time:12/17/2010 11:04:51 PM Call Number:413 Quadrant:F53 D
   in Spring Brook TWP
[Dispatch]  Unit:ch14 Status:Dispatched Location:662 DRINKER TPKE AM HUGHES BLVD / ROSS DR, 14 Call Type:ACCI Call Time:12/18/2010 6:05:58 AM Call Num
   Covington TWP, PA
(Dispatch) Unit:T14 Status:Dispatched Location:SCRANTON POCONO HWY / DRINKER TPKE, 14 Call Type:AFA Call Time:12/21/2010 8:56:18 AM Call Number:802 Q
    Dual dispatch of 53 spring brook two pa and 14 daleville pa  
    
Contact: Mark Krzan <mkrzan1@gmail.com>
Unit  Location: 206 MILLER RD STEVENSON RD / CARBONDALE RD 1 Common Name: Call Type: ALS Call Time: 09/26/11 17:02 Narrative  pd notified  POSS CONFUSED ALSO  Nature Of Call: 79YOF FEELING WEEK. SHE DID FALL EARLIER
Unit  Location: 711 MAY ST MAPLE ST / DEAD END 59 Common Name: Call Type: ALS Call Time: 09/26/11 21:33 Narrative  PD ADVISED  REF EMD  HX OF HEART PROBLEMS  Nature Of Call: 56 YOM RAPID HEART RATE
Unit  Location: 108 TERRACE DR STURGES RD / SCRANTON CARBONDALE HWY 20 Common Name: LACKAWANNA HEALTH AND REHABCall Type: ALS Call Time: 09/26/11 21:02 Narrative  22-9/LA4 TO MOSES TAYLOR  22-9 ENRT MOMENTARILY  Nature Of Call: in c-2 -- 90 yo f diff breathing low o2 sats

 */


public class PALackawannaCountyParserOld extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
     "14", "COVINGTON TWP",
     "53", "SPRING BROOK TWP"
  });
  
  public PALackawannaCountyParserOld() {
    super(CITY_CODES, "LACKAWANNA COUNTY", "PA",
           "Unit:UNIT! Status:SKIP? Location:ADDRCITY/SXx! Common_Name:PLACE? Call_Type:CALL! Call_Time:SKIP Call_Number:ID Quadrant:MAP District:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "aegispage@lackawannacounty.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("0 ")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
}
