package com.example.mymenu.ui.musica;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymenu.R;
import com.example.mymenu.databinding.FragmentMusica2Binding;


public class Musica2Fragment extends Fragment {
    private Musica2ViewModel mViewModel;

    private Intent intent;
    private FragmentMusica2Binding binding;

    public static Musica2Fragment newInstance() {
        return new Musica2Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(Musica2ViewModel.class);
        binding = FragmentMusica2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btRepro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(v.getContext(),ServicioMusical.class);
                intent.putExtra("tema",R.raw.khea);
                getActivity().startService(intent);
            }

        });
        binding.btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(v.getContext(),ServicioMusical.class);
                intent.putExtra("tema",R.raw.khea);
                getActivity().stopService(intent);
            }

        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Musica2ViewModel.class);
        // TODO: Use the ViewModel
    }

}