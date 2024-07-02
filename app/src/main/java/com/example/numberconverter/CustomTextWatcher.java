package com.example.numberconverter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CustomTextWatcher implements TextWatcher {
    private EditText editText;
    private boolean ff = false;
    public CustomTextWatcher(EditText editText){
        this.editText=editText;

    }
    @Override
    public  void beforeTextChanged(CharSequence s,int start,int count,int after){
        //Этот метод вызывается перед изменением
    }
    @Override
    public  void onTextChanged(CharSequence s,int start,int count,int after){
        // Этот метод вызывается в момент изменения текста

    }
    @Override
    public void afterTextChanged(Editable s) {
        ff = Convertor.param;
        if (ff==false){
            editText.removeTextChangedListener(this); // Отключение слушателя
            int cursorPosition = editText.getSelectionStart();
            if (s.toString().isEmpty()) {
                editText.setText(s.toString());
            } else {
                CheckNumber checking = new CheckNumber(s);
                CharSequence stringYes = checking.RemoteNumber();
                editText.setText(stringYes.toString());
            }
            editText.setSelection(Math.min(cursorPosition, editText.length())); // Восстановление положения курсора
            editText.addTextChangedListener(this); // Включение слушателя
        }

    }

}
