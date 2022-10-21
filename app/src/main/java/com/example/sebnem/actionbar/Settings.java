package com.example.sebnem.actionbar;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;


public class Settings extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        String[] list = new String[]{getActivity().getString(R.string.sellect) , "Azerbaycan" , "English"};
        String[] countryCodeList= new String[]{"az" , "en"};

       Spinner spinner =  v.findViewById(R.id.spinner);
       spinner.setAdapter(new ArrayAdapter<String>(getActivity() , android.R.layout.simple_spinner_dropdown_item , list));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0){
                   setLanguage(countryCodeList[i-1]);
                    getActivity().finish();
                    startActivity(getActivity().getIntent());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return  v;
    }

    private void setLanguage(String country){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = new Locale(country);
        res.updateConfiguration(conf , dm);
    }
}