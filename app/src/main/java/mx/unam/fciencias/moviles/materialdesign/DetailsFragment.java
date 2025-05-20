package mx.unam.fciencias.moviles.materialdesign;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String INDEX_KEY = "mx.unam.fciencias.moviles.materialdesign.INDEX";
    public static final String MASTER_LIST_SIZE_KEY = "mx.unam.fciencias.moviles.materialdesign.MASTER_LIST_SIZE_KEY";

    // TODO: Rename and change types of parameters
    private int selectedIndex;
    private int masterListSize;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args == null) {
            selectedIndex = -1;
            masterListSize = -1;
            Log.w(DetailsFragment.class.getSimpleName(), "Se seleccionó una entrada inválida");
            return;
        }
        selectedIndex = args.getInt(INDEX_KEY);
        masterListSize = args.getInt(MASTER_LIST_SIZE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        View colorView = rootView.findViewById(R.id.color_view);
        TextView red =  rootView.findViewById(R.id.red_value_tv);
        TextView green = rootView.findViewById(R.id.green_value_tv);
        TextView blue = rootView.findViewById(R.id.blue_value_tv);
        TextView hex = rootView.findViewById(R.id.hex_value_tv);
        float[] rgb = generateColorFromIndex();
        int[] intRgb = new int[] {(int) (rgb[0] * 255), (int) (rgb[1] * 255), (int) (rgb[2] * 255)};
        int indexColor = Build.VERSION.SDK_INT < Build.VERSION_CODES.O ?
                Color.rgb(intRgb[0], intRgb[1], intRgb[2]) :
                    Color.rgb(rgb[0], rgb[1], rgb[2]);
        colorView.setBackgroundColor(indexColor);
        red.setText(rootView.getResources().getString(
                R.string.red_color_component, rgb[0], intRgb[0]
        ));
        green.setText(rootView.getResources().getString(
                R.string.green_color_component, rgb[1], intRgb[1]
        ));
        blue.setText(rootView.getResources().getString(
                R.string.blue_color_component, rgb[2], intRgb[2]
        ));
        hex.setText(Integer.toHexString(indexColor));
        return rootView;
    }

    private float[] generateColorFromIndex() {
        float datasetThird = masterListSize /3f;
        byte third;
        int previousThird;
        if (masterListSize == 1 ||  selectedIndex < datasetThird) {
            previousThird = selectedIndex + 1;
            third = 1;
        } else {
            previousThird = (int) datasetThird;
            third = (byte) (selectedIndex < datasetThird * 2 ? 2 : 3);
        }
        float[] rgb = new float[3];
        rgb[0] = (selectedIndex + 1) / (third * datasetThird);
        rgb[1] = (selectedIndex + 1 - previousThird) / (2 * datasetThird);
        rgb[2] = third == 3 ? (selectedIndex + 1f) / masterListSize : 0;
        if (rgb[0] > 1) rgb[0] = 1;
        if (rgb[1] > 1) rgb[1] = 1;
        return rgb;
    }
}