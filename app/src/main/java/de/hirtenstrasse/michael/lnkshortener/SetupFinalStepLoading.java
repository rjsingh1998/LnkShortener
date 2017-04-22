package de.hirtenstrasse.michael.lnkshortener;


import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SetupFinalStepLoading extends Fragment {

    TextView statusText, statusLog;
    ProgressBar statusBar, statusSpinner;
    ImageView doneImage;
    Button finishButton;

    int step;

    public SetupFinalStepLoading() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflater = inflater.inflate(R.layout.fragment_final_step_loading, container, false);

        //  Assign variables for use in voids
        statusBar = (ProgressBar) myInflater.findViewById(R.id.statusBar);
        statusSpinner = (ProgressBar) myInflater.findViewById(R.id.statusSpinner);
        statusText = (TextView) myInflater.findViewById(R.id.statusText);
        doneImage = (ImageView) myInflater.findViewById(R.id.doneIcon);
        finishButton = (Button) myInflater.findViewById(R.id.finishButton);
        statusLog = (TextView) myInflater.findViewById(R.id.statusLogEditText);

        step = 1;


        return myInflater;
    }

    public void updateStatus(String text){
        String oldStatus, oldLog, newLog;

        oldStatus= statusText.getText().toString();
        oldLog = statusLog.getText().toString();

        newLog = "["+step+"]" + oldStatus + "\n" + oldLog;
        step++;

        statusLog.setText(newLog);
        statusText.setText(text);
    }

    public void updateStatusPercent(int status){

        if(status > 0 && status <= 100){

            statusBar.setProgress(status);

        } else {
            // TODO: Add error-logic
        }

        if(status == 100){
            statusSpinner.setVisibility(View.GONE);
            doneImage.setVisibility(View.VISIBLE);
        }

    }

    public void enableFinishButton(){
        finishButton.setEnabled(true);
    }

}
