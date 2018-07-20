package id.chirikualii.cataloguemovie.ui.main.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.chirikualii.cataloguemovie.ui.detail.DetailMovieActivity;
import id.chirikualii.cataloguemovie.R;
import id.chirikualii.cataloguemovie.model.SearchMovie;

public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.txt_title_movie)
    TextView txtTitleMovie;
    @BindView(R.id.txt_release_date) TextView txtReleaseDate;
    @BindView(R.id.img_poster) ImageView imgPoster;
    Intent intent;
    public SearchViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(this);


    }

    public void bind(SearchMovie movie, View itemView) {
        txtTitleMovie.setText(movie.getOriginalTitle());
        txtReleaseDate.setText(movie.getReleaseDate());
        Glide
                .with(itemView)
                .load("http://image.tmdb.org/t/p/w185"+movie.getPosterPath())
                .into(imgPoster);

        intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
        intent.putExtra(DetailMovieActivity.DATA_DETAIL,movie);

    }

    @Override
    public void onClick(View view) {
        itemView.getContext().startActivity(intent);
    }
}
