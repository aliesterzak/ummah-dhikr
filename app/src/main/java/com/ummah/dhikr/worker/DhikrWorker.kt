package com.ummah.dhikr.worker
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.*
class DhikrWorker(ctx:Context, params:WorkerParameters): CoroutineWorker(ctx, params){
 override suspend fun doWork(): Result {
   val nm = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
   val channelId = "ummah_dhikr_daily"
   if (android.os.Build.VERSION.SDK_INT >= 26){
     nm.createNotificationChannel(NotificationChannel(channelId, "Ummah Dhikr", NotificationManager.IMPORTANCE_HIGH))
   }
   val notif = NotificationCompat.Builder(applicationContext, channelId)
     .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
     .setContentTitle("Time to remember the Ummah ﷺ")
     .setContentText("Your istighfar reaches billions - living & dead. Tap to make dhikr now.")
     .setAutoCancel(true).build()
   nm.notify(1, notif)
   return Result.success()
 }
 companion object {
   fun scheduleDaily(context: Context, hour:Int, minute:Int){
     val now = java.util.Calendar.getInstance()
     val target = java.util.Calendar.getInstance().apply{ set(java.util.Calendar.HOUR_OF_DAY, hour); set(java.util.Calendar.MINUTE, minute); set(java.util.Calendar.SECOND,0) }
     if(target.before(now)) target.add(java.util.Calendar.DAY_OF_YEAR,1)
     val delay = target.timeInMillis - now.timeInMillis
     val periodic = PeriodicWorkRequestBuilder<DhikrWorker>(24, java.util.concurrent.TimeUnit.HOURS).setInitialDelay(delay, java.util.concurrent.TimeUnit.MILLISECONDS).build()
     WorkManager.getInstance(context).enqueueUniquePeriodicWork("daily_ummah", ExistingPeriodicWorkPolicy.UPDATE, periodic)
   }
 }
}
