package net.anei.cadpage.parsers.MO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Newton County, MO
Contact: jeffrey lechliter <jlechliter4512@gmail.com>
Sender: 911@NC-CDC.ORG

Subject:911 CALL\n11178 ELAND RD  CrossStreets: JUNIPER DR 0.01 mi SE IVY DR 0.73 mi N SICK PERSON ESN: pg6 Call Number: 763388
Subject:911 CALL\nIRIS RD & STATE LINE RD  CrossStreets: TA-D (TONE PD) HIGH MECH-ALL TERRAIN ESN: pg6 Call Number: 760919
Subject:911 CALL\n2953 ROWAN DR  CrossStreets: ANTELOPE RD 0.19 mi E HIGHWAY 43 0.81 mi W STRUCTURE FIRE-D / RES (SINGLE) ESN: pg8 Call Number: 7
Subject:911 CALL\n13724 HIGHWAY 43, Apt. 30 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE ESN: pg7 Call Number
Subject:911 CALL\n20513 HIGHWAY Y  CrossStreets: RHINEHART LN 0.19 mi S REDBUD RD 0.62 mi N CHEST PAIN ESN: pg8 Call Number: 762218
Subject:911 CALL\n5369 QUINCE RD  CrossStreets: DENNISON LN 0.03 mi E CROW RD 0.71 mi W TA INJURY ESN: pg8 Call Number: 762973
Subject:911 CALL\n13724 HIGHWAY 43, Apt. 29 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE-D / MH-PORTABLE OFC 
Subject:911 CALL\n5156 JESSICA LN  CrossStreets: CROW RD 0.31 mi W FALL ESN: pg6 Call Number: 762520

*/

public class MONewtonCountyParser extends FieldProgramParser {
 
  public MONewtonCountyParser() {
    super("NEWTON COUNTY", "MO",
          "ADDR! CrossStreets:X! ESN:MAP Call_Number:ID");
  }
  
  @Override
  public String getFilter() {
    return "911@NC-CDC.ORG";
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equalsIgnoreCase("911 CALL")) return false;
    return super.parseMsg(body, data);
  }
  
  private static final Pattern MILE_PTN = Pattern.compile(" mi [NSEW] ");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = 0;
      Matcher match = MILE_PTN.matcher(field);
      while (match.find()) pt = match.end();
      if (pt >= 0) {
        data.strCall = field.substring(pt).trim();
        data.strCross = field.substring(0,pt).trim();
      } else {
        Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field);
        if (res.getStatus() > 0) {
          res.getData(data);
          data.strCall = res.getLeft();
        } else {
          data.strCall = field;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X CALL";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}