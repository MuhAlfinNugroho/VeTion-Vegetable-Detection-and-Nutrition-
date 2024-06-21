import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vetion.capstoneproject.R
import com.vetion.capstoneproject.databinding.ItemTipsBinding
import com.vetion.capstoneproject.response.Data

class VetionAdapter : RecyclerView.Adapter<VetionAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val listTips = ArrayList<Data>()

    fun setList(tips: List<Data>) {
        listTips.clear()
        listTips.addAll(tips)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tip = listTips[position]
        holder.bind(tip)
    }

    override fun getItemCount(): Int {
        return listTips.size
    }


    inner class ViewHolder(private val binding: ItemTipsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: Data) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(tip)
            }
            // Gambar dari lokal (contoh: menggunakan resource drawable)
            binding.tvName.text = tip.name
            binding.imageTips.setImageResource(getTipImageResourceId(tip))
        }

        private fun getTipImageResourceId(tip: Data): Int {
            // Asumsi kita memiliki nama-nama sayur yang sesuai dengan nama gambar di drawable
            return when (tip.name.lowercase()) {
                "Brokoli Hijau" -> R.drawable.brokoli
                "Daun Pepaya" -> R.drawable.daun_pepaya
                "Daun Singkong" -> R.drawable.daun_singkong
                "Daun Kelor" -> R.drawable.daun_kelor
                "Kembang Kol" -> R.drawable.kembang_kol
                "Kubis Hijau" -> R.drawable.kubis_hijau
                "Paprika Merah" -> R.drawable.paprika_merah
                "Sawi sendok atau Pakcoy" -> R.drawable.sawi_sendok
                "Tomat Merah" -> R.drawable.tomat_merah
                "Wortel Nantes" -> R.drawable.wortel_nantes
                else -> R.drawable.default_vegetable_foreground
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Data)
    }
}
