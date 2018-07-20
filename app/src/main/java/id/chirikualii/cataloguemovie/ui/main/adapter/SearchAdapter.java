package id.chirikualii.cataloguemovie.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.chirikualii.cataloguemovie.R;
import id.chirikualii.cataloguemovie.model.SearchMovie;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private List<SearchMovie> movieList;

    public SearchAdapter(List<SearchMovie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie , parent , false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchMovie movie =movieList.get(position);
        holder.bind(movie,holder.itemView);
    }

    @Override
    public int getItemCount() {
        return  movieList.size();
    }
}
