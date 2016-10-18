package absolute.beginners.hellouniverse;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.RawContacts;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class ContactGalaxy extends Activity {
	Button listButton, milkyWayButton, andromedaButton, spiralButton, homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        listButton = (Button)findViewById(R.id.listRulers);
        listButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				listGalaxyRulers();
			}
		});
        milkyWayButton = (Button)findViewById(R.id.addMilkyWay);
        milkyWayButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				addGalaxyViceroy("Viceroy Pavel Chekov");
			}
		});
        andromedaButton = (Button)findViewById(R.id.addAndromeda);
        andromedaButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				addGalaxyViceroy("Viceroy Hikaru Sulu");
			}
		});
        spiralButton = (Button)findViewById(R.id.addSpiral);
        spiralButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				addGalaxyViceroy("Viceroy Leonard McCoy");
			}
		});
        homeButton = (Button)findViewById(R.id.returnHome);
        homeButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) { finish(); }});
    }
	protected void addGalaxyViceroy(String electedViceroy) {
		ContentValues viceroyContact = new ContentValues();
		viceroyContact.put(RawContacts.ACCOUNT_NAME, electedViceroy);
		viceroyContact.put(RawContacts.ACCOUNT_TYPE, electedViceroy);
		Uri newUri = getContentResolver().insert(RawContacts.CONTENT_URI, viceroyContact);
		long rawContactsId = ContentUris.parseId(newUri);
		viceroyContact.clear();
		viceroyContact.put(Data.RAW_CONTACT_ID, rawContactsId);
		viceroyContact.put(Data.MIMETYPE,  StructuredName.CONTENT_ITEM_TYPE);
		viceroyContact.put(StructuredName.DISPLAY_NAME, electedViceroy);
		getContentResolver().insert(Data.CONTENT_URI, viceroyContact);
		Toast.makeText(this, electedViceroy + " has been elected", Toast.LENGTH_LONG).show();
	}
	protected void listGalaxyRulers() {
		Cursor rulerCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
		while (rulerCursor.moveToNext()){
		String rulerName = rulerCursor.getString(rulerCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
		Toast.makeText(this, rulerName, Toast.LENGTH_LONG).show();
		}
	}
}
