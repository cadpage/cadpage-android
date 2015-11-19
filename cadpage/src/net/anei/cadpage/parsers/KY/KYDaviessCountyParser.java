package net.anei.cadpage.parsers.KY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class KYDaviessCountyParser extends DispatchBParser {
  
  private static final Pattern US_PTN = Pattern.compile("\\bU +S\\b", Pattern.CASE_INSENSITIVE);
 
  public KYDaviessCountyParser() {
    super(CITY_LIST, "DAVIESS COUNTY", "KY");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MWORD_STREET_LIST);
    setupSaintNames("BENEDICT");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER,911CENTRAL,2002";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // These are the only folks I know who split up US highway prefixes
    body = US_PTN.matcher(body).replaceAll("US");
    return super.parseMsg(body, data);
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    if (body.startsWith("911-CENTER:") || body.startsWith("911CENTRAL")) return true;
    return super.isPageMsg(body);
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "BETHEL CHURCH",
    "CRANE POND",
    "DEER TRAIL",
    "HARMONS FERRY",
    "HEARTLAND CROSSING",
    "HILL BRIDGE",
    "J R MILLER",
    "LEGION PARK",
    "MARTIN LUTHER KING JR",
    "MILLERS MILL",
    "RED HILL-MAXWELL",
    "ST ANN",
    "SUMMER POINT",
    "TIMBER RIDGE",
    "TODD BRIDGE",
    "TOWNE SQUARE",
    "TWENTY GRAND",
    "WINNING COLORS"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL PAIN",
      "ACCIDENT WITH INJURIES",
      "BLEEDING",
      "BOMB THREAT",
      "BREATHING DIFFICULTY",
      "CARBON MONOXIDE ALARM",
      "CARDIAC ARREST",
      "CHEST PAIN\\DISCOMFORT\\TIGHTNES",
      "CHILD LOCKED IN CAR",
      "DIABETIC PROBLEMS",
      "FIRE ALARM",
      "FIRE STRUCTURE",
      "FIRE VEHICLE",
      "ILLEGAL BURNING",
      "MEDICAL EMERGENCY",
      "MEDICAL UNKNOWN",
      "PERSON DOWN",
      "POISONING",
      "SEIZURES",
      "SERVICE CALL",
      "STROKE",
      "SUICIDE THREAT OR ATTEMPT",
      "TEST",
      "TRAUMATIC INJURY",
      "UNCONCIOUS",
      "UNKNOWN/PERSON DOWN",
      "WILDLAND FIRE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "HARTFORD",
    "OWENSBORO",
    "PHILPOT",
    "UTICA",
  };
}
