package com.aasc.solvecase

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_maths.*
import java.util.*
import kotlin.collections.ArrayList

class PhysicsActivity : AppCompatActivity(), onVideoItemClickListener {

    var video = ArrayList<videoDetailsModel>()
    val displayList = ArrayList<videoDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        video.add(
            videoDetailsModel(
                "Basic idea of Cartesian, cyclindrical coordinate system",
                "zKnVOfWwJqk"
            )
        )
        video.add(videoDetailsModel("Basic idea of spherical coordinate system", "QntdukJzZ8o"))
        video.add(
            videoDetailsModel(
                "Basics of fields, Gradient, Divergence and Curl",
                "TYOYID9gJxM"
            )
        )
        video.add(videoDetailsModel("Coulomb’s law,  & Gauss’s law", "0sAmVEi_6J0"))
        video.add(videoDetailsModel("Electric Flux", "MnvqHrvPq_s"))
        video.add(
            videoDetailsModel(
                "Applications of Gauss law for Spherical and Cylindrical symmetries (all important cases)",
                "JiuwIryf_DI"
            )
        )
        video.add(
            videoDetailsModel(
                "Electric field due to charged conductor, Force per unit area on the surface of the charged conductor",
                "IMf9ZNUYKGk"
            )
        )
        video.add(videoDetailsModel("Laplace and Poisson’s equations", "IVRIw36CAWs"))
        video.add(
            videoDetailsModel(
                "Treatment of electrostatic problems using Laplace and Poisson’s equations in spherical coordinate system",
                "YBW7zHE_rWo"
            )
        )
        video.add(videoDetailsModel("Displacement current", "p0q9PgYoXDc"))
        video.add(
            videoDetailsModel(
                "Maxwell’s equations in free space and dielectric media (both differential and integral forms)",
                "nEVIWCEIDIA"
            )
        )
        video.add(
            videoDetailsModel(
                "Poynting’s theorem (derivation) and Poynting vector",
                "QVaBm56m7k4"
            )
        )
        video.add(
            videoDetailsModel(
                "Electromagnetic waves in free space (equations and solutions) and Transverse nature of EM waves",
                "GbANPADAe1c"
            )
        )
        video.add(
            videoDetailsModel(
                "Energy and momentum in EM waves, Radiation pressure",
                "7__KBSMlypc"
            )
        )
        video.add(
            videoDetailsModel(
                "Propagation of EM waves through boundary, Boundary Conditions across the medium",
                "YbQJspnPm6Q"
            )
        )
        video.add(
            videoDetailsModel(
                "Reflection and Transmission at normal incidence",
                "KOuabBpKxQw"
            )
        )
        video.add(
            videoDetailsModel(
                "Reflection and Transmission at oblique incidence- Laws of Reflection and Refraction",
                "bLAtbCpMo7E"
            )
        )
        video.add(
            videoDetailsModel(
                "Oblique incidence-p polarization, Fresnel’s equations, Brewster’s Law",
                "OgjZj60yt04"
            )
        )
        video.add(
            videoDetailsModel(
                "Concept of optical fiber and Principle of Total Internal Reflection in optical fiber",
                "og_eXK2JoT4"
            )
        )
        video.add(
            videoDetailsModel(
                "Numerical aperture and Single, multistep & graded index fiber",
                "APBxllJokzs"
            )
        )
        video.add(
            videoDetailsModel(
                "Attenuation coefficient Transmission losses in optical fiber",
                "_1QwgTw4NqM"
            )
        )
        video.add(videoDetailsModel("Transmission losses in optical fiber", "N8AB_7cxh0w"))
        video.add(
            videoDetailsModel(
                "Introduction to Statistical Distributions, Maxwell-Boltzmann Statistics (Classical distribution)",
                "Kpu3I7v8vdQ"
            )
        )
        video.add(
            videoDetailsModel(
                "Applications of MB distribution (Distribution of molecular energies in an ideal gas)",
                "ZrThJYLUFv4"
            )
        )
        video.add(
            videoDetailsModel(
                "Distribution of molecular speeds in an ideal gas",
                "IO1zV3TS7Yw"
            )
        )
        video.add(
            videoDetailsModel(
                "Applications of FD distributions (average energy)",
                "RYKsddH-gJo"
            )
        )
        video.add(videoDetailsModel("Electron gas", "cSw2pqfbq3k"))
        video.add(
            videoDetailsModel(
                "Introduction to Laser, spontaneous and stimulated emission, population inversion",
                "G2Mo46eLAFs"
            )
        )
        video.add(
            videoDetailsModel(
                "Einstein A and B coefficients, Principles and working of lasers",
                "-TXR9_-Ixmo"
            )
        )
        video.add(videoDetailsModel("Ruby laser, Applications of lasers", "-CXRBySYhMQ"))
        video.add(
            videoDetailsModel(
                "Basic ideas of Bonding, Ionic bonding, covalent bonding and Metallic Bonding",
                "p9MA6Od-zBA"
            )
        )
        video.add(
            videoDetailsModel(
                "Inter-atomic coulomb forces in ionic crystals and Determination of equilibrium separation",
                "mk0c0ztofNY"
            )
        )
        video.add(
            videoDetailsModel(
                "Minimum Potential energy and determination of Madelung constant ‘α ‘for NaCl crystal in 1D",
                "46ZenVbXgXI"
            )
        )
        video.add(
            videoDetailsModel(
                "Lattice points and space lattice, Basis and crystal structure, Unit cell",
                "tXWUnJuV_N0"
            )
        )
        video.add(
            videoDetailsModel(
                "Primitive cell, Seven crystal systems and Fourteen Bravais space lattice",
                "I8OCIyCNKZQ"
            )
        )
        video.add(
            videoDetailsModel(
                "Coordination number, nearest neighbour distance",
                "hKM6fJrutu4"
            )
        )
        video.add(
            videoDetailsModel(
                "Atomic radius and packing factor in crystal structure",
                "rroulXtAxXk"
            )
        )
        video.add(
            videoDetailsModel(
                "Calculation of lattice constant, Lattice planes and Miller indices",
                "-8N7QTl6zE4"
            )
        )
        video.add(
            videoDetailsModel(
                "Separation between lattice planes, Derivation and examples",
                "ssuCZtS9bAQ"
            )
        )
        video.add(
            videoDetailsModel(
                "X-ray diffraction, Bragg’s law of X- ray diffraction",
                "KtOJd39ANUA"
            )
        )
        video.add(videoDetailsModel("Electronic conduction in metals", "-j1e9NmMO38"))
        video.add(
            videoDetailsModel(
                "Quantum theory of electronic conduction in metals",
                "LDwba7ofORE"
            )
        )
        video.add(
            videoDetailsModel(
                "Distinction between metals, Semiconductors and insulators, intrinsic and extrinsic semiconductors",
                "DvYfs6rXKuE"
            )
        )
        video.add(
            videoDetailsModel(
                "Carrier concentration in thermal equilibrium in intrinsic semiconductor",
                "BQijtvYxgIM"
            )
        )
        video.add(
            videoDetailsModel(
                "Fermi level and energy band diagram in intrinsic semiconductor, Energy band diagram and Fermi level in extrinsic semiconductors",
                "kCN-7wA8HUE"
            )
        )
        video.add(
            videoDetailsModel(
                "Effect of temperature on extrinsic semiconductor",
                "aiTcSWZ0tJ4"
            )
        )
        video.add(
            videoDetailsModel(
                "Electrical conductivity of intrinsic semiconductor",
                "1Mv5n9n2tSI"
            )
        )
        video.add(
            videoDetailsModel(
                "Electrical conductivity extrinsic semiconductor",
                "hiY1nf8qFoE"
            )
        )
        video.add(videoDetailsModel("p-n junction", "hKGJoW_u6wo"))
        video.add(
            videoDetailsModel(
                "Hall Effect, allied parameters and it’s applications",
                "_40dpUzzfhA"
            )
        )

        displayList.addAll(video)

        var adapter = recyclerViewAdapter(displayList,clickListener = this)

        recyclerView.setAdapter(adapter)
    }

    override fun onItemClick(item: videoDetailsModel, position: Int) {
        //Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
        val intent = Intent(this, YouTubePlayerActivity::class.java)
        intent.putExtra("videoname", item.title)
        intent.putExtra("videokey", item.videokey)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem!=null) {
            val searchView = menuItem.actionView as androidx.appcompat.widget.SearchView

            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint = "Search"

            searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        video.forEach {
                            if (it.title.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }

                        recyclerView.adapter!!.notifyDataSetChanged()

                    }

                    else {
                        displayList.clear()
                        displayList.addAll(video)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
