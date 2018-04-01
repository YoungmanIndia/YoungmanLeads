package in.co.youngman.views.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.co.youngman.R;
import in.co.youngman.pojo.Customer;
import in.co.youngman.rest.CustomerAPI;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewCustomerActivity extends AppCompatActivity {

    @BindView(R.id.first_name)          EditText firstName;
    @BindView(R.id.last_name)           EditText lastName;
    @BindView(R.id.company_name)        EditText companyName;
    @BindView(R.id.email)               EditText email;
    @BindView(R.id.phone)               EditText phone;
    @BindView(R.id.credit_limit)        EditText creditLimit;
    @BindView(R.id.billing_address)     EditText billingAddress;
    @BindView(R.id.billing_city)        EditText billingCity;
    @BindView(R.id.billing_pincode)     EditText billingPincode;
    @BindView(R.id.delivery_address)    EditText deliveryAddress;
    @BindView(R.id.delivery_city)       EditText deliveryCity;
    @BindView(R.id.delivery_pincode)    EditText deliveryPincode;
    @BindView(R.id.gstn)                EditText gstn;
    @BindView(R.id.same_address)        CheckBox sameAddress;
    @BindView(R.id.security_letter)     CheckBox securityLetter;
    @BindView(R.id.rental_advance)      CheckBox rentalAdvance;
    @BindView(R.id.rental_order)        CheckBox rentalOrder;
    @BindView(R.id.security_cheque)     CheckBox securityCheque;
    @BindView(R.id.login_form)          View mLoginFormView;
    @BindView(R.id.submit_progress)     ProgressBar mProgressView;

    private CustomerAPI customerAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        ButterKnife.bind(this);

        createCustomerAPI();
    }

    private void createCustomerAPI(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

/*        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();*/

        Retrofit retrofit = new Retrofit.Builder()
               // .client(client)
                .baseUrl(CustomerAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        customerAPI = retrofit.create(CustomerAPI.class);
    }

    @OnClick(R.id.submit)
    public void submit() {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String cName = companyName.getText().toString();
        String mail = email.getText().toString();
        String mobile = phone.getText().toString();
        String cLimit = creditLimit.getText().toString();
        String ba = billingAddress.getText().toString();
        String bc = billingCity.getText().toString();
        String bp = billingPincode.getText().toString();
        String da = deliveryAddress.getText().toString();
        String dc = deliveryCity.getText().toString();
        String dp = deliveryPincode.getText().toString();
        String gst = gstn.getText().toString();
        Boolean sl = securityLetter.isChecked();
        Boolean ra = rentalAdvance.isChecked();
        Boolean ro = rentalOrder.isChecked();
        Boolean sc = securityCheque.isChecked();

        boolean cancel = false;
        View focusView = null;

        ArrayList<Pair<String, EditText>> inputs = new ArrayList <Pair <String, EditText> > ();
        inputs.add(new Pair<String, EditText> (fName, firstName));
        inputs.add(new Pair<String, EditText> (lName, lastName));
        inputs.add(new Pair<String, EditText> (cName, companyName));
        inputs.add(new Pair<String, EditText> (ba, billingAddress));
        inputs.add(new Pair<String, EditText> (bc, billingCity));
        inputs.add(new Pair<String, EditText> (da, deliveryAddress));
        inputs.add(new Pair<String, EditText> (dc, deliveryCity));

        for (Pair <String, EditText> temp : inputs){
            String text = temp.first;
            EditText view = temp.second;

            // Check for a valid names.
            if (TextUtils.isEmpty(text)) {
                view.setError(getString(R.string.error_field_required));
                focusView = view;
                cancel = true;
            } else if (!isValidName(mail)) {
                view.setError("Length should be greater than 4");
                focusView = view;
                cancel = true;
            }

        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(mail)) {
            email.setError(getString(R.string.error_field_required));
            focusView = email;
            cancel = true;
        } else if (!isEmailValid(mail)) {
            email.setError(getString(R.string.error_invalid_email));
            focusView = email;
            cancel = true;
        }

        // Check for a valid pincode address.
        if (TextUtils.isEmpty(bp)) {
            billingPincode.setError(getString(R.string.error_field_required));
            focusView = billingPincode;
            cancel = true;
        } else if (!isValidPincode(bp)) {
            billingPincode.setError("Invalid pincode");
            focusView = billingPincode;
            cancel = true;
        }

        if (TextUtils.isEmpty(dp)) {
            deliveryPincode.setError(getString(R.string.error_field_required));
            focusView = deliveryPincode;
            cancel = true;
        } else if (!isValidPincode(bp)) {
            deliveryPincode.setError("Invalid pincode");
            focusView = deliveryPincode;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt submit and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the submit attempt.
            showProgress(true);
            Customer customer = new Customer(fName, lName, cName, mail, mobile, cLimit, ba, bc, bp, da, dc, dp, gst);

            customerAPI.createCustomer(customer).enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {
                    Log.e("Response", response.toString());
                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {
                    showProgress(false);
                }

            });
        }
    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isValidPincode(String pincode){
        return pincode.length()==6;
    }

    private boolean isValidName(String name) {
        return name.length()>4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}