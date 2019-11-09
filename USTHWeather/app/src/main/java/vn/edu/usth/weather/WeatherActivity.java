package vn.edu.usth.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Running","");
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




