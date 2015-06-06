package angel.reynaldo.registroalumnos;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



public class registroindividual extends Activity {

    // All static variables


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
        setContentView(R.layout.activity_registroindividual);

        // getting intent data
        Intent in = getIntent();

        // Get XML values from previous intent
        String NoControl = in.getStringExtra(KEY_NOCONTROL);
        String Nombre = in.getStringExtra(KEY_NOMBRE);
        String Apellidos = in.getStringExtra(KEY_APELLIDOS);
        String Semestre = in.getStringExtra(KEY_SEMESTRE);
        String Carrera = in.getStringExtra(KEY_CARRERA);
        String Email = in.getStringExtra(KEY_EMAIL);
        String Direccion = in.getStringExtra(KEY_DIRECCION);

        // Displaying all values on the screen
        TextView nc = (TextView) findViewById(R.id.dato1);
        TextView n = (TextView) findViewById(R.id.dato2);
        TextView a = (TextView) findViewById(R.id.dato3);
        TextView s = (TextView) findViewById(R.id.dato4);
        TextView c = (TextView) findViewById(R.id.dato5);
        TextView e = (TextView) findViewById(R.id.dato6);
        TextView d = (TextView) findViewById(R.id.dato7);

        nc.setText(NoControl);
        n.setText(Nombre);
        a.setText(Apellidos);
        s.setText(Semestre);
        c.setText(Carrera);
        e.setText(Email);
        d.setText(Direccion);
    }
}
