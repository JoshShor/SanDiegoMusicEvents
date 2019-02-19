package edu.miracostacollege.cs134.sandiegomusicevents.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class loads MusicEvent data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (MusicEvent) with data.
 */

public class JSONLoader {

    /**
     * Loads JSON data from a file in the assets directory.
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static List<MusicEvent> loadJSONFromAsset(Context context) throws IOException {
        List<MusicEvent> allMusicEvents = new ArrayList<>();
        String json;
            //TODO: Complete the file name, DONE
            InputStream is = context.getAssets().open("MusicEvents.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            //TODO: Complete the name of the root object in the JSON file, DONE
            JSONArray allMusicEventsJSON = jsonRootObject.getJSONArray("MusicEvent");
            int numberOfEvents = allMusicEventsJSON.length();

            for (int i = 0; i < numberOfEvents; i++) {
                JSONObject musicEventJSON = allMusicEventsJSON.getJSONObject(i);

                MusicEvent event = new MusicEvent();

                //Extract the artist from the JSON object
                event.setArtist(musicEventJSON.getString("Artist"));
                event.setDate(musicEventJSON.getString("Date"));
                event.setDay(musicEventJSON.getString("Day"));
                event.setTime(musicEventJSON.getString("Time"));
                event.setVenue(musicEventJSON.getString("Venue"));
                event.setCity(musicEventJSON.getString("City"));
                event.setState(musicEventJSON.getString("State"));
                event.setImageName(musicEventJSON.getString("ImageName"));

                allMusicEvents.add(event);

                //TODO: Complete the information about the event by parsing the JSON file, DONE

            allMusicEvents.add(event);
        }
        }
        catch (JSONException e)
        {
            Log.e("SD Music Events", e.getMessage());
        }

        return allMusicEvents;
    }
}
