package com.pitercapistrano.whatsapplist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pitercapistrano.whatsapplist.R;
import com.pitercapistrano.whatsapplist.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> {

    public AdapterUsuario(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    private List<Usuario> usuarioList = new ArrayList<>();

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        /* Função para inflar o layout com o layout criado, utilizando o parametro parent e como
        não iremos utilizar o attachToRoot, nós passamos ele como false.*/
        itemLista = layoutInflater.inflate(R.layout.usuario_item, parent, false);
        /*Com isso retornamos um novo View Holder passando como parametro o itemLista que é o
        nosso layout*/
        return new UsuarioViewHolder(itemLista);
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.foto.setImageResource(usuarioList.get(position).getFoto());
        holder.nome.setText(usuarioList.get(position).getNome());
        holder.mensagem.setText(usuarioList.get(position).getMensagem());
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView nome;
        private TextView mensagem;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.fotoUsuario);
            nome =  itemView.findViewById(R.id.nomeUsuario);
            mensagem =  itemView.findViewById(R.id.textoUsuario);
        }
    }

}
