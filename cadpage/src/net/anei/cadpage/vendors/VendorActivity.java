package net.anei.cadpage.vendors;

import net.anei.cadpage.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VendorActivity extends Activity {
  
  private static final String EXTRAS_VENDOR_CODE = "net.anei.cadpage.VendorActivity.VENDOR_CODE";
  
  private static final int CONFIRM_UNREGISTER_DLG = 1;
  
  private TextView infoTextView;
  private Button registerButton;
  private Button unregisterButton;
  
  private Vendor vendor;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.vendor_popup);
    
    // We can't do the cool stuff until we get a Vendor code
    // But can set up the button handlers here
    Button moreInfoButton = (Button)findViewById(R.id.more_info_button);
    moreInfoButton.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        vendor.moreInfoReq(VendorActivity.this);
      }
    });
    
    infoTextView = (TextView)findViewById(R.id.VendorInfoView);
    
    registerButton = (Button)findViewById(R.id.register_button);
    registerButton.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        vendor.registerReq(VendorActivity.this);
      }
    });
    
    unregisterButton = (Button)findViewById(R.id.unregister_button);
    unregisterButton.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        showDialog(CONFIRM_UNREGISTER_DLG);
      }
    });
    
    Button btn = (Button)findViewById(R.id.cancel_button);
    btn.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View v) {
        VendorActivity.this.finish();
      }
    });
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    switch (id) {

      case CONFIRM_UNREGISTER_DLG:
        return new AlertDialog.Builder(this)
        .setMessage(R.string.vendor_confirm_unregister)
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
          @Override
          public void onClick(DialogInterface dialog, int which) {
            vendor.unregisterReq(VendorActivity.this);
          }
        })
        .setNegativeButton(android.R.string.no, null)
        .create();
    }
    return super.onCreateDialog(id);
  }

  @Override
  protected void onStart() {
    super.onStart();
    Intent intent = getIntent();
    
    // Get the vendor associated with this activity
    vendor = null;
    String vendorCode = intent.getStringExtra(EXTRAS_VENDOR_CODE);
    if (vendorCode != null) vendor = VendorManager.instance().findVendor(vendorCode);
    if (vendor == null) { 
      finish();
      return;
    }
    
    // Register ourselves with this vendor object so it can update our
    // display if the enable status changes
    vendor.registerActivity(this);
    
    // OK, now that we have a vendor object, we can set up all of the display fields
    int resId = vendor.getIconId();
    if (resId > 0) {
      ImageView imgView = (ImageView)findViewById(R.id.VendorImageView);
      imgView.setImageResource(resId);
    }
    resId = vendor.getTitleId();
    if (resId > 0) {
      TextView txtView = (TextView)findViewById(R.id.VendorTitleView);
      txtView.setText(resId);
    }
    resId = vendor.getTextId();
    if (resId > 0) {
      TextView txtView = (TextView)findViewById(R.id.VendorDescriptionView);
      txtView.setText(resId);
    }
    
    // And update the status fields
    update();
  }
  
  /**
   * Update status fields, things that might change while window is displayed
   */
  public void update() {
    
    if (vendor.isEnabled()) {
      infoTextView.setText(R.string.vendor_registered);
      infoTextView.setVisibility(View.VISIBLE);
      registerButton.setVisibility(View.GONE);
      unregisterButton.setVisibility(View.VISIBLE);
    } else {
      infoTextView.setVisibility(View.GONE);
      registerButton.setVisibility(View.VISIBLE);
      unregisterButton.setVisibility(View.GONE);
    }
  }


  @Override
  protected void onDestroy() {
    
    // When activity is being destroyed, disconnect it from the vendor object
    vendor.registerActivity(null);
    super.onDestroy();
    
  }

  /**
   * Launch call display popup activity
   * @param context context
   * @param msgId message ID of message to be displayed
   * @return
   */
  public static void launchActivity(Context context, Vendor vendor) {
    Intent intent = new Intent(context, VendorActivity.class);
    intent.putExtra(EXTRAS_VENDOR_CODE, vendor.getVendorCode());
    context.startActivity(intent);
  }

}
