package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Salem County, NJ (Deepwater)
Contact: Michael Warner <warnersta7@gmail.com>
Contact: "m.warner1@comcast.net" <m.warner1@comcast.net>
Sender: msg@cfmsg.com

(Chief ALT) [STA:7] -- ALS -- 118 E Pittsfield St Pennsville Township NJ - Cross STS:Sparks Ave -- Caller: DAULTON 
(Chief ALT) [STA:7] -- Motor Vehicle Accident -- 1163 S Broadway Way Pennsville Township NJ - Cross STS:Freas Rd -- Caller: JACK KUGLER 9352515
(Chief ALT) [STA:7] -- MVC -- Njtp South Mm 1-4.5 Njtp Carneys Point Township NJ -- Caller: SHAWN HAMMELL 6178168
(Chief ALT) [STA:7] -- Fire Alarm System -- 117 N Broadway Way Pennsville Township NJ - Cross STS:Brandriff Ave -- Caller: VERIZON / KAREN 6158005
(Chief ALT) [STA:7] -- Out Of County Assist -- Delaware Memorial Brg New Castle DE -- Caller: COUNTY
(Chief ALT) [STA:7] -- Motor Vehicle Accident -- 430 N Broadway Way Pennsville Township NJ - Cross STS:Rt 130 Overpass -- Caller: 520
(Chief ALT) [STA:7] -- Structure Fire - Medium Hazard -- 709 S Broadway Way Pennsville Township NJ - Cross STS:Sharp St And Lighthouse Rd -- Caller: LS-5

Contact: Active911
Agency name: Parsonsburg Vol. Fire Co. Location: Parsonsburg, MD 
From: msg@cfmsg.com

(Chief ALT) [STA:6] -- Automatic Alarm -- 32000 Campus Dr Parsonsburg MD - Cross STS:Walston Switch Rd 
(Chief ALT) [STA:6] -- Psychiatric Emergency -- 6115 Ruth St Parsonsburg MD - Cross STS:Steve St - Florence St
(Chief ALT) [STA:6] -- Medical Assist -- 6115 Ruth St Parsonsburg MD - Cross STS:Steve St - Florence St
(Chief ALT) [STA:6] -- Seizure -- 6858 Zion Church Rd Parsonsburg MD - Cross STS:Old Ocean City Rd - Morris Leonard Rd
(Chief ALT) [STA:6] -- Sick Subject -- 7573 Parsonsburg Rd Parsonsburg MD - Cross STS:Old Oak Ln - Gadwall Ln
(Chief ALT) [STA:6] -- Medical Assist -- 7573 Parsonsburg Rd Parsonsburg MD - Cross STS:Old Oak Ln - Gadwall Ln
(Chief ALT) [STA:6] -- Difficulty Breathing -- 31550 Winterplace Pkwy Parsonsburg MD - Cross STS:Hobbs Rd - Blue Ribbon Rd
(Chief ALT) [STA:6] -- Subject Fallen -- 7466 Madeline Cir Parsonsburg MD - Cross STS:Jones Hastings Rd - Jones Hastings Rd
(Chief ALT) [STA:6] -- Pro Qa Ems -- 33322 Wango Rd Parsonsburg MD - Cross STS:Bear Swamp Rd - Chicken Ln
(Chief ALT) [STA:6] -- Sick Subject -- 31550 Winterplace Pkwy Parsonsburg MD - Cross STS:Hobbs Rd - Blue Ribbon Rd
(Chief ALT) [STA:6] -- Difficulty Breathing -- 6840 Mt Vernon Ave Parsonsburg MD - Cross STS:Old Ocean City Rd
(Chief ALT) [STA:6] -- Allergic Reaction -- 33442 Bob Smith Rd Parsonsburg MD - Cross STS:Dagsboro Rd - Esham Rd
(Chief ALT) [STA:6] -- Trash Fire -- Old Ocean City Rd & zion Church Rd Parsonsburg MD
(Chief ALT) [STA:6] -- Pi Accident -- Ocean Gtwy & walston Switch Rd Parsonsburg MD
(Chief ALT) [STA:6] -- Pi Accident -- Ocean Gtwy & walston Switch Rd Parsonsburg MD
(Chief ALT) [STA:6] -- Pi Accident -- E Line Rd & melson Church Rd Delmar MD
(Chief ALT) [STA:6] -- Chest Pain -- 7290 Walston Switch Rd Parsonsburg MD - Cross STS:Rushmore Dr - Morris Leonard Rd
(Chief ALT) [STA:6] -- Subject Fallen -- 31679 Dilworth Ave Parsonsburg MD - Cross STS:Brantley Dr - Cromwell Ave
(Chief ALT) [STA:6] -- Stroke -- 31375 John Deere Dr Parsonsburg MD - Cross STS:Hobbs Rd - Mid Atlantic Ln

 */

public class NJSalemCountyBParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" -- | - (?=Cross STS:)");
  
  public NJSalemCountyBParser() {
    super(CITY_LIST, "SALEM COUNTY", "NJ",
           "CALL! ADDR/S! Cross_STS:X? Caller:NAME");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,msg@cfmsg.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Drop calls from New Castle County, DE (B)
    if (body.contains(" EMD:")) return false;
   
    if (!subject.startsWith("Chief ALT|")) return false;
    data.strSource = subject.substring(10).trim();
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }

  private static final Pattern STATE_PTN = Pattern.compile(" +([A-Z]{2})$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      Matcher match = STATE_PTN.matcher(data.strCity);
      if (match.find()) {
        data.strState = match.group(1);
        if (data.strState.equals("NJ")) data.strState = "";
        data.strCity = data.strCity.substring(0, match.start()).trim();
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile(" +(\\d{7,})$");
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }
  
  private static String[] CITY_LIST = new String[]{
    "NEW CASTLE DE",
    "DELMAR MD",
    "PARSONSBURG MD",
    "CARNEYS POINT TOWNSHIP NJ",
    "PENNSVILLE TOWNSHIP NJ"
  };
}


