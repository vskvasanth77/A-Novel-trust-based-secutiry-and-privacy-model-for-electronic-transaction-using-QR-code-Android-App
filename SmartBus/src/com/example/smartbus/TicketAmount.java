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

public class TicketAmount extends Activity {

	EditText f,t;
	Button submit;
	ProgressBar pb;
	String username,from,to;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ticket_amount);
		f=(EditText)findViewById(R.id.editText1);
		t=(EditText)findViewById(R.id.editText2);
		submit=(Button)findViewById(R.id.button1);
		username=getIntent().getStringExtra("username");
		Toast.makeText(getApplicationContext(), username, Toast.LENGTH_LONG).show();

		/*from=getIntent().getStringExtra("from");
		to=getIntent().getStringExtra("to");*/
//		Toast.makeText(getApplicationContext(), username, Toast.LENGTH_LONG).show();
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				GetDeviceList1 gdlist4 = new GetDeviceList1();
				gdlist4.execute();
			}
		});
	}
	private class GetDeviceList1 extends AsyncTask<String, Void, Void> {
		String from1=f.getText().toString();
		String to1=t.getText().toString();
		String list;
		
		//intent.putExtra("b",b);
		
		
		protected void onPreExecute() {
			 //username = getIntent().getStringExtra("username");
			//Toast.makeText(getApplicationContext(),"please wait..."+username,Toast.LENGTH_SHORT).show();
			
		}
		
		protected Void doInBackground(String... params) {
			
			list=Callservice.getDeviceList1(from1,to1,"getDeviceList1");	
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {	
			Intent intent = new Intent(getBaseContext(),Buslist.class);
			intent.putExtra("from",from1);
			intent.putExtra("to",to1);
			intent.putExtra("username",username);
			intent.putExtra("list", list);
			startActivity(intent);
		}
			
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ticket_amount, menu);
		return true;
	}

}
