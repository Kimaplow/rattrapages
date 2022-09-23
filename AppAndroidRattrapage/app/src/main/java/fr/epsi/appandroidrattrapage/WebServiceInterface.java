package fr.epsi.appandroidrattrapage;

import fr.epsi.appandroidrattrapage.entity.Eleve;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServiceInterface {

    @GET("rattrapages/surveillant/{id}")
    Call<Rattrapage[]> getRattrapages(@Path("id") long id);

    @GET("rattrapages/{id}/eleves")
    Call<Eleve[]> getEleves(@Path("id") long id);

}