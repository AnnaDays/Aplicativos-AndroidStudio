package com.example.analurestaurante;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtConsumo;
    private EditText edtCouvert;
    private EditText edtDivisao;
    private EditText edtTaxa;
    private EditText edtContaTotal;
    private EditText edtValorPessoa;

    private Button btnContaFinal;
    private Button btnPagarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtDivisao = findViewById(R.id.edtDivisao);
        edtTaxa = findViewById(R.id.edtTaxa);
        edtContaTotal = findViewById(R.id.edtContaTotal);
        edtValorPessoa = findViewById(R.id.edtValorPessoa);

        btnContaFinal = findViewById(R.id.btnContaFinal);
        btnPagarConta = findViewById(R.id.btnPagarConta);
    }

    public void calcularContaFinal(View view) {
        // valor do consumo
        String consumoTexto = edtConsumo.getText().toString();
        Double consumo = Double.parseDouble(consumoTexto);

        // valor do couvert
        Double couvert = Double.parseDouble(edtCouvert.getText().toString());

        // taxa
        Double taxaServico = (consumo * 10) / 100;

        // conta total
        Double valorTotal = (consumo + taxaServico + couvert);

        // mostrar a taxa
        edtTaxa.setText(String.valueOf(taxaServico));

        // mostrar conta total
        edtContaTotal.setText(String.valueOf(valorTotal));

        // calcular valor por pessoa
        Double divisao = Double.parseDouble(edtDivisao.getText().toString());
        Double valorPessoa = valorTotal / divisao;

        // mostrar valor por pessoa
        edtValorPessoa.setText(String.valueOf(valorPessoa));
    }
    public void pagar(View view){
        edtConsumo.setText(null);
        edtCouvert.setText(null);
        edtDivisao.setText(null);
        edtTaxa.setText(null);
        edtValorPessoa.setText(null);
        edtContaTotal.setText(null);

    }
}