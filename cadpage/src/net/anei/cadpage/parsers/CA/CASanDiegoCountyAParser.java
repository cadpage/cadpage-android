package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * San Diego County, CA
 */
public class CASanDiegoCountyAParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("INFO:.*\\\\DISP:.*");

  public CASanDiegoCountyAParser() {
    super("SAN DIEGO COUNTY", "CA",
           "( ADVISE ALRM:PRI! TYP:CALL! ADDR:ADDR! LOC:PLACE! APT-SP:APT% XST:X% TIMEDSP:TIME% UNITS:UNIT% | " +
             "ALM:PRI? MSTR_INC#:ID? TYP:CALL! ADR:ADDR! LOC:PLACE! XST:X? SP:APT% TB:MAP% MAP:MAP% TG:CH% TIMEDSP:TIME? UNITS:UNIT INFO+ LOC_CMNTS:INFO+ )");
  }

  @Override
  public String getFilter() {
    return "cad@jpapage.net,cad@sdrecc.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals("CAD MESSAGE")) break;
      
      if (body.startsWith("/ CAD MESSAGE / ")) {
        body = body.substring(16).trim();
        break;
      }
      
      return false;
    } while (false);
    
    if (RUN_REPORT_PTN.matcher(body).matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    return parseFields(body.split("\\\\"), data);
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADVISE")) return new MyAdvisePageField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyAdvisePageField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.equals("***ADVISORY PAGE***")) return false;
      data.strCall = "ADVISORY";
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private static final Pattern APT_TITLE_PTN = Pattern.compile("^(?:APT|SUITE|SPT?|RM) *", Pattern.CASE_INSENSITIVE);
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_TITLE_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end());
      super.parse(field, data);
    }
  }

  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }

  private class MyChannelField extends ChannelField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, ".");
      super.parse(field, data);
    }
  }

  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field, ",");
      super.parse(field, data);
    }
  }
  
  private static final Pattern SKIP_PTN = Pattern.compile("(?:^| *,) *This incident \\d{4}.*$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "TXT:[1]");
      field = SKIP_PTN.matcher(field).replaceAll("");
      super.parse(field, data);
    }
  }

}
