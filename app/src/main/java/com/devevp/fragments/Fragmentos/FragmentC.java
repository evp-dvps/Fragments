package com.devevp.fragments.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devevp.fragments.MainActivity;
import com.devevp.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentC extends Fragment {

    private EditText ea, eb, ec, pex1;
    private TextView fgx1, fgx2, pm, infofg;
    Button btnfg;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentC.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentC newInstance(String param1, String param2) {
        FragmentC fragment = new FragmentC();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_c, container, false);
        TextView ea=(TextView)vista.findViewById(R.id.ea);
        TextView eb=(TextView)vista.findViewById(R.id.eb);
        TextView ec=(TextView)vista.findViewById(R.id.ec);
        TextView fgx1=(TextView)vista.findViewById(R.id.fgx1);
        TextView fgx2=(TextView)vista.findViewById(R.id.fgx2);
        TextView infofg=(TextView)vista.findViewById(R.id.infofg);
        Button btnfg=(Button)vista.findViewById(R.id.btnfg);

        return vista;
            }

    public void limpiar(){
        fgx1.setText("");
        fgx2.setText("");
        infofg.setText("");
    }

    public void fgral(View view){
        String valor_a = ea.getText().toString();
        String valor_b = eb.getText().toString();
        String valor_c = ec.getText().toString();
        double num_a = Integer.parseInt(valor_a);
        double num_b = Integer.parseInt(valor_b);
        double num_c = Integer.parseInt(valor_c);

        double intr= (num_b * num_b) - (4 * num_a * num_c);
        double raiz= Math.sqrt(intr);

        limpiar();

        if (intr>0){
            double x1= (-num_b + raiz) / 2 * num_a;
            String rx1 = String.valueOf(x1);
            fgx1.setText(rx1);

            double x2= (-num_b - raiz) / 2 * num_a;
            String rx2 = String.valueOf(x2);
            fgx2.setText(rx2);

        }else if (intr==0){
            double x0= -(num_b) / (2 * num_a);
            String rx0 = String.valueOf(x0);
            fgx1.setText(rx0);
            fgx2.setText("");


           infofg.setText("La ecuación tiene una solución");

        }else{

            infofg.setText("La ecuación no tiene solución");
            fgx1.setText("");
            fgx2.setText("");
        }

    }

}




