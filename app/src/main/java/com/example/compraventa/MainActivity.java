package com.example.compraventa;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Context context;
    EditText title;
    EditText description;
    EditText email;
    EditText price;
    EditText direction;
    Spinner category;
    Switch discount;
    SeekBar discountBar;
    CheckBox inPerson;
    CheckBox terms;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        title= findViewById(R.id.editTextTitle);
        description=findViewById(R.id.editTextDescription);
        email=findViewById(R.id.editEmail);
        price=findViewById(R.id.editTextPrice);
        direction=findViewById(R.id.editInPerson);
        category=findViewById(R.id.spinnerCategory);
        discount=findViewById(R.id.switchDiscount);
        discountBar=findViewById(R.id.sliderDiscount);
        inPerson=findViewById(R.id.checkboxInPerson);
        terms=findViewById(R.id.checkboxTerms);
        button=findViewById(R.id.buttonPublish);
        category.setAdapter(ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se validan los campos y segun el codigo de retorno, se muestra el error o el mensaje de exito
                switch (MainActivity.this.verify()){
                    //exito
                    case -1:
                        Toast.makeText(MainActivity.this,"-1",Toast.LENGTH_SHORT).show();
                        break;
                    //errores
                    case 0:
                        //Campos incompletos:
                        Toast.makeText(MainActivity.this,"0",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //Categoria no seleccionada:
                        Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //Precio invalido:
                        Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //Descuento invalido:
                        Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //email invalido:
                        Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        //Campos con caracteres especiales:
                        Toast.makeText(MainActivity.this,"5",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        //Direccion no completada:
                        Toast.makeText(MainActivity.this,"6",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        //Terminos no aceptados:
                        Toast.makeText(MainActivity.this,"7",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        //error generico:
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Muestra el slider o lo oculta si se activa el switch
        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch discount=findViewById(R.id.switchDiscount);

                if(discount.isChecked()){
                    findViewById(R.id.sliderDiscount).setVisibility(View.VISIBLE);
                }
                else findViewById(R.id.sliderDiscount).setVisibility(View.GONE);
            }
        });
        //Muestra el campo de direccion si se activa el
        inPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inPerson.isChecked()){
                    findViewById(R.id.editInPerson).setVisibility(View.VISIBLE);
                }
                else findViewById(R.id.editInPerson).setVisibility(View.GONE);
            }
        });
    }
    public int verify(){
        //Estan llenos los campos?
        if(!(isFilled(title)&&isFilled(price)))
            return 0;
            //Se selecciono una categoria?
        else if(category.getSelectedItem().toString().equals("Seleccione una categoria"))
            return 1;
            //Se ingreso un precio valido?
        else if(Float.parseFloat(price.getText().toString())<=0)
            return 2;
            //El descuento es mayor a 0 si esta habilitado?
        else if(discount.isChecked()&&(discountBar.getProgress()<=0))
            return 3;
            //El mail es correcto?
        else if(!email.getText().toString().contains("@")||(email.getText().toString().split("@"))[1].length()<=3)
            return 4;
            //No hay caracteres especiales?
        else if (!(noSpecialChars(title)&&(isFilled(description)&&noSpecialChars(description))))
            return 5;
            //Se puso una direccion si se habilito la entrega en persona?
        else if(inPerson.isChecked()&&!isFilled(direction))
            return 6;
            //Se aceptaron los terminos?
        else if(!terms.isChecked())
            return 7;
        //Validacion completeda
        return -1;
    }
    //Funcion para ver si se completo el campo
    public boolean isFilled(EditText text){
        if(text.getText().length()<=0) return false;
        else  return true;
    }
    //Funcion para ver si el campo no tiene caracteres especiales
    public boolean noSpecialChars(EditText text){
        Pattern pattern= Pattern.compile("[a-zA-Z0-9\\s,.]");
        if(pattern.matcher(text.getText().toString()).find()) return true;
        else return false;
    }
}