package ceui.lisa.rrshare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.Hot;

public class SearchModel extends ViewModel {

    private MutableLiveData<Hot> hot;

    public MutableLiveData<Hot> getMovie() {
        if (hot == null) {
            hot = new MutableLiveData<>();
        }
        return hot;
    }

    public void setMovie(MutableLiveData<Hot> hot) {
        this.hot = hot;
    }
}
