package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.parsers.HtmlParser;

public class FieldProgramHtmlParser extends FieldProgramParser {
private HtmlParser htmlParser = null;

/* HtmlParser Constructors */
public FieldProgramHtmlParser(String defCity,
                    String defState,
                    String prog,
                    String[] layoutArray) {
    super(defCity, defState, prog);
    htmlParser = new HtmlParser(layoutArray);
  }
  
  public FieldProgramHtmlParser(String[] cityList,
                      String defCity,
                      String defState,
                      String prog,
                      String[] layoutArray) {
    super(cityList, defCity, defState, prog);
    htmlParser = new HtmlParser(layoutArray);
  }
  
  public FieldProgramHtmlParser(Properties cityCode,
                      String defCity,
                      String defState,
                      String prog,
                      String[] layoutArray) {
    super(cityCode, defCity, defState, prog);
    htmlParser = new HtmlParser(layoutArray);
  }
  
  protected boolean getHtmlCleaner(String html) {
    return htmlParser.getHtmlCleaner(html);
  }
  
  protected void translate(String[] trans) {
    htmlParser.translate(trans);
  }
  
  protected String getValue(String tag) {
    return htmlParser.getValue(tag);
  }
  
  protected String[] getValueArray() {
    return htmlParser.getValueArray();
  }

  
  public String translate(String raw) {
    return htmlParser.translate(raw);
  }
}
