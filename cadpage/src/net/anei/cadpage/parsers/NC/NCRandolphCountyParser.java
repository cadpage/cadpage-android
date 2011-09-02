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
