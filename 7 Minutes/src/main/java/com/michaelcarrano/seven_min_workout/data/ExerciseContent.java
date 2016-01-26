package com.michaelcarrano.seven_min_workout.data;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.michaelcarrano.seven_min_workout.R;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public  class ExerciseContent {

    public static List<Exercise> exercises = new ArrayList<>();
//    public Exercise[] exercises;
    public static class Exercise {
        public String id;
        public String name;
        public String desc;
        public String video;
        public int dark;
        public int light;

        public Exercise(String name, String desc, String video) {
            this.name = name;
            this.desc = desc;
            this.video = video;
            this.dark = R.color.aspaym;
            this.light = R.color.aspaym_light;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public static void parse(Resources resources) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Exercise>>() {}.getType();
        JsonReader reader = new JsonReader(new InputStreamReader(resources.openRawResource(R.raw.data)));
        exercises = gson.fromJson(reader, listType);
        Log.i("PARSE", exercises.toString());
    }
}
