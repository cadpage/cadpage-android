package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/* 
Randolph County, NC
Contact: Frank Crotts <Crottsf@guil-randfire.com>

Randolph 911 - GRFD\nBREATHING\n5064 CROTTS DR\nSTA40\nSTA40\n10-15 JAMES KIRKMAN...BREATHING DIFF...TIGHTNESS IN CHEST...HANDS TINGLING...HEART RATE IS 45\n16:34:30 08/21/2011 - WATSON,A D\nProQA Medical Case Entry Finished\n16:35:13 08/2
Randolph 911 - GRFD\nABDOMINAL PAIN\n6242 CEDAR LN\nSTA41\nSTA41\n10-15 HOWARD PEELE..68 YO..SICKNESS AND TREMBLING...TESTICLE PAIN..ABDOMINAL\nPAIN..CONFUSED...26 D 1\n10:26:05 08/22/2011 - MCCORQUODALE, C\nPROQA WOULD NOT LAUNCH
Randolph 911 - GRFD\nFALL\n8374 HARLOW RD;UNIT 10\nSTA41\nSTA41\nCHILTON MHP...CAILY SKEEN...87 Y/O FEMALE...KEY BEHIND THE ELECTRICAL AT THE TELEPHONE POLE INSIDE THE BLK BOX AND THE KEY IS FOR A DEAD BOLT...ABLE TO VOICE CONTACT UNK INJ
Randolph 911 - GRFD\nHEMORRHAGE\n203 GREEN OAK DR; SUITE A\nSTA20\nSTA20\nREF ASSISTING GUILFORD COUNTY\n00:14:45 08/23/2011 - NELSON,A W\nProQA Medical Case 1258044 Aborted: ASSISTING GUILFORD COUNTY
Randolph 911 - GRFD\nABDOMINAL PAIN\n119 BARWOOD TER\nSTA20\nSTA20\n47YOF.. 1C4.. NEAR FAINTING.. ABOVE THE NAVEL.. \n12:44:15 08/20/2011 - WALTER,D S\nProQA Medical Case Entry Finished\n12:44:48 08/20/2011 - KING,J C\nARCHDALE RD ONTO DON

Contact: "Franklinville Fire" <franklinvillefd@triadbiz.rr.com>
Contact: Brandon Hurley<bhurley002@triad.rr.com>
Sender: RandolphWirelessOffice@co.randolph.nc.us

Randolph 911 - FRFD\nBREATHING\n7363 FERGUSON RD\nSTA08\nSTA08\nLOT 15...CPN 301-4908...10-15 40 YOA FM COPD\n15:42:31 09/20/2011 - WATSON,A D\nProQA Medical Recommended Dispatch Level = 06D02\n15:42:41 09/20/2011 - WATSON,A D\nProQA Medica
Randolph 911 - FRFD\nACCIDENT/PD\nUS HWY 64 E & FOXFIRE RD\nSTA08\nSTA08\nREF TO TRAFFIC CONTROL AT 10-50 PD AUTH OF 8B
Randolph 911 - FRFD\nUNCONSCIOUS\n125 MEADOW RD\nSTA08\nSTA08\n38 YOF UNCONSCIOUS\n14:01:59 09/20/2011 - FIELDS,K F\nProQA Medical Case Entry Finished\n14:02:25 09/20/2011 - FIELDS,K F\nProQA Medical Recommended Dispatch Level = 31D02
Randolph 911 - FRFD\nBACK PAIN\n3453 NC HWY 22 N\nSTA08\nSTA08\n10-15 TROY BULLINS 40YOM...C/O SEVERE BACK PAIN WITH DIFF BREATHING...REQ NO\nSIRENS...REQ TX TO CHATHAM\n19:50:01 09/19/2011 - RICHARDSON,A L\nProQA Medical Case Entry Finishe
Randolph 911 - FRFD\nFIRE (WOODS)\n840 BRADY ST EXT\nSTA08\nSTA08\nACROSS THE STREET FROM THIS ADDRESS, 10-70 WOODS BEHIND A BRICK RES\nCALLER LARRY BALDWIN 302-6467\nCALLBACK=??(336)430-5623 LAT=+035.755273 LON=-079.651050 UNC=00025\n

*/

public class NCRandolphCountyParser extends FieldProgramParser {
  
  public NCRandolphCountyParser() {
    super("RANDOLPH COUNTY", "NC",
           "SRC CALL ADDR UNIT SKIP INFO! INFO+");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("Randolph 911 - ")) return false;
    body = body.substring(14).trim();
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(';');
      if (pt >= 0) {
        data.strApt = field.substring(pt+1).trim();
        field = field.substring(0, pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT";
    }
  }
  
  private static final Pattern SKIP_INFO_PTN = Pattern.compile("^\\d\\d:\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d{4}");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() >= 19) {
        if (SKIP_INFO_PTN.matcher(field).find()) return;
      } else {
        if ("NN:NN:NN NN/NN/NNNN".startsWith(field.replaceAll("\\d", "N"))) return;
      }
      if (field.length() >= 5) {
        if (field.toUpperCase().startsWith("PROQA")) return;
      } else {
        if ("PROQA".startsWith(field.toUpperCase())) return;
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
