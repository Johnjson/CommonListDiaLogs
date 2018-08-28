![效果图1](https://img.shields.io/badge/build-passing-%23209e89.svg)
# CommonListDiaLogs
封装通用dialog  弹出框

由于每次写dialog都要写很多重复代码，因此简单的封装了一个CommonListDiaLogs,封装了一些常用方法，使用Builder模式实现:

### 展示效果：
![效果图1](img/2018-08-28%2015_41_25.gif)

![效果图1](img/9FD09CD2-8D55-4528-9870-9547880BBDC6.png)

![效果图2](img/50C6C998-A2DE-4E18-B524-3D5D15F88EF9.png)

![效果图3](img/49F23D66-8D04-4857-908E-837C1F60F12A.png)

![效果图4](img/7D66D69D-FC66-40F1-B622-FBA8F2D219CD.png)

![效果图5](img/87BD7DCA-178C-41DB-8F16-C338554257C9.png)

![效果图6](img/5D323BF0-D71D-4E9A-8E10-6DA790E47DC3.png)

### 使用方式：

Add the dependency to your build.gradle.

```java
dependencies {
	        implementation 'com.github.Johnjson:CommonListDiaLogs:v1.0.2'
	}
```


### 更新日志

**v1.0.2：**

``` 
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
```


**v1.0.1：**

```  public void showBottomListDialog1(@final Context context, String[] mList) {
        new BottomListDialog.Builder(context).
                addMenuListItem(mList, new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
```

```public void showBottomListDialog2( final Context context, int color, int size) {
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
```


```   public void showMiddleListDialog1(final Context context, String[] mList) {
        new MiddleListDialog.Builder(context).
                addMenuListItem(mList, new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
```

``` public void showMiddleListDialog2(final Context context, int color, int size) {
        new MiddleListDialog.Builder(context).
                addMenuItem(new MiddleListDialog. MiddleListMenuItem("张三", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, color, size)).
                addMenuItem(new MiddleListDialog. MiddleListMenuItem("李四", new OnClickPositionListener() {
                    @Override
                    public void onClickPosition(int position) {
                        Toast.makeText(context, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, color, size)).
                show();
    }
```


```    @Override
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

    }```




如果你喜欢，欢迎stars