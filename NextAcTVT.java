package main.traveldiaries.com.materialtabs;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.widget.TextView;

public class NextAcTVT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21) {
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition));
        }
        setContentView(R.layout.shared_element);
        TextView tv1 = (TextView) findViewById(R.id.text);
        //TextView tv2 = (TextView) findViewById(R.id.color);
    }
}
