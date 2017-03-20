package com.example.luv.placepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends AppCompatActivity {

    int MY_KEY = 1 ;
    TextView TV;
    public void getloc(View view)
    {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder() ;

        Intent intent ;



        try {
            intent = builder.build(this);

            startActivityForResult(intent,MY_KEY);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult( int requestCode , int resultCode , Intent data )
    {
        if( requestCode == MY_KEY )
        {
            if( resultCode==RESULT_OK )
            {
                Place place = PlacePicker.getPlace(data,this);
                String address = String.format("Place : %s",place.getAddress());
                TV.setText(address);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = (TextView)findViewById(R.id.loc);
    }
}
