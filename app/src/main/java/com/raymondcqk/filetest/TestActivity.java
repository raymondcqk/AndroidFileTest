package com.raymondcqk.filetest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.raymondqk.filetest.R;

/**
 * Created by 陈其康 raymondchan on 2016/8/10 0010.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/main.html");

        //        String s = MyFileUtil.readAssetText(this,"main.html");

        //        String dir = "huawei/ime";
        //        String[] dirs = MyFileUtil.getExternalDirs(dir);
        //        if (dirs == null){
        //            Log.i(MyFileUtil.TEST, dir+" 不存在");
        //        }else if (dirs.length==0){
        //            Log.i(MyFileUtil.TEST,dir+" 为空目录");
        //        }else {
        //            for (String s : dirs) {
        //                Log.i(MyFileUtil.TEST, s);
        //            }
        //        }
        //        Log.i(MyFileUtil.TEST, MyFileUtil.readRawText(this, R.raw.chen));
        //       AssetFileDescriptor afd =  MyFileUtil.readRawMedia(this,R.raw.chen);
        //        AssetFileDescriptor afd = MyFileUtil.readAssetMedia(this,"remember.mp3");
        //        if (afd!=null){
        //            MediaPlayer mediaPlayer = new MediaPlayer();
        //            mediaPlayer.reset();
        //            try {
        //                mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
        //            } catch (IOException e) {
        //                e.printStackTrace();
        //            }
        //            mediaPlayer.prepareAsync();
        //            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        //                @Override
        //                public void onPrepared(MediaPlayer mediaPlayer) {
        //                    mediaPlayer.start();
        //                }
        //            });
        //        }else {
        //            Log.w(MyFileUtil.TEST,"文件读取失败");
        //        }

//        String dir = "pic";
//        String[] list = MyFileUtil.assetList(this, dir);
//        if (list != null) {
//            if (list.length > 0) {
//                ImageView im = (ImageView) findViewById(R.id.image_1);
//                im.setImageBitmap(MyFileUtil.readAssetPic(this, dir + "/" + list[0]));
//            } else {
//                Log.i(MyFileUtil.TEST, "目录为空");
//            }
//        }
    }
}
