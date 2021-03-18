package app.simple.positional.dialogs.compass

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import app.simple.positional.BuildConfig
import app.simple.positional.R
import app.simple.positional.decorations.views.CustomBottomSheetDialogFragment
import app.simple.positional.preference.CompassPreference.isFlowerBloomOn
import app.simple.positional.preference.CompassPreference.setDirectionCode
import app.simple.positional.preference.CompassPreference.setFlowerBloom
import app.simple.positional.ui.Compass
import java.lang.ref.WeakReference

class CompassMenu(private val weakReference: WeakReference<Compass>) : CustomBottomSheetDialogFragment() {

    private lateinit var toggleFlower: SwitchCompat
    private lateinit var toggleCode: SwitchCompat
    private lateinit var bloomText: TextView
    private lateinit var blooms: TextView
    private lateinit var bloomSwitchContainer: LinearLayout
    private lateinit var codeSwitchContainer: LinearLayout
    private lateinit var speed: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_compass_menu, container, false)

        toggleFlower = view.findViewById(R.id.toggle_flower)
        toggleCode = view.findViewById(R.id.toggle_code)
        bloomText = view.findViewById(R.id.compass_bloom_text)
        blooms = view.findViewById(R.id.compass_bloom_skins_text)
        bloomSwitchContainer = view.findViewById(R.id.bloom_switch_container)
        codeSwitchContainer = view.findViewById(R.id.compass_menu_show_code)
        speed = view.findViewById(R.id.compass_speed)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (BuildConfig.FLAVOR != "lite") {
            toggleFlower.isChecked = isFlowerBloomOn()
        } else {
            bloomText.setTextColor(Color.GRAY)
            blooms.setTextColor(Color.GRAY)
        }

        toggleFlower.setOnCheckedChangeListener { _, isChecked ->
            if (BuildConfig.FLAVOR != "lite") {
                weakReference.get()?.setFlower(isChecked)
                setFlowerBloom(isChecked)
            } else {
                Toast.makeText(requireContext(), R.string.only_full_version, Toast.LENGTH_SHORT).show()
                toggleFlower.isChecked = false
            }
        }

        blooms.setOnClickListener {
            if (BuildConfig.FLAVOR != "lite") {
                val compassBloom = CompassBloom(weakReference)
                compassBloom.show(parentFragmentManager, "null")
            } else {
                Toast.makeText(requireContext(), R.string.only_full_version, Toast.LENGTH_SHORT).show()
                toggleFlower.isChecked = false
            }
        }

        bloomSwitchContainer.setOnClickListener {
            if (BuildConfig.FLAVOR != "lite") {
                toggleFlower.isChecked = !toggleFlower.isChecked
            } else {
                Toast.makeText(requireContext(), R.string.only_full_version, Toast.LENGTH_SHORT).show()
                toggleFlower.isChecked = false
            }
        }

        codeSwitchContainer.setOnClickListener {
            toggleCode.isChecked = !toggleCode.isChecked
        }

        toggleCode.setOnCheckedChangeListener { _, isChecked ->
            weakReference.get()?.showDirectionCode = isChecked
            setDirectionCode(isChecked)
        }

        speed.setOnClickListener {
            val compassSpeed = WeakReference(CompassSpeed(weakReference))
            compassSpeed.get()?.show(parentFragmentManager, "null")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        weakReference.clear()
    }
}
