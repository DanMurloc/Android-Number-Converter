package com.example.numberconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.mynumber);
        TextView textView = findViewById(R.id.yournumber);
        RadioButton rb2 = findViewById(R.id.hdt);
        boolean check = rb2.isChecked();
        //подписка на события
        CustomTextWatcher customTextWatcher = new CustomTextWatcher(editText);
        editText.addTextChangedListener(customTextWatcher);

        // Если найден нецифровой символ, выводим сообщение или выполняем другое действие
        //Toast.makeText(getApplicationContext(), "Введите только цифры", Toast.LENGTH_SHORT).show();
    }
    public void onClickButton(View view){
        try {
            Button button = (Button) view;
            RadioButton rb = findViewById(R.id.dth);
            RadioButton rb2 = findViewById(R.id.hdt);
            RadioButton rb3 = findViewById(R.id.dtb);
            RadioButton rb4 = findViewById(R.id.btd);
            EditText editText = findViewById(R.id.mynumber);
            TextView textView = findViewById(R.id.yournumber);
            if (rb.isChecked()==true){
                Integer con = Integer.valueOf(editText.getText().toString());
                String FF = Convertor.DecToHex(con);
                textView.setText(FF);
                // Toast.makeText(getApplicationContext(), "dth", Toast.LENGTH_SHORT).show();
            }
            else if (rb2.isChecked()==true){
                String con = editText.getText().toString().toUpperCase();
                String FF = Convertor.BinToDec(con);
                textView.setText(FF);
                //Toast.makeText(getApplicationContext(), "hdt", Toast.LENGTH_SHORT).show();
            }
            else if (rb3.isChecked()==true){
                Integer con = Integer.valueOf(editText.getText().toString());
                String FF = Convertor.DecToBin(con);
                textView.setText(FF);
                //Toast.makeText(getApplicationContext(), "dth", Toast.LENGTH_SHORT).show();
            }
            else if (rb4.isChecked()==true){
                String con = editText.getText().toString().toUpperCase();
                String FF = Convertor.BinToDec(con);
                textView.setText(FF);
                //Toast.makeText(getApplicationContext(), "hdt", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception exception){
            Toast.makeText(getApplicationContext(), "Проверьте правильность написания", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClicRadioHTD(View view){
        RadioButton rb2 = findViewById(R.id.hdt);
        Convertor.param = rb2.isChecked();
    }

    public void onClicRadioDTB(View view){
        RadioButton rb2 = findViewById(R.id.btd);
        Convertor.param = rb2.isChecked();
    }
}