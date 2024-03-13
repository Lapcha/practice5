package com.example.practice5;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.practice5.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        binding.buttonSendDataToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromMainFragment", binding.editTextDataToSecondFragment.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_main_to_second, bundle);
            }
        });

        binding.buttonSendDataToThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromMainFragment", binding.editTextDataToThirdFragment.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_main_to_third, bundle);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (Navigation.findNavController(view).getCurrentBackStackEntry().getSavedStateHandle().get("dataFromSecondFragment") != null){
            Bundle data = Navigation.findNavController(view).getCurrentBackStackEntry().getSavedStateHandle().get("dataFromSecondFragment");
            binding.textViewLastDataFromSecondFragment.setText(data.getString("dataFromSecondFragment"));
        }
        if (Navigation.findNavController(view).getCurrentBackStackEntry().getSavedStateHandle().get("dataFromThirdFragment") != null){
            Bundle data = Navigation.findNavController(view).getCurrentBackStackEntry().getSavedStateHandle().get("dataFromThirdFragment");
            binding.textViewLastDataFromThirdFragment.setText(data.getString("dataFromThirdFragment"));
        }
    }
}
