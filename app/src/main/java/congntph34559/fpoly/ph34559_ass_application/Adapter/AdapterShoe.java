package congntph34559.fpoly.ph34559_ass_application.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import congntph34559.fpoly.ph34559_ass_application.DTO.ShoeDTO;
import congntph34559.fpoly.ph34559_ass_application.MainActivity;
import congntph34559.fpoly.ph34559_ass_application.NewCreateAndAddActivity;
import congntph34559.fpoly.ph34559_ass_application.R;

public class AdapterShoe extends RecyclerView.Adapter<AdapterShoe.ViewHolder> {

    Context context;
    List<ShoeDTO> list;

    public AdapterShoe(Context context, List<ShoeDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        String nameImage = list.get(position).getUrl();
//        @SuppressLint("DiscouragedApi") int res = ((Activity)context).getResources().getIdentifier(nameImage,"drawable", context.getPackageName());
//
//
//        holder.ivShoe.setImageResource(res);

        holder.tvNameShoe.setText(String.valueOf(list.get(position).getName()));
        holder.tvBrandShoe.setText(String.valueOf(list.get(position).getBrand()));
        holder.tvPriceShoe.setText(String.valueOf(list.get(position).getPrice()));
        holder.tvSizeShoe.setText(String.valueOf(list.get(position).getSize()));

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Delete: ", Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewCreateAndAddActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("titleEdit", "Update shoe");
                intent.putExtra("titleBtnEdit", "Update");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNameShoe, tvPriceShoe, tvBrandShoe, tvSizeShoe;
        Button btnEdit, btnDelete;

        ShapeableImageView ivShoe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameShoe = itemView.findViewById(R.id.tvName);
            tvBrandShoe = itemView.findViewById(R.id.tvBrand);
            tvPriceShoe = itemView.findViewById(R.id.tvPrice);
            tvSizeShoe = itemView.findViewById(R.id.tvSize);
            ivShoe = itemView.findViewById(R.id.ivShoe);

            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);

        }
    }

}
