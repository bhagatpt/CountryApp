package com.infosy.assingment.mycountry.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.infosy.assingment.mycountry.R;
import com.infosy.assingment.mycountry.custom.CheckConnection;
import com.infosy.assingment.mycountry.model.Country;
import com.infosy.assingment.mycountry.model.CountryDetails;
import com.infosy.assingment.mycountry.viewmodel.CountryViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountryDetailsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private CountryViewModel mViewModel;
    private List<CountryDetails> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CountryAdapter mAdapter;
    private ActionBar actionBar;
    private View rootView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static CountryDetailsFragment newInstance() {
        return new CountryDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.country_details_fragment, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mAdapter = new CountryAdapter(getActivity(), movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.storageSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        if (CheckConnection.haveNetworkConnection(getContext())) {
            //start loading
            final ProgressDialog loading = ProgressDialog.show(getContext(), "", "Please wait...", false, false);
            mViewModel.init();
            mViewModel.getCountries().observe(this, new Observer<Country>() {
                @Override
                public void onChanged(@Nullable Country movieModels) {
                    // set recyclerview
                    if(!(movieModels.getRows().isEmpty()||movieModels.getRows().size()==0)) {
                        movieList.addAll(movieModels.getRows());
                    }else {
                        Toast.makeText(getContext(), R.string.no_data_found, Toast.LENGTH_LONG).show();
                    }
                    actionBar.setTitle(movieModels.getTitle());
                    mAdapter.notifyDataSetChanged();
                    // cancel loading
                    loading.cancel();
                }
            });
        } else {
            Toast.makeText(getContext(), R.string.check_connection, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1500);
    }
}