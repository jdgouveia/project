package bonato.projeto.app.appprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    public static final String CHAVE = "bonato.projeto.app.appprojeto.chave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = (EditText)findViewById(R.id.busca_nome_cardapio);
    }

    public void buscarCardapio(View view){
        Intent intent = new Intent(this, ListaCardapioActivity.class);
        String chave = nome.getText().toString();
        intent.putExtra(CHAVE, chave);
        startActivity(intent);
    }
}
