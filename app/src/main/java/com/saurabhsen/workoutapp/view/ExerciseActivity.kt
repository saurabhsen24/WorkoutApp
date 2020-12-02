package com.saurabhsen.workoutapp.view

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saurabhsen.workoutapp.R
import com.saurabhsen.workoutapp.adapter.ExerciseStatusAdapter
import com.saurabhsen.workoutapp.model.ExerciseModel
import com.saurabhsen.workoutapp.utils.Constants
import kotlinx.android.synthetic.main.activity_excercise.*
import kotlinx.android.synthetic.main.dialog_custom_back_confirmation.*
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0

    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1

    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null
    private var exerciseAdapter: ExerciseStatusAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)
        setSupportActionBar(toolbar_exercise_activity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        toolbar_exercise_activity.setNavigationOnClickListener {
            customDialogForBackButton()
        }

        tts = TextToSpeech(this,this)
        exerciseList = Constants.defaultExercise()
        setupRestView()

        setupExerciseStatusRecyclerView()
    }

    override fun onDestroy() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }

        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }

        if(player != null){
            player!!.stop()
        }

        super.onDestroy()
    }

    private fun setProgressBar() {
        progressBar.progress = restProgress
        restTimer = object : CountDownTimer(1000, 1000) { //10000
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress = 10 - restProgress
                tvTimer.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                currentExercisePosition++
                exerciseList!![currentExercisePosition].isSelected = true
                exerciseAdapter!!.notifyDataSetChanged()
                setupExerciseView()
            }

        }.start()
    }

    private fun setupRestView() {

        try{
            player = MediaPlayer.create(applicationContext, R.raw.press_start)
            player!!.isLooping = false
            player!!.start()
        }catch (e: Exception){
            e.printStackTrace()
        }

        llRestView.visibility = View.VISIBLE
        llExerciseView.visibility = View.GONE
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }

        tvUpcomingExerciseName.text = exerciseList!![currentExercisePosition + 1].name

        setProgressBar()
    }

    private fun setExerciseProgressBar() {
        progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(1000, 1000) { //30000
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                progressBarExercise.progress = 30 - exerciseProgress
                tvExerciseTimer.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                if (currentExercisePosition < exerciseList?.size!! - 1) {
                    exerciseList!![currentExercisePosition].isSelected = false
                    exerciseList!![currentExercisePosition].isCompleted = true
                    exerciseAdapter!!.notifyDataSetChanged()
                    setupRestView()
                } else {
                    finish()
                    startActivity(Intent(this@ExerciseActivity, FinishActivity::class.java))
                }
            }

        }.start()
    }

    private fun setupExerciseView() {

        llRestView.visibility = View.GONE
        llExerciseView.visibility = View.VISIBLE

        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }

        speakOut(exerciseList!![currentExercisePosition].name)

        setExerciseProgressBar()
        ivImage.setImageResource(exerciseList!![currentExercisePosition].image)
        tvExerciseName.text = exerciseList!![currentExercisePosition].name
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The Language specified is not supported")
            }
        }else{
            Log.e("TTS","Initialization Failed")
        }
    }

    private fun speakOut(text: String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private fun setupExerciseStatusRecyclerView(){
        rvExerciseStatus.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL , false)
        exerciseAdapter = ExerciseStatusAdapter(exerciseList!!, this)
        rvExerciseStatus.adapter = exerciseAdapter!!
    }

    private fun  customDialogForBackButton(){
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom_back_confirmation)
        customDialog.tvYes.setOnClickListener {
            finish()
            customDialog.dismiss()
        }

        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }

        customDialog.show()
    }
}