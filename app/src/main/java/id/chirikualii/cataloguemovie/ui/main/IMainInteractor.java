package id.chirikualii.cataloguemovie.ui.main;

import java.util.List;

import id.chirikualii.cataloguemovie.model.SearchMovie;

public interface IMainInteractor {
    void search(String query);

    interface listener{
        void onSuccess(List<SearchMovie> movieList);
        void onError();
    }
}
