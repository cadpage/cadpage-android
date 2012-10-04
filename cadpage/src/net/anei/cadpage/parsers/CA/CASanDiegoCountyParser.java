package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * San Diego County, CA
 */
public class CASanDiegoCountyParser extends FieldProgramParser {

  public CASanDiegoCountyParser() {
    super("SAN DIEGO COUNTY", "CA",
           "ALM:PRI! MSTR_INC#:ID! TYP:CALL! ADR:ADDR! LOC:PLACE! SP:APT! TB:MAP! MAP:MAP! XST:X! TG:CH! TIMEDSP:TIME! UNITS:UNIT! TXT:INFO LOC_CMNTS:INFO");
  }

  @Override
  public String getFilter() {
    return "cad@jpapage.net,cad@sdrecc.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD MESSAGE")) return false;
    return parseFields(body.split("\\\\"), data);
  }

  private static final Pattern APT_TITLE_PTN = Pattern.compile("^(?:APT|SUITE|SPT?|RM) *", Pattern.CASE_INSENSITIVE);

  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_TITLE_PTN.matcher(field);
      if (match.find())
        field = field.substring(match.end());
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
      if (field.startsWith("."))
        field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern SKIP_PTN = Pattern.compile("(?:^| *,) *This incident \\d{4}.*$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = SKIP_PTN.matcher(field).replaceAll("");
      super.parse(field, data);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
