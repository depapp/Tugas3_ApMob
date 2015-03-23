package com.example.prak_savingdata;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DBHelp extends OrmLiteSqliteOpenHelper {
	private static final String DATABASE_NAME = "buku.db";
	private static final int DATABASE_VERSION = 1;
	private Dao<Notes, Integer> daoNotes = null;
	private RuntimeExceptionDao<Notes, Integer> runtimesDaoNotes = null;

	public DBHelp(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		try {
			TableUtils.createTable(connectionSource, Notes.class);
		} catch (SQLException e) {
			Log.e(DBHelp.class.getName(), "Gagal Membuat Table", e);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		try {
			TableUtils.dropTable(connectionSource, Notes.class, true);
		} catch (SQLException e) {
			Log.e(DBHelp.class.getName(), "Gagal Menghapus Table", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		daoNotes = null;
		super.close();
	}

	public Dao<Notes, Integer> getDaoNotes() throws SQLException,
			java.sql.SQLException {
		if (daoNotes == null) {
			daoNotes = getDao(Notes.class);
		}
		return daoNotes;
	}

	public RuntimeExceptionDao<Notes, Integer> getRuntimesDaoNotes() {
		if (runtimesDaoNotes == null) {
			runtimesDaoNotes = getRuntimeExceptionDao(Notes.class);
		}
		return runtimesDaoNotes;
	}
}