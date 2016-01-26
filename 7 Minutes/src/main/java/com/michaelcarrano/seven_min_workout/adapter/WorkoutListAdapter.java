package com.michaelcarrano.seven_min_workout.adapter;

import com.michaelcarrano.seven_min_workout.R;
import com.michaelcarrano.seven_min_workout.data.ExerciseContent;
import com.michaelcarrano.seven_min_workout.data.ExerciseContent.Exercise;
import com.michaelcarrano.seven_min_workout.data.WorkoutContent;
import com.michaelcarrano.seven_min_workout.data.WorkoutContent.Workout;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Custom adapter for {@link com.michaelcarrano.seven_min_workout.WorkoutListFragment } to display
 * the ID and Name of Workout in a ListView row.
 *
 * @author michaelcarrano
 */
public class WorkoutListAdapter extends BaseAdapter {

    private static LayoutInflater mLayoutInflater = null;

    public WorkoutListAdapter(Activity ctx) {
        Log.i("PARSE", ExerciseContent.exercises.toString());
        this.mLayoutInflater = ctx.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return ExerciseContent.exercises.size();
    }

    @Override
    public Object getItem(int position) {
        return ExerciseContent.exercises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Exercise workout = (Exercise) getItem(position);

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.adapter_workout_row, parent, false);

            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.workout_id);
            holder.name = (TextView) convertView.findViewById(R.id.workout_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the content for the ListView row
        holder.id.setText(workout.id);
        holder.name.setText(workout.name);

        // Set the color for the ListView row
//        holder.id.setBackgroundColor(Color.parseColor(workout.dark));
//        holder.name.setBackgroundColor(Color.parseColor(workout.light));

        return convertView;
    }

    public static class ViewHolder {

        public TextView id;

        public TextView name;
    }
}
