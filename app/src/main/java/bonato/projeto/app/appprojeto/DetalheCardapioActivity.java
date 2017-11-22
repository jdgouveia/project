package bonato.projeto.app.appprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheCardapioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cardapio);
        TextView nome = (TextView)findViewById(R.id.nome_selecionado);
        TextView preco = (TextView)findViewById(R.id.preco_selecionado);
        Intent intent = getIntent();
        nome.setText(intent.getStringExtra(ListaCardapioActivity.NOME));
        preco.setText("R$ 10,00");
    }
}
