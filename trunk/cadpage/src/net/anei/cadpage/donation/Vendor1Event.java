package net.anei.cadpage.donation;

public class Vendor1Event extends VendorEvent {
  
  public Vendor1Event() {
    super(1);
  }
  
  private static final Vendor1Event instance = new Vendor1Event();
  
  public static Vendor1Event instance() {
    return instance;
  }

}
