package com.example.proyectom07_izimoto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.proyectom07_izimoto.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar); //PONE EN LA BARRA DE ARRIBA DE TITULO EL NOMBRE DEL PROYECTO


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.paginaPrincipalFragment, R.id.permisoMotoFragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId()==R.id.loginFragment){
                    binding.toolbar.setVisibility(View.GONE);

                }else if( destination.getId()==R.id.splashScreamFragment){
                    binding.toolbar.setVisibility(View.GONE);

                }else if( destination.getId()==R.id.registroFragment){
                    binding.toolbar.setVisibility(View.GONE);

                }else if( destination.getId()==R.id.paginaPrincipalProfessorFragment){
                    binding.toolbar.setVisibility(View.GONE);

                }else if( destination.getId()==R.id.confirmarFechaFragment){
                    binding.toolbar.setVisibility(View.GONE);

                }else if( destination.getId()==R.id.registroProfeFragment){
                    binding.toolbar.setVisibility(View.GONE);

                }
                else {
                    binding.toolbar.setVisibility(View.VISIBLE);
                }
            }
        });

    }


}