package com.jhonjson.jhonjson.bottomlistdialogs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jhonjson.dialoglib.BottomListDialog;
import com.jhonjson.dialoglib.CommonSelectDialog;
import com.jhonjson.dialoglib.MiddleListDialog;
import com.jhonjson.dialoglib.interfaces.OnClickPositionListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.mbottom1).setOnClickListener(this);
        findViewById(R.id.mbottom2).setOnClickListener(this);

        findViewById(R.id.middle1).setOnClickListener(this);
        findViewById(R.id.middle2).setOnClickListener(this);
        findViewById(R.id.select).setOnClickListener(this);
        findViewById(R.id.selec1).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**底部弹出1*/
            case R.id.mbottom1:
                String[] mList = MainActivity.this.getResources().getStringArray(R.array.selectList);
                showBottomListDialog1(MainActivity.this, mList);
                break;
            /**底部弹出2*/
            case R.id.mbottom2:
                showBottomListDialog2(MainActivity.this, R.dimen.com_font_size_16, getResources().getColor(R.color.colorAccent));
                break;

            /**中部弹出1*/
            case R.id.middle1:
                String[] mList1 = MainActivity.this.getResources().getStringArray(R.array.selectList);
                showMiddleListDialog1(MainActivity.this, mList1);
                break;
            /**中部弹出2*/
            case R.id.middle2:
                showMiddleListDialog2(MainActivity.this, R.dimen.com_font_size_16, getResources().getColor(R.color.colorAccent));
                break;

            /**选择弹出框*/
            case R.id.select:
                showSelectDialog(MainActivity.this, "提示", "你确定要关闭这个dialog吗？", "取消", "确认", 16);
                break;
            /**单个按钮弹出框*/
            case R.id.selec1:
                showSelectOneDialog(MainActivity.this, "提示", "你确定要删除这个dialog吗？", "确认", 16);
                break;
            default:
                break;
        }

    }

    /**
     * 底部弹出1
     */
    public void showBottomListDialog1(final Context context, String[] mList) {
        new BottomListDialog.Builder(context).
                addMenuListItem(mList, new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    /**
     * 底部弹出2
     */
    public void showBottomListDialog2(final Context context, int color, int size) {
        new BottomListDialog.Builder(context).
                addMenuItem(new BottomListDialog.BottomListMenuItem("张三", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, color, size)).
                addMenuItem(new BottomListDialog.BottomListMenuItem("李四", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, color, size)).
                show();
    }


    /**
     * 中部弹出1
     */
    public void showMiddleListDialog1(final Context context, String[] mList) {
        new MiddleListDialog.Builder(context).
                addMenuListItem(mList, new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    /**
     * 底部弹出2
     */
    public void showMiddleListDialog2(final Context context, int color, int size) {
        new MiddleListDialog.Builder(context).
                addMenuItem(new MiddleListDialog.MiddleListMenuItem("张三", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, color, size)).
                addMenuItem(new MiddleListDialog.MiddleListMenuItem("李四", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, color, size)).
                show();
    }

    /**
     * 选择弹出框
     */
    CommonSelectDialog mCommonSelectDialog = null;

    public void showSelectDialog(final Context context, String mTitle, String mContent, String cancel, String confirm, int size) {
        mCommonSelectDialog = new CommonSelectDialog.Builder(context).
                setContentGravity(Gravity.CENTER).
                setTouchAble(true).
                setTitle(mTitle).
                setContent(mContent).
                setContentSize(size).
                setLeftButtonInterface(cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCommonSelectDialog.dismiss();
                    }
                }).setRightButtonInterface(confirm, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCommonSelectDialog.dismiss();
            }
        }).show();

    }


    /**
     * 单个按钮弹出框
     */
    public void showSelectOneDialog(final Context context, String mTitle, String mContent, String confirm, int size) {
        mCommonSelectDialog = new CommonSelectDialog.Builder(context).
                setContentGravity(Gravity.CENTER).
                setTouchAble(true).
                setTitle(mTitle).
                setContent(mContent).
                setContentSize(size).
                setOneButtonInterface(confirm, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCommonSelectDialog.dismiss();
                    }
                }).show();

    }

}
