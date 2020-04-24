package org.aplas.myretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MahasiswiAdapter extends RecyclerView.Adapter<MahasiswiAdapter.ViewHolder> {
    private List<Post> items;
    public MahasiswiAdapter(List<Post> items) {
        this.items = items;
    }

    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int ViewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.bocil,parent,false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post item = items.get(position);
        holder.txtidsiswa.setText(item.getId_siswa());
        holder.txtnama.setText(item.getNama());
        holder.txtalamat.setText(item.getAlamat());
        holder.txtjeniskelamin.setText(item.getJenis_kelamin());
        holder.txtnotelp.setText(item.getNo_telp());

    }

    public int getItemCount() { return (items != null) ? items.size() : 0; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtidsiswa, txtnama , txtalamat , txtjeniskelamin , txtnotelp;
        public ViewHolder(@NonNull View ItemView) {
            super(ItemView);
            txtidsiswa = (TextView) ItemView.findViewById(R.id.id_siswa);
            txtnama = (TextView) ItemView.findViewById(R.id.nama_siswa);
            txtalamat = (TextView) ItemView.findViewById(R.id.alamat_siswa);
            txtjeniskelamin = (TextView) ItemView.findViewById(R.id.jeniskelamin_siswa);
            txtnotelp = (TextView) ItemView.findViewById(R.id.notelp_siswa);
        }
    }
}
