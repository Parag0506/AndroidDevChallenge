package com.example.td_.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.td_.MainActivity;
import com.example.td_.R;

public class ToolsFragment extends Fragment implements View.OnClickListener {

    private ToolsViewModel toolsViewModel;
    private RatingBar ratingBar;
    Button b;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        b=root.findViewById(R.id.feedback);
        b.setOnClickListener(this);
        return root;

    }
    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"Thank you",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}