# Workout App

    This app is created in Kotlin and the motive behind this app was to stay fit and healthy as during this pandemic people have been staying at home for a long time and this might cause various health problems. People can do workouts at home and various exercises are shown and I also used Text to Speech in the android app where the name of the exercise and "Get ready for exercise" will be spoken by app.


# Project Structure

    📦src
    ┣ 📂androidTest
    ┃ ┗ 📂java
    ┃ ┃ ┗ 📂com
    ┃ ┃ ┃ ┗ 📂saurabhsen
    ┃ ┃ ┃ ┃ ┗ 📂workoutapp
    ┃ ┃ ┃ ┃ ┃ ┗ 📜ExampleInstrumentedTest.kt
    ┣ 📂main
    ┃ ┣ 📂java
    ┃ ┃ ┗ 📂com
    ┃ ┃ ┃ ┗ 📂saurabhsen
    ┃ ┃ ┃ ┃ ┗ 📂workoutapp
    ┃ ┃ ┃ ┃ ┃ ┣ 📂adapter
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExerciseStatusAdapter.kt
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HistoryAdapter.kt
    ┃ ┃ ┃ ┃ ┃ ┣ 📂db
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SqliteOpenHelper.kt
    ┃ ┃ ┃ ┃ ┃ ┣ 📂model
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ExerciseModel.kt
    ┃ ┃ ┃ ┃ ┃ ┣ 📂utils
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Constants.kt
    ┃ ┃ ┃ ┃ ┃ ┗ 📂view
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BMIActivity.kt
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExerciseActivity.kt
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FinishActivity.kt
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HistoryActivity.kt
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MainActivity.kt
    ┃ ┣ 📂res
    ┃ ┃ ┣ 📂drawable
    ┃ ┃ ┃ ┣ 📜circular_progress_bar.xml
    ┃ ┃ ┃ ┣ 📜circular_progress_gray.xml
    ┃ ┃ ┃ ┣ 📜drawable_radio_group_tab_background.xml
    ┃ ┃ ┃ ┣ 📜drawable_units_tab_selector.xml
    ┃ ┃ ┃ ┣ 📜drawable_units_tab_text_color_selector.xml
    ┃ ┃ ┃ ┣ 📜ic_abdominal_crunch.png
    ┃ ┃ ┃ ┣ 📜ic_action_done.png
    ┃ ┃ ┃ ┣ 📜ic_calendar.png
    ┃ ┃ ┃ ┣ 📜ic_high_knees_running_in_place.png
    ┃ ┃ ┃ ┣ 📜ic_jumping_jacks.png
    ┃ ┃ ┃ ┣ 📜ic_launcher_background.xml
    ┃ ┃ ┃ ┣ 📜ic_lunge.png
    ┃ ┃ ┃ ┣ 📜ic_plank.png
    ┃ ┃ ┃ ┣ 📜ic_push_up.png
    ┃ ┃ ┃ ┣ 📜ic_push_up_and_rotation.png
    ┃ ┃ ┃ ┣ 📜ic_side_plank.png
    ┃ ┃ ┃ ┣ 📜ic_squat.png
    ┃ ┃ ┃ ┣ 📜ic_step_up_onto_chair.png
    ┃ ┃ ┃ ┣ 📜ic_triceps_dip_on_chair.png
    ┃ ┃ ┃ ┣ 📜ic_wall_sit.png
    ┃ ┃ ┃ ┣ 📜img_main_page.png
    ┃ ┃ ┃ ┣ 📜item_circular_color_accent_background.xml
    ┃ ┃ ┃ ┣ 📜item_circular_color_accent_border.xml
    ┃ ┃ ┃ ┣ 📜item_circular_gray_background.xml
    ┃ ┃ ┃ ┣ 📜item_circular_thin_color_accent_border.xml
    ┃ ┃ ┃ ┗ 📜item_color_accent_border_ripple_background.xml
    ┃ ┃ ┣ 📂drawable-v21
    ┃ ┃ ┃ ┗ 📜item_color_accent_border_ripple_background.xml
    ┃ ┃ ┣ 📂drawable-v24
    ┃ ┃ ┃ ┗ 📜ic_launcher_foreground.xml
    ┃ ┃ ┣ 📂layout
    ┃ ┃ ┃ ┣ 📜activity_b_m_i.xml
    ┃ ┃ ┃ ┣ 📜activity_excercise.xml
    ┃ ┃ ┃ ┣ 📜activity_finish.xml
    ┃ ┃ ┃ ┣ 📜activity_history.xml
    ┃ ┃ ┃ ┣ 📜activity_main.xml
    ┃ ┃ ┃ ┣ 📜dialog_custom_back_confirmation.xml
    ┃ ┃ ┃ ┣ 📜item_exercise_status.xml
    ┃ ┃ ┃ ┗ 📜item_history_row.xml
    ┃ ┃ ┣ 📂mipmap-anydpi-v26
    ┃ ┃ ┃ ┣ 📜ic_launcher.xml
    ┃ ┃ ┃ ┗ 📜ic_launcher_round.xml
    ┃ ┃ ┣ 📂mipmap-hdpi
    ┃ ┃ ┃ ┣ 📜ic_launcher.png
    ┃ ┃ ┃ ┗ 📜ic_launcher_round.png
    ┃ ┃ ┣ 📂mipmap-mdpi
    ┃ ┃ ┃ ┣ 📜ic_launcher.png
    ┃ ┃ ┃ ┗ 📜ic_launcher_round.png
    ┃ ┃ ┣ 📂mipmap-xhdpi
    ┃ ┃ ┃ ┣ 📜ic_launcher.png
    ┃ ┃ ┃ ┗ 📜ic_launcher_round.png
    ┃ ┃ ┣ 📂mipmap-xxhdpi
    ┃ ┃ ┃ ┣ 📜ic_launcher.png
    ┃ ┃ ┃ ┗ 📜ic_launcher_round.png
    ┃ ┃ ┣ 📂mipmap-xxxhdpi
    ┃ ┃ ┃ ┣ 📜ic_launcher.png
    ┃ ┃ ┃ ┗ 📜ic_launcher_round.png
    ┃ ┃ ┣ 📂raw
    ┃ ┃ ┃ ┗ 📜press_start.mp3
    ┃ ┃ ┣ 📂values
    ┃ ┃ ┃ ┣ 📜colors.xml
    ┃ ┃ ┃ ┣ 📜dimens.xml
    ┃ ┃ ┃ ┣ 📜strings.xml
    ┃ ┃ ┃ ┣ 📜styles.xml
    ┃ ┃ ┃ ┗ 📜themes.xml
    ┃ ┃ ┗ 📂values-night
    ┃ ┃ ┃ ┗ 📜themes.xml
    ┃ ┗ 📜AndroidManifest.xml
    ┗ 📂test
    ┃ ┗ 📂java
    ┃ ┃ ┗ 📂com
    ┃ ┃ ┃ ┗ 📂saurabhsen
    ┃ ┃ ┃ ┃ ┗ 📂workoutapp
    ┃ ┃ ┃ ┃ ┃ ┗ 📜ExampleUnitTest.kt


# Features

* This app has Text to Speech Feature where "Get Ready For" and the exercise name will be spoken by app.

* This app calculates the BMI and people can findout weather they are healthy or not.

* This app uses the SQLite database to store the history of completed exercises.

* This app also have Countdown feature.


# App Images 

![App Image](https://github.com/saurabhsen24/WorkoutApp/blob/master/AppImages/Workout_1.jpg?raw=true)

![App Image](https://github.com/saurabhsen24/WorkoutApp/blob/master/AppImages/Workout_2.jpg?raw=true)

![App Image](https://github.com/saurabhsen24/WorkoutApp/blob/master/AppImages/Workout_3.jpg?raw=true)

![App Image](https://github.com/saurabhsen24/WorkoutApp/blob/master/AppImages/Workout_4.jpg?raw=true)

![App Image](https://github.com/saurabhsen24/WorkoutApp/blob/master/AppImages/Workout_5.jpg?raw=true)

![App Image](https://github.com/saurabhsen24/WorkoutApp/blob/master/AppImages/Workout_6.jpg?raw=true)
