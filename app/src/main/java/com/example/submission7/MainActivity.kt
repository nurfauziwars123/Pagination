package com.example.submission7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.submission7.adapter.Adapter_Main
import com.example.submission7.model.ResultsItem
import com.example.submission7.network.ApiService
import com.example.submission7.network.NetworkConfig
import com.example.submission7.viewModel.MainViewModel
import io.reactivex.rxjava3.core.Flowable
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fabBackTop.setOnClickListener {
            rv_list_item.smoothScrollToPosition(0);
        }



        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getResult().observe(this, Observer {

            val adapter = Adapter_Main()
            adapter.submitList(it)
            rv_list_item.adapter = adapter
        })

    }


}
