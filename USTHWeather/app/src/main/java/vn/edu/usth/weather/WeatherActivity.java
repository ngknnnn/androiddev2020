package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Environment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;


public class WeatherActivity extends AppCompatActivity{
    MediaPlayer music;

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

        //copy file to sdcard0
        copyFileToExteralStorage(R.raw.songg,"songg.mp3");

        music = MediaPlayer.create(WeatherActivity.this,R.raw.songg);
        music.start();
        music.setLooping(true);

    }

    public void copyFileToExteralStorage(int resourceId, String resourceName){
        String pathSDCard = Environment.getExternalStorageDirectory() + "/Android/data/vn.edu.usth.weather/" + resourceName;

        try{
            InputStream inputStream = getResources().openRawResource(resourceId);
            FileOutputStream outputStream = null;
            outputStream = new FileOutputStream(pathSDCard);
            byte[] buff = new byte[1024];
            int read = 0;
            try{
                while ((read = inputStream.read(buff))>0){
                    outputStream.write(buff,0,read);
                }
            }finally {
                inputStream.close();
                outputStream.close();
            }



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_refresh:
                music.seekTo(0);
                Toast.makeText(getApplicationContext(),"Once more time !",Toast.LENGTH_LONG).show();
                music.start();
// do something when search is pressed here
                return true;
            case R.id.item_1:
                Intent intent = new Intent(WeatherActivity.this, PreActivity.class);
                startActivity(intent);
                return true;
        }
        return  super.onOptionsItemSelected(item);


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
        music.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Running","Destroy");
        music.release();
        music = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Running","Pause");
        music.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Running","Remuse");
        music.start();
    }
}

