package absolute.beginners.hellouniverse;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
public class AmbientService extends Service {
	MediaPlayer ambientAudioPlayer;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		ambientAudioPlayer = MediaPlayer.create(this, R.raw.ambient);
		ambientAudioPlayer.setLooping(true);
	}
	@Override
	public void onStart(Intent intent, int startid) {
		ambientAudioPlayer.start();
	}
	@Override
	public void onDestroy() {
		ambientAudioPlayer.stop();
	}
}
