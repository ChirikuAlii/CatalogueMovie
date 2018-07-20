package id.chirikualii.cataloguemovie.ui.main;

import java.util.ArrayList;
import java.util.List;

import id.chirikualii.cataloguemovie.BuildConfig;
import id.chirikualii.cataloguemovie.api.ApiClient;
import id.chirikualii.cataloguemovie.api.ApiService;
import id.chirikualii.cataloguemovie.model.ResponseSearchMovie;
import id.chirikualii.cataloguemovie.model.SearchMovie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements IMainInteractor {

    private IMainInteractor.listener listener;
    private ApiService service = ApiClient.getApiClient().create(ApiService.class);
    private List<SearchMovie> movieList = new ArrayList<>();

    public MainInteractor(IMainInteractor.listener listener) {
        this.listener = listener;
    }

    @Override
    public void search(String query) {

        service.responseSearchMovieCall(BuildConfig.MOVIE_API_KEY ,query,"1").enqueue(new Callback<ResponseSearchMovie>() {
            @Override
            public void onResponse(Call<ResponseSearchMovie> call, Response<ResponseSearchMovie> response) {
                movieList.clear();
                movieList.addAll(response.body().getResults());
                listener.onSuccess(movieList);

            }

            @Override
            public void onFailure(Call<ResponseSearchMovie> call, Throwable t) {
                listener.onError();
            }
        });

    }
}
