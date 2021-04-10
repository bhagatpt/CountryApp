package com.infosy.assingment.mycountry.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.infosy.assingment.mycountry.model.Country;
import com.infosy.assingment.mycountry.repository.CountryRepository;

public class CountryViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Country> data;
    private CountryRepository movieModel;

    public CountryViewModel() {
        movieModel = new CountryRepository();
    }

    public void init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        data = movieModel.getMovies();
    }

    public MutableLiveData<Country> getCountries() {
        return this.data;
    }
}
