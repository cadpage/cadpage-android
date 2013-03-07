package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchEmergitechParser extends FieldProgramParser {
  
  private static final Pattern COMMENTS_PTN = Pattern.compile("C ?O ?M ?M ?E ?N ?T ?S ?:");
  
  private Pattern markerPattern;
  int[] extraSpacePosList;
  
  public DispatchEmergitechParser(String prefix, int extraSpacePos,
                                   String[] cityList, String defCity, String defState) {
    this(prefix, new int[]{extraSpacePos}, cityList, defCity, defState);
  }
  
  public DispatchEmergitechParser(String prefix, int extraSpacePos1, int extraSpacePos2, 
                                   String[] cityList, String defCity, String defState) {
    this(prefix, new int[]{extraSpacePos1, extraSpacePos2}, cityList, defCity, defState);
  }
  
  public DispatchEmergitechParser(String prefix, int[] extraSpacePosList,
                           String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "NATURE:CALL? LOCATION:ADDR/SPN! BETWEEN:X? COMMENTS:INFO");
    markerPattern = Pattern.compile("^" + prefix + "\\[([A-Z0-9]+)\\]- ");
    this.extraSpacePosList = extraSpacePosList;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = markerPattern.matcher(body);
    if (!match.find()) return false;
    data.strUnit = match.group(1);
    
    // There are usually 2 extraneous blanks.  The first one tends to fall in the
    // address field and we will spend a lot of time trying to excise it.  The
    // second tends to fall in the cross street or comment fields, where an extra
    // blank isn't that critical.  We will, however, try to rebuild a COMMENTS:
    // keyword that has been split
    body = COMMENTS_PTN.matcher(body).replaceFirst("COMMENTS:");
    
    // If extraSpacePos is positive, the extraneous blank is found in a fixed
    // position relative to the message text.  Also check for keywords that
    // might get split with one side looking like a real word
    if (extraSpacePosList != null) {
      for (int extraSpacePos : extraSpacePosList) {
        int oldLen = body.length();
        if (extraSpacePos >= 0) {
          body = removeBlank(extraSpacePos, body);
        } else {
          int ndx = body.indexOf(" LOCATION:");
          if (ndx >= 0) {
            ndx += 10;
            while (ndx < body.length() && body.charAt(ndx) == ' ') ndx++;
            body = removeBlank(ndx - extraSpacePos, body);
          }
        }
        if (body.length() != oldLen) break;
      }
      body = body.replace(" CO MMENTS:", " COMMENTS:");
    }
    
    // Carry on with more normal adjustments
    body = body.substring(match.end()).trim().replace(" BETWEEN ", " BETWEEN: ");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
      if (data.strCall.length() == 0) return false;
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }

  /**
   * This method has the unenviable job of remove a extraneous blank that the
   * message service insists on putting in a a fixed position in the string
   * @param pos fixed field position where blank may be inserted
   * @param field field which has the inserted blank
   * @return field with extraneous blank removed
   */
  private String removeBlank(int pos, String field) {
    
    // If field doesn't extend position, or character in that position is
    // not a blank, we don't have to do anything.
    if (field.length() <= pos || field.charAt(pos) != ' ') return field;
   
    // Get the word in front of this blank, if it is a recognized dictionary
    // word, don't mess with it
    int pt = field.lastIndexOf(' ', pos-1);
    if (pt < 0) pt = -1;
    String word = field.substring(pt+1,pos);
    if (isDictionaryWord(word)) return field;
    boolean numeric = NUMERIC.matcher(word).matches();
   
    // Ditto for word in back of this blank
    pt = field.indexOf(' ', pos+1);
    if (pt < 0) pt = field.length();
    word = field.substring(pos+1,pt);
    if (isDictionaryWord(word)) return field;
    
    // if one, but not both, of the words contain only numeric digits
    // don't change anything
    if (NUMERIC.matcher(word).matches()) numeric = !numeric;
    if (numeric) return field;
   
    // Otherwise, assume this is an extraneous blank and remove it
    field = field.substring(0,pos) + field.substring(pos+1);
    return field;
  }
}
