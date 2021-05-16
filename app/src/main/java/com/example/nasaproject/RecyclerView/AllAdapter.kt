package com.example.nasaproject.RecyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.nasaproject.Model.Photo
import com.example.nasaproject.R
import com.example.nasaproject.View.MainActivity
import java.util.*

@Suppress("DEPRECATION")
class AllAdapter(
    private val list: ArrayList<Photo>,
    //private val listener: OnItemClickListener,
) :
    RecyclerView.Adapter<AllAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.filtreGorsel)
        val txt: TextView = itemView.findViewById(R.id.txtId)
        val txtDate: TextView = itemView.findViewById(R.id.earthDate)
        val txtRover: TextView = itemView.findViewById(R.id.roverName)
        val txtCameraName: TextView = itemView.findViewById(R.id.cameraName)
        val txtStatus: TextView = itemView.findViewById(R.id.status)
        val txtLaunchDate: TextView = itemView.findViewById(R.id.launchDate)//fırlatma
        val txtLandingDate: TextView = itemView.findViewById(R.id.landingDate)//iniş
        val backButton: Button = itemView.findViewById(R.id.backButton)
        val fullName: TextView = itemView.findViewById(R.id.txtIdText)
        val eDate: TextView = itemView.findViewById(R.id.txtEText)
        val rName: TextView = itemView.findViewById(R.id.txtroverNameText)
        val cName: TextView = itemView.findViewById(R.id.txtcameraNameText)
        val s: TextView = itemView.findViewById(R.id.txtStatusText)
        val luDate: TextView = itemView.findViewById(R.id.txtLaunchText)
        val laDate: TextView = itemView.findViewById(R.id.txtLandingText)

        fun bindData(data: Photo) {
            backButton.setOnClickListener{
             var i: Intent = Intent(itemView.context,MainActivity::class.java)
                itemView.context.startActivity(i)
            }
            txt.text = data.camera.fullName
            val url = data.imgSrc
            imageView.load(url)
             imageView.setOnClickListener {
                val popupMenu = PopupMenu(itemView.context, imageView)
                popupMenu.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.bilgiler -> {
                            txtDate.text = data.earthDate
                            txtRover.text = data.rover.name
                            txtCameraName.text = data.camera.name
                            txtStatus.text = data.rover.status
                            txtLaunchDate.text = data.rover.launchDate
                            txtLandingDate.text=data.rover.landingDate
                            fullName.isVisible=true
                            eDate.isVisible=true
                            rName.isVisible=true
                            cName.isVisible=true
                            s.isVisible=true
                            luDate.isVisible=true
                            laDate.isVisible=true
                            //var i = Intent(itemView.context, PopupMain::class.java)
                            //itemView.context.startActivity(i)
                            true
                        }
                        else -> false
                    }
                }
                popupMenu.inflate(R.menu.menu_main)
                popupMenu.show()
            }
        }

        /*init {
            imageView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {

                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
*/
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.design_layout,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
