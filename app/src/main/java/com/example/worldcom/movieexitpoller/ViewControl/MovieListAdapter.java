package com.example.worldcom.movieexitpoller.ViewControl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.worldcom.movieexitpoller.Activities.SurveyActivity;
import com.example.worldcom.movieexitpoller.R;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private final List<String> mMovieList;
    private final LayoutInflater mInflater;

    class MovieViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final Button movieItemView;
        final MovieListAdapter mAdapter;

        public MovieViewHolder(View itemView, MovieListAdapter adapter) {
            super(itemView);
            movieItemView = itemView.findViewById(R.id.button1);
            this.mAdapter = adapter;
            movieItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context mContext = view.getContext();

            Intent intent = new Intent(mContext, SurveyActivity.class);
            // Get the position of the item that was clicked.
            Integer mPosition = getLayoutPosition();

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("MOVIE_ID", mPosition);
            mContext.startActivity(intent);
            Log.i("Movie ID: ", mPosition.toString());
        }
    }

    public MovieListAdapter(Context context, List<String> movieList) {
        mInflater = LayoutInflater.from(context);
        this.mMovieList = movieList;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(
                R.layout.recyclerview_item, parent, false);
        return new MovieViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        String mCurrent = mMovieList.get(position);
        // Add the data to the view holder.
        holder.movieItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }
}
