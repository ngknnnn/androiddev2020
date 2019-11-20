package vn.edu.usth.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;


public class WeatherActivity extends AppCompatActivity{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load the layout
//        setContentView(R.layout.fragment_forecast);
//        LinearLayout ll = new LinearLayout(this);
//        ll.setOrientation(LinearLayout.VERTICAL);
//        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(
//
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        ll.setLayoutParams(llLP);
//        Log.i("StatusWeatherLog","method running...");
//        TextView textView = new TextView(this);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);

        // Create a new Fragment to be placed in the activity
        setContentView(R.layout.activity_main);
        ForecastFragment firstFragment = new ForecastFragment();
        WeatherFragment secondFragment = new WeatherFragment();


        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.number1, firstFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.number2, secondFragment).commit();

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Running","Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Running","Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Running","Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Running","Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Running","Remuse");
    }
}

