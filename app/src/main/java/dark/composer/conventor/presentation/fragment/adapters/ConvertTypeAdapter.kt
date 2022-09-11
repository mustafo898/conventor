package dark.composer.conventor.presentation.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dark.composer.conventor.R
import dark.composer.conventor.databinding.ItemConvertTypeGridBinding
import java.io.File

class ConvertTypeAdapter : RecyclerView.Adapter<ConvertTypeAdapter.ConvertTypeViewHolder>() {

    private var fileList = mutableListOf<File>()
    private var clickListener: ((position: Int) -> Unit)? = null
    fun setClickListener(f: (position: Int) -> Unit) {
        clickListener = f
    }

    fun setFile(file:List<File>){
        fileList.clear()
        fileList.addAll(file)
        notifyDataSetChanged()
    }

    inner class ConvertTypeViewHolder(private val binding: ItemConvertTypeGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(type: File) {
            binding.convertTypeImg.setImageResource(R.drawable.word_to_pdf)
            binding.convertTypeTv.text = type.name
            itemView.setOnClickListener {
//                clickListener?.invoke(type.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ConvertTypeViewHolder(
        ItemConvertTypeGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ConvertTypeViewHolder, position: Int) = holder.bind(fileList[position])

    override fun getItemCount() = fileList.size

}