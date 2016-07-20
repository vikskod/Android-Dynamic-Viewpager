package np.com.vikashparajuli.dynamicviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by viks on 7/14/16.
 */

public class ContentFragment extends Fragment {

    HashMap<String, String> hashData;
    int position;

    public static ContentFragment newInstance(int position, HashMap<String, String> hashMap) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", hashMap);
        bundle.putInt("position", position);
        ContentFragment f = new ContentFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.position = getArguments().getInt("position");
        hashData = (HashMap<String, String>) getArguments().getSerializable("data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tv);
        textView.setText(hashData.get("title") + " At: " + position);

        if(MainActivity.setBackgroundGreen){
            textView.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_green_dark));
        } else textView.setBackgroundColor(getActivity().getResources().getColor(android.R.color.white));

        return rootView;
    }
}
