package np.com.vikashparajuli.dynamicviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

import np.com.vikashparajuli.dynamicviewpager.pojo.MessageEvent;

/**
 * Created by viks on 7/14/16.
 */

public class ContentFragment extends Fragment {

    //private Bus bus = EventBus.getInstance();
    private HashMap<String, String> hashData;
    private TextView textView;
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
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.position = getArguments().getInt("position");
        hashData = (HashMap<String, String>) getArguments().getSerializable("data");

    }

    @Subscribe
    public void getMessage(MessageEvent event){
        if (event.message.equals("green")){
            textView.setBackgroundColor(Color.GREEN);
        } else textView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
         textView = (TextView) rootView.findViewById(R.id.tv);
        textView.setText(hashData.get("title") + " At: " + position);

        if(MainActivity.setBackgroundGreen){
            textView.setBackgroundColor(Color.GREEN);
        } else textView.setBackgroundColor(Color.GRAY);

        return rootView;
    }
}
