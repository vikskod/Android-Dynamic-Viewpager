package np.com.vikashparajuli.dynamicviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import np.com.vikashparajuli.dynamicviewpager.adapter.CustomAdapter;
import np.com.vikashparajuli.dynamicviewpager.com.nakama.arraypageradapter.ArrayPagerAdapter;
import np.com.vikashparajuli.dynamicviewpager.pojo.MessageEvent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static boolean setBackgroundGreen = false;
    private ArrayPagerAdapter adapter;
    private int j = 0;
    private EditText remove_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager view_pager = (ViewPager) findViewById(R.id.view_pager);
        remove_edit = (EditText) findViewById(R.id.remove_edit);

        ArrayList<HashMap<String, String>> toAddArray = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("title", "Title " + i);
            toAddArray.add(hashMap);
        }

        CustomAdapter customAdapter = new CustomAdapter(getSupportFragmentManager(), toAddArray);
        view_pager.setAdapter(customAdapter);
        adapter = customAdapter;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_btn:
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("title", "Added " + ++j);
                adapter.add(hashMap);
                break;
            case R.id.remove_btn:
                String s = remove_edit.getText().toString();
                if (!s.equals("")) {
                    int position = Integer.parseInt(s);
                    if (position >= 0 && position < adapter.getCount()) {
                        adapter.remove(position);
                    } else {
                        Toast.makeText(getApplicationContext(), "IndexOutOfBounds:" + position + ",data size is " + adapter.getCount(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Set remove position.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.add_all_btn:
                List<HashMap<String, String>> list = new ArrayList<>();
                for (int i=0; i<3; i++){
                    HashMap<String, String> hashMap1 = new HashMap<>();
                    hashMap1.put("title", "Added " + i);
                    list.add(hashMap1);
                }
                adapter.addAll(list);
                break;
            case R.id.clear_btn:
                adapter.clear();
                break;
            case R.id.btnGreen:
                setBackgroundGreen = true;
                EventBus.getDefault().post(new MessageEvent("green"));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnRemoveColor:
                setBackgroundGreen = false;
                EventBus.getDefault().post(new MessageEvent("fuck"));
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
