package com.nishajain.fragmentskotlin.Notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.nishajain.fragmentskotlin.R

class NotificationActivity : AppCompatActivity() {
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "1000"
    private val description = "Kotlin Demo Notification"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val btn = findViewById<Button>(R.id.btn)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager

        btn.setOnClickListener {
            val intent = Intent(this, AfterNotification::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.lightColor = Color.BLUE
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)
                builder = Notification.Builder(this, channelId).setContentTitle(
                    "Notification Alert "
                ).setContentText("Kotlin Demo Notification")
                    .setSmallIcon(R.drawable.ic_baseline_settings_24).setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources, R.drawable
                                .ic_launcher_background
                        )
                    ).setContentIntent(pendingIntent)
            }
            notificationManager.notify(1000, builder.build())
        }
    }
}