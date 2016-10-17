package marioargandona.com.petagram6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import marioargandona.com.petagram6.adapter.MascotaFavoritaAdapter;
import marioargandona.com.petagram6.db.ConstructorMascotas;
import marioargandona.com.petagram6.entidades.Mascota;

public class MascotaFavorita extends AppCompatActivity {

    public ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotasDummy;
    public MascotaFavoritaAdapter adapter;
    public Integer likesRecibidos = 0;
    public TextView tvLikesDummy;
    public TextView tvNombreMascotaDummy;
    public ConstructorMascotas constructorMascotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasDummy = (RecyclerView)findViewById(R.id.rvMascota2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasDummy.setLayoutManager(llm);

        obtenerMascotasBaseDatos();
        iniciaAdapterMascotas();
    }



    private void iniciaListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();

    }


    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(getApplicationContext());
        mascotas = constructorMascotas.obtenerMascotasFavoritas();
    }



    private void iniciaAdapterMascotas()
    {
        adapter = new MascotaFavoritaAdapter(mascotas,this);
        listaMascotasDummy.setAdapter(adapter);
    }


}
