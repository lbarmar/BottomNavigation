package dam.pmdm.bottomnavigation

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dam.pmdm.bottomnavigation.databinding.FragmentMapBinding

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val latlng = LatLng(36.83, -2.45)
        googleMap.addMarker(MarkerOptions()
            .position(latlng)
            .title("Marcador")
            .contentDescription("Aqui estoy yo")
        )

        googleMap.addCircle(CircleOptions()
            .center(latlng)
            .radius(500.0) //en metros
            .strokeColor(Color.GREEN)
            .strokeWidth(5f)
            .fillColor(Color.argb(100, 0, 255, 0))
        )

//        Zoom 2.0: globo terraqueo / 10.0: ciudad. / 15.0: calles, edificios / 20.0 a 21.0: máximo.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f))
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }
}

