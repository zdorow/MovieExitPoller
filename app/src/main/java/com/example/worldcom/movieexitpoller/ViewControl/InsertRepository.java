package com.example.worldcom.movieexitpoller.ViewControl;

import android.app.Application;
import android.os.AsyncTask;

import com.example.worldcom.movieexitpoller.Room.Response;
import com.example.worldcom.movieexitpoller.Room.ResponseDao;
import com.example.worldcom.movieexitpoller.Room.ResponseRoomDatabase;

public class InsertRepository {

    private ResponseDao mInsertDao;

    public InsertRepository(Application application){
        ResponseRoomDatabase db = ResponseRoomDatabase.getDatabase(application);
        mInsertDao = db.responseDao();
    }
    public void insert (Response response) {
        new insertAsyncTask(mInsertDao).execute(response);
    }

    private static class insertAsyncTask extends AsyncTask<Response, Void, Void> {

        private ResponseDao mAsyncTaskDao;

        insertAsyncTask(ResponseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Response... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
