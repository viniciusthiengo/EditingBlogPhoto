package br.com.thiengo.editingblogphoto;

import android.app.Application;

import com.adobe.creativesdk.foundation.AdobeCSDKFoundation;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.aviary.android.feather.sdk.IAviaryClientCredentials;

public class MainApplication extends Application implements IAviaryClientCredentials {

    private static final String CREATIVE_SDK_CLIENT_ID = "aa07e7ec9c644234bf084f5359c9e5a5";
    private static final String CREATIVE_SDK_CLIENT_SECRET = "f7a93976-6639-47a8-8472-badde597fd00";

    @Override
    public void onCreate() {
        super.onCreate();

        AdobeCSDKFoundation.initializeCSDKFoundation(
                getApplicationContext(),
                AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS
        );
    }

    @Override
    public String getBillingKey() {
        return "";
    }

    @Override
    public String getClientID() {
        return CREATIVE_SDK_CLIENT_ID;
    }

    @Override
    public String getClientSecret() {
        return CREATIVE_SDK_CLIENT_SECRET;
    }
}
