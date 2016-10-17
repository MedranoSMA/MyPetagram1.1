package marioargandona.com.petagram6.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import marioargandona.com.petagram6.db.ConstructorMascotas;
import marioargandona.com.petagram6.entidades.Mascota;
import marioargandona.com.petagram6.fragment.IPrincipalFragment;
import marioargandona.com.petagram6.fragment.IRecyclerViewFragmentView;
import marioargandona.com.petagram6.restApi.ConstantesRestApi;
import marioargandona.com.petagram6.restApi.EndpointsApi;
import marioargandona.com.petagram6.restApi.adapter.RestApiAdapter;
import marioargandona.com.petagram6.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrincipalFragmentPresenter implements IPrincipalFragmentPresenter {

    private IPrincipalFragment iPrincipalFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private String usuario = "";


    public PrincipalFragmentPresenter(IPrincipalFragment iPrincipalFragment , Context context)
    {
        this.iPrincipalFragment = iPrincipalFragment;
        this.context = context;
        obtenerMediosRecientes();
    }


    public PrincipalFragmentPresenter(IPrincipalFragment iPrincipalFragment , Context context , boolean flags)
    {
        this.iPrincipalFragment = iPrincipalFragment;
        this.context = context;

        obtenerMediosRecientesUsuario();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasPrincipalFragment();
    }

    @Override
    public void eliminarUsuarioBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        constructorMascotas.eliminarUsuarioInstagram();
    }

    @Override
    public void obtenerUsuarioInstagramBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        usuario = constructorMascotas.obtenerUsuarioInstagram();
        //mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasPrincipalFragment() {

        iPrincipalFragment.crearAdaptador(mascotas);
    }


    @Override
    public void mostrarListaMascotasPrincipalFragment() {
        iPrincipalFragment.inicializarAdaptadorRV(iPrincipalFragment.crearAdaptadorListas(mascotas));
        iPrincipalFragment.generarGridLayout();

        iPrincipalFragment.actualizaPerfil();
    }

    @Override
    public void obtenerMediosRecientes() {
              String usuario = ConstantesRestApi.usuario;

        if(usuario != null)
        {
            RestApiAdapter restApiAdapter = new RestApiAdapter();
            Gson gsonUser = restApiAdapter.construyeGsonDeserializadorUser();
            EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonUser);
            Call<MascotaResponse> mascotaResponseCall = endpointsApi.getUser(usuario);

            mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
                @Override
                public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                    MascotaResponse mascotaResponse = response.body();
                    mascotas = mascotaResponse.getMascotas();
                    mostrarMascotasPrincipalFragment();
                }

                @Override
                public void onFailure(Call<MascotaResponse> call, Throwable t) {
                    Toast.makeText(context, "Falló la conexión con Instagram. Intenta de nuevo.", Toast.LENGTH_LONG).show();
                    Log.e("FALLO EN LA CONEXION" , t.toString());
                }
            });
        }
    }




    @Override
    public void obtenerMediosRecientesUsuario() {
         String id = ConstantesRestApi.idUsuario;

        if(id != null)
        {
            RestApiAdapter restApiAdapter = new RestApiAdapter();
            Gson gsonUser = restApiAdapter.construyeGsonDeserializadorMediaRecent();
            EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonUser);
            Call<MascotaResponse> mascotaResponseCall = endpointsApi.getMediaUser(id);

            mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
                @Override
                public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                    MascotaResponse mascotaResponse = response.body();
                    mascotas = mascotaResponse.getMascotas();
                    mostrarListaMascotasPrincipalFragment();
                }

                @Override
                public void onFailure(Call<MascotaResponse> call, Throwable t) {
                    Toast.makeText(context, "Falló la conexión con Instagram. Intenta de nuevo.", Toast.LENGTH_LONG).show();
                    Log.e("FALLO EN LA CONEXION" , t.toString());
                }
            });
        }
    }


}
