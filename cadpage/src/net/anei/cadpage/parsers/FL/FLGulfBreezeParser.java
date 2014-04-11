package net.anei.cadpage.parsers.FL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class FLGulfBreezeParser extends SmartAddressParser {

  public FLGulfBreezeParser() {
    super("GULF COUNTY", "FL");
    setFieldList("DATE TIME CALL ADDR APT CITY INFO");
    setupMultiWordStreets(MW_STREETS);
  }

  private static final Pattern NON_PRINT = Pattern.compile("[^\\p{Print}]");
  private static final Pattern ASTERISK_TRIMMER = Pattern.compile("\\**(.*?)\\**");
  private static final Pattern DATE_TIME_BODY = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{1,2}:\\d{2}:\\d{2} [AP]M)\n(.*)", Pattern.DOTALL);
  private static final Pattern MED_CALL = Pattern.compile("(.*?)MED CALL:? (.*?)\\.(.*)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("FIRE PAGE")) return false;

    // parse date and time
    Matcher mat = DATE_TIME_BODY.matcher(body);
    if (!mat.matches()) return false;
    data.strDate = mat.group(1);
    setTime(TIME_FMT, mat.group(2), data);
    body = mat.group(3).trim();

    // trim trailing disclaimer
    int ni = body.indexOf("\n");
    if (ni != -1) body = body.substring(0, ni).trim();

    body = NON_PRINT.matcher(body).replaceAll(""); // remove non ascii
    body = ASTERISK_TRIMMER.matcher(body).replaceAll(""); // remove leading and trailing ***

    // try CALL "MED CALL:" ADDR. CALL format
    mat = MED_CALL.matcher(body);
    if (mat.matches()) {
      body = mat.group(2).trim();
      data.strCall = append(mat.group(1), ". ", mat.group(3)).trim();
      parseAddress(body, data);
      return true;
    }

    // try parseAddress on body
    Result res = parseAddress(StartType.START_CALL, body);
    if (res.getStatus() >= STATUS_FULL_ADDRESS) {
      res.getData(data);
      if (data.strCall.length() == 0) data.strCall = res.getLeft();
      else data.strSupp = res.getLeft();
      return true;
    }

    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }
  
  private static final String[] MW_STREETS = new String[]{
    "AUTUMN BRZ",
    "BLOCK GULF BREEZE",
    "CRANE COVE",
    "GULF BREEZE",
    "PENSACOLA BEACH",
    "PINE TREE",
    "SAN CARLOS",
    "VIA DE LUNA"
  };
  
}
