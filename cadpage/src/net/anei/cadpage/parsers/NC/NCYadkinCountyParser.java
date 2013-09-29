package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class NCYadkinCountyParser extends FieldProgramParser {
  
  public NCYadkinCountyParser() {
    super(CITY_LIST, "YADKIN COUNTY", "NC", "ADDR/SP! X? CODE? CALL! geo:GPS? INFO+");
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " ID";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  public static Pattern ID_EXTRACTOR = Pattern.compile("(.*?) *OCA: *(\\d{7})");
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    //fix weird subjectless formatting that occurs ~25% of the time
    int pi = subject.indexOf("Text Message");
    if (pi < 0 && subject.length() > 0) {
      body = subject + ":" + body;
      subject = "";
    }
        
    //remove OCA: blah and pass blah to callID
    Matcher idMat = ID_EXTRACTOR.matcher(body);
    if (idMat.matches()) {
      body = idMat.group(1);
      data.strCallId = idMat.group(2);
    }

    if (!parseFields(body.split(";"), data)) return false;
    if (data.strCity.equalsIgnoreCase("BOONEVILLE")) data.strCity = "BOONVILLE";
    return true;
  }
  
  @Override public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CODE")) return new CodeField("[MF]DL +(.*)", true);
    return super.getField(name);
  }
  
  public static Pattern CROSS_CLEANUP = Pattern.compile("\\*(.*?) \\(Verify\\)(.*?)\\*(.*?) \\(Verify\\)");
  private class MyCrossField extends CrossField {
    public MyCrossField() {
      super("(?:.* X .*)?(?:^X .*)?", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      int pi = field.indexOf("X ");
      if (pi == 0) field = field.substring(2);
      //get rid of *....... (Verify) formatting
      Matcher mat = CROSS_CLEANUP.matcher(field);
      if (mat.matches()) field = mat.group(1) + mat.group(2) + mat.group(3);
      super.parse(field.replace(" X ", " / "), data);
    }
  }
  
  public static String[] CITY_LIST = new String[]{
    "BOONEVILLE",
    "BOONVILLE",
    "EAST BEND",
    "JONESVILLE",
    "SURRY",
    "YADKINVILLE"
  };

}