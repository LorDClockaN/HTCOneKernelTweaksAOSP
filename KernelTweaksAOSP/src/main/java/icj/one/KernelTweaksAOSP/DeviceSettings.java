package icj.one.KernelTweaksAOSP;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.TwoStatePreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

public class DeviceSettings extends PreferenceActivity  {

    public static final String KEY_SWEEP2WAKESWITCH = "sweep2wake_switch";
    public static final String KEY_DOUBLETAP2WAKESWITCH = "doubletap2wake_switch";
    public static final String KEY_HOME2WAKESWITCH = "home2wake_switch";

    private TwoStatePreference mSweep2WakeSwitch;
    private TwoStatePreference mDoubleTap2WakeSwitch;
    private TwoStatePreference mHome2WakeSwitch;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);

        mSweep2WakeSwitch = (TwoStatePreference) findPreference(KEY_SWEEP2WAKESWITCH);
        mSweep2WakeSwitch.setEnabled(Sweep2WakeSwitch.isSupported());
        mSweep2WakeSwitch.setChecked(Sweep2WakeSwitch.isEnabled(this));
        mSweep2WakeSwitch.setOnPreferenceChangeListener(new Sweep2WakeSwitch());

        mDoubleTap2WakeSwitch = (TwoStatePreference) findPreference(KEY_DOUBLETAP2WAKESWITCH);
        mDoubleTap2WakeSwitch.setEnabled(DoubleTap2WakeSwitch.isSupported());
        mDoubleTap2WakeSwitch.setChecked(DoubleTap2WakeSwitch.isEnabled(this));
        mDoubleTap2WakeSwitch.setOnPreferenceChangeListener(new DoubleTap2WakeSwitch());

        mHome2WakeSwitch = (TwoStatePreference) findPreference(KEY_HOME2WAKESWITCH);
        mHome2WakeSwitch.setEnabled(Home2WakeSwitch.isSupported());
        mHome2WakeSwitch.setChecked(Home2WakeSwitch.isEnabled(this));
        mHome2WakeSwitch.setOnPreferenceChangeListener(new Home2WakeSwitch());

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
