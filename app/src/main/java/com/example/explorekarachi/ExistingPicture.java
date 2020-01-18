package com.example.explorekarachi;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.cloudinary.android.preprocess.BitmapDecoder;
import com.cloudinary.android.preprocess.BitmapEncoder;
import com.cloudinary.android.preprocess.DimensionsValidator;
import com.cloudinary.android.preprocess.ImagePreprocessChain;
import com.cloudinary.android.preprocess.Limit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ExistingPicture extends AppCompatActivity {


    private static final String TAG = "searchApp";
    static String result = null;
    Integer responseCode = null;
    String responseMessage = "";

    static int REQUEST_CODE = 7;
    private ImageView imageView;
    private TextView textView;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_picture);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                Uri imageUri = data.getData();
                if (imageUri != null) {
                    path = getPathFromURI(imageUri);
                    imageView.setImageURI(imageUri);
                    uploadToCloud();
                }
            }
        }
    }


    public String getPathFromURI(Uri imageUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(imageUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


    public String searchGoogle(String cloudURL) {
        String searchURL = "http://www.google.com/searchbyimage?image_url=" + cloudURL;
        Connection connect = Jsoup.connect(searchURL);
        connect.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
        connect.timeout(30000);
        try {
            Document document = connect.get();
            Element div = document.getElementsByClass("r5a77d").get(0);
            final String answer = div.getElementsByTag("a").get(0).text();
            return answer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "nothing";
    }

    public void uploadToCloud() {
        Transformation tr = new Transformation();
        tr.crop("fit").width(100).angle(90);
        String requestId = MediaManager.get().upload(path).preprocess(new ImagePreprocessChain()
                .loadWith(new BitmapDecoder(1000, 1000))
                .addStep(new Limit(1000, 1000))
                .addStep(new DimensionsValidator(10, 10, 1000, 1000))
                .saveWith(new BitmapEncoder(BitmapEncoder.Format.WEBP, 80))).callback(new UploadCallback() {
            @Override
            public void onStart(String requestId) {

            }

            @Override
            public void onProgress(String requestId, long bytes, long totalBytes) {

            }

            @Override
            public void onSuccess(String requestId, Map resultData) {
                String cloudURL = resultData.get("url").toString();
                textView.setText(cloudURL);
                if (cloudURL != null)
                    new Scraper().execute(cloudURL);
                else {
                    Log.d("MYTAG", "URL is null");
                }
            }

            @Override
            public void onError(String requestId, ErrorInfo error) {
                Log.d("MYTAG", error.getDescription());
            }

            @Override
            public void onReschedule(String requestId, ErrorInfo error) {

            }
        }).dispatch(getApplicationContext());
        Log.d("MYTAG", requestId);

    }

    private class Scraper extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.d("MYTAG", "In async task");
            return searchGoogle(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("MYTAG", s);
            textView.setText(s);
        }
    }

    public void doit(View view) {
        String sometext = textView.getText().toString();

        textView.setText("Searching for : ");

        // hide keyboard
//        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        // looking for
        String searchStringNoSpaces = sometext.replace(" ", "+");

        // Your API key
        // TODO replace with your value
        String key = "AIzaSyDKw94WUgk9VyCrs-qGTOywlC9qcc6mcKk";

        // Your Search Engine ID
        // TODO replace with your value
        String cx = "016823726179897631430:enfz3onc8zj";

        String urlString = "https://www.googleapis.com/customsearch/v1?q=" + searchStringNoSpaces + "&key=" + key + "&cx=" + cx + "&alt=json";
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            //Log.e(TAG, "ERROR converting String to URL " + e.toString());
        }
        ///Log.d(TAG, "Url = "+  urlString);


        // start AsyncTask
        ExistingPicture.GoogleSearchAsyncTask searchTask = new ExistingPicture.GoogleSearchAsyncTask();
        searchTask.execute(url);


    }

    private class GoogleSearchAsyncTask extends AsyncTask<URL, Integer, String> {

        protected void onPreExecute() {
            //Log.d(TAG, "AsyncTask - onPreExecute");
            // show progressbar
            //      progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(URL... urls) {

            URL url = urls[0];
            ///Log.d(TAG, "AsyncTask - doInBackground, url=" + url);

            // Http connection
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                //Log.e(TAG, "Http connection ERROR " + e.toString());
            }


            try {
                responseCode = conn.getResponseCode();
                responseMessage = conn.getResponseMessage();
            } catch (IOException e) {
                Log.e(TAG, "Http getting response code ERROR " + e.toString());
            }

            Log.d(TAG, "Http response code =" + responseCode + " message=" + responseMessage);

            try {

                if (responseCode == 200) {

                    // response OK

                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;

                    while ((line = rd.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    rd.close();

                    conn.disconnect();

                    result = sb.toString();

                    Log.d(TAG, "result=" + result);

                    return result;

                } else {

                    // response problem

                    String errorMsg = "Http ERROR response " + responseMessage + "\n" + "Make sure to replace in code your own Google API key and Search Engine ID";
                    Log.e(TAG, errorMsg);
                    result = errorMsg;
                    return result;

                }
            } catch (IOException e) {
                Log.e(TAG, "Http Response ERROR " + e.toString());
            }


            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
            Log.d(TAG, "AsyncTask - onProgressUpdate, progress=" + progress);

        }

        protected void onPostExecute(String result) {

            Log.d(TAG, "AsyncTask - onPostExecute, result=" + result);

            // hide progressbar
            String oneObjectsItem = new String();
//            progressBar.setVisibility(View.GONE);

            // make TextView scrollable
            textView.setMovementMethod(new ScrollingMovementMethod());
            // show result
            ///        check.setMovementMethod(new ScrollingMovementMethod());

            //     check.setText(result);
            //  System.out.println("this is result"+result );

            try {
                JSONObject jobject = new JSONObject(result);
                JSONArray jArray = jobject.getJSONArray("items");
//                String item_string = (String) jobject.get("items");

                JSONObject oneObject = jArray.getJSONObject(0);
                oneObjectsItem = oneObject.getString("snippet");
                System.out.println("" + oneObjectsItem);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            Toast.makeText(ExistingPicture.this, " " + oneObjectsItem, Toast.LENGTH_LONG).show();

            //resultTextView.setText(result);
            textView.setText(oneObjectsItem);


        }

    }
}

