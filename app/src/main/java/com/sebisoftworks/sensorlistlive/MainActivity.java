package com.sebisoftworks.sensorlistlive;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    ArrayList<String[]> mData;
    MyAdapter mMyAdapter;
    HashMap<Sensor, Integer> pos;

    //TEST
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = new ArrayList<String[]>();
        pos = new HashMap<Sensor, Integer>();
        List<Sensor> sensors;
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sm.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensors.size(); i++) {
            String[] s = new String[5];
            Sensor sensor = sensors.get(i);
            s[0] = sensor.getName();
            s[1] = sensor.getPower() + "";
            s[2] = sensor.getVendor();
            s[3] = sensor.getMaximumRange() + "";
            s[4] = "0";
            pos.put(sensor, i);
            mData.add(s);
            sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        System.out.println("collected Data");
        mMyAdapter = new MyAdapter(mData);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mMyAdapter);
    }

    public void onSensorChanged(SensorEvent event) {
        int index = pos.get(event.sensor);
        String[] newData = mData.get(index);
        newData[4] = event.values[0] + "";
        mData.set(index, newData);
        mMyAdapter.notifyDataSetChanged();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
