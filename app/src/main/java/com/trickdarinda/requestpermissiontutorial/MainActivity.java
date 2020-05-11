package com.trickdarinda.requestpermissiontutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createDir(View view) {
        checkPermission();
    }

    //Method for checking of permissions
    private void checkPermission(){
        //Required Permission String Array (Put all the permissions you required in this array)
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

        //Check if the permission is granted or not
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0])
                == PackageManager.PERMISSION_GRANTED || ContextCompat
                .checkSelfPermission(this.getApplicationContext(), permissions[1]) ==
                PackageManager.PERMISSION_GRANTED){
            //If permission granted than Toast the Permission Granted message
            Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
        }
        else{
            //if permission is not granted than request for the permission
            ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
        }
    }

    //Method for handling the requested permission results
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        checkPermission();
    }
}
