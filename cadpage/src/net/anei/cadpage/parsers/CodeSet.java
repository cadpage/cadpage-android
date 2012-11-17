package net.anei.cadpage.parsers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Lookup table that can perform incomplete text match searches.  When called to search the
 * table, it will return the longest entry that is a prefix of the search string. 
 */
public class CodeSet {
  
  private TreeSet<String> codeSet = new TreeSet<String>(new Comparator<String>(){
    @Override
    public int compare(String str1, String str2) {
      return -str1.compareTo(str2);
    }});
  
  public CodeSet(String ... table) {
    codeSet.addAll(Arrays.asList(table));
  }


  /**
   * Look for a code that is a prefix to search string
   * @param str search string
   * @return longest table entry that is a prefix of search string or
   *          null if there is no such entry
   */
  public String getCode(String str) {
    
    // Search the code dictionary sorted map for the highest entry less than or
    // equal to call code.  If the code starts with this string, we have a
    // match.  If not, we have to keep searching backward through the sorted map
    // for the entry less than or equal to the code
    
    // We reversed the tree order so we can accomplish this trick without
    // needing a backward read feature, with Android seems to be lacking
    SortedSet<String> tail =  codeSet.tailSet(str);
    if (tail.isEmpty()) return null;
    String key = tail.first();
    if (str.startsWith(key)) {
      if (str.length() == key.length() ||
          str.charAt(key.length()) == ' ') return key;
    }
    return null;
  }
}
