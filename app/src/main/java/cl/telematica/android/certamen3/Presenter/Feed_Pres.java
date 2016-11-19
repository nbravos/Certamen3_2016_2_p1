package cl.telematica.android.certamen3.Presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen3.Fragment.Feed_Implemet;
import cl.telematica.android.certamen3.HttpServerConnection;
import cl.telematica.android.certamen3.View.Feed_View;
import cl.telematica.android.certamen3.Model.Feed;

/**
 * Created by Naty on 18-11-2016.
 */

public class Feed_Pres {

    private RecyclerView.Adapter mAdapter;
    private Feed_View mFeed_View;
    public Context mContext;






    public Feed_Pres(Feed_View mFeed_View, Context mContext)  {
        this.mFeed_View = mFeed_View;
        this.mContext = mContext;

    }

    AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected String doInBackground(Void... params) {
            String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/582eea8b2600007b0c65f068", 15000);
            return resultado;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result != null){
                System.out.println(result);


                System.out.println(mContext);
                mAdapter = new DataAdapter(mContext, getFeeds(result));
                mFeed_View.manageRecyclerView(mAdapter);
            }
        }
    };


    public AsyncTask<Void, Void, String> getTask() {return task; }
    public List<Feed> getFeeds(String result) {
        List<Feed> feeds = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject responseData = jsonObject.getJSONObject("responseData");
            JSONObject feedObj = responseData.getJSONObject("feed");

            JSONArray entries = feedObj.getJSONArray("entries");
            int size = entries.length();
            for(int i = 0; i < size; i++){
                JSONObject entryObj = entries.getJSONObject(i);
                Feed feed = new Feed();

                feed.setTitle(entryObj.optString("title"));
                feed.setLink(entryObj.optString("link"));
                feed.setAuthor(entryObj.optString("author"));
                feed.setPublishedDate(entryObj.optString("publishedDate"));
                feed.setContent(entryObj.optString("content"));
                feed.setImage(entryObj.optString("image"));

                feeds.add(feed);
            }

            return feeds;
        } catch (JSONException e) {
            e.printStackTrace();
            return feeds;
        }
    }


}
