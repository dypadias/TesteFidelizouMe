package br.com.diego.matos.testefidelizoume.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.diego.matos.testefidelizoume.R;
import br.com.diego.matos.testefidelizoume.model.Dados;

public class AdapterDados extends RecyclerView.Adapter<AdapterDados.MyViewHolder> {

    private List<Dados> dadosList;

    public AdapterDados(List<Dados> lista) {
        this.dadosList = lista;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDados.MyViewHolder holder, int position) {


        Dados dados = dadosList.get(position);
        holder.name.setText(dados.getName());
        holder.city.setText(dados.getCity());
        holder.description.setText(dados.getDescription());
        holder.category.setText(dados.getCategory());
        holder.address.setText(dados.getAddress());
        holder.country.setText(dados.getCountry());
        holder.state.setText(dados.getState());
        holder.website.setText(dados.getWebsite());
        holder.ibu.setText(dados.getIbu());
        holder.abv.setText(dados.getAbv());

    }

    @Override
    public int getItemCount() {
        return dadosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView category;
        TextView city;
        TextView description;
        TextView address;
        TextView country;
        TextView state;
        TextView website;
        TextView ibu;
        TextView abv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            category = itemView.findViewById(R.id.textCategory);
            city = itemView.findViewById(R.id.textCity);
            description = itemView.findViewById(R.id.textDescription);
            address = itemView.findViewById(R.id.textAdress);
            country = itemView.findViewById(R.id.textCountry);
            state = itemView.findViewById(R.id.textState);
            website = itemView.findViewById(R.id.textWebsite);
            ibu = itemView.findViewById(R.id.textIbu);
            abv = itemView.findViewById(R.id.textAbv);
        }
    }

}



