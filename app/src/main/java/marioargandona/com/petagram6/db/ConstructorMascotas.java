package marioargandona.com.petagram6.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import marioargandona.com.petagram6.R;
import marioargandona.com.petagram6.entidades.Mascota;


public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context contexto;

    public ConstructorMascotas(Context contexto)
    {
        this.contexto = contexto;
    }


    public ArrayList<Mascota> obtenerDatos()
    {


        BaseDatos db = new BaseDatos(contexto);
        if(!verificaExistenciaTabla())
        {
            insertar5Mascotas(db);
        }
        return db.obtenerTodasLasMascotas();
    }


    public ArrayList<Mascota> obtenerMascotasFavoritas()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.listaFavoritos();
    }


    public boolean verificaExistenciaTabla()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.validaExistenciaTabla();
    }

    public boolean verificaExistenciaTablaCuenta()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.validaExistenciaTablaCuenta();
    }

    public void insertar5Mascotas(BaseDatos db)
    {

    }



    public void darlikeMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(contexto);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA , mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTA_NUMERO_LIKES , LIKE);
        db.insertarLikeMascota(contentValues);



        ArrayList<Mascota> list = new ArrayList<Mascota>();
        list = db.obtenerTodasLasMascotas();
    }



    public int obtenerLikesMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.obtenerLikesMascota(mascota);
    }


    public void eliminarUsuarioInstagram()
    {
        BaseDatos db = new BaseDatos(contexto);
        db.eliminaUsuarioInstagram();
    }


    public String obtenerUsuarioInstagram()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.obtenerUsuarioInstagram();
    }


    public void insertarUsuarioInstagram(String nombreUsuario)
    {
        BaseDatos db = new BaseDatos(contexto);
        ContentValues contentValuesUsuario = new ContentValues();
        contentValuesUsuario.put(ConstantesBaseDatos.TABLA_CUENTA_USUARIO , nombreUsuario);
        db.insertarUsuarioInstagram(contentValuesUsuario);
    }

}
