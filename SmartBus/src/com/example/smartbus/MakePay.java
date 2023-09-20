package com.example.smartbus;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MakePay extends Activity {
	Button b1;
	String uname,from,to,time,busno,cost,qrvalue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_pay);
		
		b1=(Button)findViewById(R.id.button1);
		
		qrvalue=getIntent().getStringExtra("qrvalue");
		uname=getIntent().getStringExtra("uname");
		from=getIntent().getStringExtra("from");
		to=getIntent().getStringExtra("to");
		time=getIntent().getStringExtra("time");
		busno=getIntent().getStringExtra("busno");
		time=getIntent().getStringExtra("time");
		cost=getIntent().getStringExtra("cost");
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				ActiveTask1 task1=new ActiveTask1();
				task1.execute();	
			}
		});
	}
	private class ActiveTask1 extends AsyncTask<String,Void,Void> {

		String res=null;
			@Override
			protected void onPreExecute() {
				
			}

			@Override
			protected Void doInBackground(String... params) {
			//	res=Callservice.bookService(qrvalue,uname,busno,from,to,time,cost,"booked");
				return null;
				
			}
		
		protected void onPostExecute(Void result) {
		
			if(res.equals("success")) {

					
			
						Intent intent=new Intent(getBaseContext(),Userlogin.class);
						startActivity(intent);
				
			}
		}
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.make_pay, menu);
		return true;
	}

}
