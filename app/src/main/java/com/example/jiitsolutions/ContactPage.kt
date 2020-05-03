package com.example.jiitsolutions

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_contact_page.*
import java.util.*
import kotlin.random.Random.Default.nextInt

class ContactPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var googleMap: GoogleMap
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_page)

        contribute.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/jmZDrJHFky7LRqK99"))
            startActivity(i)
        }
        val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback{
            googleMap = it
            val location1 = LatLng(28.6297, 77.3721)
            googleMap.addMarker(MarkerOptions().position(location1))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 15F))
        })
        btn_snd_msg.setOnClickListener {
            val message : String= usr_msg.text.toString()
            val intent = Intent()
            val ran = (0..20).random()
            intent.action= Intent.ACTION_VIEW
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type= "text/plain"
            if(ran%2==0) {
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+917060222315" + "&text=" + message))
            }
            else if(ran%3==0){
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+919027553376" + "&text=" + message))
            }
            else if(ran%5==0){
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+918171907780" + "&text=" + message))
            }
            else if(ran%7==0){
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+917895833794" + "&text=" + message))
            }
            else
            {
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+917060222315" + "&text=" + message))

            }

            startActivity(intent)
        }
    }
}
