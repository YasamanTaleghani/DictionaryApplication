package com.example.dictionaryapplication.Controller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.dictionaryapplication.Controller.Fragment.MainFragment;
import com.example.dictionaryapplication.R;

public class MainActivity extends SingleFragmentActivity{

    @Override
    public Fragment createFragment() {
        MainFragment mainFragment = MainFragment.newInstance();
        return mainFragment;
    }
}