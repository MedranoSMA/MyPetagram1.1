package marioargandona.com.petagram6.restApi;


public final class ConstantesRestApi {


    public static String usuario;
    public static String idUsuario;
    public static String urlPerfil;
    public static final String VERSION =                    "/v1/";
    public static final String ROOT_URL =                   "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN =               "3077421755.944bbc0.709c2a7ed37d471e8ca8f759d4f227b5";
    public static final String KEY_ACCESS_TOKEN =           "?access_token=";
    public static final String KEY_ACCESS_TOKEN_SEARCH =    "&access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER =  "users/self/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA =       "/media/recent/?access_token=" + ACCESS_TOKEN;
    public static final String KEY_USERS =                  "users/";
    public static final String KEY_GET_USER =               "users/search?q=";
    public static final String URL_GET_RECENT_MEDIA_USER =  KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_USER =               KEY_GET_USER + "luistono56" + KEY_ACCESS_TOKEN_SEARCH + ACCESS_TOKEN;
    public static final String ROOT_URL_PETAGRAM =          "https://polar-caverns-82169.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN =          "token-device/";
    public static final String KEY_POST_REGISTRO_USUARIO =  "registro-usuario/";

}
