package dark.composer.conventor.presentation.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dark.composer.conventor.R
import dark.composer.conventor.databinding.ItemConvertTypeGridBinding
import dark.composer.conventor.presentation.fragment.dto.ConvertTypeDTO

class ConvertTypeAdapter : RecyclerView.Adapter<ConvertTypeAdapter.ConvertTypeViewHolder>() {

    var type = mutableListOf<ConvertTypeDTO>()
    private var clickListener: ((position: Int) -> Unit)? = null

    fun setClickListener(f: (position: Int) -> Unit) {
        clickListener = f
    }

    inner class ConvertTypeViewHolder(private val binding: ItemConvertTypeGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(type: ConvertTypeDTO) {
            binding.convertTypeImg.setImageResource(R.drawable.word_to_pdf)
            binding.convertTypeTv.text = type.convertTypeTV.text
            itemView.setOnClickListener {
                clickListener?.invoke(type.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ConvertTypeViewHolder(
        ItemConvertTypeGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ConvertTypeViewHolder, position: Int) = holder.bind(type[position])

    override fun getItemCount() = type.size

}