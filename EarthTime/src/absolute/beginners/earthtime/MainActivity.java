package absolute.beginners.earthtime;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.ImageView;
public class MainActivity extends Activity {
	AnalogClock planetClock;
	ImageView jupiterIcon, neptuneIcon, earthIcon, marsIcon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		planetClock = (AnalogClock)findViewById(R.id.earthAnalogClock);
		marsIcon = (ImageView)findViewById(R.id.marsIcon);
		marsIcon.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				planetClock.setBackgroundResource(R.drawable.marstime);
				return false;
			}
		});
		earthIcon = (ImageView)findViewById(R.id.earthIcon);
		earthIcon.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				planetClock.setBackgroundResource(R.drawable.earthtime);
				return false;
			}
		});
		neptuneIcon = (ImageView)findViewById(R.id.neptuneIcon);
		neptuneIcon.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				planetClock.setBackgroundResource(R.drawable.neptunetime);
				return false;
			}
		});
		jupiterIcon = (ImageView)findViewById(R.id.jupiterIcon);
		jupiterIcon.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				planetClock.setBackgroundResource(R.drawable.jupitertime);
				return false;
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
