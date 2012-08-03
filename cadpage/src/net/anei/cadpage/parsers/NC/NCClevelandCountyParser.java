package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Cleveland County, NC
Contact: Richard Carroll <crrll19@gmail.com>
Sender: CAD@clevelandcounty.com

CAD:7044775828-CHEST PA-1861 E MARION ST-CAMDEN CT-BORDERS RD-[Medical Priority Info] PROBLEM: TINGLING DOWN HER ARMS # PATS: 1 AGE: 30 Years SEX: Female CO
CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]
CAD:7042978331-SEIZURES-117 PALMER ST-E MARION ST-AIRLINE AV-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 22 Years SEX: Male CONSCIOUS: No BREATH
CAD:KELIOSA-SEIZURES-313 S POST RD-GARRETT DR-KINGS ROAD EXT-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 3 Years SEX: Female CONSCIOUS: No BREAT
CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]
CAD:SPRINT PCS-9802953855-FIREAPT-415 GARDNER ST-SMITH ST-MARTIN ST-kitchen on fire at aprtment 5 they are trying to get every one out of adjacent apts [07/
CAD:CICILIA-8286444392-FIRE/HAZ-354 WASHBURN SWITCH RD-LILLCO DR-AMBER LN-GAS LEAK INSIDE THE HOUSE [07/31/12 21:18:19 C84]
CAD:AT&T MOBILITY-9118385620-FIRE/MIS-705 E DIXON BLVD-WAL-MART-EARL RD-GROVE ST

*/

public class NCClevelandCountyParser extends DispatchOSSIParser {
  
  @Override
  public String getFilter() {
    return "CAD@clevelandcounty.com";
  }
  
  public NCClevelandCountyParser() {
    super("CLEVELAND COUNTY", "NC",
           "( NAME PHONE | PHONE? ) CALL+? ADDR X+? INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("-", ";");
    return super.parseMsg(body, data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "-", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PHONE")) return new PhoneField("\\d{10}");
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
}
