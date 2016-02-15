package org.college.android.itomer.recyclerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.OvershootInterpolator;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecycler();
    }

    private void initRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvDemo);
        //get the data from a service... or just dummy data.
        ArrayList<Note> notes = initDummyData();

        //init the adapter & Layout Manager
        RecyclerAdapter adapter = new RecyclerAdapter(notes, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //add animations:
        AnimationAdapter scaleAndAlpahAdapter = addAnimations(adapter);

        //use the adapter
        recyclerView.setAdapter(scaleAndAlpahAdapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(adapter);

    }

    @NonNull
    private ArrayList<Note> initDummyData() {
        ArrayList<Note> notes = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Note n = new Note(i + " title", i + " Content", R.mipmap.ic_launcher);
            notes.add(n);
        }
        return notes;
    }

    @NonNull
    private AnimationAdapter addAnimations(RecyclerAdapter adapter) {
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        alphaAdapter.setDuration(100);
        alphaAdapter.setInterpolator(new AnticipateOvershootInterpolator(1f));

        //ScaleAdapter + AlphaAdapter
        ScaleInAnimationAdapter scaleAndAlpahAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        scaleAndAlpahAdapter.setDuration(250);
        scaleAndAlpahAdapter.setInterpolator(new OvershootInterpolator(.4f));
        return scaleAndAlpahAdapter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
