package icj.one.KernelTweaksAOSP;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.TwoStatePreference;

import icj.one.KernelTweaksAOSP.util.CMDProcessor;

public class DeviceSettings extends PreferenceActivity  {

    public static final String KEY_SWEEP2WAKESWITCH = "sweep2wake_switch";
    public static final String KEY_DOUBLETAP2WAKESWITCH = "doubletap2wake_switch";
    public static final String KEY_HOME2WAKESWITCH = "home2wake_switch";
    public static final String KEY_LOGO2MENUSWITCH = "logo2menu_switch";
    public static final String KEY_BLINKBUTTONSSWITCH = "blinkbuttons_switch";

    private TwoStatePreference mSweep2WakeSwitch;
    private TwoStatePreference mDoubleTap2WakeSwitch;
    private TwoStatePreference mHome2WakeSwitch;
    private TwoStatePreference mLogo2MenuSwitch;
    private TwoStatePreference mBlinkButtonsSwitch;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);

        CMDProcessor.runSuCommand("busybox su");
        CMDProcessor.runSuCommand("busybox chmod 0666 /sys/android_touch/sweep2wake");
        CMDProcessor.runSuCommand("busybox chmod 0666 /sys/android_touch/doubletap2wake");
        CMDProcessor.runSuCommand("busybox chmod 0666 /sys/android_touch/home2wake");
        CMDProcessor.runSuCommand("busybox chmod 0666 /sys/android_touch/home2menu");
        CMDProcessor.runSuCommand("busybox chmod 0666 /sys/class/leds/button-backlight/blink_buttons");

        mSweep2WakeSwitch = (TwoStatePreference) findPreference(KEY_SWEEP2WAKESWITCH);
        mSweep2WakeSwitch.setEnabled(Sweep2WakeSwitch.isSupported());
        mSweep2WakeSwitch.setOnPreferenceChangeListener(new Sweep2WakeSwitch());

        mDoubleTap2WakeSwitch = (TwoStatePreference) findPreference(KEY_DOUBLETAP2WAKESWITCH);
        mDoubleTap2WakeSwitch.setEnabled(DoubleTap2WakeSwitch.isSupported());
        mDoubleTap2WakeSwitch.setOnPreferenceChangeListener(new DoubleTap2WakeSwitch());

        mHome2WakeSwitch = (TwoStatePreference) findPreference(KEY_HOME2WAKESWITCH);
        mHome2WakeSwitch.setEnabled(Home2WakeSwitch.isSupported());
        mHome2WakeSwitch.setOnPreferenceChangeListener(new Home2WakeSwitch());

        mLogo2MenuSwitch = (TwoStatePreference) findPreference(KEY_LOGO2MENUSWITCH);
        mLogo2MenuSwitch.setEnabled(Logo2MenuSwitch.isSupported());
        mLogo2MenuSwitch.setOnPreferenceChangeListener(new Logo2MenuSwitch());

        mBlinkButtonsSwitch = (TwoStatePreference) findPreference(KEY_BLINKBUTTONSSWITCH);
        mBlinkButtonsSwitch.setEnabled(BlinkButtonsSwitch.isSupported());
        mBlinkButtonsSwitch.setOnPreferenceChangeListener(new BlinkButtonsSwitch());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }    
}
