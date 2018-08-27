package hbacak07.example.com.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////////////////////////////////////////////////////////
        toolbar = getSupportActionBar();

        toolbar.setTitle("Shop");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_shop:
                        toolbar.setTitle("Shop");
                        fragment=new Fragment_Anasayfa();
                        Fragment_load(fragment);
                        return true;
                    case R.id.navigation_gifts:
                        toolbar.setTitle("My Gifts");
                        fragment=new Fragment_Gift();
                        Fragment_load(fragment);
                        return true;
                    case R.id.navigation_cart:
                        toolbar.setTitle("Cart");
                        fragment=new Fragment_Cards();
                        Fragment_load(fragment);
                        return true;
                    case R.id.navigation_profile:
                        toolbar.setTitle("Profile");
                        fragment=new Fragment_Profile();
                        Fragment_load(fragment);
                        return true;
                }
                return false;
            }
        });
        ///////////////////////////////////////////////////////////
        Fragment_load(new Fragment_Anasayfa());
        ///////////////////////////////////////////////////////////
    }
    private void Fragment_load(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
