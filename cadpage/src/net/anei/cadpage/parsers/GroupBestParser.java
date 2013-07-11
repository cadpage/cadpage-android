package net.anei.cadpage.parsers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupBestParser extends GroupBaseParser {
  
  private MsgParser[] parsers;
  
  private String sponsor;
  
  private Date sponsorDate;
  
  public GroupBestParser(MsgParser ... parsers) {
    
    // Build the final array of parsers.  eliminating parsers that are aliased
    // to another parser in the list
    List<MsgParser> parserList = new ArrayList<MsgParser>(parsers.length);
    Map<String, MsgParser> aliasMap = new HashMap<String, MsgParser>();
    
    // Loop through the parser list
    for (MsgParser parser : parsers) {
      
      // Merge the default city/state and filter information.  None of these
      // are really used for any maping or filtering, but they do end up
      // calculating the displayed location name and sender filter.
      addParser(parser);
      
      // See if this parser has an alias code
      String aliasCode = parser.getAliasCode();
      if (aliasCode != null) {
        
        // Yep, see if we have already processed a parser with the same alias code
        MsgParser mainParser = aliasMap.get(aliasCode);
        if (mainParser != null) {
          
          // Yes again.  The main parser is going to replace the aliased parser
          // First step is to make sure the  main parser is an AliasedMsgParser
          // that we can adjust to include things that may differ between aliased
          // parsers
          AliasedMsgParser aliasParser;
          if (mainParser instanceof AliasedMsgParser) {
            aliasParser = (AliasedMsgParser)mainParser;
          } else {
            aliasParser = new AliasedMsgParser(mainParser);
            aliasMap.put(aliasCode, aliasParser);
            int ndx = parserList.indexOf(mainParser);
            parserList.set(ndx, aliasParser);
          }
          
          // Now that that is taken care of, just add the new parser
          // to the aliased one
          aliasParser.addMsgParser(parser);
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
    
    // Group parser is sponsored if all of it subparsers are sponsored
    // If all subparsers are sponsored, sponsor date is the earliest subparser sponsor date
    sponsor = null;
    sponsorDate = null;
    for (MsgParser parser : parsers) {
      String pSponsor = parser.getSponsor();
      if (pSponsor == null) {
        sponsor = null;
        sponsorDate = null;
        break;
      } else {
        Date pDate = parser.getSponsorDate();
        if (pDate == null) {
          if (sponsor == null) sponsor = pSponsor;
        } else {
          if (sponsorDate == null || sponsorDate.after(pDate)) {
            sponsor = pSponsor;
            sponsorDate = pDate;
          }
        }
      }
    }
  }

  @Override
  protected Data parseMsg(Message msg, int parserFlags) {
    
    // OK, this gets complicated
    // if PARSE_FLG_GEN_ALERT is set, we can't
    // pass them directly to the subparsers.  If we do, they will all return
    // a general alert status, possibly masking a real positive parser hit from
    // one of the other parsers.  In this case, and this case only, we turn off
    // the general alert flag passed to subparsers and handle it ourselves
    int tFlags = parserFlags;
    boolean genAlert = (parserFlags & PARSE_FLG_FORCE) == PARSE_FLG_FORCE;
    if (genAlert) {
      tFlags |= PARSE_FLG_RUN_REPORT;
      tFlags &= ~PARSE_FLG_GEN_ALERT;
    }
    
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
  
  @Override
  public Date getSponsorDate() {
    return sponsorDate;
  }
  
  
}
