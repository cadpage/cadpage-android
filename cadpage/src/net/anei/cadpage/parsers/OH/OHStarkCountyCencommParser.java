package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Stark County, OH (Cencomm)
Contact: support@active911.com
Sender: cencom@neohio.twcbc.com

(FIRES CALLS) CFFD:2012:306\nDISPATCHED\nMEDALS\n80, THOMAS BL ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:307\nDISPATCHED\nMEDALS\n1165, S LOCUST ST ;CANAL FULTON
(FIRES CALLS) CFFD:2012:308\nDISPATCHED\nMEDALS\n581, BEVERLY AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:309\nDISPATCHED\nMEDALS\n8757, SPRING GROVE AV NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:329\nDISPATCHED\nMEDALS\n14602, ARCADIA ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:324\nDISPATCHED\nMEDALS\n581, BEVERLY AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:325\nDISPATCHED\nODORRES\n808, DENSHIRE DR NW ;CANAL FULTON
(FIRES CALLS) CFFD:2012:326\nDISPATCHED\nMEDALS\n10751, JOHNSTON ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:327\nDISPATCHED\nMEDALS\n5622, CUTTEN AV NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:315\nDISPATCHED\nMEDALS\n700, BEVERLY AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:322\nDISPATCHED\nMVAINJ\n3971, MANCHESTER AV NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:323\nDISPATCHED\nMEDALS\n659, LAKEVIEW DR ;CANAL FULTON
(FIRES CALLS) CFFD:2012:318\nDISPATCHED\nRESFIRE\n3283, YOUNG AV NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:314\nDISPATCHED\nMEDALS\n10405, STRAUSSER ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:314\nDISPATCHED\nMEDALS\n10405, STRAUSSER ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:306\nDISPATCHED\nMEDALS\n80, THOMAS BL ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:313\nDISPATCHED\nMEDALS\n318, N CANAL ST ;CANAL FULTON
(FIRES CALLS) CFFD:2012:317\nDISPATCHED\nMEDALS\n447, CHIPPEWA ST ;CANAL FULTON
(FIRES CALLS) CFFD:2012:311\nDISPATCHED\nMEDALS\n843, BASSWOOD AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:320\nDISPATCHED\nMEDALS\n13374, BLUFTON NW
(FIRES CALLS) CFFD:2012:321\nDISPATCHED\nMEDALS\n10388, STONEACRE ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:320\nDISPATCHED\nMEDALS\n13374, BLUFTON NW
(FIRES CALLS) CFFD:2012:316\nDISPATCHED\nMEDALS\n8, MICHAEL CIR ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:307\nDISPATCHED\nMEDALS\n1165, S LOCUST ST ;CANAL FULTON
(FIRES CALLS) CFFD:2012:312\nDISPATCHED\nMEDALS\n8871, MANCHESTER AV NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:310\nDISPATCHED\nMEDALS\n714, BEVERLY AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:319\nDISPATCHED\nMEDALS\n10438, MAPLEVIEW ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:308\nDISPATCHED\nMEDALS\n581, BEVERLY AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:309\nDISPATCHED\nMEDALS\n8757, SPRING GROVE AV NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:330\nDISPATCHED\nMEDALS\n2042, REDWING DR ;CANAL FULTON
(FIRES CALLS) CFFD:2012:331\nDISPATCHED\nMEDALS\n10382, STRAUSSER ST NW ;LAWRENCE TWP
(FIRES CALLS) CFFD:2012:332\nDISPATCHED\nMEDALS\n585, BEVERLY AV ;CANAL FULTON
(FIRES CALLS) CFFD:2012:333\nDISPATCHED\nMEDALS\n490, COLONY RD ;CANAL FULTON
(FIRES CALLS) CFFD:2012:334\nDISPATCHED\nOPENBURN\n3806, GREENWOOD
(FIRES CALLS) CFFD:2012:335\nDISPATCHED\nMEDALS\n408, W MARKET ST ;CANAL FULTON

 */


public class OHStarkCountyCencommParser extends FieldProgramParser {
  
  public OHStarkCountyCencommParser() {
    super("STARK COUNTY", "OH",
           "SRCID DISPATCHED CALL ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "cencom@neohio.twcbc.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("FIRES CALLS")) return false;
    return parseFields(body.split("\n"), 4, data);
  }
  
  private static final Pattern SRC_ID_PTN = Pattern.compile("([A-Z0-9]+):(\\d{4}:\\d+)");
  private class SourceIdField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = SRC_ID_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strSource = match.group(1);
      data.strCallId = match.group(2);
    }
    
    @Override
    public String getFieldNames() {
      return "SRC ID";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(';');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      field = field.replaceAll(" *, *", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRCID")) return new SourceIdField();
    if (name.equals("DISPATCHED")) return new SkipField("DISPATCHED", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
}
