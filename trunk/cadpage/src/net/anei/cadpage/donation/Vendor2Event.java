package net.anei.cadpage.donation;

public class Vendor2Event extends VendorEvent {
  
  public Vendor2Event() {
    super(2);
  }
  
  private static final Vendor2Event instance = new Vendor2Event();
  
  public static Vendor2Event instance() {
    return instance;
  }

}
