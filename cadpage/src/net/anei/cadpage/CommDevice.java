package net.anei.cadpage;

import java.io.UnsupportedEncodingException;
import android.annotation.TargetApi;
import android.hardware.usb.UsbConstants;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build;

/**
 * This handles communications with a USB device
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class CommDevice {
  
  private UsbManager mgr;
  private UsbDevice device;
  boolean open = false;
  UsbInterface itf;
  UsbEndpoint inEndPoint;
  UsbEndpoint outEndPoint;
  UsbDeviceConnection connect;
      
  
  public CommDevice(UsbManager mgr, UsbDevice device) {
    this.mgr = mgr;
    this.device = device;
  }
  
  /**
   * Start device communications
   * @return true if successful, false otherwise
   */
  synchronized public boolean start() {
    
    if (open) {
      Log.e("Comm device already open");
      return false;
    }
    Log.w("Opening comm device");
    
    // We do not know how to pick out an interface from multiple choices
    // so we require that there only be one for now
    if (device.getInterfaceCount() != 1) {
      Log.e("USB device has " + device.getInterfaceCount() + " interfaces");
      return false;
    }
    
    // We have an interface.  See if we can find an inbound and outound bulk
    // transfer endpoint for this interface
    itf = device.getInterface(0);
    
    inEndPoint = null;
    outEndPoint = null;
    for (int ii = 0; ii<itf.getEndpointCount(); ii++) {
      UsbEndpoint ep = itf.getEndpoint(ii);
      if (ep.getType() == UsbConstants.USB_ENDPOINT_XFER_BULK) {
        if (ep.getDirection() == UsbConstants.USB_DIR_IN) {
          inEndPoint = ep;
        } else {
          outEndPoint = ep;
        }
      }
    }
    
    if (inEndPoint == null || outEndPoint == null) {
      Log.e("Could not find bulk transfer endpoints");
      inEndPoint = outEndPoint = null;
      return false;
    }
    
    connect = mgr.openDevice(device);
    connect.claimInterface(itf, false);
    
    // Launch thread to monitor input endpoint.  For now it only logs whatever
    // comes in
    new Thread("CommInThread"){
      @Override
      public void run() {
        Log.v("CommInThread running");
        byte[] buffer = new byte[1];
        while (open) {
          int cnt = connect.bulkTransfer(inEndPoint, buffer, 1, 0);
          String s = new String(buffer, 0, cnt);
          Log.w("DevIn:" + s + " (" + Integer.toHexString(buffer[0]) + ')');
        }
      }
    }.start();
    
    // Kick the device and see if it responds
    send("AT");

    Log.w("CommDev has been opened");
    open = true;
    return true;
  }
  
  private void send(String s) {
    Log.w("DevOut:" + s);
    
    try {
      final byte[] buffer = (s + "\r\n").getBytes("UTF-8");
      new Thread("CommOutThread"){
        @Override
        public void run() {
          Log.v("DevOut transferring " + buffer.length + " bytes");
          int cnt = connect.bulkTransfer(outEndPoint, buffer, buffer.length, 0);
          Log.w("DevOut transfered " + cnt + " bytes");
        }
      }.start();
    } catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
      return;
    }
  }
  
  public UsbDevice getDevice() {
    return open ? device : null;
  }
  
  synchronized public void close() {
    if (!open) return;
    Log.w("Closing CommDev");
    connect.releaseInterface(itf);
    connect.close();
    open = false;
  }
}
