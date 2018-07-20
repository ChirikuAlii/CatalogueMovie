package id.chirikualii.cataloguemovie.ui.main;

import java.util.List;

import id.chirikualii.cataloguemovie.model.SearchMovie;

public class MainPresenter implements IMainPresenter , IMainInteractor.listener {
    public MainPresenter(IMainView view ) {
        this.view = view;

    }
    private MainInteractor interactor = new MainInteractor(this);
    private IMainView view;


    @Override
    public void onSuccess(List<SearchMovie> movieList) {
        view.setOnSuccess(movieList);
    }

    @Override
    public void onError() {
        view.setOnError();
    }

    @Override
    public void peformSearch(String query) {
        interactor.search(query);
    }

    @Override
    public void performLoading() {
        view.showLoading();
    }

}
