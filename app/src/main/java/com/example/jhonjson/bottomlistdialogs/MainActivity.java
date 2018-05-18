package com.example.jhonjson.bottomlistdialogs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialog_bottomlib.BottomListDialog;
import com.example.dialog_bottomlib.interfaces.OnClickPositionListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 底部弹出
     */
    private TextView mbottom1,mbottom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mbottom1 = (TextView) findViewById(R.id.mbottom1);
        mbottom2 = (TextView) findViewById(R.id.mbottom2);
        mbottom1.setOnClickListener(this);
        mbottom2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**底部弹出*/
            case R.id.mbottom1:
                String[] mList = MainActivity.this.getResources().getStringArray(R.array.selectList);
                showBottomListDialog1(MainActivity.this,mList);
                break;

            case R.id.mbottom2:
                showBottomListDialog2(MainActivity.this,R.dimen.com_font_size_16,getResources().getColor(R.color.colorAccent));
                break;
            default:
                break;
        }

    }


    public void showBottomListDialog1(final Context context, String[] mList) {
        new BottomListDialog.Builder(context).
                addMenuListItem(mList, new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }).show();
    }


    public void showBottomListDialog2( final Context context, int color, int size) {
        new BottomListDialog.Builder(context).
                addMenuItem(new BottomListDialog.BottomListMenuItem("张三", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                },color,size)).
                addMenuItem(new BottomListDialog.BottomListMenuItem("李四", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                },color,size)).
                show();
    }


}
