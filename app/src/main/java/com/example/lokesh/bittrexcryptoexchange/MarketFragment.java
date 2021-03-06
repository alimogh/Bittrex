package com.example.lokesh.bittrexcryptoexchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class MarketFragment extends Fragment {
    private SectionsPageAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_market, container, false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSectionsPagerAdapter = new SectionsPageAdapter(getChildFragmentManager());
        mViewPager = rootView.findViewById(R.id.containerMarket);
        setupViewPager(mViewPager);
        tabLayout = rootView.findViewById(R.id.tabsMarket);
        tabLayout.setupWithViewPager(mViewPager);
        return rootView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.action_settings){
            Intent intent = new Intent(getActivity(),KeysActivity.class);
            getActivity().startActivity(intent);
        }
        return super.onOptionsItemSelected(item);


    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter((getChildFragmentManager()));
        adapter.addFragment(new BitcoinFragment(),"Bitcoin Market");
        adapter.addFragment(new ETHFragment(),"Ether Market");
        adapter.addFragment(new USDFragment(),"USD Market");
        viewPager.setAdapter(adapter);
    }

}
