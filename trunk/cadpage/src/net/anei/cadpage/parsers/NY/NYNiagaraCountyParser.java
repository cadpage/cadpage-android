package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYNiagaraCountyParser extends SmartAddressParser {
  
    private static final Pattern SUBJECT_PTN = Pattern.compile("[\\(\\[]?(\\d+)[\\)\\]]? NCFC .*");
    private static final Pattern MARKER1_PTN = Pattern.compile("[\\(\\[]?(\\d+)");
    private static final Pattern MARKER2_PTN = Pattern.compile("^NCFC [A-Z]+ *[\\)\\] ]");
    
    private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d{1,2}/\\d{1,2}(?:/\\d{2,4})?) (\\d{4})$");
    private static final Pattern TIME_PTN = Pattern.compile("\\b(\\d{4})(?:hrs)?$");
    private static final Pattern DATE_TIME_PTN2 = 
      Pattern.compile("(?: - *)?(?:(\\b\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)?))?(?: *@ *)?(\\b\\d{4}) */?hrs(?: *- )?");
    
    private static final Pattern CALL_AT_PTN = Pattern.compile("^([A-Z ]+)@");
    
    public NYNiagaraCountyParser() {
      super("NIAGARA COUNTY", "NY");
      setFieldList("ID CALL PLACE ADDR APT INFO DATE TIME");
    }
    
    @Override
    public String getFilter() {
      return "@niagaracounty.com";
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) { 
	    
	    do {
	      Matcher match = SUBJECT_PTN.matcher(subject);
	      if (match.matches()) {
	        data.strCallId = match.group(1);
	        break;
	      }
	      
	      Matcher match1 = MARKER1_PTN.matcher(subject);
	      if (match1.matches()) {
	        Matcher match2 = MARKER2_PTN.matcher(body);
	        if (match2.find()) {
	          data.strCallId = match1.group(1);
	          body = body.substring(match2.end()).trim();
	          break;
	        }
	      }
	      return false;
	    } while (false);
	    
	    String save = body;
	    
	    Matcher match = DATE_TIME_PTN.matcher(body);
	    if (match.find()) {
	      data.strDate = match.group(1);
	      data.strTime = expandTime(match.group(2));
	      body = body.substring(0,match.start()).trim();
	    } else {
	      match = TIME_PTN.matcher(body);
	      if (match.find()) {
	        data.strTime = expandTime(match.group(1));
	        body = body.substring(0,match.start()).trim();
	      }
	    }
	    
	    match = DATE_TIME_PTN2.matcher(body);
	    if (match.find()) {
	      String sDate = match.group(1);
	      if (sDate != null) data.strDate = sDate;
	      data.strTime = expandTime(match.group(2));
	      body = body.substring(0,match.start()).trim() + " " + body.substring(match.end()).trim();
	    }
	    
	    body = body.replace(',', ' ').replace('.', ' ').replaceAll("//s+", " ");
	    
	    StartType st = StartType.START_CALL;
	    match = CALL_AT_PTN.matcher(body); 
	    if (match.find()) {
	      data.strCall = match.group(1).trim();
	      body = body.substring(match.end()).trim();
	      st = StartType.START_PLACE;
	    }
	    
	    parseAddress(st, FLAG_NO_IMPLIED_APT, body, data);
	    if (getStatus() == 0) {
	      String callId = data.strCallId;
	      if (!data.parseGeneralAlert(this, save)) return false;
	      data.strCallId = callId;
	      return true;
	    }
	    
	    data.strSupp = unDash(getLeft());
	    
	    data.strCall = unDash(data.strCall);
	    if (data.strCall.length() == 0) {
	      data.strCall = data.strSupp;
	      data.strSupp = "";
	    }
	    
	    data.strPlace = unDash(data.strPlace);
	    return true;
	  }

    private String expandTime(String time) {
      return time.substring(0,2) + ":" +time.substring(2,4);
    }
    
    private String unDash(String field) {
      if (field.startsWith("- ")) field = field.substring(2).trim();
      if (field.endsWith(" -")) field = field.substring(0,field.length()-2).trim();
      return field;
    }
	}
	