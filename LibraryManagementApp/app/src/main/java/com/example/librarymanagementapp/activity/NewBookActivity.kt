package com.example.librarymanagementapp.activity

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.*
import com.example.librarymanagementapp.R
import com.example.librarymanagementapp.book.AdminDashboard
import com.example.librarymanagementapp.book.BookList


// acept a word from the user...
class NewBookActivity : AppCompatActivity() {

    // declaring variables
    private lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)
        val editBookView = findViewById<EditText>(R.id.editTextbookName)
        val editBookNumber = findViewById<EditText>(R.id.editTextbookNumber)
        val editAuthor = findViewById<EditText>(R.id.editTextAuthorName)
        val editQuantity = findViewById<EditText>(R.id.editTextQuantity)
        val backBtn = findViewById<ImageButton>(R.id.back_button)


        val button = findViewById<Button>(R.id.addBookButton)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editBookView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val bookName = editBookView.text.toString()
                val quantity : Editable? = editQuantity.text
                val author = editAuthor.text.toString()
                val bookNumber : Editable? = editBookNumber.text

                println("Quantity: $quantity")
                replyIntent.putExtra("bookName", bookName)
                replyIntent.putExtra("quantity", quantity.toString())
                replyIntent.putExtra("author", author)
                replyIntent.putExtra("bookNumber", bookNumber.toString())
                setResult(Activity.RESULT_OK, replyIntent)

                notification(bookName)

            }

            finish()
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, BookList::class.java)
            startActivity(intent)
        }
    }

    private fun notification(bookName: String){

        // it is a class to notify the user of events that happen.
        // This is how you tell the user that something has happened in the
        // background.
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // onClick listener for the button
        // pendingIntent is an intent for future use i.e after
        // the notification is clicked, this intent will come into action
        val intent = Intent(this, AfterNotification::class.java)

        // FLAG_UPDATE_CURRENT specifies that if a previous
        // PendingIntent already exists, then the current one
        // will update it with the latest intent
        // 0 is the request code, using it later with the
        // same method again will get back the same pending
        // intent for future reference
        // intent passed here is to our afterNotification class
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        // RemoteViews are used to use the content of
        // some different layout apart from the current activity layout
        val contentView = RemoteViews(packageName, R.layout.activity_after_notification)

        // checking if android version is greater than oreo(API 26) or not
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setContent(contentView)
                .setSmallIcon(R.drawable.libraryiconmodified)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.libraryiconmodified))
                .setStyle(Notification.BigTextStyle().setBigContentTitle("New Book with name $bookName Added..!!!"))
                .setContentIntent(pendingIntent)

        } else {

            builder = Notification.Builder(this)
                .setContent(contentView)
                .setSmallIcon(R.drawable.libraryiconmodified)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.libraryiconmodified))
                .setStyle(Notification.BigTextStyle().setBigContentTitle("New Book with name $bookName Added..!!!"))
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234, builder.build())

    }
}
