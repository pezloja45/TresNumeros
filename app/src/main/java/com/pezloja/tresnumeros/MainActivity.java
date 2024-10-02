package com.pezloja.tresnumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText txtNumero1, txtNumero2, txtNumero3;
    TextView strResultado1, strResultado2, strResultado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero1 = findViewById(R.id.txtNum1);
        txtNumero2 = findViewById(R.id.txtNum2);
        txtNumero3 = findViewById(R.id.txtNum3);
        strResultado1 = findViewById(R.id.strResultado1);
        strResultado2 = findViewById(R.id.strResultado2);
        strResultado3 = findViewById(R.id.strResultado3);

        Button btnMenor = findViewById(R.id.btnMenor);
        btnMenor.setOnClickListener(v -> hacerCalculo(1));
        Button btnMayor = findViewById(R.id.btnMayor);
        btnMayor.setOnClickListener(v -> hacerCalculo(2));
        Button btnAsc = findViewById(R.id.btnAsc);
        btnAsc.setOnClickListener(v -> hacerCalculo(3));
        Button btnDesc = findViewById(R.id.btnDesc);
        btnDesc.setOnClickListener(v -> hacerCalculo(4));

        Button btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(v -> borrarCampos());
    }

    public void hacerCalculo(int m) {
        int num1, num2, num3;
        try {
            num1 = Integer.parseInt(txtNumero1.getText().toString());
            num2 = Integer.parseInt(txtNumero2.getText().toString());
            num3 = Integer.parseInt(txtNumero3.getText().toString());
        } catch (NumberFormatException e) {
            strResultado2.setText("Entrada no válida");
            return;
        }

        switch (m) {
            case 1: //Menor
                strResultado1.setText("");
                strResultado3.setText("");
                int menor = Math.min(num1, Math.min(num2, num3));
                strResultado2.setText(String.valueOf(menor));
                break;
            case 2: // Mayor
                strResultado1.setText("");
                strResultado3.setText("");
                int mayor = Math.max(num1, Math.max(num2, num3)); // Encontrar el mayor valor
                strResultado2.setText(String.valueOf(mayor));
                break;
            case 3: // Orden ascendente
                int[] numsAsc = {num1, num2, num3};
                Arrays.sort(numsAsc); // Ordenar ascendentemente
                strResultado1.setText(String.valueOf(numsAsc[0]));
                strResultado2.setText(String.valueOf(numsAsc[1]));
                strResultado3.setText(String.valueOf(numsAsc[2]));
                break;
            case 4:
                int[] numDesc = {num1, num2, num3};
                Arrays.sort(numDesc); // Ordenar ascendentemente
                strResultado1.setText(String.valueOf(numDesc[2]));
                strResultado2.setText(String.valueOf(numDesc[1]));
                strResultado3.setText(String.valueOf(numDesc[0]));
                break;
            default:
                strResultado2.setText("Opción no válida");
                return;
        }
    }

    public void borrarCampos() {
        if (txtNumero1 != null) {
            txtNumero1.setText("");
        }
        if (txtNumero2 != null) {
            txtNumero2.setText("");
        }
        if (txtNumero3 != null) {
            txtNumero3.setText("");
        }
        if (strResultado1 != null) {
            strResultado1.setText("");
        }
        if (strResultado2 != null) {
            strResultado2.setText("");
        }
        if (strResultado3 != null) {
            strResultado3.setText("");
        }
    }
}