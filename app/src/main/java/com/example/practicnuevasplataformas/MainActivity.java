package com.example.practicnuevasplataformas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        FragmentManager fragmentManager = getSupportFragmentManager();

        Button buttonCreateRed = findViewById(R.id.btnCreateRed);
        Button buttonCreateOrange = findViewById(R.id.btnCreateOrange);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        buttonCreateRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedFragment redFragment = RedFragment.newInstance("", "");
                fragmentTransaction.add(R.id.fragment_conteiner, redFragment);
                fragmentTransaction.commit();
            }
        });

        buttonCreateOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrangeFragment orangeFragment = OrangeFragment.newInstance("","");
                fragmentTransaction.add(R.id.fragment_conteiner, orangeFragment);
                fragmentTransaction.commit();
            }
        });

    }
}