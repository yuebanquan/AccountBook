package com.example.terminal_work;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BillFragment extends Fragment {

    private TextView bill_select;//声明账单页面里筛选TextView键
    private DrawerLayout bill_drawerLayout;//声明账单页面的根布局

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflater使将xml布局文件转换为视图的一个类,container表示在container里面显示这个视图
        View view=inflater.inflate(R.layout.bill_page,container,false);

        bill_select=view.findViewById(R.id.bill_select);//找到账单页面里筛选TextView键
        bill_drawerLayout=view.findViewById(R.id.bill_drawerlayout);//找到账单页面的drawerlayout的根布局

        bill_select.setOnClickListener(new View.OnClickListener() {//编写点击显示侧滑菜单的事件
            @Override
            public void onClick(View v) {
                bill_drawerLayout.openDrawer(Gravity.END);//openDrawer()函数用来打开侧滑菜单,Gravity.START表示布局文件里设置的滑出方向
            }
        });

        return view;//返回具体的布局
    }
}
