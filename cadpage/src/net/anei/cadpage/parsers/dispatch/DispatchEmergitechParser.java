package net.anei.cadpage.parsers.dispatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchEmergitechParser extends FieldProgramParser {
  
  private static final String UNIT_PTN = "\\[([-A-Z0-9]+)\\]- ";
  private static final Pattern COMMENTS_PTN = Pattern.compile("/?C ?O ?M ?M ?E ?N ?T ?S ?:");
  
  private Pattern markerPattern;
  int[] extraSpacePosList;
  private Set<String> specialWordSet = new HashSet<String>(Arrays.asList(new String[]{
      "APPLE",
      "EAST",
      "MAIN",
      "MARKET",
      "NORTH",
      "SOUTH",
      "WEST"
  }));
  
  
  /** 
   * Constructor
   * @param prefix Prefix that must be found at beginning of text page<br/>
   * An empty string means that no prefix value is expected<br/>
   * A null string means no prefix value is expected, and the following unit field is optional
   * @param extraSpacePos Single extra blank column<br/>
   * Positive values of offsets from beginning of message<br/>
   * Negative values are offsets from beginning of address field 
   * @param cityList list of cities
   * @param defCity default city
   * @param defState default state
   */
  public DispatchEmergitechParser(String prefix, int extraSpacePos,
                                   String[] cityList, String defCity, String defState) {
    this(prefix, new int[]{extraSpacePos}, cityList, defCity, defState);
  }
  
  /** 
   * Constructor
   * @param prefix Prefix that must be found at beginning of text page<br/>
   * An empty string means that no prefix value is expected<br/>
   * A null string means no prefix value is expected, and the following unit field is optional
   * @param extraSpacePos1 Single extra blank column<br/>
   * Positive values of offsets from beginning of message<br/>
   * Negative values are offsets from beginning of address field 
   * @param extraSpacePos2 Single extra blank column<br/>
   * Positive values of offsets from beginning of message<br/>
   * Negative values are offsets from beginning of address field 
   * @param cityList list of cities
   * @param defCity default city
   * @param defState default state
   */
  public DispatchEmergitechParser(String prefix, int extraSpacePos1, int extraSpacePos2, 
                                   String[] cityList, String defCity, String defState) {
    this(prefix, new int[]{extraSpacePos1, extraSpacePos2}, cityList, defCity, defState);
  }
  
  /** 
   * Constructor
   * @param prefix Prefix that must be found at beginning of text page<br/>
   * An empty string means that no prefix value is expected<br/>
   * A null string means no prefix value is expected, and the following unit field is optional
   * @param extraSpacePosList Array of extra blank columns<br/>
   * Positive values of offsets from beginning of message<br/>
   * Negative values are offsets from beginning of address field 
   * @param cityList list of cities
   * @param defCity default city
   * @param defState default state
   */
  public DispatchEmergitechParser(String prefix, int[] extraSpacePosList,
                           String[] cityList, String defCity, String defState) {

    // An empty prefix just means no prefix is expected
    // a null prefix means no prefix is expected and the entire unit block is optional
    this(prefix == null ? "" : prefix
        , prefix == null, extraSpacePosList, cityList, defCity, defState);
  }
  
  /** 
   * Primary constructor
   * @param prefix Prefix that must be found at beginning of text page
   * @param optUnit True if unit field following prefix is optional
   * @param extraSpacePosList Array of extra blank columns<br/>
   * Positive values of offsets from beginning of message<br/>
   * Negative values are offsets from beginning of address field 
   * @param cityList list of cities
   * @param defCity default city
   * @param defState default state
   */
  public DispatchEmergitechParser(String prefix, boolean optUnit, int[] extraSpacePosList,
                          String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "NATURE:CALL? LOCATION:ADDR/SPN! BETWEEN:X? COMMENTS:INFO");
    
    if (!optUnit) {
      markerPattern = Pattern.compile("^" + prefix + UNIT_PTN);
    } else {
      markerPattern = Pattern.compile("^" + prefix + "(?:" + UNIT_PTN + ")?");
    }
    this.extraSpacePosList = extraSpacePosList;
  }
  
  /**
   * Add words and names to special list of words that we do not always recognize
   * when they are split by an extraneous blank.  This happens one one of the terms
   * on either side of the split happens to be a recognizable word.  Usually one
   * of the ordinal directions
   * @param words list of words to be added
   */
  protected void addSpecialWords(String ... words) {
    for (String word : words) {
      specialWordSet.add(word);
    }
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = markerPattern.matcher(body);
    if (!match.find()) return false;
    String unit = match.group(1);
    if (unit != null) data.strUnit = unit;
    
    // There are usually 2 extraneous blanks.  The first one tends to fall in the
    // address field and we will spend a lot of time trying to excise it.  The
    // second tends to fall in the cross street or comment fields, where an extra
    // blank isn't that critical.  We will, however, try to rebuild a COMMENTS:
    // keyword that has been split
    body = COMMENTS_PTN.matcher(body).replaceFirst("COMMENTS:");
    body = body.replace(" /LOCATION:", " LOCATION:");
    
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
    
    // Get the words in front of and behind the blank
    int pt = field.lastIndexOf(' ', pos-1);
    if (pt < 0) pt = -1;
    String word1 = field.substring(pt+1,pos);
    
    pt = field.indexOf(' ', pos+1);
    if (pt < 0) pt = field.length();
    String word2 = field.substring(pos+1,pt);

    // Next we are going to make a number of tests to confirm that the space
    // should or should not be removed
    // But first see if the combined workd is in our special word set.  if it
    // is, we are going to change it and can skip the other checking
    if (!isWord(word1+word2)) {
        
      // If we did not find it there, see with either the  least or trail word
      // is a recognized dictionary word.  If it is, don't change anything
      if (isWord(word1) || isWord(word2)) return field;
      
      // if one, but not both, of the words contain only numeric digits
      // don't change anything
      if (NUMERIC.matcher(word1).matches() ^ NUMERIC.matcher(word2).matches()) return field;
    }
   
    // Otherwise, assume this is an extraneous blank and remove it
    field = field.substring(0,pos) + field.substring(pos+1);
    return field;
  }
  
  /**
   * Determine if word is a recognized word, meaning it in either our special word list
   * or the smart address dictionary.
   * @param word word to be checked
   * @return true if word is a recognized word
   */
  private boolean isWord(String word) {
    return specialWordSet.contains(word) || isDictionaryWord(word);
  }
}
