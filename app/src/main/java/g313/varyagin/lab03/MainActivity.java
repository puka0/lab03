package g313.varyagin.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner fromUnit, toUnit;
    EditText fromValue;
    TextView toValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromUnit = findViewById(R.id.FromUnit);
        fromValue = findViewById(R.id.FromValue);
        toUnit = findViewById(R.id.ToUnit);
        toValue = findViewById(R.id.ToValue);

        ArrayAdapter<Units> units = new ArrayAdapter<Units>(this, android.R.layout.simple_list_item_1);
        units.add(new Units("мм.", 0.001));
        units.add(new Units("см.", 0.01));
        units.add(new Units("дм.", 0.1));
        units.add(new Units("м.", 1));
        units.add(new Units("км.", 1000));

        fromUnit.setAdapter(units);
        toUnit.setAdapter(units);
    }


    @SuppressLint("DefaultLocale")
    public void on_convert(View v){
        Units ObjUnitFrom = (Units) fromUnit.getSelectedItem();
        Units ObjUnitTo = (Units) toUnit.getSelectedItem();

//        if(stringUnitFrom.equals("мм.")) to = from / 1000;
//        if(stringUnitFrom.equals("см.")) to = from / 100;/home/user/g313_mezin/lab03
//        if(stringUnitFrom.equals("дм.")) to = from / 10;
//        if(stringUnitFrom.equals("м.")) to = from;
//        if(stringUnitFrom.equals("км.")) to = from * 1000;
//
//        if(stringUnitTo.equals("мм.")) to = to * 1000;
//        if(stringUnitTo.equals("см.")) to = to * 100;
//        if(stringUnitTo.equals("дм.")) to = to * 10;
//        // if(stringUnitTo.equals("м."));
//        if(stringUnitTo.equals("км.")) to = to / 1000;

        try {
            double from = Double.parseDouble(fromValue.getText().toString());
            double to = from * ObjUnitFrom.coeff / ObjUnitTo.coeff;
            toValue.setText(String.format("%.10f", to).replaceAll("0*$", "").replaceAll("\\.$", ""));
        } catch (Exception err) {
            Toast.makeText(this, "Error: Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
}