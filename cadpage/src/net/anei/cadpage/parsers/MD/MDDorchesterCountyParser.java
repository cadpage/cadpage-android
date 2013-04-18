package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MDDorchesterCountyParser extends FieldProgramParser {

  public MDDorchesterCountyParser(){
    super(CITY_CODE_TABLE, "DORCHESTER COUNTY", "MD",
           "CT:ADDR/S0C! BOX:BOX! DUE:UNIT!");
    addNauticalTerms();
  }
  
  public String getFilter() {
    return "dor911@docogonet.com";
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("DOR911:")) body = body.substring(7).trim();
    if (body.endsWith(":DC")) body = body.substring(0,body.length()-3).trim();
    return super.parseMsg(body, data);
  }
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
        "CAMB", "CAMBRIDGE",
        "CHUR", "CHURCH CREEK",
        "HURL", "HURLOCK",
        "SECR", "SECRETARY"
    });
}