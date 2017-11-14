package com.example.puthirin.library;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class RegisterActivity extends AppCompatActivity {
    private  static final String TAG = "Register";
    String Url = "http://192.168.100.105:8000/user_register";
    ProgressDialog progressDialog;
    private EditText firstname, lastname,tel,email, password;
    private Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        Toast.makeText(RegisterActivity.this, "gg", Toast.LENGTH_SHORT).show();
        firstname = (EditText) findViewById(R.id.firstName);
        lastname = (EditText) findViewById(R.id.lastName);
        tel = (EditText) findViewById(R.id.tel);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        Register = (Button) findViewById(R.id.submit);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

    }

    private void submitForm() {
        registerUser(firstname.getText().toString(),lastname.getText().toString(),tel.getText().toString(),email.getText().toString(), password.getText().toString());
    }

    private void registerUser(final String fname, final String lname, final String tel, final String email, final String pw) {


        progressDialog.setMessage("Adding you");
        showDialog();
        JSONObject params = new JSONObject();
        try {
            params.put("firstname",fname);
            params.put("lastname",lname);
            params.put("tel",tel);
            params.put("email",email);
            params.put("password",pw);
        }catch (JSONException e){

        }

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Toast.makeText(RegisterActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                Intent home = new Intent(getApplicationContext(), LoginActivity.class);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(RegisterActivity.this, volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);



    }

    private void hideDialog() {
        if (!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    private void showDialog() {
        if (!progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
