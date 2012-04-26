package net.anei.cadpage.parsers.CT;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
New London County, CT
Contact: Kevin McManus <kmacinct@gmail.com>
Sender: messaging@iamresponding.com,911@kx911.com

COLCHESTER\ 25 VILLAGE CT\ \@  AMSTON RD\ FAINTING OR UNCONC. PERS\ VOGEL,HERBERT H \  ** 12-6474  \ 11:42 ** MapIt:  25  VILLAGE CT, COLCHESTER , CT ( UNCONSCIOUS )
COLCHESTER\ 15 OLD HARTFORD RD\ \@  WALL ST\ DIFFICULTY BREATHING\ STATE POLICE TROOP K - LOBBY \  ** 12-6456  \ 05:21 ** MapIt:  15  OLD HARTFORD RD, COLCHESTER , CT
COLCHESTER\  ROUTE 2 WEST \ \@  \ M/V ACCIDENT\ area of exit 18 \  ** 12-6481  \ 12:30 ** MapIt:    ROUTE 2 WEST , COLCHESTER , CT ( ROLLOVER. )
COLCHESTER\ 13 HUNTERS CT\ \@  MELANIE LN\ DIFFICULTY BREATHING\ FORTIN,V \ ** 12-6400  \ 23:17 ** MapIt:  13  HUNTERS CT, COLCHESTER , CT ( 40S MALE - ATTN G LAKE R2 MUTUAL AID )
COLCHESTER\ 27 VICKI LN\ \@  OLD HEBRON RD\ ALLERG. REACT\ CINCIRIPINO,JEFFREY \  ** 12-6342  \ 00:32 ** MapIt:  27  VICKI LN, COLCHESTER , CT ( 27 MALE REACTION TO MEDICATION )
COLCHESTER\ 64 BALABAN RD\ 505\@  GILLETTES LN\ SICK PERSON\ STAPLES,ARTHUR J \  ** 12-6360  \ 10:13 ** MapIt:  64  BALABAN RD, COLCHESTER , CT

*/

public class CTNewLondonCountyParser extends FieldProgramParser {
  
  public CTNewLondonCountyParser() {
    super("NEW LONDON COUNTY", "CT",
          "CITY ADDR APT X CALL PLACENAME ID! EXTRA");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com,911@kx911.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\\\\"), 7, data);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("@")) abort();
      super.parse(field.substring(1).trim(), data);
    }
  }
  
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("** ")) abort();
      super.parse(field.substring(3).trim(), data);
    }
  }
  
  private class ExtraField extends Field {

    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strTime = field.substring(0,pt).trim();
      pt = field.indexOf(" CT (");
      if (pt >= 0) {
        field = field.substring(pt+5).trim();
        if (field.endsWith(")")) field = field.substring(0,field.length()-1).trim();
        data.strSupp = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "TIME INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("EXTRA")) return new ExtraField();
    return super.getField(name);
  }
}
