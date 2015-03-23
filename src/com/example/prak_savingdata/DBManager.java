package com.example.prak_savingdata;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import android.content.Context;

public class DBManager {
	private DBHelp dbHelp = null;

	public DBHelp getDbHelp(Context context) {
		if (dbHelp == null) {
			dbHelp = OpenHelperManager.getHelper(context, DBHelp.class);
		}
		return dbHelp;
	}

	public void releaseHelper(DBHelp helper) {
		if (helper != null) {
			OpenHelperManager.releaseHelper();
			dbHelp = null;
		}
	}
}