package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class NJBergenCountyBParser extends SmartAddressParser {
  public NJBergenCountyBParser() {
    super("BERGEN COUNTY", "NJ");
    setFieldList("ID UNIT CALL ADDR PLACE APT CITY INFO");
  }
  
  @Override
  public String getFilter() {
    return "anyone@ParamusPolice.org";
  }
  
  private static final Pattern SUBJECT_PATTERN
    = Pattern.compile("(I\\-\\d{4}\\-\\d{6})\\s*(.*)");
  private static final Pattern BODY_PATTERN
    = Pattern.compile("\\s*([A-Z]+) +@\\s*(.*?)\\s*,\\s*(.*?)\\s*(?:\\-|$)\\s*(.*)");
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String[] lines;
    String remainder = "";
    Matcher m = SUBJECT_PATTERN.matcher(subject);
    if (m.matches()) {
      data.strCallId = m.group(1);
      parseUnits(m.group(2), data);
    }
    else
      return false;
    lines = body.split("\n");
    m = BODY_PATTERN.matcher(lines[0]);
    if (m.matches()) {
      int l;
      data.strCall = append(m.group(1), " - ", data.strCall);
      parseAddress (m.group(2), data);
      data.strCity = stripFieldEnd(m.group(3), " BORO");
      remainder = m.group(4);
      for (l = 1; l < lines.length; l++)
        remainder = append(remainder, " ", lines[l]);
      parseInfoField(remainder, data);
      return true;
    }
    else
      return false;
  }
  
  static final Pattern UNIT_PATTERN
    = Pattern.compile("(?i)(.*?)(\\(?update\\)?)?(.*)");
  private void parseUnits(String field, Data data) {
    Matcher m = UNIT_PATTERN.matcher(field);
    if (m.matches())
      if (m.group(2) != null) {
        data.strCall = "UPDATE";
        data.strUnit = m.group(1)+m.group(3);
        return;
      }
    data.strUnit = field;
  }
  
  static final Pattern TRAILING_UNIT_PATTERN
    = Pattern.compile("(.*?)(?:Active Units\\:\\s*)?((?i)\\b(?:[ELT]L?\\-?\\d|res(?:c(?:ue)?)?\\b|eng(?:ine) +\\d|haz\\-?mat).*)");
  private void parseInfoField(String field, Data data) {
    Matcher m = TRAILING_UNIT_PATTERN.matcher(field);
    if (m.matches()) {
      data.strSupp = m.group(1).trim();
      data.strUnit = append(data.strUnit, " ", m.group(2).replace(",", " ").replace("  ", " "));
    }
    else
      data.strSupp = field;
  }
}
