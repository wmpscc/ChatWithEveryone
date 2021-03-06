package com.example.lab.android.nuc.chat.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab.android.nuc.chat.Fragment.HomeFragment;
import com.example.lab.android.nuc.chat.Fragment.MessageFragment;
import com.example.lab.android.nuc.chat.Fragment.QuestionFragment;
import com.example.lab.android.nuc.chat.R;

public class PageAdapter extends FragmentPagerAdapter {

    //定义标签的数量
    public final int COUNT  = 3;

    private String [] titles = {"消息","联系人","提问"};


    private int[] tabimgs = new int[]{
            R.drawable.message_selector,R.drawable.contact_selector,
            R.drawable.question_selector
    };

    public Context mContext;

    public PageAdapter(FragmentManager fm,Context context){
        super(fm);
        this.mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            //返回一个Fragment
            return MessageFragment.newInstance();
        else if (position == 1)
            return HomeFragment.newInstance(position + 1);
        else if (position == 2)
            return QuestionFragment.newInstance();
        else
            return null;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public View getTabView(int position){

        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_page,null);
        TextView textView = (TextView) v.findViewById(R.id.news_title);
        ImageView tabImageView = (ImageView) v.findViewById(R.id.news_image_view);
        tabImageView.setImageResource( tabimgs[position] );
        textView.setText(titles[position]);
        return v;
    }
}
