package com.attentionhub.worder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button acceptButton;

    private String dict = "";
    private final char[] ruAlphabet = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.actMain_inputString_editText);
        acceptButton = (Button) findViewById(R.id.actMain_accept_button);

        // Init process

        readDict();

        // Game process
    }

    private char randomWord(char[] alphabet){

        Random random = new Random();

        return ruAlphabet[random.nextInt(ruAlphabet.length)];
    }

    private void readDict(){
        InputStream inputStream = getResources().openRawResource(R.raw.ru);
        try{
            byte[] buffer = new byte[inputStream.available()];
            while (inputStream.read(buffer) != -1) {
                dict = new String(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchWord(View view) {

        if (dict.contains(userInput.getText().toString())) {
            System.out.println("Текст найден!");
        } else {
            System.out.println("Текст не найден!");
        }
    }

}
