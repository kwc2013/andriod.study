package com.example.user.mylocation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GPSListener extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    CalendarContract.Events events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapsInitializer.initialize(getApplicationContext());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MainActivity mact = new MainActivity();

        int listsize = mact.alistlongitude.size();
        for(int i=0; i<listsize; i++) {
            MarkerOptions opt = new MarkerOptions();
            opt.position(mact.alistlocation.get(i));
            opt.title("here you are!"+(i+1));
            mMap.addMarker(opt).showInfoWindow();
            if(i!=0) {
                mMap.addPolyline(new PolylineOptions().geodesic(true).add(new LatLng(Double.valueOf(mact.alistlatitude.get(i - 1)), Double.valueOf(mact.alistlongitude.get(i - 1))), new LatLng(Double.valueOf(mact.alistlatitude.get(i)), Double.valueOf(mact.alistlongitude.get(i)))).width(5).color(Color.RED));
            }
        }

        mMap.moveCamera(newLatLng(mact.alistlocation.get(0)));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getApplicationContext(),marker.getTitle()+"클릭했음",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Date clsTime = new Date();

                Intent clsIntent = new Intent( Intent.ACTION_INSERT );
                clsIntent.setData( events.CONTENT_URI );
                clsIntent.putExtra( CalendarContract.EXTRA_EVENT_BEGIN_TIME, clsTime.getTime( ) );
                clsIntent.putExtra( CalendarContract.EXTRA_EVENT_END_TIME, clsTime.getTime() + 3600000 );
                clsIntent.putExtra( events.TITLE, "일정 제목" );
                clsIntent.putExtra( events.DESCRIPTION, "일정 내용" );

                SimpleDateFormat df = new SimpleDateFormat("MM/dd/hh:mm");
                String tmp = String.valueOf(clsTime.getTime());
                String result = String.format(tmp, df);



                marker.setTitle(""+result+""+clsIntent.getExtras().getString(events.TITLE));

                startActivity( clsIntent );
            }
        });
    }
}