package com.example.hvn15.shownotifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//plan: subscribe to tv series if exists, and save them on firebase.
// show pictures of the tv-show on the profile / or other info, and also if boolean named isSoon is false tell user series is not active.
// if there is an episode the next 7 days, set a timer for a notificaiton.
// else set some boolean to false, so that next time you open the app it will check again.
public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.themoviedb.org/";
    public static final String API_KEY = BuildConfig.APIKEY;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyApiEndpointInterface apiService =
                retrofit.create(MyApiEndpointInterface.class);
        /*Call<List<Country>> call = apiService.getUser(API_KEY);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<User>> response) {
                text.setText("name are: ");
                for(int i = 0; i < response.body().size(); i++){
                    text.append(response.body().get(i).getEnglish_name() + ",");
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
               text.setText(t.getMessage());
            }
        });*/
        Call<Movie> call2 = apiService.getMovie(API_KEY, "eng", "harry potter", 1, false);
        call2.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                for(int i = 0; i < response.body().getResults().size(); i++){
                    text.append("movie nr " + i + ": " + response.body().getResults().get(i).getRelease_date() + "\n");
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }

}


