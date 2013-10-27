package sur.gdgdevfest.WikitudeExample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

        Intent intent = null;
        String className = "com.wikitude.samples.SampleCamActivity";
        try {
            intent = new Intent(context, Class.forName(className));
            intent.putExtra(EXTRAS_KEY_ACTIVITY_TITLE_STRING, "1.1 Image On Target");
            intent.putExtra(EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL, "samples/1_Image$Recognition_1_Image$On$Target/index.html");

            startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this, className + "\nnot defined/accessible",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
