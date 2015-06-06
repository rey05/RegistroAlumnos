package angel.reynaldo.registroalumnos;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ListActivity {


    static final String URL = "http://eulisesrdz.260mb.net/rey/bbdd.xml";

    // XML node keys

    static final String KEY_ALUMNOS = "alumnos"; // parent node
    static final String KEY_NOCONTROL = "NoControl"; // parent node
    static final String KEY_NOMBRE = "Nombre";
    static final String KEY_APELLIDOS = "Apellidos";
    static final String KEY_SEMESTRE = "Semestre";
    static final String KEY_CARRERA = "Carrera";
    static final String KEY_EMAIL = "Email";
    static final String KEY_DIRECCION = "Direccion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML

        Document doc = parser.getDomElement(xml);// getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_ALUMNOS);
        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_NOCONTROL, parser.getValue(e, KEY_NOCONTROL));
            map.put(KEY_NOMBRE, parser.getValue(e, KEY_NOMBRE));
            map.put(KEY_APELLIDOS, parser.getValue(e, KEY_APELLIDOS));
            map.put(KEY_SEMESTRE, parser.getValue(e, KEY_SEMESTRE));
            map.put(KEY_CARRERA, parser.getValue(e, KEY_CARRERA));
            map.put(KEY_EMAIL, parser.getValue(e, KEY_EMAIL));
            map.put(KEY_DIRECCION, parser.getValue(e, KEY_DIRECCION));

            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems, R.layout.listaregistro, new String[]{ KEY_NOCONTROL, KEY_NOMBRE, KEY_APELLIDOS}, new int[]{ R.id.nc1, R.id.n1, R.id.a1 });

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting values from selected ListItem
                String nc = ((TextView) view.findViewById(R.id.nc1)).getText().toString();
                String nom = ((TextView) view.findViewById(R.id.n1)).getText().toString();
                String ap = ((TextView) view.findViewById(R.id.apellidos)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), registroindividual.class);
                in.putExtra(KEY_NOCONTROL, nc);
                in.putExtra(KEY_NOMBRE, nom);
                in.putExtra(KEY_APELLIDOS, ap);
                startActivity(in);

            }
        });
    }
}




