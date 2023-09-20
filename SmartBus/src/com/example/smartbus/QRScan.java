package com.example.smartbus;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QRScan extends Activity {
	protected static final int ACTIVITY_RESULT_QR_DRDROID = 0;
	TextView report;
	Button scan;
	
	String from,username;
	String to;
	String time,busno,cost,count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qrscan);
		report = (TextView) findViewById(R.id.textView2);
		scan = (Button) findViewById(R.id.button1);
		
		count=getIntent().getStringExtra("count");
		username=getIntent().getStringExtra("username");
		
		from=getIntent().getStringExtra("from");
		to=getIntent().getStringExtra("to");
		time=getIntent().getStringExtra("time");
		busno=getIntent().getStringExtra("busno");
		cost=getIntent().getStringExtra("resultamount");
	
	
	
//		Toast.makeText(getApplicationContext(), pamount, Toast.LENGTH_LONG).show();
//		
		scan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent("la.droid.qr.scan");
				
				try {
					
					startActivityForResult(i, ACTIVITY_RESULT_QR_DRDROID);
				} 
				catch (ActivityNotFoundException activity) {
					
					QRScan.qrDroidRequired(QRScan.this);
				}
			}
		});
	}	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if( ACTIVITY_RESULT_QR_DRDROID == requestCode 
				&& data != null && data.getExtras() != null ) {
			
			String result = data.getExtras().getString("la.droid.qr.result");
			
			
			
			report.setText(result);
			report.setVisibility(View.VISIBLE);
			Intent in=new Intent(QRScan.this,PaymentAct.class);
			in.putExtra("qrvalue", result);
			//in.putExtra("amount", pamount);
			in.putExtra("to", to);
			in.putExtra("from", from);
			in.putExtra("busno", busno);
			in.putExtra("time", time);
			in.putExtra("count", count);
			in.putExtra("cost", cost);
			in.putExtra("username", username);
			startActivity(in);
			
			
	}
	}

	protected static void qrDroidRequired(final QRScan qrScan) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder AlertBox = new AlertDialog.Builder(qrScan);
		
		AlertBox.setMessage("QRDroid Missing");
		
		AlertBox.setPositiveButton("Direct Download", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
				qrScan.startActivity(new Intent(Intent.ACTION_VIEW, 
					Uri.parse("http://droid.la/apk/qr/")));
			}
		});
		
		AlertBox.setNeutralButton("From Market", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				qrScan.startActivity(new Intent(Intent.ACTION_VIEW, 
					Uri.parse("http://market.android.com/details?id=la.droid.qr")));
			}
		});
		
		AlertBox.setNegativeButton("Cancel", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				dialog.cancel();
			}
		});
		
		AlertBox.create().show();
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.qrscan, menu);
		return true;
	}

}
