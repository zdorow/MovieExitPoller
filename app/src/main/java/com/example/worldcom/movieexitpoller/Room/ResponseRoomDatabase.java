package com.example.worldcom.movieexitpoller.Room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

@Database(entities = {Response.class}, version = 2,  exportSchema = false)
public abstract class ResponseRoomDatabase extends RoomDatabase {

    public abstract ResponseDao responseDao();

    private static ResponseRoomDatabase INSTANCE;

    public static ResponseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ResponseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ResponseRoomDatabase.class, "responseDatabase")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ResponseDao mDao;

        PopulateDbAsync(ResponseRoomDatabase db) {
            mDao = db.responseDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            Integer movieId1 = 1;
            Integer movieId2 = 2;
            Integer movieId3 = 3;
            Integer movieId4 = 4;
            Integer movieId5 = 5;

            Map<Integer, Integer> movie1Responses = new HashMap<Integer, Integer>() {{
                put(1,5);
                put(2,4);
                put(3,3);
                put(4,5);
                put(5,5);
                put(6,5);

            }};
            for (Map.Entry<Integer, Integer> entry : movie1Responses.entrySet()){
                Response response = new Response(movieId1, entry.getKey(), entry.getValue());
                mDao.insert(response);
            }

            Map<Integer, Integer> movie2Responses = new HashMap<Integer, Integer>() {{
                put(1,5);
                put(2,4);
                put(3,3);
                put(4,2);
                put(5,5);
                put(6,5);
            }};
            for (Map.Entry<Integer, Integer> entry : movie2Responses.entrySet()){
                Response response = new Response(movieId2, entry.getKey(), entry.getValue());
                mDao.insert(response);
            }

            Map<Integer, Integer> movie3Responses = new HashMap<Integer, Integer>() {{
                put(1,5);
                put(2,4);
                put(3,3);
                put(4,3);
                put(5,5);
                put(6,5);
            }};

            for (Map.Entry<Integer, Integer> entry : movie3Responses.entrySet()){
                Response response = new Response(movieId3, entry.getKey(), entry.getValue());
                mDao.insert(response);
            }
            Map<Integer, Integer> movie4Responses = new HashMap<Integer, Integer>() {{
                put(1,5);
                put(2,4);
                put(3,3);
                put(4,1);
                put(5,5);
                put(6,5);
            }};

            for (Map.Entry<Integer, Integer> entry : movie4Responses.entrySet()){
                Response response = new Response(movieId4, entry.getKey(), entry.getValue());
                mDao.insert(response);
            }

            Map<Integer, Integer> movie5Responses = new HashMap<Integer, Integer>() {{
                put(1,5);
                put(2,4);
                put(3,3);
                put(4,5);
                put(5,2);
                put(6,5);
            }};

            for (Map.Entry<Integer, Integer> entry : movie5Responses.entrySet()){
                Response response = new Response(movieId5, entry.getKey(), entry.getValue());
                mDao.insert(response);
            }
            return null;
        }
    }
}
