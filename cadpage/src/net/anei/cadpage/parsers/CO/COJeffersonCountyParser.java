package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Cecil County, MD
Contact: CodeMessaging
Sender: @c-msg.net

[WRCAD] Add:3745 Quail St Type: UNKM PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0708201205966-001385
[WRCAD] Add:2650 Harlan St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001431
[WRCAD] Add:4345 Everett St Type: FALL PgG-17 Units:WM1,WR1Radio:TAC2 Case#:0627201205966-001283
[WRCAD] Add:3480 Ames St Type: LINE PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0627201205966-001282
[WRCAD] Add:7045 W 43rd Ave Type: INV PgG-18 Units:WR1,WRD71Radio:TAC3 Case#:0705201205966-001352
[WRCAD] Add:2686 Newland St Type: CO PgH-19 Units:WR1Radio:TAC2 Case#:0712201205966-001412
[WRCAD] Add:4643 Wadsworth Blvd Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001410
[WRCAD] Add:7380 W 32nd Ave Type: STROK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001423
[WRCAD] Add:7535 W 44th Ave Type: ALTER PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001458
[WRCAD] Add:7777 W 29th Ave Type: PSYCH PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0704201205966-001341
[WRCAD] Add:4407 Teller St Type: CPRA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0630201205966-001302


*/

public class COJeffersonCountyParser extends FieldProgramParser {
  

  public COJeffersonCountyParser() {
    super("Jefferson County", "CO",
        "Add:ADDR! Type:CALL! Units:UNIT Case#:ID");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
    
  }
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("Radio:", " Radio:");  
    if (!subject.startsWith("WRCAD")) return false; 
    return true;
  }  
  private static final Pattern UNIT = Pattern.compile("([A-Z0-9]+) (Radio:[A-z]d/)");
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT.matcher(field);
      if (match.find()) {
        data.strUnit = match.group(1);
        data.strChannel = match.group(2);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
  
    @Override
    public String getFieldNames() {
      return "UNIT CH";
    }
  }
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  }
  





