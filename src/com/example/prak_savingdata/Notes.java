package com.example.prak_savingdata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "notes")
public class Notes {
	@DatabaseField(generatedId = true)
	public int id;
	@DatabaseField
	public String judul;
	@DatabaseField
	public String isi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}
}