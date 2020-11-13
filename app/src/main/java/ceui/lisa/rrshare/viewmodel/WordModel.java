package ceui.lisa.rrshare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class WordModel extends ViewModel {

    private MutableLiveData<String> word;

    public MutableLiveData<String> getMovie() {
        if (word == null) {
            word = new MutableLiveData<>();
        }
        return word;
    }
}
