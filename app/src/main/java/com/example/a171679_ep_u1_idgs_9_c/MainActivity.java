package com.example.a171679_ep_u1_idgs_9_c;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Creo las variables globales que almacenaran los datos, esto para poder tomarlos en el metdo sin tener que mandarlos omo parametros
    private EditText et1;
    private EditText et2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Doy valor a las variables globales emparejandolas con los elementos en la vista con los IDs que coincidan
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tvResultado = (TextView)findViewById(R.id.resultado);
    }

    //Creo un metodo publico que realizará la acción al dar clic al boton de calcular IMC
    public void calculaIMC(View view){
        //Se convierten a string los valores en cada variable global
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        //Ese valor en string se convierte a double para poderlo operar
        double  num1 = Double.parseDouble(valor1);
        double  num2 = Double.parseDouble(valor2);
        //Se realiza la operación para el cálculo de IMC masa/(altura)^2
        double IMC = num1/Math.pow(num2, 2);

        //Creo un variable donde se concatenara el resultado con el valor del IMC
        String resultado ="";

        //Inicio una serie de condicionales que iran evaluando el IMC para determinar su categoria
        if(IMC >0 & IMC <=15) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Muy severo bajo peso'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#a81923"));
        }
        else if (IMC >15 & IMC <=16){
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Severo bajo peso'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#ff9f33"));
        }
        else if (IMC >16 & IMC <=18.5) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Bajo peso'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#fcad05"));
        }
        else if (IMC >18.5 & IMC <=25) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Peso normal (peso saludable)'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#32A852"));
        }
        else if (IMC >25 & IMC <=30) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Sobrepeso'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#fcad05"));
        }
        else if (IMC >30 & IMC <=35) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Obeso clase I (moderadamente obeso)'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#ff9f33"));
        }
        else if (IMC >35 & IMC <=40) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Obeso clase II (severamente obeso)'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#f25800"));
        }
        else if (IMC >40) {
            //Se concatena el mensaje con el valor del IMC
            resultado = "Su IMC es de "+String.format("%.2f",IMC)+", su categoría es 'Obeso clase III (obesidad mórbida)'";
            //Se cambia la propiedad del color del texto al TextView del resultado
            tvResultado.setTextColor(Color.parseColor("#a81923"));
        }
        //Se acualiza el texto que se muestra en el TextView de resultado
        tvResultado.setText(resultado);
    }
}