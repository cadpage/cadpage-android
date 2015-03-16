package net.anei.cadpage.parsers.PA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/**
 * Adams County, PA
 */
public class PAAdamsCountyAParser extends DispatchA1Parser {
  
  private static final Pattern IAMR_PREFIX1 = Pattern.compile("^(?:Alert: +)?(.*?)[ \n](?=ALRM LVL:|: +BOX )");
  private static final Pattern IAMR_BOX_PTN = Pattern.compile("[, ] +BOX ");
  private static final Pattern IAMR_COMMA_PTN = Pattern.compile("[ ,]*\n[ ,]*");
  
  public PAAdamsCountyAParser() {
    super("ADAMS COUNTY", "PA");
  }

  @Override
  public String getFilter() {
    return "adams911@adamscounty.us,messaging@iamresponding.com,777";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Check for garbled prefix associated with IamResponding
    Matcher match = IAMR_PREFIX1.matcher(body);
    if (match.lookingAt()) {
      data.strSource = subject;
      subject = "Alert: " + match.group(1).trim();
      body = body.substring(match.end()).trim();
      if (body.startsWith(":")) {
        body = "RUN CARD:" + body.substring(1);
      } else {
        body = IAMR_BOX_PTN.matcher(body).replaceFirst(", RUN CARD: BOX ");
      }
      body = IAMR_COMMA_PTN.matcher(body).replaceAll("\n");
      body = body.replaceAll(" , ", " ");
    }
    
    if (!super.parseMsg(subject, body, data)) return false;
    
    String city = data.strCity.toUpperCase();
    city = stripFieldEnd(city, " BORO");
    city = convertCodes(city, MISTYPED_CITIES);
    if (city.endsWith(" CO")) city += "UNTY";
    data.strCity = city;
    if (MD_CITIES.contains(city)) data.strState = "MD";
    
    data.strSupp = data.strSupp.replace(" / ", "\n");
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram().replace("CITY", "CITY ST");
  }
  
  private static final Properties MISTYPED_CITIES = buildCodeTable(new String[]{       
    "CICKINSON TWP",   "DICKINSON TWP",  
    "EMITTSBURG",      "EMMITSBURG",
    "EMMITTSBURG",     "EMMITSBURG",
    "EMTTISBURG",      "EMMITSBURG",
    "GILFORD TWP",     "GUILFORD TWP",
    "GREEN TWP",       "GREENE TWP",
    "HEIDELBURG TWP",  "HEIDELBERG TWP",
    "MOUNT ALTO",      "MONT ALTO",
    "QUINCEY TWP",     "QUINCY TWP"
  });
  
  private static final Set<String> MD_CITIES = new HashSet<String>(Arrays.asList(
    "CARROLL COUNTY",
      "TANEYTOWN",
      "WESTMINSTER",
      "MANCHESTER",
      "NEW WINDSOR",
      "UNION BRIDGE",
      "HAMPSTEAD",
      "MOUNT AIRY",

    "FREDERICK COUNTY",
      "BRUNSWICK",
      "BURKITTSVILLE",
      "EMMITSBURG",
      "FREDERICK",
      "MIDDLETOWN",
      "MYERSVILLE",
      "NEW MARKET",
      "ROSEMONT",
      "THURMONT",
      "WALKERSVILLE",
      "WOODSBORO",

    "WASHINGTON COUNTY",
      "BOONSBORO",
      "CASCADE",
      "CLEAR SPRING",
      "FUNKSTOWN",
      "HANCOCK",
      "HAGERSTOWN",
      "KEEDYSVILLE",
      "SHARPSBURG",
      "SMITHSBURG",
      "WILLIAMSPORT"
  ));
}
