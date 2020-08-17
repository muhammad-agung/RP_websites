package sg.edu.rp.c346.id18004536.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner category;
    Spinner subCategory;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category = findViewById(R.id.spinnerCategory);
        subCategory = findViewById(R.id.spinnerSubCategory);
        btnUpdate = findViewById(R.id.buttonUpdate);


        alNumbers = new ArrayList<>();

        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alNumbers);

        subCategory.setAdapter(aaNumbers);


        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alNumbers.clear();
                switch (position) {

                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.RP);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        aaNumbers.notifyDataSetChanged();
                        break;

                    case 1:
                        String[] strNumbers1 = getResources().getStringArray(R.array.SOI);
                        alNumbers.addAll(Arrays.asList(strNumbers1));
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Original
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,BrowseActivity.class);
//
//                String URL = alNumbers.get(subCategory.getSelectedItemPosition());
//                String realURL = "";
//                if(URL.equals("Homepage")){
//                    realURL = "https://www.rp.edu.sg/";
//                }
//                else if(URL.equals("Student Life")){
//                    realURL = "https://www.rp.edu.sg/student-life";
//                }
//                else if(URL.equals("DMSD")){
//                    realURL = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
//                }
//                else if(URL.equals("DIT")){
//                    realURL = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
//                }
//                intent.putExtra("Value",realURL);
//                startActivity(intent);
//            }
//        });

        //2d Array
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,BrowseActivity.class);


                String[][] sites = {
                        {
                                "https://www.rp.edu.sg/",
                                "Homepage",
                        },
                        {
                                "https://www.rp.edu.sg/student-life",
                                "Student Life",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "DMSD",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12",
                                "DIT",
                        },
                };
                String getURL = sites[subCategory.getSelectedItemPosition()][category.getSelectedItemPosition()];
                intent.putExtra("Value",getURL);
                startActivity(intent);
            }
        });
    }

}
