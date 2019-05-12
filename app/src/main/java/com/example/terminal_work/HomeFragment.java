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
import android.widget.Button;
import android.widget.ListView;

public class HomeFragment extends Fragment {

    private ListView listview;//声明侧滑菜单的列表控件
    private ArrayAdapter<String> adapter;//声明一个字符串型的数组适配器
    String[] home_menu;//侧滑菜单的内容

    private Button show_list_btn;//声明点击出现侧滑菜单的按钮
    private DrawerLayout drawerLayout;//声明侧滑菜单对应的根布局

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflater使将xml布局文件转换为视图的一个类,container表示在container里面显示这个视图
        View view = inflater.inflate(R.layout.home_page, container, false);

        listview = view.findViewById(R.id.list_view_menu);//找到添加侧滑菜单对应的控件
        home_menu = new String[]{"消息中心", "个性皮肤", "同步", "汇率计算器", "房贷计算器", "帮助与反馈", "关于小账本", "清空缓存", "设置"};
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_expandable_list_item_1, home_menu);//创建适配器,并加载对应的布局资源

        listview.setAdapter(adapter);//listview与适配器的绑定

        show_list_btn = view.findViewById(R.id.show_list);//找到点击显示侧滑菜单的按钮
        drawerLayout = view.findViewById(R.id.drawerlayout);//找到要显示的侧滑菜单的根布局
        show_list_btn.setOnClickListener(new View.OnClickListener() {//编写按钮的点击显示侧滑菜单的事件
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);//openDrawer()函数用来打开侧滑菜单,Gravity.START表示布局文件里设置的滑出方向
            }
        });

        return view;//返回具体的布局
    }
}
