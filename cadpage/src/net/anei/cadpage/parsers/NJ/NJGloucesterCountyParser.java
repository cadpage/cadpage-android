package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Gloucester County, NJ
Contact: Rich Danner <richdanner@comcast.net>
Sender: alert_@private.gloucesteralert.com

Sta:23-1\nType:MVC\nLoc:233 N MAIN ST\nVen:HARRISON\nDsp-07:56:31\nClr- 
Sta:23-1\nType:SEIZ\nLoc:143 SALVATORE DR\nVen:HARRISON\nDsp-15:26:16\nClr- 
Sta:23-1\nType:DWEL\nLoc:296 WESTBROOK DR\nVen:WOOLWICH\nDsp-08:16:44\nClr- 
Sta:23-1\nType:MVC\nLoc:203 N MAIN ST\nVen:HARRISON\nDsp-09:34:52\nClr- 
Sta:23-1\nType:MVC\nLoc:203 N MAIN ST\nVen:HARRISON\nDsp-09:34:52\nClr- 
Sta:23-1\nType:ALRM\nLoc:7 FERRELL RD APT A\nVen:S\nDsp-14:55:22\nClr- 
Sta:23-1\nType:BRSH\nLoc:54 VESTRY RD\nVen:S\nDsp-12:40:42\nClr- 
Sta:23-1\nType:FALL\nLoc:115 FRANKLIN DR\nVen:HARRISON\nDsp-16:01:31\nClr- 
Sta:23-1\nType:BRSH\nLoc:49 TURTLE CREEK DR\nVen:HARRISON\nDsp-\nClr- 
Sta:23-1\nType:MVC\nLoc:2227 RT 322\nVen:WOOLWICH\nDsp-11:25:11\nClr- 
Sta:23-1\nType:MVC\nLoc:TOMLIN STATION RD\nVen:HARRISON\nDsp-17:31:56\nClr- 

Contact: Michael Carestio <mcarestio81@gmail.com>
(#265339) Dispatch\n\nSta:8-1\nType:MVCC\nLoc:HESSIAN AVE\nVen:NATNL\nDsp-17:33:46\nClr-
(#264149) Dispatch\n\nSta:8-1\nType:DWEL\nLoc:817 ASBURY AVE\nVen:NATNL\nDsp-\nClr-
(#266773) Dispatch\n\nSta:8-1\nType:ALRM\nLoc:518 SIMPSON AVE\nVen:NATNL\nDsp-\nClr-

Contact: mostwanted4tec <mostwanted4tec@gmail.com>
Subject:1/2\n\nDispatch\n\nSta:43-2\n\nType:SERV\n\nLoc:751 LINCOLN AVE               \n\nVen:FRANKLIN\n\nDsp-17:28:02\5s\n\nClr-

Contact: Tom <bad69shovel@yahoo.com>
Dispatch\nSta:28-3\nType:ALRM\nLoc:158 KENTON AVE                \nVen:PITMAN\nDsp-\nClr-

Contact: orders@coasttocoastoutlet.com
Sender: 777155668218
COUNTY OF GLOUCESTER (#353519) Dispatch\n\nSta:10-2\nType:ALRM\nLoc:5 BELMONT BLVD\                \nVen:WASHINGTON\nDsp-\nClr- STOP

Contact: John Godish <jg10306@gmail.com>
Sender: 777146881581
COUNTY OF GLOUCESTER (#353135) Dispatch\n\nSta:10-3\nType:ALRM\nLoc:5600 BLACK HORSE PIKE         \nVen:WASHINGTON\nDsp-04:11:36     \nClr- STOP

Contact: Richard Harris <rwh037@gmail.com>,"rwh037@verizon.net" <rwh037@verizon.net>
Sender: 777
Sta:6-3\nType:RSQM\nLoc:1719 FRONT ST                 \nVen:W-DEPTFORD\nDsp-18:53:53     \nClr- STOP
Sta:6-3\nType:MVCC\nLoc:RT 45                         \nVen:W-DEPTFORD\nDsp-\nClr- STOP
Sta:6-3\nType:BRSH\nLoc:1762 THIRD ST                 \nVen:W-DEPTFORD\nDsp-19:54:13     \nClr- STOP
*/


public class NJGloucesterCountyParser extends FieldProgramParser {
  
  public NJGloucesterCountyParser() {
    super(CITY_CODES, "GLOUCESTER COUNTY", "NJ",
        "Sta:SRC! Type:CALL! Loc:ADDR! Ven:CITY! TIME");
  }
 
  @Override
  public String getFilter() {
    return "@private.gloucesteralert.com,7771";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('\\');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern TIME_PTN = Pattern.compile("Dsp-(\\d\\d:\\d\\d:\\d\\d)");
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_PTN.matcher(field);
      if (!match.matches()) return;
      super.parse(match.group(1), data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "DEPTFORD", "DEPFORD TWP",
      "EAST GREENWICH", "E GREENWICH TWP",
      "ELK", "ELK TWP",
      "FRANKLIN", "FRANKLIN TWP",
      "HARRISON", "HARRISON TWP",
      "LOGAN", "LOGAN TWP",
      "MANTUA", "MANTUA TWP",
      "MONROE", "MONROE TWP",
      "NATNL", "NATIONAL PARK",
      "S", "S HARRISON TWP",
      "WASHINGTON", "WASHINGTON TWP",
      "WEST DEPTFORD", "W DEPTFORD TWP",
      "W-DEPTFORD", "W DEPTFORD TWP",
      "WOOLWICH", "WOOLWICH TWP",
      "WOODBRYHGT", "WOODBURY HEIGHTS"
  });
}
