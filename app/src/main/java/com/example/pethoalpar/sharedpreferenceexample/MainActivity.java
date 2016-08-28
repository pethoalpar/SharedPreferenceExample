package com.example.pethoalpar.sharedpreferenceexample;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdd;
    private Button buttonRead;
    private EditText editTextValue;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) this.findViewById(R.id.buttonAdd);
        buttonRead = (Button) this.findViewById(R.id.buttonRead);

        editTextValue = (EditText) this.findViewById(R.id.editTextValue);
        textViewResult = (TextView) this.findViewById(R.id.textViewResult);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addValue(editTextValue.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    textViewResult.setText(readSharedPred().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JSONArray readSharedPred() throws JSONException {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedArray = sharedPreferences.getString("example","[]");
        return new JSONArray(savedArray);
    }

    private void addValue(String value) throws JSONException {
        JSONArray jsonArray = this.readSharedPred();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value",value);
        jsonArray.put(jsonObject);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("example",jsonArray.toString());
        editor.commit();
    }
}
