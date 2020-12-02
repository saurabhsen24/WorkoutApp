package com.saurabhsen.workoutapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.saurabhsen.workoutapp.model.ExerciseModel
import com.saurabhsen.workoutapp.R
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class ExerciseStatusAdapter(private val items: ArrayList<ExerciseModel>, val context: Context): RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(item: ExerciseModel){
            view.tvItem.text = item.id.toString()
            if(item.isSelected){
                view.tvItem.background = ContextCompat.getDrawable(context,
                    R.drawable.item_circular_thin_color_accent_border
                )
                view.tvItem.setTextColor(Color.parseColor("#212121"))
            }else if(item.isCompleted){
                view.tvItem.background = ContextCompat.getDrawable(context,
                    R.drawable.item_circular_color_accent_background
                )
                view.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }else{
                view.tvItem.background = ContextCompat.getDrawable(context,
                    R.drawable.item_circular_gray_background
                )
                view.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise_status, parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}