package com.example.sample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.looperex.calenderview.calendardayview.CalendarDayView
import com.looperex.calenderview.calendardayview.EventView
import com.looperex.calenderview.calendardayview.PopupView
import com.looperex.calenderview.calendardayview.data.IEvent
import com.looperex.calenderview.calendardayview.data.IPopup

import com.looperex.calenderview.calendardayview.decoration.CdvDecorationDefault
import java.util.*

class MainActivity : AppCompatActivity() {
    var dayView: CalendarDayView? = null
    var events: ArrayList<IEvent>? = null
    var popups: ArrayList<IPopup>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        dayView = findViewById(R.id.dayView)
//        dayView!!.setLimitTime(9, 22)
        (dayView!!.decoration as CdvDecorationDefault).setOnEventClickListener(
            object : EventView.OnEventClickListener {
                override fun onEventClick(view: EventView?, data: IEvent?) {
//                    Log.e("TAG", "onEventClick:" + data!!.name)
                    Toast.makeText(this@MainActivity,"Alredy Booked",Toast.LENGTH_SHORT).show()
                }

                override fun onEventViewClick(view: View?, eventView: EventView?, data: IEvent?) {
//                    Log.e("TAG", "onEventViewClick:" + data!!.name)
//                    Toast.makeText(this@MainActivity1,data.name,Toast.LENGTH_SHORT).show()
                    Toast.makeText(this@MainActivity,"Alredy Booked",Toast.LENGTH_SHORT).show()
                    if (data is Event) {
                        // change event (ex: set event color)
                        dayView!!.setEvents(events)
                    }
                }
            })
        (dayView!!.decoration as CdvDecorationDefault).setOnPopupClickListener(
            object : PopupView.OnEventPopupClickListener {
                override fun onPopupClick(view: PopupView?, data: IPopup?) {
                    Log.e("TAG", "onPopupClick:" + data!!.title)
                    Toast.makeText(this@MainActivity,data.title,Toast.LENGTH_SHORT).show()
                }

                override fun onQuoteClick(view: PopupView?, data: IPopup?) {
                    Log.e("TAG", "onQuoteClick:" + data!!.title)
                    Toast.makeText(this@MainActivity,data.title,Toast.LENGTH_SHORT).show()
                }

                override fun onLoadData(
                    view: PopupView?, start: ImageView?, end: ImageView?,
                    data: IPopup?
                ) {
//                    start.setImageResource(R.drawable.avatar)
                }
            })
        events = ArrayList<IEvent>()
            val timeStart = Calendar.getInstance()
            timeStart[Calendar.HOUR_OF_DAY] = 11
            timeStart[Calendar.MINUTE] = 0
            val timeEnd = timeStart.clone() as Calendar
            timeEnd[Calendar.HOUR_OF_DAY] = 15
            timeEnd[Calendar.MINUTE] = 30
            val event = Event(timeStart, timeEnd)
            events!!.add(event)
        run {
            val timeStart = Calendar.getInstance()
            timeStart[Calendar.HOUR_OF_DAY] = 18
            timeStart[Calendar.MINUTE] = 0
            val timeEnd = timeStart.clone() as Calendar
            timeEnd[Calendar.HOUR_OF_DAY] = 20
            timeEnd[Calendar.MINUTE] = 30
            val event = Event(timeStart, timeEnd, )
            events!!.add(event)
        }
        popups = ArrayList<IPopup>()
        run {
            val timeStart = Calendar.getInstance()
            timeStart[Calendar.HOUR_OF_DAY] = 12
            timeStart[Calendar.MINUTE] = 0
            val timeEnd = timeStart.clone() as Calendar
            timeEnd[Calendar.HOUR_OF_DAY] = 13
            timeEnd[Calendar.MINUTE] = 30
            val popup = Popup()
            popup.startTime = timeStart
            popup.endTime = timeEnd
            popup.title = "Your Booking"
            popup.description = "#48478"
            popups!!.add(popup)
        }
        run {
            val timeStart = Calendar.getInstance()
            timeStart[Calendar.HOUR_OF_DAY] = 20
            timeStart[Calendar.MINUTE] = 0
            val timeEnd = timeStart.clone() as Calendar
            timeEnd[Calendar.HOUR_OF_DAY] = 22
            timeEnd[Calendar.MINUTE] = 0
            val popup = Popup()
            popup.startTime = timeStart
            popup.endTime = timeEnd
            popup.title = "Your Booking"
            popup.description = "#54564"
            popups!!.add(popup)
        }
        dayView!!.setEvents(events)
        dayView!!.setPopups(popups)
    }
}