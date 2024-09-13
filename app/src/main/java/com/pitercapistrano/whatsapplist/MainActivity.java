package com.pitercapistrano.whatsapplist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pitercapistrano.whatsapplist.adapter.AdapterUsuario;
import com.pitercapistrano.whatsapplist.model.Usuario;
import com.pitercapistrano.whatsapplist.recyclerItemClickListener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_usuario;
    private List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recycler_usuario = findViewById(R.id.recycler_usuario);

        //Definindo Layout da lista na vertical
        recycler_usuario.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        // Método para melhorar o desempenho da nossa lista na hora de reciclar
        recycler_usuario.setHasFixedSize(true);
        // Método para criar um adapter da nossa lista
        AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList);
        recycler_usuario.setAdapter(adapterUsuario);

        Usuarios();

        // Evento de click na recyclerView
        recycler_usuario.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recycler_usuario,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Usuario usuario = usuarioList.get(position);

                        Toast.makeText(getApplicationContext(), "Usuário: " + usuario.getNome(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Usuario usuario = usuarioList.get(position);

                        Toast.makeText(getApplicationContext(), "Click longo usuário: " + usuario.getNome(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }
    public void Usuarios(){
        Usuario usuario1 = new Usuario(R.drawable.usuario1, "Piter", "Olá como vai?");
        usuarioList.add(usuario1);

        Usuario usuario2 = new Usuario(R.drawable.usuario2, "Erika", "Olá como vai?");
        usuarioList.add(usuario2);

        Usuario usuario3 = new Usuario(R.drawable.usuario1, "Jorge", "Vou na sua casa amanhã");
        usuarioList.add(usuario3);

        Usuario usuario4 = new Usuario(R.drawable.usuario2, "Carla", "Eu estou bem e você?");
        usuarioList.add(usuario4);

        Usuario usuario5 = new Usuario(R.drawable.usuario1, "Bruno", "Opa");
        usuarioList.add(usuario5);

        Usuario usuario6 = new Usuario(R.drawable.usuario2, "Kelly", "Tudo bem");
        usuarioList.add(usuario6);

        Usuario usuario7 = new Usuario(R.drawable.usuario1, "João", "Fecho");
        usuarioList.add(usuario7);

        Usuario usuario8 = new Usuario(R.drawable.usuario2, "Bia", "Te vejo mais tarde?");
        usuarioList.add(usuario8);

        Usuario usuario9 = new Usuario(R.drawable.usuario1, "Douglas", "Bora");
        usuarioList.add(usuario9);

        Usuario usuario10 = new Usuario(R.drawable.usuario2, "Lays", "Até mais tarde");
        usuarioList.add(usuario10);

        Usuario usuario11 = new Usuario(R.drawable.usuario1, "Fernando", "Ok, tudo bem");
        usuarioList.add(usuario11);

        Usuario usuario12 = new Usuario(R.drawable.usuario2, "Mariana", "Oi");
        usuarioList.add(usuario12);
    }
}