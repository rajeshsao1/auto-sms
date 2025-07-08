package com.autosms.myapplicationcallevent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.autosms.myapplicationcallevent.BlockContact.DatabaseHelper;
import com.autosms.myapplicationcallevent.BlockContact.NoteModel;
import com.pixplicity.easyprefs.library.Prefs;
import java.util.ArrayList;

public class PhoneStateReceiver_blockno extends BroadcastReceiver {
    ArrayList<NoteModel> arrayList;
    String blockno;
    int cnt = 0;
    DatabaseHelper database_helper;
    Boolean flag = false;
    String incomingNumber = "";
    String misscallMsg = Prefs.getString("msg_MissCall", "");
    String outgoingnumber;
    String setting = Prefs.getString("msgSettingOnOff", "");

    public void onReceive(Context context, Intent intent) {
        String str;
        Intent intent2 = intent;
        try {
            System.out.println("Receiver start");
            String state = intent2.getStringExtra("state");
            this.incomingNumber = intent2.getStringExtra("incoming_number");
            this.outgoingnumber = intent2.getStringExtra("android.intent.extra.PHONE_NUMBER");
            state.equals(TelephonyManager.EXTRA_STATE_RINGING);
            state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK);
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                try {
                    this.database_helper = new DatabaseHelper(context);
                    ArrayList<NoteModel> arrayList2 = new ArrayList<>(this.database_helper.getNotes());
                    this.arrayList = arrayList2;
                    if (arrayList2.size() <= 0) {
                        if (this.setting.equalsIgnoreCase("true") && ((str = this.misscallMsg) != null || !str.equalsIgnoreCase(""))) {
                            SmsManager sms = SmsManager.getDefault();
                            sms.sendMultipartTextMessage(this.incomingNumber, (String) null, sms.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                        }
                    } else if (this.incomingNumber != null) {
                        if (this.setting.equalsIgnoreCase("true")) {
                            int i = 0;
                            while (true) {
                                if (i >= this.arrayList.size()) {
                                    break;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                String state2 = state;
                                sb.append(this.arrayList.get(i).getTitle());
                                Log.e("ArrayVal>>", sb.toString());
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
                                state = state2;
                            }
                        }
                        if (this.flag.booleanValue()) {
                            String str2 = this.misscallMsg;
                            if (str2 != null || !str2.equalsIgnoreCase("")) {
                                SmsManager sms2 = SmsManager.getDefault();
                                sms2.sendMultipartTextMessage(this.incomingNumber, (String) null, sms2.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                            }
                            this.flag = false;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } else {
                Context context2 = context;
                String str3 = state;
            }
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                this.outgoingnumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
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
                    if (this.flag.booleanValue() && this.setting.equalsIgnoreCase("true")) {
                        String str4 = this.misscallMsg;
                        if (str4 != null || !str4.equalsIgnoreCase("")) {
                            SmsManager sms3 = SmsManager.getDefault();
                            SmsManager smsManager = sms3;
                            smsManager.sendMultipartTextMessage(this.incomingNumber, (String) null, sms3.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                        }
                    }
                } else if (this.setting.equalsIgnoreCase("true")) {
                    String str5 = this.misscallMsg;
                    if (str5 != null || !str5.equalsIgnoreCase("")) {
                        SmsManager sms4 = SmsManager.getDefault();
                        SmsManager smsManager2 = sms4;
                        smsManager2.sendMultipartTextMessage(this.incomingNumber, (String) null, sms4.divideMessage(this.misscallMsg), (ArrayList) null, (ArrayList) null);
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            Context context3 = context;
            e.printStackTrace();
        }
    }
}
