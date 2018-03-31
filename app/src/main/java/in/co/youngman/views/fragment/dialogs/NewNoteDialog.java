package in.co.youngman.views.fragment.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.R;
import in.co.youngman.pojo.LeadNote;
import in.co.youngman.pojo.LeadTask;

/**
 * Created by vikasmahato on 24/02/18.
 */

public class NewNoteDialog extends DialogFragment implements View.OnClickListener{
    public static final String TAG = "NewNoteDialog";
    private EditText mEditText;
    private Button mButton;
    private AddNoteLListener callback;

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.note_btn:

                callback.onFinishTaskDialog(mEditText.getText().toString());
                this.dismiss();
                break;
        }
    }

    public interface AddNoteLListener {
        void onFinishTaskDialog(String note);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

        try {
            callback = (AddNoteLListener) getTargetFragment();
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

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_note, parent, false);

        mEditText = (EditText) view.findViewById(R.id.note);
        mButton = (Button) view.findViewById(R.id.note_btn);

        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter note");


        mButton.setOnClickListener(this);
        return view;
    }

}
