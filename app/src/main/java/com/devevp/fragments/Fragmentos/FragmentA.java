package com.devevp.fragments.Fragmentos;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devevp.fragments.Adapter.PeliculasAdapter;
import com.devevp.fragments.Interfaces.IComunicaFragments;
import com.devevp.fragments.PeliculasVo.PeliculasVo;
import com.devevp.fragments.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<PeliculasVo> listaPeliculas;
    RecyclerView recyclerPeliculas;


    Activity activity;
    IComunicaFragments interfaceComunicaFragments;


    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_a, container, false);

        listaPeliculas = new ArrayList<>();

        recyclerPeliculas = (RecyclerView) vista.findViewById(R.id.RecyclerV);
        recyclerPeliculas.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarlista();

        PeliculasAdapter adapter= new PeliculasAdapter(listaPeliculas);
        recyclerPeliculas.setAdapter(adapter);
        // Inflate the layout for this fragment

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Selecciona"+
                        listaPeliculas.get(recyclerPeliculas.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarPeliculas(listaPeliculas.get(recyclerPeliculas.getChildAdapterPosition(view)));
            }
        });
        return vista;
    }

    private void llenarlista() {
        listaPeliculas.add(new PeliculasVo(getString(R.string.ironman1),getString(R.string.ironman1desc),getString(R.string.ironman1descripcion) , R.drawable.ironman1));
        listaPeliculas.add(new PeliculasVo(getString(R.string.hulk),getString(R.string.hulkdesc),getString(R.string.hulkdescripcion) , R.drawable.hulk));
        listaPeliculas.add(new PeliculasVo(getString(R.string.ironman2),getString(R.string.ironman2desc),getString(R.string.ironman2descripcion), R.drawable.ironman2));
        listaPeliculas.add(new PeliculasVo(getString(R.string.thor),getString(R.string.thordesc),getString(R.string.thordescripcion) , R.drawable.thor1));
        listaPeliculas.add(new PeliculasVo(getString(R.string.vengadores1),getString(R.string.vengadores1desc),getString(R.string.vengadores1descripcion) , R.drawable.avengers1));
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity=(Activity)context;
            interfaceComunicaFragments=(IComunicaFragments) this.activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
