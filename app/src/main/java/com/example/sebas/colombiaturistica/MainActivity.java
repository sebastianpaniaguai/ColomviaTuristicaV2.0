package com.example.sebas.colombiaturistica;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adaptador;
    GridView gridView;
    final private GridEntries[] options =
            new GridEntries[]{
                    new GridEntries(R.drawable.movies,null),
                    new GridEntries(R.drawable.thater,null),
                    new GridEntries(R.drawable.restaurant,null),
                    new GridEntries(R.drawable.party,null),
                    new GridEntries(R.drawable.tourism,null)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adapter adaptador=new Adapter(this, options);
        GridView Options=(GridView) findViewById(R.id.gridview);
        Options.setAdapter(adaptador);
        options[0].setTitle(getResources().getString(R.string.tCinema));
        options[1].setTitle(getResources().getString(R.string.tTheater));
        options[2].setTitle(getResources().getString(R.string.tRestaurants));
        options[3].setTitle(getResources().getString(R.string.tParty));
        options[4].setTitle(getResources().getString(R.string.tTourism));
        Options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, String.valueOf(parent.getItemIdAtPosition(position)), Toast.LENGTH_LONG).show();
                int idActivity=(int)parent.getItemIdAtPosition(position);
                Intent i;
                switch (idActivity){
                    case 0:
                        i = new Intent(MainActivity.this, CinemaActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        i=new Intent(MainActivity.this, TheaterActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(MainActivity.this, RestaurantsActivity.class);
                        startActivity(i);
                        break;
                    case 3:
                        i=new Intent(MainActivity.this, PartyActivity.class);
                        startActivity(i);
                        break;
                    case 4:
                        i=new Intent(MainActivity.this, TourismActivity.class);
                        startActivity(i);
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id==R.id.About){
            Intent i=new Intent(this,About.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class Adapter extends ArrayAdapter<GridEntries>{
        public Adapter(Context context, GridEntries[] entries){
            super(context, R.layout.grid_layout, entries);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.grid_layout, null);

            TextView title = (TextView) item.findViewById(R.id.tTitle);
            title.setText(options[position].getTitle());

            ImageView imagen = (ImageView) item.findViewById(R.id.imView);
            imagen.setImageResource(options[position].getImageId());

            return item;
        }
    }
}
