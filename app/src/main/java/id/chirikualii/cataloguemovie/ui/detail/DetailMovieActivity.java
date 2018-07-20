package id.chirikualii.cataloguemovie.ui.detail;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.chirikualii.cataloguemovie.R;
import id.chirikualii.cataloguemovie.model.SearchMovie;

public class DetailMovieActivity extends AppCompatActivity {
    @BindView(R.id.img_poster)
    private ImageView imgPoster;
    @BindView(R.id.txt_title_movie)
    private TextView txtTitleMovie;
    @BindView(R.id.txt_rating)
    private TextView txtRating;
    @BindView(R.id.txt_release_date)
    private TextView txtReleaseDate;
    @BindView(R.id.txt_overview)
    private TextView txtOverview;

    private SearchMovie movie;
    private String overview;
    private String rating;
    private String releaseDate;
    public static final String DATA_DETAIL = "detail_movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        this.initValue();
        this.bind();
    }

    private void initValue() {
        movie = getIntent().getParcelableExtra(DATA_DETAIL);
        overview =String.format(getString(R.string.overview_detail_movie) ,movie.getOverview());
        rating = String.format(getString(R.string.average_rating_movie),movie.getVoteAverage().toString());
        releaseDate = String.format(getString(R.string.release_date_movie),movie.getReleaseDate());
    }

    private void bind() {

        txtTitleMovie.setText(movie.getOriginalTitle());
        txtOverview.setText(overview);
        txtRating.setText(rating);
        txtReleaseDate.setText(releaseDate);

        Glide
                .with(this)
                .load("http://image.tmdb.org/t/p/w500"+movie.getPosterPath())
                .into(imgPoster);
    }
}
