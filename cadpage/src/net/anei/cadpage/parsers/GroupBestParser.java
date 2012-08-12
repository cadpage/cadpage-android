package net.anei.cadpage.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupBestParser extends MsgParser {
  
  private MsgParser[] parsers;
  
  private String dispFilter;
  
  private String sponsor;
  
  public GroupBestParser(MsgParser ... parsers) {
    super("", "");
    
    // Build the final array of parsers.  eliminating parsers that are aliased
    // to another parser in the list
    List<MsgParser> parserList = new ArrayList<MsgParser>(parsers.length);
    Map<String, MsgParser> aliasMap = new HashMap<String, MsgParser>();
    
    // Loop through the parser list
    for (MsgParser parser : parsers) {
      
      // See if this parser has an alias code
      String aliasCode = parser.getAliasCode();
      if (aliasCode != null) {
        
        // Yep, see if we have already processed a parser with the same alias code
        MsgParser mainParser = aliasMap.get(aliasCode);
        if (mainParser != null) {
          
          // Yes again.  The main parser is going to replace the aliased parser
          // but before we discard the new parser, see if it has a different
          // default city or state then the main parser.  If it does, reset the
          // main parser default city or state value to an empty string.
          String defCity = mainParser.getDefaultCity();
          if (defCity.length() > 0 && !defCity.equals(parser.getDefaultCity())) {
            mainParser.setDefaultCity("");
          }
          String defState = mainParser.getDefaultState();
          if (defState.length() > 0 && !defState.equals(parser.getDefaultState())) {
            mainParser.setDefaultState("");
          }
          parser = null;
        } 
        
        // No, we do not yet have another parser with this alias code.  So we keep this
        // parser, but add it to the alias map in case another parser is aliased to this one
        else {
          aliasMap.put(aliasCode, parser);
        }
      }
      
      // If we haven't dropped this parser because it is aliased to another one, 
      // add it to this list
      if (parser != null) parserList.add(parser);
    }
    
    // Convert the adjusted parser list back to an array
    this.parsers = parserList.toArray(new MsgParser[parserList.size()]);
    setDefaultCity(parsers[0].getDefaultCity());
    setDefaultState(parsers[0].getDefaultState());
    
    // Build a display filter by concatenating all of the filters of
    // our constituent parsers.  As the name implies, this will never be
    // used to do any real filtering, but it will give us something to 
    // display in the settings menu
    StringBuilder sb = new StringBuilder();
    for (MsgParser parser : this.parsers) {
      String filter = parser.getFilter();
      if (filter.length() > 0) {
        if (sb.length() > 0) sb.append(',');
        sb.append(filter);
      }
    }
    dispFilter = sb.toString();
    
    // Group parser is sponsored if all of it subparsers are sponsored
    sponsor = null;
    for (MsgParser parser : this.parsers) {
      String pSponsor = parser.getSponsor();
      if (pSponsor == null) {
        sponsor = null;
        break;
      } else if (sponsor == null) {
        sponsor = pSponsor;
      }
    }
  }
  
  @Override
  public String getFilter() {
    return dispFilter;
  }

  @Override
  protected Data parseMsg(Message msg, int parserFlags) {
    
    // OK, this gets complicated
    // If all three flags are on (which is what PARSE_FLG_FORCE is, we can't
    // pass them directly to the subparsers.  If we do, they will all return
    // a general alert status, possibly masking a real positive parser hit from
    // one of the other parsers.  In this case, and this case only, we turn off
    // the general alert flag passed to subparsers and handle it ourselves
    int tFlags = parserFlags;
    boolean genAlert = (tFlags & MsgParser.PARSE_FLG_FORCE) == MsgParser.PARSE_FLG_FORCE;
    if (genAlert) tFlags &= ~PARSE_FLG_GEN_ALERT;
    
    int bestScore = -1;
    Data bestData = null;
    
    for (MsgParser parser : parsers) {
      Data tmp = parser.parseMsg(msg, tFlags);
      if (tmp != null) {
        int newScore = tmp.score();
        if (!parser.getParserCode().startsWith("General")) newScore +=25;
        if (newScore > bestScore) {
          bestData = tmp;
          bestScore = newScore;
        }
      }
    }
    
    if (bestData != null) return bestData;
    
    // If non of our subparsers found this to be valid page, and the original
    // flags forced a general alert, handle that now
    if (genAlert) {
      return ManageParsers.getInstance().getAlertParser().parseMsg(msg, parserFlags);
    }
    
    return null;
  }

  // We have to override this to satisfy abstract requirements, but it will
  // never be called and doesn't have to do anything
  @Override
  protected boolean parseMsg(String strMessage, Data data) {
    return false;
  }

  @Override
  public String getSponsor() {
    return sponsor;
  }
  
  
}
