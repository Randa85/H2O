package com.manaffsoft.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraUtils;
import com.otaliastudios.cameraview.CameraView;

public class MainActivity extends AppCompatActivity {

    CameraView cameraView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraView= (CameraView) findViewById(R.id.camera);
        imageView= (ImageView) findViewById(R.id.imageView);
    //    cameraView.capturePicture();

        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] picture) {


                Bitmap bmp = BitmapFactory.decodeByteArray(picture, 0, picture.length);


                imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.getWidth(),
                        imageView.getHeight(), false));

                


                // Create a bitmap or a file...
                // CameraUtils will read EXIF orientation for you, in a worker thread.
//                CameraUtils.decodeBitmap(picture, new CameraUtils.BitmapCallback() {
//                    @Override
//                    public void onBitmapReady(Bitmap bitmap) {
//
//                    }
//                });
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraView.destroy();
    }


public void mansaf(View v)
{
    cameraView.capturePicture();
}



}
