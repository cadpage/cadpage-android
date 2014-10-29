
package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;

public class INWarrickCountyParser extends HtmlParser {
  public INWarrickCountyParser() {
    super(CITY_CODE, "WARRICK COUNTY", "IN",
        "Date:DATETIME Nature:CALL Business:PLACE Address:ADDR/S Notes:INFO+ Units:UNIT",
        LAYOUT);
    
    translate(TRANS);
  }
  
  @Override
  public String getProgram() {
    return "ID CALL ADDR APT COUNTY PLACE X DATE TIME UNIT INFO";
  }
  
  @Override
  public String getFilter() {
    return "forwarding-noreply@google.com,news-googleplay@google.com,noreply@active911.com,"
        + "otfd.officers@gmail.com,noreply-2feb01bf@plus.google.com,noreply@youtube.com,"
        + "contact@active911.com,swilliams@warrickcountysheriff.com";
  }

  private static final Pattern HEADER_PATTERN
    = Pattern.compile("(.*?)Incident #(\\d{10})");
  @Override
  protected boolean parseHtmlMsg(String header, String msg, Data data) {
    msg=msg.replace("\\t", "");
    if (!getHtmlCleaner(msg))
      return false;
    Matcher m = HEADER_PATTERN.matcher(header);
    if (!m.matches()) return false;
    data.strCallId = m.group(2);
    if (m.group(1).contains("Clear")) {
      data.strCall = "CLEAR";
      data.strSupp = getValue("EVERYTHING");
      return true;
    }
    else
      return parseFields(getValue("EVERYTHING").split("\n"), data);
  }
 
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME"))
      return new MyDateTimeField();
    if (name.equals("CALL"))
      return new CallField("(.*?)MP\\:", false);
    if (name.equals("ADDR"))
      return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PATTERN
    = Pattern.compile ("(.*?)Time Out\\:(.*)");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = DATE_TIME_PATTERN.matcher(field);
      if (m.matches()) {
        data.strDate = m.group(1).trim();
        data.strTime = m.group(2).trim();
      }
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replace("City:",  " ").trim(), data);
    }
  }
  
  private static final String[] LAYOUT = {
    "EVERYTHING(ELEMENT=PRE;offset=0)"
// That's right, everything of interest is in one preformatted chunk of text
    // with a bunch of extra tabs, which
    // begs the question:  Why even use html????
  };
  
  private static final Properties CITY_CODE = buildCodeTable(new String[]{    
      
      "WC",           "WARRICK COUNTY"
  });
  
  private static final String[] TRANS = {
    "\\t", ""
  };
  
}
