package com.e.tfl_coding.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e.tfl_coding.R
import com.e.tfl_coding.common.ApiProgress
import com.e.tfl_coding.common.AppInjector
import com.e.tfl_coding.di.activity.ActivityComponent
import com.e.tfl_coding.di.activity.ActivityModule
import com.e.tfl_coding.di.factories.RoadViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var activityComponent: ActivityComponent
    @Inject
    lateinit var factory: RoadViewModelFactory
    private lateinit var viewModel: RoadViewModel
    private var roadId = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()
        viewModel = ViewModelProvider(this, factory).get(RoadViewModel::class.java)

        search.setOnClickListener {
            roadId = et_road_id.text.toString()
            viewModel.getRoadResponse(roadId)
        }
        viewModel.status.observe(this, Observer {
            when(it){
                is ApiProgress.PROGRESS->{
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                is ApiProgress.SUCCESS->{
                    name.text = it.roads[0].displayName
                    status.text = it.roads[0].statusSeverity
                    description.text = it.roads[0].statusSeverityDescription
                }
                is ApiProgress.FAILURE->{
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Error Message")
                    alert.setMessage(it.error)
                    alert.setNeutralButton("Okay"){
                        dialog, which ->
                    }

                    val dialog: AlertDialog = alert.create()
                    dialog.show()
                }
            }
        })

    }

    private fun injectDependencies() {
        activityComponent =
            (this.application as AppInjector).applicationComponent.newActivityComponent(
                ActivityModule()
            )
        activityComponent.injectRoadActivity(this)
    }
}
