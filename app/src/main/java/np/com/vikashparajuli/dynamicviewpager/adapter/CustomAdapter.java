package np.com.vikashparajuli.dynamicviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;

import np.com.vikashparajuli.dynamicviewpager.ContentFragment;
import np.com.vikashparajuli.dynamicviewpager.com.nakama.arraypageradapter.ArrayFragmentPagerAdapter;

/**
 * Created by viks on 7/14/16.
 */

public class CustomAdapter extends ArrayFragmentPagerAdapter<HashMap<String,String>> {

    public CustomAdapter(FragmentManager fm, ArrayList<HashMap<String,String>> data) {
        super(fm, data);
    }

    @Override
    public Fragment getFragment(HashMap<String, String> data, int position) {
        return ContentFragment.newInstance(position, data);
    }

}