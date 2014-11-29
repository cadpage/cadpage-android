package net.anei.cadpage.parsers.NJ;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Sussex County, NJ
 */
public class NJSussexCountyCParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[A-Z]{3,4}");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  
  public NJSussexCountyCParser() {
    super("SUSSEX COUNTY", "NJ",
           "ID DATETIME ADDR CALL! Notes:INFO");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@vernonpolice.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (SUBJECT_PTN.matcher(subject).matches()) data.strSource = subject;
    return parseFields(body.split("\n"), 4, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{2}-\\d{5}", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d\\d?:\\d\\d:\\d\\d [AP]M", DATE_TIME_FMT, true);
    return super.getField(name);
  }
}
