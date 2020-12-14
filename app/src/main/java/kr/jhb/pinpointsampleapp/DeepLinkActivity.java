package kr.jhb.pinpointsampleapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class DeepLinkActivity extends Activity {

    private static String TAG = "DeepLinkActivity";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getAction() == Intent.ACTION_VIEW) {
            Uri data = getIntent().getData();

            if (data != null) {
                Log.v(TAG,data.toString());
                // show an alert with the "title" param
                // deeplink example: pinpoint://deeplink?title=foo
                new AlertDialog.Builder(this)
                        .setTitle("An example of a Deeplink")
                        //.setMessage("Found title param: " +data.getQueryParameter("title"))
                        .setMessage("Deeplink Content: " +data.toString())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }
    }
}
