package net.anei.cadpage.parsers.LA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Ascension Parish, LA
 */
public class LAAscensionParishParser extends FieldProgramParser {
  
  
  public LAAscensionParishParser() {
    super("ASCENSION PARISH", "LA",
          "ID! Call_Type:CALL! Nature_of_Call:INFO! Date/Time:DATETIME! Address:ADDRCITY! PLACE Location_Info:INFO/N! Cross_Streets:X! Adtl_Loc_Info:INFO? Quadrant:MAP Assigned_Units:UNIT Radio_Channel:CH? Narrative:INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ascensionsheriff.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    return super.parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("Incident No. *(\\d{4}-\\d{8}|\\d*)(?: +\\(.*\\))?", true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) *(\\d{1,2}:\\d{2}:\\d{2} [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
    }
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("@", "&");
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      field = field.replace(", ", " / ");
      super.parse(field, data);
    }
  }
}
