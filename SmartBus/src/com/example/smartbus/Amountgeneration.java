package com.example.smartbus;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Amountgeneration extends Activity {

	//TextView amount;
	
	EditText count;
	Button mp;
	int result11;
	String pamount,username;
	String busno,time ;
	String from,to;
	String devicename;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amountgeneration);
		//amount=(TextView)findViewById(R.id.textView1);
		
		count=(EditText)findViewById(R.id.editText1);
		mp=(Button)findViewById(R.id.button1);
	//	bus=(Button)findViewById(R.id.button2);
		
		
		
		
			from=getIntent().getStringExtra("from");
			to=getIntent().getStringExtra("to");
	         pamount=getIntent().getStringExtra("amount");
	         username=getIntent().getStringExtra("username");
	         time=getIntent().getStringExtra("timee");
	         busno=getIntent().getStringExtra("bus");
	         
	         
	         
	         Toast.makeText(getBaseContext(), pamount, Toast.LENGTH_LONG).show();
		/*String pamount=getIntent().getStringExtra("amount");
		int ppamount=Integer.parseInt(pamount);
		amount.setText("Ticket Cost is: "+pamount);
		String ccount=count.getText().toString();
		int cccount=Integer.parseInt(ccount);*/
		
		mp.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String ccount=count.getText().toString();
				int ppamount=Integer.parseInt(pamount);
		       int cccount=Integer.parseInt(ccount);
				
				result11=ppamount*cccount;
				String cost=String.valueOf(result11);
			//	busno=getIntent().getStringExtra("busnumber");
		
				Toast.makeText(getApplicationContext(), "Total Amount is: "+cost, Toast.LENGTH_LONG).show();
				Intent inn=new Intent(getApplicationContext(),QRScan.class);
				inn.putExtra("resultamount", cost);
				inn.putExtra("from", from);
				inn.putExtra("to", to);
				inn.putExtra("count", ccount);
				inn.putExtra("time", time);
				inn.putExtra("busno", busno);
				inn.putExtra("username", username);
				
				
				
				startActivity(inn);
			}
			
		});
	}
//	bus.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View arg0) {
//			// TODO Auto-generated method stub
//			GetDeviceList4 gdlist4 = new GetDeviceList4();
//			gdlist4.execute();
//		}
//	});
//}
//private class GetDeviceList4 extends AsyncTask<String, Void, Void> {
//	String list;
//	
//	//intent.putExtra("b",b);
//	protected void onPreExecute() {
//
//
//	}
//	
//	protected Void doInBackground(String... params) {
//		
//		list=Callservice.getDeviceList4(from,to,"getDeviceList4");	
//		return null;
//	}
//	@Override
//	protected void onPostExecute(Void result) {	
//	
//
//			Intent intent = new Intent(getBaseContext(),Buslist.class);
//			intent.putExtra("from",from);
//			intent.putExtra("to",to);
//			intent.putExtra("list", list);
//			startActivity(intent);
//		}
//		
//		
//}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.amountgeneration, menu);
		return true;
	}

}
