package com.example.spinnermagic;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout activityBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // here don't need of the typecast because above we already create the instance above
        TextView selectColor = findViewById(R.id.select_color);   // we don't need to use typecast if we make the field local variable or instance above
        Spinner colorSpinner = findViewById(R.id.color_spinner);
        activityBackground =  findViewById(R.id.background_activity);

        // For to access its own font
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "font/CustomFont.ttf");
        selectColor.setTypeface(myCustomFont);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.color_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);

        colorSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String selectedColor = adapterView.getItemAtPosition(position).toString();
                // above value integer if we direct access using Color.RED
                switch (selectedColor) {
                    case "Red":
                        // if we select the Color.RED than we have to store this value into integer
                        // because color code in hexadecimal which returns int value
                        //selectedColor = Color.RED;
                        // activity background is the id of the linear layout we want to change the
                        // color of layout so we take this activity
                        activityBackground.setBackgroundColor(Color.RED);
                        break;
                    case "Green":
                        activityBackground.setBackgroundColor(Color.GREEN);
                        break;
                    case "Yellow":
                        activityBackground.setBackgroundColor(Color.YELLOW);
                        break;
                    case "Blue":
                        activityBackground.setBackgroundColor(Color.BLUE);
                        break;
                    case "Lilac":
                        activityBackground.setBackgroundColor(getResources().getColor(R.color.Lilac));
                        break;
                    case "cream":
                        activityBackground.setBackgroundColor(getResources().getColor(R.color.cream));
                        break;
                    case "whitest":
                        activityBackground.setBackgroundColor(getResources().getColor(R.color.whitest));
                        break;
                    case "brown":
                        activityBackground.setBackgroundColor(getResources().getColor(R.color.brown));
                        break;

                    }
                }
              //  @Override
            //    public void onNothingSelected(AdapterView<?> parent){


                //}

           });

    }
}
