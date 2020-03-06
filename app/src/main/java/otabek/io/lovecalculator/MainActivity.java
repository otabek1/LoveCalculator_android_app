package otabek.io.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name1 = (EditText) findViewById(R.id.name1);
        final EditText name2 = (EditText) findViewById(R.id.name2);
        final int[] i = {0};

        final String[] temp = new String[1];
        final int[] temp_ran = new int[1];

        Button calc_button = (Button) findViewById(R.id.button);
        final TextView percentage = findViewById(R.id.percent);


        calc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name2val = name2.getText().toString();
                final String name1val = name1.getText().toString();

                if ((name1val.equals("Behzod") || name1val.equals("Maftuna") || name1val.equals("Oysha")) && (name2val.equals("Behzod" )|| name2val.equals("Maftuna" )|| name2val.equals("Oysha") )){
                    percentage.setText("0 % ");
                    Toast.makeText(getApplicationContext(), "0 % as You are coward", Toast.LENGTH_LONG ).show();
                    return;
                }

                if ((name1val.length() == 0) && (name2val.length() == 0)) {
                    Toast.makeText(getApplicationContext(), getString(R.string.error_noname), Toast.LENGTH_LONG).show();
                    return;
                }
                Log.d("Calc", "names2:  "+name1val+name2val+ " percentage2 "+temp_ran[0]);

                if ((name1val + name2val).equals(temp[0]) ) {
                    percentage.setText(temp_ran[0] + "%");
                    return;
                }
//                Log.d("Calc", "onClick: " + name1val + name2val);

                Random random_generator = new Random();
                int random_number = random_generator.nextInt(100);
                percentage.setText(random_number + "%");
                temp_ran[0] = random_number;

                temp[0] = name1val + name2val;
                Log.d("Calc", "names1  "+name1val+name2val+ " percent1  "+temp_ran[0]);
            }
        });


    }
}