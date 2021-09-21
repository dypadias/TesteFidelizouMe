package br.com.diego.matos.testefidelizoume.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.diego.matos.testefidelizoume.R;
import br.com.diego.matos.testefidelizoume.adapter.AdapterDados;
import br.com.diego.matos.testefidelizoume.api.DataService;
import br.com.diego.matos.testefidelizoume.model.Dados;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btnRecuperar;
    private Button btnOrdenar;
    private Retrofit retrofit;
    private List<Dados> dadosList = new ArrayList<>();




    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnRecuperar = findViewById(R.id.btnRecuperar);

        /*btnOrdenar = findViewById(R.id.btnOrdenar);*/

        recyclerView = findViewById(R.id.recyclerView);

        //configurar adapter
        AdapterDados adapterDados = new AdapterDados( dadosList );

        //Configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( adapterDados );



        retrofit = new Retrofit.Builder()

                .baseUrl("https://raw.githubusercontent.com/fidelizou-me/frontend-test/5b12fcc409428281b72917249dadc42ad163c158/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       /* btnOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperaOrdenado();
            }
        });*/


       btnRecuperar.setOnClickListener(v -> {
           onStart();

           recuperarListaRetrofit();
         //recuperaCEPRetrofit();
//                /* MyTask task = new MyTask();
//                String urlApi = "https://raw.githubusercontent.com/fidelizou-me/frontend-test/main/db.json";
//                task.execute(urlApi);*/
//
//
       });
//
  }

    private void recuperarListaRetrofit() {

        DataService dataService = retrofit.create(DataService.class);
        Call<List<Dados>> call = dataService.recuperaDados();

        call.enqueue(new Callback<List<Dados>>() {
            @Override
            public void onResponse(Call<List<Dados>> call, Response<List<Dados>> response) {
                if (response.isSuccessful()){
                    dadosList = response.body();


                    AdapterDados adapterDados = new AdapterDados( dadosList );

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager( layoutManager );
                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration( new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                    recyclerView.setAdapter( adapterDados );





                 /*   for (int i=0; i<dadosList.size(); i++){
                        Dados dado = dadosList.get( i );




                      Log.d("resposta","resultado: " +dado.getName()+"/"+dado.getCity());
                    }*/
                }
            }

            @Override
            public void onFailure(Call<List<Dados>> call, Throwable t) {

            }
        });

    }

   /* TODO
    IMPLEMENTAR O METODO DE ORDENAR A LISTA;*/

   /* private void recuperaOrdenado(){





        DataService dataService = retrofit.create(DataService.class);
        Call<List<Dados>> call = dataService.recuperaDados();

        call.enqueue(new Callback<List<Dados>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Dados>> call, Response<List<Dados>> response) {
                if (response.isSuccessful()){
                     dadosList = response.body();




                    AdapterDados adapterDados = new AdapterDados( dadosList );



                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager( layoutManager );
                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration( new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                    recyclerView.setAdapter( adapterDados );

                }
            }

            @Override
            public void onFailure(Call<List<Dados>> call, Throwable t) {

            }
        });

    }*/

    }

























