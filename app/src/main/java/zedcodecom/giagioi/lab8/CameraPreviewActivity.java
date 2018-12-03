package zedcodecom.giagioi.lab8;

import android.graphics.Camera;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.IOException;

public class CameraPreviewActivity extends AppCompatActivity {

    private TextureView textureView;
    private CameraManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        textureView = findViewById(R.id.textureView);

    }
}
