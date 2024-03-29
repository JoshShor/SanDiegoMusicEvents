package edu.miracostacollege.cs134.sandiegomusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import edu.miracostacollege.cs134.sandiegomusicevents.model.JSONLoader;
import edu.miracostacollege.cs134.sandiegomusicevents.model.MusicEvent;

public class MainActivity extends ListActivity {

    private ListView eventsListView;
    //Create a list of music events, these will be loaded from JSON
    List<MusicEvent> allMusicEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Load the List using JSONLoader
        try {
            allMusicEvents = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("SD Music Events", "Error loading JSON" + e.getMessage());
        }



        eventsListView = findViewById(R.id.eventsListView);
        setListAdapter(new ArrayAdapter<>(this, R.layout.music_event_list_item, allMusicEvents));
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);

        //ListItems correspond to the list entries by position
        MusicEvent selectedEvent = allMusicEvents.get(position);

        detailsIntent.putExtra("Artist", selectedEvent.getArtist());
        detailsIntent.putExtra("Date", selectedEvent.getDate());
        detailsIntent.putExtra("Day", selectedEvent.getDay());
        detailsIntent.putExtra("Time", selectedEvent.getTime());
        detailsIntent.putExtra("Venue", selectedEvent.getVenue());
        detailsIntent.putExtra("City", selectedEvent.getCity());
        detailsIntent.putExtra("State", selectedEvent.getState());
        detailsIntent.putExtra("ImageName", selectedEvent.getImageName());

        startActivity(detailsIntent);

    }
}
