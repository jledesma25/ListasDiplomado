package academiamoviles.com.applistaspersonalizadasv5;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import academiamoviles.com.applistaspersonalizadasv5.Adapter.AlumnoAdapter;
import academiamoviles.com.applistaspersonalizadasv5.Modelo.Alumno;
import academiamoviles.com.applistaspersonalizadasv5.View.IMainActivity;
import academiamoviles.com.applistaspersonalizadasv5.View.RecyclerViewOnItemClickListener;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    @InjectView(R.id.recycler_alumnos)
    RecyclerView recycler_alumnos;

    @InjectView(R.id.fabAgregar)
    FloatingActionButton fabAgregar;

    ArrayList<Alumno> list_alumnos;
    private AlumnoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        inicializarValores();
        setearAdaptador();
        configurarOrientacionLayout();
    }

    @Override
    public void inicializarValores() {
        list_alumnos = new ArrayList<>();

        Alumno alumno = new Alumno();
        alumno.setNombre("Ludvic");
        alumno.setCurso("Android");

        list_alumnos.add(alumno);

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Jared");
        alumno2.setCurso("Android");

        list_alumnos.add(alumno2);
    }

    @Override
    public void setearAdaptador() {
        mAdapter = new AlumnoAdapter(this,R.layout.alumno_row,list_alumnos, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        recycler_alumnos.setAdapter(mAdapter);
    }

    @Override
    public void mostrarMensaje(String mensaje) {

    }

    @Override
    public void configurarOrientacionLayout() {
        recycler_alumnos.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void configurarActionBar() {

    }

    @Override
    public void configurarAnimator() {

    }

    @Override
    @OnClick(R.id.fabAgregar)
    public void AgregarAlumnos() {
        Intent intent = new Intent(this,AgregarAlumnoActivity.class);
        //startActivity(intent);

        startActivityForResult(intent,1);  //1 = requestCode
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED){
            Toast.makeText(this,"Operacion cancelada",Toast.LENGTH_SHORT).show();
        }
        else{
            //Agregar el objeto a la lista recyclerview
            String nombre_resultado = data.getExtras().getString("NOMBRES");
            String curso_resultado = data.getExtras().getString("CURSO");

            Alumno alumno = new Alumno();
            alumno.setNombre(nombre_resultado);
            alumno.setCurso(curso_resultado);

            mAdapter.addItem(0,alumno);
        }
    }
}
