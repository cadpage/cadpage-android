package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo;
import net.anei.cadpage.SmsMsgInfo.Data;


/**
 * This class is responsible for parsing useful information from an SMS page message
 */
public abstract class SmsMsgParser {
  
  /**
   * @return true if this message contain the text phrases that indicate it is 
   * a valid page message
   */
  public abstract boolean isPageMsg(String msgText);
  
  /**
   * constructor
   * @param strMessage SMS message text to be parsed
   */
  public SmsMsgInfo parse(String strMessage) {
    
    // Decode the call page and place the data in the database

    SmsMsgInfo.Data data = new SmsMsgInfo.Data();
    parse(strMessage, data);
    return new SmsMsgInfo(data);
  }

  protected abstract void parse(String strMessage, Data data);
 
 /** 
  * General purpose parser for formats where there is not a clear delimiter
  * between key: value item pairs.
  * @param body message body to be parsed
  * @param keyWords list of expected keywords
  * @return Properties object containing the parsed key: value pairs
  */
 protected Properties parseMessage(String body, String[] keyWords) {
   StringBuffer sb = new StringBuffer(body);
   for (String keyWord : keyWords) {
     int ipt = sb.indexOf(" " + keyWord + ":");
     if (ipt >= 0) sb.setCharAt(ipt, '\n');
   }
   return parseMessage(sb.toString(), "\n");
 }

 /**
  * General purpose message parser for formats where there is a clear delimiter
  * between key: value data pairs 
  * @param body
  * @param delim line delimiter
  * @return
  */
 protected Properties parseMessage(String body, String delim) {
   return parseMessage(body, delim, null);
 }
 
 /**
  * General purpose parser
  * @param body of message to be parsed
  * @param delim expression to be used to separate lines in message
  * @param missedKeys if not null, an array of keywords to be assigned to
  * lines that are missing a keyword
  * @return Properties object containing the parsed line tokens
  */
 protected Properties parseMessage(String body, String delim, String[] missedKeys) {
   
     Properties props = new Properties();
     String[] lines = body.split(delim);
     int missed = 0;
     for (String line : lines) {
         line = line.trim();
         int ndx = line.indexOf(':');
         if (ndx < 0) {
           if (missedKeys != null && missed < missedKeys.length) {
             props.put(missedKeys[missed++], line);
           }
           continue;
         }
         if (ndx+1 == line.length()) continue;
         String key = line.substring(0, ndx).trim();
         String value = line.substring(ndx+1).trim();
         ndx = key.lastIndexOf(' ');
         if (ndx >= 0) key = key.substring(ndx+1);
         props.put(key, value);
     }
     return props;
 }

 /**
  * Parse address line into address and city fields
  * @param addressLine address line to be parsed
  */
 protected void parseAddress(String addressLine, SmsMsgInfo.Data data) {
   for (String addr : addressLine.split("/")) {
     String[] tmp = addr.split("-");
     if (data.strAddress.length() > 0) data.strAddress += " and ";
     data.strAddress += tmp[0].trim();
     if (tmp.length > 1) {
       tmp[1] = tmp[1].trim();
       int pta = tmp[1].indexOf(" ");
       if (pta <=0) pta = tmp[1].length();
       data.strCity = tmp[1].substring(0,pta);
     }
   }
 }

 /**
  * Build a code table for use by convertCodeTable
  * @param table array containing pairs of strings, each pair will be considered
  * as a key/value pair to be inserted into the code table
  * @return resulting code table
  */
 protected static Properties buildCodeTable(String[] table) {
   Properties props = new Properties();
   for (int ndx = 0; ndx < table.length-1; ndx+=2) {
     props.put(table[ndx], table[ndx+1]);
   }
   return props;
 }

 /**
  * Convert any special codes in an item
  * @param item String item to be converted
  * @param codeTable table of codes with corresponding values
  * @return if item is a key to a codeTable entry, returns the associated value,
  * otherwise returns item
  */
 protected String convertCodes(String item, Properties codeTable) {
   String value = codeTable.getProperty(item);
   return (value != null ? value : item);
 }
}
