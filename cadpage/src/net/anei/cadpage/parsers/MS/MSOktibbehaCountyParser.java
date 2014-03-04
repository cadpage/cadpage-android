package net.anei.cadpage.parsers.MS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class MSOktibbehaCountyParser extends SmartAddressParser {

  public MSOktibbehaCountyParser() {
    super("OKTIBBEHA COUNTY", "MS");
    setFieldList("SRC CODE CALL ID ADDR APT CITY ST INFO");
  }

  private static Pattern SUBJECT = Pattern.compile("(?:([A-Z]{3}) +- +)?(.*?) +- +(.*?) *(\\d{10})(?: +-)? *(.*)");
  private static Pattern BODY = Pattern.compile("(?:(?:There has been a\\(n\\) +)?(.*?) +reported +.*? *at +)?(.*)");
  private static Pattern TRAIL_DELIM = Pattern.compile(" *, *");
  private static Pattern CALL_DELIM = Pattern.compile(" *- *");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    // trail will consist of ADDR CITY ST INFO
    String subjTrail, bodyTrail;

    // try parsing from subject, fail if doesn't match
    Matcher mat = SUBJECT.matcher(subject);
    if (mat.matches()) {
      data.strSource = getOptGroup(mat.group(1));
      String g2 = mat.group(2);
      if (CODE_LIST.contains(g2)) data.strCode = g2;
      else data.strCall = g2;
      data.strCall = append(data.strCall, " - ", mat.group(3));
      data.strCallId = mat.group(4);
      subjTrail = mat.group(5);
    } else return false;

    // parse any unfound info from body and save body's trail
    mat = BODY.matcher(body);
    if (!mat.matches()) return false;  // Can't possibly happen.  But...
    bodyTrail = mat.group(2);
    
    // parse calls from body while excluding redundant fields
    Set<String> subjCallFieldsSet = new HashSet<String>(Arrays.asList(CALL_DELIM.split(data.strCall)));
    String[] bodyCallFields = CALL_DELIM.split(getOptGroup(mat.group(1)));
    for (int c = 0; c < bodyCallFields.length; c++) {
      if (!subjCallFieldsSet.contains(bodyCallFields[c])) data.strCall = append(data.strCall, " - ", bodyCallFields[c]);
    }

    // parse the trailing "addr, city, st, info" construct from subj trail
    String[] subjFields = TRAIL_DELIM.split(subjTrail);
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, subjFields[0].trim(), data);
    if (subjFields.length > 1) {
      int i = 2;
      if (CITY_LIST.contains(subjFields[1].toUpperCase())) data.strCity = subjFields[1];
      else i = 1;
      while (i < subjFields.length) {
        if (!subjFields[i].equals("MS")) data.strSupp = append(data.strSupp, ", ", subjFields[i]);
        i++;
      }
    }

    // try to parse trail fields from body that differ from their subject equivalents
    Set<String> subjFieldsSet = new HashSet<String>(Arrays.asList(subjFields));
    String[] bodyFields = TRAIL_DELIM.split(bodyTrail);
    for (int f = 0; f < bodyFields.length; f++) {
      // check if this comma delimited string was in subjTrail and make sure its not an address
      if (!subjFieldsSet.contains(bodyFields[f]) && checkAddress(bodyFields[f], 3) == 0) {
        data.strSupp = append(data.strSupp, ", ", bodyFields[f]);
      }
    }

    // yay we made it here!
    return true;
  }

  private static Set<String> CITY_LIST = new HashSet<String>(Arrays.asList(
      "MABEN", 
      "STARKVILLE", 
      "STURGIS"
  ));
  
  private static Set<String> CODE_LIST = new HashSet<String>(Arrays.asList(
      "FIREAL", 
      "MED", 
      "MVA", 
      "STRUC"
  ));

}
