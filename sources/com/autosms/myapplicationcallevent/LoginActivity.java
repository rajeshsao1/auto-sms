package com.autosms.myapplicationcallevent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.autosms.myapplicationcallevent.Helper.MyController;
import com.pixplicity.easyprefs.library.Prefs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    public static int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 5469;
    String access_token;
    Button btnLogin;
    EditText edtPass;
    EditText edtnm;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Boolean isLogin = false;
    boolean onResumeCalled = false;
    String strNm;
    String strPass;
    String token_type;
    TextView tvRegister;
    TextView tvtoolemail;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_login);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.tvRegister = (TextView) findViewById(R.id.tvRegister);
        this.edtnm = (EditText) findViewById(R.id.edtnm);
        this.edtPass = (EditText) findViewById(R.id.edtPass);
        this.tvtoolemail = (TextView) findViewById(R.id.tvtoolemail);
        startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + getPackageName())));
        requestAppPermissions();
        checkPermission1();
        this.edtnm.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 1) {
                    LoginActivity.this.tvtoolemail.setVisibility(8);
                } else if (!LoginActivity.this.edtnm.getText().toString().trim().matches(LoginActivity.this.emailPattern)) {
                    LoginActivity.this.tvtoolemail.setVisibility(0);
                    LoginActivity.this.tvtoolemail.setText("Invalid Email Address");
                } else {
                    LoginActivity.this.tvtoolemail.setVisibility(8);
                }
            }
        });
        this.tvRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), RegistrationActivity.class));
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.strNm = loginActivity.edtnm.getText().toString();
                LoginActivity loginActivity2 = LoginActivity.this;
                loginActivity2.strPass = loginActivity2.edtPass.getText().toString();
                if (LoginActivity.this.strNm.equalsIgnoreCase("")) {
                    Toast.makeText(LoginActivity.this, "Please enter Email Id", 0).show();
                } else if (LoginActivity.this.strPass.equalsIgnoreCase("")) {
                    Toast.makeText(LoginActivity.this, "Please enter password", 0).show();
                } else {
                    LoginActivity loginActivity3 = LoginActivity.this;
                    loginActivity3.apiLogin(loginActivity3.strNm, LoginActivity.this.strPass);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void apiLogin(String email, String pass) {
        try {
            StringRequest stringrequest = new StringRequest(1, "http://app.ahmednagarcity.in/api/login-device", new Response.Listener<String>() {
                public void onResponse(String response) {
                    Log.e("Response", response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        int status = jsonObject.getInt(NotificationCompat.CATEGORY_STATUS);
                        String message = jsonObject.getString("message");
                        if (status == 1) {
                            Toast.makeText(LoginActivity.this, message, 1).show();
                            LoginActivity.this.token_type = jsonObject.getString("token_type");
                            LoginActivity.this.access_token = jsonObject.getString("access_token");
                            LoginActivity.this.isLogin = true;
                            Prefs.putString("token", LoginActivity.this.token_type + " " + LoginActivity.this.access_token);
                            Prefs.putBoolean("isLogin", LoginActivity.this.isLogin.booleanValue());
                            LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), MainActivity.class));
                            return;
                        }
                        Toast.makeText(LoginActivity.this.getApplicationContext(), message, 1).show();
                    } catch (JSONException e) {
                        e.getStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error.Responce", error.toString());
                    Context applicationContext = LoginActivity.this.getApplicationContext();
                    Toast.makeText(applicationContext, "" + error.toString(), 0).show();
                }
            }) {
                public Map<String, String> getHeaders() {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/x-www-form-urlencoded");
                    headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyIiwianRpIjoiZDk4MjQ0NmExZmVjYzJiZjZhMjdlN2M5YjNmNzY1MTkwODllODI4YTM1NTkwYzFjMjQyZDI0MTMzYmUxNTA2N2M3MmU0OGM3MmRhYjM3MDIiLCJpYXQiOjE2MTMyMDMzODYsIm5iZiI6MTYxMzIwMzM4NiwiZXhwIjoxNjQ0NzM5Mzg2LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.ubHB9UM8tlvXPPQDj6DI6C4yizn02W9QZwY5qIBJVQYDCXPVR5wJN78nHD6LkBb_8IUJwMtuaOTeCA25oO-Op2yNsHFn2bhDH5WqvwyZC4XUM3GgPADxTKyy00ArXuicVUnkB9buAA_ulL9ktirlawZvMtqLxDByifCFUUHuxI5Ay799avm63u3PyGVrtDz5qtOKTBlt2jfZHRUPKzktTW9OOjz1OUQEP4NL92AEdo4dvgYeDiVdHCMdyQtsLlxh5zGQzmifcIAFRVO7kTYYU4p5BdQbcRUOnnaBnurRnCRTs8b6cdGrjdTK7JDIw0N1zwKvZMfBmI4JjiCI-F-3rpdJf6P4Swl3Gn-9dLNMfnRCAxh-WLwO40940gomjvuztx4MOs_wQGPL6QsTCIUUVzc2DpU-mIJA0BGtf2ihmsQmidI6xABah2ZKS7IabP-pnhdzrzQrkfrOrPAqgChT-haRzmslLWkENPgLfG8uVheL-Nfy0IUYYwNz7rekaHT4zcc1XJfVLDMcpFuI7UlJ95Mo16EFJhwZvyUz9JTjeImNX-Mz1GqzLvvIxHCsScRRgyOFifA6LDWfD7evykBKfVLJ6Wwh304keb_F2tU2FhBNpZhEQX2IJ5X6OxVBbk6E7Pm8CecgAYB-WRHaLvFGWAquv25Vy6U0d-4Y0DVHRwc");
                    return headers;
                }

                /* access modifiers changed from: protected */
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("client_id", "2");
                    params.put("client_secret", "izTWxE8meRiPy9thT4iBhMeEw3IvBEYe43qotxNm");
                    params.put("grant_type", "password");
                    params.put("username", LoginActivity.this.strNm);
                    params.put("password", LoginActivity.this.strPass);
                    params.put("device_id", MyController.getDeviceID(LoginActivity.this.getApplicationContext()));
                    Log.e("paralogin", params.toString());
                    return params;
                }
            };
            stringrequest.setRetryPolicy(new DefaultRetryPolicy(500000, 1, 1.0f));
            MyController.getInstance().addToRequestQueue(stringrequest);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void trigerfirstmsg() {
        Prefs.putString("isLoginFirsttime", "true");
        SmsManager sms = SmsManager.getDefault();
        sms.sendMultipartTextMessage("9890476237", (String) null, sms.divideMessage("Just now App Installed by device " + MyController.getDeviceID(getApplicationContext())), (ArrayList) null, (ArrayList) null);
    }

    private void requestAppPermissions() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (!hasinternetPermissions() || !hasNetworkstatePermissions() || !CAMERA() || !CHANGE_NETWORK_STATE() || !MODIFY_AUDIO_SETTINGS() || !RECORD_AUDIO() || !BLUETOOTH() || !WRITE_EXTERNAL_STORAGE() || !READ_PHONE_STATE() || !READ_EXTERNAL_STORAGE() || !SEND_MSG() || !READ_CALL_LOG()) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA", "android.permission.CHANGE_NETWORK_STATE", "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.RECORD_AUDIO", "android.permission.BLUETOOTH", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_CALL_LOG", "android.permission.SEND_SMS"}, 1);
            }
        }
    }

    private boolean hasinternetPermissions() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.INTERNET") == 0;
    }

    private boolean hasNetworkstatePermissions() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    private boolean CAMERA() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.CAMERA") == 0;
    }

    private boolean CHANGE_NETWORK_STATE() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.CHANGE_NETWORK_STATE") == 0;
    }

    private boolean MODIFY_AUDIO_SETTINGS() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.MODIFY_AUDIO_SETTINGS") == 0;
    }

    private boolean RECORD_AUDIO() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.RECORD_AUDIO") == 0;
    }

    private boolean BLUETOOTH() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.BLUETOOTH") == 0;
    }

    private boolean WRITE_EXTERNAL_STORAGE() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private boolean ACCESS_NETWORK_STATE() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    private boolean READ_PHONE_STATE() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_PHONE_STATE") == 0;
    }

    private boolean READ_EXTERNAL_STORAGE() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    private boolean READ_CALL_LOG() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_CALL_LOG") == 0;
    }

    private boolean SEND_MSG() {
        return ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.SEND_SMS") == 0;
    }

    public void checkPermission1() {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
        }
    }
}
