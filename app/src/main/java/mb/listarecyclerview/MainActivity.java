package mb.listarecyclerview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import mb.listarecyclerview.view.DogListActivity;

public class MainActivity extends AppCompatActivity {

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Tela XMl (Identificar Via Nativo)
        setContentView(R.layout.activity_main);

        //Redirecionamento
        startActivity(new Intent(this, DogListActivity.class));
    }
}
