package com.zero.modeloa.view.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zero.modeloa.R;
import com.zero.modeloa.adapter.ItemOffsetDecoration;
import com.zero.modeloa.adapter.PictureAdapterRecyclerView;
import com.zero.modeloa.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    PictureAdapterRecyclerView adapter;
    RecyclerView recycler_lista;
    FloatingActionButton fab;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.bottom_navigation_home),false,view);
        recycler_lista = (RecyclerView) view.findViewById(R.id.recycler_lista);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_home);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recycler_lista.setLayoutManager(linearLayoutManager);

        adapter = new PictureAdapterRecyclerView(buildPictures(),R.layout.carview_picture,getActivity());
        recycler_lista.setAdapter(adapter);
        recycler_lista.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Agregados",Toast.LENGTH_SHORT).show();
                addAll();
            }
        });
        return view;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private ArrayList<Picture> buildPictures(){
        ArrayList<Picture> lista = new ArrayList<Picture>();
        lista.add(new Picture("http://media.tumblr.com/2e1cbacfc100ea973bae8d2035820178/tumblr_inline_mw68fdmWbL1sp7s5w.png","Kevin Robin","3 días","2 Me gusta"));
        lista.add(new Picture("https://68.media.tumblr.com/b0b160ef6631fc81d2a2e5a20cec2b1a/tumblr_nq65s9XHo41rci0ueo1_500.jpg","Monica Yurani","3 días","5 Me gusta"));
        lista.add(new Picture("https://secure.static.tumblr.com/0c52d873071333e7efefefed5c653ecd/e1lh8lc/C6xnl3elu/tumblr_static_716d3gkn63cwcss8go04ck0kc_640_v2.jpg","Jack Junior","5 días","10 Me gusta"));
        lista.add(new Picture("https://secure.static.tumblr.com/17efe76922038b70f3211cf639d5b030/mn6o5pi/J7ynai5sm/tumblr_static_tumblr_static_19rddujhuh7o848s8wgwo88w8_640.jpg","Kris Evans","2 días","15 Me gusta"));
        return lista;
    }

    private void addAll(){
        ArrayList<Picture> lista = new ArrayList<Picture>();
        lista.add(new Picture("http://media.tumblr.com/2e1cbacfc100ea973bae8d2035820178/tumblr_inline_mw68fdmWbL1sp7s5w.png","Arthas","2 días","30 Me gusta"));
        lista.add(new Picture("https://68.media.tumblr.com/b0b160ef6631fc81d2a2e5a20cec2b1a/tumblr_nq65s9XHo41rci0ueo1_500.jpg","Sara","1 días","45 Me gusta"));
        lista.add(new Picture("https://secure.static.tumblr.com/0c52d873071333e7efefefed5c653ecd/e1lh8lc/C6xnl3elu/tumblr_static_716d3gkn63cwcss8go04ck0kc_640_v2.jpg","Chimney","1 días","29 Me gusta"));
        lista.add(new Picture("https://secure.static.tumblr.com/17efe76922038b70f3211cf639d5b030/mn6o5pi/J7ynai5sm/tumblr_static_tumblr_static_19rddujhuh7o848s8wgwo88w8_640.jpg","Kai","1 días","5 Me gusta"));
        adapter.addAll(lista);
    }

}
