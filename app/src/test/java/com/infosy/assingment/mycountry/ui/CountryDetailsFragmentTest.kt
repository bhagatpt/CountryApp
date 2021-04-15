package com.infosy.assingment.mycountry.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.model.CountryDetails
import com.infosy.assingment.mycountry.viewmodel.CountryViewModel
import io.reactivex.Single
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

@RunWith(JUnit4::class)
class CountryDetailsFragmentTest : Fragment() {
    @Mock
    internal var mViewModel: CountryViewModel? = null
    @Mock
    internal val movieList: MutableList<CountryDetails> = ArrayList()
    @Mock
     var recyclerView: RecyclerView? = null
    @Mock
    internal var mAdapter: CountryAdapter? = null
    @Mock
    var actionBar: ActionBar? = null
    @Mock
     var rootView: View? = null
    @Mock
     var mSwipeRefreshLayout: SwipeRefreshLayout? = null


    @Mock
   var countryDetailsFragmentTest: CountryDetailsFragment? = null


    @Before
    @Throws(java.lang.Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        countryDetailsFragmentTest = CountryDetailsFragment.newInstance()
    }

    @Test
    fun testFragmentViewModelSuccess() {
        countryDetailsFragmentTest?.mViewModel?.countries
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        countryDetailsFragmentTest = null
    }
}