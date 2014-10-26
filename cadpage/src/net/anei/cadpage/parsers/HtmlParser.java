package net.anei.cadpage.parsers;

// import android.annotation.SuppressLint;
// import android.annotation.TargetApi;
// import android.os.Build;

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

import net.anei.cadpage.parsers.FieldProgramParser;

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

// @TargetApi(Build.VERSION_CODES.FROYO)
// @SuppressLint("NewApi")
public class HtmlParser extends FieldProgramParser {
  private HtmlCleaner htmlCleaner = null;
  private CleanerProperties props = null;
  private TagNode root = null;
  private Map<String, ParseInfo> layout = new LinkedHashMap<String, ParseInfo>();
  private Map<String, Set<String>> domain = new HashMap<String, Set<String>>();
  private Map<String, String> translate = new HashMap<String, String>();
  private org.w3c.dom.Document doc;
  private boolean hasXPath = false;

  protected static final int
    STATUS_OK = 0,
    STATUS_UNINITIALIZED = 1,
    STATUS_DOMAIN = 2,
    STATUS_ELEMENT = 3,
    STATUS_LABEL = 4,
    STATUS_OFFSET = 5,
    STATUS_ROW = 6,
    STATUS_COL = 7;
  
  private class ParseInfo {
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
    private boolean       required;
    private Set<Integer>   offset;
    private String         separator;
    private String         exclude;
    private String         remove;
    private String         value;
    private String         xPath;
    private int           xBegin;
    private int           xEnd;
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
      required(false);
      offset(new HashSet<Integer>());
      separator(" ");
      exclude("");
      remove("");
      value("");
      xPath("");
      xBegin(0);
      xEnd(-1);
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
    public boolean xJava() { return xJava; }
    public void xJava(boolean xj) { xJava = xj; }
    public int status() { return status; }
    public void status(int s) { status = s; }
  }
  
  /* HtmlParser Constructors */
  public HtmlParser(String defCity,
                      String defState,
                      String prog,
                      String[] layoutArray) {
    super(defCity, defState, prog);
    createLayout(layoutArray);
  }

  public HtmlParser(String[] cityList,
                      String defCity,
                      String defState,
                      String prog,
                      String[] layoutArray) {
    super(cityList, defCity, defState, prog);
    createLayout(layoutArray);
  }
  
  public HtmlParser(Properties cityCode,
                      String defCity,
                      String defState,
                      String prog,
                      String[] layoutArray) {
    super(cityCode, defCity, defState, prog);
    createLayout(layoutArray);
  }

  public HtmlParser(String defCity,
                      String defState,
                      String prog) {
    super(defCity, defState, prog);
  }

  public HtmlParser(String[] cityList,
                      String defCity,
                      String defState,
                      String prog) {
    super(cityList, defCity, defState, prog);
  }
  
  public HtmlParser(Properties cityCode,
                      String defCity,
                      String defState,
                      String prog) {
    super(cityCode, defCity, defState, prog);
  }

  @Override
  public String getProgram() {
    return getOptGroup(super.getProgram());
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
    else
      if (c.contains("=")) {
        int ep = c.indexOf('=');
        processAttributeValue(c.substring(0, ep).trim(), c.substring(ep+1).trim(), pi);
      }
  }

  /*
   * If a is a valid attribute set a to v.  Otherwise,
   * it is a domain spec so set domain to "a=v".
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
    else
      pi.domain(a.toLowerCase()+"="+v);
  }
  
  /*
   * If v is "*" return -1, otherwise
   * return int value.
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
   */
  private void setOffset(String oString, ParseInfo pi) {
    String[] part = oString.split(",");
    for (int p=0; p<part.length; p++)
      addOffset(part[p].trim(), pi);
  }
  
  /*
   * oString contains an offset or a range of offsets (min - max)
   * parse it and update pi.
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
   */
  private static final String XMLNS_PATTERN_STRING
  = "(?is)xmlns=\\\".*?\\\"";
  protected boolean getHtmlCleaner(String html) {
//    int n;
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
   * Returns true if NOT all tags were successfully processed.
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
      for (int n=pi.xBegin(); n<node.length && (pi.xEnd() == -1 || n<=pi.xEnd()); n++) {
//        System.out.println("'"+((TagNode)node[n]).getName()+"'");
        String v = ((TagNode)node[n]).getText().toString();
        if (pi.exclude().equals("") || !v.contains(pi.exclude()))
          pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
      }
    }
    pi.status(STATUS_OK);    
  }

  /*
   * Evaluate XPath using Java XPath engine
   */
  private void getJXPathValue(TagNode top, ParseInfo pi) {
    NodeList nl;
//    System.out.println("XPATH: '"+pi.xPath()+"'");
    XPath xpath = XPathFactory.newInstance().newXPath();
    try {
      nl = (NodeList) xpath.evaluate(pi.xPath, doc, XPathConstants.NODESET);
    } catch (XPathExpressionException e) {
      throw new RuntimeException("XPath Error");
    }
    for (int i=0; i<nl.getLength(); i++)
      pi.value(append(pi.value, pi.separator(), cleanValue(nl.item(i).getTextContent(), pi)));
  }
  
  /*
   * Save the original values of row and col to xMin & yMin
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
   */
  private void findTableValues(TagNode top, Set<String> tagSet) {
    int rowNum = 0, colNum = 0, rs, cs;
    Map<Integer,Integer> descender = new LinkedHashMap<Integer,Integer>();
    
    if (top == null) {
//      System.out.println("findTableValues():  null domain");
      Iterator<String> tag = tagSet.iterator();
      while (tag.hasNext()) {
        ParseInfo pi = layout.get(tag);
        pi.status(pi.status() | STATUS_DOMAIN);
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
   */
  private int getColSpan(TagNode cell) {
    String cs = cell.getAttributeByName("colspan");
    if (cs == null)
      return 1;
    return Integer.parseInt(cs);
  }
  
  /*
   * Get the rowspan attribute
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
            && (pi.col() == -1 || pi.col() == colNum)) {
          if (pi.exclude().equals("") || !cell.getText().toString().contains(pi.exclude()))
            pi.value(append(pi.value, pi.separator(), cleanValue(cell.getText().toString(), pi)));
          pi.status(STATUS_OK);
        }
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
   */
  private void findLabelIndependentValues(TagNode[] nodes, Set<String> tagSet) {
    Set<String> done = new HashSet<String>();
    Iterator<String> t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      if (pi.label().equals("")) {
        Iterator<Integer> o = pi.offset().iterator();
        while (o.hasNext()) {
          int os = o.next();
          if (os < nodes.length) {
            TagNode vnode = nodes[os];
            String v = vnode.getText().toString();
            if (pi.exclude().equals("") || !v.contains(pi.exclude()))
              pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
          }
          else
            pi.status(STATUS_OFFSET);
        }
        done.add(tag);
      }
      pi.status(STATUS_OK);
    }
    removeTags(tagSet, done);
  }
  
  /*
   * Set operation:  from = from - remove
   */
  private void removeTags(Set<String> from, Set<String> remove) {
    Iterator<String> r = remove.iterator();
    while (r.hasNext())
      from.remove(r.next());
  }
  
  /*
   * This finds values relative to a label
   */
  private void findLabelDependentValues(TagNode[] nodes, Set<String> tagSet) {
    Iterator<String> t;
    for (int n=0; n<nodes.length; n++) {
      TagNode vnode = nodes[n];
      String v = vnode.getText().toString();
      if (!v.equals("")) {
        t = tagSet.iterator();
        while (t.hasNext()) {
          String tag = t.next();
          ParseInfo pi = layout.get(tag);
          if (v.contains(pi.label())) {
            if (pi.closest())
              findClosestInWindow(vnode, nodes, pi);
            else {
              Iterator<Integer> o = pi.offset().iterator();
              while (o.hasNext()) {
                int off = n+o.next();
                if (off >=0 && off < nodes.length) {
                  vnode = nodes[off];
                  v = vnode.getText().toString();
                  if (pi.exclude().equals("") || !v.contains(pi.exclude()))
                    pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
                }
              }
            }
          }
        }
      }
    }
  }
  
  /*
   * This method operates on absolutely positioned elements (usually div), getting the value of
   * the node in the window specified with the closest position to the reference node or the
   * concatenation of all nodes in the window if multiple values are requested.  This only
   * works with elements positioned with a style attribute within the tag.
   */
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
//    System.out.println("Reference node: x:"+x+", y:"+y+", text:"+node.getText().toString());
    for (int n=0; n<allNode.length; n++) {
      TagNode testNode = allNode[n];
      if (testNode != null) {
        String nodeText = testNode.getText().toString();
        style = testNode.getAttributeByName("style");
        if (pi.exclude().equals("") || !nodeText.contains(pi.exclude())) {
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
              if (pi.multiple())
//              System.out.println("x:"+testX+", y:"+testY+", text:"+testNode.getText().toString());
                pi.value(append(pi.value(), pi.separator(), cleanValue(testNode.getText().toString(), pi)));
              else {
                int distance = (testX - x)*(testX - x) + (testY - y)*(testY - y);
                if (del == -1 || distance < del) {
                  del = distance;
//              System.out.println("del:"+del+", x:"+testX+", y:"+testY+", text:"+testNode.getText().toString());
                  pi.value(cleanValue(testNode.getText().toString(), pi));
                }
              }
            }
          }
        }
      }
    }
  }

  /*
   * Return the top value from a style attribute or -1 if top is not found.
   */
  private static final Pattern STYLE_TOP_PATTERN
    = Pattern.compile(".*top\\:(\\d+)(?:px)?\\;.*");
  private int findTop(String style) {
    Matcher m = STYLE_TOP_PATTERN.matcher(style);
    if (m.matches())
      return Integer.parseInt(m.group(1));
    return -1;
  }

/*
 * Return the left value from a style attribute or -1 if left is not found.
 */
  private static final Pattern STYLE_LEFT_PATTERN
    = Pattern.compile(".*left\\:(\\d+)(?:px)?\\;.*");
  private int findLeft(String style) {
    Matcher m = STYLE_LEFT_PATTERN.matcher(style);
    if (m.matches())
      return Integer.parseInt(m.group(1));
    return -1;
  }

/*
 * Remove specified text, translate and trim
 */
  private String cleanValue(String v, ParseInfo pi) {
    if (pi.removeLabel())
      v = v.replace(pi.label(), "");
    return translate(v.replace(pi.remove(), ""));
  }
  
  /*
   * Get the top level node for a domain
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
   * 
   * subclass access methods.  It is strongly recommended to
   * use getValue() with a layout to access all data.
   */

  /*
   * Returns the status value for a tag
   */
  protected int getStatus(String tag) {
    return layout.get(tag).status();
  }
  
  /*
   * This method gets the value for a tag from the hash table
   */

  protected String getValue(String tag) {
    return layout.get(tag).value();
  } 
  
  /*
   * 
   * HtmlParser primitive access methods
   * 
   */
    
  /*
   * Gets the nth element of type name under root
   */
  private TagNode getElement(String name, int n) {
    return getElement(root, name, n);
  }

  /*
   * Gets the nth element of type name under top
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
   * Return an array of values in the same order as the layout entries were given 
   */
  protected String[] getValueArray() {
    String[] ret = new String[layout.size()];
    Iterator<String> i = layout.keySet().iterator();
    for (int j=0; i.hasNext(); j++)
      ret[j] = layout.get(i.next()).value();
    return ret;
  }
  
  /*
   * Set the translation map with values from a string array
   */
  protected void translate(String[] arr) {
    for (int i = 0; i < arr.length; i += 2)
      translate.put(arr[i], arr[i+1]);
  }
  
  /*
   * Print value of all elements with name (recursively) 
   */
  protected void printElements(String name) {
    TagNode[] node = root.getElementsByName(name, true);
    for (int i=0; i < node.length; i++)
      if (node[i].getText() == null)
        System.out.println("null");
      else
        System.out.println(i+": "+node[i].getText().toString().trim());
  }
}
