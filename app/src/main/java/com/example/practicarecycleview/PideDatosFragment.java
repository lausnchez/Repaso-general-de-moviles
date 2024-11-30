package com.example.practicarecycleview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PideDatosFragment extends Fragment {
public static final String TAG = "FragmentPideDatos";
private View vista;
    public PideDatosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.vista = inflater.inflate(R.layout.fragment_pide_datos, container, false);
        Button boton = vista.findViewById(R.id.btn_guardar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comercio nuevoComercio = comprobarCampos();
                if(nuevoComercio != null){
                    Comercios.cogerInstancia().agregarComercio(nuevoComercio);
                    Adapter.actualizarListado(Comercios.cogerInstancia().recogerTodosLosComercios());
                    RecyclerViewFragment.miAdaptador.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Comercio agregado con éxito", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //vista.findViewById();
        return vista;
    }

    // Comprueba que los txt no están vacíos
    public Comercio comprobarCampos(){
        EditText eTnombre = this.vista.findViewById(R.id.eT_nombre);
        String nombre = eTnombre.getText().toString().trim();

        EditText eTtelefono = this.vista.findViewById(R.id.eT_telefono);
        String telefono = eTtelefono.getText().toString().trim();

        EditText eTdireccion = this.vista.findViewById(R.id.eT_direccion);
        String direccion = eTdireccion.getText().toString().trim();

        if(nombre.trim().isEmpty() || telefono.trim().isEmpty() || direccion.trim().isEmpty()){
            Toast.makeText(getContext(), "Faltan datos por rellenar", Toast.LENGTH_SHORT).show();
            return null;
        }
        else{
            return new Comercio(nombre,telefono,direccion);
        }
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