package net.anei.cadpage.parsers;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo;
import net.anei.cadpage.SmsMsgInfo.Data;


/**
 * This class is responsible for parsing useful information from an SMS page message
 */
public abstract class SmsMsgParser {
  
  // Pattern matching a terminated string of digits
  public static final Pattern NUMERIC = Pattern.compile("\\b\\d+\\b");
  
  /**
   * @return true if this message contain the text phrases that indicate it is 
   * a valid page message
   */
  public abstract boolean isPageMsg(String msgText);
  
  /**
   * build information object
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
   * Convenience method to identify a page message by checking to see if
   * it contains a sequence of key phrases in the proper order
   * @param body body of message to be checked
   * @param keywords array of key phrases used to identify paging message
   * @return true if all key phrases were found.
   */
  protected boolean isPageMsg(String body, String[] keywords) {
    int ipt = 0;
    for (String keyword : keywords) {
      ipt = body.indexOf(keyword, ipt);
      if (ipt < 0) return false;
      ipt += keyword.length();
    }
    return true;
  }
  
  /**
   * @return parser code identifying the parser that actually was used
   */
  public String getParserCode() {
    // This will be overridden in the parser group classes, but here we
    // just extract the parser code from our own class name
    
    String clsName = this.getClass().getName();
    int ipt = clsName.lastIndexOf('.');
    return clsName.substring(ipt+1, clsName.length()-6);
  }

 
 /** 
  * General purpose parser for formats where there is not a clear delimiter
  * between key: value item pairs.
  * @param body message body to be parsed
  * @param keyWords list of expected keywords
  * @return Properties object containing the parsed key: value pairs
  */
 protected static Properties parseMessage(String body, String[] keyWords) {
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
 protected static Properties parseMessage(String body, String delim) {
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
 protected static Properties parseMessage(String body, String delim, String[] missedKeys) {
   
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
  * Attempt to strip off any place names that are ahead of a real address
  * @param address suspected name and address line
  * @return the stripped address line
  */
 protected static String stripAddressName(String address) {
   
   // If we find a numeric token, assumed to be a house number
   // strip everything in front of it
   Matcher match = NUMERIC.matcher(address);
   if (match.find()) address = address.substring(match.start());
   return address;
 }

 /**
  * Parse address line into address and city fields
  * @param addressLine address line to be parsed
  */
 protected static void parseAddress(String addressLine, SmsMsgInfo.Data data) {
   addressLine = addressLine.trim();
   for (String addr : addressLine.split("/")) {
     String[] tmp = addr.split("-");
     if (data.strAddress.length() > 0) data.strAddress += " & ";
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
 protected static String convertCodes(String item, Properties codeTable) {
   String value = codeTable.getProperty(item);
   return (value != null ? value : item);
 }
 
 /**
  * Utility method to cut a selected subfield out of a string field and 
  * return everything that is left
  * @param field field are working on
  * @param start start index of subfield to be removed
  * @param end end index of subfield to be removed
  * @return Remainder of field once subfield has been removed.
  */
 protected static String cutOut(String field, int start, int end) {
   String pfx = field.substring(0,start).trim();
   String sfx = field.substring(end).trim();
   if (pfx.length() == 0) return sfx;
   if (sfx.length() == 0) return pfx;
   return pfx + " " + sfx;
 }
 
 /**
  * Class containing a list of strings that tokens will need to be checked against
  */
 protected static class MatchList {
   
   private Set<String> set;

   /**
    * Constructor
    * @param list list of strings that tokens will be checked against
    */
   public MatchList(String[] list) {
     set = new HashSet<String>(list.length);
     for (String entry : list) set.add(entry.toUpperCase());
   }
   
   /**
    * Determine if token is in list
    * @param token token to be checked
    * @return true if token is in list
    */
   public boolean contains(String token) {
     return set.contains(token.toUpperCase());
   }
 }
 
 /**
  * Worker class that will parse a into consecutive substrings up to the
  * next occurrence of a particular parser
  */
 protected static class Parser {
   
   private String line;
   private int spt;
   private int ept;

   /**
    * Constructor 
    * @param line string to be parsed out
    */
   public Parser(String line) {
     init(line);
   }

   /**
    * Reset parser with new string
    * @param line new string to be parsed
    */
   public void init(String line) {
     this.line = line;
     this.spt = 0;
     this.ept = line.length();
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter
    */
   public String get(char delim) {
     return get(delim, false);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter if found, empty string otherwise
    */
   String getOptional(char delim) {
     return get(delim, true);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter
    */
   public String getLast(char delim) {
     return getLast(delim, false);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter if found, empty string otherwise
    */
   String getLastOptional(char delim) {
     return getLast(delim, true);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter
    */
   public String get(String delim) {
     return get(delim, false);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter if found, empty string otherwise
    */
   public String getOptional(String delim) {
     return get(delim, true);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter if found
    */
   public String getLast(String delim) {
     return getLast(delim, false);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter if found, empty string otherwise
    */
   public String getLastOptional(String delim) {
     return getLast(delim, true);
   }
   
   /**
    * @param delim delimiter
    * @return everything up to next occurrence of delimiter
    */
   public String get() {
     return get(-1, 0, false);
   }
   
   /**
    * @param delim delimiter
    * @param optional true if empty string should be returned if deliminter not found
    * @return everything up to next occurrence of delimiter
    */
   private String get(char delim, boolean optional) {
     return get(line.indexOf(delim, spt), 1, optional);
   }
   
   /**
    * @param delim delimiter
    * @param optional true if empty string should be returned if deliminter not found
    * @return everything up to next occurrence of delimiter
    */
   private String get(String delim, boolean optional) {
     return get(line.indexOf(delim, spt), delim.length(), optional);
   }
   
   /**
    * @param delim delimiter
    * @param optional true if empty string should be returned if deliminter not found
    * @return everything up to next occurrence of delimiter
    */
   private String getLast(char delim, boolean optional) {
     return getLast(line.lastIndexOf(delim, ept-1), 1, optional);
   }
   
   /**
    * @param delim delimiter
    * @param optional true if empty string should be returned if deliminter not found
    * @return everything up to next occurrence of delimiter
    */
   private String getLast(String delim, boolean optional) {
     int len = delim.length();
     return getLast(line.lastIndexOf(delim, ept-len), len, optional);
   }
   
   /**
    * @param npt index returned by indexof search
    * @param len length of delimiter searched for
    * @param optional true if empty string should be returned if deliminter not found
    * @return whatever was found
    */
   private String get(int npt, int len, boolean optional) {
     if (npt < 0 || npt+len > ept) {
       if (optional) return "";
       npt = ept;
       len = 0;
     }
     String result = line.substring(spt, npt).trim();
     spt = npt + len;
     while (spt < ept && line.charAt(spt)==' ') spt++;
     return result;
   }
   
   /**
    * @param npt index returned by indexof search
    * @param len length of delimiter searched for
    * @param optional true if empty string should be returned if deliminter not found
    * @return whatever was found
    */
   private String getLast(int npt, int len, boolean optional) {
     if (npt < 0 || npt<spt) {
       if (optional) return "";
       npt = spt;
       len = 0;
     }
     String result = line.substring(npt+len, ept).trim();
     ept = npt;
     while (ept > spt && line.charAt(ept-1)==' ') ept--;
     return result;
   }
 }

}
