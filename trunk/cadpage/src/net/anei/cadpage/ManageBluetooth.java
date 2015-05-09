package net.anei.cadpage;


import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;

/**
 * Class probing USB connections looking to establish communications with a
 * Tetra pager
 */

public class ManageBluetooth {
  
  public static final int BLUETOOTH_REQ = 10000;
  
  // Production version does not request Bluetooth permissions, so this will never work!!
  private BluetoothAdapter adapter = null; // BluetoothAdapter.getDefaultAdapter();
  
  public void enableDiscovery(Activity context) {
    Log.v("Starting Bluetooth Discovery");
    if (!checkBluetoothStatus(context)) return;
    Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
    discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
    context.startActivity(discoverableIntent);
  }

  public void probe(Activity context) {
    
    Log.v("Starting Bluetooth Probe");
    
    if (!checkBluetoothStatus(context)) return;
    
    // Request Bluetooth be enabled if it is not already
    if (!adapter.isEnabled()) {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        context.startActivityForResult(enableBtIntent, BLUETOOTH_REQ+1);
        return;
    }
    
    probe2(context);
  }
  
  private boolean checkBluetoothStatus(Activity context) {
    
    if (adapter == null) {
      Log.v("Device does not support Bluetooth");
      new AlertDialog.Builder(context)
      .setIcon(R.drawable.ic_launcher).setTitle("Bluetooth Error")
      .setPositiveButton(R.string.donate_btn_OK, null)
      .setMessage("This device does not support Bluetooth")
      .create().show();
      return false;
    }
    
    return true;
  }
  
  public boolean onActivityResult(Activity context, int requestCode, int resultCode) {
    
    if (resultCode != Activity.RESULT_OK) return false;
    
    if (requestCode == BLUETOOTH_REQ+1) {
      if (!adapter.isEnabled()) return false;
      probe2(context);
      return true;
    }
    return false;
  }
  
  private void probe2(Activity context) {
    Log.v("Bluetooth probe phase 2");
    
    // See what we have already bonded
    Log.v("\nBonded Bluetooth Devices");
    for (BluetoothDevice dev : adapter.getBondedDevices()) {
      Log.v(fmtDevice(dev));
    }
    
    // Check to see what else is out there
    adapter.startDiscovery();
    
  }
  
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    // When discovery finds a device
    if (BluetoothDevice.ACTION_FOUND.equals(action)) {
        // Get the BluetoothDevice Info from the Intent
      BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
      Log.v("Discovered Bluetooth Device");
      Log.v(fmtDevice(device));
    }
  }
  
  private String fmtDevice(BluetoothDevice device) {
    BluetoothClass cls = device.getBluetoothClass();
    return "Bluetooth device info" +
           "\nAddress:" + device.getAddress() +
           "\nName:" + device.getName() +
           "\nState:" + device.getBondState() +
//           "\nType:" + device.getType() +
           "\nMajorDevClass:" + cls.getMajorDeviceClass() +
           "\nMinorDevClass:" + cls.getDeviceClass();
  }
  
  private static final ManageBluetooth instance = new ManageBluetooth();
  
  public static ManageBluetooth instance() {
    return instance;
  }
}
