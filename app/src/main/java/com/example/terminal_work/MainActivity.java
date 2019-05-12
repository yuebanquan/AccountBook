package com.example.terminal_work;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    //下面创建三个管理四个Fragment碎片必要的组建
    private Fragment[] fragments=new Fragment[4];
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    //声明四个碎片类
    private HomeFragment homeFragment;
    private BillFragment billFragment;
    private WishFragment wishFragment;
    private TableFragment tableFragment;
    //声明底部导航栏的按钮
    private RadioButton  homebutton;
    private RadioButton  billbutton;
    private RadioButton  wishbutton;
    private RadioButton  tablebutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //下面找到四个底部导航栏的选择按钮
        homebutton=findViewById(R.id.home_page);
        billbutton=findViewById(R.id.bill_page);
        wishbutton=findViewById(R.id.wish_page);
        tablebutton=findViewById(R.id.table_page);


        //找到之后进行监听的绑定
        homebutton.setOnClickListener(this);
        billbutton.setOnClickListener(this);
        wishbutton.setOnClickListener(this);
        tablebutton.setOnClickListener(this);

        //下面对三个java的Fragment类进行实例化
        homeFragment=new HomeFragment();
        billFragment=new BillFragment();
        wishFragment=new WishFragment();
        tableFragment=new TableFragment();

        fragmentManager=getSupportFragmentManager();
        //下面将四个Fragment加入到fragments数组中,方便后续使用
        fragments=new Fragment[]{homeFragment,billFragment,wishFragment,tableFragment};

        selectTab(0);//首先加载第一个首页页面
    }

    private void selectTab(int i) {
        transaction=fragmentManager.beginTransaction();
        //在首页展示之前先隐藏其他页面
        hideAllFragment(transaction);
        //展示需要展示的fragment
        if(fragments[i].isAdded()){//判断是否将fragment加入，如果加入则直接展示即可
            transaction.show(fragments[i]);
        }
        else{//如果未加入，则先加入，后展示
            transaction.add(R.id.mFragment,fragments[i]);
            transaction.show(fragments[i]);
        }
        transaction.commit();//最后进行事务的提交
    }

    private void hideAllFragment(FragmentTransaction transaction) {//隐藏四个Fragment
        for(int i=0;i<fragments.length;i++){
            transaction.hide(fragments[i]);
        }
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.home_page:
                selectTab(0);
                break;
            case R.id.bill_page:
                selectTab(1);
                break;
            case R.id.wish_page:
                selectTab(2);
                break;
            case R.id.table_page:
                selectTab(3);
                break;
        }
    }
}
