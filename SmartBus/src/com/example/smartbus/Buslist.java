package com.example.smartbus;




import android.os.AsyncTask;
import android.os.Bundle;

import android.app.ListActivity;
import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Buslist extends ListActivity {
	String buslists;
	
	
	String from,username;
	String to;
	String item;
	String timee,bus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_buslist);
		username=getIntent().getStringExtra("username");
		from=getIntent().getStringExtra("from");
		to=getIntent().getStringExtra("to");
		
		buslists=getIntent().getStringExtra("list");
		
		
		String[] eventnames = buslists.split("@");		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_buslist,eventnames));
		ListView listview = getListView();
		listview.setTextFilterEnabled(true);
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
			//ItemClicked item = adapter.getItemAtPosition(position);
				 item = ((TextView)view).getText().toString();
				 String[] parts=item.split("\n");
				 timee=parts[0].replace("Time: ", "");;
				 bus=parts[1].replace("buses: ", "");
				 Toast.makeText(getApplicationContext(), timee+"__"+bus, Toast.LENGTH_LONG).show();
				 ActiveTask task=new ActiveTask();
				 task.execute();
//				 Intent i = new Intent(getApplicationContext(),Amountgeneration.class);
//			     i.putExtra("item",item);
//				 startActivity(i);
					 //Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();					}		});		
			}
		});	

	}
	
	 private class ActiveTask extends AsyncTask<String,Void,Void> {
			
			String res=null;
			
			/*protected void onPreExecute() {
				mainpb.setVisibility(View.VISIBLE);
			}*/

			
			protected Void doInBackground(String... params) {
				res=Callservice.BuslistService(timee,bus,"Buslist");	
				
				return null;
			}
			
			@Override
			protected void onPostExecute(Void result) {
						
				Intent intent=new Intent(getBaseContext(),Amountgeneration.class);
				intent.putExtra("username", username);
				intent.putExtra("amount", res);
				
				intent.putExtra("from", from);
				intent.putExtra("to", to);
			
				intent.putExtra("timee", timee);
				intent.putExtra("bus", bus);
				
				startActivity(intent);
				}				
				//mainpb.setVisibility(View.INVISIBLE);
			}
	    
	   
	
}

	
