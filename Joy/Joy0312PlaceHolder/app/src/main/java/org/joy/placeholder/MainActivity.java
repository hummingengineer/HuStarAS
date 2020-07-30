package org.joy.placeholder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout layout;
    private Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(">onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);

        ///////////////////// method 2 ////////////////////////////
        ImageView bus = findViewById(R.id.bus);
        bus.setOnClickListener(this);

        ImageView bike = findViewById(R.id.bike);
        bike.setOnClickListener(this::onClick);

        ImageView truck = findViewById(R.id.truck);
        truck.setOnClickListener(this::swapView);

        ImageView taxi = findViewById(R.id.taxi);
        taxi.setOnClickListener(this);

        ImageView flight = findViewById(R.id.flight);
        flight.setOnClickListener(this);
    }

    public void swapView(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(layout);
        }
        placeholder.setContentId(v.getId());
    }

    @Override
    public void onClick(View view) {
        swapView(view);
    }
}