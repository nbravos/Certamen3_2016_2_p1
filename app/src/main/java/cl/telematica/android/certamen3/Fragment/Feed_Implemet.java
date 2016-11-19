package cl.telematica.android.certamen3.Fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import cl.telematica.android.certamen3.Presenter.Feed_Pres;
import cl.telematica.android.certamen3.R;
import cl.telematica.android.certamen3.View.Feed_View;
import android.content.Context;

/**
 * Created by Naty on 18-11-2016.
 */

public class Feed_Implemet  extends Fragment implements Feed_View{
    private Feed_Pres mFeed_Presenter;

    public RecyclerView mRecyclerView;
    public RecyclerView.LayoutManager mLayoutManager;

    public static Feed_Implemet nuevoFeed_Implement(){
        Feed_Implemet fragment  = new Feed_Implemet();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.main_view, null);

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mFeed_Presenter = new Feed_Pres(this);
        mFeed_Presenter.getTask().execute();

        return mainView;
    }

    public void manageRecyclerView(RecyclerView.Adapter mAdapter){
        mRecyclerView.setAdapter(mAdapter);
    }

}
