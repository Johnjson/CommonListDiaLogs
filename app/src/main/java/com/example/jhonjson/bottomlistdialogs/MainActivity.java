package com.example.jhonjson.bottomlistdialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dialog_bottomlib.BottomListDialog;
import com.example.dialog_bottomlib.interfaces.OnClickPositionListener;

public class MainActivity extends AppCompatActivity {

    BottomListDialog mBottomListDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] mReportList = MainActivity.this.getResources().getStringArray(R.array.selectList);

        mBottomListDialog = new BottomListDialog.Builder(MainActivity.this).
                addMenuItem(new BottomListDialog.BottomListMenuItem("张三的锅")).
                addMenuListItem(mReportList, new OnClickPositionListener() {
            @Override
            public void onClickPosition(int position) {

                Toast.makeText(MainActivity.this, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}
