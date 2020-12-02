package com.saurabhsen.workoutapp.utils

import com.saurabhsen.workoutapp.model.ExerciseModel
import com.saurabhsen.workoutapp.R

class Constants {

    companion object {
        fun defaultExercise(): ArrayList<ExerciseModel> {
            val exerciseList = mutableListOf<ExerciseModel>(
                    ExerciseModel(1,"Jumping Jacks", R.drawable.ic_jumping_jacks, isCompleted = false, isSelected = false),
                    ExerciseModel(2, "Wall Sit", R.drawable.ic_wall_sit, isCompleted = false, isSelected = false),
                    ExerciseModel(3, "Push Up", R.drawable.ic_push_up, isCompleted = false, isSelected = false),
                    ExerciseModel(4, "Abdominal Crunch", R.drawable.ic_abdominal_crunch, isCompleted = false, isSelected = false),
                    ExerciseModel(5, "Set-Up onto Chain", R.drawable.ic_step_up_onto_chair, isCompleted = false, isSelected = false),
                    ExerciseModel(6, "Squat", R.drawable.ic_squat, isCompleted = false, isSelected = false),
                    ExerciseModel(7, "Triceps Dip on the Chain", R.drawable.ic_triceps_dip_on_chair, isCompleted = false, isSelected = false),
                    ExerciseModel(8, "Plank", R.drawable.ic_plank, isCompleted = false, isSelected = false),
                    ExerciseModel(9, "High Knees Running In Place", R.drawable.ic_high_knees_running_in_place, isCompleted = false, isSelected = false),
                    ExerciseModel(10, "Lunges", R.drawable.ic_lunge, isCompleted = false, isSelected = false),
                    ExerciseModel(11, "Push Up And Rotation", R.drawable.ic_push_up_and_rotation, isCompleted = false, isSelected = false),
                    ExerciseModel(12, "Side Plank", R.drawable.ic_side_plank, isCompleted = false, isSelected = false)
            )

            return exerciseList as ArrayList<ExerciseModel>
        }
    }
}