package com.example.worldcom.movieexitpoller;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "responseTable")
public class Response {

    public Response(@NonNull String movie, @NonNull Integer movieId, @NonNull Integer questionId,
                    @NonNull Integer questionAnswer) {
        this.movie = movie;
        this.movieId = movieId;
        this.questionId = questionId;
        this.questionAnswer = questionAnswer;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie")
    private String movie;
    public String getMovie(){return this.movie;
    }

    @NonNull
    @ColumnInfo(name = "movieId")
    private Integer movieId;
    public Integer getMovieId(){return this.movieId;
    }
    
    public Integer setMovieId(Integer movieId){
        this.movieId = movieId;
        return movieId;
    }

    @NonNull
    @ColumnInfo(name = "questionId")
    private Integer questionId;
    public Integer getQuestionId() { return questionId;
    }

    public Integer setQuestionId(Integer questionId){
        this.questionId = questionId;
        return questionId;
    }

    @NonNull
    @ColumnInfo(name = "questionAnswer")
    private Integer questionAnswer;
    
    public Integer getQuestionAnswer() {
        return questionAnswer;
    }

    public Integer setQuestionAnswer(Integer questionAnswer){
        this.questionAnswer = questionAnswer;
        return questionAnswer;
    }

}
