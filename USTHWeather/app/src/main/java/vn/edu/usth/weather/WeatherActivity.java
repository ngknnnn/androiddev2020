package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;


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

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

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

