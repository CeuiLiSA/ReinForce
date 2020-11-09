package ceui.lisa.rrshare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ceui.lisa.rrshare.response.Content;

public class MovieModel extends ViewModel {

    private MutableLiveData<Content> movie;

    public MutableLiveData<Content> getMovie() {
        if (movie == null) {
            movie = new MutableLiveData<>();
        }
        return movie;
    }

    public void setMovie(MutableLiveData<Content> movie) {
        this.movie = movie;
    }
}
