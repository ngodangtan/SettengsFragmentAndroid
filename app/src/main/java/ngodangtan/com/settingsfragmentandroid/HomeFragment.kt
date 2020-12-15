package ngodangtan.com.settingsfragmentandroid

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_settings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        loadSettings()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadSettings(){

        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        val signature = sp.getString("signature","")
        val reply = sp.getString("reply","")
        val sync = sp.getBoolean("sync",false)
        val notifications = sp.getBoolean("notifications",false)
        val volume = sp.getInt("volume_notifications",0)

        tv_signature.text = "Signature: $signature"
        tv_reply.text = "Default reply: $reply"
        tv_sync.text = "Sync: $sync"
        tv_notifications.text = "Disable notifications: $notifications"

        pb_volume.setProgress(volume, true)
    }


}