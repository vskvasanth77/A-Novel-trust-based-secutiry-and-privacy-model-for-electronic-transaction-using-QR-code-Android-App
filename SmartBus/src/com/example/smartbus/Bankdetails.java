package com.example.smartbus;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Bankdetails extends Activity {
	EditText e1,e2,e3,e4;
	Button b1,b2;
	ProgressBar pb1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bankdetails);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		pb1=(ProgressBar)findViewById(R.id.progressBar1);
		b1=(Button)findViewById(R.id.button1);
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if((e1.equals(""))||(e2.equals(""))||(e3.equals(""))||(e4.equals("")))
			{
				Toast.makeText(getApplicationContext(), "Please Enter All Details", Toast.LENGTH_LONG).show();
			}
			else
			{
				ActiveTask1 task1=new ActiveTask1();
				task1.execute();
			}
			/*Intent in=new Intent(getApplicationContext(), Success.class);
			startActivity(in);*/
			
		}
	});
		
	}
	
	private class ActiveTask1 extends AsyncTask<String,Void,Void> {
		String s1=e1.getText().toString();
		String s2=e2.getText().toString();
		String s4=e3.getText().toString();
		String s5=e4.getText().toString();
		String res=null;
		@Override
		protected void onPreExecute() {
			pb1.setVisibility(View.VISIBLE);
		}

		@Override
		protected Void doInBackground(String... params) {
			res=Callservice.BankDetailsService(s1,s2,s4,s5,"BankDetails");
			return null;
			
		}
	
	protected void onPostExecute(Void result) {
		pb1.setVisibility(View.INVISIBLE);
		if(res.equals("success")) {

				
			AlertDialog.Builder dia=new AlertDialog.Builder(Bankdetails.this);
			dia.setTitle("trus again");
			dia.setMessage("Account Created");
			dia.setCancelable(false);
			dia.setPositiveButton("Got it", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(getBaseContext(),Wallet.class);
					startActivity(intent);
					dialog.cancel();
				}
			});
			AlertDialog dialo=dia.create();
			dialo.show();
					
					
				}				
		
		else {
			Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
		}
		
	}
 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bankdetails, menu);
		return true;
	}

}
