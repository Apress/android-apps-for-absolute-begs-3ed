package absolute.beginners.hellouniverse;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends Activity {
    static Galaxy milkyWay = new Galaxy("Milky Way", 511, 97);
	TextView nameData, solarData, habitData, colonyData, popData, fleetData, shipsData;
	ImageButton imageButtonOne, imageButtonTwo, imageButtonThree;
	Animation spaceShipAnim, lightShipAnim;
	ImageView animImageView;
    SoundPool buttonSamples;
    SparseIntArray buttonSampleArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSamples = new SoundPool(3, AudioManager.STREAM_MUSIC, 100);
        buttonSampleArray = new SparseIntArray(3);
        buttonSampleArray.append(1, buttonSamples.load(this, R.raw.buttonaudio, 1));
        buttonSampleArray.append(2, buttonSamples.load(this, R.raw.buttonaudio2, 1));
        buttonSampleArray.append(3, buttonSamples.load(this, R.raw.buttonaudio3, 1));
        createDefaultGalaxy();
        createUiTextViews();
        transferDataValues();
        imageButtonOne = (ImageButton)findViewById(R.id.galaxyOne);
        imageButtonTwo = (ImageButton)findViewById(R.id.galaxyTwo);
        imageButtonThree = (ImageButton)findViewById(R.id.galaxyThree);
        animImageView = (ImageView)findViewById(R.id.animImageView);
        spaceShipAnim = AnimationUtils.loadAnimation(this, R.anim.anim_andromeda);
        lightShipAnim = AnimationUtils.loadAnimation(this, R.anim.anim_lightshipset);
        imageButtonOne.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
			 animImageView.setBackgroundResource(R.drawable.imageviewwhitering);
			 animImageView.setImageResource(R.drawable.anim_milkyway);
			 animImageView.setAnimation(null);
			 nameData.setText("Milky Way");
			 solarData.setText("511");
			 habitData.setText("97");
			 colonyData.setText("37579231");
			 popData.setText("1967387132");
			 fleetData.setText("237");
			 shipsData.setText("34769");
			 triggerSample(1, 1.0f);
		 }});
        imageButtonTwo.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
			 animImageView.setImageResource(R.drawable.friendship);
			 animImageView.setBackground(null);
			 animImageView.startAnimation(spaceShipAnim);
			 nameData.setText("Andromeda");
			 solarData.setText("762");
			 habitData.setText("143");
			 colonyData.setText("32586419");
			 popData.setText("16543875");
			 fleetData.setText("421");
			 shipsData.setText("97325");
			 triggerSample(2, 1.0f);
		 }});
        imageButtonThree.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
			 animImageView.setImageResource(R.drawable.anim_lightship);
			 animImageView.setBackground(null);
			 animImageView.startAnimation(lightShipAnim);
			 nameData.setText("Spiral Galaxy M106");
			 solarData.setText("762");
			 habitData.setText("143");
			 colonyData.setText("32586419");
			 popData.setText("16543875");
			 fleetData.setText("421");
			 shipsData.setText("97325");
			 triggerSample(3, 1.0f);
		 }});        
    }
	private void createDefaultGalaxy(){
        milkyWay.setGalaxyColonies(37579231);
        milkyWay.setGalaxyPopulation(1967387132);
        milkyWay.setGalaxyFleets(237);
        milkyWay.setGalaxyStarships(34769);
    }
	private void createUiTextViews() {
		nameData = (TextView)findViewById(R.id.name);
		solarData = (TextView)findViewById(R.id.solar);
		habitData = (TextView)findViewById(R.id.habit);
		colonyData = (TextView)findViewById(R.id.colony);
		popData = (TextView)findViewById(R.id.pop);
		fleetData = (TextView)findViewById(R.id.fleet);
		shipsData = (TextView)findViewById(R.id.ships);
	}	
	private void transferDataValues() {
		nameData.setText(milkyWay.galaxyName);
		solarData.setText(String.valueOf(milkyWay.galaxySolarSystems));
		habitData.setText(String.valueOf(milkyWay.galaxyPlanets));
		colonyData.setText(String.valueOf(milkyWay.galaxyColonies));
		popData.setText(String.valueOf(milkyWay.galaxyLifeforms));
		fleetData.setText(String.valueOf(milkyWay.galaxyFleets));
		shipsData.setText(String.valueOf(milkyWay.galaxyStarships));
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.edit_galaxy:
    		Intent editIntent = new Intent(this, EditGalaxy.class);
    		this.startActivity(editIntent);
    		break;
    	case R.id.contact_galaxy:
    		Intent dataIntent = new Intent(this, ContactGalaxy.class);
    		this.startActivity(dataIntent);
    		break;
    	case R.id.play_video:
    		Intent playIntent = new Intent(this, PlayVideo.class);
    		this.startActivity(playIntent);
    		break;
    	}
		return true;
	}
    public void triggerSample (int sound, float pitch){
    	AudioManager audioControl = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    	float currentSoundVolume = audioControl.getStreamVolume(AudioManager.STREAM_MUSIC);
    	float maximumSoundVolume = audioControl.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    	float volumeSet = currentSoundVolume / maximumSoundVolume;
    	buttonSamples.play(buttonSampleArray.get(sound), volumeSet, volumeSet, 0, 0, pitch);
    }
}