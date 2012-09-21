package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
Monroe County, NY (Rural Metro MEdical Services)
Contact: "axel_doerrer@yahoo.com" <axel_doerrer@yahoo.com>

RC:Run# 24706/300 GENESEE ST/X=Frost Ave|Superior St&Superior St///Priority 4/1A1 - ABDOMINAL PAIN/LOCI: APT 508 ENTRY: 33 YOF STOMACH PAIN HER RIGHT SIDE XST: btwn SUPERIOR ST AND
RC:Run# 23685/16 AUSTIN DR/X=Woodcrest Dr&Penfield Rd///Priority 4/17A3 - FALL - PUBLIC ASSIST/LOCI:  ENTRY: 75 YO FEM - FELL - FROM TOILET - SLIPPED - STILL ON FLOOR - NO INJ XST:
RC:Run# 20459/50 UNION SQUARE BLVD///134/Priority 3/INJURY- NON ACUTE/93 YOF FELL AND CUT ABOVE EYE....HAS BLOOD IN EYE/<Unknown>////
RC:Run# 20174/4 MITCHELL ST/X=Delamaine&Barberry///Priority 1/31D3 - UNCONSCIOUS/FAINTING - NOT ALERT/LOCI:  ENTRY: 29 YO MALE PASSED OUT -NOW AWAKE-NOT ALERT XST: btwn BARBERRY TE
RC:Run# 20413/535 LYELL AVE/X=Warner&Mart///Priority 4/26A2 - SICK PERSON - NO PRIORITY SYMPTOMS/LOCI: 535 1~2 LYELL ENTRY: 21 MONTH OLD M - 104.3 TEMP - XST: btwn MART PL AND RR 

 */

public class NYMonroeCountyRuralMetroParser extends DispatchProQAParser {
  
  public NYMonroeCountyRuralMetroParser() {
    super("MONROE COUNTY", "NY",
           "ADDR! APT? X:X? PRI CALL! INFO+ LOCI:PLACE ENTRY:INFO+ XST:SKIP");
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.contains("/Priority ")) return false;
    body = body.replace("/X=", "/X:").replace(" ENTRY:", "/ENTRY:").replace(" XST:", "/XST:");
    return super.parseMsg(body, data);
  }
  
  private class MyAptField extends AptField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("Priority ")) return false;
      if (field.length() > 4) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  private class MyPriorityField extends PriorityField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Priority ")) field = field.substring(9).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("PRI")) return new MyPriorityField();
    return super.getField(name);
  }
}
