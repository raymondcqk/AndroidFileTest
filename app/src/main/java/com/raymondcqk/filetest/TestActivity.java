package com.raymondcqk.filetest;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.raymondqk.filetest.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        //        readAssetPic();
        //        readAssetMedia();
        //        readRawMedia();
        //        readRawText();

        //        String s = MyFileUtil.readAssetText(this,"main.html");
        String[] dirs = MyFileUtil.getExternalDirs("cba");
        if (dirs == null){
            Log.i(MyFileUtil.TEST,"dir 不存在");
        }else {
            for (String s : dirs) {
                Log.i(MyFileUtil.TEST, s);
            }
        }



    }


    private void readRawText() {
        /**
         * Raw 读取文本文件
         */
        InputStream is = getResources().openRawResource(R.raw.text);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                Log.i(MyFileUtil.TEST, line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readRawMedia() {
        /**
         * 读取Raw音频文件
         */
        AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.chen);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAssetMedia() {
        /**
         * Asset：读取音频
         */
        try {
            AssetFileDescriptor afd = getAssets().openFd("remember.mp3");
            if (afd != null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.reset();
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAssetPic() {
        /**
         * Asset：读取图片
         */
        ImageView im_1 = (ImageView) findViewById(R.id.image_1);
        ImageView im_2 = (ImageView) findViewById(R.id.image_2);
        InputStream in = null;
        Bitmap[] bitmaps = null;
        String[] fileNames = null;
        try {
            fileNames = getAssets().list("pic");
            bitmaps = new Bitmap[fileNames.length];
            for (int i = 0; i < fileNames.length; i++) {
                Log.i(MyFileUtil.TEST, fileNames[i]);
                in = getResources().getAssets().open("pic/" + fileNames[i]);
                bitmaps[i] = BitmapFactory.decodeStream(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bitmaps.length > 0) {
            im_1.setImageBitmap(bitmaps[0]);
            im_2.setImageBitmap(bitmaps[1]);
        }
    }

}
