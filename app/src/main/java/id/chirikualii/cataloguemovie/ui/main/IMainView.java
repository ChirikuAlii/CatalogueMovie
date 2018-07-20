package id.chirikualii.cataloguemovie.ui.main;

import java.util.List;

import id.chirikualii.cataloguemovie.model.SearchMovie;

public interface IMainView {
    void setOnSuccess(List<SearchMovie> movieList);
    void setOnError();
    void showLoading();
}
