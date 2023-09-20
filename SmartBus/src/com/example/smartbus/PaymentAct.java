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
import android.widget.Toast;

public class PaymentAct extends Activity {

	Button b1,b2;
	EditText e1,e2;
	String pamount;
	String from,username,qrvalue;
	String to;
	String time,busno,cost,count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		
		username=getIntent().getStringExtra("username");
		count=getIntent().getStringExtra("count");
		qrvalue=getIntent().getStringExtra("qrvalue");
		from=getIntent().getStringExtra("from");
		to=getIntent().getStringExtra("to");
		cost=getIntent().getStringExtra("cost");
		time=getIntent().getStringExtra("time");
		busno=getIntent().getStringExtra("busno");
		
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String s1=e1.getText().toString();
				String s2=e2.getText().toString();
				if(s1.equals("") && s2.equals("")){
					
					Toast.makeText(getApplicationContext(), "Plz fill all fields", Toast.LENGTH_LONG).show();
					
				}
				else{
					ActiveTask1 task=new ActiveTask1();
					task.execute();
					
				}
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent in=new Intent(PaymentAct.this,RechargeAct.class);
				in.putExtra("username", username);
				startActivity(in);
				
			}
		});
	}
	private class ActiveTask1 extends AsyncTask<String,Void,Void> {
		String s1=e1.getText().toString();
		String s2=e2.getText().toString();
		String res=null;
		@Override
		protected void onPreExecute() {
			
		}

		@Override
		protected Void doInBackground(String... params) {
			res=Callservice.payService(s1,s2,"payment");
			return null;
		}

	protected void onPostExecute(Void result) {
		//pb.setVisibility(View.INVISIBLE);
		//if(res.equals("success")) {

		Toast.makeText(getApplicationContext(), "Payment-->"+res, Toast.LENGTH_LONG).show();
		
					Intent in=new Intent(getBaseContext(),Wallet.class);
					in.putExtra("payment", res);
					in.putExtra("cvv", s2);
					in.putExtra("qrvalue", qrvalue);
					in.putExtra("to", to);
					in.putExtra("from", from);
					in.putExtra("busno", busno);
					in.putExtra("count", count);
					in.putExtra("time", time);
					in.putExtra("cost", cost);
					in.putExtra("username", username);
					Toast.makeText(getApplicationContext(), ".... "+res, Toast.LENGTH_LONG).show();
					startActivity(in);
					
					
				
		
		
		
	}

	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payment, menu);
		return true;
	}

}
