package np.com.vikashparajuli.dynamicviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

import np.com.vikashparajuli.dynamicviewpager.adapter.CustomAdapter;
import np.com.vikashparajuli.dynamicviewpager.com.nakama.arraypageradapter.ArrayPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static boolean setBackgroundGreen = false;
    private ArrayPagerAdapter adapter;
    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager view_pager = (ViewPager) findViewById(R.id.view_pager);

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
                break;
            case R.id.add_all_btn:
                break;
            case R.id.clear_btn:
                adapter.clear();
                break;
            case R.id.btnGreen:
                setBackgroundGreen = true;
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnRemoveColor:
                setBackgroundGreen = false;
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
