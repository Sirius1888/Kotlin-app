package com.example.firstapp.test_di

import android.content.Context

/**
 * Created by Karukes Sergey on
 */
class PeopleInfo(pref: SharedPref, car: Car) {


}


class SharedPref(var context: Context) {
    /*
    MAGIC
     */
}

class Car(var engine: EngineCar, var value: ValueEngine) {
    /*
    MAGIC
     */
}


class EngineCar(var context: Context) {
    /*
    MAGIC
     */
}

class ValueEngine() {

    /*
    MAGIC
     */
}