package sur.gdgdevfest.WikitudeExample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.wikitude.samples.MainActivity;
import com.wikitude.samples.MainSamplesListActivity;

public class MyActivity extends Activity {
    private Context context;

    public static final String EXTRAS_KEY_ACTIVITY_TITLE_STRING = "activityTitle";
    public static final String EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL = "activityArchitectWorldUrl";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        context = this;

        Button ownIR = (Button) findViewById(R.id.own);
        Button ownGPS = (Button) findViewById(R.id.gps);
        Button examples = (Button) findViewById(R.id.examples);

        ownIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                String className = "com.wikitude.samples.SampleCamActivity";
                try {
                    intent = new Intent(context, Class.forName(className));
                    intent.putExtra(EXTRAS_KEY_ACTIVITY_TITLE_STRING, "My own app");
                    intent.putExtra(EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL, "samples/gdgdevfestsur/index.html");

                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(context, className + "\nnot defined/accessible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ownGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = "com.wikitude.samples.SampleCamHandlePoiDetailActivity";

                try {
                    final Intent intent = new Intent(context, Class.forName(className));
                    intent.putExtra(EXTRAS_KEY_ACTIVITY_TITLE_STRING, "My own GPS app");
                    intent.putExtra(EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL, "samples/gdgdevfestsurGPS/index.html");

                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(context, className + "\nnot defined/accessible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        examples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
