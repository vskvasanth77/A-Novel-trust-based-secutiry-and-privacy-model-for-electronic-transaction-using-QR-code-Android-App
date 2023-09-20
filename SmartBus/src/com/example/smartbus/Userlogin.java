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
import android.widget.ProgressBar;
import android.widget.Toast;

public class Userlogin extends Activity {
	EditText e1,e2;
	Button b1,b2;
	ProgressBar pb1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userlogin);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		pb1=(ProgressBar)findViewById(R.id.progressBar1);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getApplicationContext(), UserReg.class);
				startActivity(in);
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if(!((e1.getText().toString().equals("")) || (e2.getText().toString().equals("")))) {
					ActiveTask1 task=new ActiveTask1();
					task.execute();
				}	
				else {
					Toast.makeText(getApplicationContext(), "enter values in all field", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}
	private class ActiveTask1 extends AsyncTask<String,Void,Void> {
		String s1=e1.getText().toString();
		String s2=e2.getText().toString();
		String res=null;
		@Override
		protected void onPreExecute() {
			pb1.setVisibility(View.VISIBLE);
		}

		@Override
		protected Void doInBackground(String... params) {
			res=Callservice.loginService(s1,s2,"Login");
			return null;
		}

	protected void onPostExecute(Void result) {
		//pb.setVisibility(View.INVISIBLE);
		if(res.equals("success")) {

				
					Intent intent=new Intent(getBaseContext(),TicketAmount.class);
					intent.putExtra("username", s1);
					startActivity(intent);
					
					
				}				
		
		else {
			Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
		}
		
	}

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}