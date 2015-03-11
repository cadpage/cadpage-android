package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class HtmlProgramParser extends FieldProgramParser {
  private HtmlDecoder decoder = new HtmlDecoder();
  
  /* HtmlParser Constructors */
  public HtmlProgramParser(String defCity, String defState, String prog) {
    super(defCity, defState, prog);
  }
  
  public HtmlProgramParser(String[] cityList, String defCity, String defState, String prog) {
    super(cityList, defCity, defState, prog);
  }
  
  public HtmlProgramParser(Properties cityCode, String defCity, String defState, String prog) {
    super(cityCode, defCity, defState, prog);
  }

  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    String[] flds = decoder.parseHtml(body);
    if (flds == null) return false;
    return parseFields(flds, data);
  }
}
