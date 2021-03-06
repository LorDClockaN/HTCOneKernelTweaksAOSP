package icj.one.KernelTweaksAOSP;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Startup extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent bootintent) {
        Sweep2WakeSwitch.restore(context);
        DoubleTap2WakeSwitch.restore(context);
        Home2WakeSwitch.restore(context);
        Logo2MenuSwitch.restore(context);
        BlinkButtonsSwitch.restore(context);
    }
}
