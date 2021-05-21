package com.devevp.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.devevp.fragments.Fragmentos.FragmentC;
import com.devevp.fragments.Fragmentos.FragmentDefault;
import com.devevp.fragments.Fragmentos.FragmentA;
import com.devevp.fragments.Fragmentos.FragmentB;
import com.devevp.fragments.Interfaces.IComunicaFragments;
import com.devevp.fragments.PeliculasVo.PeliculasVo;
import com.devevp.fragments.R;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener, FragmentB.OnFragmentInteractionListener, IComunicaFragments{
    RecyclerView recyclerview;
    FragmentA listaFragment;
    FragmentB detalleFragmentB;

    public EditText ea, eb, ec;
    public TextView fgx1, fgx2, pm, infofg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaFragment=new FragmentA();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentDefault()).commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public void enviarPeliculas(PeliculasVo peliculas) {
        detalleFragmentB= new FragmentB();

        Bundle bundleEnvio= new Bundle();
        bundleEnvio.putSerializable("objeto",peliculas);
        detalleFragmentB.setArguments(bundleEnvio);

        //cargar fragmente en activity
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, detalleFragmentB).addToBackStack(null).commit();
    }

    public void mostrarFdefaut(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentDefault()).commit();
    }

    public void mostrarFA(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,listaFragment).commit();
    }

    public void mostrarFB(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentB()).commit();
    }

    public void mostrarFC(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentC()).commit();
    }
}



