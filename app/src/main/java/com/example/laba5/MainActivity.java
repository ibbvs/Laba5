package com.example.laba5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "TextSaverPrefs";
    private static final String TEXT_KEY = "savedText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Загружаем текст при запуске приложения
        loadText();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Сохраняем текст при выходе из приложения
        saveText();
    }

    private void saveText() {
        String text = editText.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT_KEY, text);
        editor.apply();
        Toast.makeText(this, "Текст сохранен автоматически", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        String text = sharedPreferences.getString(TEXT_KEY, "");
        editText.setText(text);
        Toast.makeText(this, "Текст загружен", Toast.LENGTH_SHORT).show();
    }
}
