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
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  private static final Pattern MARKER = Pattern.compile("^messaging@iamresponding.com \\( *(.*?) *\\) ");
  private static final Pattern MASTER1 = Pattern.compile("/ *(.*?) *\\( *(.*?) *\\) *(?:(\\d{1,2}[A-Z]\\d{1,2}) +)?(.*)");
  private static final Pattern MASTER2 = Pattern.compile("(.*?) *, *(.*?) *\\( *(.*?/.*?) *\\) *(?:(\\d{1,2}[A-Z]\\d{1,2}) +)?(.*)");
  private static final Pattern MASTER3 = Pattern.compile("(.*?) *, *([^\\(\\)]*?) *(\\d{1,2}[A-Z]\\d{1,2}) +(.*)");
  private static final Pattern MASTER4 = Pattern.compile("(.*?) *, *([^\\(\\)]*?) (?:TOWN|VILLAGE) OF +(.*)");
  private static final Pattern MASTER5 = Pattern.compile("(.*?) *\\((.*?)\\) *, *(.*?) +(?:TOWN|VILLAGE)(.*)");
  
  
  private static final Pattern[] TRAILER_PTNS = {
    Pattern.compile("(AVOCA?FDA?|AVOCAFDAMB|ATLANFD|BATHAMB|BRADFD|BTFD|COHOFAM|COHOFD|CATOFD|HAMFD|HOWAFD|WAYLA|WAYNFD|FD)(?::\\d*)*$"),
    Pattern.compile("([A-Z]+)(?::\\d*)+$"),
    Pattern.compile("\n([A-Z]+)$")
  };
  
  private static final Pattern INFO_HEADER = Pattern.compile("^--?\\{(.*)\\}--?");
  
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
	    if (subject.endsWith(" FD")) {
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
      body = body.substring(0,match.start()).trim();
    }
    
    body = body.replace('\n', ' ').replace('\\', '/');
    
    // Check for special information header
    match = INFO_HEADER.matcher(body);
    if (match.find()) {
      data.strSupp = match.group(1);
      body = body.substring(match.end()).trim();
    }
    
    // Check for RECALLED tag
    if (body.startsWith("::::RECALLED:::::: ")) {
      data.strCall = "RECALLED - ";
      body = body.substring(19).trim();
    } else if (subject.equals("2ndCall") || subject.equals("2nd Call")) {
      data.strCall = subject + " - ";
    }
    
    body = body.replace("COUNTY ROUTE", "COUNTY ROAD");
    
    // There a couple basic patterns
    // /<place> (<addr> <city>) [code] <call>
    if ((match = MASTER1.matcher(body)).matches()) {
      parseAddress(match.group(1), data);
      data.strPlace = match.group(1);
      parseAddress(StartType.START_ADDR, match.group(2), data);
      String left = getLeft();
      if (left.startsWith("TOWN OF")) left = left.substring(7).trim();
      else if (left.startsWith("VILLAGE OF")) left = left.substring(10).trim();
      data.strCross = left;
      data.strCode = cleanCode(match.group(3));
      data.strSupp = append(data.strSupp, " / ", match.group(4));
    }
    
    // <addr> , <city> ( <cross> ) [code] <info>
    else if ((match = MASTER2.matcher(body)).matches()) {
      parseAddress(match.group(1), data);
      data.strCity = cleanCity(match.group(2));
      Parser p = new Parser(match.group(3).trim());
      data.strPlace = p.getLastOptional("Near:");
      String cross = "";
      for (String part : p.get().split(",")) {
        part = part.trim();
        if (part.contains("/")) {
          cross = part;
          break;
        } else if (cross.length() == 0) {
          cross = part;
        }
      }
      data.strCross = cleanCross(cross);
      data.strCode = cleanCode(match.group(4));
      data.strSupp = append(data.strSupp, " / ", match.group(5));
    }
    
    // <addr> , <city> <code> <info>
    else if ((match = MASTER3.matcher(body)).matches()) {
      parseAddress(match.group(1), data);
      data.strCity = cleanCity(match.group(2));
      data.strCode = cleanCode(match.group(3));
      data.strSupp = append(data.strSupp, " / ", match.group(4));
    }
    
    // <addr> , <city> <info>
    else if ((match = MASTER4.matcher(body)).matches()) {
      parseAddress(match.group(1), data);
      data.strCity = cleanCity(match.group(2));
      data.strSupp = append(data.strSupp, " / ", match.group(3));
    }
    
    // <addr> ( <cross> ), <city> <info>
    else if ((match = MASTER5.matcher(body)).matches()) {
      parseAddress(match.group(1).trim(), data);
      data.strCross = cleanCross(match.group(2));
      data.strCity = cleanCity(match.group(3).trim());
      data.strSupp = match.group(4).trim();
    }
    
    // Anything else is just a info
    // If we didn't find a matching start signature and didn't find a
    // master pattern match, the we had better conclude that this is not
    // reall a CAD page
    else {
      if (!sigMatch) return false;
      data.strSupp = append(data.strSupp, " / ", body);
    }
    
    if (data.strSupp.length() > 0 && data.strSupp.length() <= 40) {
      data.strCall = data.strCall + data.strSupp;
      data.strSupp = "";
    } else {
      data.strCall = data.strCall + "ALERT";
    }
    return true;
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
    if (field.startsWith("/")) field = field.substring(1).trim();
    if (field.endsWith(";")) field = field.substring(0,field.length()-1).trim();
    if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
    return field;
  }
  
  private String cleanCode(String field) {
    return (field == null ? "" : field);
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
	