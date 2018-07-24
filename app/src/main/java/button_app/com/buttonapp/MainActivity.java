package button_app.com.buttonapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    // define spinner

    Spinner sp;
    View v;


    //DEFINE TEXT VIEW

    //make string Arrary

    String names[] = {"Red", "Blue", "Green","Pink","Orange","Purple"};

    //defins array adapter of string type

    ArrayAdapter<String> adapter;

    //define string variable for record

    String record = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // define spinner

        sp = (Spinner) findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

         v = (View)findViewById(R.id.view);

        //set adapter to spinner

        sp.setAdapter(adapter);

        //set spinner method

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @SuppressLint("ResourceAsColor")
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        record = "r";
                        v.setBackgroundColor(getResources().getColor(R.color.red));
                        break;
                    case 1:
                        record = "b";
                        v.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                    case 2:
                        record = "g";
                        v.setBackgroundColor(getResources().getColor(R.color.grean));
                        break;
                    case 3:
                        record = "p";
                        v.setBackgroundColor(getResources().getColor(R.color.pink));
                        break;
                    case 4:
                        record = "o";
                        v.setBackgroundColor(getResources().getColor(R.color.orange));
                        break;
                    case 5:
                        record = "pu";
                        v.setBackgroundColor(getResources().getColor(R.color.purple));
                        break;
                }

            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    //set display button click to show result


    public void send(View v) {
        MessageSender messageSender = new MessageSender();
        messageSender.execute(record);

    }


}
