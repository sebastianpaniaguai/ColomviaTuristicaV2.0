package com.example.sebas.colombiaturistica;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class CinecolombiaFragment extends Fragment {
    ArrayAdapter<String> adaptador;
    ListView listView;
    final private ListEntries[] options =
            new ListEntries[]{
                    new ListEntries(R.drawable.molinos,"C.C. Los Molinos","Carrera 82 # 30A-24","360 24 63"),
                    new ListEntries(R.drawable.oviedo,"C.C. Oviedo","Cr 43A 6S-15, Av El Poblado","360 24 63"),
                    new ListEntries(R.drawable.unicentro,"C.C Unicentro","Bolivariana 66B #34a - 76, Medellín, Antioquia","360 24 63"),
                    new ListEntries(R.drawable.vizcaya,"C.C. Vizcaya","Calle 10 No. 32 - 115","360 24 63")};

    static final LatLng CineColombiaPos = new LatLng(6.199273,-75.5775189);
    MapView mMapView;
    private GoogleMap googleMap;
    public CinecolombiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_cinecolombia, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        MarkerOptions marker = new MarkerOptions().position(CineColombiaPos).title("C.C. Santa Fé");
        // adding marker
        googleMap.addMarker(marker.title("C.C. Santa Fé").snippet("C.C. Santa Fé"));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(CineColombiaPos).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv=(ListView) getView().findViewById(R.id.cinecolombiaList);
        Adapter adaptador= new Adapter(getActivity(), options);
        lv.setAdapter(adaptador);
    }

    public class Adapter extends ArrayAdapter<ListEntries>{
        public Adapter(Context context, ListEntries[] entries){
            super(context, R.layout.list_layout, entries);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_layout, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(options[position].getNombre());

            TextView dir = (TextView) item.findViewById(R.id.tDireccion);
            dir.setText(options[position].getDireccion());

            TextView reservas = (TextView) item.findViewById(R.id.tReservas);
            reservas.setText(options[position].getReservas());

            ImageView imagen=(ImageView) item.findViewById(R.id.imagenList);
            imagen.setImageResource(options[position].getIdImage());

            return item;
        }
    }
}