package com.dsi32gr11.tunisiaup.ui.definition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dsi32gr11.tunisiaup.R;

public class DefinitionFragment extends Fragment {

    private DefinitonViewModel definitonViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        definitonViewModel =
                ViewModelProviders.of(this).get(DefinitonViewModel.class);
        View root = inflater.inflate(R.layout.fragment_definition, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        definitonViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;

    }





}