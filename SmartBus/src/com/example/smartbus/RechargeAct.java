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

public class RechargeAct extends Activity {
	EditText e1,e2;
	Button b1;
	String uname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recharge);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		b1=(Button)findViewById(R.id.button1);
		
		uname=getIntent().getStringExtra("username");
//		cvv=getIntent().getStringExtra("cvv");
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s1=e1.getText().toString();
				if(s1.equals("")){
					
					Toast.makeText(getApplicationContext(), "plz fill all fields...", Toast.LENGTH_LONG ).show();
				}
				
				else{
				ActiveTask2 task1=new ActiveTask2();
				task1.execute();	
				}
			}
		});
	}

	
	private class ActiveTask2 extends AsyncTask<String,Void,Void> {
		String cvv=e2.getText().toString();
		String reamnt=e1.getText().toString();
		String res=null;
		@Override
		protected void onPreExecute() {
			
		}

		@Override
		protected Void doInBackground(String... params) {
			res=Callservice.Recharge(uname,cvv,reamnt,"recharge");
			return null;
			
		}

	protected void onPostExecute(Void result) {

		if(res.equals("success")) {

				
		
					Intent intent=new Intent(getBaseContext(),PaymentAct.class);
					startActivity(intent);
			
		}
	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recharge, menu);
		return true;
	}

}
