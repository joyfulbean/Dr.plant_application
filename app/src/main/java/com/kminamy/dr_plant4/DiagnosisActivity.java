package com.kminamy.dr_plant4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class DiagnosisActivity extends AppCompatActivity {
    //상수
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1001;
    private static final int MY_STORAGE_ACCESS = 101;
    private static final int CAMERA_CAPTURE = 102;

    ImageView imgSelectedPicture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        imgSelectedPicture = (ImageView) findViewById(R.id.imgSelectFromUser);

        //camera permission check
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        //아직 부여받지 않았으므로 요청
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
            }
            //퍼미션 부여 받음
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "Camera Permission is approved", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Camera Permission is disapproved ", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_STORAGE_ACCESS){
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지뷰에 세팅
                    imgSelectedPicture.setImageBitmap(img);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if(requestCode == CAMERA_CAPTURE){
            //찍은 사진 가져와서 붙여주기
            if(resultCode == RESULT_OK && data.hasExtra("data")){
                try{
                    //촬영한 이미지 가져오기
                    Bitmap img = (Bitmap) data.getExtras().get("data");
                    img = imgRotate(img);
                    // 이미지 뷰에 세팅하기
                    imgSelectedPicture.setImageBitmap(img);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnStorage:{
                //스토리지에 접근하는 인텐트
                 /*
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, MY_STORAGE_ACCESS);*/
                //기본 갤러리에 접근하는 코드
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, MY_STORAGE_ACCESS);
                break;
            }
            case R.id.btnCapture:{
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_CAPTURE);

            }
            case R.id.btnSendToServer:{
                // http socket 통신

            }
        }
    }
    private Bitmap imgRotate(Bitmap bmp){
        int width = bmp.getWidth();
        int height = bmp.getHeight();

        Matrix matrix = new Matrix();
        matrix.postRotate(90);

        Bitmap resizedBitmap = Bitmap.createBitmap(bmp,0,0,width,height,matrix,true);
        bmp.recycle();

        return resizedBitmap;
    }

    private void setWaitAnimation(){
        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
    }
}
