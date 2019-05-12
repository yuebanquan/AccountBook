package com.example.terminal_work;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;


public class TableFragment extends Fragment {


    private Spinner spinner;
    List<String>list=new ArrayList<String>();//创建一个用来对spinner添加内容的list

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflater使将xml布局文件转换为视图的一个类,container表示在container里面显示这个视图
        View view=inflater.inflate(R.layout.table_page,container,false);

        spinner=view.findViewById(R.id.table_select);//找到控制是否弹出菜单的spinner
        list.add("收入");
        list.add("支出");
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this.getActivity(),R.layout.my_spinner_layout,list);//适配器创建
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);//控件绑定适配器




        return view;//返回具体的布局
    }


}
