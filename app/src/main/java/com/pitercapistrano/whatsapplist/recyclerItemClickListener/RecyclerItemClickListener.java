package com.pitercapistrano.whatsapplist.recyclerItemClickListener;

import android.content.Context;  // Importa a classe Context, usada para acessar recursos do sistema
import android.view.GestureDetector;  // Importa GestureDetector para detectar gestos de toque
import android.view.MotionEvent;  // Importa MotionEvent para lidar com eventos de toque
import android.view.View;  // Importa a classe View para interagir com elementos da interface
import android.widget.AdapterView;  // Importa AdapterView para lidar com eventos de clique em itens de lista

import androidx.annotation.NonNull;  // Importa a anotação NonNull para indicar que um parâmetro não pode ser nulo
import androidx.recyclerview.widget.RecyclerView;  // Importa RecyclerView para trabalhar com listas de rolagem eficiente

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;  // Declara o listener para eventos de clique
    GestureDetector mGestureDetector;  // Declara o detector de gestos

    // Construtor padrão
    public RecyclerItemClickListener() {

    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        // Intercepta eventos de toque para identificar se um item foi clicado
        View childView = rv.findChildViewUnder(e.getX(), e.getY());  // Encontra a view filha sob o ponto de toque
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            // Se a view não for nula e o gesto é reconhecido, chama o método de clique no item
            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
            return true;  // Evento tratado
        }
        return false;  // Evento não tratado
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        // Não faz nada neste método, pois o toque é tratado no onInterceptTouchEvent
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // Método necessário, mas não faz nada neste caso
    }

    // Interface para os listeners de clique e clique longo em itens
    public interface OnItemClickListener extends AdapterView.OnItemClickListener {
        void onItemClick(View view, int position);  // Método para clique simples no item
        void onLongItemClick(View view, int position);  // Método para clique longo no item
    }

    // Construtor da classe que configura o listener e o detector de gestos
    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;  // Inicializa o listener
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;  // Indica que o gesto de toque simples foi reconhecido
            }

            @Override
            public void onLongPress(MotionEvent e) {
                // Ação para o gesto de toque longo
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());  // Encontra a view filha sob o ponto de toque
                if (child != null && mListener != null) {
                    // Se a view não for nula e o listener não for nulo, chama o método de clique longo
                    mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }
}
