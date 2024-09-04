package com.example.quizdebandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNomeUsuario;
    Button btnIniciar;

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
        edtNomeUsuario = findViewById(R.id.edtNomeUsuario);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setEnabled(false);

        edtNomeUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnIniciar.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void telaDois(View view) {
        // Capturar o nome do usuário digitado no EditText
        String nomeUsuario = edtNomeUsuario.getText().toString();

        // Passar o nome do usuário para a próxima tela
        Intent it = new Intent(getApplicationContext(), Pergunta.class);
        it.putExtra("NomeUsuario", nomeUsuario);
        startActivity(it);
    }
    @Override
    protected void onResume() {
        //onResume -> limpa a caixinha de texto na hora que vc volta pra tela anterior
        super.onResume();
        edtNomeUsuario.setText(null);
    }
}