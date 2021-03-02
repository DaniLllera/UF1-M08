package com.example.proyectom07_izimoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectom07_izimoto.databinding.FragmentFechaExamenBinding;


public class FechaExamenFragment extends Fragment{

    private FragmentFechaExamenBinding binding;
    private AppViewModel appViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentFechaExamenBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        appViewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);


        binding.calendarView.setDateFormat("yyyy MMM");
        binding.calendarView.setPreventPreviousDate(true);
        binding.calendarView.setErrToastMessage("Selecciona una fecha valida");
        binding.calendarView.buildCalendar();

        binding.calendarView.setOnDaySelectedListener((startDay, endDay) -> {
            appViewModel.startday=startDay;
            navController.navigate(R.id.action_fechaExamenFragment_to_confirmarFechaFragment);

        });
    }
}
