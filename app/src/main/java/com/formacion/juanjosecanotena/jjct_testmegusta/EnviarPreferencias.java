package com.formacion.juanjosecanotena.jjct_testmegusta;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cice on 1/4/17.
 */

public class EnviarPreferencias extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        String str_dev = null;
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        String urlPost = "http://femxa-ebtm.rhcloud.com/CalcularLetraDni";
        String mensaje_json = strings[0];
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        try {

            url = new URL(urlPost);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");

            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(mensaje_json);
            outputStreamWriter.close();

            int response_code = httpURLConnection.getResponseCode();
            if(response_code == HttpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                str_dev = bufferedReader.readLine();
            }


        }catch(Throwable t){
            Log.e(getClass().getCanonicalName(), "Error: " + t);
        }finally {
            httpURLConnection.disconnect();
        }


        return str_dev;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
