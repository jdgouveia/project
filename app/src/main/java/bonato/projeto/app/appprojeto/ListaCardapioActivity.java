package bonato.projeto.app.appprojeto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaCardapioActivity extends AppCompatActivity {

    public static final String NOME = "bonato.projeto.app.appprojeto.nome";
    ArrayList<String> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapio);
        atividade = this;
        Intent intent = new Intent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscaCardapio(chave);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(atividade, DetalheCardapioActivity.class);
                intent.putExtra(NOME, lista.get(position));

                startActivity(intent);

            }

        });
    }

    public ArrayList<String> buscaCardapio(String chave){
        ArrayList<String> lista = geraListaCardapio();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraListaCardapio(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Batata Frita");
        lista.add("Coca-Cola");
        lista.add("Hamburger");
        lista.add("Arroz");
        lista.add("Feijao");
        lista.add("Macarrao");
        lista.add("Carne");
        lista.add("Frango");
        lista.add("Peixe");
        lista.add("Costela de Porco");
        return lista;
    }
}
