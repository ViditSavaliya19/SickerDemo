package com.example.sickerdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sickerdemo.cropper.CropImage;
import com.example.sickerdemo.cropper.CropImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private CropImageView crop_img;
    private Button crop_btn;
    public static Bitmap bitmap;
    private Button getimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crop_img=findViewById(R.id.crop_img);
//        crop_img.setImageResource(R.drawable.img);
        crop_btn=findViewById(R.id.crop_btn);
        getimg=findViewById(R.id.getimg);
        getimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);

            }
        });

        crop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              bitmap = crop_img.getCroppedImage();
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0)
        {
            Uri uri =  data.getData();
            crop_img.setImageUriAsync(uri);
        }
    }
}