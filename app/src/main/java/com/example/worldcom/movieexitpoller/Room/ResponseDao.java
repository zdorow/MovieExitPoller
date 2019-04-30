package com.example.worldcom.movieexitpoller.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ResponseDao {

    @Query("SELECT * from responseTable")
    LiveData<List<Response>> getAllResponses();

    @Query("SELECT AVG(questionAnswer) from responseTable where movieId = :mId AND questionId = :questionId")
    LiveData<Integer> getAnswerAverage(Integer mId, Integer questionId);

    @Query("SELECT DISTINCT movieName from responseTable")
    LiveData<List<String>> getMovieNames();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Response response);

    @Query("DELETE FROM responseTable")
    void deleteAll();
}
