package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/* 
Surry County, NC
Contact: Active911

[] SC911::Call #120627-0079 [Address] 112 SOLO LN [X St] PEACE HAVEN CIR TO DEADEND [Type] ASST PATIENT\n
[] SC911::Call #120627-0206 [Address] 587 N FRANKLIN RD [X St] TO [Type] CARDIAC\n
[] SC911::Call #120627-0221 [Address] 297 MAPLE HOLLOW RD [X St] MARK ST TO LYNN ST [Type] DIABETIC D\n
[] SC911::Call #120627-0235 [Address] 1872 W PINE ST [X St] TRANQUIL LN TO CEDAR KNOLL DR [Type] ASST PATIENT\n
[] SC911::Call #120627-0263 [Address] MAPLE DR // OLD TOAST RD [X St] OLD TOAST RD TO DEADEND [Type] UNKNOWN PROB\n
[] SC911::Call #120628-0145 [Address] 1766 S ANDY GRIFFITH PKWY [X St] CITY LIMITS TO OLD BUCK SHOALS RD [Type] FIRE ALARM\n
[] SC911::Call #120628-0294 [Address] 1161 W LEBANON ST [X St] PAIGE ST TO HADLEY RD [Type] COMM SERVICE\n

Agency name: Franklin VFD - Medical Location: Toast, NC 
Sender: SC911:@co.surry.nc.us
  
SC911::Call #120707-0414 [Address] 367 CEDAR RIDGE RD [X St] PIPERS GAP RD TO DEADEND [Type] ASSAULT D
SC911::Call #120709-0218 [Address] 192 LOWER PARK LN [X St] MID LN TO DEADEND [Type] CVA D
SC911::Call #120710-0221 [Address] 426 N FRANKLIN RD [X St] TO [Type] RESP DIS D
SC911::Call #120712-0107 [Address] 1872 PIPERS GAP RD [X St] MILLER RD TO PHANTOM LN [Type] ACCIDENT PI
SC911::Call #120712-0347 [Address] 223 BLUEMONT RD [X St] HIGHLAND DR TO S FRANKLIN RD [Type] FALL
SC911::Call #120713-0124 [Address] 201 HUNTINGTON CREEK LN [X St] IMOGENE CH RD TO DEADEND [Type] UNRESPONSIVE
SC911::Call #120713-0140 [Address] 227 AIRVIEW DR [X St] SUMMIT DR TO DEADEND [Type] ASSIST AGNCY
SC911::Call #120713-0165 [Address] 227 AIRVIEW DR [X St] SUMMIT DR TO DEADEND [Type] ASSIST AGNCY
SC911::Call #120713-0208 [Address] 142 BOURBON TR [X St] CAROLINA RD/DUKE RD TO DEADEND [Type] CHOKE
SC911::Call #120713-0222 [Address] 242 DUDLEY AVE [X St] DUDLEY AVE TO DEADEND [Type] FALL D
SC911::Call #120713-0222 [Address] 242 DUDLEY AVE [X St] DUDLEY AVE TO DEADEND [Type] FALL D
SC911::Call #120714-0040 [Address] 149 LINWOOD DR [X St] S FRANKLIN RD TO GREENWAY DR [Type] SUICIDE
SC911::Call #120714-0113 [Address] 150 ELK COURT DR [X St] N BRIDGE ST TO HWY 268 BY PASS [Type] LIFELINE
SC911::Call #120714-0116 [Address] 108 DOGWOOD DR [X St] ROSEWOOD DR TO LONG ST [Type] SICK D
SC911::Call #120715-0211 [Address] 194 OAK RIDGE DR [X St] MAPLE HOLLOW RD TO DEADEND [Type] CARDIAC D
SC911::Call #120715-0237 [Address] 481 WHITE PINES COUNTRY CLUB RD [X St] N ANDY GRIFFITH PKWY TO VA STATE LINE [Type] ASST PATIENT
SC911::Call #120715-0325 [Address] 338 S FRANKLIN RD [X St] CALVARY DR TO LONG ST [Type] HEMRGE D
SC911::Call #120716-0179 [Address] 227 AIRVIEW DR [X St] SUMMIT DR TO DEADEND [Type] TRANSPORT
SC911::Call #120716-0280 [Address] 110 DUTCHMANS CT [X St] JOHNSON RIDGE RD TO DEADEND [Type] TRANSPORT
SC911::Call #120716-0299 [Address] 481 WHITE PINES COUNTRY CLUB RD [X St] N ANDY GRIFFITH PKWY TO VA STATE LINE [Type] UNRSPVE D
SC911::Call #120716-0529 [Address] 2013 SPARGER RD [X St] BEAMER RD TO GOINS RD [Type] ACCIDENT PI
SC911::Call #120718-0172 [Address] 112 SOLO LN [X St] PEACE HAVEN CIR TO DEADEND [Type] CARDIAC D
SC911::Call #120718-0206 [Address] 1872 W PINE ST [X St] TRANQUIL LN TO CEDAR KNOLL DR [Type] ASST PATIENT

*/

public class NCSurryCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("SC911::Call #(\\d{6,}-\\d{4}) \\[Address\\] (.*?) \\[X St\\] (.*?) \\[Type\\] (.*)");
  
  public NCSurryCountyParser() {
    super("SURRY COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "SC911:@co.surry.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    parseAddress(match.group(2).replace("//", "&").trim(), data);
    data.strCross = match.group(3).trim().replace(" TO ", " & ");
    if (data.strCross.equals("TO")) data.strCross = "";
    else if (data.strCross.endsWith(" TO")) {
      data.strCross = data.strCross.substring(0,data.strCross.length()-3).trim();
    }
    data.strCall = match.group(4).trim();
    return true;
  }
}
