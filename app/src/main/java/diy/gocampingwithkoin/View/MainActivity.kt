package diy.gocampingwithkoin.View

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.PolygonOptions
import diy.gocampingwithkoin.R
import diy.gocampingwithkoin.ViewModel.BaseInfoViewModel
import diy.gocampingwithkoin.ViewModel.ImageUrlViewModel
import diy.gocampingwithkoin.databinding.ActivityMainBinding


import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private val baseInfoViewModel: BaseInfoViewModel by viewModel()
    private val imageUrlViewModel: ImageUrlViewModel by viewModel()
    private lateinit var bindingOfMainActivity: ActivityMainBinding

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingOfMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingOfMainActivity.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)




        baseInfoViewModel.baseItemsFromApi(5,1)

        baseInfoViewModel.baseInfoItems.observe(this){ item->
            Log.d("fefef",item.toString())

        }

        imageUrlViewModel.imageItemsFromApi(5,1,10)

        imageUrlViewModel.imageListItems.observe(this){ item->

        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val seoul = LatLng(37.5665, 126.9780)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 7.0f))

        addImageOverlay()
        drawPolygon()

        mMap.setOnPolygonClickListener {polygon->
            Toast.makeText(this, "폴리곤 클릭됨", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addImageOverlay() {
        val bounds = LatLngBounds(
            LatLng(33.0, 124.6), // 대한민국 남서쪽 좌표
            LatLng(39.0, 131.87)  // 대한민국 북동쪽 좌표
        )

        val overlayOptions = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.koreamap)) // 이미지 리소스
            .positionFromBounds(bounds)
            .transparency(0.5f) // 투명도 설정

        mMap.addGroundOverlay(overlayOptions)


    }
    private fun drawPolygon() {
        val polygonOptions = PolygonOptions()
            .add(
                LatLng(37.3998, 126.6505),
                LatLng(36.9896, 129.4178),
                LatLng(35.1032, 129.0407),
                LatLng(37.5, 127.3),
                LatLng(37.6, 128.4)
            )
            .strokeColor(Color.RED)
            .fillColor(Color.argb(50, 255, 0, 0)) // 투명한 빨간색

        mMap.addPolygon(polygonOptions)
    }


}

