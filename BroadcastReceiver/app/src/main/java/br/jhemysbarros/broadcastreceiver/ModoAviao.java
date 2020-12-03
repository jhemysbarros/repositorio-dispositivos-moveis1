package br.jhemysbarros.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ModoAviao extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getBooleanExtra("state", true)) {
            Toast.makeText(context, "Modo avião ligado!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Modo avião desligado!", Toast.LENGTH_LONG).show();
        }
    }
}
