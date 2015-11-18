package com.example.sebas.colombiaturistica;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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


public class ProcinalFragment extends Fragment {
    ArrayAdapter<String> adaptador;
    ListView listView;
    static final LatLng ProcinalPos = new LatLng(6.1617553,-75.6073707);
    MapView mMapView;
    private GoogleMap googleMap;
    final private ListEntries[] options =
            new ListEntries[]{
                    new ListEntries(R.drawable.puertanorte,"C.C. Puerta del Norte","Autonorte #34-67, Bello, Antioquia","(4) 3746464"),
                    new ListEntries(R.drawable.monterrey,"C.C. Monterrey","Cl. 14, Medellín, Antioquia","(4) 3746464"),
                    new ListEntries(R.drawable.florida,"C.C Florida","Cl. 71 #65-150, Medellín, Antioquia","(4) 3746464"),
                    new ListEntries(R.drawable.sannicolas,"C.C. San Nicolás","Calle 43 54 - 139, 1669, Antioquia","(4) 3746464")};



    public ProcinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_procinal, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        MarkerOptions marker = new MarkerOptions().position(ProcinalPos).title("Cinemas Procinal");
        // adding marker
        googleMap.addMarker(marker.title("Cinemas Procinal").snippet("C.C. Mayorca"));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(ProcinalPos).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);
        return v;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv=(ListView) getView().findViewById(R.id.procinalList);
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
