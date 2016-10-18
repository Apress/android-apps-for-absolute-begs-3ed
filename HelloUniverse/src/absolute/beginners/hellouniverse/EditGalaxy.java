package absolute.beginners.hellouniverse;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class EditGalaxy extends Activity {
	Button colonyButton, popButton, fleetButton, shipsButton;
	EditText colonyEdit, popEdit, fleetEdit, shipsEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        instantiateUi();
        colonyButton.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
		  MainActivity.milkyWay.galaxyColonies = Long.parseLong(colonyEdit.getText().toString());
		 }});
        popButton.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
		  MainActivity.milkyWay.galaxyLifeforms = Double.parseDouble(popEdit.getText().toString());
		 }});
        fleetButton.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
		  MainActivity.milkyWay.galaxyFleets = Integer.parseInt(fleetEdit.getText().toString());
		 }});
        shipsButton.setOnClickListener(new View.OnClickListener(){
		 @Override
		 public void onClick(View v) {
		  MainActivity.milkyWay.galaxyStarships = Integer.parseInt(shipsEdit.getText().toString());
		 }});        
    }
	private void instantiateUi() {
		colonyButton = (Button)findViewById(R.id.submit_colony);
		popButton = (Button)findViewById(R.id.submit_pop);
		fleetButton = (Button)findViewById(R.id.submit_fleet);
		shipsButton = (Button)findViewById(R.id.submit_ships);
		colonyEdit = (EditText)findViewById(R.id.edit_colony);
		popEdit = (EditText)findViewById(R.id.edit_pop);
		fleetEdit = (EditText)findViewById(R.id.edit_fleet);
		shipsEdit = (EditText)findViewById(R.id.edit_ships);
	}
}