package fr.epsi.appandroidrattrapage;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import fr.epsi.appandroidrattrapage.entity.Eleve;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallApi {

    private static final String baseUrl = "https://10.60.12.29:8080/v1/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final WebServiceInterface webServiceInterface = retrofit.create(WebServiceInterface.class);

    public Call<Rattrapage[]> getRattrapages(long id) {
        return webServiceInterface.getRattrapages(id);
    }

    public Call<Eleve[]> getEleves(long id) {
        return webServiceInterface.getEleves(id);
    }


}