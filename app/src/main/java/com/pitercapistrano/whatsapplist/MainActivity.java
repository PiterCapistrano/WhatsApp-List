package com.pitercapistrano.whatsapplist;

import android.os.Bundle;  // Importa a classe necessária para manipular o ciclo de vida da activity
import android.view.View;  // Importa a classe View para interagir com a interface
import android.widget.AdapterView;  // Importa AdapterView para lidar com eventos de clique em itens de lista
import android.widget.Toast;  // Importa Toast para exibir mensagens rápidas na tela

import androidx.activity.EdgeToEdge;  // Importa EdgeToEdge para definir o layout em tela cheia
import androidx.appcompat.app.AppCompatActivity;  // Classe base para activities
import androidx.core.graphics.Insets;  // Usada para manipular as margens das bordas
import androidx.core.view.ViewCompat;  // Classe de compatibilidade para trabalhar com as views
import androidx.core.view.WindowInsetsCompat;  // Usada para manipular margens e preenchimento relacionados a insets de sistema
import androidx.recyclerview.widget.LinearLayoutManager;  // Define o layout da RecyclerView
import androidx.recyclerview.widget.RecyclerView;  // Componente para listas de rolagem eficiente

import com.pitercapistrano.whatsapplist.adapter.AdapterUsuario;  // Importa o adaptador da lista de usuários
import com.pitercapistrano.whatsapplist.model.Usuario;  // Importa a classe model do usuário
import com.pitercapistrano.whatsapplist.recyclerItemClickListener.RecyclerItemClickListener;  // Importa o listener para cliques nos itens da RecyclerView

import java.util.ArrayList;  // Importa ArrayList para manipular listas dinâmicas
import java.util.List;  // Importa List como interface para listas

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_usuario;  // Declara o componente RecyclerView para exibir a lista de usuários
    private List<Usuario> usuarioList = new ArrayList<>();  // Declara uma lista para armazenar os usuários

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Ativa o modo tela cheia, escondendo as barras de navegação
        setContentView(R.layout.activity_main);  // Define o layout da activity
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {  // Aplica insets para ajustes de bordas
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());  // Recupera os insets das barras de sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);  // Aplica o preenchimento (padding) com base nos insets
            return insets;
        });

        recycler_usuario = findViewById(R.id.recycler_usuario);  // Inicializa o componente RecyclerView

        // Configura o layout da RecyclerView como uma lista vertical
        recycler_usuario.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

        // Otimiza o desempenho da RecyclerView, informando que os itens têm tamanho fixo
        recycler_usuario.setHasFixedSize(true);

        // Cria um adaptador para a RecyclerView com base na lista de usuários
        AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList);
        recycler_usuario.setAdapter(adapterUsuario);

        // Chama o método para adicionar usuários à lista
        Usuarios();

        // Configura o listener para capturar cliques nos itens da RecyclerView
        recycler_usuario.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recycler_usuario,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        // Ação ao clicar em um item: Exibe um Toast com o nome do usuário clicado
                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(), "Usuário: " + usuario.getNome(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // Ação ao realizar clique longo em um item: Exibe um Toast com o nome do usuário
                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(), "Click longo usuário: " + usuario.getNome(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Evento não utilizado neste caso, necessário apenas para interface de listener
                    }
                }
        ));
    }

    // Método que preenche a lista de usuários com instâncias da classe `Usuario`
    public void Usuarios() {
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
