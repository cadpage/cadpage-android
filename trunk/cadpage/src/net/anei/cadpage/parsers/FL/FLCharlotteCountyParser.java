package net.anei.cadpage.parsers.FL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA24Parser;


/**
 * Charlotte County, FL
 */
public class FLCharlotteCountyParser extends DispatchA24Parser {
  
  public FLCharlotteCountyParser() {
    super("CHARLOTTE COUNTY", "FL");
  }
  
  @Override
  public String getFilter() {
    return "administrator@ccsofl.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CCSO FIRE CALL")) return false;
    return parseMsg(body, data);
  }
  
  private static final Pattern INFO_BRACKET_PTN = Pattern.compile(" *(?:\\[[^\\]]*\\] *| *\\.{2,} *|  +)+");
  private static final Pattern SKIP_PTN = Pattern.compile("^\\(Cloned from.*?\\) *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      for (String fld : INFO_BRACKET_PTN.split(field)) {
        fld = SKIP_PTN.matcher(fld).replaceAll("");
        if (fld.startsWith("Cross streets:")) {
          String cross = fld.substring(14).trim().replace("//", "/");
          if (cross.endsWith("/")) cross = cross.substring(0,cross.length()-1).trim();
          data.strCross = append(data.strCross, "/", cross);
        }
        else if (fld.startsWith("Landmark:")) {
          fld = fld.substring(9).trim();
          addPlace(fld, data);
        }
        else if (fld.startsWith("NBH:")) {
          fld = fld.substring(4).trim();
          addPlace(fld, data);
        }
        else {
          if (fld.startsWith("Landmark Comment:")) fld = fld.substring(17).trim();
          else if (fld.startsWith("Geo Comment:")) fld = fld.substring(12).trim();
          if (fld.endsWith(",") || fld.endsWith(".")) fld = fld.substring(0,fld.length()-1).trim();
          data.strSupp = append(data.strSupp, " / ", fld);
        }
      }
    }
    
    private void addPlace(String place, Data data) {
      if (data.strPlace.contains(place)) return;
      data.strPlace = append(data.strPlace, " - ", place);
    }
    
    @Override
    public String getFieldNames() {
      return "X PLACE INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
