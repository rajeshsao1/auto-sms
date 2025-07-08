package com.autosms.myapplicationcallevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.autosms.myapplicationcallevent.Helper.MyController;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity {
    EditText add;
    Button btnRegister;
    EditText buis_nm;
    EditText buisnessmob;
    EditText city;
    EditText country;
    EditText edtNm;
    EditText edtemail;
    EditText edtmob;
    EditText edtpass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText state;
    String stradd;
    String strbNm;
    String strbmob;
    String strcity;
    String strcountry;
    String stremail;
    String strmob;
    String strnm;
    String strpass;
    String strstate;
    TextView tvtoolemail;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_registration);
        this.edtNm = (EditText) findViewById(R.id.edtNm);
        this.edtemail = (EditText) findViewById(R.id.edtEmail);
        this.edtmob = (EditText) findViewById(R.id.edtMob);
        this.edtpass = (EditText) findViewById(R.id.edtPass);
        this.buis_nm = (EditText) findViewById(R.id.edtBuisnessnm);
        this.buisnessmob = (EditText) findViewById(R.id.edtbuisnessMob);
        this.add = (EditText) findViewById(R.id.edtAdd);
        this.city = (EditText) findViewById(R.id.edtCity);
        this.country = (EditText) findViewById(R.id.edtCountry);
        this.state = (EditText) findViewById(R.id.edtState);
        this.tvtoolemail = (TextView) findViewById(R.id.tvtoolemail);
        this.btnRegister = (Button) findViewById(R.id.btnRegister);
        this.buis_nm.setText(MyController.getDeviceID(getApplicationContext()));
        this.edtemail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 1) {
                    RegistrationActivity.this.tvtoolemail.setVisibility(8);
                } else if (!RegistrationActivity.this.edtemail.getText().toString().trim().matches(RegistrationActivity.this.emailPattern)) {
                    RegistrationActivity.this.tvtoolemail.setVisibility(0);
                    RegistrationActivity.this.tvtoolemail.setText("Invalid Email Address");
                } else {
                    RegistrationActivity.this.tvtoolemail.setVisibility(8);
                }
            }
        });
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegistrationActivity registrationActivity = RegistrationActivity.this;
                registrationActivity.strnm = registrationActivity.edtNm.getText().toString();
                RegistrationActivity registrationActivity2 = RegistrationActivity.this;
                registrationActivity2.stremail = registrationActivity2.edtemail.getText().toString();
                RegistrationActivity registrationActivity3 = RegistrationActivity.this;
                registrationActivity3.strmob = registrationActivity3.edtmob.getText().toString();
                RegistrationActivity registrationActivity4 = RegistrationActivity.this;
                registrationActivity4.strpass = registrationActivity4.edtpass.getText().toString();
                RegistrationActivity registrationActivity5 = RegistrationActivity.this;
                registrationActivity5.strbNm = registrationActivity5.buis_nm.getText().toString();
                RegistrationActivity registrationActivity6 = RegistrationActivity.this;
                registrationActivity6.strbmob = registrationActivity6.buisnessmob.getText().toString();
                RegistrationActivity.this.stradd = "Resellar code 001";
                RegistrationActivity registrationActivity7 = RegistrationActivity.this;
                registrationActivity7.strcity = registrationActivity7.city.getText().toString();
                RegistrationActivity registrationActivity8 = RegistrationActivity.this;
                registrationActivity8.strstate = registrationActivity8.state.getText().toString();
                RegistrationActivity registrationActivity9 = RegistrationActivity.this;
                registrationActivity9.strcountry = registrationActivity9.country.getText().toString();
                RegistrationActivity registrationActivity10 = RegistrationActivity.this;
                registrationActivity10.tvtoolemail = (TextView) registrationActivity10.findViewById(R.id.tvtoolemail);
                if (RegistrationActivity.this.strnm.equalsIgnoreCase("")) {
                    Toast.makeText(RegistrationActivity.this, "Please enter name", 0).show();
                } else if (RegistrationActivity.this.stremail.equalsIgnoreCase("")) {
                    Toast.makeText(RegistrationActivity.this, "Please enter email id", 0).show();
                } else if (RegistrationActivity.this.strmob.equalsIgnoreCase("")) {
                    Toast.makeText(RegistrationActivity.this, "Please enter mobile no.", 0).show();
                } else if (RegistrationActivity.this.strmob.length() > 10 || RegistrationActivity.this.strmob.length() < 10) {
                    Toast.makeText(RegistrationActivity.this, "Please enter 10 digit mobile no.", 0).show();
                } else if (RegistrationActivity.this.strpass.equalsIgnoreCase("")) {
                    Toast.makeText(RegistrationActivity.this, "Please enter password.", 0).show();
                } else if (RegistrationActivity.this.strbmob.equalsIgnoreCase("")) {
                    Toast.makeText(RegistrationActivity.this, "Please enter business mobile no.", 0).show();
                } else if (RegistrationActivity.this.strbmob.length() > 10 || RegistrationActivity.this.strbmob.length() < 10) {
                    Toast.makeText(RegistrationActivity.this, "Please enter 10 digit mobile no.", 0).show();
                } else if (RegistrationActivity.this.strpass.equalsIgnoreCase("")) {
                    Toast.makeText(RegistrationActivity.this, "Please enter password", 0).show();
                } else {
                    RegistrationActivity.this.apiRegister();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void apiRegister() {
        try {
            StringRequest stringrequest = new StringRequest(1, "http://app.ahmednagarcity.in/api/register-user", new Response.Listener<String>() {
                public void onResponse(String response) {
                    Log.e("Response", response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (String.valueOf(jsonObject.getString(NotificationCompat.CATEGORY_STATUS)).equalsIgnoreCase("1")) {
                            Toast.makeText(RegistrationActivity.this, jsonObject.getString("message"), 0).show();
                            RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this.getApplicationContext(), LoginActivity.class));
                        }
                        if (String.valueOf(jsonObject.getString(NotificationCompat.CATEGORY_STATUS)).equalsIgnoreCase("200")) {
                            Toast.makeText(RegistrationActivity.this.getApplicationContext(), jsonObject.getString("message"), 0).show();
                        } else {
                            Toast.makeText(RegistrationActivity.this.getApplicationContext(), jsonObject.getString("message"), 0).show();
                        }
                    } catch (JSONException e) {
                        e.getStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error.Responce", error.toString());
                    Context applicationContext = RegistrationActivity.this.getApplicationContext();
                    Toast.makeText(applicationContext, "" + error.toString(), 0).show();
                }
            }) {
                public Map<String, String> getHeaders() {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/x-www-form-urlencoded");
                    return headers;
                }

                /* access modifiers changed from: protected */
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", RegistrationActivity.this.strnm);
                    params.put("email", RegistrationActivity.this.stremail);
                    params.put("mobile", RegistrationActivity.this.strmob);
                    params.put("password", RegistrationActivity.this.strpass);
                    params.put("business_name", RegistrationActivity.this.strbNm);
                    params.put("business_mobile", RegistrationActivity.this.strbmob);
                    params.put("address", RegistrationActivity.this.stradd);
                    params.put("city", RegistrationActivity.this.strcity);
                    params.put("state", RegistrationActivity.this.strstate);
                    params.put("country", RegistrationActivity.this.strcountry);
                    Log.e("pararegister", params.toString());
                    return params;
                }
            };
            stringrequest.setRetryPolicy(new DefaultRetryPolicy(500000, 1, 1.0f));
            MyController.getInstance().addToRequestQueue(stringrequest);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
