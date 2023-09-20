package com.example.smartbus;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Wallet extends Activity {
	
	TextView tv;
	EditText e1;
	Button out,pay,sub,sms;
	String ramount,qr;
	int tamount;
	String from,username,qrvalue,amount,payment;
	String to,uname;
	String amountresult,phno;
	String time,busno,cost,cvv,count;
	//int cash;
	int tamount1,cash,ct;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallet);
		
		tv=(TextView)findViewById(R.id.textView1);
		e1=(EditText)findViewById(R.id.editText1);
		pay =(Button)findViewById(R.id.button2);
		out=(Button)findViewById(R.id.button1);
		sms=(Button)findViewById(R.id.button3);
		
		 phno=e1.getText().toString();
		
		
		count=getIntent().getStringExtra("count");
		cvv=getIntent().getStringExtra("cvv");
		payment=getIntent().getStringExtra("payment");
		username=getIntent().getStringExtra("username");
		from=getIntent().getStringExtra("from");
		to=getIntent().getStringExtra("to");
		time=getIntent().getStringExtra("time");
		busno=getIntent().getStringExtra("busno");
		cost=getIntent().getStringExtra("cost");
		qrvalue=getIntent().getStringExtra("qrvalue");
		
		 
		sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		out.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				
				Intent in=new Intent(Wallet.this,MainActivity.class);
				startActivity(in);
			}
		});
		 
		 
		pay.setOnClickListener(new OnClickListener() {
			
			//@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				try{
//				cash = Integer.valueOf(getIntent().getStringExtra("payment"));
//				}catch(NumberFormatException e){
//					
//					System.out.println(e);
//				}
//				try{
//					 ct=Integer.valueOf(getIntent().getStringExtra("cost"));
//					}catch(NumberFormatException e){
//						
//						System.out.println(e);
//					}
//				
//				
//				 tamount=cash-ct;
//				//tamount1=tamount-Integer.parseInt(cost);
//				 amountresult=String.valueOf(tamount1);
//				 phno=e1.getText().toString();
//				
//				//int c=tamount-tamount1;
//			tv.setText("Balance amount is  " +amountresult);
				Toast.makeText(getApplicationContext(), cost+"....."+payment, Toast.LENGTH_LONG).show();
				
			
			ActiveTask2 task=new ActiveTask2();
			task.execute();	
				
			
					
			}
		});
		
		
		
	}
	

	

	private class ActiveTask2 extends AsyncTask<String,Void,Void> {

		String res=null;
			@Override
			protected void onPreExecute() {
				
			}

			@Override
			protected Void doInBackground(String... params) {
				res=Callservice.bookService(qrvalue,username,busno,from,to,time,cost,payment,cvv,"booked");
				return null;
				
			}
		
		//@SuppressWarnings("deprecation")
		@SuppressWarnings("deprecation")
		protected void onPostExecute(Void result) {
		
			if(res.equals("success")) {

				phno=e1.getText().toString();
				SmsManager sms= SmsManager.getDefault();
				sms.sendTextMessage(phno, null, "Ticket Received"+"\n"+"Bus Number: "+busno+"\n"+"Ticket Amount:"+cost, null, null);
				Toast.makeText(getApplicationContext(), "Message Sent Successfully", Toast.LENGTH_LONG).show();
				Intent in=new Intent(Wallet.this,Userlogin.class);
				startActivity(in);
				
				
					
					
				}
						
				
			
sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
		
		try{		
		
		}
		catch(Exception e)
		{
			
		}
				
			}
		});
		}
		

	}	

	
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.wallet, menu);
	return true;
}

}

