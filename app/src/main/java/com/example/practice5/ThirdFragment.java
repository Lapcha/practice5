package com.example.practice5;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.practice5.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(getLayoutInflater());
        String data = getArguments().getString("dataFromMainFragment");
        binding.textViewLastDataFromMainFragment.setText("Последнее сообщение от главного фрагмента: " + data);
        binding.buttonSendDataToMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromThirdFragment", binding.editTextDataToMainFragment.getText().toString());
                Navigation.findNavController(v).getPreviousBackStackEntry().getSavedStateHandle().set("dataFromThirdFragment", bundle);
                Navigation.findNavController(v).popBackStack();
            }
        });
        return binding.getRoot();
    }
}
