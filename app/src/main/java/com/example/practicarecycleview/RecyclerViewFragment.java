package com.example.practicarecycleview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RecyclerViewFragment extends Fragment {
public static final String TAG = "FragmentRecyclerView";
private RecyclerView recyclerView;
private View vista;

public RecyclerViewFragment() {

}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.vista = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        this.recyclerView = vista.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                DividerItemDecoration.VERTICAL
        );
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        Adapter miAdaptador = new Adapter();
        recyclerView.setAdapter(miAdaptador);

        Button botonGuardar = vista.findViewById(R.id.btn_guardar);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comercio comercio = comprobarCampos();
                if(comercio != null){

                }
            }
        });
        return vista;
    }

    // Comprueba que los txt no están vacíos
    public Comercio comprobarCampos(){
        Boolean valido = true;
        EditText eTnombre = this.vista.findViewById(R.id.eT_nombre);
        String nombre = eTnombre.getText().toString().trim();
        EditText eTtelefono = this.vista.findViewById(R.id.eT_telefono);
        String telefono = eTtelefono.getText().toString().trim();
        EditText eTdireccion = this.vista.findViewById(R.id.eT_direccion);
        String direccion = eTdireccion.getText().toString().trim();
        if(nombre.equals("") || telefono.equals("") || direccion.equals(""))
            return new Comercio(nombre,telefono,direccion);
        else
            return null;
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach called");
    }
}