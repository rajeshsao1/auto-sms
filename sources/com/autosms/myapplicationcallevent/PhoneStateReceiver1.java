package com.autosms.myapplicationcallevent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pixplicity.easyprefs.library.Prefs;
import java.util.ArrayList;
import java.util.List;

public class PhoneStateReceiver1 extends BroadcastReceiver {
    String incomingNumber = "";
    String misscallMsg = Prefs.getString("msg_MissCall", "");
    String outgoingnumber;
    String setting = Prefs.getString("msgSettingOnOff", "");

    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        Intent intent2 = intent;
        try {
            System.out.println("Receiver start");
            String state = intent2.getStringExtra("state");
            this.incomingNumber = intent2.getStringExtra("incoming_number");
            this.outgoingnumber = intent2.getStringExtra("android.intent.extra.PHONE_NUMBER");
            state.equals(TelephonyManager.EXTRA_STATE_RINGING);
            state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK);
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                Gson gson = new Gson();
                String json = Prefs.getString("array", "");
                Log.e("json", json);
                if (!json.isEmpty()) {
                    for (String data : (List) gson.fromJson(json, new TypeToken<List<String>>() {
                    }.getType())) {
                        String str3 = this.incomingNumber;
                        if (str3 != null && !data.equalsIgnoreCase(str3) && this.setting.equalsIgnoreCase("true") && ((str = this.misscallMsg) != null || !str.equalsIgnoreCase(""))) {
                            SmsManager sms = SmsManager.getDefault();
                            ArrayList<String> parts = sms.divideMessage(this.misscallMsg);
                            sms.sendMultipartTextMessage(this.incomingNumber, (String) null, parts, (ArrayList) null, (ArrayList) null);
                        }
                    }
                } else if (this.setting.equalsIgnoreCase("true") && ((str2 = this.misscallMsg) != null || !str2.equalsIgnoreCase(""))) {
                    SmsManager sms2 = SmsManager.getDefault();
                    SmsManager smsManager = sms2;
                    smsManager.sendMultipartTextMessage(this.incomingNumber, (String) null, sms2.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                }
            }
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                this.outgoingnumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
                Gson gson2 = new Gson();
                String json2 = Prefs.getString("array", "");
                Log.e("json", json2);
                if (!json2.isEmpty()) {
                    for (String data2 : (List) gson2.fromJson(json2, new TypeToken<List<String>>() {
                    }.getType())) {
                        String str4 = this.incomingNumber;
                        if (str4 != null && !data2.equalsIgnoreCase(str4) && this.setting.equalsIgnoreCase("true")) {
                            String str5 = this.misscallMsg;
                            if (str5 != null || !str5.equalsIgnoreCase("")) {
                                SmsManager sms3 = SmsManager.getDefault();
                                SmsManager smsManager2 = sms3;
                                smsManager2.sendMultipartTextMessage(this.incomingNumber, (String) null, sms3.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                            }
                        }
                    }
                } else if (this.setting.equalsIgnoreCase("true")) {
                    String str6 = this.misscallMsg;
                    if (str6 != null || !str6.equalsIgnoreCase("")) {
                        SmsManager sms4 = SmsManager.getDefault();
                        SmsManager smsManager3 = sms4;
                        smsManager3.sendMultipartTextMessage(this.incomingNumber, (String) null, sms4.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
