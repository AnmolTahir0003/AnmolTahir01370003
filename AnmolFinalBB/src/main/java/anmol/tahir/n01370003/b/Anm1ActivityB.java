/* Anmol Tahir n01370003 CENG-258-RNB*/

package anmol.tahir.n01370003.b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class Anm1ActivityB extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        setViewPagerAdapter();
        //adding titles
        titles = new ArrayList<>();
        titles.add("Anmol Tab"); //default
        titles.add("Tahir Tab");
//connect them together
        new TabLayoutMediator(tabLayout, viewPager2, this).attach();

//add the images of the tabs
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_setting);
    }

    // adding them in
    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new
                ViewPager2Adapter(this);
        ArrayList<Fragment> fragmentList = new ArrayList<>(); //create an ArrayList of Fragments
        fragmentList.add(new AnmolTab());
        fragmentList.add(new TahirTab());
        //connecting to view pager to view pager adapter:
        viewPager2Adapter.setData(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);

    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }
}