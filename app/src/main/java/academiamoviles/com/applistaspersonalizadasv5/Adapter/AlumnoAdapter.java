package academiamoviles.com.applistaspersonalizadasv5.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import academiamoviles.com.applistaspersonalizadasv5.MainActivity;
import academiamoviles.com.applistaspersonalizadasv5.Modelo.Alumno;
import academiamoviles.com.applistaspersonalizadasv5.R;
import academiamoviles.com.applistaspersonalizadasv5.View.RecyclerViewOnItemClickListener;

/**
 * Created by jledesma on 24/09/2016.
 */
public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoAdapterViewHolder> {

    Context context;
    int alumno_row;
    ArrayList<Alumno> list_alumno;

    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public AlumnoAdapter(Context mainActivity, int alumno_row, ArrayList<Alumno> list_alumnos) {

        this.context = mainActivity;
        this.alumno_row = alumno_row;
        this.list_alumno = list_alumnos;

    }

    @Override
    public AlumnoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(alumno_row,parent,false);
        return new AlumnoAdapterViewHolder(item);
    }

    @Override
    public void onBindViewHolder(AlumnoAdapterViewHolder holder, int position) {

        Alumno alumno = list_alumno.get(position);

        holder.tv_nombre.setText(alumno.getNombre());
        holder.tv_curso.setText(alumno.getCurso());

    }

    public void addItem(int position, Alumno data){
        list_alumno.add(position,data);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return list_alumno.size();
    }

    public class AlumnoAdapterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView tv_nombre,tv_curso;

        public AlumnoAdapterViewHolder(View itemView) {
            super(itemView);

            tv_nombre = (TextView) itemView.findViewById(R.id.tv_alumno);
            tv_curso = (TextView) itemView.findViewById(R.id.tv_curso);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
