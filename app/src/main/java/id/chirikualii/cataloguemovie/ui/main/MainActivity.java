package id.chirikualii.cataloguemovie.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.chirikualii.cataloguemovie.R;
import id.chirikualii.cataloguemovie.model.SearchMovie;
import id.chirikualii.cataloguemovie.ui.main.adapter.SearchAdapter;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener{

    IMainPresenter presenter = new MainPresenter(this);
    SearchAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    //init view
    @BindView(R.id.recycler_view_movie) RecyclerView recyclerView;
    @BindView(R.id.btn_search) Button btnSearch;
    @BindView(R.id.edt_search) EditText edtSearch;
    @BindView(R.id.loading_search_movie) ProgressBar loadingSearchMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind
        ButterKnife.bind(this);

        //config recycler_view
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnSearch.setOnClickListener(this);

    }

    @Override
    public void setOnSuccess(List<SearchMovie> movieList) {
        adapter = new SearchAdapter(movieList);

        loadingSearchMovie.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setOnError() {
        Toast.makeText(this, "data gagal di load", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.INVISIBLE);
        loadingSearchMovie.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_search:
                presenter.performLoading();
                presenter.peformSearch(edtSearch.getText().toString());

            break;
        }
    }
}
