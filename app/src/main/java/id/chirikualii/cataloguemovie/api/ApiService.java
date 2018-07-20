package id.chirikualii.cataloguemovie.api;

import id.chirikualii.cataloguemovie.model.ResponseSearchMovie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("3/search/movie?language=en-US&page=1&include_adult=false")
    Call<ResponseSearchMovie> responseSearchMovieCall(
            @Query("api_key")String apiKey,
            @Query("query")String query,
            @Query("page")String page
    );
}
