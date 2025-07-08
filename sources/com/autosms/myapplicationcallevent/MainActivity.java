package com.autosms.myapplicationcallevent;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.autosms.myapplicationcallevent.BlockContact.BlockActivity;
import com.autosms.myapplicationcallevent.Helper.MyController;
import com.pixplicity.easyprefs.library.Prefs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static String str = "";
    Button btnAbout;
    Button btnAboutApp;
    Button btnBlockContact;
    Button btnCallReceive1;
    Button btnDialCall;
    Button btnFrequency;
    Button btnMissCall;
    Button btnlog;
    Button btntSettingonoff;
    TextView id_OnOfStatus;
    TextView id_OnOfStatus_whatsappmsg;
    boolean isCheckedpref;
    /* access modifiers changed from: private */
    public DBHelper mydb;
    Switch sw1;
    Switch switch_whatsappmsg;
    Toolbar toolbar;
    TextView tv1;
    TextView tv2;
    TextView tvLoginnm;
    TextView tv_whtsapponWarning;

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        apiGetData();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.sw1 = (Switch) findViewById(R.id.switch1);
        this.switch_whatsappmsg = (Switch) findViewById(R.id.switch_whatsappmsg);
        this.id_OnOfStatus_whatsappmsg = (TextView) findViewById(R.id.id_OnOfStatus_whatsappmsg);
        this.tv_whtsapponWarning = (TextView) findViewById(R.id.tv_whtsapponWarning);
        this.id_OnOfStatus = (TextView) findViewById(R.id.id_OnOfStatus);
        this.mydb = new DBHelper(this);
        TextView textView = (TextView) findViewById(R.id.tvLoginm);
        this.tvLoginnm = textView;
        textView.setText(str);
        this.sw1.setChecked(Prefs.getBoolean("ischecked", false));
        this.switch_whatsappmsg.setChecked(Prefs.getBoolean("ischecked_whatsapp", false));
        Prefs.putBoolean("isFreqoff", Prefs.getBoolean("ischecked", false));
        Log.e("Frequency>>", "" + Prefs.getBoolean("isFreqoff", false));
        if (Prefs.getBoolean("ischecked", false)) {
            this.id_OnOfStatus.setText("On");
        } else {
            this.id_OnOfStatus.setText("Off");
        }
        if (Prefs.getBoolean("ischecked_whatsapp", false)) {
            this.id_OnOfStatus_whatsappmsg.setText("On");
        } else {
            this.id_OnOfStatus_whatsappmsg.setText("Off");
        }
        this.sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", "" + isChecked);
                if (isChecked) {
                    MainActivity.this.mydb.deletetbl();
                } else {
                    MainActivity.this.mydb.deletetbl();
                }
                Prefs.putBoolean("ischecked", isChecked);
                Prefs.putBoolean("isFreqoff", isChecked);
                Log.e("Frequency>>", "" + Prefs.getBoolean("isFreqoff", false));
                if (Prefs.getBoolean("ischecked", false)) {
                    MainActivity.this.id_OnOfStatus.setText("On");
                } else {
                    MainActivity.this.id_OnOfStatus.setText("Off");
                }
            }
        });
        this.switch_whatsappmsg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", "" + isChecked);
                Prefs.putBoolean("ischecked_whatsapp", isChecked);
                if (Prefs.getBoolean("ischecked_whatsapp", false)) {
                    MainActivity.this.id_OnOfStatus_whatsappmsg.setText("On");
                } else {
                    MainActivity.this.id_OnOfStatus_whatsappmsg.setText("Off");
                }
            }
        });
        Prefs.putString("msgSettingOnOff", "true");
        System.out.println("In Main");
        requestAppPermissions();
        TextView textView2 = (TextView) findViewById(R.id.tv2);
        this.tv2 = textView2;
        textView2.setText(Html.fromHtml("<a>https://wa.link/paq6kn</a>"));
        this.btnCallReceive1 = (Button) findViewById(R.id.btnCallReceive1);
        this.btnMissCall = (Button) findViewById(R.id.btnMissCall);
        this.btnDialCall = (Button) findViewById(R.id.btnDialCall);
        this.btntSettingonoff = (Button) findViewById(R.id.btntSettingonoff);
        this.btnAbout = (Button) findViewById(R.id.btnAbout);
        this.btnlog = (Button) findViewById(R.id.btnlog);
        this.btnFrequency = (Button) findViewById(R.id.btnFrequency);
        this.btnAboutApp = (Button) findViewById(R.id.btnAboutApp);
        this.btnBlockContact = (Button) findViewById(R.id.btnBlockContact);
        this.btnAboutApp.setVisibility(8);
        this.btnFrequency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Prefs.putString("date", (String) null);
                MainActivity.this.mydb.deletetbl();
                Toast.makeText(MainActivity.this.getApplicationContext(), "Frequency table cleared !!", 0).show();
            }
        });
        this.btnlog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Prefs.putBoolean("isLogin", false);
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        this.btnAboutApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, AboutAppActivity.class));
            }
        });
        this.btnBlockContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), BlockActivity.class));
            }
        });
        this.btnlog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Prefs.putBoolean("isLogin", false);
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        this.btnCallReceive1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, CallEndedmsgActivity.class));
            }
        });
        this.btnMissCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), MisscallmsgActivity.class));
            }
        });
        this.btnDialCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.btntSettingonoff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, MessageSettingonofActivity.class));
            }
        });
        this.btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), AboutusActivity.class));
            }
        });
    }

    public void dia() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Activation");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Your application Service activation is expired !!\nPlease Contact with admin to activate Service..\nThanks");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.dismiss();
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), AboutusActivity.class));
                MainActivity.this.finish();
            }
        });
        alertDialogBuilder.create().show();
    }

    private void apiGetData() {
        try {
            StringRequest stringrequest = new StringRequest(0, "http://app.ahmednagarcity.in/api/user", new Response.Listener<String>() {
                public void onResponse(String response) {
                    Log.e("Response", response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.length() > 0) {
                            MainActivity.str = jsonObject.getString("name");
                            TextView textView = MainActivity.this.tvLoginnm;
                            textView.setText("Welcome " + MainActivity.str);
                            if (String.valueOf(jsonObject.getString("activated")).equalsIgnoreCase("1")) {
                                Prefs.putString("activation", "1");
                            } else {
                                Prefs.putString("activation", "0");
                                MainActivity.this.dia();
                            }
                            return;
                        }
                        Toast.makeText(MainActivity.this.getApplicationContext(), "Error", 0).show();
                    } catch (JSONException e) {
                        e.getStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error.Responce", error.toString());
                    Context applicationContext = MainActivity.this.getApplicationContext();
                    Toast.makeText(applicationContext, "" + error.toString(), 0).show();
                }
            }) {
                public Map<String, String> getHeaders() {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Authorization", Prefs.getString("token", ""));
                    Log.e("main", headers.toString());
                    return headers;
                }
            };
            stringrequest.setRetryPolicy(new DefaultRetryPolicy(500000, 1, 1.0f));
            MyController.getInstance().addToRequestQueue(stringrequest);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
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
}
