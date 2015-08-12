package net.anei.cadpage.parsers;

public class SplitMsgOptionsCustom implements SplitMsgOptions {
  
  private int splitMinMsg;
  private boolean splitBlankIns;
  private boolean splitChkSender;
  private boolean splitKeepLeadBreak;
  private boolean revMsgOrder;
  
  public SplitMsgOptionsCustom(int splitMinMsg, boolean splitBlankIns, 
                                boolean splitChkSender, boolean splitKeepLeadBreak, 
                                boolean revMsgOrder) {
    this.splitMinMsg = splitMinMsg;
    this.splitBlankIns = splitBlankIns;
    this.splitChkSender = splitChkSender;
    this.splitKeepLeadBreak = splitKeepLeadBreak;
    this.revMsgOrder = revMsgOrder;
  }

  @Override
  public boolean splitDirectPage() {
    return true;
  }

  @Override
  public int splitMinMsg() {
    return splitMinMsg;
  }

  @Override
  public boolean splitBlankIns() {
    return splitBlankIns;
  }

  @Override
  public boolean splitChkSender() {
    return splitChkSender;
  }

  @Override
  public boolean splitKeepLeadBreak() {
    return splitKeepLeadBreak;
  }

  @Override
  public boolean revMsgOrder() {
    return revMsgOrder;
  }
}
