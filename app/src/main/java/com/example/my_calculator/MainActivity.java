package com.example.my_calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

  public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonClear;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        buttonClear = findViewById(R.id.btn_clear);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.Result);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_clear) {
            editTextN1.setText("");
            editTextN2.setText("");
            textView.setText("");
            Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();

        }

        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        if (id == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (id == R.id.btn_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (id == R.id.btn_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (id == R.id.btn_div) {
            if (num2 == 0) {
                textView.setText("Cannot divide by zero");
                Toast.makeText(this, "Error: Division by zero", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Answer = " + (num1 / num2));
            }
        }
    }
}
