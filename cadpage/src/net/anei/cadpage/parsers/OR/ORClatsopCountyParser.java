package net.anei.cadpage.parsers.OR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class ORClatsopCountyParser extends SmartAddressParser {

  public ORClatsopCountyParser() {
    super("CLATSOP COUNTY", "OR");
    setFieldList("CALL ADDR APT PLACE INFO");
    setupSpecialStreets("PROMENADE");
  }
  
  @Override
  public String getFilter() {
    return "@cityofseaside.us,@astoria.or.us";
  }

  private static final Pattern PROM_PTN = Pattern.compile("\\bPROM\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern AVE_PTN1 = Pattern.compile(".* (?:AVE|AVENUE)", Pattern.CASE_INSENSITIVE);
  private static final Pattern AVE_PTN2 = Pattern.compile("([A-Z])\\b(?: +#?(\\d+))?(?: +(.*))?", Pattern.CASE_INSENSITIVE);
  
  protected boolean parseMsg(String subject, String body, Data data) {
    //require subject
    if (subject.length() == 0) return false;
    
    // Expand PROM -> PROMONADE
    subject = PROM_PTN.matcher(subject).replaceAll("PROMENADE");
    body = PROM_PTN.matcher(body).replaceAll("PROMENADE");

    // split body to fields
    String[] fields = body.split("/");
    boolean slashDelim = true;
    if (fields.length == 1 && body.contains("\n")) {
      slashDelim = false;
      fields = body.split("\n");
    }
    
    // trim fields
    for (int i = 0; i < fields.length; i++) fields[i] = fields[i].trim();
    
    // Sometimes call and address in subject and first field are reversed :(
    Result res1 = parseAddress(StartType.START_ADDR, subject);
    Result res2 = parseAddress(StartType.START_ADDR, fields[0]);
    if (!CALL_SET.contains(subject) && 
        (CALL_SET.contains(fields[0].toUpperCase()) || res1.getStatus() > res2.getStatus())) {
      data.strCall = fields[0];
      res2 = res1;
    } else {
      data.strCall = subject;
    }
    
    // reject if unknown source and strCall
    if (!isPositiveId() && !CALL_SET.contains(data.strCall.toUpperCase())) return false;

    // Parse address data
    // AVENUE X street names usually get split up and have to be repaired :(
    res2.getData(data);
    String left = res2.getLeft();
    if (AVE_PTN1.matcher(data.strAddress).matches()) {
      Matcher match = AVE_PTN2.matcher(left);
      if (match.matches()) {
        data.strAddress = data.strAddress + ' ' + match.group(1);
        data.strApt = append(data.strApt, "-", getOptGroup(match.group(2)));
        left = getOptGroup(match.group(3));
      }
    }
    data.strPlace = left;

    // second body field and rest
    int st = 1;
    if (slashDelim && fields.length > 1) {
      // if we split by \ there's a chance second field is an intersection component
      if (checkAddress(fields[1]) >= STATUS_STREET_NAME) {
        data.strAddress = append(data.strAddress, " & ", fields[1]);
        st = 2;
      }
    } 
    for (int i = st; i < fields.length; i++) data.strSupp = append(data.strSupp, " / ", fields[i]);
    
    return true;
  }
  
  private static final Set<String> CALL_SET = new HashSet<String>(Arrays.asList(
      "2 VEH MVA",
      "CHIMNEY FIRE",
      "FIRE ALARM",
      "FIRE CALL",
      "MALE NOT BREATHING",
      "MEDICAL",
      "MEDICAL CALL",
      "POSS STROKE",
      "RESCUE CALL",
      "SEISURE PATIENT",
      "TWO VEHICL AIC",
      "WATER FLOW ALARM"
  ));
  
}
