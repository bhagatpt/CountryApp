package com.infosy.assingment.mycountry.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.infosy.assingment.mycountry.R
import com.infosy.assingment.mycountry.custom.CheckConnection
import com.infosy.assingment.mycountry.model.CountryDetails
import com.infosy.assingment.mycountry.viewmodel.CountryViewModel
import java.util.*

class CountryDetailsFragment : Fragment(), OnRefreshListener {
    public var mViewModel: CountryViewModel? = null
    private val movieList: MutableList<CountryDetails> = ArrayList()
    var recyclerView: RecyclerView? = null
    private var mAdapter: CountryAdapter? = null
    var actionBar: ActionBar? = null
    var rootView: View? = null
    var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.country_details_fragment, container, false)
        initViews()
        getData()
        return rootView
    }

     private fun initViews() {
            actionBar=(activity as AppCompatActivity?)?.supportActionBar
            recyclerView = rootView?.findViewById<View>(R.id.recycler_view) as RecyclerView
            mAdapter = context?.let { CountryAdapter(it, movieList) }
            val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
            recyclerView?.layoutManager = mLayoutManager
            recyclerView?.itemAnimator = DefaultItemAnimator()
            recyclerView?.adapter = mAdapter
            mSwipeRefreshLayout = rootView?.findViewById<View>(R.id.storageSwipeRefreshLayout) as SwipeRefreshLayout
            mSwipeRefreshLayout?.setOnRefreshListener(this)

    }

    @VisibleForTesting
    fun getData(){
        mViewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        if (context?.let { CheckConnection.haveNetworkConnection(it) } == true) {
            val loading = ProgressDialog.show(context, "", "Please wait...", false, false)
            mViewModel?.init()
            mViewModel?.countries?.observe(this, Observer { movieModels -> // set recyclerview
                if (!(movieModels?.rows?.isEmpty() == true || movieModels?.rows?.size == 0)) {
                    movieModels?.rows?.let { movieList.addAll(it) }
                } else {
                    Toast.makeText(context, R.string.no_data_found, Toast.LENGTH_LONG).show()
                }
                actionBar?.title = movieModels?.title
                mAdapter?.notifyDataSetChanged()
                loading.cancel()
            })
        } else {
            Toast.makeText(context, R.string.check_connection, Toast.LENGTH_LONG).show()
        }
    }
    override fun onRefresh() {
        Handler().postDelayed({ mSwipeRefreshLayout?.isRefreshing = false }, 1500)
    }

    companion object {
        fun newInstance(): CountryDetailsFragment {
            return CountryDetailsFragment()
        }
    }
}