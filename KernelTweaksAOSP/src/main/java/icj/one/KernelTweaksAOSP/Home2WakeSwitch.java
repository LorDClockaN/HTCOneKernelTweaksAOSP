package icj.one.KernelTweaksAOSP;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import java.io.File;

public class Home2WakeSwitch implements OnPreferenceChangeListener {

    private static final String FILE = "/sys/android_touch/home2wake";

    public static boolean isSupported() {
        return Utils.fileWritable(FILE);
    }

	public static boolean isEnabled(Context context) {
        boolean enabled = Utils.getFileValueAsBoolean(FILE, true);        
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getBoolean(DeviceSettings.KEY_HOME2WAKESWITCH, enabled);
	}
	
    /**
     * Restore swipe2wake switch setting from SharedPreferences. (Write to kernel.)
     * @param context       The context to read the SharedPreferences from
     */
    public static void restore(Context context) {
        if (!isSupported()) {
            return;
        }

        boolean enabled = isEnabled(context);        
        File blFile = new File(FILE);
        if(enabled) {
            Utils.writeValue(FILE, "1");
        }
        else {
            Utils.writeValue(FILE, "0");
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Boolean enabled = (Boolean) newValue;
        File blFile = new File(FILE);
        if(enabled) {
            Utils.writeValue(FILE, "1");
        }
        else {
            Utils.writeValue(FILE, "0");
        }
        return true;
    }

}
