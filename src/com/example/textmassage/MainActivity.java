package com.example.textmassage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView mssListview;
	private EditText text;
	private Button mssg_bn;
	private MessageAdapter adapter;

	private List<Msg> list = new ArrayList<Msg>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initMsgs();
		adapter=new MessageAdapter(MainActivity.this, R.layout.layout_message,list);
		mssListview=(ListView)findViewById(R.id.listview);
		mssg_bn=(Button)findViewById(R.id.button);
		text=(EditText)findViewById(R.id.edit_send);
		mssListview.setAdapter(adapter);
		mssg_bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content=text.getText().toString();
				if (!"".equals(content)) {
					Msg msg=new Msg(content, Msg.MESSAGE_SEND);
					list.add(msg);
					adapter.notifyDataSetChanged();
					mssListview.setSelection(list.size());
					text.setText("");
					
				}
			}
		});
	}

	private void initMsgs() {
		Msg msg2 = new Msg("hello", Msg.MESSAGE_RECEIVE);
		list.add(msg2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
