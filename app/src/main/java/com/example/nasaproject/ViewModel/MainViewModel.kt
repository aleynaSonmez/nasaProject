package com.example.nasaproject.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaproject.Model.RoverJson
import com.example.nasaproject.Services.ApiServices
import com.example.nasaproject.View.CuriosityFragment
import com.example.nasaproject.View.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    private val nasaApiServices = ApiServices()
    private val disposable = CompositeDisposable()
    val nasa_data = MutableLiveData<RoverJson>()
    val nasa_error = MutableLiveData<Boolean>()
    val nasa_load = MutableLiveData<Boolean>()

     fun getDataFromApi() {
        nasa_load.value = true
        disposable.add(
            nasaApiServices.getDataServices()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<RoverJson>() {

                    override fun onError(e: Throwable) {
                        nasa_error.value = true
                        nasa_load.value = false
                        Log.e(TAG, "onError:" + e)
                    }

                    override fun onSuccess(t: RoverJson) {
                        nasa_data.value = t
                        nasa_error.value = false
                        nasa_load.value = false
                        Log.d(TAG, "OnSucces: Success")
                    }

                })
        )
    }

   fun getDataFromApiS() {
        nasa_load.value = true
        disposable.add(
            nasaApiServices.getDataServicesS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<RoverJson>() {

                    override fun onError(e: Throwable) {
                        nasa_error.value = true
                        nasa_load.value = false
                        Log.e(TAG, "onError:" + e)
                    }

                    override fun onSuccess(t: RoverJson) {
                        nasa_data.value = t
                        nasa_error.value = false
                        nasa_load.value = false
                        Log.d(TAG, "OnSucces: Success")
                    }

                })
        )
    }
    fun getDataFromApi0() {
        nasa_load.value = true
        disposable.add(
            nasaApiServices.getDataServicesO()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<RoverJson>() {

                    override fun onError(e: Throwable) {
                        nasa_error.value = true
                        nasa_load.value = false
                        Log.e(TAG, "onError:" + e)
                    }

                    override fun onSuccess(t: RoverJson) {
                        nasa_data.value = t
                        nasa_error.value = false
                        nasa_load.value = false
                        Log.d(TAG, "OnSucces: Success")
                    }

                })
        )
    }
}
