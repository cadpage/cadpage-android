package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAPennStarParser extends MsgParser {
  
//  private static final Pattern PTN_ADDRESS1 = Pattern.compile("N[0-9]+ [0-9]{2}\\.[0-9]+ W[0-9]+ [0-9]{2}\\.[0-9]+ , [0-9]+\\.[0-9]+ nm / [0-9]+\\.[0-9]+ deg\\.");
  private static final Pattern PTN_CALL_ID = Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]+");
  private static final Pattern PTN_CODE = Pattern.compile("\\b[A-Z0-9]{5}$");
  private static final Pattern PTN_CALL_TAG = Pattern.compile("\\(.+\\)");      // Pulls out things like "(STANDBY)".
  
  private static final int FREQ_LABEL_WIDTH = 6;
  private static final int DEG_LABEL_WIDTH = 4;
  
  public PAPennStarParser() {
    super("", "");
    setFieldList("ID UNIT ADDR GPS CALL CODE INFO CH");
  }
  
  @Override
  public boolean parseMsg(String strMessage, Data data) {
    
    // Extract the Call ID (ex: 23-13-21515:), ':' is always the delimiter for this field
    Matcher callIDMatch = PTN_CALL_ID.matcher(strMessage);
    if(!callIDMatch.find()) return false;
    data.strCallId = callIDMatch.group();
    String remaining = strMessage.substring(callIDMatch.end()+1).trim();
    
    // Extract the unit, this will always follow the : and have a comma after it.  
    // If there is no comma, then the message is a description and will be stored in strCall or strSupp.
    int firstComma = remaining.indexOf(',');
    if(firstComma > 0) {
      String unit = remaining.substring(0, firstComma);
      
      Matcher callTag = PTN_CALL_TAG.matcher(unit);             // Check for the extra tag in front of the unit
      if(callTag.find()) {
        data.strCall = callTag.group() + " ";
        data.strUnit = unit.substring(callTag.end()).trim();
      }
      else {                                                    // Otherwise store everything up to the comma as the unit
        data.strUnit = remaining.substring(0, firstComma).trim();
      }
      remaining = remaining.substring(firstComma+1).trim();
      
      // Check for OUTGOING label
      if(remaining.startsWith("OUTGOING")) {
        int extraComma = remaining.indexOf(',');
        data.strCall = remaining.substring(0, extraComma) + " - ";
        remaining = remaining.substring(extraComma+1).trim();
      }
      
      // Check for coordinates using pattern and store in strAddress
      data.strAddress = "";
      int deg = remaining.indexOf("deg.");                      // All Address coordinates will end with "deg."
      if(deg > 0) {
        String address = remaining.substring(0, deg+DEG_LABEL_WIDTH).trim();
        data.strAddress = address;
        setGPSLoc(address, data);
        remaining = remaining.substring(deg+DEG_LABEL_WIDTH).trim();
      }
      
      // Check the remaining for a Grd Cnt field, it will always be followed by Freq or nothing
      data.strSupp = "";
      int grdCnt = remaining.indexOf("Grd Cnt:");
      int freqIdx = remaining.indexOf("Freq:");
      if(grdCnt > 0) {                                                    // If we have a Grd Cnt, 
        if(freqIdx > 0) {                                                 // check for Freq
          data.strSupp = remaining.substring(grdCnt, freqIdx).trim();
          data.strChannel = remaining.substring(freqIdx+FREQ_LABEL_WIDTH);
        }
        else {
          data.strSupp = remaining.substring(grdCnt);                     // If we don't have Freq, then Grd Cnt is the last piece of info
        }
        remaining = remaining.substring(0, grdCnt);
      }
      // Check the remaining for a Freq field in case Grd Cnt did not exist
      else if(freqIdx >= 0) {
        data.strChannel = remaining.substring(freqIdx+FREQ_LABEL_WIDTH);
        remaining = remaining.substring(0, freqIdx);
      }
      
      // Check the remaining for a 5 digit strCode
      Matcher codeMatch = PTN_CODE.matcher(remaining);
      if(codeMatch.find()) {
        data.strCode = codeMatch.group();
        remaining = remaining.substring(0, codeMatch.start()).trim();      // Remove callCode from remaining string
      }
      
      // Check the remaining for a comma followed by callID.
      int lastComma = remaining.indexOf(',');
      if(lastComma >= 0) {
        remaining = remaining.substring(0, lastComma);
      }
      
      // The remaining is the strCall.
      data.strCall = data.strCall + remaining;
    }
    else {
      data.strCall = "GENERAL ALERT";
      data.strPlace = remaining;
    }
    
    return true;
  }
  
  @Override
  public String getLocName() {
    return "PENNSTAR, PA";
  }
  
  @Override 
  public String getFilter() {
    return "mail@ghds.net";
  }

}
