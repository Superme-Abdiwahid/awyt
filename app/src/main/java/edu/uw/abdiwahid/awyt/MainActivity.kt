package edu.uw.abdiwahid.awyt

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import java.lang.StringBuilder

class IntentListener: BroadcastReceiver(){
    init{
        Log.i("ABDIWAHID", "We created YYEEYEYE!!")
    }
    override fun onReceive(p0: Context?, p1: Intent?) {



    }
}
class MainActivity : AppCompatActivity() {
    private var result: String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var start: Button = findViewById<Button>(R.id.begin)

        var stop: Button = findViewById<Button>(R.id.stop)

        var message: EditText = findViewById<EditText>(R.id.editTextTextPersonName)


      stop.visibility = View.INVISIBLE

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        val time = System.currentTimeMillis()+ (5 * 1000)
        val intent = Intent("HELLO")
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent)
        }

        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val recived = Intent(this, IntentListener::class.java)
        var phone: EditText = findViewById<EditText>(R.id.editTextPhone)


        phone.setOnClickListener(){
            result = produceNumber(phone.text.toString())
            Toast.makeText(this, "Your number is: ${result}", Toast.LENGTH_LONG )
            Log.i("Abdiwahid", result)
        }

        Toast.makeText(this, "Your number is: ${result}", Toast.LENGTH_LONG )

    }




    fun produceNumber(phoneNumber: String): String {
        var phone = ""
       var  builder: StringBuilder = StringBuilder(10);
        if(phoneNumber.length == 10) {
            builder.append("(" + phoneNumber.substring(0,3) + ")" + "-");
            builder.append(phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6, 10))
            return builder.toString()
        }

            return "This is a  invalid number must be 10 digits";
    }
}