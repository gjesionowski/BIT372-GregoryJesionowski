package com.example.eventlistmvvm;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eventlistmvvm.roomdb.Event;

import java.util.List;

public class EventListViewModel extends ViewModel {
    // Only created if MutableLiveData eventsData is null
    private MutableLiveData<List<Event>> eventsData;
    private EventRepository repository;

    public void init(Context context){
        if (eventsData == null){
            eventsData = new MutableLiveData<>();
        }
        repository = EventRepository.getInstance(context);
        eventsData.setValue(repository.getEvents());
    }

    public MutableLiveData<List<Event>> getEvents() {
        eventsData.setValue(repository.getEvents());
        return eventsData;
    }
}
