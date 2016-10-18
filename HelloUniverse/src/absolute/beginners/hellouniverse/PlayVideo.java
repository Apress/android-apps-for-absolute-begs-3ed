package absolute.beginners.hellouniverse;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
public class PlayVideo extends Activity {
	VideoView videoPlayer;
	Uri planetFlyOverUri;
	MediaController videoTransport;
	ImageView soundOn, soundOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        soundOn = (ImageView)findViewById(R.id.playAudio);
        soundOn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				startService(new Intent(PlayVideo.this, AmbientService.class));
			}
        });
        soundOff = (ImageView)findViewById(R.id.stopAudio);
        soundOff.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				stopService(new Intent(PlayVideo.this, AmbientService.class));
			}
        });
        videoPlayer = (VideoView)findViewById(R.id.videoPlayer);
        planetFlyOverUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.flyover);
        videoPlayer.setVideoURI(planetFlyOverUri);
        videoTransport = new MediaController(this);
        videoTransport.setAnchorView(videoPlayer);
        videoPlayer.setMediaController(videoTransport);
        videoPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer arg0) {
				arg0.setLooping(true);
			}
		});
        videoPlayer.start();
    }
}