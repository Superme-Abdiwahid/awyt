
package edu.uw.abdiwahid.awyt

import android.annotation.TargetApi
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
import android.os.Build
import android.telephony.SmsMessage
import androidx.annotation.BoolRes
import androidx.annotation.DisplayContext
import androidx.annotation.DrawableRes
import androidx.annotation.MainThread
import androidx.core.text.util.LinkifyCompat
import androidx.core.view.WindowInsetsAnimationCompat
import org.intellij.lang.annotations.Pattern
import java.lang.annotation.Native





class IntentListener: BroadcastReceiver() {
    init {
        Log.i("ABDIWAHID", "We created YYEEYEYE!!")
    }

    @TargetApi(Build.VERSION_CODES.M)
    @MainThread
    @SuppressWarnings("unknown")
    @Suppress
    @DisplayContext

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Alarm Ringing...", Toast.LENGTH_SHORT).show()
    }
}

    @MainThread
    @DisplayContext
    class MainActivity : AppCompatActivity() {
        private var result: String = "";

        @ExperimentalMultiplatform
        @MainThread
        @SuppressWarnings("unknown")
        @Suppress
        override fun onCreate(savedInstanceState: Bundle?) {
            val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
            val pendingIntent =
                PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_NO_CREATE)
            if (pendingIntent != null && alarmManager != null) {
                alarmManager.cancel(pendingIntent)
            }


            val broadCastIntent: Intent = Intent(this, IntentListener::class.java);
            val intent = PendingIntent.getBroadcast(
                this, 0, intent, 0
            );
            var alarmManager2: AlarmManager =
                getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager2.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                AlarmManager.INTERVAL_HOUR, pendingIntent
            );
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            var start: Button = findViewById<Button>(R.id.begin)

            var stop: Button = findViewById<Button>(R.id.stop)

            var message: EditText = findViewById<EditText>(R.id.editTextTextPersonName)


            stop.visibility = View.INVISIBLE


            val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val recived = Intent(this, IntentListener::class.java)
            var phone: EditText = findViewById<EditText>(R.id.editTextPhone)


            phone.setOnClickListener() {
                result = produceNumber(phone.text.toString())
                Toast.makeText(this, "Your number is: ${result}", Toast.LENGTH_LONG)
                Log.i("Abdiwahid", result)
            }

            Toast.makeText(this, "Your number is: ${result}", Toast.LENGTH_LONG)

        }

        @ExperimentalMultiplatform
        @MainThread
       @SuppressWarnings("unknown")
       @Suppress
        @Deprecated("unknown")
        fun produceNumber(phoneNumber: String): String {
            var phone = ""
            var builder: StringBuilder = StringBuilder(10);
            if (phoneNumber.length == 10) {
                builder.append("(" + phoneNumber.substring(0, 3) + ")" + "-");
                builder.append(phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10))
                return builder.toString()
            }

            return "This is a  invalid number must be 10 digits";
        }
    }
