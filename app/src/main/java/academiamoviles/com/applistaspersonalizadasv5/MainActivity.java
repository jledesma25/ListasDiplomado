package academiamoviles.com.applistaspersonalizadasv5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import academiamoviles.com.applistaspersonalizadasv5.Adapter.AlumnoAdapter;
import academiamoviles.com.applistaspersonalizadasv5.Modelo.Alumno;
import academiamoviles.com.applistaspersonalizadasv5.View.IMainActivity;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    @InjectView(R.id.recycler_alumnos)
    RecyclerView recycler_alumnos;

    ArrayList<Alumno> list_alumnos;
    private AlumnoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void inicializarValores() {

    }

    @Override
    public void setearAdaptador() {
        mAdapter = new AlumnoAdapter(this,R.layout.alumno_row,list_alumnos);
    }

    @Override
    public void mostrarMensaje(String mensaje) {

    }

    @Override
    public void configurarOrientacionLayout() {

    }

    @Override
    public void configurarActionBar() {

    }

    @Override
    public void configurarAnimator() {

    }

    @Override
    public void AgregarAlumnos() {

    }
}
