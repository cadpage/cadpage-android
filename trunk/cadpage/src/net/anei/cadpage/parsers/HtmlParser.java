package net.anei.cadpage.parsers;
import android.annotation.SuppressLint;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.htmlcleaner.*;
import org.w3c.dom.NodeList;

/**
 * 
 * HtmlParser provides methods for accessing data embedded in HTML.
 * While direct method calls are available to access pieces of an HTML doc
 * it is preferable to use a layout given to a constructor.
 * 
 * The layout is a String array, each element of which gives a tag to identify
 * the data and instructions for getting it.  The general form of a layout entry is:
 * 
 *          TAGNAME(option[;option])
 *          
 * TAGNAME is used to get the value via getValue(TAGNAME) and is case-sensitive.
 * Following TAGNAME is a list of ;-delimited options enclosed in parentheses.
 * The options are:
 * 
 *    ELEMENT=value
 *      The data is contained in the element type specified, e.g. div, p, td
 *      
 *    LABEL=value
 *      Search for value to identify the data.  value is a case-sensitive string enclosed in //.
 *      
 *    ROW=value
 *      Only used with a domain of "table=n".  If used must also have either LABEL=value or COL=value
 *      specified.  Selects the table row the data will be taken from.  A value of "*" means select
 *      all rows.
 *      
 *    COL=value
 *      Analogous to ROW above.  Only used with a domain of "table=n".  If used must also have either
 *      LABEL=value or ROW=value specified.  Selects the table column with the data.  A value of "*"
 *      means select all columns.
 *      
 *    OFFSET=value
 *      value is an integer giving the absolute ordinal of the data or the ordinal relative
 *      to the found label if specified.  You can give multiple values with comma-separated numbers
 *      (e.g. offset=3, 14) or with ranges (e.g. offset=2-5) or both (offset = 1, 5, 10-15)
 *      
 *    EXCLUDE=value
 *      value is a /-delimited string.  Any element that otherwise qualifies will not be used
 *      if its contents include value
 *      
 *    REMOVE=value
 *      value is a /-delimited string.  Any qualifying element will have value removed from the
 *      contents.
 *      
 *    REMOVE_LABEL
 *      like remove above but removes the text specified with the LABEL option
 *      
 *    MULTIPLE
 *      multiple pieces of data will be used.  This is completely independent from giving multiple
 *      offsets except they both use the separator string to concatenate the results.  So if a label
 *      is given in an entry with MULTIPLE specified, every matching label is processed instead of
 *      just the first.  If the CLOSEST option is used, all values within the window will be
 *      concatenated for the final value instead of just the closest being used.
 *      
 *    SEPARATOR=value
 *      value is a /-delimited string which will be used any time values will be concatenated.
 *      Defaults to / / (space.)
 *      
 *    CLOSEST
 *      This option is only used for absolutely positioned elements (div, p, hn) where the
 *      position is given by the style attribute of the element.  This gives the closest element
 *      to the reference element (presumably found with the LABEL option) within a rectangle
 *      relative to the reference element.  If MULTIPLE is also specified all of the elements
 *      within the window will be concatenated for the value.
 *      
 *      The default window extends 2 pixels up and down, 5 to the left and 100 to the right
 *      of the reference element, but can be changed with the XMIN, XMAX, YMIN and YMAX options.
 *      
 *    YMIN=value
 *      value is an integer.  Only used with the closest option.  This is the farthest above
 *      the reference element to look for the data.  Note that value can be negative.
 *      
 *    YMAX=value
 *      value is an integer.  Only used with the closest option.  This is the farthest below
 *      the reference element to look for the data.  Again, the value can be negative.
 *      
 *    XMIN=value
 *    XMAX=value
 *      Only used with the closest option.  These are analogous to the YMIN and YMAX options
 *      but give the minimum left value and the maximum right value respectively.
 *      
 *    <element name>=value
 *      By default HtmlParser uses the top-level node of the document for the domain.
 *      Giving an element name and an integer value will use the element with the
 *      ordinal value as the domain.  E.g., div=0, table=4.  When the data is actually
 *      retrieved, like domains will be processed together to reduce execution time.
 *      
 *    XPATH=value
 *      Use value as XPath to get the value.  MULTIPLE is assumed.  You can limit the
 *      values used with XBEGIN=n and XEND=n.  The default values use the entire result.
 *      REMOVE and SEPARATOR= work normally.  EXCLUDE excludes data values rather than
 *      labels.  LABEL, OFFSET, CLOSEST, XMIN, YMIN, XMAX and YMAX have no effect.
 *      
 *    XBEGIN=value
 *      XPath evaluation results in an array of matching nodes.  XBEGIN tells HtmlParser
 *      to use only values from the array with an index of value or greater.
 *      Defaults to 0.
 *      
 *    XEND=value
 *      This is the highest position in an XPath array from which to use data.  A value of
 *      -1 means no higher bound.  Defaults to -1.
 *    
 *    LABEL_BEGIN=value
 *      When retrieving multiple data, use the element containing value as the beginning of the sequence.
 *      
 *    LABEL_END=value
 *      When retrieving multiple data, use the element containing value as the end of the sequence.
 *      
 *    INCLUDE_BEGIN
 *      When set, includes the element containing the LABEL_BEGIN value in the sequence.  Default: unset
 *      
 *    INCLUDE_END
 *      When set, includes the element containing the LABEL_END value in the sequence.  Default: unset
 *       
 *    REQUIRED
 *      This particular datum is required.  If not present, getHtmlCleaner(html) will return false.
 * 
 *    XJAVA
 *      Only meaningful if using XPath.  Use the Java XPath engine instead of htmlcleaner (which
 *      only implements v1.0.  Probably this should go away and HtmlParser would just use the Java
 *      engine.
 *         
 *    All of the options and element names are case-insensitive.  Any string value in / / is
 *    case-sensitive.
 *    
 */

public class HtmlParser {
  private HtmlCleaner htmlCleaner = null;
  private CleanerProperties props = null;
  private TagNode root = null;
  private Map<String, ParseInfo> layout = new LinkedHashMap<String, ParseInfo>();
  private Map<String, Set<String>> domain = new HashMap<String, Set<String>>();
  private Map<String, String> translate = new HashMap<String, String>();
  private org.w3c.dom.Document doc;
  private boolean hasXPath = false;

  public static final int
    STATUS_OK = 0,
    STATUS_UNINITIALIZED = 1,
    STATUS_DOMAIN = 2,
    STATUS_ELEMENT = 3,
    STATUS_LABEL = 4,
    STATUS_OFFSET = 5,
    STATUS_ROW = 6,
    STATUS_COL = 7;
  
  public class ParseInfo {
    private String        domain;
    private String        element;
    private String        label;
    private int           row;
    private int           col;
    private boolean      removeLabel;
    private boolean      closest;
    private int           yMin;
    private int           yMax;
    private int           xMin;
    private int           xMax;
    private boolean       multiple;
    private Pattern        validate;
    private boolean       required;
    private Set<Integer>   offset;
    private String         separator;
    private String         exclude;
    private String         remove;
    private String         value;
    private String         xPath;
    private int           xBegin;
    private int           xEnd;
    private String         labelBegin;
    private String         labelEnd;
    private boolean       includeBegin;
    private boolean       includeEnd;
    private boolean       xJava;
    private int           status;
    
    /* Constructor */
    ParseInfo() {
      init();
    }

    private void init() {
      domain("*");
      element("");
      label("");
      row(-2);
      col(-2);
      removeLabel(false);
      closest(false);
      xMin(5);
      yMin(2);
      xMax(100);
      yMax(2);
      multiple(false);
      validate(null);
      required(false);
      offset(new HashSet<Integer>());
      separator(" ");
      exclude("");
      remove("");
      value("");
      xPath("");
      xBegin(0);
      xEnd(-1);
      labelBegin("");
      labelEnd("");
      includeBegin(false);
      includeEnd(false);
      xJava(false);
      status(STATUS_UNINITIALIZED);
    }
    
    // Accessors
    public String domain() { return domain; }
    public void domain(String d) { domain = d; }
    public String element() { return element; }
    public void element(String en) { element = en; }
    public String label() { return label; }
    public void label(String l) { label = l; }
    public int row() { return row; }
    public void row(int r) { row = r; }
    public int col() { return col; }
    public void col(int c) { col = c; }
    public boolean removeLabel() { return removeLabel; }
    public void removeLabel(boolean rl) { removeLabel = rl; }
    public boolean closest() { return closest; }
    public void closest(boolean c) { closest = c; }
    public boolean required() { return required; }
    public void required(boolean r) { required = r; }
    public int xMin() { return xMin; }
    public void xMin(int xm) { xMin = xm; }
    public int xMax() { return xMax; }
    public void xMax(int xm) { xMax = xm; }
    public int yMin() { return yMin; }
    public void yMin(int ym) { yMin = ym; }
    public int yMax() { return yMax; }
    public void yMax(int ym) { yMax = ym; }
    public boolean multiple() { return multiple; }
    public void multiple(boolean m) { multiple = m; }
    public Pattern validate() { return validate; }
    public void validate(Pattern v) { validate = v; }
    public Set<Integer> offset() { return offset; }
    public void offset(Set<Integer> o) { offset = o; }
    public String separator() { return separator; }
    public void separator(String c) { separator = c; }
    public String exclude() { return exclude; }
    public void exclude(String e) { exclude = e; }
    public String remove() { return remove; }
    public void remove(String r) { remove = r; }
    public String value() { return value; }
    public void value(String v) { value = v; }
    public String xPath() { return xPath; }
    public void xPath(String xp) { xPath = xp; }
    public int xBegin() { return xBegin; }
    public void xBegin(int xb) { xBegin = xb; }
    public int xEnd() { return xEnd; }
    public void xEnd(int xe) { xEnd = xe; }
    public String labelBegin() { return labelBegin; }
    public void labelBegin(String lb) { labelBegin = lb; }
    public String labelEnd() { return labelEnd; }
    public void labelEnd(String le) { labelEnd = le; }
    public boolean includeBegin() { return includeBegin; }
    public void includeBegin(boolean ib) { includeBegin = ib; }
    public boolean includeEnd() { return includeEnd; }
    public void includeEnd(boolean ie) { includeEnd = ie; }
    public boolean xJava() { return xJava; }
    public void xJava(boolean xj) { xJava = xj; }
    public int status() { return status; }
    public void status(int s) { status = s; }
  }
  
  /* HtmlParser Constructors */
  /*
   *  Currently always constructed with this one
   *  @param layoutArray String array of layout entries
   */
  public HtmlParser(String[] layoutArray) {
    createLayout(layoutArray);
  }
  
  /*
   *
   * 
   * Layout initialization methods
   * 
   * 
   */
  
   /*
   * This method populates the hash table with layout supplied by subclass
   * See top of file for the layout syntax.
   * @param pArray The layout array
   */
  private void createLayout(String[] pArray) {
    for (int i=0; i<pArray.length; i++) {
      int fp = pArray[i].indexOf('(');
      String tag = pArray[i].substring(0, fp).trim();
      String remainder = pArray[i].substring(fp+1, pArray[i].length()).trim();
      createLayoutEntry(tag, remainder.substring(0, remainder.length()-1).trim());
    }
  }
  
  /*
   * Create layout entry for tag with instructions
   * @param tag Tag for the layout entry
   * @param instructions Instructions for getting the value of the entry
   */
  private void createLayoutEntry(String tag, String instructions) {
/*
    System.out.println("Tag: '"+tag+"'");
    System.out.println("Instructions: '"+instructions+"'");
*/
    ParseInfo pi = new ParseInfo();
    String command[] = instructions.split("(?<!\\\\);");
    for (int i=0; i<command.length; i++)
      processCommand(command[i].trim(), pi);
    // Offset defaults to 0 but if no OFFSET= cmd was given there won't be anything in
    // the set:
    if (pi.offset().isEmpty() && !pi.label().equals(""))
      addOffset("0", pi);
    // If a row or col was specified for a table mark the domain with "TABLE" instead
    // of "table"
    if (pi.row() != -2 || pi.col() != -2)
      pi.domain(pi.domain().toUpperCase());
    updateDomains(tag, pi);
    layout.put(tag, pi);
  }

  /*
   * Get domain of pi and add tag to appropriate domain entry
   * or create a new entry if it doesn't exist.
   * @param tag Tag for the layout entry
   * @parseInfo pi parseInfo for the layout entry
   */
  private void updateDomains(String tag, ParseInfo pi) {
    String dom = pi.domain();
    if (!domain.containsKey(dom))
      domain.put(dom, new HashSet<String>());
    domain.get(dom).add(tag);
  }

  /*
   * c contains a layout option.  Interpret it and update pi
   * accordingly.
   * @param c layout option
   * @param pi parseInfo for the layout entry
   */
  private void processCommand(String c, ParseInfo pi) {
//    System.out.println("Command: \""+c+"\"");
    if (c.equalsIgnoreCase("MULTIPLE"))
      pi.multiple(true);
    else if (c.equalsIgnoreCase("REMOVE_LABEL"))
      pi.removeLabel(true);
    else if (c.equalsIgnoreCase("CLOSEST"))
      pi.closest(true);
    else if (c.equalsIgnoreCase("REQUIRED"))
      pi.required(true);
    else if (c.equalsIgnoreCase("XJAVA"))
      pi.xJava(true);
    else if (c.equalsIgnoreCase("INCLUDE_BEGIN"))
      pi.includeBegin(true);
    else if (c.equalsIgnoreCase("INCLUDE_END"))
      pi.includeEnd(true);
    else
      if (c.contains("=")) {
        int ep = c.indexOf('=');
        processAttributeValue(c.substring(0, ep).trim(), c.substring(ep+1).trim(), pi);
      }
  }

  /*
   * If a is a valid attribute set a to v.  Otherwise,
   * it is a domain spec so set domain to "a=v".
   * @param a Layout entry attribute
   * @param v Layout entry value
   * @param pi Layout entry parseInfo
   */
  private void processAttributeValue(String a, String v, ParseInfo pi) {
//    System.out.println("Attribute: \""+a+"\", Value: \""+v+"\"");
    if (a.equalsIgnoreCase("element"))
      pi.element(v);
    else if (a.equalsIgnoreCase("label"))
      pi.label(stringContent(v));
    else if (a.equalsIgnoreCase("row"))
      pi.row(rowColValue(v));
    else if (a.equalsIgnoreCase("col"))
      pi.col(rowColValue(v));
    else if (a.equalsIgnoreCase("offset"))
      setOffset(v, pi);
    else if (a.equalsIgnoreCase("exclude"))
      pi.exclude(stringContent(v));
    else if (a.equalsIgnoreCase("remove"))
      pi.remove(stringContent(v));
    else if (a.equalsIgnoreCase("separator"))
      pi.separator(stringContent(v));
    else if (a.equalsIgnoreCase("xmin"))
      pi.xMin(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("xmax"))
      pi.xMax(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("ymin"))
      pi.yMin(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("ymax"))
      pi.yMax(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("xpath")) {
      pi.xPath(stringContent(v));
      hasXPath = true;
    }
    else if (a.equalsIgnoreCase("xbegin"))
      pi.xBegin(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("xend"))
      pi.xEnd(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("label_begin"))
      pi.labelBegin(stringContent(v));
    else if (a.equalsIgnoreCase("label_end"))
      pi.labelEnd(stringContent(v));
    else if (a.equalsIgnoreCase("validate"))
      pi.validate(Pattern.compile(stringContent(v)));
    else
      pi.domain(a.toLowerCase()+"="+v);
  }
  
  /*
   * @param v String representation of integer value or "*"
   * @return int value of v or -1 if v is "*"
   */
  private int rowColValue (String v) {
    if (v.equals("*"))
      return -1;
    return Integer.parseInt(v);
  }
  
  /*
   * I chose '/' as the string delimiter.
   * Maybe another character would have made more sense.
   * This function merely removes the bracketing '/'s.
   * @param delimitedString '/'-delimited String
   * @return String value
   */
  private String stringContent(String delimitedString) {
    if (delimitedString.charAt(0) != '/'
        || delimitedString.charAt(delimitedString.length()-1) != '/') {
      System.out.println("Improperly delimited string: "+delimitedString);
      return null;
    }
    return delimitedString.substring(1, delimitedString.length()-1);
  }
 
  /*
   * Parse oString to get offset values and update pi
   * values and value ranges are separated by ','
   * @param oString String containing offet(s)
   */
  private void setOffset(String oString, ParseInfo pi) {
    String[] part = oString.split(",");
    for (int p=0; p<part.length; p++)
      addOffset(part[p].trim(), pi);
  }
  
  /*
   * oString contains an offset or a range of offsets (min - max)
   * parse it and update pi.
   * @param oString String containing offset(s)
   * @param pi parseInfo for layout entry
   */
  private void addOffset(String oString, ParseInfo pi) {
//    System.out.println("addOffset(): '"+oString+"'");
    if (oString.contains("-")) {
      String first = oString.substring(0, oString.indexOf('-')), second;
      if (first.equals(""))
        if (oString.substring(1).contains("-")) {
          int hloc = oString.substring(1).indexOf('-')+1;
          first = oString.substring(0, hloc);
          second = oString.substring(hloc+1);
          int b = Integer.parseInt(first),
              e = Integer.parseInt(second);
          while (b <= e)
            pi.offset.add(b++);
        }
        else
          pi.offset.add(Integer.parseInt(oString));
      else {
        second = oString.substring(oString.indexOf('-')+1);
        int b = Integer.parseInt(first),
            e = Integer.parseInt(second);
        while (b <= e)
          pi.offset.add(b++);
      }
    }
    else
      pi.offset.add(Integer.parseInt(oString));
  }

  /*
   * 
   * value population methods
   * 
   */
  
  /*
   * Instantiate htmlCleaner and set reasonable looking properties
   * @return true if success, else false
   */
  private boolean getHtmlCleaner() {
    htmlCleaner = new HtmlCleaner();
    if (htmlCleaner == null)
      return false;
    setHtmlCleanerProps();
    return true;
  }
  
  
  /*
   * According to the documentation these
   * properties should make htmlcleaner convert
   * &xxx; escapes to the char equivalent but it
   * doesn't seem to work correctly.
   * 
   * Also get rid of comments, scripts and styles.
   */
  private void setHtmlCleanerProps() {
    props = htmlCleaner.getProperties();  
    props.setAllowHtmlInsideAttributes(false);  
    props.setAllowMultiWordAttributes(true);  
    props.setRecognizeUnicodeChars(true);  
    props.setOmitComments(true);
    props.setPruneTags("script,style");
  }
  

  /*
   * Instantiate htmlCleaner with properties and give it html to parse
   * v2.7 won't process html tags (& their descendants with a certain
   * value of the xmlns attribute so strip out all occurrences.
   * 
   * Return true or false if htmlcleaner fails to parse
   * (haven't seen this happen yet.)
   * @param html html to parse
   * @return true if success, else false
   */
  private static final String XMLNS_PATTERN_STRING  = "(?is)xmlns=\\\".*?\\\"";
  public boolean getHtmlCleaner(String html) {
    if (!getHtmlCleaner())
      return false;
    root = htmlCleaner.clean(html.replaceAll(XMLNS_PATTERN_STRING, ""));
    if (root != null) {
      if (layout.isEmpty())
        return true;
      if (hasXPath)
        serializeDoc();
      return getValues();
    }
    return false;
  }
  
  private void serializeDoc() {
    try {
      doc = new DomSerializer(new CleanerProperties()).createDOM(root);
    } catch (ParserConfigurationException e) {
      throw new RuntimeException("Serialization Error");
    }   
  }

  /*
   * This is where the actual values are located and put into the layout.
   * Return true or false if any required value is empty.
   * @return true if all required layout entries have a value, else false
   */
  private boolean getValues() {
    // Must initialize pi values or values from prev. msg will be carried over
    Set<String> layoutKeySet = layout.keySet();
    initializeParseInfo (layoutKeySet);
    Set<String> domainKeySet = domain.keySet();
    Iterator<String> k = domainKeySet.iterator();
    while (k.hasNext()) {
      String d = k.next();
//      System.out.println("Domain: '"+d+"'");
      getDomainValues(d);
    }
    return checkValues(layoutKeySet);
  }

  /*
   * Initialize ParseInfo for each layout tag in keySet
   * @param keySet String set of keys in layout
   */
  private void initializeParseInfo (Set<String> keySet) {
    Iterator<String> k = keySet.iterator();
    while (k.hasNext()) {
      String tag = k.next();
      ParseInfo pi = layout.get(tag);
      pi.value("");
      pi.status(STATUS_UNINITIALIZED);
    }    
  }
  
  /*
   * Return true or false if any required entry is empty.
   * @param keySet String set of keys in layout
   * @return true if all required entries have values, else false
   */
  private boolean checkValues(Set<String> keySet) {
    Iterator<String> k = keySet.iterator();
    while (k.hasNext()) {
      String tag = k.next();
      ParseInfo pi = layout.get(tag);
      if (pi.required() && pi.value().equals(""))
        return false;
    }
    return true;
  }
  
  /*
   * This method processes the instructions to get values for all tags
   * with the same domain.  Currently, only 1 search element is allowed.
   * Thus NAME(TABLE=5;ELEMENT=TD;LABEL=/Person:/;OFFSET=1) and
   * PHONE(TABLE=5;ELEMENT=TD;LABEL=/Phone:/;OFFSET=1) will get processed together
   * but SOURCE(TABLE=5;ELEMENT=H2) would get processed in another pass.
   * This will be corrected in a future version.
   * 
   * @param d domain to process
   */
  private void getDomainValues(String d) {
    Set<String> tagSet = domain.get(d);
    TagNode top = getTop(d);    
    Iterator<String> t = tagSet.iterator();
    if (top == null) {
      while (t.hasNext()) {
        String tag = t.next();
        ParseInfo pi = layout.get(tag);
        pi.status(STATUS_DOMAIN);
        return;
      }
    }
    String el = "";
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      if (!pi.xPath.equals(""))
        getXPathValue(top, pi);
      if (el.equals(""))
        el = pi.element();
    }
    // If domain is "TABLE=n" use table processing logic
    if (d.contains("TABLE")) {
      saveRowCol(tagSet);
      findTableValues(top, tagSet);
      restoreRowCol(tagSet);
    }
    else
      findValues(top, el, new HashSet<String>(tagSet));
  }

  /*
   * Evaluate XPath to get the value
   * @param top top-level node
   * @param pi ParseInfo for layout entry
   */
  private void getXPathValue(TagNode top, ParseInfo pi) {
    Object[] node;
    if (pi.xJava())
      getJXPathValue(top, pi);
    else {
      try {
        node = top.evaluateXPath(pi.xPath());
      }  catch (XPatherException e) {
        throw new RuntimeException(e.getMessage());
      }
      for (int n=pi.xBegin(); n<node.length && (pi.xEnd() == -1 || n<=pi.xEnd()); n++)
        addValue(((TagNode)node[n]).getText().toString(), pi);
    pi.status(STATUS_OK);
    }
  }

  /*
   * Evaluate XPath using Java XPath engine
   * @param top top-level node
   * @param pi ParseInfo for layout entry
   */

@SuppressLint("NewApi")
private void getJXPathValue(TagNode top, ParseInfo pi) {
    NodeList nl;
//    System.out.println("XPATH: '"+pi.xPath()+"'");
    XPath xpath = XPathFactory.newInstance().newXPath();
    try {
      nl = (NodeList) xpath.evaluate(pi.xPath, doc, XPathConstants.NODESET);
    } catch (XPathExpressionException e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    for (int i=0; i<nl.getLength(); i++)
      addValue(nl.item(i).getTextContent(), pi);
  }
  
  /*
   * Save the original values of row and col to xMin & yMin
   * @param tagSet Set of layout tag strings
   */
  private void saveRowCol(Set<String> tagSet) {
    Iterator<String> t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      pi.xMin(pi.col());
      pi.yMin(pi.row());
    }
  }
  
  /*
   * Restore previously saved row and col values
   * @param tagSet set of layout tag strings
   */
  private void restoreRowCol(Set<String> tagSet) {
    Iterator<String> t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      pi.col(pi.xMin());
      pi.row(pi.yMin());
    }
  }

   /*
   * Find values in a table where row/column info is necessary.
   * A row or col value of -1 means use all values
   * @param top top level node (a table)
   * @param tagSet set of tag strings using this domain
   */
  private void findTableValues(TagNode top, Set<String> tagSet) {
    int rowNum = 0, colNum = 0, rs, cs;
    Map<Integer,Integer> descender = new LinkedHashMap<Integer,Integer>();
    
    if (top == null) {
//      System.out.println("findTableValues():  null domain");
      Iterator<String> tag = tagSet.iterator();
      while (tag.hasNext()) {
        ParseInfo pi = layout.get(tag);
        pi.status(STATUS_DOMAIN);
      }
      return;
    }
    TagNode[] bodyArray = top.getElementsByName("tbody", false);
    TagNode tbody = null;
    if (bodyArray.length > 0)
      tbody = bodyArray[0];
    if (tbody != null)
      top = tbody;
    TagNode[] rowArray = top.getElementsByName("tr", false);
    for (int r=0; r<rowArray.length; r++) {
      TagNode[] colArray = rowArray[r].getElementsByName("td", false);
      for (int c=0; c<colArray.length; c++) {
        TagNode cell = colArray[c];
        Iterator<Integer> d = descender.keySet().iterator();
        while (d.hasNext())
          if (d.next() <= colNum)
            colNum++;
        rs = getRowSpan(cell);
        cs = getColSpan(cell);
        for (int row = rowNum; row < rowNum+rs; row++) {
          for (int col=colNum; col < colNum+cs; col++) {
            findTableCellValues(cell, row, col, tagSet);
            if (row == rowNum && rs > 1)
              descender.put(col, rs);
          }
        }
        colNum += cs;
      }
      rowNum++;
      updateDescenders(descender);
      colNum = 0;
    }
  }

  /*
   * Get the colspan attribute
   * @param cell node for table cell (td)
   * @return value of colspan attribute of table cell (default 1)
   */
  private int getColSpan(TagNode cell) {
    String cs = cell.getAttributeByName("colspan");
    if (cs == null)
      return 1;
    return Integer.parseInt(cs);
  }
  
  /*
   * Get the rowspan attribute
   * @param cell node for table cell (td)
   * @return value of rowspan attribute of table cell (default 1)
   */
  private int getRowSpan(TagNode cell) {
    String rs = cell.getAttributeByName("rowspan");
    if (rs == null)
      return 1;
    return Integer.parseInt(rs);
  }
  
  /*
   * Moved to the next row.  Decrement ttl for all descenders
   * or remove if reduced to 0.
   * @param descender map of column/remaining rows affected
   */
  private void updateDescenders(Map<Integer,Integer> descender) {
    Iterator<Integer> d = descender.keySet().iterator();
    while (d.hasNext()) {
      int key = d.next();
      int ttl = descender.get(key);
      if (ttl > 1)
        descender.put(key, ttl-1);
      else
        descender.remove(key);
    }
  }
  
  /*
   * Find values for layout entries given by tags in tagSet for this table cell (td)
   * @param cell table cell (td)
   * @param rowNum row number
   * @param colNum col number
   */
  private void findTableCellValues(TagNode cell, int rowNum, int colNum, Set<String> tagSet) {
//    System.out.println("findTableCellValues(): row: "+rowNum+", col: "+colNum);
//    System.out.println("cell value: "+cell.getText().toString());
    Iterator<String> t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
//      System.out.println("Checking tag: "+tag);
      ParseInfo pi = layout.get(tag);
//      System.out.println("pi.label: "+pi.label()+"pi.row: "+pi.row()+", pi.col: "+pi.col());
      if (pi.row() != -2 && pi.col() != -2) {
        if ((pi.row() == -1 || pi.row() == rowNum)
            && (pi.col() == -1 || pi.col() == colNum))
          addValue(cell.getText().toString(), pi);
      }
      else
        if (!pi.label().equals("")) {
          String cellText = cell.getText().toString();
          if (cellText.contains(pi.label())
              && (pi.exclude().equals("") || !cellText.contains(pi.exclude())))
            if (pi.row() > -2)
              pi.col(colNum);
            else
              pi.row(rowNum);
        }
        else {
          // Throw exception or something....
          throw new RuntimeException("Need more explicit row, col");
        }
    }
  }
  
  /*
   * findValues() looks for el under top and goes through the tags for this
   * domain to fill out the values.
   * @param top top-level node for this domain
   * @param el element name
   * @param tagSet Set of layout entry tags using this domain
   */
  private void findValues(TagNode top, String el, Set<String> tagSet) {
//    System.out.println("findValues(): Element: \""+el+"\"");
    /*
    ArrayList<TagNode> nodeSet = getElementList(top, el);
    */
    TagNode[] nodes = top.getElementsByName(el, true);
    if (nodes == null) {
      Iterator<String> tag = tagSet.iterator();
      while (tag.hasNext()) {
        ParseInfo pi = layout.get(tag.next());
        pi.status(STATUS_ELEMENT);
      }
      return;
    }
    findLabelIndependentValues(nodes, tagSet);
    findLabelDependentValues(nodes, tagSet);
   }
  

  /* 
   * This finds values from absolute offsets.
   * Remove each label independent tag from tagSet.
   * @param nodes Array of TagNode to use
   * @param tagSet Set of affected layout entry tags 
   */
  private void findLabelIndependentValues(TagNode[] nodes, Set<String> tagSet) {
    Set<String> done = new HashSet<String>();
    Iterator<String> t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      if (pi.label().equals("")) {
        if (pi.labelBegin().equals("")) {
          Iterator<Integer> o = pi.offset().iterator();
          while (o.hasNext()) {
            int os = o.next();
            if (os < nodes.length) {
              TagNode vnode = nodes[os];
              addValue(vnode.getText().toString(), pi);
            }
            else
              pi.status(STATUS_OFFSET);
          }
        }
        else
          findSequenceValue(nodes, pi);
        done.add(tag);
      }
    }
    removeTags(tagSet, done);
  }
  
  /*
   * Find a sequence value using labelBegin(), etc.
   * @param nodes Array of nodes to check
   * @param pi ParseInfo for layout entry
   */
  private void findSequenceValue(TagNode[] nodes, ParseInfo pi) {
    boolean inSeq = false;
    for (int n=0; n<nodes.length; n++) {
      String v = nodes[n].getText().toString();
      if (inSeq) {
        if (v.contains(pi.labelEnd())) {
          if (pi.includeEnd())
            addValue(v, pi);
          return;
        }
        addValue(v, pi);
      }
      else
        if (v.contains(pi.labelBegin())) {
          if (pi.includeBegin())
            addValue(v, pi);
          inSeq = true;
        }
    }
  }
  
  /*
   * Add a value to pi.value
   * @param v value to add
   * @param pi ParseInfo for layout entry
   */
  private void addValue(String v, ParseInfo pi) {
    if (pi.exclude().equals("") || !v.contains(pi.exclude())) {
      if (pi.validate() != null) {
        Matcher m = pi.validate().matcher(v);
        if (!m.matches())
          return;
      }
      pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
    }
  }
  
  /*
   * Set operation:  from = from - remove
   * @param from Set on which to operate
   * @param remove Set of strings to remove from from
   */
  private void removeTags(Set<String> from, Set<String> remove) {
    Iterator<String> r = remove.iterator();
    while (r.hasNext())
      from.remove(r.next());
  }
  
  /*
   * This finds values relative to a label
   * @param nodes Array of nodes to use
   * @param tagSet Set of affected layout entry tags
   */
  private void findLabelDependentValues(TagNode[] nodes, Set<String> tagSet) {
    Iterator<String> t;
    for (int n=0; n<nodes.length; n++) {
      TagNode vnode = nodes[n];
      String v = vnode.getText().toString();
      if (!v.equals("")) {
//        System.out.println("Checking: '"+v+"'");
        t = tagSet.iterator();
        while (t.hasNext()) {
          String tag = t.next();
          ParseInfo pi = layout.get(tag);
          if (v.contains(pi.label())) {
            if (pi.closest()) {
            if (v.equals(pi.label()))
              new APElement(vnode, nodes, pi);
            }
            else {
              Iterator<Integer> o = pi.offset().iterator();
              while (o.hasNext()) {
                int off = n+o.next();
                if (off >=0 && off < nodes.length) {
                  vnode = nodes[off];
                  addValue(vnode.getText().toString(), pi);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static final Pattern STYLE_TOP_PATTERN
    = Pattern.compile(".*top\\:(\\d+)(?:px)?\\;.*");
  private static final Pattern STYLE_LEFT_PATTERN
    = Pattern.compile(".*left\\:(\\d+)(?:px)?\\;.*");
  private class APElement {
    private ParseInfo pi = null;
    private Set<DNode> dnSet = null;
    private DNode rn = null;
    private class DNode {
      private String text;
      private int x_distance;
      private int y_distance;
      DNode(String t, int x, int y) {
        text(t);
        x_distance(x);
        y_distance(y);
      }
      public String text() { return text; }
      public void text(String t) { text = t; }
      public int x_distance() { return x_distance; }
      public void x_distance(int d) { x_distance = d; }
      public int y_distance() { return y_distance; }
      public void y_distance(int d) { y_distance = d; }
    }
    
    /*
     * Constructor
     * @param refNode The reference node containing the label
     * @param node Array of nodes to use
     * @param pInfo ParseInfo for layout entry
     */
    APElement(TagNode refNode, TagNode[] node, ParseInfo pInfo) {
      pi = pInfo;
      dnSet = new LinkedHashSet<DNode>();
      String style = refNode.getAttributeByName("style");
      int minDistance = -1;
      String text = "";
      rn = new DNode(refNode.getText().toString(), findLeft(style), findTop(style));
      for (int n=0; n<node.length; n++) {
        if (node[n] != refNode) {
          style = node[n].getAttributeByName("style");
          int nodeX = findLeft(style);
          int nodeY = findTop(style);
          String txt = node[n].getText().toString();
          if (nodeX != -1
              && nodeY != -1
              && nodeX - rn.x_distance() <= pi.xMax()
              && rn.x_distance() - nodeX <= pi.xMin()
              && nodeY - rn.y_distance() <= pi.yMax()
              && rn.y_distance() - nodeY <= pi.yMin()) {
            dnSet.add(new DNode(txt, nodeX, nodeY));
            int d = distance(nodeX, nodeY);
            if (minDistance == -1 || d < minDistance) {
              minDistance = d;
              text = txt;
            }
          }
        }
      }
      if (pi.multiple())
        getMultipleValue();
      else
        pi.value(text);
    }
    
    private void getMultipleValue() {
      Iterator<DNode> dni = dnSet.iterator();
      while (dni.hasNext()) {
        addValue(dni.next().text(), pi);
      }
    }
    
    /*
     * get the square of the distance of x,y from the reference node
     * @param x x distance
     * @param y y distance
     * @return square of distance from reference node 
     */
    private int distance(int x, int y) {
      return (x - rn.x_distance())*(x - rn.x_distance()) + (y - rn.y_distance())*(y - rn.y_distance());
    }
    /*
     * Return the top value from a style attribute or -1 if top is not found.
     * @param style the style attribute of a node
     * @return value of the CSS top entry or -1 if not found
     */
    private int findTop(String style) {
      Matcher m = STYLE_TOP_PATTERN.matcher(style);
      if (m.matches())
        return Integer.parseInt(m.group(1));
      return -1;
    }

  /*
   * Return the left value from a style attribute or -1 if left is not found.
   * @param style the style attribute of a node
   * @return value of the CSS left entry or -1 if not found
   */
    private int findLeft(String style) {
      Matcher m = STYLE_LEFT_PATTERN.matcher(style);
      if (m.matches())
        return Integer.parseInt(m.group(1));
      return -1;
    }
  }
  
  /*
   * This method operates on absolutely positioned elements (usually div), getting the value of
   * the node in the window specified with the closest position to the reference node or the
   * concatenation of all nodes in the window if multiple values are requested.  This only
   * works with elements positioned with a style attribute within the tag.
   */
  
  /*
  private void findClosestInWindow (TagNode node,
                                     TagNode[] allNode,
                                     ParseInfo pi) {
    String style = node.getAttributeByName("style");
    if (style == null)
      return;
    int del = -1;
    int x = findLeft(style),
        y = findTop(style);
    if (x == -1 || y == -1)
      return;
    if (debug) System.out.println("Reference node: x:"+x+", y:"+y+", text:"+node.getText().toString());
    for (int n=0; n<allNode.length; n++) {
      TagNode testNode = allNode[n];
      if (testNode != null) {
        String nodeText = testNode.getText().toString();
        style = testNode.getAttributeByName("style");
        if (style != null) {
          int testX = findLeft(style),
              testY = findTop(style);
          if (testX != -1
              && testY != -1
              && (testX != x || testY != y)
              && testX - x <= pi.xMax()
              && x - testX <= pi.xMin()
              && testY - y <= pi.yMax()
              && y - testY <= pi.yMin()) {
            if (debug) System.out.println("x:"+testX+", y:"+testY+", text:"+nodeText);
            if (pi.multiple())
              addValue(nodeText, pi);
            else {
              int distance = (testX - x)*(testX - x) + (testY - y)*(testY - y);
              if (del == -1 || distance < del) {
                del = distance;
//              System.out.println("del:"+del+", x:"+testX+", y:"+testY+", text:"+testNode.getText().toString());
              if (pi.exclude().equals("") || !nodeText.contains(pi.exclude()))
                pi.value(translate(testNode.getText().toString()));
              }
            }
          }
        }
      }
    }
  }
*/
  
/*
 * Remove specified text, translate and trim
 * @param v value to clean
 * @param pi ParseInfo for layout entry
 * @return cleaned value
 */
  private String cleanValue(String v, ParseInfo pi) {
    if (pi.removeLabel())
      v = v.replace(pi.label(), "");
    return translate(v.replace(pi.remove(), ""));
  }
  
  /*
   * Get the top level node for a domain
   * @param dom String representation of the domain
   * @return top level node for domain
   */
  private TagNode getTop(String dom) {
    if (dom.equals("*"))
      return root;
    int e = dom.indexOf('=');
    String el = dom.substring(0, e).trim();
    int n = Integer.parseInt(dom.substring(e+1));
    return getElement(el, n);
  }

  /*
   * Returns the status value for a tag
   * @param tag layout entry tag
   * @return status of layout entry
   */
  public int getStatus(String tag) {
    return layout.get(tag).status();
  }
  
  /*
   * This method gets the value for a tag from the hash table
   * @param tag layout entry tag
   * @return layout entry value
   */
  public String getValue(String tag) {
    return layout.get(tag).value();
  } 
  
  /*
   * 
   * HtmlParser primitive access methods
   * 
   */
    
  /*
   * Gets the nth element of type name under root
   * @param name element name
   * @param n index
   * @return nth node of type name under root
   */
  private TagNode getElement(String name, int n) {
    return getElement(root, name, n);
  }

  /*
   * Gets the nth element of type name under top
   * @param top top level node
   * @param name element name
   * @param n index
   * @return nth node of type name under top
   */
  private TagNode getElement(TagNode top, String name, int n) {
    TagNode[] l = top.getElementsByName(name, true);
    if (l == null)
      return null;
//    System.out.println("getElement(): "+name+" got "+l.length+" elements");
    if (n >= l.length)
      return null;
    return l[n];
  }
  
  /*
   * 
   *
   *  Utility methods
   *  
   *   
   */
  
  /*
   * translate a string using data from the translation table
   * @param original original string
   * @return translated string
   */
  public String translate (String original) {
    Iterator<String> i = translate.keySet().iterator();
    while (i.hasNext()) {
      String k = i.next();
      original = original.replace(k, translate.get(k));
    }
    return original.trim();
  }

  /*
   * Utility method to create an html file for inspection via browser
   * @param fn file name
   */
  public void makeFile(String fn) {
    // serialize to html file
    SimpleHtmlSerializer serializer = new SimpleHtmlSerializer(htmlCleaner.getProperties());
    try {
      serializer.writeToFile(root, fn);
    } catch (IOException e) {
    }
  }

  /*
   * Return a program string constructed from the (ordered) layout tag values
   * @return space delimited list of layout tags
   */
  protected String getTagString() {
    String l = "";
    Set<String> ks = layout.keySet();
    Iterator<String> i = ks.iterator();
    while (i.hasNext()) {
      l += i.next();
      if (i.hasNext())
        l += " ";
    }
    return l;
  }
  
  
  /*
   * Return an array of values in the same order as the layout entries were given
   * @return array of layout entry values 
   */
  public String[] getValueArray() {
    String[] ret = new String[layout.size()];
    Iterator<String> i = layout.keySet().iterator();
    for (int j=0; i.hasNext(); j++)
      ret[j] = layout.get(i.next()).value();
    return ret;
  }
  
  /*
   * Set the translation map with values from a string array
   * @param arr array of string value to be translated/string to translate to pairs
   */
  public void translate(String[] arr) {
    for (int i = 0; i < arr.length; i += 2)
      translate.put(arr[i], arr[i+1]);
  }
  
  /*
   * Print value of all elements with name (recursively)
   * @param name name of element type
   */
  public void printElements(String name) {
    TagNode[] node = root.getElementsByName(name, true);
    for (int i=0; i < node.length; i++)
      if (node[i].getText() == null)
        System.out.println("null");
      else
        System.out.println(i+": "+node[i].getText().toString().trim());
  }
  
  /**
   * Convenience method to append two strings with a connector
   * @param str1 first string
   * @param connector connector string
   * @param str2 second string
   * @return appended string
   */
  private static String append(String str1, String connector, String str2) {
    if (str1.length() == 0) return str2;
    if (str2.length() == 0) return str1;
    return str1 + connector + str2;
  }
  

}
