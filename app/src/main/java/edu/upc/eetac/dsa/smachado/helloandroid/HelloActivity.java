package edu.upc.eetac.dsa.smachado.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import org.apache.commons.codec.digest.DigestUtils;


public class HelloActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_linear);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private final static String TAG = HelloActivity.class.getName();
    private int counter;

    public void clickMe(View v) {
        TextView tv = (TextView) findViewById(R.id.counterLabel);
        tv.setText(getString(R.string.counter_label) + " " + (++counter));

        TextView tvInput = (TextView) findViewById(R.id.tvInput);
        EditText input = (EditText) findViewById(R.id.input);
        String hash = DigestUtils.md5Hex(input.getText().toString());
        tvInput.setText(hash);
        input.setText("");
    }
}
