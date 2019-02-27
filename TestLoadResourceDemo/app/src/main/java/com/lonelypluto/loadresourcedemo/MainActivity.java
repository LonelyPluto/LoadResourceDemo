package com.lonelypluto.loadresourcedemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lonelypluto.loadresourcedemo.constants.SPConsts;
import com.lonelypluto.loadresourcedemo.utils.LoadResourceUtil;
import com.lonelypluto.loadresourcedemo.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;

    private ImageView iv;
    private TextView tv;
    private Button btn_set_resource;
    private Button btn_img;
    private Button btn_text;
    private Button btn_color;
    private Button btn_ohter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();
        initView();
        setListener();
    }

    /**
     * 初始化view
     */
    private void initView(){
        iv = (ImageView)findViewById(R.id.main_iv);
        tv = (TextView)findViewById(R.id.main_tv);
        btn_set_resource = (Button)findViewById(R.id.main_btn_set_resource);
        btn_img = (Button)findViewById(R.id.main_btn_img);
        btn_text = (Button)findViewById(R.id.main_btn_text);
        btn_color = (Button)findViewById(R.id.main_btn_color);
        btn_ohter = (Button)findViewById(R.id.main_btn_other);

    }

    /**
     * 设置监听事件
     */
    private void setListener(){
        btn_set_resource.setOnClickListener(this);
        btn_img.setOnClickListener(this);
        btn_text.setOnClickListener(this);
        btn_color.setOnClickListener(this);
        btn_ohter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_set_resource:
                // 加载sd卡路径下的资源apk文件
                LoadResourceUtil.getInstance().setLoadResource(Environment.getExternalStorageDirectory() + "/testResource1.apk");
                Toast.makeText(this, "加载成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn_img:
                // 加载资源apk文件中的图片
                Drawable changeConfig = LoadResourceUtil.getInstance().getDrawable("test_img");
                if (changeConfig != null) {
                    iv.setImageDrawable(changeConfig);
                }
                break;
            case R.id.main_btn_text:
                // 加载资源apk文件中的文字
                tv.setText(LoadResourceUtil.getInstance().getString("test_text"));
                break;
            case R.id.main_btn_color:
                // 加载资源apk文件中的颜色
                tv.setTextColor(LoadResourceUtil.getInstance().getColor("test_color"));
                break;
            case R.id.main_btn_other:
                // 加载sd卡路径下的其他资源apk文件
                LoadResourceUtil.getInstance().setLoadResource(Environment.getExternalStorageDirectory() + "/testResource2.apk");
                Toast.makeText(this, "加载成功", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_REQUEST_CODE:
                java.util.Map<String, Integer> perms = new HashMap<>();
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                Boolean storage = perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
                if (storage) {
                    // All Permissions Granted
                    Toast.makeText(MainActivity.this, "允许存储权限", Toast.LENGTH_SHORT).show();
                } else { // !location && !storage case
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "存储权限被拒绝", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }

    /**
     * 申请权限
     */
    private void checkPermissions() {
        List<String> permissions = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissions.isEmpty()) {
            String[] params = permissions.toArray(new String[permissions.size()]);
            ActivityCompat.requestPermissions(this, params, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
        }else{// else: We already have permissions, so handle as normal

        }
    }
}
