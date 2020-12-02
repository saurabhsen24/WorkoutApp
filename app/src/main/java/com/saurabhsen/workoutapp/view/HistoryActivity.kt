package com.saurabhsen.workoutapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurabhsen.workoutapp.R
import com.saurabhsen.workoutapp.adapter.HistoryAdapter
import com.saurabhsen.workoutapp.db.SqliteOpenHelper
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        setSupportActionBar(toolbar_history_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "HISTORY"
        }

        toolbar_history_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        getAllCompletedDates()
    }

    private fun getAllCompletedDates() {
        val dbHandler = SqliteOpenHelper(this, null)
        val allCompletedDateList = dbHandler.getAllCompletedDateList()
        if(allCompletedDateList.size > 0){
            tvHistory.visibility = View.VISIBLE
            rvHistory.visibility = View.VISIBLE
            tvNoDataAvailable.visibility = View.GONE
            rvHistory.layoutManager = LinearLayoutManager(this)
            val historyAdapter = HistoryAdapter(this, allCompletedDateList)
            rvHistory.adapter = historyAdapter
        }else{
            tvHistory.visibility = View.GONE
            rvHistory.visibility = View.GONE
            tvNoDataAvailable.visibility = View.VISIBLE
        }
    }
}