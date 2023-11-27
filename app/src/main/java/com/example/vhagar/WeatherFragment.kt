package com.example.vhagar

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.airbnb.lottie.LottieAnimationView
import com.example.vhagar.databinding.ActivityMainBinding
import com.example.vhagar.databinding.FragmentMainBinding
import com.example.vhagar.databinding.FragmentWeatherBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


//ab6ddd883e4b448bf6a6e00688aad6f8
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchWeatherData("jaipur")
//        SearchCity()
    }
//
//    private fun SearchCity() {
//        val searchView = binding.searchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (query != null) {
//                    fetchWeatherData(query)
//                }
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Handle text change if needed
//                return true
//            }
//        })
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        val view = binding.root
//        val lottieAnimationView: LottieAnimationView = binding.lottieAnimationView
//        lottieAnimationView.playAnimation()

        return view
    }
    private fun fetchWeatherData(city:String){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)
        val response = retrofit.getWeatherData(city, appid = "ab6ddd883e4b448bf6a6e00688aad6f8", units = "metric" )
        response.enqueue(object :Callback<Weather>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val responseBody = response.body()

                if (response.isSuccessful){
                    val temperature = responseBody?.main?.temp.toString()
                    val humidity = responseBody?.main?.humidity
                    val windSpeed = responseBody?.wind?.speed
                    val sunrise = responseBody?.sys?.sunrise
                    val sunset = responseBody?.sys?.sunset
                    val sea = responseBody?.main?.pressure
                    val conditions = responseBody?.weather?.firstOrNull()?.main?: "unknown"
                    val maxTemp = responseBody?.main?.temp_max
                    val minTemp = responseBody?.main?.temp_min
                    binding.temp.text = "$temperature *C"
                    binding.weather.text = conditions
                    binding.maxTemp.text = "Max Temp: $maxTemp *C"
                    binding.minTemp.text = "Min Temp: $minTemp *C"
                    binding.humidity.text = "$humidity"
                    binding.windspeed.text = "$windSpeed m/s"
                    binding.sunrise.text = "$sunrise"
                    binding.sunset.text = "$sunset"
                    binding.sea.text = "$sea hPa"
                    binding.conditions.text = conditions
                    binding.date.text =date()
                        binding.textView3.text = dayName(System.currentTimeMillis())

                    binding.city.text = "$city"


                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    private fun date(): String{
        val sdf = SimpleDateFormat("dd MMMM yyyy" , Locale.getDefault())
//        val sdf = SimpleDateFormat(pattern:"dd MMMM yyyy", Locale.getDefault())
        return sdf.format((Date()))
    }
    fun dayName(timestamp: Long): String{
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format((Date()))
    }



}


