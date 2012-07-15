package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/***
Cambridge, MD
Contact:ryan travers <traversboy@gmail.com>
Sender:dor911@docogonet.com
DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC
DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC
DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC
DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC
DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC

Contact: Jeff Lewis <jeff.lewis37@yahoo.com>
Sender: DOR911@docogonet.com
DOR911:CANCEL LAST ALERT AUTH OF ALARM CO 835 :DC\r

***/

public class MDCambridgeParser extends FieldProgramParser {

  public MDCambridgeParser(){
    super(CITY_CODES, "CAMBRIDGE", "MD",
           "CT:ADDR/S0C! BOX:BOX! DUE:UNIT!");
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    
    if (!body.startsWith("DOR911:") ) return false;
    body = body.substring(7).trim();
    if (body.endsWith(":DC")) body = body.substring(0,body.length()-3).trim();
    return super.parseMsg(body, data);
  }
    
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Everything changes if this is a Mutual aid call
      int ipt = field.indexOf(" @MA ");
      if (ipt >= 0) {
        data.strCall = "Mutual Aid: " + field.substring(0, ipt).trim();
        int ipt2 = field.indexOf(':', ipt);
        if (ipt2 < 0) ipt2 = field.length();
        data.strCity = field.substring(ipt+5, ipt2).trim();
        field = field.substring(ipt2+1).trim().replaceAll("@", "");
        parseAddress(field, data);
      }
  
      else {
        super.parse(field, data);
      }
    }
  }
    
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = 
    buildCodeTable(new String[]{
        "CAMB","Cambridge"
  });
}