package com.example.worldcom.movieexitpoller;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ResponseDao {

    @Query("SELECT * from responseTable")
    LiveData<List<Response>> getAllResponses();

    @Query("SELECT questionAnswer from responseTable where movieId = :mId AND questionId = :questionId")
    LiveData<List<Integer>> getAnswers(Integer mId, Integer questionId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Response response);

    @Query("DELETE FROM responseTable")
    void deleteAll();
}
