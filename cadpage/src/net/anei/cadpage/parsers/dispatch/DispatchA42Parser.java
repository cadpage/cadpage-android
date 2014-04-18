package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class DispatchA42Parser extends SmartAddressParser {

  public DispatchA42Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
  }

  private static Pattern TAGGED_MASTER = Pattern.compile("Location: *(.*?) *(-?\\d{1,3}\\.\\d+ -?\\d{1,3}\\.\\d+) *(.*?) *Common Name: *(.*?) *Call Type: *(.*?) *Call Time: *(\\d{2}/\\d{2}/\\d{2}) *(\\d{2}:\\d{2}) *Call Number: *-?(\\d+) *Narrative: *(.*?)");
  
  @Override
  public boolean parseMsg(String body, Data data) {
    // Tagged format
    Matcher mat = TAGGED_MASTER.matcher(body);
    if (!mat.matches()) return false;
    
    // Setting the field list at runtime is uncommon, we do it here because
    // this vendor usually sends out alerts in two formats, a tagged format that
    // we handle and an untagged format that varies from place to place
    setFieldList("ADDR APT X CITY GPS PLACE CALL DATE TIME ID INFO");
    
    // ADDR CITY APT
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, mat.group(1), data);
    // X
    //parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_ANCHOR_END, getPadField(), data);
    data.strCross = getPadField();
    if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    
    // PLACE GPS
    setGPSLoc(getOptGroup(mat.group(2)), data);
    data.strPlace = mat.group(3);
    
    // PLACE CALL DATE TIME ID INFO<
    data.strPlace = append(data.strPlace, " - ", mat.group(4));
    data.strCall = mat.group(5);
    data.strDate = mat.group(6);
    data.strTime = mat.group(7);
    data.strCallId = mat.group(8);
    data.strSupp = mat.group(9);
    return true;
  }
}
