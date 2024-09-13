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

// Adapter para conectar a lista de usuários com o RecyclerView
public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> {

    // Lista de usuários que será exibida na RecyclerView
    private List<Usuario> usuarioList = new ArrayList<>();

    // Construtor do Adapter que recebe a lista de usuários
    public AdapterUsuario(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;  // Inicializa a lista de usuários com a lista fornecida
    }

    // Cria um novo ViewHolder para um item da lista
    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista;  // Variável para armazenar a visão do item da lista
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());  // Obtém o LayoutInflater para inflar o layout
        // Infla o layout do item da lista (usuario_item.xml) e não o anexa à raiz do layout
        itemLista = layoutInflater.inflate(R.layout.usuario_item, parent, false);
        // Retorna um novo ViewHolder com a visão inflada
        return new UsuarioViewHolder(itemLista);
    }

    // Retorna o número total de itens na lista
    @Override
    public int getItemCount() {
        return usuarioList.size();  // Retorna o tamanho da lista de usuários
    }

    // Vincula os dados ao ViewHolder no item da lista especificado
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        // Define a imagem do usuário no ImageView
        holder.foto.setImageResource(usuarioList.get(position).getFoto());
        // Define o nome do usuário no TextView
        holder.nome.setText(usuarioList.get(position).getNome());
        // Define a mensagem do usuário no TextView
        holder.mensagem.setText(usuarioList.get(position).getMensagem());
    }

    // ViewHolder para armazenar as referências dos Views de um item da lista
    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;  // ImageView para exibir a foto do usuário
        private TextView nome;  // TextView para exibir o nome do usuário
        private TextView mensagem;  // TextView para exibir a mensagem do usuário

        // Construtor do ViewHolder que inicializa os Views
        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializa os Views a partir do layout do item
            foto = itemView.findViewById(R.id.fotoUsuario);
            nome = itemView.findViewById(R.id.nomeUsuario);
            mensagem = itemView.findViewById(R.id.textoUsuario);
        }
    }
}

