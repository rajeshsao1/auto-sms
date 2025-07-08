package com.autosms.myapplicationcallevent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.autosms.myapplicationcallevent.BlockContact.DatabaseHelper;
import com.autosms.myapplicationcallevent.BlockContact.NoteModel;
import com.autosms.myapplicationcallevent.Helper.MyController;
import com.pixplicity.easyprefs.library.Prefs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PhoneStateReceiver extends BroadcastReceiver {
    ArrayList<NoteModel> arrayList;
    String blockno;
    int cnt = 0;
    DatabaseHelper database_helper;
    Boolean flag = false;
    boolean flagMsgsenfrestricted = false;
    String incomingNumber = "";
    Boolean isSend = false;
    String misscallMsg;
    private DBHelper mydb;
    String outgoingnumber;
    String setting = Prefs.getString("msgSettingOnOff", "");

    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        Context context2 = context;
        Intent intent2 = intent;
        try {
            System.out.println("Receiver start");
            apiGetData(context);
            if (Prefs.getString("activation", "").equalsIgnoreCase("0")) {
                this.misscallMsg = Prefs.getString("msg_MissCall", "");
            } else {
                this.misscallMsg = Prefs.getString("msg_MissCall", "");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dt1 = sdf.format(new Date());
            DBHelper dBHelper = new DBHelper(context2);
            this.mydb = dBHelper;
            dBHelper.deletedata(dt1);
            String state = intent2.getStringExtra("state");
            this.incomingNumber = intent2.getStringExtra("incoming_number");
            this.outgoingnumber = intent2.getStringExtra("android.intent.extra.PHONE_NUMBER");
            this.database_helper = new DatabaseHelper(context2);
            state.equals(TelephonyManager.EXTRA_STATE_RINGING);
            state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK);
            boolean equals = state.equals(TelephonyManager.EXTRA_STATE_IDLE);
            SimpleDateFormat simpleDateFormat = sdf;
            String str5 = state;
            String state2 = "TAG";
            String str6 = "android.intent.extra.PHONE_NUMBER";
            String str7 = "outttttttttttt";
            if (equals) {
                try {
                    getData(this.incomingNumber, dt1);
                    if (this.isSend.booleanValue()) {
                        this.database_helper = new DatabaseHelper(context2);
                        ArrayList<NoteModel> arrayList2 = new ArrayList<>(this.database_helper.getNotes());
                        this.arrayList = arrayList2;
                        if (arrayList2.size() <= 0) {
                            String str8 = state2;
                            if (this.setting.equalsIgnoreCase("true")) {
                                String str9 = this.misscallMsg;
                                if (str9 == null) {
                                    if (str9.equalsIgnoreCase("")) {
                                        str = "true";
                                        str3 = str7;
                                        str2 = str8;
                                    }
                                }
                                SmsManager sms = SmsManager.getDefault();
                                ArrayList<String> parts = sms.divideMessage(this.misscallMsg);
                                if (!this.flagMsgsenfrestricted) {
                                    sms.sendMultipartTextMessage(this.incomingNumber, (String) null, parts, (ArrayList) null, (ArrayList) null);
                                    this.database_helper.addFrequency(this.incomingNumber);
                                    ArrayList<FreqModel> arrayListfreq = new ArrayList<>(this.database_helper.getFreq());
                                    SmsManager smsManager = sms;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("");
                                    str = "true";
                                    sb.append(arrayListfreq.size());
                                    Log.e("freqlen>", sb.toString());
                                    sendwhatsappmsg(this.incomingNumber, this.misscallMsg, context2);
                                    insertData(context2, this.incomingNumber, dt1);
                                    int j = 0;
                                    while (j < arrayListfreq.size()) {
                                        Log.e("freq>", "" + arrayListfreq.get(j).getDt() + ">>>mob>>>" + arrayListfreq.get(j).getMob());
                                        j++;
                                        Context context3 = context;
                                    }
                                    str3 = str7;
                                    str2 = str8;
                                } else {
                                    return;
                                }
                            } else {
                                str = "true";
                                str3 = str7;
                                str2 = str8;
                            }
                        } else if (this.incomingNumber != null) {
                            if (this.setting.equalsIgnoreCase("true")) {
                                int i = 0;
                                while (true) {
                                    if (i >= this.arrayList.size()) {
                                        str4 = state2;
                                        break;
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("");
                                    str4 = state2;
                                    sb2.append(this.arrayList.get(i).getTitle());
                                    Log.e("ArrayVal>>", sb2.toString());
                                    this.blockno = "+91" + this.arrayList.get(i).getTitle();
                                    Log.e("aaa1>>>block", this.blockno + "incomming>>>" + this.incomingNumber);
                                    if (this.blockno.equalsIgnoreCase(this.incomingNumber)) {
                                        Log.e("aaa>>>", this.blockno + "no is bolcked");
                                        this.flag = false;
                                        break;
                                    }
                                    Log.e("aaaelse>>>", this.blockno + "not bolcked");
                                    this.flag = true;
                                    i++;
                                    state2 = str4;
                                }
                            } else {
                                str4 = state2;
                            }
                            if (this.flag.booleanValue()) {
                                String str10 = this.misscallMsg;
                                if (str10 != null || !str10.equalsIgnoreCase("")) {
                                    SmsManager sms2 = SmsManager.getDefault();
                                    ArrayList<String> parts2 = sms2.divideMessage(this.misscallMsg);
                                    if (!this.flagMsgsenfrestricted) {
                                        sms2.sendMultipartTextMessage(this.incomingNumber, (String) null, parts2, (ArrayList) null, (ArrayList) null);
                                        sendwhatsappmsg(this.incomingNumber, this.misscallMsg, context2);
                                        insertData(context2, this.incomingNumber, dt1);
                                    } else {
                                        return;
                                    }
                                }
                                this.flag = false;
                                str = "true";
                                str3 = str7;
                                str2 = str4;
                            } else {
                                str = "true";
                                str3 = str7;
                                str2 = str4;
                            }
                        } else {
                            str = "true";
                            str3 = str7;
                            str2 = state2;
                        }
                    } else {
                        str = "true";
                        str3 = str7;
                        str2 = state2;
                        Log.e(str2, str3);
                    }
                } catch (Exception e) {
                    e = e;
                    Context context4 = context;
                    e.printStackTrace();
                }
            } else {
                str = "true";
                str2 = state2;
                str3 = str7;
            }
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                this.outgoingnumber = intent.getExtras().getString(str6);
                getData(this.incomingNumber, dt1);
                if (this.isSend.booleanValue()) {
                    Log.e(str2, "innnnnnnnnnnnnnnn");
                    if (this.arrayList.size() > 0) {
                        if (this.incomingNumber != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= this.arrayList.size()) {
                                    break;
                                }
                                Log.e("ArrayVal>>", "" + this.arrayList.get(i2).getTitle());
                                this.blockno = "+91" + this.arrayList.get(i2).getTitle();
                                Log.e("aaa1>>>block", this.blockno + "incomming>>>" + this.incomingNumber);
                                if (this.blockno.equalsIgnoreCase(this.incomingNumber)) {
                                    Log.e("aaa>>>", this.blockno + "no is bolcked");
                                    this.flag = false;
                                    break;
                                }
                                Log.e("aaaelse>>>", this.blockno + "not bolcked");
                                this.flag = true;
                                i2++;
                            }
                        }
                        if (!this.flag.booleanValue()) {
                            Context context5 = context;
                        } else if (this.setting.equalsIgnoreCase(str)) {
                            String str11 = this.misscallMsg;
                            if (str11 == null) {
                                if (str11.equalsIgnoreCase("")) {
                                    Context context6 = context;
                                    return;
                                }
                            }
                            SmsManager sms3 = SmsManager.getDefault();
                            ArrayList<String> parts3 = sms3.divideMessage(this.misscallMsg);
                            if (!this.flagMsgsenfrestricted) {
                                sms3.sendMultipartTextMessage(this.incomingNumber, (String) null, parts3, (ArrayList) null, (ArrayList) null);
                                Context context7 = context;
                                try {
                                    sendwhatsappmsg(this.incomingNumber, this.misscallMsg, context7);
                                    insertData(context7, this.incomingNumber, dt1);
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            Context context8 = context;
                        }
                    } else {
                        Context context9 = context;
                        if (this.setting.equalsIgnoreCase(str)) {
                            String str12 = this.misscallMsg;
                            if (str12 != null || !str12.equalsIgnoreCase("")) {
                                SmsManager sms4 = SmsManager.getDefault();
                                ArrayList<String> parts4 = sms4.divideMessage(this.misscallMsg);
                                if (!this.flagMsgsenfrestricted) {
                                    sms4.sendMultipartTextMessage(this.incomingNumber, (String) null, parts4, (ArrayList) null, (ArrayList) null);
                                    sendwhatsappmsg(this.incomingNumber, this.misscallMsg, context9);
                                    insertData(context9, this.incomingNumber, dt1);
                                }
                            }
                        }
                    }
                } else {
                    Context context10 = context;
                    Log.e(str2, str3);
                }
            } else {
                Context context11 = context;
            }
        } catch (Exception e3) {
            e = e3;
            Context context12 = context2;
            e.printStackTrace();
        }
    }

    public void insertData(Context context, String no, String dt) {
        Log.e("Frequency>>", "" + Prefs.getBoolean("isFreqoff", false));
        if (Prefs.getBoolean("isFreqoff", false)) {
            this.mydb.addStudentContact(no, dt);
        }
    }

    public void getData(String no, String dt) {
        Cursor rs1 = this.mydb.getDatawithqry(no, dt);
        if (rs1.moveToFirst()) {
            while (!rs1.isAfterLast()) {
                this.isSend = false;
                String no1 = rs1.getString(rs1.getColumnIndex(DBHelper.CONTACTS_COLUMN_no));
                String dt1 = rs1.getString(rs1.getColumnIndex(DBHelper.CONTACTS_COLUMN_dt));
                Log.e("Data1>>", no1 + "\n" + dt1);
                rs1.moveToNext();
            }
            return;
        }
        this.isSend = true;
        Log.e("Data1>>", "No data..");
    }

    public void sendwhatsappmsg(String strmob, String msg, Context context) {
        if (Prefs.getBoolean("ischecked_whatsapp", false)) {
            Log.e("LOG>>", "Innnnnnnnnnnnnn" + strmob + "  " + msg);
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s&text=%s", new Object[]{strmob, msg})));
            i.setFlags(268435456);
            context.startActivity(i);
        }
    }

    private void apiGetData(Context context) {
        try {
            StringRequest stringrequest = new StringRequest(0, "http://app.ahmednagarcity.in/api/user", new Response.Listener<String>() {
                public void onResponse(String response) {
                    Log.e("Response", response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.length() <= 0) {
                            return;
                        }
                        if (String.valueOf(jsonObject.getString("activated")).equalsIgnoreCase("1")) {
                            Prefs.putString("activation", "1");
                            return;
                        }
                        Prefs.putString("activation", "0");
                        PhoneStateReceiver.this.flagMsgsenfrestricted = true;
                    } catch (JSONException e) {
                        e.getStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error.Responce", error.toString());
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
}
