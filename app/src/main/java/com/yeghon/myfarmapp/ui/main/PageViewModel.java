package com.yeghon.myfarmapp.ui.main;

import android.view.View;

import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.yeghon.myfarmapp.R;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<Fragment> mText = Transformations.map(mIndex, new Function<Integer, Fragment>() {
        @Override
        public Fragment apply(Integer input) {
            switch (input) {
                case 1: // crops
                    return new CropsActivity();
                case 2: // livestock
                    return new LivestockActivity();
                case 3: // market
                    return new MarketActivity();
                case 4: // news
                    return new NewsActivity();
            }
            return null;
        }
//        @Override
//        public String apply(Integer input) {
//
//            return "Hello world from section: " + input;
//        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<Fragment> getText() {
        return mText;
    }
}