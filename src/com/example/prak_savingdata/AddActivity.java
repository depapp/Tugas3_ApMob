package com.example.prak_savingdata;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class AddActivity extends Activity {
	private EditText title;
	private EditText body;
	private Button buttonn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_data);
		title = (EditText) findViewById(R.id.editText1);
		body = (EditText) findViewById(R.id.editText2);
		buttonn = (Button) findViewById(R.id.button1);
		buttonn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Notes notes = new Notes();
				notes.setJudul(title.getText().toString());
				notes.setIsi(body.getText().toString());
				try {
					new NotesRepo(AddActivity.this).create(notes);
					Toast.makeText(AddActivity.this, "Data Sukses Tersimpan",
							Toast.LENGTH_LONG).show();
				} catch (SQLException e) {
					Toast.makeText(AddActivity.this, "Data Gagal Tersimpan",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				} catch (java.sql.SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startActivity(new Intent(AddActivity.this, MainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
				finish();
			}
		});
	}
}