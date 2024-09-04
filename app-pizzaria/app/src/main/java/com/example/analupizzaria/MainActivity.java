package com.example.analupizzaria;

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

    private EditText edtPizzaQueijo;
    private EditText edtPizzaFrango;
    private EditText edtPizzaChocolate;
    private EditText edtPizzaRomeu;
    private EditText edtResultado;

    private Button btnFazerPedido;
    private Button btnPagarPedido;

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

        edtPizzaQueijo = findViewById(R.id.edtPizzaQueijo);
        edtPizzaFrango = findViewById(R.id.edtPizzaFrango);
        edtPizzaChocolate = findViewById(R.id.edtPizzaChocolate);
        edtPizzaRomeu = findViewById(R.id.edtPizzaRomeu);
        edtResultado = findViewById(R.id.edtResultado);

        btnFazerPedido = findViewById(R.id.btnFazerPedido);
        btnPagarPedido = findViewById(R.id.btnPagarPedido);
    }

    public void fazerPedido(View view) {
        // Verificar se todos os campos foram preenchidos
        if (edtPizzaQueijo.getText().toString().isEmpty() ||
                edtPizzaFrango.getText().toString().isEmpty() ||
                edtPizzaChocolate.getText().toString().isEmpty() ||
                edtPizzaRomeu.getText().toString().isEmpty()) {

            // Exibir uma mensagem de erro
            if (edtPizzaQueijo.getText().toString().isEmpty()) {
                edtPizzaQueijo.setError("Campo obrigatório");
            }
            if (edtPizzaFrango.getText().toString().isEmpty()) {
                edtPizzaFrango.setError("Campo obrigatório");
            }
            if (edtPizzaChocolate.getText().toString().isEmpty()) {
                edtPizzaChocolate.setError("Campo obrigatório");
            }
            if (edtPizzaRomeu.getText().toString().isEmpty()) {
                edtPizzaRomeu.setError("Campo obrigatório");
            }
            return;
        }

        // calcular e converter o input da pizza de queijo
        String edtQueijo = edtPizzaQueijo.getText().toString();
        int quantidadeQueijo = Integer.parseInt(edtQueijo);

        // calcular e converter o input da pizza de frango
        String edtFrango = edtPizzaFrango.getText().toString();
        int quantidadeFrango = Integer.parseInt(edtFrango);

        // calcular e converter o input da pizza de chocolate
        String edtChocolate = edtPizzaChocolate.getText().toString();
        int quantidadeChocolate = Integer.parseInt(edtChocolate);

        // calcular e converter o input da pizza de romeu e julieta
        String edtRomeu = edtPizzaRomeu.getText().toString();
        int quantidadeRomeu = Integer.parseInt(edtRomeu);

        // cálculo de todos os pedidos
        int precoQueijo = quantidadeQueijo * 30;
        int precoFrango = quantidadeFrango * 30;
        int precoChocolate = quantidadeChocolate * 35;
        int precoRomeu = quantidadeRomeu * 35;

        // cálculo total da compra
        int totalCompra = precoQueijo + precoFrango + precoChocolate + precoRomeu;

        // mostrando no campo
        edtResultado.setText(String.valueOf(totalCompra) + ",00");
    }

    public void pagarPedido(View view) {
        edtPizzaQueijo.setText(null);
        edtPizzaFrango.setText(null);
        edtPizzaChocolate.setText(null);
        edtPizzaRomeu.setText(null);
        edtResultado.setText(null);
    }
}