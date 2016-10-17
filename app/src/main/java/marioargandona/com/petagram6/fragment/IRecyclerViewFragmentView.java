package marioargandona.com.petagram6.fragment;

import java.util.ArrayList;

import marioargandona.com.petagram6.adapter.MascotaAdapter;
import marioargandona.com.petagram6.entidades.Mascota;


public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdapter adaptador);

}
