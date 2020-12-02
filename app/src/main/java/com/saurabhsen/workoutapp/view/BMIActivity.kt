package com.saurabhsen.workoutapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.saurabhsen.workoutapp.R
import kotlinx.android.synthetic.main.activity_b_m_i.*
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    var currentVisibleView = METRIC_UNITS_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)
        setSupportActionBar(toolbar_bmi_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "CALCULATE BMI"
        }

        toolbar_bmi_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        btnCalculateUnits.setOnClickListener {
            if(currentVisibleView == METRIC_UNITS_VIEW){
                if (validateMetricUnit()) {
                    val heightValue: Float = etMetricUnitHeight.text.toString().toFloat() / 100
                    val weightValue: Float = etMetricUnitWeight.text.toString().toFloat()
                    val bmi = weightValue / (heightValue * heightValue)
                    displayBMIResult(bmi)
                }else{
                    Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show()
                }
            }else{
                if(validateUSUnit()){
                    val usUnitHeightValueFeet = etUsUnitHeightFeet.text.toString()
                    val usUnitHeightValueInch = etUsUnitHeightInch.text.toString()
                    val usUnitWeightValue: Float = etUsUnitWeight.text.toString().toFloat()

                    val heightValue = usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12
                    val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))
                    displayBMIResult(bmi)
                }else{
                    Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show()
                }
            }

        }

        makeVisibleMetricUnitsView()
        rgUnits.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }else{
                makeVisibleUsUnitsView()
            }
        }
    }

    private fun displayBMIResult(bmi: Float) {
        val bmiLabel: String
        val bmiDescription: String
        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "Very severely underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0) {
            bmiLabel = "Severely underweight"
            bmiDescription = "Oops!You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in a good shape!"
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(
                bmi,
                30f
            ) <= 0) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0) {
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        } else {
            bmiLabel = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }

        llDiplayBMIResult.visibility = View.VISIBLE

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        tvBMIValue.text = bmiValue
        tvBMIType.text = bmiLabel
        tvBMIDescription.text = bmiDescription
    }

    private fun validateMetricUnit(): Boolean {
        var isValid = true
        if (etMetricUnitHeight.text.toString().isEmpty()) isValid = false
        if (etMetricUnitWeight.text.toString().isEmpty()) isValid = false
        return isValid
    }

    private fun validateUSUnit(): Boolean {
        var isValid = true
        when {
            etUsUnitHeightFeet.text.toString().isEmpty() -> isValid = false
            etUsUnitHeightInch.text.toString().isEmpty() -> isValid = false
            etUsUnitWeight.text.toString().isEmpty() -> isValid = false
        }
        return isValid
    }

    private fun makeVisibleMetricUnitsView() {
        currentVisibleView = METRIC_UNITS_VIEW
        tilMetricUnitWeight.visibility = View.VISIBLE
        tilMetricUnitHeight.visibility = View.VISIBLE

        etMetricUnitHeight.text!!.clear()
        etMetricUnitWeight.text!!.clear()

        tilUsUnitWeight.visibility = View.GONE
        llUsUnitsHeight.visibility = View.GONE
        llDiplayBMIResult.visibility = View.INVISIBLE
    }

    private fun makeVisibleUsUnitsView() {
        currentVisibleView = US_UNITS_VIEW
        tilMetricUnitWeight.visibility = View.GONE
        tilMetricUnitHeight.visibility = View.GONE

        etUsUnitHeightFeet.text!!.clear()
        etUsUnitHeightInch.text!!.clear()
        etUsUnitWeight.text!!.clear()

        tilUsUnitWeight.visibility = View.VISIBLE
        llUsUnitsHeight.visibility = View.VISIBLE
        llDiplayBMIResult.visibility = View.INVISIBLE
    }

    companion object {
        const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }

}