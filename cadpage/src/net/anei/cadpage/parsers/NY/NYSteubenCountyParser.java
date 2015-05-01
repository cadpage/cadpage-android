package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Steuben County, NY
 */
public class NYSteubenCountyParser extends SmartAddressParser {
  
  public NYSteubenCountyParser() {
    super(CITY_LIST, "STEUBEN COUNTY", "NY");
    setFieldList("SRC PLACE ADDR APT CITY ST X CODE CALL INFO ID");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  private static final Pattern MARKER = Pattern.compile("^messaging@iamresponding.com \\( *(.*?) *\\) ");
  private static final Pattern SUBJECT_PTN = Pattern.compile(".* FD|SC911");
  
  private static final Pattern[] TRAILER_PTNS = {
    Pattern.compile("(AVOCA?FDA?|AVOCAFDAMB|ATLANFD|BATHAMB|BRADFD|BTFD|COHOFAM|COHOFD|CATOFD|HAMFD|HOWAFD|KANOFD|TUSCAFD|WAYLA|WAYNE?FD|FD):([:\\d]*)$"),
    Pattern.compile("([A-Z]+):([:\\d]*)$"),
    Pattern.compile("\n([A-Z]+)()$")
  };
  
  private static final Pattern INFO_HEADER = Pattern.compile("^--?\\{\\[?(.*?)\\]?\\}--?");
  private static final Pattern MASTER1 = Pattern.compile("/ *(.*?) \\((.*?)\\)(?:, +([ A-Z]+) (?:TOWN|VILLAGE)(?: OF)?)?/?(.*)");
  private static final Pattern PAREN_PTN = Pattern.compile("\\((?!CVA)([^a-z]*?|.*; Near:.*)\\)");
  private static final Pattern MASTER6 = Pattern.compile("(.*?) T/(NELSON)(.*)");
  
  private static final Pattern CODE_PTN = Pattern.compile("(\\d{1,2}[A-Z]\\d{1,2}[A-Z]?)[- ]+");
  private static final Pattern CITY_PTN = Pattern.compile(", ([ A-Z]+) (?:TOWN|VILLAGE)(?: OF)?/?");
  
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) { 

    // There are a couple different text signatures we look for
    boolean sigMatch = true;
    Matcher match;
    do {
	    // Look for starting page signature
	    match = MARKER.matcher(body);
	    if (match.find()) {
	      data.strSource = match.group(1);
	      body = body.substring(match.end()).trim();
	      break;
	    }
	    
	    // Sometimes the starting sender address is missing, which means the
	    // station code ends up in the description
	    if (SUBJECT_PTN.matcher(subject).matches()) {
	      data.strSource = subject;
	      break;
	    }
	    
	    // Nothing worked, we will keep trying, but will have a much stricter 
	    // standard of what constitutes a CAD page
	    sigMatch = false;
    } while (false);

    // If we found a start signature match, which included a station source
    // Look for and remove any trailing station and call ID
    boolean found = false;
    for (Pattern ptn : TRAILER_PTNS) {
      match = ptn.matcher(body);
      found = match.find();
      if (found) break;
    }
    if (found) {
      if (data.strSource.length() == 0) data.strSource = match.group(1);
      data.strCallId = match.group(2);
      body = body.substring(0,match.start()).trim();
    }
    
    body = body.replace('\n', ' ').replace('\\', '/');
    
    // Check for special information header
    match = INFO_HEADER.matcher(body);
    if (match.find()) {
      data.strCall = match.group(1) + " - ";
      body = body.substring(match.end()).trim();
    }
    
    // Check for RECALLED tag
    else if (body.startsWith("::::RECALLED:::::: ")) {
      data.strCall = "RECALLED - ";
      body = body.substring(19).trim();
    } else if (subject.equals("2ndCall") || subject.equals("2nd Call")) {
      data.strCall = subject + " - ";
    }
    
    body = body.replace("COUNTY ROUTE", "COUNTY ROAD");
    
    // There a couple basic patterns
    // /<place> (<addr> <city> [cross]) [code] <call>
    // /<place> (<addr>), <city> [code] <call>
    String info;
    if ((match = MASTER1.matcher(body)).matches()) {
      data.strPlace = match.group(1).trim();
      String addr = match.group(2);
      data.strCity = getOptGroup(match.group(3));
      info = match.group(4).trim();
      
      if (data.strCity.length() > 0) {
        parseAddress(addr, data);
      } else {
        parseAddress(StartType.START_ADDR, addr, data);
        data.strCross = cleanCross(cleanLeft(getLeft()));
      }
    }
    
    // for all othe patterns, parens can occur anywhere and
    // always enclose cross streets
    else {
      while ((match = PAREN_PTN.matcher(body)).find()) {
        String cross = match.group(1).trim();
        body = body.substring(0,match.start()).trim() + " " + body.substring(match.end()).trim();
        body = body.trim();
        
        int pt = cross.indexOf("; Near:");
        if (pt >= 0) {
          data.strPlace = append(data.strPlace, " - ", cross.substring(pt+2));
          cross = cross.substring(0,pt).trim();
        }
        data.strCross = append(data.strCross, ", ", cleanCross(cross));
      }
      
      // <addr>, <city> <info>
      match = CITY_PTN.matcher(body);
      if (match.find()) {
        parseAddress(body.substring(0,match.start()).trim(), data);
        data.strCity =  match.group(1).trim();
        info = body.substring(match.end()).trim();
      }
      
      // <addr> T/<city> <info>
      else if ((match = MASTER6.matcher(body)).matches()) {
        parseAddress(match.group(1).trim(), data);
        data.strCity = match.group(2);
        info = match.group(3).trim();
      }
      
      // Anything else is just a info
      // If we didn't find a matching start signature and didn't find a
      // master pattern match, the we had better conclude that this is not
      // real a CAD page
      else {
        if (!sigMatch) return false;
        data.strSupp = append(data.strSupp, " / ", body);
        info = "";
      }
    }
    
    // See if there is another city in the rest of the information, even
    // if we have already found one city
    match = CITY_PTN.matcher(info);
    if (match.find()) {
      data.strSupp = append(data.strSupp, " / ", info.substring(0,match.start()).trim());
      data.strCity = match.group(1);
      info = info.substring(match.end()).trim();
    }
    
    // See if there is a code in what we picked out as info
    match = CODE_PTN.matcher(info);
    if (match.lookingAt()) {
      data.strCode = match.group(1);
      info = info.substring(match.end());
    }
    
    if (info.length() > 0 && info.length() <= 40) {
      data.strCall = data.strCall + info;
    } else {
      data.strCall = data.strCall + "ALERT";
      data.strSupp = append(data.strSupp, " ", info);
    }
    
    if (data.strCity.equalsIgnoreCase("NELSON")) data.strState = "PA";
    return true;
  }

  protected String cleanLeft(String left) {
    if (left.startsWith("TOWN OF")) left = left.substring(7).trim();
    else if (left.startsWith("VILLAGE OF")) left = left.substring(10).trim();
    return left;
  }

  private String cleanCity(String field) {
    if (field.endsWith(" TOWN OF")) {
      field = field.substring(0, field.length()-8).trim();
    } else if (field.endsWith(" TOWN")) {
      field = field.substring(0,field.length()-5).trim();
    } else if (field.endsWith(" VILLAGE OF")) {
      field = field.substring(0, field.length()-11);
    }
    return field;
  }

  private String cleanCross(String field) {
    field = stripFieldStart(field, "/");
    field = stripFieldEnd(field, "/");
    field = stripFieldEnd(field, ";");
    return field;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ADDISON",
    "ALMOND",
    "ARKPORT",
    "AVOCA",
    "BATH",
    "BRADFORD",
    "CAMERON",
    "CAMPBELL",
    "CANISTEO",
    "CANISTEO",
    "CATON",
    "COHOCTON",
    "CORNING",
    "DANSVILLE",
    "ERWIN",
    "FREMONT",
    "GANG MILLS",
    "GREENWOOD",
    "HAMMONDSPORT",
    "HARTSVILLE",
    "HORNBY",
    "HORNELL",
    "HORNELLSVILLE",
    "HOWARD",
    "JASPER",
    "LINDLEY",
    "NORTH HORNELL",
    "PAINTED POST",
    "PRATTSBURGH",
    "PULTENEY",
    "RATHBONE",
    "RIVERSIDE",
    "STEPHENS MILLS",
    "SAVONA",
    "SOUTH CORNING",
    "THURSTON",
    "TROUPSBURG",
    "TUSCARORA",
    "URBANA",
    "WAYLAND",
    "WAYNE",
    "WEST UNION",
    "WHEELER",
    "WOODHULL"
  };
}
	