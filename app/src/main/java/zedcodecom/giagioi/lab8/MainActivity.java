package zedcodecom.giagioi.lab8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCameraIntent;
    private Button btnCameraIntentPreview;
    private Button btnMeadiaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCameraIntent = findViewById(R.id.btnCameraIntent);
        btnCameraIntentPreview = findViewById(R.id.btnCameraPreview);
        btnMeadiaPlayer = findViewById(R.id.btnMeadiaPlayer);

        btnCameraIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            999);
                }else {
                    navigateScreen(CameraIntentActivity.class);
                }

            }
        });
        btnCameraIntentPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            999);
                }else {
                    navigateScreen(CameraPreviewActivity.class);
                }

            }
        });
        btnMeadiaPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigateScreen(MediaPlayerActivity.class);
            }
        });
    }

    public void navigateScreen(Class target) {
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
}
