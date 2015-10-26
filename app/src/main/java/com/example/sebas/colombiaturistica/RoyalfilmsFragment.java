package com.example.sebas.colombiaturistica;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class RoyalfilmsFragment extends Fragment {
    ArrayAdapter<String> adaptador;
    ListView listView;
    final private ListEntries[] options =
            new ListEntries[]{
                    new ListEntries(R.drawable.carrefour,"Carrefour de la 65","Calle 47D No. 65 - 115","605 15 87"),
                    new ListEntries(R.drawable.bosque,"C.C. El Bosque","Carrera 52 No. 71 - 52, Carabobo","605 15 87")};


    public RoyalfilmsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_royalfilms, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv=(ListView) getView().findViewById(R.id.royalList);
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