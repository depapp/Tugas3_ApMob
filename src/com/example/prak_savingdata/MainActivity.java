package com.example.prak_savingdata;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView list;
	private TextView txt;
	private List<Notes> notes;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> arrlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			notes = data();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			arrlist = data_Notes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setContentView(R.layout.activity_main);
		list = (ListView) findViewById(R.id.note_data);
		txt = (TextView) findViewById(R.id.total_data);
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, arrlist);
		list.setAdapter(adapter);
		if (notes.size() > 0) {
			txt.setText(notes.size() + " note tersimpan");
		} else {
			txt.setText("Belum ada note");
		}
	}

	public List<Notes> data() throws SQLException {
		return new NotesRepo(MainActivity.this).listall();
	}

	public ArrayList<String> data_Notes() throws SQLException {
		ArrayList<String> dt = new ArrayList<String>();
		for (int i = 0; i < data().size(); i++) {
			dt.add(data().get(i).getJudul());
			dt.add(data().get(i).getIsi());
		}
		return dt;
	}

	public void tambah_data(View view) {
		startActivity(new Intent(MainActivity.this, AddActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}