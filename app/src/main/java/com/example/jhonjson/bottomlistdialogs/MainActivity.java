package com.example.jhonjson.bottomlistdialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialog_bottomlib.BottomListDialog;
import com.example.dialog_bottomlib.interfaces.OnClickPositionListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomListDialog mBottomListDialog;
    /**
     * 底部弹出
     */
    private TextView mbottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mbottom = (TextView) findViewById(R.id.mbottom);
        mbottom.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**底部弹出*/
            case R.id.mbottom:
                showBottomListDialog();
                break;
            default:
                break;
        }

    }


    private void showBottomListDialog() {
        String[] mReportList = MainActivity.this.getResources().getStringArray(R.array.selectList);
        mBottomListDialog = new BottomListDialog.Builder(MainActivity.this).
                addMenuItem(new BottomListDialog.BottomListMenuItem("张三的锅")).
                addMenuListItem(mReportList, new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(MainActivity.this, "点击第几个位置    " + (position - 1), Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
}
