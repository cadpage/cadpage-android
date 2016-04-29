package net.anei.cadpage.parsers.WI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.HtmlDecoder;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WIRockCountyParser extends FieldProgramParser {
  
  private HtmlDecoder decoder;

  public WIRockCountyParser() {
    super("ROCK COUNTY", "WI", 
          "Status:STATUS! Inc_#:ID Inc_Type:CODE! Inc_Desc:CALL! Location:ADDR! Cross_Strs:X END");
    decoder = new HtmlDecoder();
  }
  
  @Override
  public String getFilter() {
    return "RCCC@co.rock.wi.us";
  }
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("([A-Z]{2,4})-Active911");
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    String[] flds = decoder.parseHtml(body);
    if (flds == null) return false;
    
    for (int jj = 0; jj<flds.length-1; jj++) {
      if (flds[jj].equals("PremierOne Notification")) {
        return super.parseHtmlMsg(subject, flds[jj+1], data);
      }
    }
    return false;
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    
    return super.parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("STATUS")) return new SkipField("Open", true);
    return super.getField(name);
  }

}
