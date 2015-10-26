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


public class ProcinalFragment extends Fragment {
    ArrayAdapter<String> adaptador;
    ListView listView;
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
        return inflater.inflate(R.layout.fragment_procinal, container, false);
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
