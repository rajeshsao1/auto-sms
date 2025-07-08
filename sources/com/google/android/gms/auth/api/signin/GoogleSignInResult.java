package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    private Status zzUX;
    private GoogleSignInAccount zzXg;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.zzXg = googleSignInAccount;
        this.zzUX = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.zzXg;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public boolean isSuccess() {
        return this.zzUX.isSuccess();
    }
}
