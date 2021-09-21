package br.com.diego.matos.testefidelizoume.api;


import java.util.List;

import br.com.diego.matos.testefidelizoume.model.Dados;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("db.json")
    Call<List<Dados>> recuperaDados();

}
