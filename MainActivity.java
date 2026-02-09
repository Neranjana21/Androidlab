package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button SquareButton, RectangleButton, TriangleButton, CircleButton;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        SquareButton = findViewById(R.id.SquareButton);
        RectangleButton = findViewById(R.id.RectangleButton);
        TriangleButton = findViewById(R.id.TriangleButton);
        CircleButton = findViewById(R.id.CircleButton);

        result = findViewById(R.id.result);

        SquareButton.setOnClickListener(v -> calculate("Square"));
        RectangleButton.setOnClickListener(v -> calculate("Rectangle"));
        TriangleButton.setOnClickListener(v -> calculate("Triangle"));
        CircleButton.setOnClickListener(v -> calculate("Circle"));
    }

    private void calculate(String shape) {
        String input1 = number1.getText().toString().trim();
        String input2 = number2.getText().toString().trim();

        if (input1.isEmpty()) {
            Toast.makeText(this, "Enter value", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = input2.isEmpty() ? 0 : Double.parseDouble(input2);

        double res = 0;

        switch (shape) {
            case "Square":
                res = num1 * num1;
                break;

            case "Rectangle":
                res = num1 * num2;
                break;

            case "Triangle":
                res = 0.5 * num1 * num2;
                break;

            case "Circle":
                res = 3.14 * num1 * num1;
                break;
        }

        result.setText("Area of " + shape + " = " + res);

    }
}
