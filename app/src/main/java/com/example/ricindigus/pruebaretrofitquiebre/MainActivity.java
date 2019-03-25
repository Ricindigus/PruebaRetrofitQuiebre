package com.example.ricindigus.pruebaretrofitquiebre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.boton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
                httpClientBuilder.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .addHeader("Authorization",
                                        "Basic " + Base64.encodeToString("qallarix:cWFsbGFyaXgqbW92aXN0YXI=".getBytes(),Base64.NO_WRAP))
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                });

                Retrofit retrofit = new Retrofit.Builder()
                        .client(httpClientBuilder.build())
                        .baseUrl("https://tomcat-qallarix-dev.mybluemix.net/ambassador/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                WebServiceApi webServiceApi = retrofit.create(WebServiceApi.class);

                Call<Quiebre> call = webServiceApi.setQuiebre(new Quiebre(
                        "10586325",
                       "dsiancas@urbangolem.com",
                        "Danny Siancas",
                        "999747905",
                        "FIJA",
                        "ALTA",
                        "PEDIDOS",
                        "999747905",
                        "TEST",
                       "10287799",
                     "daxxad@gmail.com",
                       "Marco Basadur",
                         "999747905"
                ));

                call.enqueue(new Callback<Quiebre>() {
                    @Override
                    public void onResponse(Call<Quiebre> call, Response<Quiebre> response) {

                    }

                    @Override
                    public void onFailure(Call<Quiebre> call, Throwable t) {

                    }
                });
            }
        });


    }
}
