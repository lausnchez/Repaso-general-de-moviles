package com.example.practicarecycleview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_home){
                    Toast.makeText(MainActivity.this, "Pulsaste home", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.menu_configuracion){
                    Toast.makeText(MainActivity.this, "Pulsaste config", Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId() == R.id.menu_persona){
                    Toast.makeText(MainActivity.this, "Pulsaste persona", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        replaceFragment(R.id.frameLayout_insertDatos,new PideDatosFragment());
        replaceFragment(R.id.frameLayout_recyclerView, new RecyclerViewFragment());
    }

    public void replaceFragment(int resID, Fragment fragment){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(resID, fragment).commit();
    }


}