package tutorials.androidstudio.fragmentsv4;

import processing.core.PApplet;
import processing.android.PFragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.drawer_layout);
        layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int availableHeight = layout.getMeasuredHeight();
                if(availableHeight>0) {
                    layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    //save height here and do whatever you want with it
                    Sketch.w = layout.getWidth();
                    Sketch.h = layout.getHeight();
                    initSketch();
                }
            }
        });
    }

    void initSketch(){
        FragmentManager fragmentManager = getFragmentManager();
        PApplet sketch = new Sketch();
        PFragment fragment =  new PFragment();
        fragment.setSketch(sketch);
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
