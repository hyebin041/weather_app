package com.example.my_application_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

    private String title;
    private int page;

    public static ThirdFragment newInstance(int page, String title){
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       //View view = inflater.inflate();
    }*/
}
