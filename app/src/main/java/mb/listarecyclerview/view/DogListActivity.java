package mb.listarecyclerview.view;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mb.listarecyclerview.R;
import mb.listarecyclerview.model.DogModel;

public class DogListActivity extends AppCompatActivity {
    //Atributos
    private SQLiteDatabase  bd;                                 //Banco Dados SqLite
    private List<DogModel>  listaDogs = new ArrayList<>();      //Lista Conteúdo

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState); setContentView(R.layout.activity_dog_list);
        //Conexão
        bd = openOrCreateDatabase("empresa20", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS clientes (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                ", datcadsql DEFAULT CURRENT_TIMESTAMP NOT NULL, nome VARCHAR)");

        //Manipular
        //salvar();
        buscarTodos();
    }

    //Método - Salvar
    public void salvar() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", "Marcelo");
        bd.insert("clientes", null, contentValues);
    }

    //Método - Buscar Todos
    public void buscarTodos(){
        //Comando
        String consultaSimp1 = "SELECT * FROM clientes";                       //Comando SQL
        Cursor cursor        = bd.rawQuery(consultaSimp1, null);    //Ponteiro
        int    quantReg      = cursor.getCount();                              //Quant Registros

        //Verificar Se Há Conteúdo
        if(quantReg > 0){
            //Posição Colunas
            int idI         = cursor.getColumnIndex("id");
            int nomeI       = cursor.getColumnIndex("nome");
            int dataCadSqlI = cursor.getColumnIndex("datcadsql");

            //Primeiro Registro
            cursor.moveToFirst();

            //Pegar Dados
            while(cursor != null){
                Integer idPego          = cursor.getInt(idI);
                Long    dataCadSqlPega  = cursor.getLong(dataCadSqlI);
                String  nomePego        = cursor.getString(nomeI);

                DogModel dogModel = new DogModel();
                dogModel.setDataCadastro(dataCadSqlPega);
                dogModel.setId(idPego);
                dogModel.setNome(nomePego);

                listaDogs.add(dogModel);

                if(cursor.getPosition() +1 < cursor.getCount()){
                    cursor.moveToNext();
                }else{
                    break;
                }
            }
        }else{ Log.d("myLog", "Banco Dados Vazio!");}

        //Debugar - Lista
        Log.d("myLog", listaDogs.toString());

        //Debugar   Data
        Long dataCadSQL = listaDogs.get(0).getDataCadastro();
        Date date = new Date(dataCadSQL*1000L);
        SimpleDateFormat dataFormatadaSQL = new SimpleDateFormat("dd/MM/yyyy");
        Log.d("myLog Data TimeStamp Automático", dataFormatadaSQL.format(date));

    }
}
