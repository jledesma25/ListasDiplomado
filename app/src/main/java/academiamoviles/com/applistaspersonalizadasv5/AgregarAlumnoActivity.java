package academiamoviles.com.applistaspersonalizadasv5;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AgregarAlumnoActivity extends AppCompatActivity {

    @InjectView(R.id.edt_nombre)
    EditText edt_nombre;

    @InjectView(R.id.edt_curso)
    EditText edt_curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);
        ButterKnife.inject(this);
        configurarActionBar();
    }
    @OnClick(R.id.btnAgregar)
    public void agregarAlumno(){
        if(edt_nombre.getText().length()!=0 && edt_curso.getText().length()!=0){

            String nombres = edt_nombre.getText().toString();
            String curso = edt_curso.getText().toString();

            Intent intent = getIntent();
            intent.putExtra("NOMBRES",nombres);
            intent.putExtra("CURSO",curso);

            setResult(RESULT_OK,intent);
            finish();
        }
        else{
            mostrarMensaje("Completar los campos");
        }
    }

    public void configurarActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Agregar Alumnos");
    }

    public void mostrarMensaje(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }
}
