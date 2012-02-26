package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Portage County, OH
Contact: Joseph L Corbin Jr <jcorbinjr@gmail.com>
Sender: 911@ci.ravenna.oh.us
System: Sundance
*
911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY *\n3594,INDRUSTRY RD, * ,ROOTSTOWN * 89YOA MALE OXYGEN MACHINE BROKEN,\nTROU
911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 4265,ROCK SPRING RD, * ,Ravenna * 53 YR OLD MALE DIFFICULTY BREATHING, PO
911@ci.ravenna.oh.us:* 15_edinburg_generalMA,MUTUAL AID * 0,PALMYRA TOWNSHIP [EDIT], * PALMYRA,Ravenna * 1511 TO MEET 2011 AT STATION 20
911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 7824,TALLMADGE RD, * ,Ravenna * 80 YOA FEMALE CHEST PAINS﻿
911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 4174,PORTER RD , * ,EDINBURG TWP * FEMALE VERY LIGHT HEADED﻿
911@ci.ravenna.oh.us:* 15_edinburg_general29,MEDICAL EMERGENCY * 3594,INDUSTRY RD, * ,ROOTSTOWN * 89 YOA MALE FALLEN
911@ci.ravenna.oh.us:* 15_edinburg_general28,FIRE * 4907,ROCK SPRING RD, * ,Ravenna * CHIMNEY FIRE﻿

 */


public class OHPortageCountyParser extends FieldProgramParser {
  
  public OHPortageCountyParser() {
    super("PORTAGE", "OH",
           "CALL ADDR CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911@ci.ravenna.oh.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("* ")) return false;
    body = body.substring(2).replace('\n', ' ').trim();
    return parseFields(body.split("\\*"), data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt < 0) abort();
      super.parse(field.substring(pt+1).trim(), data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(',', ' ').trim();
      if (field.startsWith("0 ")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(',', ' ').trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
}
