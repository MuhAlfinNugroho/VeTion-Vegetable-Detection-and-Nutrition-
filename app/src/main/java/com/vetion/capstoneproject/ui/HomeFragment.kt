package com.vetion.capstoneproject.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.vetion.capstoneproject.R

class HomeFragment : Fragment() {

    private lateinit var progressBar1: ProgressBar
    private lateinit var progressBar2: ProgressBar
    private lateinit var progressBar3: ProgressBar
    private lateinit var progressBar4: ProgressBar
    private lateinit var progressBar5: ProgressBar

    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageNews: ImageView
    private lateinit var textNews: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize ProgressBar and ImageView references
        progressBar1 = rootView.findViewById(R.id.progress_bar)
        progressBar2 = rootView.findViewById(R.id.progress_bar2)
        progressBar3 = rootView.findViewById(R.id.progress_bar3)
        progressBar4 = rootView.findViewById(R.id.progress_bar4)
        progressBar5 = rootView.findViewById(R.id.progress_bar5)

        imageView1 = rootView.findViewById(R.id.imageView)
        imageView2 = rootView.findViewById(R.id.imageView2)
        imageView3 = rootView.findViewById(R.id.imageView3)
        imageView4 = rootView.findViewById(R.id.imageView4)
        imageNews = rootView.findViewById(R.id.imageNews)
        textNews = rootView.findViewById(R.id.textNews)

        // Set click listener for imageView2
        imageView2.setOnClickListener {
            val url = "https://cookpad.com/id/cari/brokoli"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        imageView3.setOnClickListener {
            val url = "https://cookpad.com/id/cari/masakan%20paprika"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        imageView4.setOnClickListener {
            val url = "https://cookpad.com/id/cari/sawi"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // Load data or perform actions to display images and hide progress bars when data is ready
        loadData()

        return rootView
    }

    private fun loadData() {
        // Simulate loading data with a delay
        // This is just a placeholder. Replace it with actual data loading logic.
        progressBar1.visibility = View.GONE
        imageView1.setImageResource(R.drawable.images) // Replace with actual image resource or data

        progressBar2.visibility = View.GONE
        imageView2.setImageResource(R.drawable.masakan_brokoli) // Replace with actual image resource or data

        progressBar3.visibility = View.GONE
        imageView3.setImageResource(R.drawable.masakan_paprika) // Replace with actual image resource or data

        progressBar4.visibility = View.GONE
        imageView4.setImageResource(R.drawable.masakan_sawi) // Replace with actual image resource or data

        progressBar5.visibility = View.GONE
        imageNews.setImageResource(R.drawable.bersih_sayuran) // Replace with actual image resource or data

        // Set text news about vegetables
        textNews.text = getString(R.string.sample_news_text)
    }
}
