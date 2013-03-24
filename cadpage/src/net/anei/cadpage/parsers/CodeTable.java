package net.anei.cadpage.parsers;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Lookup table designed to identify call descriptions associated with particular call codes.  
 * Constructor is passed a table of codes and descriptions.  When searching the table for a
 * code match, an exact match is not required, the table will return the description associated
 * with the longest key code that is a prefix of the passed call code. 
 */
public class CodeTable {
  
  public static class Result {
    private String code;
    private String description;
    private String remainder;
    
    private Result(Map.Entry<String,String> entry, String text) {
      this.code = entry.getKey();
      this.description = entry.getValue();
      this.remainder = text.substring(code.length()).trim();
    }
    
    void setCode(String code) {
      this.code = code;
    }
    
    public String getCode() {
      return code;
    }
    
    public String getDescription() {
      return description;
    }
    
    public String getRemainder() {
      return remainder;
    }
  }
  
  private TreeMap<String,String> codeMap = new TreeMap<String,String>(new Comparator<String>(){
    @Override
    public int compare(String str1, String str2) {
      return -str1.compareTo(str2);
    }});
  
  public CodeTable(String ... table) {
    if (table.length % 2 != 0) {
      throw new RuntimeException("CodeTable constructor must have even number of of entries");
    }
    for (int ndx = 0; ndx < table.length; ndx += 2) {
      codeMap.put(table[ndx], table[ndx+1]);
    }
  }
  
  protected void put(String key, String value) {
    codeMap.put(key, value);
  }


  /**
   * Look for a call description corresponding to a specific code
   * @param code call code
   * @return description associated with code or null if none found
   */
  public String getCodeDescription(String code) {
    Result res = getResult(code);
    if (res == null) return null;
    return res.getDescription();
  }

  /**
   * Look for a call description corresponding to a specific code
   * @param code call code
   * @return result object describing result if found, null otherwise
   */
  public Result getResult(String code) {
    
    // Search the code dictionary sorted map for the highest entry less than or
    // equal to call code.  If the code starts with this string, we have a
    // match.  If not, we have to keep searching backward through the sorted map
    // for the entry less than or equal to the code
    
    // We reversed the tree order so we can accomplish this trick without
    // needing a backward read feature, with Android seems to be lacking
    SortedMap<String,String> tail =  codeMap.tailMap(code);
    for (Map.Entry<String,String> entry : tail.entrySet()) {
      String key = entry.getKey();
      if (code.startsWith(key)) return new Result(entry, code);;
      if (!code.startsWith(key)) break;
    }
    return null;
  }
}
