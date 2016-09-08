package np.com.vikashparajuli.dynamicviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;

import np.com.vikashparajuli.dynamicviewpager.ContentFragment;
import np.com.vikashparajuli.dynamicviewpager.nakama.arraypageradapter.ArrayFragmentStatePagerAdapter;

/**
 * Created by Vikash Parajuli on 9/8/16.
 * vikspjl@gmail.com
 */

public class CustomStatePagerAdapter extends ArrayFragmentStatePagerAdapter<HashMap<String, String>> {

    public CustomStatePagerAdapter(FragmentManager fm, ArrayList<HashMap<String, String>> data) {
        super(fm, data);
    }

    @Override
    public Fragment getFragment(HashMap<String, String> item, int position) {
        return ContentFragment.newInstance(position, item);
    }
}
