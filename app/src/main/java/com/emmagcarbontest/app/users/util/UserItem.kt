package com.emmagcarbontest.app.users.util

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emmagcarbontest.app.R
import com.facebook.shimmer.ShimmerFrameLayout

class UserItem(v: View) : RecyclerView.ViewHolder(v) {
    var tvName: TextView = v.findViewById(R.id.tvName)
    var tvLName: TextView = v.findViewById(R.id.tvLastName)
    var tvEmail: TextView = v.findViewById(R.id.tvEmail)
    var imageView: ImageView = v.findViewById(R.id.profile_image)
    var shimmerView: ShimmerFrameLayout = v.findViewById(R.id.shimmerView)
    var parentLayout: LinearLayout = v.findViewById(R.id.parent_layout)
}