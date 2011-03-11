package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.SmsMsgInfo.Data;

import net.anei.cadpage.parsers.FieldProgramParser;

/*
Marion County (North), OR
Contact: Mike Jensen <sfdmike@gmail.com>
Sender: trex@ci.woodburn.or.us
System: New World Systems :Aegis Public Safety System

[(49962]  : ) TONE:  819::RAILWAY:AV:::::3030:VTON,STAF,:SAFE COM STA1@1830/APP CKS@1900 EMS@1945 STA1:20110302:174858
[(45354]  : ) CVA: 1732::PINE:ST:9::::3029:M24,R404,D411,STAF,N7,:35 Y M C/B/A LEFT SIDE PARALYSIS:20110223:110234
[(47486]  : ) STRC:::ABIQUA:RD:::HW 213::2833:E435,E485,E405,E415,D411,T489,T418,T419,R484,PGE,TIME,STAF,N7,:LARGE FLAMES APPX 2 MILES EAST:20110226:183324
[(48144]  : ) SICK: 5024::CROOKED FINGER:RD:::::3340:E485,D411,:75YOM C/B/A DIZZY:20110228:043844
[(50323]  : ) BREA:12884::MASCHER:RD:::::3230:E415,D411,STAF,:85YOF C/A/SOB FAST HEART RATE/150:20110303:140259
[(50791]  : ) FALL:  930::OAK:ST:130::::3031:M23,R404,D411,N7,:99YOF C/A/B GLF R HIP PAIN:20110304:073911
[(52678]  : ) ALM: 1106::PINE:ST:::::3030:E405,D411,N7,:CO2 DETECTOR ALRM AT COMM LOC:20110306:215554
[(52806]  : ) UNC: 5870::VALLEY VIEW:RD:::::3032:M24,R404,D411,N7,:65YOM UNC/NOT BREA:20110307:073728
[(53886]  : ) MISC:12622::SILVERTON:RD:::::3030:E415,D411,N7,:FLAMES SEEN FROM FIELD NEAR BY:20110308:190734
[(53944]  : ) SUIC: 1418::PINE:ST:D::::3030:M24,R404,D411,N7,:64YOF/C/B/SUIC ATTEMPT, SLASHED WRISTS:20110308:194443
[(54072]  : ) MVA:  918:N:FIRST:ST:::::3031:E405,E435,R404,D411,M23,N7,:ONE VEH ROLLOVER IFO ROTHS STORE:20110309:022055
[(45886]  : ) MVA:::CASCADE:HW:::STATE:ST:3630:E425,D411,R404,M31,SBLE,SBLR,PGE,E415,LAW,N7,:SINGLE VEH ROLLOVER/ENTRAPMENT, NO INJ:20110224:063549

*/

public class ORMarionCountyNParser extends FieldProgramParser {
  
  public ORMarionCountyNParser() {
    super("MARION COUNTY", "OR",
           "CALL ADDR1 ADDR1 ADDR1 ADDR1 APT ADDR2 ADDR2 ADDR2 MAP UNIT INFO");
  }
  
  private String address[] = new String[2];
  
  @Override
  public String getFilter() {
    return "trex@ci.woodburn.or.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("(")) return false;
    data.strCallId = subject.substring(1).trim();
    
    if (! body.startsWith(": ) ")) return false;
    body = body.substring(4).trim();
    
    address[0] = address[1] = "";
    if (! parseFields(body.split(":"), data)) return false;
    
    data.strAddress = append(address[0], " & ", address[1]);
    return true;
  }
  
  private class MyAddressField extends AddressField {
    
    private int index;
    
    public MyAddressField(int index) {
      this.index = index;
    }
    
    @Override
    public void parse(String fld, Data data) {
      if (fld.equals("AV")) fld = "AVE";
      else if (fld.equals("HW")) fld = "HWY";
      else if (fld.startsWith("HW ")) fld = "HWY " + fld.substring(3);
      address[index] = append(address[index], " ", fld); 
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String fld, Data data) {
      if (fld.endsWith(",")) fld = fld.substring(0,fld.length()-1);
      super.parse(fld, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR1")) return new MyAddressField(0);
    if (name.equals("ADDR2")) return new MyAddressField(1);
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
