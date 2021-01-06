package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
     private TextInputEditText editAlcool,editGasolina;
     private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool=findViewById(R.id.editalcool);
        editGasolina=findViewById(R.id.editGasolina);
        textResultado=findViewById(R.id.textresultado);
    }
    public void calcularPreco(View view){
        //recuperar valores digitados
        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();
        //validar os campos digitados
        Boolean camposvalidados = validarCampos(precoAlcool,precoGasolina);
        if(camposvalidados){
            //converter string para numeros
            Double valorAlcool=Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool/valorGasolina;
            if(resultado>=0.7){
                textResultado.setText("melho usar gasolina");
            }else{
                textResultado.setText("melhor usar alcool");
            }
        }else{
            textResultado.setText("preencha os preco primeiro");
        }
    }
    public Boolean validarCampos(String pAlcool,String pGasolina){
        Boolean camposValidados = true;

        if(pAlcool==null||pAlcool.equals("")){
            camposValidados =false;

        }else if(pGasolina ==null || pGasolina.equals("")){
            camposValidados = false;

        }else{
            camposValidados=true;
        }
        return camposValidados;
    }
}