package com.example.prak_savingdata;

import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

public class NotesRepo {
	public DBHelp db;
	Dao<Notes, Integer> notesDao;

	public NotesRepo(Context context) throws java.sql.SQLException {
		try {
			DBManager dbManager = new DBManager();
			db = dbManager.getDbHelp(context);
			notesDao = db.getDaoNotes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int create(Notes mediaModel) throws SQLException,
			java.sql.SQLException {
		return notesDao.create(mediaModel);
	}

	public List<Notes> listall() throws java.sql.SQLException {
		try {
			return notesDao.queryForAll();
		} catch (SQLException e) {
			Log.e("error", "query gagal");
			e.printStackTrace();
		}
		return null;
	}
}