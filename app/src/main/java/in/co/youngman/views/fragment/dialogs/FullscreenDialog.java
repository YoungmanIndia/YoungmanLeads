package in.co.youngman.views.fragment.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.youngman.R;
import in.co.youngman.pojo.LeadTask;

/**
 * Created by vikasmahato on 24/02/18.
 */

public class FullscreenDialog extends DialogFragment implements View.OnClickListener{
    public static final String TAG = "FullScreenDialog";
    private EditText mEditText;
    private Button mButton;
    private DatePicker mDatepicker;
    private AddTaskLListener callback;

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.task_btn:

                int day = mDatepicker.getDayOfMonth();
                int month = mDatepicker.getMonth();
                int year = mDatepicker.getYear();


                SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
                Date d = new Date(year, month, day);
                String strDate = dateFormatter.format(d);

                callback.onFinishTaskDialog(new LeadTask(mEditText.getText().toString(),strDate));
                this.dismiss();
                break;
        }
    }

    public interface AddTaskLListener {
        void onFinishTaskDialog(LeadTask leadTask);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

        try {
            callback = (AddTaskLListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException("Calling Fragment must implement OnAddFriendListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        super.onCreateView(inflater, parent, state);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_task, parent, false);

        mEditText = (EditText) view.findViewById(R.id.task);
        mButton = (Button) view.findViewById(R.id.task_btn);
        mDatepicker = (DatePicker) view.findViewById(R.id.date);

        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");


        mButton.setOnClickListener(this);
        return view;
    }

}
