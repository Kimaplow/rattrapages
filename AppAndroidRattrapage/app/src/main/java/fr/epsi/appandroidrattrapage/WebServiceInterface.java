package fr.epsi.appandroidrattrapage;

import com.google.gson.JsonObject;

import fr.epsi.appandroidrattrapage.entity.Convocation;
import fr.epsi.appandroidrattrapage.entity.Eleve;
import fr.epsi.appandroidrattrapage.entity.Personne;
import fr.epsi.appandroidrattrapage.entity.PostPersonne;
import fr.epsi.appandroidrattrapage.entity.Rattrapage;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceInterface {

    @GET("rattrapages/surveillant/{id}")
    Call<Rattrapage[]> getRattrapages(@Path("id") long id);

    @GET("convocations/rattrapage/{id}/eleves")
    Call<Eleve[]> getEleves(@Path("id") long id);

    @POST("personnes/login")
    Call<Personne> connexion(@Body PostPersonne p);

    @PATCH("convocations/rattrapage/{idRattrapage}/eleve/{idEleve}/present")
    Call<Convocation> setElevePresent(@Path("idRattrapage") long idRattrapage,
                                      @Path("idEleve") long idEleve);

}
