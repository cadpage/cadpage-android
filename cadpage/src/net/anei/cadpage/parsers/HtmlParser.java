package net.anei.cadpage.parsers;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlcleaner.*;

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
 *    All of the options and element names are case-insensitive.  Any string value in / / is
 *    case-sensitive.
 *    
 */

public class HtmlParser extends FieldProgramParser {
  private HtmlCleaner htmlCleaner = null;
  private CleanerProperties props = null;
  private TagNode root = null;
  private Map<String, ParseInfo> layout = new HashMap<String, ParseInfo>();
  private Map<String, Set<String>> domain = new HashMap<String, Set<String>>();
  
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
    private Set<Integer>   offset;
    private String         separator;
    private String         exclude;
    private String         remove;
    private String         value;
    private String         xPath;
    private int           xBegin;
    private int           xEnd;
    
    /* Constructor */
    ParseInfo() {
      init();
    }

    private void init() {
      domain = "*";
      element = "";
      label = "";
      row = col = -2;
      removeLabel = false;
      closest = false;
      xMin = 5;
      yMin = 2;
      xMax = 100;
      yMax = 2;
      multiple = false;
      offset(new HashSet<Integer>());
      separator = " ";
      exclude = "";
      remove = "";
      value = "";
      xPath = "";
      xBegin = 0;
      xEnd = -1;
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
  }
  
  /* Constructors */
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
   */
  private void createLayout(String[] pArray) {
    for (int i=0; i<pArray.length; i++) {
      int fp = pArray[i].indexOf('(');
      String tag = pArray[i].substring(0, fp).trim();
      createLayoutEntry(tag, pArray[i].substring(fp+1).replace(")", "").trim());
    }
  }
  
  /*
   * Create layout entry for tag with instructions
   */
  private void createLayoutEntry(String tag, String instructions) {
//    System.out.println("Tag: \""+tag+"\"");
    ParseInfo pi = new ParseInfo();
    String command[] = instructions.split("(?<!\\\\);");
    for (int i=0; i<command.length; i++)
      processCommand(command[i].trim(), pi);
    // Offset defaults to 0 but if no OFFSET= cmd was given there won't be anything in
    // the set:
    if (pi.offset().isEmpty())
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
  
  private void processCommand(String c, ParseInfo pi) {
//    System.out.println("Command: \""+c+"\"");
    if (c.equalsIgnoreCase("MULTIPLE"))
      pi.multiple(true);
    else if (c.equalsIgnoreCase("REMOVE_LABEL"))
      pi.removeLabel(true);
    else if (c.equalsIgnoreCase("CLOSEST"))
      pi.closest(true);
    else
      if (c.contains("=")) {
        int ep = c.indexOf('=');
        processAttributeValue(c.substring(0, ep).trim(), c.substring(ep+1).trim(), pi);
      }
  }

  /*
   * If a is attribute set a to v, else set domain to lower case a = v
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
    else if (a.equalsIgnoreCase("xpath"))
      pi.xPath(stringContent(v));
    else if (a.equalsIgnoreCase("xbegin"))
      pi.xBegin(Integer.parseInt(v));
    else if (a.equalsIgnoreCase("xend"))
      pi.xEnd(Integer.parseInt(v));
    else
      pi.domain(a.toLowerCase()+"="+v);
  }
  
  private int rowColValue (String v) {
    if (v.equals("*"))
      return -1;
    return Integer.parseInt(v);
  }
  
  private String stringContent(String delimitedString) {
    if (delimitedString.charAt(0) != '/'
        || delimitedString.charAt(delimitedString.length()-1) != '/') {
      System.out.println("Improperly delimited string: "+delimitedString);
      return null;
    }
    return delimitedString.substring(1, delimitedString.length()-1);
  }
  
  private void setOffset(String oString, ParseInfo pi) {
    String[] part = oString.split(",");
    for (int p=0; p<part.length; p++)
      addOffset(part[p].trim(), pi);
  }
  
  private void addOffset(String oString, ParseInfo pi) {
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
   * I may have to tweak this one.  These properties were from an example online
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
   * value of the xmlns attribute so strip out all occurances.
   */
  private static final String XMLNS_PATTERN_STRING
  = "(?is)xmlns=\\\".*?\\\"";
  protected boolean getHtmlCleaner(String html) {
//    int n;
    if (!getHtmlCleaner())
        return false;
    root = htmlCleaner.clean(html.replaceAll(XMLNS_PATTERN_STRING, ""));

    if (root != null)
      if (!layout.isEmpty())
        getValues();
    return root != null;
  }
  

  /*
   * This is where the actual values are located and put into the layout
   */
  private void getValues() {
    Set<String> key = layout.keySet();
    Iterator<String> k = key.iterator();
    while (k.hasNext()) {
      String tag = k.next();
      ParseInfo pi = layout.get(tag);
      // Must initialize or values from prev. msg will be carried over
      pi.value("");
    }
    key = domain.keySet();
    k = key.iterator();
    while (k.hasNext()) {
      String d = k.next();
      Set<String> domainTagSet = new HashSet<String>(domain.get(d));
      while (processDomain(d))
        ;
      domain.put(d, domainTagSet);
    }
  }

  /*
   * This method processes the instructions to get values for all tags
   * with the same domain.  Currently, only 1 search element is allowed.
   * Thus NAME(TABLE=5;ELEMENT=TD;LABEL=/Person:/;OFFSET=1) and
   * PHONE(TABLE=5;ELEMENT=TD;LABEL=/Phone:/;OFFSET=1) will get processed together
   * but SOURCE(TABLE=5;ELEMENT=H2) would get processed in another pass.
   * This will be corrected in a future version.
   */
  private boolean processDomain(String d) {
    Set<String> tagSet = domain.get(d);
    Set<String> finalTagSet = new HashSet<String>(tagSet);
    TagNode top = getTop(d);    
    Iterator<String> t = tagSet.iterator();
    String el = "";
//    System.out.println("processDomains("+d+"):  Tags:");
//    while (t.hasNext())
//      System.out.println("\t\""+t.next()+"\"");
//    t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      if (!pi.xPath.equals("")) {
        getXPathValue(top, pi);
        tagSet.remove(tag);
        finalTagSet.remove(tag);
      }
      if (el.equals("")) {
        el = pi.element();
        finalTagSet.remove(tag);
      }
      else if (el.equals(pi.element()))
        finalTagSet.remove(tag);
      else
        tagSet.remove(tag);
    }
    // Now tagSet contains tags with like elements
    // If top element is "TABLE" use table processing logic
    if (d.contains("TABLE")) {
      saveRowCol(tagSet);
      findTableValues(top, tagSet);
      restoreRowCol(tagSet);
    }
    else
      findValues(top, el, tagSet);
    domain.put(d, finalTagSet);
    return (!finalTagSet.isEmpty());
  }

  /*
   * Evaluate XPath to get the value
   */
  private void getXPathValue(TagNode top, ParseInfo pi) {
    Object[] node = null;
    try {
      node = top.evaluateXPath(pi.xPath());
    }  catch (XPatherException e) {
      throw new RuntimeException(e.getMessage());
    }
    for (int n=pi.xBegin(); n<node.length && (pi.xEnd() == -1 || n<=pi.xEnd()); n++) {
      String v = ((TagNode)node[n]).getText().toString();
      if (pi.exclude().equals("") || !v.contains(pi.exclude()))
        pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
    }
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
          for (int col=colNum; col <= colNum+cs; col++) {
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
            && (pi.col() == -1 || pi.col() == colNum))
          pi.value(append(pi.value, pi.separator(), cleanValue(cell.getText().toString(), pi)));
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
  
  private void findValues(TagNode top, String el, Set<String> tagSet) {
//    System.out.println("findValues(): Element: \""+el+"\"");
    /*
    ArrayList<TagNode> nodeSet = getElementList(top, el);
    */
    if (top == null)
      return;
    TagNode[] node = top.getElementsByName(el, true);
    if (node == null)
      // System.out.println("Got null element list in findValues()");
      return;
    Set<String> done = findLabelIndependentValues(node, tagSet);
    Iterator<String> i = done.iterator();
    while (i.hasNext())
      tagSet.remove(i.next());
    findLabelDependentValues(node, tagSet);
   }
  
  /*
  // Why is this necessary??? v2.4 worked
  private ArrayList<TagNode> getElementList(TagNode top, String el) {
    if (top == null)
      return null;
    if (el == null)
      return null;
    TagNode[] nodeList = top.getElementsByName(el, true);
//    TagNode[] nodeList = top.getAllElements(true);    
    ArrayList<TagNode> ret = new ArrayList<TagNode>();
    for (int n=0; n<nodeList.length; n++)
      ret.add(nodeList[n]);
    return ret;
  }
  */
  
  private Set<String> findLabelIndependentValues(TagNode[] node, Set<String> tagSet) {
    Set<String> ret = new HashSet<String>();
    Iterator<String> t = tagSet.iterator();
    while (t.hasNext()) {
      String tag = t.next();
      ParseInfo pi = layout.get(tag);
      if (pi.label().equals("")) {
        Iterator<Integer> o = pi.offset().iterator();
        while (o.hasNext()) {
          int os = o.next();
          if (os < node.length) {
            TagNode vnode = node[os];
            String v = vnode.getText().toString();
            if (pi.exclude().equals("") || !v.contains(pi.exclude()))
              pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
          }
        }
        ret.add(tag);
      }
    }
    return ret;
  }
  
  private void findLabelDependentValues(TagNode[] node, Set<String> tagSet) {
    Iterator<String> t;
    Set<String> done = new HashSet<String>();
    for (int n=0; n<node.length; n++) {
      TagNode vnode = node[n];
      String v = vnode.getText().toString();
      if (!v.equals("")) {
        t = tagSet.iterator();
        while (t.hasNext()) {
          String tag = t.next();
          ParseInfo pi = layout.get(tag);
          if (v.contains(pi.label())) {
            if (pi.closest()) {
              findClosestInWindow(vnode, node, pi);
              done.add(tag);
            }
            else {
              Iterator<Integer> o = pi.offset().iterator();
              while (o.hasNext()) {
                int off = n+o.next();
                if (off >=0 && off < node.length) {
                  vnode = node[off];
                  v = vnode.getText().toString();
                  if (pi.exclude().equals("") || !v.contains(pi.exclude())) {
                    pi.value(append(pi.value(), pi.separator(), cleanValue(v, pi)));
                    if (!pi.multiple())
                      done.add(tag);
                  }
                }
              }
            }
          }
        }
        t = done.iterator();
        while (t.hasNext())
          tagSet.remove(t.next());
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
  
private static final Pattern STYLE_TOP_PATTERN
  = Pattern.compile(".*top\\:(\\d+)(?:px)?\\;.*");
private int findTop(String style) {
  Matcher m = STYLE_TOP_PATTERN.matcher(style);
  if (m.matches())
    return Integer.parseInt(m.group(1));
  return -1;
}

private static final Pattern STYLE_LEFT_PATTERN
  = Pattern.compile(".*left\\:(\\d+)(?:px)?\\;.*");
private int findLeft(String style) {
  Matcher m = STYLE_LEFT_PATTERN.matcher(style);
  if (m.matches())
    return Integer.parseInt(m.group(1));
  return -1;
}

/*
 * Remove specified text and trim
 */
  private String cleanValue(String v, ParseInfo pi) {
    if (pi.removeLabel())
      v = v.replace(pi.label(), "");
    return v.replace(pi.remove(), "").trim();
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
   * This method gets the value for a tag from the hash table
   */
  protected String getValue(String tag) {
    return layout.get(tag).value();
  }
  
  /*
   * 
   * Direct access methods.  These methods are deprecated.
   * 
   */
  /*
   * Return the value of the nth element after element containing lookFor
   */
  protected String getValueInElementAfter(String lookFor,
                                            String elementName,
                                            int n,
                                            boolean includeFirst) {
    TagNode[] testNode = root.getElementsByName(elementName, true);
    for (int i=includeFirst? 0: 1; i<testNode.length; i++) {
      String label = testNode[i].getText().toString();
      if (label.contains(lookFor))
        if (i<testNode.length - n)
          return testNode[i+n].getText().toString();
    }
    return null;
  }
  
  /*
   * Like the above but exclude elements whose value contains exceptFor 
   */
  protected String getValueInElementAfterExcept(String lookFor,
                                                  String elementName,
                                                  String exceptFor,
                                                  int n,
                                                  boolean includeFirst) {
    String v = getValueInElementAfter(lookFor, elementName, n, includeFirst);
    return v.contains(exceptFor)? "": v;
  }
  
  
  
  /*
   * This method looks at ALL table cells (recursively) and returns the value of
   * the nth table cell after the one containing lookFor or null on failure
   */
  
  protected String getTableCellValueAfter(String lookFor, int n) {
    TagNode[] node = root.getElementsByName("td", true);
    for (int i=0; i<node.length; i++) {
      String label = node[i].getText().toString();
      if (label.contains(lookFor))
        if (i < node.length-n)
          return node[i+n].getText().toString();
    }
    return null;
  }
  
  /*
   * This method returns the value of the table cell containing lookFor
   * with lookFor removed
   */
  protected String getTableCellValueWith(String lookFor) {
    String label = getOptGroup(getTableCellValueAfter(lookFor, 0));
    return label.replace(lookFor, "");
  }
  
  /*
   * Like the above method but returns set of ALL matching table cells
   */
  protected Set<String> getTableCellValuesWith(String lookFor) {
    TagNode[] node = root.getElementsByName("td", true);
    Set<String> ret = new HashSet<String>();
    for (int i=0; i<node.length; i++) {
      String label = node[i].getText().toString();
      if (label.contains(lookFor))
        ret.add(label.replace(lookFor, ""));
    }
    return ret;
  }
  
  /*
   * getTableCellValueAfter will do this, too.  Probably should use this one if you know
   * the table number and generally on better-behaved html
   */
  protected String getTableCellValue(int t, String rowHeader, int c) {
    TagNode table = getElement("table", t);
    if (table == null)
      return null;
/*
 *     TagNode[] rowList = table.getElementsByName("tr", true);
 */
    TagNode[] cell = table.getElementsByName("td", true);
    for (int i=0; i<cell.length; i++) {
      String header = cell[i].getText().toString();
      if (header.contains(rowHeader))
        return cell[i+c].getText().toString();
    }
    return null;
  }
  
  /*
   * Get the value of a table cell given table number, row and column
   */
  protected String getTableCellValue(int t, int r, int c) {
//    System.out.println("getTableCellValue(): table "+t+", row "+r+", col"+c);
    TagNode table = getElement("table", t);
    if (table == null)
      return null;
    TagNode row = getElement(table, "tr", r);
    if (row == null)
      return null;
    String cellValue = getElementValue(row, "td", c);
    return cellValue;
  }
  
  /*
   * Gets the value of the nth element (under root, recursively) named name
   */
  protected String getElementValue(String name, int n) {
    TagNode element = getElement(name, n);
    if (element == null)
      return null;
    return element.getText().toString();
  }
  
  /*
   * 
   * HtmlParser primitive access methods
   * 
   */
  /*
   * Gets the value of the nth element under top (recursively) named name
   */
  private String getElementValue(TagNode top, String name, int n) {
    TagNode element = getElement(top, name, n);
    if (element == null)
      return null;
    return element.getText().toString();
  }
  
  /*
   * Gets the nth element of type name under root
   */
  private TagNode getElement(String name, int n) {
    return getElement(root, name, n);
  }

  private TagNode[] getElements(String name) {
    return getElements(root, name);
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

  private TagNode[] getElements(TagNode top, String name) {
    return top.getElementsByName(name, false);
  }
  
  /*
   * 
   *
   *  Utility methods
   *  
   *   
   */
  public String clean (String dirty) {
    return dirty.replace("\\t", "").replace("\n", "").trim();
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
      System.out.println("makeFile()"+e.getMessage());
    }
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
